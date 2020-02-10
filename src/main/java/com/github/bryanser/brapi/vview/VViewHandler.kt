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

class TestContext(p: Player) : VViewContext(p) {
    lateinit var box: (Boolean) -> Unit
    lateinit var list: VComponentBuilder<TestContext>.ScrollingList.ScrollingProxy

    fun addButton() {
        list.addListDynamicComponent {
            button("按钮", "[local]button.png") {
                x = 0
                y = 0
                w = 10
                h = 10
                clickImg = "[local]button2.png"
                onClick {
                    player.sendMessage("§c你点击了按钮 添加了一个新的按钮")
                    addButton()
                }
                hover {
                    +"§6悬浮文字"
                }
            }
        }
    }

    companion object {
        val view = VViewHandler.createView("[local]gui.png", -1, -1, 240, 158, ::TestContext) {
            button("按钮", "[local]button.png") {
                x = 0
                y = 0
                w = 10
                h = 10
                clickImg = "[local]button2.png"
                onClick {
                    player.sendMessage("§c你点击了按钮")
                }
                hover {
                    +"§6悬浮文字"
                }
            }
            checkBox(1, "[local]box.png", x = 20, y = 10, w = 10, h = 10, clickImg = "[local]box2.png", default = false) {
                onChange { t ->
                    if (t) {
                        box(false)
                        player.sendMessage("§c你不能选中这个哦")
                    }
                }
                proxy { proxy ->
                    box = proxy
                }
            }
            slot {
                x = 100
                y = 200
                id = 10
                item(ItemBuilder.createItem(Material.GLASS) {
                    name = "物品名"
                    lore {
                        +"lore"
                    }
                })
                click {
                    player.sendMessage("§c你点击了玻璃")
                }
            }
            scrollingList(x = 100, y = 20, h = 200, w = 50, fullHight = 400) {
                component {
                    button("按钮", "[local]button.png") {
                        x = 0
                        y = 0
                        w = 10
                        h = 10
                        clickImg = "[local]button2.png"
                        onClick {
                            player.sendMessage("§c你点击了按钮 添加了一个新的按钮")
                            addButton()
                        }
                        hover {
                            +"§6悬浮文字"
                        }
                    }
                }
                dynamicProxy {
                    list = it
                }
            }
        }
    }
}


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