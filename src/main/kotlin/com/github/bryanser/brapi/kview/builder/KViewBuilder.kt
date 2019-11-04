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

    fun onClose(func: H.() -> Unit) {
        this.close = func
    }


    operator fun Int.plus(icon: KIcon<H>) {
        contents[this] = icon
    }

    operator fun Int.plusAssign(icon: KIcon<H>) {
        contents[this] = icon
    }

    operator fun KIcon<H>.unaryPlus() {
        contents[currIndex++] = this
    }

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

    inline fun slotIcon(init: KItem<H>.() -> Unit = {}): KIcon<H> {
        return icon(true, true, false){
            cancelClick {
                false
            }
            init(this)
        }
    }

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

