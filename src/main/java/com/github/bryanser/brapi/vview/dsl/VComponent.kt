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
        val copy = this.copy()
        if (copy is Building<*, *>) {
            val b = copy as Building<VC, VComponent<VC, COM>>
            b.build(copy, context)
        }
        val com = copy.createComponents(context)
        copy.comInit(context, com)
        return com
    }

    abstract fun copy(): VComponent<VC,COM>
}

