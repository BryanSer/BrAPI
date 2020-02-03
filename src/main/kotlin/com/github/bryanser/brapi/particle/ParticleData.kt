package com.github.bryanser.brapi.particle

import com.comphenix.protocol.events.PacketContainer
import com.comphenix.protocol.reflect.StructureModifier
import com.comphenix.protocol.utility.MinecraftReflection
import com.comphenix.protocol.wrappers.WrappedBlockData
import com.comphenix.protocol.wrappers.WrappedParticle
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.Particle
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Vector

interface ParticleData {
    @JvmDefault
    fun getData():Any? = null

    fun write(packet: PacketContainer, type: ParticleType? = null)
}

open class OffsetData(
        var offsetX: Float,
        var offsetY: Float,
        var offsetZ: Float
) : ParticleData {

    constructor(scatter: Vector) : this(scatter.x.toFloat(), scatter.y.toFloat(), scatter.z.toFloat())

    override fun write(packet: PacketContainer, type: ParticleType?) {
        packet.float.write(3, offsetX)
        packet.float.write(4, offsetY)
        packet.float.write(5, offsetZ)
        if (!isVer14())
            packet.integerArrays.write(0, IntArray(0))

    }

}

class ItemData(
        offsetX: Float,
        offsetY: Float,
        offsetZ: Float,
        var material: Material,
        var data: Short
) : OffsetData(offsetX, offsetY, offsetZ) {
    override fun write(packet: PacketContainer, type: ParticleType?) {
        super.write(packet, type)
        if (isVer14() && type != null) {
            val data = WrappedParticle.create(type.bukkitType, ItemStack(material, 1, data))
            val specificModifier = packet.getSpecificModifier(MinecraftReflection.getMinecraftClass("ParticleParam")) as StructureModifier<Any>
            specificModifier.write(0, data.handle)

//            val minecraftClass = MinecraftReflection.getMinecraftClass("ParticleParamItem")
//            val constructor = minecraftClass.constructors[0]
//            val target = constructor.newInstance(null, null)
//            val sm = StructureModifier<Any>(minecraftClass).withTarget(target)
//            val item = sm.withType<ItemStack>(MinecraftReflection.getItemStackClass(), BukkitConverters.getItemStackConverter())
//            item.write(0, ItemStack(material,1,data.toShort()))
//            val par = sm.withType<EnumWrappers.Particle>(EnumWrappers.getParticleClass(), EnumWrappers.getParticleConverter())
//            par.write(0, EnumWrappers.getParticleConverter().getSpecific(type))
//
        } else {
            packet.integerArrays.write(0, intArrayOf(material.id, data.toInt()))
        }
    }
}

class BlockData(
        offsetX: Float,
        offsetY: Float,
        offsetZ: Float,
        var material: Material,
        var data: Byte
) : OffsetData(offsetX, offsetY, offsetZ) {
    override fun write(packet: PacketContainer, type: ParticleType?) {
        super.write(packet, type)
        val data = material.id + (data.toInt() shl 12)
        if (isVer14() && type != null) {
            val data = WrappedParticle.create(type.bukkitType, WrappedBlockData.createData(material))
            val specificModifier = packet.getSpecificModifier(MinecraftReflection.getMinecraftClass("ParticleParam")) as StructureModifier<Any>
            specificModifier.write(0, data.handle)
        } else {
            packet.integerArrays.write(0, intArrayOf(data))
        }
    }
}


class ColorData(
        r: Float,
        g: Float,
        b: Float,
        val scale: Float = 0.01F
) : OffsetData(r, g, b) {
    constructor(color: Color, scale: Float = 0.01F) :
            this(color.red.toFloat(), color.green.toFloat(), color.blue.toFloat(), scale)

    init {
        if (r < 0 || r > 255) throw IllegalArgumentException("不合法的颜色参数")
        if (g < 0 || g > 255) throw IllegalArgumentException("不合法的颜色参数")
        if (b < 0 || b > 255) throw IllegalArgumentException("不合法的颜色参数")
        if (scale < 0.01F || scale > 4) throw IllegalArgumentException("不合法的颜色参数")
    }


    override fun write(packet: PacketContainer, type: ParticleType?) {
        super.write(packet, type)
        if (isVer14()) {
            val redstone = MinecraftReflection.getMinecraftClass("ParticleParamRedstone")
            val con = redstone.getConstructor(java.lang.Float.TYPE, java.lang.Float.TYPE, java.lang.Float.TYPE, java.lang.Float.TYPE)
            val rd = con.newInstance(offsetX, offsetY, offsetZ, scale)
            val wrappedParticle = WrappedParticle.fromHandle(rd)
            val specificModifier = packet.getSpecificModifier(MinecraftReflection.getMinecraftClass("ParticleParam")) as StructureModifier<Any>
            specificModifier.write(0, wrappedParticle.handle)
        }
    }
}