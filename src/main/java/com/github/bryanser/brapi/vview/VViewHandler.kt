package com.github.bryanser.brapi.vview

import com.github.bryanser.brapi.ItemBuilder
import com.github.bryanser.brapi.Main
import com.github.bryanser.brapi.vview.dsl.VComponentBuilder
import com.github.bryanser.brapi.vview.dsl.VView
import lk.vexview.event.gui.VexGuiCloseEvent
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent
import java.util.*


object VViewHandler : Listener {
    var enable: Boolean = false

    val opening = hashMapOf<UUID, VViewContext>()

    fun init() {
        if (Bukkit.getPluginManager().getPlugin("VexView") == null) {
            return
        }
        Bukkit.getPluginManager().registerEvents(this, Main.getPlugin())
    }

    fun getContext(p: Player): VViewContext? = opening[p.uniqueId]

    fun <VC : VViewContext> createView(
            img: String,
            x: Int,
            y: Int,
            w: Int,
            h: Int,
            contextFactory: (Player) -> VC,
            init: VView<VC>.() -> Unit
    ): VView<VC> {
        val view = VView(img, x, y, w, h, contextFactory)
        view.init()
        return view
    }


    @EventHandler
    fun onClose(evt: VexGuiCloseEvent) {
        val vc = opening.remove(evt.player.uniqueId) ?: return
        vc.view.onClose(vc)
    }

    @EventHandler
    fun onQuit(evt: PlayerQuitEvent) {
        val vc = opening.remove(evt.player.uniqueId) ?: return
        vc.view.onClose(vc)
    }
}