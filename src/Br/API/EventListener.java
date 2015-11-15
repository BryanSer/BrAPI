/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class EventListener implements Listener {

    @EventHandler
    public void UseItemEvent(PlayerInteractEvent evt) {
        if (!evt.hasItem()) {
            return;
        }
        ItemStack is = evt.getItem();
        ItemData ID = Data.Traversal(is);
        if (ID == null) {
            return;
        }
        PlayerUseItemEvent PUIE = new PlayerUseItemEvent(ID, evt.getPlayer());
        Bukkit.getPluginManager().callEvent(PUIE);
    }
}
