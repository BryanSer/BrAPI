/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bryan_lzh
 */
public abstract class PluginData {
    

    public static List<ItemInfo> ItemDatas = new ArrayList<>();
    public static JavaPlugin plugin;
    
    public static ItemInfo traversal(ItemStack is) {
        if (is == null) {
            return null;
        }
        for (ItemInfo id : PluginData.ItemDatas) {
            if (id.isSame(is)) {
                return id;
            }
        }
        return null;
    }
    
}
