package com.github.bryanser.brapi.util

import org.bukkit.Color
import org.bukkit.OfflinePlayer
import org.bukkit.configuration.Configuration
import org.bukkit.configuration.ConfigurationSection
import org.bukkit.configuration.serialization.ConfigurationSerializable
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector

class MapConfigurationSection(
        private var data: MutableMap<String, Any?>,
        val father: ConfigurationSection? = null
) : ConfigurationSection {
    init {
        val copy = LinkedHashMap<String, Any?>()
        for ((k, v) in data) {
            if (v is MutableMap<*, *>) {
                copy[k] = MapConfigurationSection(v as MutableMap<String, Any?>, this)
            } else {
                copy[k] = v
            }
        }
        data = copy
    }


    override fun isSet(path: String?): Boolean = data[path] is Set<*>

    override fun isVector(path: String?): Boolean = data[path] is Vector

    override fun getFloatList(path: String?): MutableList<Float>? = data[path] as? MutableList<Float>

    override fun getVector(path: String?): Vector? = data[path] as? Vector

    override fun getVector(path: String?, def: Vector?): Vector? = data[path] as? Vector ?: def

    override fun getLong(path: String?): Long = data[path] as? Long ?: 0L

    override fun getLong(path: String?, def: Long): Long = data[path] as? Long ?: def

    override fun getItemStack(path: String?): ItemStack? = data[path] as? ItemStack

    override fun getItemStack(path: String?, def: ItemStack?): ItemStack? = data[path] as? ItemStack
            ?: def

    override fun isList(path: String?): Boolean = data[path] is List<*>

    override fun getDefaultSection(): ConfigurationSection {
        return this
    }

    override fun isInt(path: String?): Boolean = data[path] is Int

    override fun getBoolean(path: String?): Boolean = data[path] as? Boolean ?: false

    override fun getBoolean(path: String?, def: Boolean): Boolean = data[path] as? Boolean ?: def

    override fun getColor(path: String?): Color? = data[path] as? Color

    override fun getColor(path: String?, def: Color): Color = data[path] as? Color ?: def

    override fun isItemStack(path: String?): Boolean = data[path] is ItemStack

    override fun createSection(path: String?): ConfigurationSection {
        val map = LinkedHashMap<String, Any?>()
        return MapConfigurationSection(map)
    }

    override fun createSection(path: String?, map: MutableMap<*, *>?): ConfigurationSection {
        return MapConfigurationSection(map as MutableMap<String, Any?>)
    }

    override fun isDouble(path: String?): Boolean = data[path] is Double

    override fun getBooleanList(path: String?): MutableList<Boolean>? = data[path] as? MutableList<Boolean>

    override fun isColor(path: String?): Boolean = data[path] is Color

    override fun getList(path: String?): MutableList<*>? = data[path] as? MutableList<*>

    override fun getList(path: String?, def: MutableList<*>): MutableList<*> = data[path] as? MutableList<*>
            ?: def

    override fun getLongList(path: String?): MutableList<Long>? = data[path] as? MutableList<Long>

    override fun isConfigurationSection(path: String?): Boolean = data[path] is ConfigurationSection

    override fun getRoot(): Configuration? = null

    override fun getOfflinePlayer(path: String?): OfflinePlayer? = data[path] as? OfflinePlayer

    override fun getOfflinePlayer(path: String?, def: OfflinePlayer): OfflinePlayer = data[path] as? OfflinePlayer
            ?: def

    override fun getCharacterList(path: String?): MutableList<Char>? = data[path] as? MutableList<Char>

    override fun contains(path: String): Boolean {
        if (path.contains('.')) {
            var str = path.split("\\.".toRegex(), 2)
            val pt = data[str[0]] as? ConfigurationSection ?: return false
            return pt.contains(str[1])
        } else {
            return data.containsKey(path)
        }
    }

    override fun contains(path: String, ignoreDefault: Boolean): Boolean = contains(path)

    override fun isString(path: String?): Boolean = data[path] is String

    override fun getDoubleList(path: String?): MutableList<Double>? = data[path] as? MutableList<Double>

    override fun getName(): String {
        return "MapConfigurationSection"
    }

    override fun getIntegerList(path: String?): MutableList<Int>? = data[path] as? MutableList<Int>

    override fun getConfigurationSection(path: String?): ConfigurationSection? = data[path] as? ConfigurationSection

    override fun get(path: String?): Any? = data[path] as? Any

    override fun get(path: String?, def: Any): Any = data[path] as? Any ?: def

    override fun getCurrentPath(): String {
        return ""
    }

    override fun getDouble(path: String?): Double = data[path] as? Double ?: 0.0

    override fun getDouble(path: String?, def: Double): Double = data[path] as? Double ?: def

    override fun getByteList(path: String?): MutableList<Byte>? = data[path] as? MutableList<Byte>

    override fun isOfflinePlayer(path: String?): Boolean = data[path] is OfflinePlayer

    override fun getParent(): ConfigurationSection? = father

    override fun getStringList(path: String?): MutableList<String>? = data[path] as? MutableList<String>

    override fun getKeys(deep: Boolean): MutableSet<String> {
        return data.keys
    }

    override fun getInt(path: String?): Int = data[path] as? Int ?: 0

    override fun getInt(path: String?, def: Int): Int = data[path] as? Int ?: def

    override fun getMapList(path: String?): MutableList<MutableMap<*, *>>? = data[path] as? MutableList<MutableMap<*, *>>

    override fun set(path: String, value: Any?) {
        if(path.contains('.')){
            val str = path.split("\\.".toRegex(),2)
            val cs = this.getConfigurationSection(str[0]) ?: throw IllegalArgumentException(path)
            cs.set(str[1],value)
        }else{
            data[path] = value
        }
    }

    override fun isBoolean(path: String?): Boolean = data[path] is Boolean

    override fun getValues(deep: Boolean): MutableMap<String, Any?> = data

    override fun <T : ConfigurationSerializable?> getSerializable(path: String?, clazz: Class<T>): T? {
        val get = get(path) as? ConfigurationSerializable ?: return null
        if(clazz.isInstance(get)){
            return clazz.cast(get)
        }
        return null
    }

    override fun <T : ConfigurationSerializable?> getSerializable(path: String?, clazz: Class<T>, def: T): T {
        val get = get(path) as? ConfigurationSerializable ?: return def
        if(clazz.isInstance(get)){
            return clazz.cast(get)
        }
        return def
    }

    override fun isLong(path: String?): Boolean = data[path] is Long

    override fun addDefault(path: String, value: Any?) {
        if(!contains(path)){
            set(path,value)
        }
    }

    override fun getString(path: String?): String? = data[path] as? String

    override fun getString(path: String?, def: String): String = data[path] as? String ?: def

    override fun getShortList(path: String?): MutableList<Short>? = data[path] as? MutableList<Short>
}