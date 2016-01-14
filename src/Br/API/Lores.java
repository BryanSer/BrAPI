/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Lores {

    /**
     * 设置Lore 以|分割行,视_为空格
     *
     * @param is 需要设置的物品
     * @param lore 以|分割行,视_为空格
     * @return ItemStack
     */
    public static ItemStack Lore(ItemStack is, String lore) {
        if (is != null) {
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
            ItemMeta im = is.getItemMeta();
            im.setLore(LoreList);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

    /**
     * 设置Lore
     *
     * @param is 需要设置的物品
     * @param s 按顺序添加至Lore
     * @return ItemStack
     */
    public static ItemStack Lore(ItemStack is, String[] s) {
        if (is != null) {
            int i = 0;
            for (String st : s) {
                s[i] = ChatColor.translateAlternateColorCodes('&', st);
                i++;
            }
            ItemMeta im = is.getItemMeta();
            List<String> l = new ArrayList<>();
            l.addAll(Arrays.asList(s));
            im.setLore(l);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }
//                                                          强制替换

    /**
     * 设置Lore
     *
     * @param is 需要设置的物品
     * @param s 按顺序添加至Lore
     * @param b 是否强制替换
     * @return
     */
    public static ItemStack Lore(ItemStack is, String[] s, boolean b) {
        if (is != null) {
            int i = 0;
            for (String st : s) {
                s[i] = ChatColor.translateAlternateColorCodes('&', st);
                i++;
            }
            ItemMeta im = is.getItemMeta();
            if (im.hasLore()) {
                if (b) {
                    List<String> l = new ArrayList<>();
                    l.addAll(Arrays.asList(s));
                    im.setLore(l);
                } else {
                    List<String> l = new ArrayList<>();
                    l.addAll(Arrays.asList(s));
                    im.setLore(l);
                }
            } else {
                List<String> l = new ArrayList<>();
                l.addAll(Arrays.asList(s));
                im.setLore(l);
            }
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

    /**
     * 添加Lore
     * @param is 需要设置的物品
     * @param s 待添加的String
     * @return ItemStack
     */
    public static ItemStack addLore(ItemStack is, String s) {
        if (is != null) {
            s = ChatColor.translateAlternateColorCodes('&', s);
            ItemMeta im = is.getItemMeta();
            List<String> l = im.getLore();
            l.add(s);
            im.setLore(l);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

    /**
     * 移除指定行的Lore
     * @param is 需要移除的物品
     * @param index 行数
     * @return ItemStack
     */
    public static ItemStack removeLore(ItemStack is, int index) {
        if (is != null) {
            ItemMeta im = is.getItemMeta();
            List<String> l = im.getLore();
            l.remove(index);
            im.setLore(l);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

    /**
     * 移除全部的Lore
     * @param is 需要移除的物品
     * @return ItemStack
     */
    public static ItemStack removeAllLore(ItemStack is) {
        if (is != null) {
            ItemMeta im = is.getItemMeta();
            im.setLore(null);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

    /**
     * 为指定行数设置Lore
     * @param is 需要设置的物品
     * @param index 指定的行数
     * @param s 字符串
     * @return ItemStack
     */
    public static ItemStack setLore(ItemStack is, int index, String s) {
        if (is != null) {
            ItemMeta im = is.getItemMeta();
            List<String> l = im.getLore();
            l.set(index, ChatColor.translateAlternateColorCodes('&', s));
            im.setLore(l);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

    /**
     * 替换指定的Lore
     * @param is 需要替换的物品
     * @param old 原Lore
     * @param newString 新Lore
     * @return ItemStack
     */
    public static ItemStack replaceLore(ItemStack is, String old, String newString) {
        ItemMeta im = is.getItemMeta();
        List<String> lore = im.getLore();
        if (!lore.contains(old)) {
            return is;
        }
        while (true) {
            if (!lore.contains(old)) {
                break;
            }
            lore.set(lore.indexOf(old), newString);
        }
        im.setLore(lore);
        is.setItemMeta(im);
        return is;
    }
}
