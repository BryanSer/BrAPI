package com.github.bryanser.brapi.vview.dsl

import lk.vexview.event.VexSlotClickEvent

enum class ClickType(
        val type: VexSlotClickEvent.ClickType
){
    LEFT(VexSlotClickEvent.ClickType.values()[1]),
    RIGHT(VexSlotClickEvent.ClickType.values()[0]),
    MIDDLE(VexSlotClickEvent.ClickType.values()[2])
}