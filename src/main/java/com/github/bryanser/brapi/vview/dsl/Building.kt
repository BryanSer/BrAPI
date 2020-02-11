package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.vview.VViewContext

interface Building<VC : VViewContext, VCOM : VComponent<VC, *>> {
    var build: VCOM.(VC) -> Unit

    @JvmDefault
    @VViewMaker
    fun onBuild(func: VCOM.(VC) -> Unit) {
        build = func
    }
}