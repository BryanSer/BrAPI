package com.github.bryanser.brapi.ui

import Br.API.GUI.Ex.Snapshot
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack


fun ui(name: String, displayName: String, rows: Int = 6, allowShift: Boolean = false, init: UI.() -> Unit): UI {
    val ui = UI(name, displayName, rows, allowShift)
    ui.init()
    return ui
}

fun test() {
    ui("test", "测试") {

    }
}


@UIMaker
class UI(
        val name: String,
        val displayName: String,
        val rows: Int,
        val allowShift: Boolean
) : UIBase() {

}

typealias Display = (Player, Snapshot<*>) -> ItemStack?

@UIMaker
class Item : Br.API.GUI.Ex.ExItem {
    var initDisplay: Display? = null
    var updateDisplay: Display? = null
    var update: Boolean = true
    var keepOpen: Boolean = true


    override fun update(p0: Player?, p1: Snapshot<*>?): ItemStack {
        TODO("not implemented")
    }

    override fun getDisplayItem(p0: Player?, p1: Snapshot<*>?): ItemStack {
        TODO("not implemented")
    }

    override fun getClick(p0: ClickType?, p1: Player?, p2: Snapshot<*>?): Boolean {
        TODO("not implemented")
    }

    override fun isUpdate(): Boolean {
        TODO("not implemented")
    }

    override fun isKeepOpen(): Boolean {
        TODO("not implemented")
    }

    override fun getButtonPlaceable(p0: Player?): Boolean {
        TODO("not implemented")
    }

    override fun isUpdateIcon(): Boolean {
        TODO("not implemented")
    }

}