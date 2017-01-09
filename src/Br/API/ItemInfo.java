/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import Br.API.Item.ItemManager;
import java.util.Objects;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class ItemInfo {

    private ItemStack item;
    private int ID;

    public ItemInfo(ItemStack is, int ID) {
        this.item = is;
        this.ID = ID;
    }

    /**
     * 返回物品
     *
     * @return 物品
     */
    public ItemStack getItem() {
        return this.item;
    }

    /**
     * 返回识别ID
     *
     * @return 识别ID
     */
    public int getID() {
        return this.ID;
    }

    /**
     * 是否与另一个ItemStack相同(不考虑数量)
     *
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

    public Br.API.Item.ItemData toItemData() {
        return ItemManager.createItem(item);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ItemInfo)) {
            return false;
        }
        ItemInfo ii = (ItemInfo) obj;
        if (obj.hashCode() == this.hashCode() && ii.ID == this.ID) {
            return true;
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.item);
        hash = 79 * hash + this.ID;
        return hash;
    }

}
