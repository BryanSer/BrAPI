package com.github.bryanser.brapi

import Br.API.EventListener
import org.bukkit.configuration.serialization.ConfigurationSerialization
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.event.HandlerList
import Br.API.Main.PluginsAmount
import Br.API.Main.Plugins
import Br.API.Main.RegisterMetrics
import com.github.bryanser.brapi.kview.KViewHandler
import com.github.bryanser.brapi.test.TestManager
import org.bukkit.ChatColor


/**
 * 插件主类
 *
 */
class Main : JavaPlugin() {

    override fun onEnable() {
        PLGUIN = this
        compOld()
        ScriptManager.checkClass()
        TestManager.init()
        KViewHandler.init()
        ScriptManager.loadScript()
    }

    override fun onDisable() {
        KViewHandler.closeAll()
        compOldDisable()
        HandlerList.unregisterAll(this)
        Bukkit.getMessenger().unregisterIncomingPluginChannel(this)
    }

    companion object {
        lateinit var PLGUIN: Main
        fun getPlugin(): Main = PLGUIN
        operator fun not(): Main = PLGUIN
    }

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size == 0) {
            if (EventListener.Reg) {
                RegisterMetrics()
                EventListener.Reg = false
            }
            var plugins = "§a"
            for (s in Plugins) {
                plugins = "$plugins$s|"
            }
            sender.sendMessage(arrayOf(ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"),
                    ChatColor.translateAlternateColorCodes('&', "&aBrAPI已安装 版本: " + description.version),
                    "§b当前依赖的插件数:$PluginsAmount",
                    plugins,
                    ChatColor.translateAlternateColorCodes('&', "&aBrAPI has been installed, Version: " + description.version),
                    ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------")))
            return true
        }
        if(args[0].equals("script",true) && sender.isOp){
            if(args.size < 2){
                sender.sendMessage("§6/$label script reload >> 重载所有脚本")
                return true
            }
            if(args[1].equals("reload", true)){
                ScriptManager.loadScript()
                sender.sendMessage("§6重载成功")
                return true
            }
            sender.sendMessage("§6/$label script reload >> 重载所有脚本")
            return true
        }
        if (args[0].equals("test", true) && args.size > 1 && sender.isOp) {
            TestManager.init()
            if (!TestManager.enable) {
                return true
            }
            val test = TestManager.tests[args[1]]
            if (test == null) {
                sender.sendMessage("§c找不到名为${args[1]}的测试脚本")
                return true
            }
            val sargs = if (args.size <= 2) arrayOf() else args.copyOfRange(2, args.size)
            val r = test.test(sender, *sargs)
            if (r.isEmpty()) {
                sender.sendMessage("§6测试脚本执行成功")
            } else {
                sender.sendMessage("§c测试脚本执行失败: $r")
            }
            return true
        }
        return true
    }

    //////////////////////////////////////////////////////////////////////////////以下为遗留代码
    private fun compOldDisable() {
        Br.API.Data.DataManager.SaveAll()
        Br.API.Item.ItemManager.saveData()
    }

    private fun compOld() {
        Br.API.PluginData.plugin = this
        val folder = dataFolder
        if (!folder.exists()) {
            folder.mkdirs()
        }
        val data = File(folder, "Datas")
        if (!data.exists()) {
            data.mkdirs()
        }
        Br.API.Data.DataManager.LoadAll(true)
        ConfigurationSerialization.registerClass(Br.API.NBT.AttributeModifiers::class.java)
        ConfigurationSerialization.registerClass(Br.API.Data.Zone::class.java)
        Br.API.Item.ItemManager.loadConfig()
        Bukkit.getPluginManager().registerEvents(Br.API.EventListener(), this)
        Bukkit.getMessenger().registerIncomingPluginChannel(this, Br.API.Commands.CommandChannel.CHANNEL_IN, Br.API.Commands.CommandChannel())
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, Br.API.Commands.CommandChannel.CHANNEL_OUT)

        try {
            val econ = Br.API.Utils::class.java.getDeclaredField("econ")
            econ.isAccessible = true
            econ.set(null, Utils.economy)
        } catch (e: Throwable) {
        }
    }
}