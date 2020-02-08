/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 *
 * @author Bryan_lzh
 */
public class WriteSignEvent extends Event {
    
    private Player pl;
    private String wi;
    private String id;

    public WriteSignEvent(Player p, String write, String id) {
        this.pl = p;
        this.wi = write;
        this.id = id;
    }

    public String getID() {
        return id;
    }

    public Player getPlayer() {
        return pl;
    }

    public String getWrite() {
        return wi;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }
    
}
