/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public abstract class Item {

    /**
     * 显示的物品
     */
    protected ItemStack display = null;

    /**
     * 玩家点击之后是否保持开启界面
     */
    protected boolean keepopen = true;

    /**
     * 物品的冷却时间 单位秒
     */
    protected int Colddown = -1;
    protected Map<String, Long> LastUseTime = new HashMap<>();

    public Item() {
    }

    public Item(boolean keep) {
        keepopen = keep;
    }

    /**
     * 检查一个玩家是否可用这个物品
     *
     * @param p
     * @return
     */
    public boolean checkCD(Player p) {
        if (this.Colddown == -1) {
            return true;
        }
        if (!this.LastUseTime.containsKey(p.getName())) {
            return true;
        }
        long get = this.LastUseTime.get(p.getName());
        return System.currentTimeMillis() - (1000 * this.Colddown) >= get;
    }

    /**
     * 使一个玩家进入CD
     *
     * @param p
     */
    public void CD(Player p) {
        if (this.Colddown != -1) {
            this.LastUseTime.put(p.getName(), System.currentTimeMillis());
        }
    }

    public ItemStack getDisplay(Player p) {
        return display.clone();
    }

    public boolean isKeepopen() {
        return keepopen;
    }

    /**
     * 当一个玩家左键点击之后触发本方法
     *
     * @param p
     * @return 是否成功(true时将会进入CD)
     */
    public abstract boolean Use(Player p);

    public boolean Use_Right(Player p) {
        return this.Use(p);
    }
    
    public boolean Use_Shift(Player p) {
        return this.Use(p);
    }

}
