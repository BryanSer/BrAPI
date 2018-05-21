/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import Br.API.PluginData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public class UIManager {

    public static ClickType getSuperClickType(ClickType t) {
        switch (t) {
            case SHIFT_RIGHT:
                return ClickType.SHIFT_LEFT;
            case CONTROL_DROP:
                return ClickType.DROP;
            default:
                return ClickType.LEFT;
        }
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append('§').append(c);
        }
        return sb.toString();
    }

    private static Map<String, BaseUI> RegisteredUI = new ConcurrentHashMap<>();

    private static boolean Reigstered = false;

    public static void RegisterUI(BaseUI ui) {
        if (!Reigstered) {
            RegisterListener();
        }
        RegisteredUI.put(ui.getName(), ui);
    }

    public static void OpenUI(Player p, BaseUI ui) {
        Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
            p.closeInventory();
            Snapshot s = ui.getSnapshotFactory().getNewSnapshot(p, ui);
            Inventory inv = Bukkit.createInventory(p, ui.getSize(), ui.getDisplayName() + BaseUI.UICODE + UIManager.encode(ui.getName()));
            for (int i = 0; i < ui.getSize(); i++) {
                Item item = s.getItem(i);
                if (item != null) {
                    inv.setItem(i, item.getDisplayItem(p));
                }
            }
            p.openInventory(inv);
        });
    }

    public static void OpenUI(Player p, String name) {
        BaseUI ui = RegisteredUI.get(name);
        if (ui != null) {
            OpenUI(p, ui);
        }
    }

    private static void UpdateUI(Player p) {
        Inventory inv = p.getOpenInventory().getTopInventory();
        if (inv.getName() == null || !inv.getName().contains(BaseUI.UICODE)) {
            return;
        }
        String name = ChatColor.stripColor(inv.getName().split(BaseUI.UICODE)[1]);
        BaseUI ui = RegisteredUI.get(name);
        if (ui == null) {
            return;
        }
        Snapshot s = ui.getSnapshotFactory().getNewSnapshot(p, ui);
        for (int i = 0; i < ui.getSize(); i++) {
            Item item = s.getItem(i);
            if (item != null) {
                inv.setItem(i, item.getDisplayItem(p));
            }
        }
        Bukkit.getScheduler().runTask(PluginData.plugin, p::updateInventory);
    }

    private static void RegisterListener() {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onClose(InventoryCloseEvent evt) {
                for (BaseUI ui : RegisteredUI.values()) {
                    ui.getSnapshotFactory().deleteSanpshop((Player) evt.getPlayer());
                }
            }

            @EventHandler(priority = EventPriority.HIGHEST)
            public void onClick(InventoryClickEvent evt) {
                Inventory inv = evt.getWhoClicked().getOpenInventory().getTopInventory();
                if (inv.getName() == null || !inv.getName().contains(BaseUI.UICODE)) {
                    return;
                }
                String name = ChatColor.stripColor(inv.getName().split(BaseUI.UICODE)[1]);
                BaseUI ui = RegisteredUI.get(name);
                if (ui == null) {
                    return;
                }
                evt.setCancelled(true);
                Player p = (Player) evt.getWhoClicked();
                Snapshot snap = ui.getSnapshotFactory().getSnapshot(p);
                int slot = evt.getSlot();
                try {
                    if (evt.getClickedInventory() != inv) {
                        return;
                    }
                } catch (Throwable t) {//防止craftbukkit出错(一般没人用了吧)
                    if (slot < 0) {
                        return;
                    }
                }
                Item item = snap.getItem(slot);
                if (item != null) {
                    Consumer<Player> c = item.getClickLambda(evt.getClick());
                    if (c != null) {
                        c.accept(p);
                    }
                    if (item.getOnClickNotCancel().apply(p)) {
                        evt.setCancelled(false);
                    }
                    if (!item.isKeepOpen()) {
                        Bukkit.getScheduler().runTask(PluginData.plugin, p::closeInventory);
                    } else if (item.isUpdate()) {
                        UpdateUI(p);
                    }
                }
            }
        }, PluginData.plugin);
    }
}
