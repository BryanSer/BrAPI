package com.github.bryanser.brapi.vview.dsl

import java.awt.Color

interface Colorful {
    var mainColor: Int
    var sideColor: Int
    @VViewMaker
    @JvmDefault
    fun mainColor(color: Color) {
        mainColor = color.rgb
    }

    @VViewMaker
    @JvmDefault
    fun sideColor(color: Color) {
        sideColor = color.rgb
    }
}