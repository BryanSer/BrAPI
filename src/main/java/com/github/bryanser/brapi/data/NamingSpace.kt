package com.github.bryanser.brapi.data

import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.Plugin
import java.io.File

open class NamingSpace(
        val owner: Plugin,
        val name: String
) {
    val proxy = hashMapOf<String, ValueProxy<*>>()

    open val file: File by lazy {
        File(owner.dataFolder, "$name.yml")
    }

    lateinit var config: YamlConfiguration

    open fun reload() {
        config = YamlConfiguration.loadConfiguration(file)
        for ((_, vcp) in proxy) {
            vcp.load()
        }
    }

    open fun save() {
        for ((k, v) in proxy) {
            config.set(k, v.getValue())
        }
        config.save(file)
    }
}