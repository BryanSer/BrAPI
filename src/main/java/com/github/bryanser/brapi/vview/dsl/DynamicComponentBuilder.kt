package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.vview.VViewContext
import lk.vexview.gui.components.*
import org.bukkit.Bukkit
import java.util.*

open class DynamicComponentBuilder<VC : VViewContext>(
        val father: VComponentBuilder<VC>? = null
) {
    protected val components: MutableList<VComponent<VC, *>> = mutableListOf()

    @VViewMaker
    inner class Button(
            val id: UUID,
            var x: Int = 0,
            var y: Int = 0,
            var w: Int = 0,
            var h: Int = 0,
            var name: String,
            var img: String,
            var clickImg: String? = null,
            var click: (VC.() -> Unit)? = null,
            override var hover: MutableList<String> = mutableListOf()
    ) : VComponent<VC, VexButton>(), HoverText {

        @VViewMaker
        fun onClick(func: VC.() -> Unit) {
            click = func
        }

        override fun createComponents(context: VC): VexButton {
            return VexButton(id, name, img, clickImg, x, y, w, h, {
                if (click != null && it.uniqueId == context.player.uniqueId) {
                    click!!(context)
                }
            }, VexHoverText(hover))
        }

    }

    @VViewMaker
    fun button(
            name: String,
            img: String,
            x: Int = 0,
            y: Int = 0,
            w: Int = 0,
            h: Int = 0,
            clickImg: String? = null,
            init: Button.() -> Unit
    ): UUID {
        val uid = UUID.randomUUID()
        val btn = Button(uid, x, y, w, h, name, img, clickImg)
        btn.init()
        components += btn
        return uid
    }


    open inner class Image(
            var img: String,
            var x: Int,
            var y: Int,
            var xs: Int,
            var ys: Int,
            override var hover: MutableList<String> = mutableListOf()
    ) : VComponent<VC, VexImage>(), HoverText {
        override fun createComponents(context: VC): VexImage {
            if (hover.isNotEmpty()) {
                return VexImage(img, x, y, xs, ys, VexHoverText(hover))
            } else {
                return VexImage(img, x, y, xs, ys)
            }
        }
    }

    @VViewMaker
    fun image(
            img: String,
            x: Int = 0,
            y: Int = 0,
            xs: Int = 0,
            ys: Int = 0,
            init: Image.() -> Unit
    ) {
        val img = Image(img, x, y, xs, ys)
        img.init()
        components += img
    }

    inner class Text(
            var x: Int = 0,
            var y: Int = 0,
            var scale: Double = 1.0,
            var textWidth: Int = 10,
            var text: MutableList<String> = mutableListOf(),
            override var hover: MutableList<String> = mutableListOf()

    ) : VComponent<VC, VexText>(), HoverText {

        @VViewMaker
        fun text(init: HoverText.Holder.() -> Unit) {
            val hh = HoverText.Holder(text)
            hh.init()
        }

        override fun createComponents(context: VC): VexText {
            return VexText(x, y, text, scale, VexHoverText(hover), textWidth)
        }
    }


    @VViewMaker
    fun text(
            x: Int = 0,
            y: Int = 0,
            scale: Double = 1.0,
            textWidth: Int = 10,
            init: Text.() -> Unit
    ) {
        val text = Text(x, y, scale, textWidth)
        text.init()
        components += text
    }


    fun toComponentsList(context: VC): List<VexComponents> {
        return components.mapNotNull {
            if (it.isVisible(context)) {
                it.toVexComponents(context)
            } else {
                null
            }
        }
    }
}