/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Lores {

    public static ItemStack Lore(ItemStack is, String lore) {
        if (is != null) {
            List<String> LoreList = new ArrayList<>();
            if (lore.indexOf("|") != -1) {
                        String lores[] = lore.split("\\|");
                        int o = 0;
                        for (String os : lores) {
                            lores[o] = lores[o].replaceAll("_", " ");
                            lores[o] = org.bukkit.ChatColor.translateAlternateColorCodes('&', lores[o]);
                            o++;
                        }
                        LoreList.addAll(Arrays.asList(lores));
                    } else {
                        lore = lore.replaceAll("_", " ");
                        lore = org.bukkit.ChatColor.translateAlternateColorCodes('&', lore);
                        LoreList.addAll(Arrays.asList(lore));
                    }
            ItemMeta im = is.getItemMeta();
            im.setLore(LoreList);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

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
                    return is;
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

    public static ItemStack removeAllLore(ItemStack is) {
        if (is != null) {
            ItemMeta im = is.getItemMeta();
            im.setLore(null);
            is.setItemMeta(im);
            return is;
        }
        return null;
    }

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
}
