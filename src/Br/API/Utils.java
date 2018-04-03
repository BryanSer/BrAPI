/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.function.BiConsumer;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.Dye;
import org.bukkit.material.Wool;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Utils {

    public static void RemoveItem(Player p, ItemStack... items) {
        Map<Item, Integer> map = new HashMap<>();
        for (ItemStack is : items) {
            Item i = new Item(is);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + is.getAmount());
            } else {
                map.put(i, is.getAmount());
            }
        }
        A:
        for (Map.Entry<Item, Integer> e : map.entrySet()) {
            Item cl = e.getKey();
            int amount = e.getValue();
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                ItemStack item = p.getInventory().getItem(i);
                if (amount <= 0) {
                    continue A;
                }
                if (item == null) {
                    continue;
                }
                if (cl.isSame(item)) {
                    if (amount - item.getAmount() < 0) {
                        item.setAmount(item.getAmount() - amount);
                        p.getInventory().setItem(i, item);
                        continue A;
                    }
                    if (amount == item.getAmount()) {
                        p.getInventory().setItem(i, null);
                        continue A;
                    }
                    if (amount > item.getAmount()) {
                        amount -= item.getAmount();
                        p.getInventory().setItem(i, null);
                    }
                }
            }
        }
    }

    public static void RemoveItem(Player p, List<ItemStack> items) {
        Map<Item, Integer> map = new HashMap<>();
        items.forEach((is) -> {
            Item i = new Item(is);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + is.getAmount());
            } else {
                map.put(i, is.getAmount());
            }
        });
        A:
        for (Map.Entry<Item, Integer> e : map.entrySet()) {
            Item cl = e.getKey();
            int amount = e.getValue();
            for (int i = 0; i < p.getInventory().getSize(); i++) {
                ItemStack item = p.getInventory().getItem(i);
                if (amount <= 0) {
                    continue A;
                }
                if (item == null) {
                    continue;
                }
                if (cl.isSame(item)) {
                    if (amount - item.getAmount() < 0) {
                        item.setAmount(item.getAmount() - amount);
                        p.getInventory().setItem(i, item);
                        continue A;
                    }
                    if (amount == item.getAmount()) {
                        p.getInventory().setItem(i, null);
                        continue A;
                    }
                    if (amount > item.getAmount()) {
                        amount -= item.getAmount();
                        p.getInventory().setItem(i, null);
                    }
                }
            }
        }
    }

    public static boolean hasEnoughItems(Player p, List<ItemStack> items) {
        Map<Item, Integer> map = new HashMap<>();
        items.forEach((ItemStack is) -> {
            Item i = new Item(is);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + is.getAmount());
            } else {
                map.put(i, is.getAmount());
            }
        });
        for (ItemStack is : p.getInventory().getContents()) {
            if (is == null || is.getAmount() == 0 || is.getType() == Material.AIR) {
                continue;
            }
            for (Item item : map.keySet()) {
                if (item.isSame(is)) {
                    map.put(item, map.get(item) - is.getAmount());
                    break;
                }
            }
        }
        return map.values().stream().noneMatch((a) -> (a > 0));
    }

    public static boolean hasEnoughItems(Player p, ItemStack... items) {
        Map<Item, Integer> map = new HashMap<>();
        for (ItemStack is : items) {
            Item i = new Item(is);
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + is.getAmount());
            } else {
                map.put(i, is.getAmount());
            }
        }
        for (ItemStack is : p.getInventory().getContents()) {
            if (is == null || is.getAmount() == 0 || is.getType() == Material.AIR) {
                continue;
            }
            for (Item item : map.keySet()) {
                if (item.isSame(is)) {
                    map.put(item, map.get(item) - is.getAmount());
                    break;
                }
            }
        }
        return map.values().stream().noneMatch((a) -> (a > 0));
    }

    public static boolean hasItemInMainHand(Player p) {
        return p.getItemInHand() != null && p.getItemInHand().getTypeId() != 0 && p.getItemInHand().getAmount() != 0;
    }

    public static boolean hasItemInOffHand(Player p) {
        try {
            return p.getInventory().getItemInOffHand() != null
                    && p.getInventory().getItemInOffHand().getType() != Material.AIR
                    && p.getInventory().getItemInOffHand().getAmount() != 0;
        } catch (Throwable e) {
        }
        return false;
    }

    static Economy econ = null;

    /**
     * 返回Vault经济控制类
     *
     * @return
     */
    public static Economy getEconomy() {
        if (econ == null) {
            throw new NullPointerException("找不到Vault");
        }
        return econ;
    }

    /**
     * 数据插件jar里的文件
     *
     * @param p 插件
     * @param res 资源文件名 如config.yml
     * @param fold 目标文件夹 若为null则默认插件配置文件夹
     * @throws IOException
     */
    public static void OutputFile(Plugin p, String res, File fold) throws IOException {
        InputStream is = p.getResource(res);
        if (is == null) {
            return;
        }

        if (fold == null) {
            fold = p.getDataFolder();
            if (!fold.exists()) {
                fold.mkdirs();
            }
        }
        if (!fold.exists()) {
            fold.mkdirs();
        }
        File f = new File(fold, res);

        if (!f.exists()) {
            f.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(f);
        while (true) {
            int i = is.read();
            if (i == -1) {
                break;
            }
            fos.write(i);
        }
        fos.close();
        is.close();
    }

    /**
     * 安全的添加物品到玩家背包,如果玩家背包满了. 会将物品丢弃到地上
     *
     * @param p 玩家
     * @param is 物品
     */
    public static void safeGiveItem(Player p, ItemStack is) {
        if (p == null || is == null) {
            return;
        }
        is = is.clone();
        if (p.getInventory().firstEmpty() == -1 && is.getMaxStackSize() == 1) { // 背包满了
            Utils.safeDropItem(p, is);
            return;
        }
        int allowCount = 0;
        for (ItemStack sInvItem : p.getInventory().getContents()) {
            if (sInvItem != null && sInvItem.getType() != Material.AIR) {
                if (sInvItem.isSimilar(is)) {
                    allowCount += sInvItem.getMaxStackSize() - sInvItem.getAmount();
                }
            } else {
                allowCount += is.getMaxStackSize();
            }
            if (allowCount >= is.getAmount()) {
                break;
            }
        }
        if (allowCount < is.getAmount()) {
            ItemStack dropItems = is.clone();
            dropItems.setAmount(is.getAmount() - allowCount);
            is.setAmount(allowCount);
            Utils.safeDropItem(p, dropItems);
        }
        if (is.getMaxStackSize() != 0) {
            for (int i = 0; i < is.getAmount() / is.getMaxStackSize(); i++) {
                ItemStack giveItem = is.clone();
                giveItem.setAmount(giveItem.getMaxStackSize());
                p.getInventory().addItem(giveItem);
            }
        }
        if (is.getMaxStackSize() > 1) {
            int leftItemCount = is.getAmount() % is.getMaxStackSize();
            if (leftItemCount != 0) {
                ItemStack giveItem = is.clone();
                giveItem.setAmount(leftItemCount);
                p.getInventory().addItem(giveItem);
            }
        }
        p.updateInventory();
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
        if (is == null) {
            throw new NullPointerException();
        }
        if (!registered) {
            Bukkit.getPluginManager().registerEvents(new Listener() {
                @EventHandler
                public void UseItemEvent(PlayerInteractEvent evt) {
                    if (!evt.hasItem()) {
                        return;
                    }

                    ItemStack is = evt.getItem();
                    ItemInfo ID = PluginData.Traversal(is.clone());
                    if (ID == null) {
                        return;
                    }
                    try {
                        if (evt.getPlayer().getInventory().getItemInOffHand() != null
                                && evt.getPlayer().getInventory().getItemInOffHand().getType() != Material.AIR
                                && evt.getPlayer().getInventory().getItemInOffHand().getAmount() != 0) {
                            evt.getPlayer().sendMessage("§c不允许在副手上有东西时右键这个物品");
                            return;
                        }
                    } catch (Throwable e) {
                    }
                    PlayerUseItemEvent PUIE = new PlayerUseItemEvent(ID, evt.getPlayer());
                    Bukkit.getPluginManager().callEvent(PUIE);
                }
            }, PluginData.plugin);
            registered = true;
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
    @Deprecated
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
    @Deprecated
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
    @Deprecated
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
    @Deprecated
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
            int id = Integer.parseInt(s.substring(0, index));
            index2 = s.indexOf(" ", index + 1);
            int amount = Integer.parseInt(s.substring(index + 1, index2));
            index = s.indexOf(" ", index + 1);
            int durability = Integer.parseInt(s.substring(index2 + 1, s.indexOf("(")));
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
     * Ench:附魔Id-附魔等级<p>
     *
     * @param s String 字符串
     * @return ItemStack
     */
    public static ItemStack AnalyticalItem_2(String s) {
        ItemStack item;
        try {
            item = new ItemStack(Material.getMaterial(Integer.parseInt(s.split(" ")[0])));
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
                    item.setAmount(Integer.parseInt(data));
                } catch (NumberFormatException e) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l在读取物品: " + s + " 时出现错误"));
                }
                i++;
                continue;
            }
            if (i == 2) {
                try {
                    item.setDurability(Short.parseShort(data));
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
                List<String> LoreList = new ArrayList<>();
                for (int o = 0; o < lores.length; o++) {
                    lores[o] = lores[o].replaceAll("_", " ");
                    lores[o] = ChatColor.translateAlternateColorCodes('&', lores[o]);
                }
                LoreList.addAll(Arrays.asList(lores));
                ItemMeta im = item.getItemMeta();
                im.setLore(LoreList);
                item.setItemMeta(im);
                continue;
            }
            if (data.toLowerCase().contains("hide:")) {
                data = data.substring(data.indexOf(":") + 1);
                ItemMeta im = item.getItemMeta();
                for (String str : data.split(",")) {
                    im.addItemFlags(ItemFlag.valueOf(str));
                }
                item.setItemMeta(im);
                continue;
            }
            if (data.toLowerCase().contains("ench:")) {
                data = data.substring(data.indexOf(":") + 1);
                String str[] = data.split("-");
                Enchantment e = null;
                try {
                    e = Enchantment.getById(Integer.parseInt(str[0]));
                } catch (NumberFormatException ee) {
                    e = Enchantment.getByName(str[0]);
                }
                int lv = Integer.parseInt(str[1]);
                item.addUnsafeEnchantment(e, lv);
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
                    lam.setColor(Color.fromRGB(Integer.parseInt(data)));
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

    public static Class<?> getNMSClass(String name) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return Class.forName("net.minecraft.server." + version + "." + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Class<?> getBukkitClass(String name) {
        String version = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        try {
            return Class.forName("org.bukkit.craftbukkit." + version + "." + name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class Item {

        int ID;
        short Durability;
        ItemMeta meta;

        public Item(ItemStack is) {
            this.ID = is.getTypeId();
            this.Durability = is.getDurability();
            this.meta = is.getItemMeta().clone();
        }

        public boolean isSame(Item i) {
            if (i.ID == this.ID && i.Durability == this.Durability && Bukkit.getItemFactory().equals(i.meta, this.meta)) {
                return true;
            }
            return false;
        }

        public boolean isSame(ItemStack is) {
            if (is.getTypeId() == this.ID && is.getDurability() == this.Durability && Bukkit.getItemFactory().equals(is.getItemMeta(), this.meta)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 61 * hash + this.ID;
            hash = 61 * hash + this.Durability;
            hash = 61 * hash + Objects.hashCode(this.meta);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Item other = (Item) obj;
            if (this.ID != other.ID) {
                return false;
            }
            if (!Bukkit.getItemFactory().equals(other.meta, this.meta)) {
                return false;
            }
            return true;
        }

    }

    private Utils() {
    }

    /**
     * 将指定格式字符串转换成时间长度<p>
     * 格式为: ##年##(个)月##(个小)时##分(钟)##秒
     *
     * @param time
     * @return
     */
    public static long getTimeLength(String time) {
        time = time.replaceAll("[^0-9年月天时分秒]", "");
        long result = 0L;

        if (time.matches("[0-9]+(年)(.?)")) {
            int year = Integer.parseInt(time.split("年")[0]);
            result += (year * 31536000000L);
        }
        time = time.replaceAll("[0-9]+(年)", "");

        if (time.matches("[0-9]+(月)(.?)")) {
            int month = Integer.parseInt(time.split("月")[0]);
            result += (month * 2592000000L);
        }
        time = time.replaceAll("[0-9]+(月)", "");

        if (time.matches("[0-9]+(天)(.?)")) {
            int day = Integer.parseInt(time.split("天")[0]);
            result += (day * 86400000L);
        }
        time = time.replaceAll("[0-9]+(天)", "");

        if (time.matches("[0-9]+(时)(.?)")) {
            int hour = Integer.parseInt(time.split("时")[0]);
            result += (hour * 3600000L);
        }
        time = time.replaceAll("[0-9]+(时)", "");

        if (time.matches("[0-9]+(分)(.?)")) {
            int min = Integer.parseInt(time.split("分")[0]);
            result += (min * 60000L);
        }
        time = time.replaceAll("[0-9]+(分)", "");

        if (time.matches("[0-9]+(秒)")) {
            int second = Integer.parseInt(time.replaceAll("[^0-9]", ""));
            result += (second * 1000);
        }
        return result;
    }

    public static long getTimeLengthAddNow(String time) {
        long now = Utils.getTimeLength(time) + System.currentTimeMillis();
        now /= 1000;
        now *= 1000;
        return now;
    }
    private static SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String toDateFormat(long now) {
        return SDF.format(new Date(now));
    }

    public static Date toDate(String s) throws ParseException {
        return SDF.parse(s);
    }

    public static class CallBack implements Listener {

        public static void SendSignRequest(Player p, BiConsumer<Player, String> callback) {
            SignUtils.getSignUtils().SendSignRequest(p, callback);
        }

        private static Map<String, BiConsumer<Player, Integer>> SBR_Function = new HashMap<>();
        private static Map<String, Integer> SBR_Indexs = new HashMap<>();
        private static boolean Register = false;

        /**
         * 向玩家发送一堆按钮 按钮的的内容将由msg决定,最后通过BiConsumer来返回执行玩家按下的按钮<p>
         * 按钮计数从0开始
         *
         * @param p
         * @param msg
         * @param callback 注意 Integer参数可能是null
         */
        public static void SendButtonRequest(Player p, String[] msg, BiConsumer<Player, Integer> callback) {
            RegisterListener();
            BiConsumer<Player, Integer> f = SBR_Function.remove(p.getName());
            if (f != null) {
                f.accept(p, null);
            }
            ComponentBuilder builder = new ComponentBuilder("");
            final String key[] = new String[msg.length];
            for (int i = 0; i < msg.length; i++) {
                String s = msg[i];
                String cmd = getRandomString();
                key[i] = cmd;
                SBR_Indexs.put(cmd, i);
                builder.append(getButton(String.format("[%s]", s), cmd)).append("    ");
            }
            p.spigot().sendMessage(builder.create());
            callback = callback.andThen((t, u) -> {
                for (String s : key) {
                    SBR_Indexs.remove(s);
                }
            });
            SBR_Function.put(p.getName(), callback);
        }

        @EventHandler
        public void onCommand(PlayerCommandPreprocessEvent evt) {
            if (SBR_Function.isEmpty()) {
                return;
            }
            if (evt.getMessage().matches(REGex)) {
                evt.setCancelled(true);
                String key = evt.getMessage().split(" ")[2];
                Integer i = SBR_Indexs.get(key);
                if(i != null){
                    BiConsumer<Player, Integer> f = SBR_Function.remove(evt.getPlayer().getName());
                    if(f != null){
                        f.accept(evt.getPlayer(), i);
                    }
                }
            }
        }

        public static BaseComponent[] getButton(String text, String cmd) {
            return new ComponentBuilder(text)
                    .event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BrAPI Button " + cmd))
                    .create();
        }

        private static void RegisterListener() {
            if (!Register) {
                Bukkit.getPluginManager().registerEvents(new CallBack(), PluginData.plugin);
                Register = true;
            }
        }

        private static final int CHARAMOUNT = 24 + 24 + 10;
        private static final int LENGTH = 6;
        private static final char[] CHAR = new char[CHARAMOUNT];
        private static final Random Random = new Random();
        private static final String REGex = String.format("\\/?BrAPI Button [a-zA-Z0-9]{%d,%d}", LENGTH, LENGTH);

        private static String getRandomString() {
            char c[] = new char[LENGTH];
            for (int i = 0; i < LENGTH; i++) {
                c[i] = CHAR[Random.nextInt(CHARAMOUNT)];
            }
            return new String(c);
        }

        static {
            int index = 0;
            for (char c = 'a'; c <= 'z'; c++) {
                CHAR[index++] = c;
            }
            for (char c = 'A'; c <= 'Z'; c++) {
                CHAR[index++] = c;
            }
            for (char c = '0'; c <= '9'; c++) {
                CHAR[index++] = c;
            }
        }

        private CallBack() {
        }
    }
}
