package com.github.bryanser.brapi

import com.github.bryanser.brapi.test.Script
import jdk.nashorn.api.scripting.NashornScriptEngine
import jdk.nashorn.api.scripting.NashornScriptEngineFactory
import jdk.nashorn.api.scripting.ScriptObjectMirror
import org.bukkit.Bukkit
import org.bukkit.event.Event
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin
import java.io.File
import java.net.URL
import java.net.URLClassLoader
import java.util.logging.Level

interface ScriptListenerRegister {
    fun getPlugin(): Main

    fun registerListener(listener: ScriptObjectMirror, event: String): Listener?
    fun registerListener(listener: ScriptObjectMirror, event: String, priority: EventPriority): Listener?
    fun registerListener(listener: ScriptObjectMirror, event: String, ignoreCancel: Boolean): Listener?
    fun registerListener(listener: ScriptObjectMirror, event: String, ignoreCancel: Boolean, priority: EventPriority): Listener?
}

object ScriptManager : ScriptListenerRegister {
    var hasNashorn: Boolean = false

    class ScriptListener(
            val script: ScriptObjectMirror
    ) : Listener {
        fun call(evt: Event) {
            script.call(script, evt)
        }
    }

    override fun getPlugin(): Main = Main.getPlugin()

    override fun registerListener(listener: ScriptObjectMirror, event: String): Listener? {
        if (listener.isFunction) {
            val evt = Class.forName(event) ?: return null
            val targetevt = evt.asSubclass(Event::class.java) ?: return null
            val ler = ScriptListener(listener)
            Bukkit.getPluginManager().registerEvent(targetevt, ler, EventPriority.NORMAL, { listener, event ->
                ler.call(event)
            }, Main.getPlugin())
            return ler
        }
        return null
    }

    override fun registerListener(listener: ScriptObjectMirror, event: String, priority: EventPriority): Listener? {
        if (listener.isFunction) {
            val evt = Class.forName(event) ?: return null
            val targetevt = evt.asSubclass(Event::class.java) ?: return null
            val ler = ScriptListener(listener)
            Bukkit.getPluginManager().registerEvent(targetevt, ler, priority, { listener, event ->
                ler.call(event)
            }, Main.getPlugin())
            return ler
        }
        return null
    }

    override fun registerListener(listener: ScriptObjectMirror, event: String, ignoreCancel: Boolean): Listener? {
        if (listener.isFunction) {
            val evt = Class.forName(event) ?: return null
            val targetevt = evt.asSubclass(Event::class.java) ?: return null
            val ler = ScriptListener(listener)
            Bukkit.getPluginManager().registerEvent(targetevt, ler, EventPriority.NORMAL, { listener, event ->
                ler.call(event)
            }, Main.getPlugin(), ignoreCancel)
            return ler
        }
        return null
    }

    override fun registerListener(listener: ScriptObjectMirror, event: String, ignoreCancel: Boolean, priority: EventPriority): Listener? {
        if (listener.isFunction) {
            val evt = Class.forName(event) ?: return null
            val targetevt = evt.asSubclass(Event::class.java) ?: return null
            val ler = ScriptListener(listener)
            Bukkit.getPluginManager().registerEvent(targetevt, ler, priority, { listener, event ->
                ler.call(event)
            }, Main.getPlugin(), ignoreCancel)
            return ler
        }
        return null
    }

    fun checkClass() {
        try {
            Class.forName("jdk.nashorn.api.scripting.NashornScriptEngine")
            hasNashorn = true
            return
        } catch (e: ClassNotFoundException) {
            val folder = Main.getPlugin().dataFolder
            val f = File(folder, "nashorn.jar")
            if (f.exists()) {
                val method = URLClassLoader::class.java.getDeclaredMethod("addURL", URL::class.java)
                method.isAccessible = true
                val classLoader = this.javaClass.classLoader as URLClassLoader
                val url = f.toURI().toURL()
                method.invoke(classLoader, url);
                hasNashorn = true
                return
            }
            val log = Bukkit.getLogger()
            log.log(Level.WARNING, "=================================================================")
            log.log(Level.WARNING, "    未找到Nashorn脚本引擎 若无需求请忽略本提示 ")
            log.log(Level.WARNING, "    若需要脚本引擎支持 请下载")
            log.log(Level.WARNING, "https://github.com/BryanSer/BrAPI/raw/ver-kotlin/lib/nashorn.jar")
            log.log(Level.WARNING, "并将jar放入 /plugins/BrAPI 目录下")
            log.log(Level.WARNING, "=================================================================")
        }
    }

    fun createScriptEngine(plugin: Plugin): NashornScriptEngine {
        val factory = NashornScriptEngineFactory()
        val eng = factory.getScriptEngine(plugin.javaClass.classLoader) as NashornScriptEngine
        return eng
    }

    val scripts = mutableListOf<Script>()

    fun loadScript() {
        for (sc in scripts) {
            sc.disable()
        }
        scripts.clear()
        val folder = File(Main.getPlugin().dataFolder, "script")
        if (!folder.exists()) {
            folder.mkdirs()
        }
        for (f in folder.listFiles()) {
            try {
                val script = Script(f)
                scripts += script
            } catch (e: Throwable) {
                e.printStackTrace()
            }
        }
    }
}

