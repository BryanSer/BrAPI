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
public abstract class Item implements Cloneable {

    @FunctionalInterface
    public interface Useable {

        public boolean Use(Player p);
    }

    @FunctionalInterface
    public interface Display {

        public ItemStack getDisplay(Player p);
    }

    public static class ItemBuilder extends Item {

        Useable tar = null;
        Useable tar_Right = null;
        Useable tar_Shift = null;
        Display dis = null;

        ItemBuilder() {
        }

        public ItemBuilder setDisplayMethod(Display d) {
            this.dis = d;
            return this;
        }

        public ItemBuilder setUse(Useable p) {
            tar = p;
            return this;
        }

        public ItemBuilder setUse_Right(Useable p) {
            tar_Right = p;
            return this;
        }

        public ItemBuilder setUse_Shift(Useable p) {
            tar_Shift = p;
            return this;
        }

        @Override
        public boolean Use_Right(Player p) {
            if (tar_Right != null) {
                return tar_Right.Use(p);
            }

            return super.Use_Right(p);
        }

        @Override
        public ItemStack getDisplay(Player p) {
            if (this.dis != null) {
                return this.dis.getDisplay(p);
            }
            return super.getDisplay(p); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean Use_Shift(Player p) {
            if (tar_Shift != null) {
                return tar_Shift.Use(p);
            }
            return super.Use_Shift(p);
        }

        @Override
        public boolean Use(Player p) {
            if (tar != null) {
                return tar.Use(p);
            }
            throw new UnsupportedOperationException("未指定Use方法");
        }

        public ItemBuilder setKeepOpen(boolean b) {
            super.keepopen = b;
            return this;
        }

        public ItemBuilder setDisplay(ItemStack is) {
            super.display = is;
            return this;
        }

        public Item build() {
            return this;
        }

        public ItemBuilder setColddown(int i) {
            super.Colddown = i;
            return this;
        }

    }

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

    @Override
    protected Item clone() {
        try {
            Item i = (Item) super.clone();
            i.display = this.display.clone();
            i.LastUseTime = new HashMap<>();
            for (Map.Entry<String, Long> e : this.LastUseTime.entrySet()) {
                i.LastUseTime.put(e.getKey(), e.getValue());
            }
            return i;
        } catch (CloneNotSupportedException ex) {
        }
        return Item
                .getItemBuilder()
                .setUse((p) -> {
                    return this.Use(p);
                })
                .setColddown(this.Colddown)
                .setDisplay(this.display.clone())
                .setKeepOpen(this.keepopen)
                .setUse_Right((p) -> {
                    return this.Use_Right(p);
                })
                .setUse_Shift((p) -> {
                    return this.Use_Shift(p);
                })
                .setDisplayMethod((p) -> {
                    return this.getDisplay(p);
                })
                .build();
    }

    public static ItemBuilder getItemBuilder() {
        return new ItemBuilder();
    }

}
