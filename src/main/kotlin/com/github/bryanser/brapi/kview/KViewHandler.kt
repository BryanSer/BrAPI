package com.github.bryanser.brapi.kview

import com.comphenix.protocol.PacketType
import com.comphenix.protocol.ProtocolLibrary
import com.comphenix.protocol.events.ListenerPriority
import com.comphenix.protocol.events.PacketAdapter
import com.comphenix.protocol.events.PacketEvent
import com.comphenix.protocol.injector.GamePhase
import com.github.bryanser.brapi.Main
import com.github.bryanser.brapi.Utils
import com.github.bryanser.brapi.kview.builder.KViewBuilder
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryDragEvent
import java.util.logging.Level

object KViewHandler : Listener {

    init {
        Bukkit.getPluginManager().registerEvents(this, Main.getPlugin())
    }

    inline fun <C : KViewContext> createKView(
            name: String,
            rows: Int,
            noinline contextFactory: (Player) -> C,
            init: KViewBuilder<C>.() -> Unit
    ): KViewBuilder<C> {
        val view = KViewBuilder<C>(
                name,
                rows,
                contextFactory
        )
        view.init()
        return view
    }

    fun openUI(p: Player, view: KView<out KViewContext>) {
        Bukkit.getScheduler().runTask(Main.getPlugin()) {
            p.closeInventory()
            val inv = view.createInventory(p)
            p.openInventory(inv)
        }
    }

    fun updateUI(p: Player) {
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        val view = context.kView

        Bukkit.getScheduler().runTask(Main.getPlugin()) {
            view.updateInventory(context)
            p.updateInventory()
        }
    }

    fun closeAll(){
        for(p in Utils.getOnlinePlayers()){
            val top = p.openInventory?.topInventory ?: continue
            if(top.holder is KViewContext){
                p.closeInventory()
            }
        }
    }

    val clickLimit = mutableSetOf<String>()
    val numberKey = mutableMapOf<String, Int>()
    private var enableNumberKey: Boolean = false

    @EventHandler
    fun onDrug(evt: InventoryDragEvent) {
        val p = evt.whoClicked as?  Player ?: return
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        evt.isCancelled = !context.kView.allowDrug
    }

    @EventHandler
    fun onClose(evt: InventoryCloseEvent) {
        val p = evt.player as?  Player ?: return
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        clickLimit -= p.name
        val view = context.kView
        view.onClose(context)
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onClick(evt: InventoryClickEvent) {
        val p = evt.whoClicked as?  Player ?: return
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        if (clickLimit.contains(evt.whoClicked.name)) {
            evt.isCancelled = true
            return
        }
        val view = context.kView
        if (evt.isCancelled && view.ignoreEventCancel) {
            return
        }
        val click = evt.click
        if (click == ClickType.DOUBLE_CLICK) {
            evt.isCancelled = true
            return
        }
        var clickOtherInv = false
        try {
            if (evt.clickedInventory != inv) {
                clickOtherInv = true
            }
        } catch (e: Throwable) {
            val raw = evt.rawSlot
            if (raw < 0 || raw >= inv.size) {
                clickOtherInv = true
            }
        }
        if (clickOtherInv) {
            if (!view.allowShift) {
                if (click == ClickType.SHIFT_RIGHT || click == ClickType.SHIFT_LEFT) {
                    evt.isCancelled = true
                }
            }
            if (!view.allowDrop) {
                if (click == ClickType.DROP || click == ClickType.CONTROL_DROP) {
                    evt.isCancelled = true
                }
            }
            if (!view.allowNumber) {
                if (click == ClickType.NUMBER_KEY) {
                    evt.isCancelled = true
                }
            }
            return
        }
        val slot = evt.slot
        val icon = view.getIcon(slot, context)
        if (icon == null) {
            evt.isCancelled = true
            return
        }
        clickLimit += p.name
        when (click) {
            ClickType.NUMBER_KEY -> {
                if (enableNumberKey) {
                    try {
                        icon.numberClick(context, numberKey[p.name]!!)
                    } catch (e: NullPointerException) {
                        Bukkit.getLogger().log(Level.INFO, "KView捕获到无数字点击 丢弃处理", e)
                        evt.isCancelled = true
                        return
                    }
                }
            }
            ClickType.CREATIVE, ClickType.UNKNOWN -> {
                evt.isCancelled = true
            }
            else -> {
                icon.onClick(click, context)
            }
        }
        try {
            evt.isCancelled = icon.cancelClickEvent(context)
        } catch (e: Throwable) {
            evt.isCancelled = true
            Bukkit.getLogger().log(Level.INFO, "KView点击处理事件取消异常", e)
            return
        }
        if (!icon.keepOpen) {
            Bukkit.getScheduler().runTask(Main.getPlugin()) {
                p.closeInventory()
                clickLimit -= p.name
            }
        } else if (icon.updateAll) {
            Bukkit.getScheduler().runTask(Main.getPlugin()) {
                updateUI(p)
                clickLimit -= p.name
            }
        } else {
            Bukkit.getScheduler().runTask(Main.getPlugin()) {
                clickLimit -= p.name
            }
        }
    }

    init {
        try {
            val pm = ProtocolLibrary.getProtocolManager()
            pm.addPacketListener(object : PacketAdapter(PacketAdapter
                    .params()
                    .plugin(Main.getPlugin())
                    .clientSide()
                    .listenerPriority(ListenerPriority.LOWEST)
                    .gamePhase(GamePhase.PLAYING)
                    .types(PacketType.Play.Client.WINDOW_CLICK)) {
                override fun onPacketReceiving(e: PacketEvent) {
                    val btn = e.packet.integers.read(2) and 0b1111
                    numberKey[e.player.name] = btn
                }
            })
            enableNumberKey = true
        } catch (e: Throwable) {
            Bukkit.getLogger().log(Level.INFO, "KView系统初始化出现异常 无法监听点击数据包 与数字键有关功能失效", e)
        }
    }
}