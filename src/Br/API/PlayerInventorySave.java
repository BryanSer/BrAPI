/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 */
public abstract class PlayerInventorySave {

    protected static HashMap<String, PlayerInventory> PI = new HashMap<>();

    public static boolean hasSaved(Player p, Plugin pn) {
        return PlayerInventorySave.PI.containsKey(pn.getName() + p.getName());
    }

    public static void SavePlayerInventory(Player p, Plugin pn) {
        PlayerInventorySave.PI.put(pn.getName() + p.getName(), p.getInventory());
    }

    public static PlayerInventory getPlayerInventory(Player p, Plugin pn) {
        if (PlayerInventorySave.hasSaved(p, pn)) {
            return PlayerInventorySave.PI.get(pn.getName() + p.getName());
        } else {
            return null;
        }
    }
    
    public static void remove(Player p, Plugin pn){
        PlayerInventorySave.PI.remove(pn.getName() + p.getName());
    }

    public static void removeAll(Plugin pn) {
        for (String n : PlayerInventorySave.PI.keySet()) {
            if (n.contains(pn.getName())) {
                PlayerInventorySave.PI.remove(n);
            }
        }
    }
    
    public static void removeAll(){
        PlayerInventorySave.PI = new HashMap<>();
    }
}
