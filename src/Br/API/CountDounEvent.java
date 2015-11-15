/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.Date;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Bryan_lzh
 */
public class CountDounEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private long ID;
    private Player P;

    public CountDounEvent(Player p) {
        ID = new Date().getTime();
        P = p;
    }

    public CountDounEvent(long id) {
        ID = id;
        P = null;
    }

    public CountDounEvent(Player p, long id) {
        this.ID = id;
        this.P = p;
    }

    public long getID() {
        return this.ID;
    }

    public Player getPlayer() {
        return this.P;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
