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



/**
 * 插件主类
 *
 */
class Main : JavaPlugin() {
    override fun onEnable() {
        PLGUIN = this
        compOld()
    }

    override fun onDisable() {
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
        if(args.isEmpty()){
            if (EventListener.Reg) {
                RegisterMetrics()
                EventListener.Reg = false
            }
            var plugins = "§a"
            for (s in Plugins) {
                plugins = "$plugins$s|"
            }
            sender.sendMessage(arrayOf(ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"), ChatColor.translateAlternateColorCodes('&', "&aBrAPI已安装 版本: " + description.version), "§b当前依赖的插件数:$PluginsAmount", plugins, ChatColor.translateAlternateColorCodes('&', "&aBrAPI has been installed, Version: " + description.version), ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------")))
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

        val econ = Br.API.Utils::class.java.getDeclaredField("econ")
        econ.isAccessible = true
        econ.set(null, Utils.economy)
    }
}