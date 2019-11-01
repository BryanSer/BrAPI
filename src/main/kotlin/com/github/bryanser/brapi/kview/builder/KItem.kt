package com.github.bryanser.brapi.kview.builder

import com.github.bryanser.brapi.kview.KIcon
import com.github.bryanser.brapi.kview.KViewHolder
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import java.util.*

@KViewMaker
class KItem<H : KViewHolder>(
        override var keepOpen: Boolean,
        override var updateAll: Boolean,
        override var updateIcon: Boolean
) : KIcon<H> {

    private var initDisplay: (H) -> ItemStack? = { null }
    private var update: (H) -> ItemStack? = { this.initDisplay.invoke(it) }
    private val clicks: MutableMap<ClickType, (H) -> Unit> = EnumMap(ClickType::class.java)
    private var numberClick: ((H, Int) -> Unit)? = null
    private var cancelClick: ((H) -> Boolean)? = null

    constructor(
            keepOpen: Boolean,
            updateAll: Boolean,
            updateIcon: Boolean,
            initDisplay: ItemStack
    ) : this(keepOpen, updateAll, updateIcon) {
        this.initDisplay = { initDisplay }
    }

    fun cancelClick(func: H.() -> Boolean) {
        cancelClick = func
    }

    fun initDisplay(func: H.() -> ItemStack?) {
        initDisplay = func
    }

    fun update(func: H.() -> ItemStack?) {
        update = func
    }

    fun click(func: H.() -> Unit) {
        clicks[ClickType.LEFT] = func
    }

    fun click(click: ClickType, func: H.() -> Unit) {
        clicks[click] = func
    }

    fun number(func: H.(Int) -> Unit) {
        numberClick = func
    }

    override fun initDisplay(holder: H): ItemStack? {
        return initDisplay.invoke(holder)
    }

    override fun update(holder: H): ItemStack? {
        return update.invoke(holder)
    }

    override fun onClick(type: ClickType, holder: H) {
        val func = clicks[type]
        if (func != null) {
            func(holder)
        } else if (type != ClickType.LEFT) {
            onClick(getSuperClickType(type), holder)
        }
    }

    override fun numberClick(holder: H, key: Int) {
        numberClick?.invoke(holder, key)
    }

    override fun cancelClickEvent(holder: H): Boolean {
        return this.cancelClick?.invoke(holder) ?: super.cancelClickEvent(holder)
    }

    companion object {
        fun getSuperClickType(t: ClickType): ClickType {
            when (t) {
                ClickType.SHIFT_LEFT -> return ClickType.LEFT
                ClickType.SHIFT_RIGHT -> return ClickType.RIGHT
                ClickType.CONTROL_DROP -> return ClickType.DROP
                else -> return ClickType.LEFT
            }
        }

    }

}