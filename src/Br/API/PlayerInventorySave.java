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
@Deprecated
public abstract class PlayerInventorySave {

    @Deprecated
    protected static HashMap<String, PlayerInventory> PI = new HashMap<>();

    /**
     * 是否已经储存了这个玩家
     *
     * @param p 玩家
     * @param pn 注册插件
     * @return 布尔值
     */
    @Deprecated
    public static boolean hasSaved(Player p, Plugin pn) {
        return PlayerInventorySave.PI.containsKey(pn.getName() + p.getName());
    }

    /**
     * 保存一个玩家
     *
     * @param p 玩家
     * @param pn 注册插件
     */
    @Deprecated
    public static void SavePlayerInventory(Player p, Plugin pn) {
        PlayerInventorySave.PI.put(pn.getName() + p.getName(), p.getInventory());
    }

    /**
     * 返回已储存的一个玩家背包
     *
     * @param p 玩家
     * @param pn 插件
     * @return PlayerInventory
     */
    @Deprecated
    public static PlayerInventory getPlayerInventory(Player p, Plugin pn) {
        if (PlayerInventorySave.hasSaved(p, pn)) {
            return PlayerInventorySave.PI.get(pn.getName() + p.getName());
        } else {
            return null;
        }
    }

    /**
     * 移除一个玩家的背包
     *
     * @param p 玩家
     * @param pn 插件
     */
    @Deprecated
    public static void remove(Player p, Plugin pn) {
        PlayerInventorySave.PI.remove(pn.getName() + p.getName());
    }

    /**
     * 移除某个插件储存的所有背包
     *
     * @param pn 插件
     */
    @Deprecated
    public static void removeAll(Plugin pn) {
        for (String n : PlayerInventorySave.PI.keySet()) {
            if (n.contains(pn.getName())) {
                PlayerInventorySave.PI.remove(n);
            }
        }
    }

    /**
     * 移除全部
     */
    @Deprecated
    public static void removeAll() {
        PlayerInventorySave.PI.clear();
    }
}
