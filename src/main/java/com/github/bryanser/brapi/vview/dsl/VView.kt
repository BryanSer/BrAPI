package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.vview.VViewContext
import com.github.bryanser.brapi.vview.VViewHandler
import lk.vexview.api.VexViewAPI
import lk.vexview.gui.VexGui
import lk.vexview.gui.components.DynamicComponent
import lk.vexview.gui.components.VexComponents
import org.bukkit.entity.Player

@VViewMaker
class VView<VC : VViewContext>(
        val img: String,
        val x: Int,
        val y: Int,
        val w: Int,
        val h: Int,
        val contextFactory: (Player) -> VC
) : VComponentBuilder<VC>() {

    var close: VC.() -> Unit = {}
    var open: VC.() -> Boolean = { true }
    var proxy: VC.(ViewProxy) -> Unit = {}

    inner class ViewProxy(
            val context: VC
    ) {
        fun addDynamicComponent(init: DynamicComponentBuilder<VC>.() -> Unit) {
            val dcb = DynamicComponentBuilder<VC>()
            dcb.init()
            for (com in dcb.toComponentsList(context)) {
                if (com is DynamicComponent) {
                    context.getOpenedVexGui().addDynamicComponent(com)
                }
            }
        }

        fun removeDynamicComponent(com: VexComponents) {
            if (com is DynamicComponent) {
                context.getOpenedVexGui().removeDynamicComponent(com)
            }
        }
    }

    @VViewMaker
    fun dynamicProxy(func: VC.(ViewProxy) -> Unit) {
        proxy = func
    }

    @VViewMaker
    fun onClose(func: VC.() -> Unit) {
        close = func
    }

    @VViewMaker
    fun checkOpen(func: VC.() -> Boolean) {
        open = func
    }

    fun onClose(context: VC) {
        close(context)
        bindCheckBox.remove(context)
    }

    fun checkOpen(context: VC): Boolean = open(context)

    fun build(context: VC): VexGui {
        val gui = VexGui(img, x, y, w, h)
        toComponentsList(context).forEach(gui::addComponent)
        return gui
    }

    fun open(player: Player) {
        val context = contextFactory(player)
        VViewHandler.opening[player.uniqueId] = context
        if (checkOpen(context)) {
            bindCheckBox[context] = mutableListOf()
            VexViewAPI.openGui(player, this.build(context))
            proxy(context, ViewProxy(context))
        }
    }
}