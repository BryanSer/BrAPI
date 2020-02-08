package com.github.bryanser.brapi.particle

import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


enum class ParticleDataType(
        val clasz: Class<out ParticleData>
) {
    OFFSET(OffsetData::class.java),
    COLOR(ColorData::class.java),
    ITEM(ItemData::class.java),
    BLOCK(BlockData::class.java);

    fun offset(offsetX: Float, offsetY: Float, offsetZ: Float): ParticleData {
        if (this != OFFSET) {
            throw IllegalArgumentException("这个数据类型不支持偏移量")
        }
        return OffsetData(offsetX, offsetY, offsetZ)
    }

    fun color(color: Color, scale: Float = 0.01F): ParticleData {
        if (this != COLOR) {
            throw IllegalArgumentException("这个数据类型不支持颜色")
        }
        return ColorData(color, scale)
    }

    fun item(offsetX: Float, offsetY: Float, offsetZ: Float, item: ItemStack): ParticleData {
        if (this != ITEM) {
            throw IllegalArgumentException("这个数据类型不支持物品")
        }
        return ItemData(offsetX, offsetY, offsetZ, item.type, item.durability)
    }

    fun item(offsetX: Float, offsetY: Float, offsetZ: Float, material: Material, durability: Short = 0): ParticleData {
        if (this != ITEM) {
            throw IllegalArgumentException("这个数据类型不支持物品")
        }
        return ItemData(offsetX, offsetY, offsetZ, material, durability)
    }

    fun block(offsetX: Float, offsetY: Float, offsetZ: Float, material: Material, data: Byte = 0): ParticleData {
        if (this != BLOCK) {
            throw IllegalArgumentException("这个数据类型不支持方块")
        }
        return BlockData(offsetX, offsetY, offsetZ, material, data)
    }

    fun create(vararg args: Any): ParticleData {
        val par = Array(args.size) {
            args[it].javaClass
        }
        val con = clasz.getConstructor(*par)
        return con.newInstance(*args)
    }
}