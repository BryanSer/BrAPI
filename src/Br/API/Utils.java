/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Dye;
import org.bukkit.material.Wool;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Utils {

    /**
     * 安全的添加物品到玩家背包,如果玩家背包满了,会将物品丢弃到地上
     *
     * @param pPlayer 玩家
     * @param pItem 物品
     */
    public static void safeGiveItem(Player pPlayer, ItemStack pItem) {
        if (pPlayer == null || pItem == null) {
            return;
        }
        pItem = pItem.clone();
        if (pPlayer.getInventory().firstEmpty() == -1) { // 背包满了
            if (pItem.getMaxStackSize() == 1) {
                Utils.safeDropItem(pPlayer, pItem);
                return;
            }
        }
        int allowCount = 0;
        for (ItemStack sInvItem : pPlayer.getInventory().getContents()) {
            if (sInvItem != null && sInvItem.getType() != Material.AIR) {
                if (sInvItem.isSimilar(pItem)) {
                    allowCount += sInvItem.getMaxStackSize() - sInvItem.getAmount();
                }
            } else {
                allowCount += pItem.getMaxStackSize();
            }
            if (allowCount >= pItem.getAmount()) {
                break;
            }
        }
        if (allowCount < pItem.getAmount()) {
            ItemStack dropItems = pItem.clone();
            dropItems.setAmount(pItem.getAmount() - allowCount);
            pItem.setAmount(allowCount);
            Utils.safeDropItem(pPlayer, dropItems);
        }
        if (pItem.getMaxStackSize() != 0) {
            for (int i = 0; i < pItem.getAmount() / pItem.getMaxStackSize(); i++) {
                ItemStack giveItem = pItem.clone();
                giveItem.setAmount(giveItem.getMaxStackSize());
                pPlayer.getInventory().addItem(giveItem);
            }
        }
        if (pItem.getMaxStackSize() > 1) {
            int leftItemCount = pItem.getAmount() % pItem.getMaxStackSize();
            if (leftItemCount != 0) {
                ItemStack giveItem = pItem.clone();
                giveItem.setAmount(leftItemCount);
                pPlayer.getInventory().addItem(giveItem);
            }
        }
    }

    public static void safeDropItem(Player p, ItemStack is) {
        if (is.getAmount() > 64) {
            do {
                ItemStack s = is.clone();
                s.setAmount(64);
                p.getWorld().dropItem(p.getLocation(), s);
                is.setAmount(is.getAmount() - 64);
            } while (is.getAmount() <= 64);
            p.getWorld().dropItem(p.getLocation(), is);
            return;
        }
        p.getWorld().dropItem(p.getLocation(), is);
    }

    private static boolean registered = false;

    //注册物品 将在被注册物品被玩家右键互交的时候触发 PlayerUseItemEvent
    //返回值ItemData用于判断调用事件是哪个物品
    /**
     * 注册物品 将在被注册物品被玩家右键互交的时候触发 PlayerUseItemEvent. 返回值ItemData用于判断调用事件是哪个物品.
     *
     * @param is 需要注册的物品
     * @return ItemData 用于判断调用事件是哪个物品
     */
    public static ItemInfo RegisterUseItemEvent(ItemStack is) {
        if (!registered) {
            Bukkit.getPluginManager().registerEvents(new Listener() {
                @EventHandler
                public void UseItemEvent(PlayerInteractEvent evt) {
                    if (!evt.hasItem()) {
                        return;
                    }
                    ItemStack is = evt.getItem();
                    ItemInfo ID = PluginData.Traversal(is);
                    if (ID == null) {
                        return;
                    }
                    PlayerUseItemEvent PUIE = new PlayerUseItemEvent(ID, evt.getPlayer());
                    Bukkit.getPluginManager().callEvent(PUIE);
                }
            }, PluginData.plugin);
            registered = true;
        }
        if (is == null) {
            return null;
        }
        is.setAmount(1);
        int size = PluginData.ItemDatas.size();
        ItemInfo ID = new ItemInfo(is, size + 1);
        PluginData.ItemDatas.add(ID);
        return ID;
    }

    //移除注册物品 利用注册时的返回值
    /**
     * 移除注册物品. 利用注册时的返回值 ItemData .
     *
     * @param ID 移除注册物品
     */
    public static void UnregisterUseItemEvent(ItemInfo ID) {
        if (PluginData.ItemDatas.contains(ID)) {
            PluginData.ItemDatas.remove(ID);
        }
    }

    //创建一个以tick计时的时钟 将在(long tick)后调用事件 CountDounEvent.
    //仅设置时间 20tick=1s 可通过返回值取消以及获取标识ID.
    /**
     * 创建一个以tick计时的时钟 将在(long tick)后调用事件 CountDounEvent 仅设置时间 20tick=1s.
     * 可通过返回值取消以及获取标识ID.
     *
     * @param tick 20tick=1s
     * @return {@link CountDownTask}
     */
    public static CountDownTask CreateCountDown(long tick) {
        CountDownTask cdt = new CountDownTask(tick);
        cdt.runTaskLater(PluginData.plugin, tick);
        return cdt;
    }

    //设置玩家与时间  事件调用时可通过getPlayer()方法判断是否与设置的玩家相同
    /**
     * 设置玩家与时间. 事件调用时可通过getPlayer()方法判断是否与设置的玩家相同
     *
     * @param p 玩家
     * @param tick 20tick=1s
     * @return {@link CountDownTask}
     */
    public static CountDownTask CreateCountDown(Player p, long tick) {
        CountDownTask cdt = new CountDownTask(p, tick);
        cdt.runTaskLater(PluginData.plugin, tick);
        return cdt;
    }

    //指定ID与时间   注意不要重复ID哦
    /**
     * 指定ID与时间 注意不要重复ID
     *
     * @param id ID
     * @param tick 20tick=1s
     * @return {@link CountDownTask}
     */
    public static CountDownTask CreateCountDown(long id, long tick) {
        CountDownTask cdt = new CountDownTask(id, tick);
        cdt.runTaskLater(PluginData.plugin, tick);
        return cdt;
    }
    //指定ID,玩家,时间

    /**
     * 指定ID,玩家,时间
     *
     * @param id ID
     * @param p 玩家
     * @param tick 20tick=1s
     * @return {@link CountDownTask}
     */
    public static CountDownTask CreateCountDown(long id, Player p, long tick) {
        CountDownTask cdt = new CountDownTask(id, p, tick);
        cdt.runTaskLater(PluginData.plugin, tick);
        return cdt;
    }

    /* 配置文件物品解析
     * 格式: - ID 数量 损伤值(Name:名字 Lore:Lore)
     */
    /**
     * 配置文件物品解析. 格式: ID 数量 损伤值(Name:名字 Lore:Lore)
     *
     * @param config 配置文件
     * @param path 路径
     * @return List<ItemStack> 按顺序读取的ItemStack
     * @deprecated 已经不使用 太SB了
     */
    @Deprecated
    public static List<ItemStack> AnalyticalItems(FileConfiguration config, String path) {
        if (!config.isList(path)) {
            return null;
        }
        List<String> StringList = config.getStringList(path);
        if (StringList == null) {
            return null;
        }
        List<ItemStack> ItemList = new ArrayList<>();
        for (String s : StringList) {
            int index = s.indexOf(" ");
            int index2;
            int id = Integer.valueOf(s.substring(0, index));
            index2 = s.indexOf(" ", index + 1);
            int amount = Integer.valueOf(s.substring(index + 1, index2));
            index = s.indexOf(" ", index + 1);
            int durability = Integer.valueOf(s.substring(index2 + 1, s.indexOf("(")));
            if (!s.contains("()")) {
                ItemStack i = new ItemStack(Material.getMaterial(id));
                i.setAmount(amount);
                i.setDurability((short) durability);
                ItemMeta IM = i.getItemMeta();
                s = s.substring(s.indexOf("(") + 1);
                if (s.toLowerCase().contains("name:")) {
                    int $name1 = s.toLowerCase().indexOf("name:");
                    int $name2 = 0;
                    if (s.toLowerCase().indexOf(" ", $name1) < s.indexOf(")") && s.toLowerCase().indexOf(" ", $name1) != -1) {
                        $name2 = s.toLowerCase().indexOf(" ", $name1);
                    } else {
                        $name2 = s.toLowerCase().indexOf(")", $name1);
                    }
                    String NAME = s.substring($name1 + 5, $name2);
                    IM.setDisplayName(ChatColor.translateAlternateColorCodes('&', NAME));
                }
                if (s.toLowerCase().contains("lore")) {
                    int $lore1 = s.toLowerCase().indexOf("lore");
                    int $lore2 = 0;
                    if (s.toLowerCase().indexOf(" ", $lore1) < s.indexOf("(") && s.toLowerCase().indexOf(" ", $lore1) != -1) {
                        $lore2 = s.toLowerCase().indexOf(" ", $lore1);
                    } else {
                        $lore2 = s.toLowerCase().indexOf(")");
                    }
                    String lore = s.substring($lore1 + 5, $lore2);
                    List<String> LoreList = new ArrayList<>();
                    if (lore.contains("|")) {
                        String lores[] = lore.split("\\|");
                        int o = 0;
                        for (String os : lores) {
                            lores[o] = lores[o].replaceAll("_", " ");
                            lores[o] = ChatColor.translateAlternateColorCodes('&', lores[o]);
                            o++;
                        }
                        LoreList.addAll(Arrays.asList(lores));
                    } else {
                        lore = lore.replaceAll("_", " ");
                        lore = ChatColor.translateAlternateColorCodes('&', lore);
                        LoreList.addAll(Arrays.asList(lore));
                    }
                    IM.setLore(LoreList);
                }
                i.setItemMeta(IM);
                ItemList.add(i);
            } else {
                ItemStack i = new ItemStack(Material.getMaterial(id));
                i.setAmount(amount);
                i.setDurability((short) durability);
                ItemList.add(i);
            }
        }
        return ItemList;
    }

    /* 配置文件物品解析
     * 格式: - ID 数量 损伤值 Name:名字 Lore:Lore
     */
    /**
     * 配置文件物品解析.<p>
     * 格式: ID 数量 损伤值
     * <p>
     * 可选: Name:名字 Lore:Lore Color:RED(用于染料羊毛) 或 Color:RGB(用于皮革)
     *
     * @param s String 字符串
     * @return ItemStack
     */
    public static ItemStack AnalyticalItem_2(String s) {
        ItemStack item;
        try {
            item = new ItemStack(Material.getMaterial(Integer.valueOf(s.split(" ")[0])));
        } catch (NumberFormatException e) {
            item = new ItemStack(Material.getMaterial(s.split(" ")[0]));
        }
        int i = 0;
        for (String data : s.split(" ")) {
            if (i == 0) {
                i++;
                continue;
            }
            if (i == 1) {
                try {
                    item.setAmount(Integer.valueOf(data));
                } catch (NumberFormatException e) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l在读取物品: " + s + " 时出现错误"));
                }
                i++;
                continue;
            }
            if (i == 2) {
                try {
                    item.setDurability(Short.valueOf(data));
                } catch (NumberFormatException e) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l在读取物品: " + s + " 时出现错误"));
                }
                i++;
                continue;
            }
            if (data.toLowerCase().contains("name:")) {
                data = data.substring(data.indexOf(":") + 1);
                data = ChatColor.translateAlternateColorCodes('&', data);
                data = data.replaceAll("_", " ");
                ItemMeta im = item.getItemMeta();
                im.setDisplayName(data);
                item.setItemMeta(im);
                continue;
            }
            if (data.toLowerCase().contains("lore:")) {
                data = data.substring(data.indexOf(":") + 1);
                String lores[] = data.split("\\|");
                int o = 0;
                List<String> LoreList = new ArrayList<>();
                for (String os : lores) {
                    lores[o] = lores[o].replaceAll("_", " ");
                    lores[o] = ChatColor.translateAlternateColorCodes('&', lores[o]);
                    o++;
                }
                LoreList.addAll(Arrays.asList(lores));
                ItemMeta im = item.getItemMeta();
                im.setLore(LoreList);
                item.setItemMeta(im);
                continue;
            }
            if (data.toLowerCase().contains("color:")) {
                data = data.substring(data.indexOf(":") + 1);
                if (item.getData() instanceof Dye) {
                    Dye d = (Dye) item.getData();
                    d.setColor(DyeColor.valueOf(data));
                    item.setData(d);
                    continue;
                }
                if (item.getData() instanceof Wool) {
                    Wool w = (Wool) item.getData();
                    w.setColor(DyeColor.valueOf(data));
                    item.setData(w);
                    continue;
                }
                if (item.getItemMeta() instanceof LeatherArmorMeta) {
                    LeatherArmorMeta lam = (LeatherArmorMeta) item.getItemMeta();
                    lam.setColor(Color.fromRGB(Integer.valueOf(data)));
                    item.setItemMeta(lam);
                    continue;
                }
            }
        }
        Bukkit.getConsoleSender().sendMessage(item.toString());
        return item;
    }

    /**
     * 批量解析
     *
     * @param config 配置文件
     * @param path 路径
     * @return List<ItemStack> 按顺序读取的ItemStack
     */
    public static List<ItemStack> AnalyticalItems_2(FileConfiguration config, String path) {
        if (!config.isList(path)) {
            return null;
        }
        List<String> StringList = config.getStringList(path);
        if (StringList == null) {
            return null;
        }
        List<ItemStack> ItemList = new ArrayList<>();
        for (String s : StringList) {
            ItemList.add(AnalyticalItem_2(s));
        }
        return ItemList;
    }

    /**
     * 单独解析
     *
     * @param s String字符串
     * @return ItemStack
     * @deprecated 已经不使用
     */
    @Deprecated
    public static ItemStack AnalyticalItem(String s) {
        int index = s.indexOf(" ");
        int index2;
        int id = Integer.valueOf(s.substring(0, index));
        index2 = s.indexOf(" ", index + 1);
        int amount = Integer.valueOf(s.substring(index + 1, index2));
        index = s.indexOf(" ", index + 1);
        int durability = Integer.valueOf(s.substring(index2 + 1, s.indexOf("(")));
        if (!s.contains("()")) {
            ItemStack i = new ItemStack(Material.getMaterial(id));
            i.setAmount(amount);
            i.setDurability((short) durability);
            ItemMeta IM = i.getItemMeta();
            s = s.substring(s.indexOf("(") + 1);
            if (s.toLowerCase().contains("name:")) {
                int $name1 = s.toLowerCase().indexOf("name:");
                int $name2 = 0;
                if (s.toLowerCase().indexOf(" ", $name1) < s.indexOf(")") && s.toLowerCase().indexOf(" ", $name1) != -1) {
                    $name2 = s.toLowerCase().indexOf(" ", $name1);
                } else {
                    $name2 = s.toLowerCase().indexOf(")", $name1);
                }
                String NAME = s.substring($name1 + 5, $name2);
                IM.setDisplayName(ChatColor.translateAlternateColorCodes('&', NAME));
            }
            if (s.toLowerCase().contains("lore")) {
                int $lore1 = s.toLowerCase().indexOf("lore");
                int $lore2 = 0;
                if (s.toLowerCase().indexOf(" ", $lore1) < s.indexOf("(") && s.toLowerCase().indexOf(" ", $lore1) != -1) {
                    $lore2 = s.toLowerCase().indexOf(" ", $lore1);
                } else {
                    $lore2 = s.toLowerCase().indexOf(")");
                }
                String lore = s.substring($lore1 + 5, $lore2);
                List<String> LoreList = new ArrayList<>();
                if (lore.contains("|")) {
                    String lores[] = lore.split("\\|");
                    int o = 0;
                    for (String os : lores) {
                        lores[o] = lores[o].replaceAll("_", " ");
                        lores[o] = ChatColor.translateAlternateColorCodes('&', lores[o]);
                        o++;
                    }
                    LoreList.addAll(Arrays.asList(lores));
                } else {
                    lore = lore.replaceAll("_", " ");
                    lore = ChatColor.translateAlternateColorCodes('&', lore);
                    LoreList.addAll(Arrays.asList(lore));
                }
                IM.setLore(LoreList);
            }
            i.setItemMeta(IM);
            return i;
        } else {
            ItemStack i = new ItemStack(Material.getMaterial(id));
            i.setAmount(amount);
            i.setDurability((short) durability);
            return i;
        }
    }

    /**
     * 获取方便表达的物品名称
     *
     * @param re
     * @return
     */
    public static String getItemName(ItemStack re) {
        return ((re.hasItemMeta())
                ? ((re.getItemMeta().hasDisplayName())
                        ? re.getItemMeta().getDisplayName() + ":" + re.getDurability()
                        : "物品ID为 " + re.getTypeId() + ":" + re.getDurability() + " 的物品")
                : "物品ID为 " + re.getTypeId() + ":" + re.getDurability() + " 的物品");
    }

    /**
     * 合理的获取在线玩家~
     *
     * @return
     */
    public static Collection<Player> getOnlinePlayers() {
        try {
            Method onlinePlayerMethod = Server.class.getMethod("getOnlinePlayers");
            if (onlinePlayerMethod.getReturnType().equals(Collection.class)) {
                return (Collection<Player>) onlinePlayerMethod.invoke(Bukkit.getServer());
            } else {
                return Arrays.asList((Player[]) onlinePlayerMethod.invoke(Bukkit.getServer()));
            }
        } catch (Exception ex) {
        }
        return new ArrayList<>();
    }
}
