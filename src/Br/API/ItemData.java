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

    ItemData(ItemStack is, int ID) {
        this.item = is;
        this.ID = ID;
    }

    public ItemStack getItem() {
        return this.item;
    }

    public int getID() {
        return this.ID;
    }

    public boolean isSame(ItemStack i) {
        if (i == null) {
            return false;
        }
        ItemStack is = i;
        is.setAmount(1);
        if (this.getItem().equals(is)) {
            return true;
        }
        return false;
    }
}
