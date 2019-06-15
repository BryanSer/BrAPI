package com.github.bryanser.brapi

import org.bukkit.configuration.serialization.ConfigurationSerialization
import org.bukkit.plugin.java.JavaPlugin
import java.io.File
import org.bukkit.Bukkit
import org.bukkit.event.HandlerList

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
        Bukkit.getMessenger().registerIncomingPluginChannel(this, "BrAPICmdCnlIn", Br.API.Commands.CommandChannel())
        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BrAPICmdCnlOut")

        val econ = Br.API.Utils::class.java.getDeclaredField("econ")
        econ.isAccessible = true
        econ.set(null, Utils.economy)
    }
}