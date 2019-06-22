package com.github.bryanser.brapi.particle

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLib
import com.comphenix.protocol.ProtocolLibrary
import org.bukkit.Location
import org.bukkit.entity.Player

class ParticleInfo(
        val type: ParticleType,
        var data: ParticleData,
        val count: Int = 1
) {

    fun playParticle(loc: Location, r: Double, longDistance: Boolean = false) {
        if (type.dataType.clasz != data.javaClass) {
            throw IllegalStateException("错误的粒子数据, $type 类型不应该使用${data.javaClass.simpleName}")
        }
        val pc = ProtocolManager.createPacket(PacketType.Play.Server.WORLD_PARTICLES)
        pc.integers.write(0, type.id_LEGACY)
        pc.booleans.write(0, longDistance)
        pc.float.write(0, loc.x.toFloat())
        pc.float.write(1, loc.y.toFloat())
        pc.float.write(2, loc.z.toFloat())
        data.write(pc, if (isVer14()) type else null)

        pc.integers.write(1, count)
        for (p in loc.world.getNearbyEntities(loc, r, r, r)) {
            ProtocolManager.sendServerPacket(p as? Player ?: continue, pc)
        }
    }

    companion object {
        val ProtocolManager = ProtocolLibrary.getProtocolManager()
    }
}