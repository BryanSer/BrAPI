package com.github.bryanser.brapi.kview.builder

import com.github.bryanser.brapi.kview.KIcon
import com.github.bryanser.brapi.kview.KView
import com.github.bryanser.brapi.kview.KViewHolder
import org.bukkit.entity.Player

@KViewMaker
class KViewBuilder<H : KViewHolder>(
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

    override fun onClose(holder: H) {
        close?.invoke(holder)
    }

    override fun getIcon(index: Int, holder: H): KIcon<H>? {
        return contents[index]
    }
}

