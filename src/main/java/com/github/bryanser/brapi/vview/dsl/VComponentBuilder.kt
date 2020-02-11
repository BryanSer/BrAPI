package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.Main
import com.github.bryanser.brapi.vview.VViewContext
import lk.vexview.event.CheckBoxEvent
import lk.vexview.event.VexSlotClickEvent
import lk.vexview.gui.components.*
import lk.vexview.gui.components.expand.VexBase64Image
import lk.vexview.gui.components.expand.VexClickableButton
import lk.vexview.gui.components.expand.VexColorfulTextArea
import lk.vexview.gui.components.expand.VexColorfulTextField
import org.bukkit.Bukkit
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.inventory.ItemStack
import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.util.*


open class VComponentBuilder<VC : VViewContext>(
        father: VComponentBuilder<VC>? = null
) : DynamicComponentBuilder<VC>(father), Listener {

    protected val bindCheckBox: MutableMap<VC, MutableList<Pair<CheckBox, VexCheckBox>>>
    protected val bindSlot: MutableMap<VC, MutableList<Pair<Slot, VexSlot>>>

    init {
        if (father == null) {
            Bukkit.getPluginManager().registerEvents(this, Main.getPlugin())
            bindCheckBox = hashMapOf()
            bindSlot = hashMapOf()
        } else {
            bindCheckBox = father.bindCheckBox
            bindSlot = father.bindSlot
        }
    }

    @EventHandler
    fun onClick(evt: VexSlotClickEvent) {
        if (bindSlot.isEmpty()) {
            return
        }
        for ((ctx, list) in bindSlot) {
            if (ctx.player.uniqueId != evt.player.uniqueId) {
                continue
            }
            for ((cb, vs) in list) {
                if (evt.id == vs.id) {
                    val click = cb.click.getOrElse(evt.clickType) {
                        cb.click[cb.getSuperClick(evt.clickType) ?: return]
                    } ?: return
                    click(ctx)
                    return
                }
            }
        }
    }

    @EventHandler
    fun onChangeCheckBox(evt: CheckBoxEvent) {
        if (bindCheckBox.isEmpty()) {
            return
        }
        for ((ctx, list) in bindCheckBox) {
            for ((cb, vcb) in list) {
                if (evt.checkBox == vcb) {
                    cb.change(ctx, evt.checkBox.isChecked)
                    return
                }
            }
        }
    }


    @VViewMaker
    inner class CheckBox(
            val id: Int,
            var x: Int = 0,
            var y: Int = 0,
            var w: Int = 0,
            var h: Int = 0,
            var img: String,
            var checkImg: String = img,
            val default: Boolean = false,
            override var hover: MutableList<String> = mutableListOf(),
            var change: VC.(check: Boolean) -> Unit = {}
    ) : VComponent<VC, VexCheckBox>(), HoverText {

        var proxy: VC.(CheckBoxProxy) -> Unit = {}


        @VViewMaker
        fun proxy(func: VC.(CheckBoxProxy) -> Unit) {
            proxy = func
        }

        @VViewMaker
        fun onChange(func: VC.(check: Boolean) -> Unit) {
            change = func
        }

        inner class CheckBoxProxy(
                val context: VC
        ) : (Boolean) -> Unit {
            fun setChecked(chk: Boolean) {
                context.getOpenedVexGui().setCheckBox(id, chk)
            }

            override fun invoke(p1: Boolean) {
                setChecked(p1)
            }
        }

        override fun createComponents(context: VC): VexCheckBox {
            val vcb = VexCheckBox(id, img, checkImg, x, y, w, h, default)
            vcb.setHover(VexHoverText(hover))
            this@VComponentBuilder.bindCheckBox.getOrPut(context) { mutableListOf() }.add(this to vcb)
            proxy(context, CheckBoxProxy(context))
            return vcb
        }
    }

    @VViewMaker
    fun checkBox(
            id: Int,
            img: String,
            x: Int = 0,
            y: Int = 0,
            w: Int = 0,
            h: Int = 0,
            clickImg: String = img,
            default: Boolean = false,
            init: CheckBox.() -> Unit
    ) {
        val cb = CheckBox(id, x, y, w, h, img, clickImg, default)
        cb.init()
        components += cb
    }

    @VViewMaker
    abstract inner class Draw<E, VED : VexEntityDraw>(
            var x: Int = 0,
            var y: Int = 0,
            var scale: Int = 30,
            var see: Boolean = true
    ) : VComponent<VC, VED>() {
        lateinit var provider: VC.() -> E

        @VViewMaker
        fun data(func: VC.() -> E) {
            provider = func
        }

        fun getData(context: VC): E = provider(context)
    }

    @VViewMaker
    fun drawEntity(
            x: Int = 0,
            y: Int = 0,
            scale: Int = 30,
            see: Boolean = true,
            init: Draw<Entity, VexEntityDraw>.() -> Unit
    ) {
        val draw = object : Draw<Entity, VexEntityDraw>(x, y, scale, see) {
            override fun createComponents(context: VC): VexEntityDraw {
                val ved = VexEntityDraw(x, y, scale, getData(context))
                ved.setSee(see)
                return ved
            }
        }
        draw.init()
        components += draw
    }


    @VViewMaker
    fun drawPlayer(
            x: Int = 0,
            y: Int = 0,
            scale: Int = 30,
            see: Boolean = true,
            init: Draw<Player, VexPlayerDraw>.() -> Unit
    ) {
        val draw = object : Draw<Player, VexPlayerDraw>(x, y, scale, see) {
            override fun createComponents(context: VC): VexPlayerDraw {
                val ved = VexPlayerDraw(x, y, scale, getData(context))
                ved.setSee(see)
                return ved
            }
        }
        draw.init()
        components += draw
    }

    @VViewMaker
    fun drawEntityType(
            x: Int = 0,
            y: Int = 0,
            scale: Int = 30,
            see: Boolean = true,
            init: Draw<EntityType, VexEntityDraw>.() -> Unit
    ) {
        val draw = object : Draw<EntityType, VexEntityDraw>(x, y, scale, see) {
            override fun createComponents(context: VC): VexEntityDraw {
                val ved = VexEntityDraw(x, y, scale, getData(context))
                ved.setSee(see)
                return ved
            }
        }
        draw.init()
        components += draw
    }


    @VViewMaker
    fun drawPlayerGameProfile(
            x: Int = 0,
            y: Int = 0,
            scale: Int = 30,
            see: Boolean = true,
            init: Draw<Any, VexPlayerDraw>.() -> Unit
    ) {
        val draw = object : Draw<Any, VexPlayerDraw>(x, y, scale, see) {
            override fun createComponents(context: VC): VexPlayerDraw {
                val ved = VexPlayerDraw(x, y, scale, getData(context))
                ved.setSee(see)
                return ved
            }
        }
        draw.init()
        components += draw
    }

    @VViewMaker
    inner class ScrollingList(
            var x: Int,
            var y: Int,
            var w: Int,
            var h: Int,
            var fullHight: Int
    ) : VComponent<VC, VexScrollingList>() {

        val subCom = VComponentBuilder(this@VComponentBuilder)

        @VViewMaker
        fun component(init: VComponentBuilder<VC>.() -> Unit) {
            subCom.init()
        }

        inner class ScrollingProxy(
                val context: VC
        ) {
            fun addListDynamicComponent(init: DynamicComponentBuilder<VC>.() -> Unit) {
                val dcb = DynamicComponentBuilder<VC>()
                dcb.init()
                for (com in dcb.toComponentsList(context)) {
                    if (com is DynamicComponent) {
                        context.getOpenedVexGui().addListDynamicComponent(com)
                    }
                }
            }

            fun removeListDynamicComponent(com: VexComponents) {
                if (com is DynamicComponent) {
                    context.getOpenedVexGui().removeListDynamicComponent(com)
                }
            }
        }

        var proxy: VC.(ScrollingProxy) -> Unit = {}


        @VViewMaker
        fun dynamicProxy(func: VC.(ScrollingProxy) -> Unit) {
            proxy = func
        }

        override fun createComponents(context: VC): VexScrollingList {
            val vsl = VexScrollingList(x, y, w, h, fullHight)
            for (v in subCom.toComponentsList(context)) {
                if (v is ScrollingListComponent) {
                    vsl.addComponent(v)
                }
            }
            proxy(context, ScrollingProxy(context))
            return vsl
        }
    }


    @VViewMaker
    fun scrollingList(
            x: Int = 0,
            y: Int = 0,
            w: Int = 0,
            h: Int = 0,
            fullHight: Int = 0,
            init: ScrollingList.() -> Unit
    ) {
        val sl = ScrollingList(x, y, w, h, fullHight)
        sl.init()
        components += sl
    }


    @VViewMaker
    inner class Slot(
            var id: Int = 0,
            var x: Int = 0,
            var y: Int = 0,
            var provider: VC.() -> ItemStack? = { null },
            val click: EnumMap<VexSlotClickEvent.ClickType, VC.() -> Unit> = EnumMap<VexSlotClickEvent.ClickType, VC.() -> Unit>(VexSlotClickEvent.ClickType::class.java)
    ) : VComponent<VC, VexSlot>() {


        @VViewMaker
        fun item(func: VC.() -> ItemStack?) {
            provider = func
        }

        @VViewMaker
        fun item(item: ItemStack?) {
            provider = { item }
        }

        @VViewMaker
        fun click(func: VC.() -> Unit) {
            click[VexSlotClickEvent.ClickType.values()[1]] = func
        }

        @VViewMaker
        fun click(type: VexSlotClickEvent.ClickType, func: VC.() -> Unit) {
            click[type] = func
        }

        override fun createComponents(context: VC): VexSlot {
            return VexSlot(id, x, y, provider(context)).also {
                bindSlot.getOrPut(context) {
                    mutableListOf()
                }.add(this to it)
            }
        }

        fun getSuperClick(ct: VexSlotClickEvent.ClickType): VexSlotClickEvent.ClickType? {
            return when (ct) {
                VexSlotClickEvent.ClickType.values()[1] -> null
                VexSlotClickEvent.ClickType.values()[0] -> VexSlotClickEvent.ClickType.values()[1]
                VexSlotClickEvent.ClickType.values()[2] -> VexSlotClickEvent.ClickType.values()[1]
                else -> null
            }
        }
    }


    @VViewMaker
    fun slot(
            id: Int = 0,
            x: Int = 0,
            y: Int = 0,
            init: Slot.() -> Unit
    ) {
        val slot = Slot(id, x, y)
        slot.init()
        components += slot
    }


    abstract inner class TextArea<TA : VexTextArea>(
            var id: Int,
            var x: Int,
            var y: Int,
            var w: Int,
            var h: Int,
            var maxLength: Int,
            var text: MutableList<String> = mutableListOf(),
            override var hover: MutableList<String> = mutableListOf()
    ) : VComponent<VC, TA>(), HoverText {


        @VViewMaker
        fun text(init: HoverText.Holder.() -> Unit) {
            val hh = HoverText.Holder(text)
            hh.init()
        }
    }

    @VViewMaker
    fun textArea(
            id: Int,
            x: Int = 0,
            y: Int = 0,
            w: Int = 0,
            h: Int = 0,
            maxLength: Int = 100,
            init: TextArea<VexTextArea>.() -> Unit
    ) {
        val ta = object : TextArea<VexTextArea>(id, x, y, w, h, maxLength) {
            override fun createComponents(context: VC): VexTextArea {
                return VexTextArea(x, y, w, h, maxLength, id, text)
            }
        }
        ta.init()
        components += ta
    }

    abstract inner class TextField<TF : VexTextField>(
            var id: Int,
            var x: Int,
            var y: Int,
            var w: Int,
            var h: Int,
            var maxLength: Int,
            var text: String,
            override var hover: MutableList<String> = mutableListOf()
    ) : VComponent<VC, TF>(), HoverText {

        var proxy: VC.(TextFieldProxy) -> Unit = {}

        fun proxy(func: VC.(TextFieldProxy) -> Unit) {
            proxy = func
        }

        inner class TextFieldProxy(
                val context: VC
        ) : (String) -> Unit {

            fun setTextFieldContent(text: String) {
                context.getOpenedVexGui().setTextFieldContent(id, text)
            }

            override fun invoke(p1: String) {
                setTextFieldContent(p1)
            }

        }
    }

    @VViewMaker
    fun textField(
            id: Int,
            x: Int = 0,
            y: Int = 0,
            w: Int = 0,
            h: Int = 0,
            maxLength: Int = 100,
            text: String = "",
            init: TextField<VexTextField> .() -> Unit
    ) {
        val ta = object : TextField<VexTextField>(id, x, y, w, h, maxLength, text) {
            override fun createComponents(context: VC): VexTextField {
                proxy(context, TextFieldProxy(context))
                return VexTextField(x, y, w, h, maxLength, id, text)
            }
        }
        ta.init()
        components += ta
    }

    @VViewMaker
    inner class ExpandBuilder {
        inner class Base64Image(
                var id: String,
                var x: Int,
                var y: Int,
                var w: Int,
                var h: Int,
                override var hover: MutableList<String> = mutableListOf()
        ) : VComponent<VC, VexBase64Image>(), HoverText {
            lateinit var image: () -> InputStream

            @VViewMaker
            fun image(image: () -> InputStream) {
                this.image = image
            }

            @VViewMaker
            fun image(image: File) {
                image {
                    FileInputStream(image)
                }
            }

            @VViewMaker
            fun image(base64: String) {
                val code = Base64.getDecoder().decode(base64)
                image {
                    ByteArrayInputStream(code)
                }
            }

            override fun createComponents(context: VC): VexBase64Image {
                return VexBase64Image(image(), id, x, y, w, h, VexHoverText(hover))
            }
        }

        @VViewMaker
        fun base64Image(
                id: String,
                x: Int = 0,
                y: Int = 0,
                w: Int = 0,
                h: Int = 0,
                init: Base64Image.() -> Unit
        ) {
            val data = Base64Image(id, x, y, w, h)
            data.init()
            components += data
        }

        inner class ClickableButton(
                id: UUID,
                x: Int,
                y: Int,
                w: Int,
                h: Int,
                name: String,
                img: String,
                var unclickableImg: String = img,
                var clickable: Boolean = true
        ) : Button<VexClickableButton>(id, x, y, w, h, name, img) {
            var proxy: VC.(ButtonClickableProxy) -> Unit = {}

            override fun createComponents(context: VC): VexClickableButton {
                return VexClickableButton(id, name, img, clickImg, unclickableImg, x, y, w, h, {
                    if (click != null && it.uniqueId == context.player.uniqueId) {
                        click!!(context)
                    }
                }, clickable).also {
                    it.hover = VexHoverText(hover)
                    proxy(context, ButtonClickableProxy(context))
                }
            }

            inner class ButtonClickableProxy(val context: VC) : (Boolean) -> Unit {
                fun setButtonClickable(clickable: Boolean) {
                    context.getOpenedVexGui().setButtonClickable(id, clickable)
                }

                override fun invoke(p1: Boolean) {
                    setButtonClickable(p1)
                }
            }

            fun proxy(func: VC.(ButtonClickableProxy) -> Unit) {
                proxy = func
            }
        }


        @VViewMaker
        fun clickableButton(
                name: String,
                img: String,
                x: Int = 0,
                y: Int = 0,
                w: Int = 0,
                h: Int = 0,
                init: ClickableButton.() -> Unit
        ): UUID {
            val uid = UUID.randomUUID()
            val cb = ClickableButton(uid, x, y, w, h, name, img)
            cb.init()
            components += cb
            return uid
        }

        inner class ColorfulTextArea(
                id: Int,
                x: Int,
                y: Int,
                w: Int,
                h: Int,
                maxLength: Int,
                override var mainColor: Int = 0,
                override var sideColor: Int = 0
        ) : TextArea<VexColorfulTextArea>(id, x, y, w, h, maxLength), Colorful {
            override fun createComponents(context: VC): VexColorfulTextArea {
                return VexColorfulTextArea(x, y, w, h, maxLength, id, mainColor, sideColor, text).also {
                    it.setHover(VexHoverText(hover))
                }
            }
        }

        @VViewMaker
        fun colorfulTextArea(
                id: Int,
                x: Int = 0,
                y: Int = 0,
                w: Int = 0,
                h: Int = 0,
                maxLength: Int = 30,
                init: ColorfulTextArea.() -> Unit
        ) {
            val cta = ColorfulTextArea(id, x, y, w, h, maxLength)
            cta.init()
            components += cta
        }

        inner class ColorfulTextField(
                id: Int,
                x: Int,
                y: Int,
                w: Int,
                h: Int,
                maxLength: Int,
                text: String,
                override var mainColor: Int = 0,
                override var sideColor: Int = 0
        ) : TextField<VexColorfulTextField>(id, x, y, w, h, maxLength, text), Colorful {
            override fun createComponents(context: VC): VexColorfulTextField {
                return VexColorfulTextField(x, y, w, h, maxLength, id, mainColor, sideColor, text).also {
                    it.setHover(VexHoverText(hover))
                }
            }
        }

        fun colorfulTextField(
                id:Int,
                x:Int =0,
                y:Int= 0,
                w:Int = 0,
                h:Int = 0,
                maxLength: Int=30,
                text:String="",
                init:ColorfulTextField.()->Unit
        ){
            val ctf = ColorfulTextField(id,x,y,w,h,maxLength,text)
            ctf.init()
            components += ctf
        }
    }

    val expand: ExpandBuilder by lazy(::ExpandBuilder)

    @VViewMaker
    fun expand(init: ExpandBuilder.() -> Unit) {
        expand.init()
    }

}

