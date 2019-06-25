package com.github.bryanser.brapi.test

import com.github.bryanser.brapi.Main
import com.github.bryanser.brapi.ScriptManager
import jdk.nashorn.api.scripting.NashornScriptEngine
import org.bukkit.command.CommandSender
import org.bukkit.configuration.ConfigurationSection
import javax.script.ScriptContext

class Test(config: ConfigurationSection) {
    val name: String
    val args: Int
    val function: String
    val script: NashornScriptEngine

    init {
        name = config.name
        args = config.getInt("Args")
        function = config.getString("Function")
        script = ScriptManager.createScriptEngine(Main.getPlugin())
        script.eval(TestManager.globalScript + "\n" + config.getString("Script"))
    }

    fun test(sender: CommandSender, vararg args: String): String {
        if (args.size != this.args) {
            return "参数长度不正确 需求参数长度:${this.args}"
        }
        script.invokeFunction(function, sender, *args)
        return ""
    }
}