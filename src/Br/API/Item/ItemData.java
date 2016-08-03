/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Item;

import java.util.Map.Entry;
import java.util.Objects;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class ItemData {

    private String UniqueID;
    private ItemStack ItemStack;

    public ItemData(String u, ItemStack i) {
        this.UniqueID = u;
        this.ItemStack = i;
        /*   if (ItemManage.ItemDatas.containsValue(this)) {
            for (Entry<String, ItemData> E : ItemManage.ItemDatas.entrySet()) {
                if (E.getValue().equals(this)) {
                    this.UniqueID = E.getKey();
                    return;
                }
            }
        }*/
      //  ItemManage.ItemDatas.put(u, this);
    }

    public String getUniqueID() {
        return this.UniqueID;
    }

    public ItemStack getItemStack() {
        return this.ItemStack.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ItemData)) {
            return false;
        }
        if (o.hashCode() == this.hashCode()) {
            return true;
        }
        return ((ItemData) o).equals(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.ItemStack);
        return hash;
    }
}
