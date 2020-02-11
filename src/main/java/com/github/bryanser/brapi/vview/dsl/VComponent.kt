package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.vview.VViewContext
import lk.vexview.gui.components.VexComponents

abstract class VComponent<VC : VViewContext, COM : VexComponents>(
        var visible: VC.() -> Boolean = { true },
        var comInit: VC.(COM) -> Unit = {}
) {
//    var build: VC.(VComponent<VC, COM>) -> Unit = {}
    fun isVisible(context: VC): Boolean = visible(context)

    @VViewMaker
    fun visible(func: VC.() -> Boolean) {
        visible = func
    }

    @VViewMaker
    fun init(func: VC.(COM) -> Unit) {
        comInit = func
    }

    protected abstract fun createComponents(context: VC): COM

    fun toVexComponents(context: VC): COM {
        if (this is Building<*, *>) {
            val b = this as Building<VC, VComponent<VC, COM>>
            b.build(context, this)
        }
//        build(context, this)
        val com = createComponents(context)
        comInit(context, com)
        return com
    }
}

