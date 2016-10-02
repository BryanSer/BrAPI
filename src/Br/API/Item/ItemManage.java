/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Item;

import org.bukkit.inventory.ItemStack;

/**
 * 之前类名写错了
 * @author Administrator
 */
@Deprecated
public abstract class ItemManage {

    /**
     * 创建一个新的ItemData<P>
     * 若已存在相同的ItemData将直接返回
     *
     * @param is 传入的物品堆叠
     * @return ItemData
     */
    @Deprecated
    public static ItemData createItem(ItemStack is) {
        return ItemManager.createItem(is);
    }

    /**
     * 通过唯一值来移除某ItemData
     *
     * @param name 唯一值
     */
    @Deprecated
    public static void removeDataByName(String name) {
        ItemManager.removeDataByName(name);
    }

    /**
     * 通过物品堆叠来删除ItemData
     *
     * @param is ItemStack
     */
    @Deprecated
    public static void removeDataByItem(ItemStack is) {
        ItemManager.removeDataByItem(is);
    }

    /**
     * 该物品是否储存过
     *
     * @param s
     * @return
     */
    @Deprecated
    public static boolean hasData(ItemStack s) {
        return ItemManager.hasData(s);
    }

    /**
     * 通过唯一值寻找ItemData
     *
     * @param u
     * @return
     */
    @Deprecated
    public static ItemData getItemByName(String u) {
        return ItemManager.getItemByName(u);
    }

    /**
     * 通过物品堆叠寻找ItemData
     *
     * @param is
     * @return
     */
    @Deprecated
    public static ItemData getItemByItemStack(ItemStack is) {
        return ItemManager.getItemByItemStack(is);
    }
    
}
