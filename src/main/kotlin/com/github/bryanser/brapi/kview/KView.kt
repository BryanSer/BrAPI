@file:Suppress("UNCHECKED_CAST")

package com.github.bryanser.brapi.kview

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.util.logging.Level

abstract class KView<H : KViewHolder>(
        val name: String,
        val displayName: String,
        val rows: Int,
        val holderFactory: (Player) -> H
) {
    init {
        if (rows !in 1..6) {
            throw IllegalArgumentException("UI行数错误 必须在[1,6]之间")
        }
    }

    /*
     * 指阻止玩家对自己背包按Shift
     */
    open var allowShift: Boolean = false
    /*
     * 指阻止玩家对自己背包按数字键
     */
    open var allowNumber: Boolean = false
    /*
     * 指阻止玩家对自己背包按Q
     */
    open var allowDrop: Boolean = false
    /*
     * 是否允许在UI上拖拽;
     * *警告 这个选项非常危险 除非你知道你在做什么 否则不要设为true*
     */
    open var allowDrug: Boolean = false
    open var ignoreEventCancel: Boolean = true

    abstract fun getIcon(index: Int, holder: H): KIcon<H>?

    abstract fun onClose(holder: H)


    open fun createInventory(p: Player): Inventory {
        val holder = holderFactory(p)
        holder.kView = this as KView<KViewHolder>
        holder.player = p
        val inv = Bukkit.createInventory(holder, rows * 9, displayName)
        for (i in 0 until (rows * 9)) {
            try {
                val item = getIcon(i, holder)
                inv.setItem(i, item?.initDisplay(holder))
            } catch (e: Throwable) {
                Bukkit.getLogger().log(Level.INFO, "KView系统创建${this.name}时发生错误 ", e)
            }
        }
        return inv
    }

    open fun updateInventory(holder: H) {
        val inv = holder.inventory
        for (i in 0 until (rows * 9)) {
            val item = getIcon(i, holder)
            if (item?.updateIcon == false) {
                continue
            }
            inv.setItem(i, item?.update(holder))
        }
    }
//
//    val contents: Array<KIcon<H>?> = arrayOfNulls(rows * 9)
//
//    open fun getIcon(index: Int, holder: H): KIcon<H>? {
//        return contents[index]
//    }
//
//    open fun createInventory(p: Player): Inventory {
//        val holder = holderFactory(this, p)
//        val inv = Bukkit.createInventory(holder, rows * 9, displayName)
//        for (i in 0 until (rows * 9)) {
//            try {
//                val item = getIcon(i, holder) ?: continue
//                inv.setItem(i, item.initDisplay(holder))
//            } catch (e: Throwable) {
//                Bukkit.getLogger().log(Level.INFO, "KUI系统创建${this.name}时发生错误 ", e)
//            }
//        }
//        return inv
//    }
}