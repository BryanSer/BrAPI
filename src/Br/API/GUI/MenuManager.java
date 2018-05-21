/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import Br.API.PluginData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Bryan_lzh
 */

public class MenuManager {

    public static Map<String, Menu> Menus = new HashMap<>();
    public static Map<CheckItem, Menu> MenuItems = new HashMap<>();
    public static boolean registered = false;

    public static void UpdateMenu(Player p) {
        Inventory inv = p.getOpenInventory().getTopInventory();
        Menu m = MenuManager.getMenu(inv);
        if (m != null) {
            inv.clear();
            List<Item> list = m.getContains(p);
            for (int i = 0; i < 9 * m.getSize(); i++) {
                if (i == list.size()) {
                    break;
                }
                Item item = list.get(i);
                if (item != null) {
                    inv.setItem(i, item.getDisplay(p));
                }
            }
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                p.updateInventory();
            }
        }.runTaskLater(PluginData.plugin, 0);
    }

    public static void OpenMenu(Player p, String menu) {
        Menu m = Menus.get(menu);
        if (m != null) {
            Inventory inv = m.getInv(p);
            p.openInventory(inv);
        }
    }

    public static void OpenMenuDelay(Player p, String menu) {
        Menu m = Menus.get(menu);
        if (m != null) {

            Bukkit.getScheduler().runTask(PluginData.plugin, () -> {
                p.closeInventory();
                Inventory inv = m.getInv(p);
                p.openInventory(inv);
            });
        }
    }

    public static void RegisterMenu(Menu m) {
        if (!registered) {
            registerListener();
            registered = true;
        }
        Menus.put(m.getName(), m);
        if (m.getOpenItem_Mate() != null) {
            CheckItem ci = new CheckItem();
            ci.m = m.OpenItem_Mate;
            ci.s = m.OpenItem_Dam;
            MenuItems.put(ci, m);
        }
    }

    public static Menu getMenu(Inventory inv) {
        if (inv.getTitle() != null) {
            String s = deCode(inv.getTitle());
            if (s != null) {
                return Menus.get(s);
            }
        }
        return null;
    }

    private static void registerListener() {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler(priority = EventPriority.MONITOR)
            public void onClick(InventoryClickEvent evt) {
                Inventory inv = evt.getWhoClicked().getOpenInventory().getTopInventory();
                Menu m = MenuManager.getMenu(inv);
                if (m == null) {
                    return;
                }
                evt.setCancelled(true);
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
                Item i = m.getClick(slot, (Player) evt.getWhoClicked());
                if (i != null) {
                    Player p = (Player) evt.getWhoClicked();
                    if (!i.checkCD(p)) {
                        p.sendMessage(i.CDMessage(p));
                        return;
                    }

                    switch (evt.getClick()) {
                        case LEFT:
                            if (i.Use(p)) {
                                i.CD(p);
                            }
                            break;
                        case RIGHT:
                            if (i.Use_Right(p)) {
                                i.CD(p);
                            }
                            break;
                        case SHIFT_LEFT:
                            if (i.Use_Shift_Left(p)) {
                                i.CD(p);
                            }
                            break;
                        case SHIFT_RIGHT:
                            if (i.Use_Shift_Right(p)) {
                                i.CD(p);
                            }
                            break;
                        case DROP:
                            if (i.Use_Drop(p)) {
                                i.CD(p);
                            }
                            break;
                        case CONTROL_DROP:
                            if (i.Use_Drop_Ctrl(p)) {
                                i.CD(p);
                            }
                            break;
                        case MIDDLE:
                            if (i.Use_Middle(p)) {
                                i.CD(p);
                            }
                            break;
                        default:
                            if (i.Use(p)) {
                                i.CD(p);
                            }
                            break;
                    }
                    if (!i.isKeepopen()) {
                        evt.getWhoClicked().closeInventory();
                    } else if (i.isNeedUpdate()) {
                        MenuManager.UpdateMenu(p);
                    }
                }
            }

            @EventHandler
            public void onRightClick(PlayerInteractEvent evt) {
                if (evt.hasItem()) {
                    ItemStack is = evt.getItem();
                    for (Map.Entry<CheckItem, Menu> e : MenuItems.entrySet()) {
                        if (e.getKey().isItem(is)) {
                            evt.setCancelled(true);
                            Menu m = e.getValue();

                            if (!m.canOpen(evt.getPlayer())) {
                                evt.getPlayer().sendMessage("§c你无法打开这个菜单");
                                return;
                            }
                            Inventory inv = m.getInv(evt.getPlayer());
                            evt.getPlayer().openInventory(inv);
                            return;
                        }
                    }
                }
            }
        }, PluginData.plugin);
    }

    public static String deCode(String s) {
        if (s.contains(Menu.SplCode)) {
            s = s.split(Menu.SplCode)[1];
            return s.replaceAll("§", "");
        } else {
            return null;
        }
    }

    public static String toCode(String s) {
        String r = "";
        for (char c : s.toCharArray()) {
            r = r + "§" + c;
        }
        return r;
    }
}
