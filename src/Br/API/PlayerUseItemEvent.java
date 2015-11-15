/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class PlayerUseItemEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private ItemStack item;
    private Player p;
    private int ID;

    public PlayerUseItemEvent(ItemData ID, Player p) {
        this.item = ID.getItem();
        this.p = p;
        this.ID = ID.getID();
    }

    public ItemStack getItem() {
        return this.item;
    }

    public Player getPlayer() {
        return this.p;
    }

    public void removeItem() {
        if (this.getPlayer().getItemInHand().getAmount() <= 1) {
            this.getPlayer().setItemInHand(null);
        } else {
            ItemStack s = this.getPlayer().getItemInHand();
            s.setAmount(s.getAmount() - 1);
            this.getPlayer().setItemInHand(s);
        }
    }

    public void removeItem(int i) {
        if (i <= 0) {
            return;
        }
        if (this.getPlayer().getItemInHand().getAmount() <= i) {
            this.getPlayer().setItemInHand(null);
        } else {
            ItemStack s = this.getPlayer().getItemInHand();
            s.setAmount(s.getAmount() - i);
            this.getPlayer().setItemInHand(s);
        }
    }

    public void removeAllItem() {
        this.getPlayer().setItemInHand(null);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
