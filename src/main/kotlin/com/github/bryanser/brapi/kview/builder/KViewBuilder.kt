package com.github.bryanser.brapi.kview.builder

import com.github.bryanser.brapi.kview.KIcon
import com.github.bryanser.brapi.kview.KView
import com.github.bryanser.brapi.kview.KViewContext
import org.bukkit.entity.Player

@KViewMaker
class KViewBuilder<H : KViewContext>(
        name: String,
        rows: Int,
        holderFactory: (Player) -> H
) : KView<H>(name, rows, holderFactory) {

    private var close: ((H) -> Unit)? = null
    val contents: Array<KIcon<H>?> = arrayOfNulls(rows * 9)
    private var currIndex: Int = 0

    @KViewMaker
    fun onClose(func: H.() -> Unit) {
        this.close = func
    }


    @KViewMaker
    operator fun Int.plus(icon: KIcon<H>) {
        contents[this] = icon
    }

    @KViewMaker
    operator fun Int.plusAssign(icon: KIcon<H>) {
        contents[this] = icon
    }

    @KViewMaker
    operator fun KIcon<H>.unaryPlus() {
        contents[currIndex++] = this
    }

    @KViewMaker
    inline fun icon(
            slot: Int,
            keepOpen: Boolean = true,
            updateAll: Boolean = true,
            updateIcon: Boolean = true,
            init: KItem<H>.() -> Unit
    ) {
        val icon = KItem<H>(keepOpen, updateAll, updateIcon)
        icon.init()
        contents[slot] = icon
    }

    @KViewMaker
    inline fun icon(
            keepOpen: Boolean = true,
            updateAll: Boolean = true,
            updateIcon: Boolean = true,
            init: KItem<H>.() -> Unit
    ): KIcon<H> {
        val icon = KItem<H>(keepOpen, updateAll, updateIcon)
        icon.init()
        return icon
    }

    @KViewMaker
    inline fun slotIcon(init: KItem<H>.() -> Unit = {}): KIcon<H> {
        return icon(true, true, false){
            cancelClick {
                false
            }
            init(this)
        }
    }

    @KViewMaker
    inline fun slotIcon(slot: Int, init: KItem<H>.() -> Unit = {}) {
        icon(slot, true, true, false){
            cancelClick {
                false
            }
            init(this)
        }
    }

    override fun onClose(context: H) {
        close?.invoke(context)
    }

    override fun getIcon(index: Int, context: H): KIcon<H>? {
        return contents[index]
    }
}

