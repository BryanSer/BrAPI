package com.github.bryanser.brapi.vview.dsl

import com.github.bryanser.brapi.vview.VViewContext

interface Building<VC : VViewContext, VCOM : VComponent<VC, *>> {
    var build: VC.(VCOM) -> Unit

    @JvmDefault
    fun onBuild(func: VC.(VCOM) -> Unit) {
        build = func
    }
}