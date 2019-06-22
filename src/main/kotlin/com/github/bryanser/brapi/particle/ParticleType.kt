package com.github.bryanser.brapi.particle

import org.bukkit.Particle

enum class ParticleType(
        val id_LEGACY: Int,
        val id: Int,
        val particleName: String,
        bukkitName:String,
        val dataType: ParticleDataType = ParticleDataType.OFFSET
) {
    EXPLODE(0, 19, "minecraft:explosion", "EXPLOSION_NORMAL"),
    EXPLODE_LARGE(1, -1, "", "EXPLOSION_LARGE"),
    EXPLOSION_HUGE(2, -1, "", "EXPLOSION_HUGE"),
    FIREWORKS_SPARK(3, 21, "minecraft:firework", "FIREWORKS_SPARK"),
    BUBBLE(4, 4, "minecraft:bubble", "WATER_BUBBLE"),
    SPLASH(5, 43, "minecraft:splash", "WATER_SPLASH"),
    WAKE(6, -1, "", "WATER_WAKE"),
    SUSPENDED(7, -1, "", "SUSPENDED"),
    SUSPENDED_DEPTH(8, -1, "", "SUSPENDED_DEPTH"),
    CRIT(9, 6, "minecraft:crit", "CRIT"),
    CRIT_MAGIC(10, 6, "minecraft:crit", "CRIT_MAGIC"),
    SMOKE(11, 37, "minecraft:smoke", "SMOKE_NORMAL"),
    SMOKE_LARGE(12, 30, "minecraft:large_smoke", "SMOKE_LARGE"),
    SPELL(13, -1, "", "SPELL"),
    SPELL_INSTANT(14, -1, "", "SPELL_INSTANT"),
    SPELL_MOB(15, -1, "", "SPELL_MOB"),
    SPELL_MOB_AMBIENT(16, -1, "", "SPELL_MOB_AMBIENT"),
    WITCH_MAGIC(17, 44, "minecraft:witch", "SPELL_WITCH"),
    DRIP_WATER(18, 10, "minecraft:dripping_water", "DRIP_WATER"),
    DRIP_LAVA(19, 9, "minecraft:dripping_lava", "DRIP_LAVA"),
    VILLAGER_ANGRY(20, 1, "minecraft:angry_villager", "VILLAGER_ANGRY"),
    VILLAGER_HAPPY(21, 24, "minecraft:happy_villager", "VILLAGER_HAPPY"),
    TOWN_AURA(22, -1, "", "TOWN_AURA"),
    NOTE(23, 33, "minecraft:note", "NOTE", ParticleDataType.COLOR),
    PORTAL(24, 35, "minecraft:portal", "PORTAL"),
    ENCHANTMENT_TABLE(25, 15, "minecraft:enchant", "ENCHANTMENT_TABLE"),
    FLAME(26, 23, "minecraft:flame", "FLAME"),
    LAVA(27, 31, "minecraft:lava", "LAVA"),
    CLOUD(29, 5, "minecraft:cloud", "CLOUD"),
    RED_DUST(30, -1, "", "REDSTONE",ParticleDataType.COLOR),
    COLORFUL_DUST(30, -1, "", "REDSTONE",ParticleDataType.COLOR),
    SNOWBALL_POOF(31, -1, "", "SNOWBALL"),
    SNOW_SHOVEL(32, -1, "", "SNOW_SHOVEL"),
    SLIME(33, -1, "", "SLIME"),
    HEART(34, 25, "minecraft:heart", "HEART"),
    BARRIER(35, 2, "minecraft:barrier", "BARRIER"),
    ICON_CRACK(36, 27, "minecraft:item", "ITEM_CRACK", ParticleDataType.ITEM),
    ITEM_CRACK(36, 27, "minecraft:item", "ITEM_CRACK", ParticleDataType.ITEM),
    BLOCK_CRACK(37, 3, "minecraft:block", "BLOCK_CRACK", ParticleDataType.BLOCK),
    BLOCK_DUST(38, 20, "minecraft:falling_dust", "BLOCK_DUST", ParticleDataType.BLOCK),
    MOB_APPEARANCE(41, -1, "", "MOB_APPEARANCE"),
    DRAGON_BREATH(42, 8, "minecraft:dragon_breath", "DRAGON_BREATH"),
    END_ROD(43,16,"minecraft:end_rod","END_ROD"),
    DAMAGE_INDICATOR(44,7,"minecraft:damage_indicator","DAMAGE_INDICATOR"),
    SWEEP_ATTACK(45,-1,"","SWEEP_ATTACK"),
    FALLING_DUST(46, 20, "minecraft:falling_dust", "FALLING_DUST", ParticleDataType.BLOCK),
    TOTEM(47,-1,"","TOTEM"),
    SPIT(48,38,"minecraft:spit","SPIT");

    val bukkitType: Particle?
    init {
        bukkitType = Particle.valueOf(bukkitName)
    }


}


