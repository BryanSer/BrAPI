package com.github.bryanser.brapi.test

import com.github.bryanser.brapi.Main
import com.github.bryanser.brapi.Utils
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File

object TestManager {
    var enable:Boolean = false
    lateinit var globalScript:String

    fun init(){
        val f = File(Main.getPlugin().dataFolder,"testScript.yml")
        if(!f.exists()){
            Utils.saveResource(Main.getPlugin(),"testScript.yml")
        }
        val config = YamlConfiguration.loadConfiguration(f)
        enable = config.getBoolean("EnableTest",false)
        if(!enable){
            return
        }
        globalScript = config.getString("Global")
    }
}