package com.github.bryanser.brapi.util
import org.bukkit.configuration.serialization.ConfigurationSerializable
import java.lang.reflect.Modifier
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.jvm.isAccessible
import kotlin.reflect.jvm.javaField

interface  KConfigurationSerializable : ConfigurationSerializable {

    override fun serialize(): MutableMap<String, Any?> {
        val map = mutableMapOf<String, Any?>()
        for (member in this.getAllProperty()) {
            map[member.name] = member.get(this)
        }
        return map
    }

    fun Map<String, Any?>.deserialize() {
        for (member in getAllProperty()) {
            member.set(this@KConfigurationSerializable, this[member.name])
        }
    }

    companion object {
        private fun KConfigurationSerializable.getAllProperty(): List<KMutableProperty1<KConfigurationSerializable, Any?>> {
            val list = mutableListOf<KMutableProperty1<KConfigurationSerializable, Any?>>()
            for (callable in this::class.members) {
                val member = callable as? KMutableProperty1<KConfigurationSerializable, Any?> ?: continue
                val f = member.javaField
                if (f != null && Modifier.isTransient(f.modifiers)) {
                    continue
                }
                member.isAccessible = true
                list.add(member)
            }
            return list
        }
    }
}