/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import org.bukkit.inventory.ItemStack;

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
    @Deprecated
    public static ItemStack Lore(ItemStack is, String lore) {
        return Br.API.Lore.Lores.Lore(is, lore);
    }

    /**
     * 设置Lore
     *
     * @param is 需要设置的物品
     * @param s 按顺序添加至Lore
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack Lore(ItemStack is, String[] s) {
        return Br.API.Lore.Lores.Lore(is, s);
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
    @Deprecated
    public static ItemStack Lore(ItemStack is, String[] s, boolean b) {
        return Br.API.Lore.Lores.Lore(is, s, b);
    }

    /**
     * 添加Lore
     *
     * @param is 需要设置的物品
     * @param s 待添加的String
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack addLore(ItemStack is, String s) {
        return Br.API.Lore.Lores.addLore(is, s);
    }

    /**
     * 添加多行Lore
     *
     * @param is 需要设置的物品
     * @param s 待添加的String
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack addLores(ItemStack is, String[] s) {
        return Br.API.Lore.Lores.addLores(is, s);
    }

    /**
     * 移除指定行的Lore
     *
     * @param is 需要移除的物品
     * @param index 行数
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack removeLore(ItemStack is, int index) {
        return Br.API.Lore.Lores.removeLore(is, index);
    }

    /**
     * 移除全部的Lore
     *
     * @param is 需要移除的物品
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack removeAllLore(ItemStack is) {
        return Br.API.Lore.Lores.removeAllLore(is);
    }

    /**
     * 为指定行数设置Lore
     *
     * @param is 需要设置的物品
     * @param index 指定的行数
     * @param s 字符串
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack setLore(ItemStack is, int index, String s) {
        return Br.API.Lore.Lores.setLore(is, index, s);
    }

    /**
     * 替换指定的Lore
     *
     * @param is 需要替换的物品
     * @param old 原Lore
     * @param newString 新Lore
     * @return ItemStack
     */
    @Deprecated
    public static ItemStack replaceLore(ItemStack is, String old, String newString) {
        return Br.API.Lore.Lores.replaceLore(is, old, newString);
    }
}
