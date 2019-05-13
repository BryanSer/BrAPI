/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import org.bukkit.entity.Player;


/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public abstract class BaseUI {

    protected String Name;
    protected String DisplayName;
    protected int Rows = 6;
    protected boolean AllowShift = false;

    /**
     *
     * @return UI名
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @return UI的显示名
     */
    public String getDisplayName() {
        return DisplayName;
    }

    /**
     *
     * @return UI的行数
     */
    public int getRows() {
        return Rows;
    }

    /**
     * 获取某个位置的物品
     *
     * @param p 打开UI的玩家
     * @param slot 位置
     * @return Item
     */
    public abstract ExItem getItem(Player p, int slot);

    /**
     *
     * @return UI总物品数
     */
    public int getSize() {
        return this.Rows * 9;
    }

    /**
     * 警告 每次调用这个方法必须返回同一个对象
     *
     * @return 一个快照生成器
     */
    public abstract SnapshotFactory getSnapshotFactory();

    /**
     *
     * @param p 玩家
     * @return 这个玩家当前的UI快照
     */
    public Snapshot getSnapshot(Player p) {
        return getSnapshotFactory().getSnapshot(p);
    }

    public boolean isAllowShift() {
        return AllowShift;
    }

    public void onClose(Player p, Snapshot s) {
    }
}
