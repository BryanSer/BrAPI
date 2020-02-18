package com.github.bryanser.brapi.vview.dsl

@VViewMaker
interface HoverText {
    val hover: MutableList<String>

    class Holder(
            val hover: MutableList<String>
    ) {
        @VViewMaker
        operator fun String.unaryPlus() {
            hover += this
        }

        @VViewMaker
        operator fun String.unaryMinus() {
            hover -= this
        }

        @VViewMaker
        operator fun set(index: Int, lore: String) {
            while (this.hover.size <= index) {
                +""
            }
            this.hover[index] = lore
        }


        @VViewMaker
        operator fun get(index: Int): String = hover[index]
    }

    @JvmDefault
    @VViewMaker
    fun hover(init: Holder.() -> Unit) {
        val ho = Holder(hover)
        ho.init()
    }
}