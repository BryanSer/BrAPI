package com.github.bryanser.brapi.ui

import Br.API.GUI.Ex.BaseUI
import Br.API.GUI.Ex.ExItem
import Br.API.GUI.Ex.Snapshot
import Br.API.GUI.Ex.SnapshotFactory
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack


fun ui(name: String, displayName: String, rows: Int = 6, allowShift: Boolean = false, init: UI.() -> Unit): UI {
    val ui = UI(name, displayName, rows, allowShift)
    ui.init()
    return ui
}

//fun test() {
//    ui("test", "测试") {
//
//
//        onCreate { p, d ->
//        }
//        for(i in 0..9){
//            slot(i) {
//                update = false
//                updateIcon = false
//                initDisplay { p, s ->
//                    ItemStack(Material.ANVIL)
//                }
//                click { p, s ->
//
//                }
//            }
//        }
//
//    }()
//}


@UIMaker
class UI(
        val name: String,
        val displayName: String,
        val rows: Int,
        val allowShift: Boolean
) : UIBase() {
    var initSnapshot: (Player, MutableMap<String, Any?>) -> Unit = { p, d -> }

    fun onCreate(func: (Player, MutableMap<String, Any?>) -> Unit) {
        initSnapshot = func
    }

    val contents = arrayOfNulls<Item>(rows * 9)
    fun slot(slot: Int, init: Item.() -> Unit): UI {
        val item = Item()
        item.init()
        contents[slot] = item
        return this
    }

    fun build(): BaseUI {
        return object : BaseUI() {
            @Deprecated("never use", ReplaceWith("null"))
            override fun getItem(p0: Player?, p1: Int): Br.API.GUI.Ex.Item? = null

            val factory: SnapshotFactory<*> = SnapshotFactory.getDefaultSnapshotFactory(this, initSnapshot)

            init {
                super.Name = name
                super.DisplayName = displayName
                super.Rows = rows
                super.AllowShift = allowShift
            }

            override fun getSnapshotFactory(): SnapshotFactory<*> = factory

            override fun getExItem(p: Player, slot: Int): ExItem? = contents[slot]
        }
    }

    operator fun invoke(): BaseUI = this.build()
}

typealias Display = (Player, Snapshot<*>) -> ItemStack?

@UIMaker
class Item : ExItem {
    private var initDisplay: Display? = null
    private var updateDisplay: Display? = null
    var update: Boolean = true
    var keepOpen: Boolean = true
    var updateIcon: Boolean = true
    var placeable: (Player) -> Boolean = { false }
    private val click = mutableMapOf<ClickType, (Player, Snapshot<*>) -> Unit>()


    fun initDisplay(display: Display) {
        this.initDisplay = display
    }

    fun updateDisplay(display: Display) {
        this.updateDisplay = display
    }

    fun click(ct: ClickType = ClickType.LEFT, func: ((Player, Snapshot<*>) -> Unit)?) {
        if (func != null)
            this.click[ct] = func
        else this.click - ct
    }


    fun param(
            update: Boolean = true,
            keepOpen: Boolean = true,
            updateIcon: Boolean = true,
            placeable: (Player) -> Boolean = { false }
    ) {
        this.update = update
        this.keepOpen = keepOpen
        this.updateIcon = updateIcon
        this.placeable = placeable
    }


    override fun update(p0: Player, p1: Snapshot<*>): ItemStack? {
        return if (updateDisplay == null) {
            getDisplayItem(p0, p1)
        } else {
            updateDisplay!!(p0, p1)
        }
    }

    override fun getDisplayItem(p0: Player, p1: Snapshot<*>): ItemStack? {
        return if (initDisplay != null) {
            initDisplay!!(p0, p1)
        } else {
            null
        }
    }

    override fun getClick(p0: ClickType, p1: Player, p2: Snapshot<*>): Boolean {
        val func = click[p0] ?: return false
        func(p1, p2)
        return true
    }

    override fun isUpdate(): Boolean = update

    override fun isKeepOpen(): Boolean = keepOpen

    override fun getButtonPlaceable(p0: Player): Boolean = placeable(p0)

    override fun isUpdateIcon(): Boolean = updateIcon

}