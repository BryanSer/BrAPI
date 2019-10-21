package com.github.bryanser.brapi

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * 构造物品工具
 * 用法:
 * ```
 *  val item = (ItemBuilder create Material.STONE name "§6物品名" lore "lore")()
 * ```
 */
object ItemBuilder {

    inline fun createItem(material: Material, amount: Int = 1, durability: Int = 0, init: StackBuilder.() -> Unit): ItemStack {
        val sb = StackBuilder(material)
        sb.amount = amount
        sb.durability = durability.toShort()
        sb.init()
        return sb.build()
    }

    /**
     * 创建一个物品构造器
     *
     * @param id 物品ID
     * @return 构造器
     */
    infix fun create(id: Int): Building = Building(Material.getMaterial(id))

    /**
     * 创建一个物品构造器
     *
     * @param material 物品类型
     * @return 构造器
     */
    infix fun create(material: Material): Building = Building(material)

    /**
     * 创建一个物品构造器
     *
     * @param material 物品类型
     * @return 构造器
     */
    operator fun times(material: Material): Building = Building(material)

    /**
     * 创建一个物品构造器
     *
     * @param id 物品ID
     * @return 构造器
     */
    operator fun times(id: Int): Building = Building(Material.getMaterial(id))

    /**
     * 物品构造器
     *
     * @property material 物品类型
     * @property amount 物品数量
     * @property displayName 物品显示名
     * @property lore 物品Lore
     * @property unbreakable 是否不可破坏
     * @property durability 物品损伤值
     * @property ench 物品附魔
     */
    data class Building(
            val material: Material
    ) {
        var amount: Int = 1
        var displayName: String? = null
        var lore: MutableList<String>? = null
        var unbreakable = false
        var durability: Short = 0
        var ench: MutableMap<Enchantment, Int>? = null

        /**
         * 构造物品
         *
         * @return 物品
         */
        fun build(): ItemStack {
            val item = ItemStack(material, amount, durability)
            val im = +item
            if (displayName != null) im.displayName = displayName
            if (lore != null) im.lore = lore
            if (unbreakable) {
                try {
                    im.isUnbreakable = true
                } catch (t: Throwable) {
                    im.spigot().isUnbreakable = true
                }
            }
            item += im
            if (ench != null) {
                for ((e, l) in ench!!) {
                    item.addUnsafeEnchantment(e, l)
                }
            }
            return item
        }

        infix fun amount(v: Int): Building {
            this.amount = v
            return this
        }

        infix fun name(name: String): Building {
            this.displayName = name
            return this
        }

        infix fun lore(s: String): Building {
            if (this.lore == null) {
                this.lore = ArrayList()
            }
            this.lore!! += s
            return this
        }

        infix fun lore(s: Array<String>): Building {
            if (this.lore == null) {
                this.lore = ArrayList()
            }
            this.lore!! += s
            return this
        }

        infix fun lore(func: (MutableList<String>) -> Unit): Building {
            if (this.lore == null) {
                this.lore = ArrayList()
            }
            func(lore!!)
            return this
        }


        operator fun invoke(): ItemStack = this.build()

        operator fun plusAssign(s: Array<String>) {
            this lore s
        }

        operator fun plus(s: Array<String>): Building = this lore s


        operator fun plusAssign(s: String) {
            this lore s
        }

        operator fun plus(s: String): Building = this lore s

        infix fun unbreakable(u: Boolean): Building {
            this.unbreakable = u
            return this
        }

        infix fun durability(dur: Int): Building {
            this.durability = dur.toShort()
            return this
        }

        infix fun ench(pair: Pair<Enchantment, Int>): Building {
            if (this.ench == null) {
                this.ench = HashMap()
            }
            this.ench!! += pair
            return this
        }
    }
}



@DslMarker
annotation class ItemStackBuilder

@ItemStackBuilder
class StackBuilder(
        val material: Material
) {
    var amount: Int = 1
    var name: String? = null
    val loreHolder = LoreHolder()
    var unbreakable = false
    var durability: Short = 0
    var ench: MutableMap<Enchantment, Int>? = null
    var onBuild: (ItemStack.() -> ItemStack)? = null


    infix fun amount(v: Int) {
        this.amount = v
    }

    infix fun name(name: String) {
        this.name = name
    }

    fun unbreakable(ub: Boolean = true) {
        this.unbreakable = ub
    }

    fun lore(vararg lore:String){
        this.loreHolder.lore.addAll(Arrays.asList(*lore))
    }

    inline fun lore(init: LoreHolder.() -> Unit) {
        this.loreHolder.init()
    }

    infix fun durability(dur: Int) {
        this.durability = dur.toShort()
    }

    infix fun ench(pair: Pair<Enchantment, Int>) {
        if (this.ench == null) {
            this.ench = HashMap()
        }
        this.ench!! += pair
    }

    infix fun onBuild(build: ItemStack.() -> ItemStack) {
        this.onBuild = build
    }

    @ItemStackBuilder
    inner class LoreHolder {
        val lore = mutableListOf<String>()

        operator fun String.unaryPlus() {
            lore += this
        }

        operator fun String.unaryMinus() {
            lore -= this
        }

        operator fun set(index: Int, lore: String) {
            while (this.lore.size <= index) {
                +""
            }
            this.lore[index] = lore
        }

        operator fun get(index: Int): String = lore[index]
    }

    fun build(): ItemStack {
        val item = ItemStack(material, amount, durability)
        val im = +item
        if (name != null) im.displayName = name
        im.lore = loreHolder.lore
        if (unbreakable) {
            try {
                im.isUnbreakable = true
            } catch (t: Throwable) {
                im.spigot().isUnbreakable = true
            }
        }
        item += im
        if (ench != null) {
            for ((e, l) in ench!!) {
                item.addUnsafeEnchantment(e, l)
            }
        }
        if (onBuild != null) {
            return onBuild!!.invoke(item)
        }
        return item
    }
}