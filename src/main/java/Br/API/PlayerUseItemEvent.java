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
    private ItemInfo II;

    public PlayerUseItemEvent(ItemInfo ID, Player p) {
        this.item = ID.getItem();
        this.p = p;
        this.II = ID;
    }

    public ItemInfo getItemInfo() {
        return this.II;
    }

    /**
     * 返回使用的物品
     *
     * @return
     */
    public ItemStack getItem() {
        return this.item;
    }

    /**
     * 返回玩家
     *
     * @return
     */
    public Player getPlayer() {
        return this.p;
    }

    /**
     * 移除一个物品
     */
    public void removeItem() {
        ItemStack is = this.getPlayer().getItemInHand().clone();
        if (is.getAmount() == 0) {
            this.getPlayer().setItemInHand(null);
        } else {
            is.setAmount(is.getAmount() - 1);
            this.getPlayer().setItemInHand(is);
        }
    }

    /**
     * 移除指定数量的物品
     *
     * @param i 数量
     */
    public void removeItem(int i) {
        ItemStack is = this.getPlayer().getItemInHand().clone();
        if (is.getAmount() <= i) {
            this.getPlayer().setItemInHand(null);
        } else {
            is.setAmount(is.getAmount() - i);
            this.getPlayer().setItemInHand(is);
        }
    }

    /**
     * 移除所有这个物品
     */
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
