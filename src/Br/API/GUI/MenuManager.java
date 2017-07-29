/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import Br.API.PluginData;
import java.util.HashMap;
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
import org.bukkit.inventory.PlayerInventory;
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
            for (int i = 0; i < 9 * m.getSize(); i++) {
                if (i == m.Contains.size()) {
                    break;
                }
                Item item = m.Contains.get(i);
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
                    if (evt.getClickedInventory() instanceof PlayerInventory) {
                        PlayerInventory pi = (PlayerInventory) evt.getClickedInventory();
                        if (evt.getSlot() == 8) {
                            evt.setCancelled(true);
                        }
                    }
                    return;
                }
                evt.setCancelled(true);
                if (evt.getClickedInventory() != inv) {
                    return;
                }
                int slot = evt.getSlot();
                Item i = m.getClick(slot);
                if (i != null) {
                    Player p = (Player) evt.getWhoClicked();
                    if (!i.checkCD(p)) {
                        p.sendMessage("§c你还不能使用这个项目 请稍等后重试");
                        return;
                    }
                    if (i.Use(p)) {
                        i.CD(p);
                    }
                    if (!i.isKeepopen()) {
                        evt.getWhoClicked().closeInventory();
                    }
                    MenuManager.UpdateMenu(p);
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
