package Br.API.GUI.Ex.kt

import Br.API.GUI.Ex.ExItem
import Br.API.GUI.Ex.Snapshot
import org.bukkit.entity.Player
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import java.util.*

typealias SnapshotFactoryInit = (Player, MutableMap<String, Any?>) -> Unit

operator fun Snapshot<*>.get(key: String): Any = this.getData(key)
operator fun Snapshot<*>.set(key: String, data: Any) = this.setData(key, data)
class KtUIBuilder private constructor(
        val name: String,
        val displayName: String,
        val rows: Int,
        val allowShift: Boolean
) {
    companion object {
        @JvmStatic
        fun createUI(name: String, displayName: String, rows: Int, allowShift: Boolean = false): KtUIBuilder =
                KtUIBuilder(name, displayName, rows, allowShift)

    }

    public var snapshotInit: SnapshotFactoryInit? = null
        private set
    val contains: Array<KtItem?> = arrayOfNulls<KtItem?>(rows * 9)

    fun setSnapshotInit(init: SnapshotFactoryInit?): KtUIBuilder {
        snapshotInit = init
        return this
    }

    operator fun times(init: SnapshotFactoryInit?): KtUIBuilder {
        snapshotInit = init
        return this
    }

    fun build(): KtUI = object : KtUI(this) {
        override fun getItem(p: Player?, slot: Int): KtItem? {
            return contains[slot]
        }

    }

    var currencyIndex: Int = 0

    infix fun add(index: Int): KtUIBuilder {
        currencyIndex = index
        return this
    }

    infix fun add(item: KtItem?): KtUIBuilder {
        contains[currencyIndex++] = item
        return this
    }

    infix fun add(com: Pair<Int, KtItem?>): KtUIBuilder {
        contains[com.first] = com.second
        return this
    }

    infix fun remove(index: Int): KtUIBuilder {
        contains[index] = null
        return this
    }

    operator fun minus(index: Int): KtUIBuilder = this remove index

    operator fun minusAssign(index: Int) {
        this remove index
    }

    operator fun plus(index: Int): KtUIBuilder = this add index
    operator fun plus(item: KtItem?): KtUIBuilder = this add item


    operator fun plus(com: Pair<Int, KtItem?>): KtUIBuilder = this add com

    operator fun plusAssign(com: Pair<Int, KtItem?>) {
        this add com
    }

    operator fun plusAssign(item: KtItem?) {
        this add item
    }

    operator fun inc(): KtUIBuilder {
        this.currencyIndex++
        return this
    }

    operator fun dec(): KtUIBuilder {
        this.currencyIndex--
        return this
    }
}
typealias Click = (Player, Snapshot<*>) -> Unit
typealias ButtonPlaceable = (Player) -> Boolean
typealias Display = (Player, Snapshot<*>) -> ItemStack?

class KtItem(
        var keepOpen: Boolean = true,//玩家点击之后是否保持开启界面
        var update: Boolean = true,//玩家点击之后是更新 前提是keepopen == true
        var updateIcon: Boolean = true//更新时是否也更新图标
) : ExItem {
    override fun getClick(ct: ClickType, p: Player, s: Snapshot<*>): Boolean {
        val click = clicks[ct]
        if (click != null) {
            click(p, s)
            return true
        } else {
            return false
        }
    }

    val clicks: MutableMap<ClickType, Click> = EnumMap(ClickType::class.java)
    var buttonPlaceable: ButtonPlaceable? = null
    var display: Display = { _, _ -> null }
    var updateDisplay: Display? = null

    companion object {
        @JvmStatic
        fun newItem(): KtItem = KtItem()

        @JvmStatic
        fun newEmptySlot(): KtItem {
            val item = KtItem(updateIcon = false)
            item placeable { true }
            return item
        }
    }

    infix fun keepOpen(ko: Boolean): KtItem {
        this.keepOpen = ko
        return this
    }

    infix fun update(u: Boolean): KtItem {
        this.update = u
        return this
    }

    infix fun updateIcon(ui: Boolean): KtItem {
        this.updateIcon = ui
        return this
    }

    override fun getDisplayItem(p: Player, s: Snapshot<*>): ItemStack? = display(p, s)

    override fun getButtonPlaceable(p: Player): Boolean {
        return buttonPlaceable?.invoke(p) ?: false
    }


    infix fun placeable(bp: ButtonPlaceable): KtItem {
        this.buttonPlaceable = bp
        return this
    }

    infix fun click(clk: Pair<ClickType, Click>): KtItem {
        this.clicks[clk.first] = clk.second
        return this
    }

    infix fun display(dis: Display): KtItem {
        this.display = dis
        return this
    }

    infix fun update(dis: Display): KtItem {
        this.updateDisplay = dis
        return this
    }


    override fun isKeepOpen(): Boolean = keepOpen

    override fun isUpdateIcon(): Boolean = updateIcon

    override fun isUpdate(): Boolean = update

    override fun update(p: Player, s: Snapshot<*>): ItemStack? =
            if (updateDisplay != null) {
                updateDisplay!!(p, s)
            } else {
                this.getDisplayItem(p, s)
            }


}