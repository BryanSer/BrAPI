package Br.API.ktsuger

import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.inventory.ItemStack

object ItemBuilder {
    infix fun create(material: Material): Building = Building(material)

    operator fun times(material: Material): Building = Building(material)

    data class Building(
            val material: Material
    ) {
        var displayName: String? = null
        var lore: MutableList<String>? = null
        var unbreakable = false
        var durability: Short = 0
        var ench: MutableMap<Enchantment, Int>? = null

        fun build(): ItemStack {
            val item = ItemStack(material)
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