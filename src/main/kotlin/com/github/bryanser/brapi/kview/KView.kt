@file:Suppress("UNCHECKED_CAST")

package com.github.bryanser.brapi.kview

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import java.util.logging.Level

abstract class KView<C : KViewContext>(
        val name: String,
        val rows: Int,
        val contextFactory: (Player) -> C
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

    var debug: Boolean = false

    abstract fun getIcon(index: Int, context: C): KIcon<C>?

    abstract fun onClose(context: C)

    open fun createInventory(p: Player): Inventory {
        val context = contextFactory(p)
        context.kView = this as KView<KViewContext>
        context.player = p

        val inv = Bukkit.createInventory(context, rows * 9, context.title)
        context.inv = inv
        for (i in 0 until (rows * 9)) {
            try {
                val item = getIcon(i, context)
                inv.setItem(i, item?.initDisplay(context))
            } catch (e: Throwable) {
                Bukkit.getLogger().log(Level.INFO, "KView系统创建${this.name}时发生错误 ", e)
            }
        }
        return inv
    }

    open fun updateInventory(context: C) {
        val inv = context.inventory
        for (i in 0 until (rows * 9)) {
            val item = getIcon(i, context)
            if (item?.updateIcon == false) {
                continue
            }
            inv.setItem(i, item?.update(context))
        }
    }
//
//    val contents: Array<KIcon<C>?> = arrayOfNulls(rows * 9)
//
//    open fun getIcon(index: Int, holder: C): KIcon<C>? {
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