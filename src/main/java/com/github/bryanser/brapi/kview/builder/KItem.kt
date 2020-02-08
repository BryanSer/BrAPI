package com.github.bryanser.brapi.kview.builder

import com.github.bryanser.brapi.kview.KIcon
import com.github.bryanser.brapi.kview.KViewContext
import org.bukkit.event.inventory.ClickType
import org.bukkit.inventory.ItemStack
import java.util.*

@KViewMaker
class KItem<H : KViewContext>(
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

    @KViewMaker
    fun cancelClick(func: H.() -> Boolean) {
        cancelClick = func
    }

    @KViewMaker
    fun initDisplay(display:ItemStack){
        initDisplay = {display}
    }

    @KViewMaker
    fun initDisplay(func: H.() -> ItemStack?) {
        initDisplay = func
    }

    @KViewMaker
    fun update(func: H.() -> ItemStack?) {
        update = func
    }

    @KViewMaker
    fun click(func: H.() -> Unit) {
        clicks[ClickType.LEFT] = func
    }

    @KViewMaker
    fun click(click: ClickType, func: H.() -> Unit) {
        clicks[click] = func
    }

    @KViewMaker
    fun number(func: H.(Int) -> Unit) {
        numberClick = func
    }

    override fun initDisplay(context: H): ItemStack? {
        return initDisplay.invoke(context)
    }

    override fun update(context: H): ItemStack? {
        return update.invoke(context)
    }

    override fun onClick(type: ClickType, context: H) {
        val func = clicks[type]
        if (func != null) {
            func(context)
        } else if (type != ClickType.LEFT) {
            onClick(getSuperClickType(type), context)
        }
    }

    override fun numberClick(context: H, key: Int) {
        numberClick?.invoke(context, key)
    }

    override fun cancelClickEvent(context: H): Boolean {
        return this.cancelClick?.invoke(context) ?: super.cancelClickEvent(context)
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