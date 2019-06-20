package com.github.bryanser.brapi

import org.bukkit.Bukkit
import java.io.File
import java.net.URL
import java.util.logging.Level
import java.net.URLClassLoader



object ScriptManager {

    fun checkClass() {
        try {
            Class.forName("jdk.nashorn.api.scripting.NashornScriptEngine")
            return
        } catch (e: ClassNotFoundException) {
            val folder = Main.getPlugin().dataFolder
            val f = File(folder,"nashorn.jar")
            if(f.exists()){
                val method = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java)
                method.isAccessible = true
                val classLoader = this.javaClass.classLoader as URLClassLoader
                val url = f.toURI().toURL()
                method.invoke(classLoader, url);
                return
            }
            val log = Bukkit.getLogger()
            log.log(Level.WARNING,"=================================================================")
            log.log(Level.WARNING,"    未找到Nashorn脚本引擎 若无需求请忽略本提示 ")
            log.log(Level.WARNING,"    若需要脚本引擎支持 请下载")
            log.log(Level.WARNING,"https://github.com/BryanSer/BrAPI/raw/ver-kotlin/lib/nashorn.jar")
            log.log(Level.WARNING,"并将jar放入 /plugins/BrAPI 目录下")
            log.log(Level.WARNING,"=================================================================")
        }
    }
}