package com.github.bryanser.brapi.util

import org.bukkit.configuration.file.YamlConfiguration
import java.io.*


fun loadConfigurationCharset(f: File, charset: String = "UTF-8"): YamlConfiguration {
    FileInputStream(f).use {
        try {
            YamlConfiguration::class.java.getMethod("loadConfiguration", InputStream::class.java)
        } catch (e: Throwable) {
            InputStreamReader(it, charset).use {
                return YamlConfiguration.loadConfiguration(it)
            }
        }
        val config = YamlConfiguration();
        val builder = StringBuilder()
        InputStreamReader(it, charset).use {
            val input = BufferedReader(it)
            var line: String?
            while (input.readLine().also { line = it } != null) {
                builder.append(line)
                builder.append('\n')
            }
        }
        config.loadFromString(builder.toString())
        return config
    }
}

fun loadConfiguration(f: File, charset: String = "UTF-8"): YamlConfiguration {
    try {
        val config = YamlConfiguration();
        config.load(f)
        return config
    } catch (e: Throwable) {
        return loadConfigurationCharset(f, charset)
    }
}