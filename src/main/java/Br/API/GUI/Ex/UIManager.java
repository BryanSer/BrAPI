/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import Br.API.PluginData;

/**
 * @author Bryan_lzh
 * @version 1.0
 */
public class UIManager {

    public static final String UICODE = "\u00a7c\u00a7b\u00a7p\u00a7r";

    public static ClickType getSuperClickType(ClickType t) {
        switch (t) {
            case SHIFT_LEFT:
                return ClickType.LEFT;
            case SHIFT_RIGHT:
                return ClickType.RIGHT;
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

    public static String decode(String s) {
        return s.replaceAll("§", "");
    }

    private static Map<String, BaseUI> RegisteredUI = new ConcurrentHashMap<>();

    private static boolean Reigstered = false;

    public static void RegisterUI(BaseUI ui) {
        if (!Reigstered) {
            RegisterListener();
            Reigstered = true;
        }
        RegisteredUI.put(ui.getName(), ui);
    }

    @Deprecated
    public static void OpenUI(Player p, BaseUI ui) {
        openUI(p, ui);
    }

    public static void openUI(Player p, BaseUI ui) {
        Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
            p.closeInventory();
            Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
                Snapshot s = ui.getSnapshotFactory().getNewSnapshot(p, ui);
                Inventory inv = Bukkit.createInventory(p, ui.getSize(), ui.getDisplayName() + UICODE + UIManager.encode(ui.getName()));
                s.setInventory(inv);
                for (int i = 0; i < ui.getSize(); i++) {
                    ExItem item = s.getItem(i);
                    if (item != null) {
                        try {
                            inv.setItem(i, item.getDisplayItem(p, s));
                        } catch (Throwable t) {
                            Bukkit.getConsoleSender().sendMessage("BrAPI-ExUI系统处理发生异常, [" + ui.getName() + ": " + ui.getClass().getName() + "]");
                            t.printStackTrace();
                            return;
                        }
                    }
                }
                p.openInventory(inv);
            });
        });
    }

    @Deprecated
    public static void OpenUI(Player p, String name) {
        openUI(p, name);
    }

    public static void openUI(Player p, String name) {
        BaseUI ui = RegisteredUI.get(name);
        if (ui != null) {
            openUI(p, ui);
        }
    }

    @Deprecated
    public static void UpdateUI(Player p) {
        updateUI(p);
    }

    public static void updateUI(Player p) {
        String name = p.getOpenInventory().getTitle();
        Inventory inv = p.getOpenInventory().getTopInventory();
        if (name == null || !name.contains(UICODE)) {
            return;
        }
        name = UIManager.decode(name.split(UICODE)[1]);
        BaseUI ui = RegisteredUI.get(name);
        if (ui == null) {
            return;
        }
        Snapshot s = ui.getSnapshot(p);
        for (int i = 0; i < ui.getSize(); i++) {
            ExItem item = s.getItem(i);
            if (item != null) {
                if (item.isUpdateIcon()) {
                    inv.setItem(i, item.update(p, s));
                }
            }
        }
        Bukkit.getScheduler().runTask(PluginData.plugin, p::updateInventory);
    }


    private static void RegisterListener() {
        Bukkit.getPluginManager().registerEvents(new Listener() {

            @EventHandler
            public void onDrug(InventoryDragEvent evt) {
                String inv = evt.getView().getTitle();
                if (inv == null || !inv.contains(UIManager.UICODE)) {
                    return;
                }
                evt.setCancelled(true);
            }

            @EventHandler
            public void onClose(InventoryCloseEvent evt) {
                ClickLimit.remove(evt.getPlayer().getName());
                for (BaseUI ui : RegisteredUI.values()) {
                    Player p = (Player) evt.getPlayer();
                    Snapshot s = ui.getSnapshot(p);
                    if (s != null) {
//                        Boolean uiManager_close = (Boolean) s.getData("UIManager_Close");
//                        if(uiManager_close != null && uiManager_close == true){
//                            return;
//                        }
//                        s.setData("UIManager_Close",true);
                        ui.onClose(p, s);
                        ui.getSnapshotFactory().deleteSanpshop(p);
                    }
                }
            }

            private Set<String> ClickLimit = new HashSet<>();

            @EventHandler(priority = EventPriority.HIGHEST)
            public void onClick(InventoryClickEvent evt) {
                if (ClickLimit.contains(evt.getWhoClicked().getName())) {
                    evt.setCancelled(true);
                    return;
                }
                Inventory inv = evt.getWhoClicked().getOpenInventory().getTopInventory();
                String name;
                try {
                    name = inv.getName();
                } catch (NoSuchMethodError e) {
                    name = evt.getWhoClicked().getOpenInventory().getTitle();
                }
                if (name == null || !name.contains(UIManager.UICODE)) {
                    return;
                }
                name = UIManager.decode(name.split(UIManager.UICODE)[1]);
                BaseUI ui = RegisteredUI.get(name);
                if (ui == null) {
                    return;
                }
                if (evt.getClick() == ClickType.DOUBLE_CLICK) {
                    evt.setCancelled(true);
                    return;
                }
                Player p = (Player) evt.getWhoClicked();
                Snapshot snap = ui.getSnapshotFactory().getSnapshot(p);
                int slot = evt.getSlot();
                try {
                    if (evt.getClickedInventory() != inv) {
                        if ((evt.getClick() == ClickType.SHIFT_LEFT || evt.getClick() == ClickType.SHIFT_RIGHT) && !ui.isAllowShift()) {
                            evt.setCancelled(true);
                        }
                        return;
                    }
                } catch (Throwable t) {//防止craftbukkit出错(一般没人用了吧)
                    slot = evt.getRawSlot();//防止1.7.10出错
                    if (slot < 0 || slot >= inv.getSize() || slot >= ui.getSize()) {
                        if ((evt.getClick() == ClickType.SHIFT_LEFT ||
                                evt.getClick() == ClickType.SHIFT_RIGHT) && !ui.isAllowShift()) {
                            evt.setCancelled(true);
                        }
                        return;
                    }
                    slot = evt.getSlot();
                }
                evt.setCancelled(true);
                if (snap == null) {
                    Bukkit.getConsoleSender().sendMessage("BrAPI-ExUI系统处理发生异常, [" + ui.getName() + ": " + ui.getClass().getName() + "] 的Snapshot@" + p.getName() + " 无法获得");
                    Bukkit.getScheduler().runTask(PluginData.plugin, p::closeInventory);
                    return;
                }
                ExItem item = snap.getItem(slot);
                if (item != null) {
                    ClickLimit.add(evt.getWhoClicked().getName());
                    item.getClickLambda(evt.getClick(), p, snap);
                    if (item.getButtonPlaceable(p)) {
                        evt.setCancelled(false);
                    }
                    if (!item.isKeepOpen()) {
                        Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
                            p.closeInventory();
                            ClickLimit.remove(p.getName());
                        });
                    } else if (item.isUpdate()) {
                        Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
                            try {
                                UpdateUI(p);
                            } catch (Throwable e) {//修正BUG
                                Bukkit.getConsoleSender().sendMessage("BrAPI-ExUI系统处理发生异常, [" + ui.getName() + ": " + ui.getClass().getName() + "]");
                                e.printStackTrace();
                            }
                            ClickLimit.remove(p.getName());
                        });
                    } else {
                        Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
                            ClickLimit.remove(p.getName());
                        });
                    }
                }
            }
        }, PluginData.plugin);
    }
}
