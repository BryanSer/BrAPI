/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Utils {

    public static ItemData RegisterUseItemEvent(ItemStack is) {
        if (is == null) {
            return null;
        }
        is.setAmount(1);
        int size = Data.ItemDatas.size();
        ItemData ID = new ItemData(is, size + 1);
        Data.ItemDatas.add(ID);
        return ID;
    }
    
    public static void UnregisterUseItemEvent(ItemData ID){
        if(Data.ItemDatas.contains(ID)){
            Data.ItemDatas.remove(ID);
        }
    }

    public static CountDownTask CreateCountDown(long tick) {
        CountDownTask cdt = new CountDownTask(tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }

    public static CountDownTask CreateCountDown(Player p, long tick) {
        CountDownTask cdt = new CountDownTask(p, tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }

    public static CountDownTask CreateCountDown(long id, long tick) {
        CountDownTask cdt = new CountDownTask(id, tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }

    public static CountDownTask CreateCountDown(long id, Player p, long tick) {
        CountDownTask cdt = new CountDownTask(id, p, tick);
        cdt.runTaskTimer(Data.plugin, 0l, tick);
        return cdt;
    }
}
