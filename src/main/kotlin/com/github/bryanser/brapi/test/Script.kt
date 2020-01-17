package com.github.bryanser.brapi.test

import com.github.bryanser.brapi.Main
import com.github.bryanser.brapi.ScriptManager
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.file.YamlConfiguration
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.security.MessageDigest
import javax.script.ScriptContext

val instance = MessageDigest.getInstance("SHA-256")
internal fun String.hashSHA256(): String {
    val ba = instance.digest(this.toByteArray())
    return byteArrayToHexString(ba)
}

private val hexDigIts = "0123456789ABCDEF".toCharArray()
internal fun byteArrayToHexString(b: ByteArray): String {
    val resultSb = StringBuffer()
    for (i in b.indices) {
        resultSb.append(byteToHexString(b[i]))
    }
    return resultSb.toString()
}

internal fun byteToHexString(b: Byte): String {
    var n = b.toInt()
    if (n < 0) {
        n += 256
    }
    val d1 = n / 16
    val d2 = n % 16
    return hexDigIts[d1] + "" + hexDigIts[d2]
}

class Script(config: ConfigurationSection) {
    val name = config.getString("name")
    val version = config.getString("version")
    val script = config.getString("script")

    val engine = ScriptManager.createScriptEngine(Main.getPlugin())

    fun hash(): String {
        return toString().hashSHA256()
    }

    override fun toString(): String {
        return "Script(name='$name', version='$version', script='$script')"
    }


    constructor(f: File) : this(YamlConfiguration.loadConfiguration(f.let {
        val fin = FileInputStream(it)
        InputStreamReader(fin, "UTF-8")
    }))

    init {
        val sign = config.getString("sign") ?: throw SecurityException("发现未经开发者签名的脚本${name} 拒绝加载")
        val cap = RSACheck.decryptByPublic(sign)
        if (cap != this.hash()) {
            throw SecurityException("${name}开发者签名检验失败 拒绝加载")
        }
        val binding = engine.createBindings()
        binding["getManager"] = java.util.function.Supplier<ScriptManager> {
            ScriptManager
        }
        val cs = config.getConfigurationSection("config")
        if (cs != null) {
            for (key in cs.getKeys(false)) {
                binding[key] = cs.get(key)
            }
        }
        engine.setBindings(binding, ScriptContext.ENGINE_SCOPE)
        engine.eval(script)
    }

}