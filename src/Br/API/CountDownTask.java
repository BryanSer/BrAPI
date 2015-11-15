/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API;

import java.util.Date;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 *
 * @author Bryan_lzh
 */
public class CountDownTask extends BukkitRunnable {

    private long tick;
    private long ID;
    private Player P;
    private int type;

    public long getTick() {
        return this.tick;
    }

    public long getID() {
        return this.ID;
    }

    public Player getPlayer() {
        return this.P;
    }

    public boolean hasPlayer() {
        if (this.P != null) {
            return true;
        } else {
            return false;
        }
    }

    public CountDownTask(long id, Player p, long time) {
        this.ID = id;
        this.P = p;
        this.tick = time;
        this.type = 3;
    }

    public CountDownTask(long id, long time) {
        this.ID = id;
        this.tick = time;
        this.type = 2;
        this.P = null;
    }

    public CountDownTask(Player p, long time) {
        this.P = p;
        this.tick = time;
        this.type = 1;
    }

    public CountDownTask(long time) {
        this.ID = new Date().getTime();
        this.tick = time;
        this.type = 2;
        this.P = null;
    }

    @Override
    public void run() {
        if (this.tick < 1) {
            switch (this.type) {
                case 1:
                    Bukkit.getPluginManager().callEvent(new CountDounEvent(this.P));
                    break;
                case 2:
                    Bukkit.getPluginManager().callEvent(new CountDounEvent(this.ID));
                    break;
                case 3:
                    Bukkit.getPluginManager().callEvent(new CountDounEvent(this.P, this.ID));
                    break;
            }
            this.cancel();
        }
        this.tick--;
    }
}
