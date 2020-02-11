package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.vview.VViewContext
import lk.vexview.gui.components.*
import lk.vexview.gui.components.expand.VexGifImage
import lk.vexview.gui.components.expand.VexMcImage
import lk.vexview.gui.components.expand.VexSplitImage
import java.util.*
import kotlin.collections.ArrayList

open class DynamicComponentBuilder<VC : VViewContext>(
        val father: VComponentBuilder<VC>? = null,
        protected val components: MutableList<VComponent<VC, *>> = mutableListOf()
) {


    @VViewMaker
    abstract inner class Button<VB : VexButton>(
            val id: UUID,
            var x: Int = 0,
            var y: Int = 0,
            var w: Int = 0,
            var h: Int = 0,
            var name: String,
            var img: String,
            var clickImg: String = img,
            var click: (VC.() -> Unit)? = null,
            override var hover: MutableList<String> = mutableListOf()
    ) : VComponent<VC, VB>(), HoverText {

        @VViewMaker
        fun onClick(func: VC.() -> Unit) {
            click = func
        }
    }

    inner class BuildingButton(id: UUID, x: Int, y: Int, w: Int, h: Int, name: String, img: String, clickImg: String)
        : Button<VexButton>(id, x, y, w, h, name, img, clickImg), Building<VC, Button<VexButton>> {
        override var build: Button<VexButton>.(VC) -> Unit = {}

        override fun createComponents(context: VC): VexButton {
            return VexButton(id, name, img, clickImg, x, y, w, h, {
                if (click != null && it.uniqueId == context.player.uniqueId) {
                    click!!(context)
                }
            }, VexHoverText(hover))
        }

        override fun copy(): BuildingButton {
            return BuildingButton(id, x, y, w, h, name, img, clickImg).also {
                it.click = click
                it.hover = ArrayList(hover)
                it.build = build
            }
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
            clickImg: String = img,
            init: BuildingButton.() -> Unit
    ): UUID {
        val uid = UUID.randomUUID()
        val btn = BuildingButton(uid, x, y, w, h, name, img, clickImg)
        btn.init()
        components += btn
        return uid
    }


    abstract inner class Image<VI : VexImage>(
            var img: String,
            var x: Int,
            var y: Int,
            var xs: Int,
            var ys: Int,
            override var hover: MutableList<String> = mutableListOf()
    ) : VComponent<VC, VI>(), HoverText

    inner class BuildingImage(img: String, x: Int, y: Int, xs: Int, ys: Int)
        : Image<VexImage>(img, x, y, xs, ys), Building<VC, Image<VexImage>> {
        override var build: Image<VexImage>.(VC) -> Unit = {}

        override fun createComponents(context: VC): VexImage {
            if (hover.isNotEmpty()) {
                return VexImage(img, x, y, xs, ys, VexHoverText(hover))
            } else {
                return VexImage(img, x, y, xs, ys)
            }
        }

        override fun copy(): BuildingImage {
            return BuildingImage(img, x, y, xs, ys).also {
                it.hover = ArrayList(hover)
                it.build = build
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
            init: BuildingImage.() -> Unit
    ) {
        val img = BuildingImage(img, x, y, xs, ys)
        img.init()
        components += img
    }

    inner class GifImage(
            img: String,
            x: Int,
            y: Int,
            xs: Int,
            ys: Int,
            var interval: Int = 1,
            override var build: GifImage.(VC) -> Unit = {}
    ) : Image<VexGifImage>(img, x, y, xs, ys), Building<VC, GifImage> {
        override fun createComponents(context: VC): VexGifImage {
            return VexGifImage(img, x, y, xs, ys, interval).also {
                it.setHover(VexHoverText(hover))
            }
        }

        override fun copy(): GifImage {
            return GifImage(img, x, y, xs, ys, interval, build).also {
                it.hover = ArrayList(hover)
            }
        }
    }

    @VViewMaker
    fun gifImage(
            img: String,
            x: Int = 0,
            y: Int = 0,
            xs: Int = 0,
            ys: Int = 0,
            init: GifImage.() -> Unit
    ) {
        val img = GifImage(img, x, y, xs, ys)
        img.init()
        components += img
    }

    abstract inner class SplitImage<SI : VexSplitImage>(
            img: String,
            x: Int,
            y: Int,
            xs: Int,
            ys: Int,
            var u: Int = 0,
            var v: Int = 0,
            var uWidth: Int = 100,
            var vHeight: Int = 100,
            var realWidth: Int = 100,
            var realHeight: Int = 100
    ) : Image<SI>(img, x, y, xs, ys)


    inner class BuildingSplitImage(img: String, x: Int, y: Int, xs: Int, ys: Int)
        : SplitImage<VexSplitImage>(img, x, y, xs, ys), Building<VC, SplitImage<VexSplitImage>> {
        override var build: SplitImage<VexSplitImage>.(VC) -> Unit = {}
        override fun createComponents(context: VC): VexSplitImage {
            return VexSplitImage(img, x, y, u, v, xs, ys, uWidth, vHeight, realWidth, realHeight).also {
                it.setHover(VexHoverText(hover))
            }
        }

        override fun copy(): BuildingSplitImage {
            return BuildingSplitImage(img, x, y, xs, ys).also {
                it.u = u
                it.v = v
                it.uWidth = uWidth
                it.vHeight = vHeight
                it.realHeight = realHeight
                it.realWidth = realWidth
                it.hover = ArrayList(hover)
                it.build = build
            }
        }
    }

    @VViewMaker
    fun splitImage(
            img: String,
            x: Int = 0,
            y: Int = 0,
            xs: Int = 0,
            ys: Int = 0,
            init: BuildingSplitImage.() -> Unit
    ) {
        val si = BuildingSplitImage(img, x, y, xs, ys)
        si.init()
        components += si
    }

    inner class BuildingMcImage(img: String, x: Int, y: Int, xs: Int, ys: Int)
        : SplitImage<VexMcImage>(img, x, y, xs, ys), Building<VC, SplitImage<VexMcImage>> {
        override var build: SplitImage<VexMcImage>.(VC) -> Unit = {}

        override fun createComponents(context: VC): VexMcImage {
            return VexMcImage(img, x, y, u, v, xs, ys, uWidth, vHeight, realWidth, realHeight).also {
                it.setHover(VexHoverText(hover))
            }
        }

        override fun copy(): BuildingMcImage {
            return BuildingMcImage(img, x, y, xs, ys).also {
                it.build = build
                it.hover = ArrayList(hover)
            }
        }
    }

    @VViewMaker
    fun mcImage(
            img: String,
            x: Int = 0,
            y: Int = 0,
            xs: Int = 0,
            ys: Int = 0,
            init: BuildingMcImage.() -> Unit) {
        val si = BuildingMcImage(img, x, y, xs, ys)
        si.init()
        components += si
    }

    inner class Text(
            var x: Int = 0,
            var y: Int = 0,
            var scale: Double = 1.0,
            var textWidth: Int = 10,
            var text: MutableList<String> = mutableListOf(),
            override var hover: MutableList<String> = mutableListOf(),
            override var build: Text.(VC) -> Unit = {}
    ) : VComponent<VC, VexText>(), HoverText, Building<VC, Text> {

        @VViewMaker
        fun text(init: HoverText.Holder.() -> Unit) {
            val hh = HoverText.Holder(text)
            hh.init()
        }

        override fun createComponents(context: VC): VexText {
            return VexText(x, y, text, scale, VexHoverText(hover), textWidth)
        }

        override fun copy(): Text {
            return Text(x, y, scale, textWidth, ArrayList(text), ArrayList(hover), build)
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