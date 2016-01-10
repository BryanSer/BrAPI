/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Utils {

    /*  final public static int d0 = 1;
     final public static int d1 = 2;
     final public static int d2 = 4;
     final public static int d3 = 8;
     final public static int d4 = 16;
     final public static int d5 = 32;
     final public static int d6 = 64;
     final public static int d7 = 128;
     final public static int d8 = 256;
     final public static int d9 = 512;*/
    //注册物品 将在被注册物品被玩家右键互交的时候触发 PlayerUseItemEvent
    //返回值ItemData用于判断调用事件是哪个物品
    public static ItemData RegisterUseItemEvent(ItemStack is) {
        if (is == null) {
            return null;
        }
        is.setAmount(1);
        int size = Data.ItemDatas.size();
        ItemData ID = new ItemData(is, size + 1);
        Data.ItemDatas.add(ID);
        return ID;
    }

    //移除注册物品 利用注册时的返回值
    public static void UnregisterUseItemEvent(ItemData ID) {
        if (Data.ItemDatas.contains(ID)) {
            Data.ItemDatas.remove(ID);
        }
    }

    //创建一个以tick计时的时钟 将在(long tick)后调用事件 CountDounEvent
    //仅设置时间 20tick=1s 可通过返回值取消以及获取标识ID
    public static CountDownTask CreateCountDown(long tick) {
        CountDownTask cdt = new CountDownTask(tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }

    //设置玩家与时间  事件调用时可通过getPlayer()方法判断是否与设置的玩家相同
    public static CountDownTask CreateCountDown(Player p, long tick) {
        CountDownTask cdt = new CountDownTask(p, tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }

    //指定ID与时间   注意不要重复ID哦
    public static CountDownTask CreateCountDown(long id, long tick) {
        CountDownTask cdt = new CountDownTask(id, tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }
    //指定ID,玩家,时间

    public static CountDownTask CreateCountDown(long id, Player p, long tick) {
        CountDownTask cdt = new CountDownTask(id, p, tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }

    /* 配置文件物品解析
     * 格式: - ID 数量 损伤值(Name:名字 Lore:Lore)
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
                    if (lore.indexOf("|") != -1) {
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
                continue;
            } else {
                ItemStack i = new ItemStack(Material.getMaterial(id));
                i.setAmount(amount);
                i.setDurability((short) durability);
                ItemList.add(i);
                continue;
            }
        }
        return ItemList;
    }

    /* 配置文件物品解析
     * 格式: - ID 数量 损伤值 Name:名字 Lore:Lore
     */
    public static ItemStack AnalyticalItem_2(String s) {
        ItemStack item;
        try {
            item = new ItemStack(Material.getMaterial(Integer.valueOf(s.split(" ")[0])));
        } catch (NumberFormatException e) {
            item = new ItemStack(Material.getMaterial(s.split(" ")[0]));
        }
        int i = 1;
        for (String data : s.split(" ")) {
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
        }
        return item;
    }

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
                if (lore.indexOf("|") != -1) {
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
}
