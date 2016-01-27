/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Data {

    public static List<ItemData> ItemDatas= new ArrayList<>();
    public static Main plugin;
    
    
    public static ItemData Traversal(ItemStack is) {
        if (is == null) {
            return null;
        }
        for (ItemData id : Data.ItemDatas) {
            if (id.isSame(is)) {
                return id;
            }
        }
        return null;
    }
    
}
