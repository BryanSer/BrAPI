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
public class ItemData {

    private ItemStack item;
    private int ID;

    public ItemData(ItemStack is, int ID) {
        this.item = is;
        this.ID = ID;
    }

    /**
     * 返回物品
     * @return 物品
     */
    public ItemStack getItem() {
        return this.item;
    }

    /**
     * 返回识别ID 
     * @return 识别ID 
     */
    public int getID() {
        return this.ID;
    }

    /**
     * 是否与另一个ItemStack相同(不考虑数量)
     * @param i ItemStack
     * @return 布尔值
     */
    public boolean isSame(ItemStack i) {
        if (i == null) {
            return false;
        }
        ItemStack is = i.clone();
        is.setAmount(1);
        if (this.getItem().isSimilar(is)) {
            return true;
        }
        return false;
    }
}
