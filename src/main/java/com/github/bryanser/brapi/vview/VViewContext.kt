package com.github.bryanser.brapi.vview

import com.github.bryanser.brapi.vview.dsl.VView
import lk.vexview.api.VexViewAPI
import lk.vexview.gui.OpenedVexGui
import org.bukkit.entity.Player

abstract class VViewContext(
        val player: Player
) {

    lateinit var view: VView<VViewContext>

    fun getOpenedVexGui(): OpenedVexGui {
        return VexViewAPI.getPlayerCurrentGui(player) ?: throw IllegalStateException("玩家${player.name}未打开VexView")
    }
}
