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
import org.bukkit.entity.HumanEntity
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.inventory.*
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryView
import java.util.logging.Level

object KViewHandler : Listener {

    fun init() {
        Bukkit.getPluginManager().registerEvents(this, Main.getPlugin())
        try {
            if (Bukkit.getPluginManager().getPlugin("OpenInv") != null) {
                Bukkit.getLogger().warning("§c 警告 服务器安装了OpenInv 会导致KView完全失效 BrAPI将强制关闭OpenInv")
                val oi = Bukkit.getPluginManager().getPlugin("OpenInv")
                val f = oi.javaClass.getDeclaredField("accessor")
                f.isAccessible = true
                val acc = f.get(oi)
                if (acc != null) {
                    val tf = acc.javaClass.getDeclaredField("supported")
                    tf.isAccessible = true
                    tf.setBoolean(acc, false)
                }
                Bukkit.getPluginManager().disablePlugin(oi)
            }
        } catch (e: Throwable) {
        }
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
            clickLimit -= p.name
            p.openInventory(inv)
        }
    }

    fun updateUI(p: Player) {
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        val view = context.kView
        Bukkit.getScheduler().runTask(Main.getPlugin()) {
            try {
                if(context.closed){
                    p.closeInventory()
                    return@runTask
                }
                view.updateInventory(context)
            } catch (e: Throwable) {
                p.closeInventory()
                p.sendMessage("§cUI遇到致命错误 自动关闭 请联系管理员")
                val e = Throwable("KViewHandler遇到致命错误", e)
                e.printStackTrace()
                return@runTask
            }
            p.updateInventory()
            clickLimit -= p.name
        }
    }

    fun closeAll() {
        for (p in Utils.getOnlinePlayers()) {
            val top = p.openInventory?.topInventory ?: continue
            if (top.holder is KViewContext) {
                p.closeInventory()
            }
        }
    }

    val clickLimit = mutableSetOf<String>()
    val numberKey = mutableMapOf<String, Int>()
    private var enableNumberKey: Boolean = false

    @EventHandler
    fun onDrug(evt: InventoryDragEvent) {
        val p = evt.whoClicked as? Player ?: return
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        evt.isCancelled = !context.kView.allowDrug
    }

    @EventHandler
    fun onClose(evt: InventoryCloseEvent) {
        val p = evt.player as? Player
        if (p == null) {
            return
        }
        val inv = p.openInventory.topInventory
        if (inv == null) {
            return
        }
        val context = inv.holder as? KViewContext ?: return
        if(context.closed){
            return
        }
        context.closed = true
        clickLimit -= p.name
        val view = context.kView
        view.onClose(context)
    }


    private fun debugHandler(evt: InventoryClickEvent) {
        val p = evt.whoClicked as? Player ?: return
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        Bukkit.getLogger().info("KViewHandler-DEBUG: 开始DEBUG")
        if (clickLimit.contains(evt.whoClicked.name)) {
            Bukkit.getLogger().info("KViewHandler-DEBUG: 由于点击限制,点击事件已被抛弃")
            evt.isCancelled = true
            return
        }
        val view = context.kView
        if (evt.isCancelled && view.ignoreEventCancel) {
            Bukkit.getLogger().info("KViewHandler-DEBUG: 由于ignoreEventCancel,点击事件已被抛弃")
            return
        }
        val click = evt.click
        if (click == ClickType.DOUBLE_CLICK) {
            Bukkit.getLogger().info("KViewHandler-DEBUG: 由于DOUBLE_CLICK,点击事件已被抛弃")
            evt.isCancelled = true
            return
        }
        var clickOtherInv = false
        try {
            if (evt.clickedInventory != inv) {
                clickOtherInv = true
            }
        } catch (e: Throwable) {
            Bukkit.getLogger().log(Level.INFO, "KViewHandler-DEBUG:", e)
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
            Bukkit.getLogger().info("KViewHandler-DEBUG: 由于clickOtherInv,点击事件已被抛弃")

            return
        }
        val slot = evt.slot
        try {
            val icon = view.getIcon(slot, context)
            if (icon == null) {
                evt.isCancelled = true
                Bukkit.getLogger().info("KViewHandler-DEBUG: 由于icon == null,点击事件已被抛弃")

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
                    Bukkit.getLogger().log(Level.INFO, "KView点击类型: CREATIVE|UNKNOWN 取消事件")
                }
                else -> {
                    icon.onClick(click, context)
                }
            }
            evt.isCancelled = icon.cancelClickEvent(context)
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
        } catch (e: Throwable) {
            evt.isCancelled = true
            Bukkit.getLogger().log(Level.INFO, "KView点击处理事件取消异常", e)
            Bukkit.getScheduler().runTask(Main.getPlugin()) {
                p.closeInventory()
                p.sendMessage("§CKViewHandler遇到致命问题 自动关闭 请联系管理员")
            }
            val e = Throwable("KViewHandler遇到致命错误", e)
            e.printStackTrace()
            return
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onClick(evt: InventoryClickEvent) {
        val p = evt.whoClicked as? Player ?: return
        val inv = p.openInventory.topInventory ?: return
        val context = inv.holder as? KViewContext ?: return
        if (context.kView.debug) {
            debugHandler(evt)
            return
        }
        if (clickLimit.contains(evt.whoClicked.name)) {
            evt.isCancelled = true
            return
        }
        val view = context.kView
        if (evt.isCancelled && !view.ignoreEventCancel) {
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
        }else{
            if (!view.allowNumber) {
                if (click == ClickType.NUMBER_KEY) {
                    evt.isCancelled = true
                }
            }
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
        }
        val slot = evt.slot
        try {
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
            evt.isCancelled = icon.cancelClickEvent(context)
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
        } catch (e: Throwable) {
            evt.isCancelled = true
            Bukkit.getLogger().log(Level.INFO, "KView点击处理事件取消异常", e)
            Bukkit.getScheduler().runTask(Main.getPlugin()) {
                p.closeInventory()
                p.sendMessage("§CKViewHandler遇到致命问题 自动关闭 请联系管理员")
            }
            val e = Throwable("KViewHander遇到致命错误", e)
            e.printStackTrace()
            return
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
                var firstErr = true
                override fun onPacketReceiving(e: PacketEvent) {
                    if(e.packetType != PacketType.Play.Client.WINDOW_CLICK){
                        return
                    }
                    try{
                        val btn = e.packet.integers.read(2) and 0b1111
                        numberKey[e.player.name] = btn
                    }catch (e:Throwable){
                        if(firstErr){
                            firstErr = false
                            e.printStackTrace()
                        }
                    }
                }
            })
            enableNumberKey = true
        } catch (e: Throwable) {
            Bukkit.getLogger().log(Level.INFO, "KView系统初始化出现异常 无法监听点击数据包 与数字键有关功能失效", e)
        }

    }
}
