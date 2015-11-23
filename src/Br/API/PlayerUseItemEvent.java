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
        if (this.getPlayer().getItemInHand().getAmount() > 1) {
            this.getPlayer().getItemInHand().setAmount(p.getItemInHand().getAmount() - 1);
        } else {
            ItemStack is = new ItemStack(this.item);
            is.setAmount(1);
            this.getPlayer().getInventory().remove(is);
            is=null;
        }
    }

    public void removeItem(int i) {
        if (i <= 0) {
            return;
        }
        if (this.getPlayer().getItemInHand().getAmount() > i) {
            this.getPlayer().getItemInHand().setAmount(p.getItemInHand().getAmount() - i);
        } else {
            ItemStack is = new ItemStack(this.item);
            is.setAmount(i);
            this.getPlayer().getInventory().remove(is);
            is=null;
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
