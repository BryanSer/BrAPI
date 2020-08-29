package com.github.bryanser.brapi

import Br.API.EventListener
import Br.API.Main.*
import com.github.bryanser.brapi.kview.KViewHandler
import com.github.bryanser.brapi.test.TestManager
import com.github.bryanser.brapi.vview.VViewHandler
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.configuration.serialization.ConfigurationSerialization
import org.bukkit.event.HandlerList
import org.bukkit.plugin.java.JavaPlugin
import java.io.File


/**
 * 插件主类
 *
 */
class Main : JavaPlugin() {

    private fun makeKotlinLoader(){
        if (!KotlinVersion.CURRENT.isAtLeast(1, 3, 72)) {
            Bukkit.getLogger().warning("§6服务器内存在其他插件安装着旧版本kotlin运行库 正在覆盖")
            try {
                val loader = this.pluginLoader
                val field = loader::class.java.getDeclaredField("loaders")
                field.isAccessible = true
                val list = field.get(loader) as MutableList<ClassLoader>
                val selfloader = this::class.java.classLoader
                list.remove(selfloader)
                list.add(0, selfloader)
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            Class.forName("kotlin.jvm.internal.Reflection")
        }
    }

    override fun onLoad() {
        makeKotlinLoader()
    }

    override fun onEnable() {
        makeKotlinLoader()
        PLGUIN = this
        compOld()
        ScriptManager.checkClass()
        TestManager.init()
        KViewHandler.init()
        ScriptManager.loadScript()
        VViewHandler.init()
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
        if (args[0].equals("script", true) && sender.isOp) {
            if (args.size < 2) {
                sender.sendMessage("§6/$label script reload >> 重载所有脚本")
                return true
            }
            if (args[1].equals("reload", true)) {
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
        try {
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

            val econ = Br.API.Utils::class.java.getDeclaredField("econ")
            econ.isAccessible = true
            econ.set(null, Utils.economy)
        } catch (e: Throwable) {
        }
    }
}