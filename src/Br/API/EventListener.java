/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class EventListener implements Listener {

    static boolean Reg = true;

    @EventHandler
    public void onJoin(PlayerJoinEvent evt) {
        if (Reg) {
            Reg = false;
            Main.RegisterMetrics();

        }
    }

}
