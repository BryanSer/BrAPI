package com.github.bryanser.brapi.particle

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLib
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.wrappers.EnumWrappers
import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.entity.Player

open class ParticleInfo(
        val type: ParticleType,
        var data: ParticleData,
        var speed: Float,
        val count: Int = 1
) {

    open fun playParticle(loc: Location, r: Double, longDistance: Boolean = false) {
        if (type.dataType.clasz != data.javaClass) {
            throw IllegalStateException("错误的粒子数据, $type 类型不应该使用${data.javaClass.simpleName}")
        }
        val pc = ProtocolManager.createPacket(PacketType.Play.Server.WORLD_PARTICLES)
        if (isVer14()) {
            TODO()
            //pc.integers.write(0, type.id)
        } else {
            pc.particles.write(0, EnumWrappers.Particle.getById(type.id_LEGACY))
            //pc.integers.write(0, type.id_LEGACY)
        }
        pc.booleans.write(0, longDistance)
        pc.float.write(0, loc.x.toFloat())
        pc.float.write(1, loc.y.toFloat())
        pc.float.write(2, loc.z.toFloat())
        pc.float.write(6, speed)
        data.write(pc, if (isVer14()) type else null)

        pc.integers.write(0, count)
        for (p in loc.world.getNearbyEntities(loc, r, r, r)) {
            ProtocolManager.sendServerPacket(p as? Player ?: continue, pc)
        }
    }

    companion object {
        val ProtocolManager = ProtocolLibrary.getProtocolManager()
    }
}

class ColorDust(
        r: Float,
        g: Float,
        b: Float
) : ParticleInfo(ParticleType.COLORFUL_DUST, ColorData(r, g, b), 1F, 0) {
    constructor(color: Color) :
            this(color.red.toFloat(), color.green.toFloat(), color.blue.toFloat())
}