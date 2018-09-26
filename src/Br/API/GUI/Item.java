/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */

public abstract class Item implements Cloneable {

    public static class ItemBuilder extends Item {

        Function<Player, Boolean> tar = null;
        Function<Player, Boolean> tar_Right = null;
        Function<Player, Boolean> tar_Shift = null;
        Function<Player, Boolean> tar_Shift_R = null;
        Function<Player, Boolean> tar_Shift_L = null;
        Function<Player, Boolean> tar_Drop = null;
        Function<Player, Boolean> tar_Drop_C = null;
        Function<Player, Boolean> tar_Middle = null;
        Function<Player, ItemStack> dis = null;

        ItemBuilder() {
        }

        public ItemBuilder setDisplayMethod(Function<Player, ItemStack> d) {
            this.dis = d;
            return this;
        }

        @Deprecated
        public ItemBuilder setUse(Function<Player, Boolean> p) {
            tar = p;
            return this;
        }

        public ItemBuilder setUse(Consumer<Player> p) {
            return this.setUse((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Right(Function<Player, Boolean> p) {
            tar_Right = p;
            return this;
        }

        public ItemBuilder setUse_Right(Consumer<Player> p) {
            return this.setUse_Right((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Shift(Function<Player, Boolean> p) {
            tar_Shift = p;
            return this;
        }

        public ItemBuilder setUse_Shift(Consumer<Player> p) {
            return this.setUse_Shift((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Shift_Left(Function<Player, Boolean> p) {
            tar_Shift_L = p;
            return this;
        }

        public ItemBuilder setUse_Shift_Left(Consumer<Player> p) {
            return this.setUse_Shift_Left((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Drop(Function<Player, Boolean> p) {
            tar_Drop = p;
            return this;
        }

        public ItemBuilder setUse_Drop(Consumer<Player> p) {
            return this.setUse_Drop((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Middle(Function<Player, Boolean> p) {
            tar_Middle = p;
            return this;
        }

        public ItemBuilder setUse_Middle(Consumer<Player> p) {
            return this.setUse_Middle((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Drop_Ctrl(Function<Player, Boolean> p) {
            tar_Drop_C = p;
            return this;
        }

        public ItemBuilder setUse_Drop_Ctrl(Consumer<Player> p) {
            return this.setUse_Drop_Ctrl((t) -> {
                p.accept(t);
                return true;
            });
        }

        @Deprecated
        public ItemBuilder setUse_Shift_Right(Function<Player, Boolean> p) {
            tar_Shift_R = p;
            return this;
        }

        public ItemBuilder setUse_Shift_Right(Consumer<Player> p) {
            return this.setUse_Shift_Right((t) -> {
                p.accept(t);
                return true;
            });
        }

        public ItemBuilder setUpdate(boolean p) {
            super.update = p;
            return this;
        }

        @Override
        public boolean Use_Middle(Player p) {
            if (this.tar_Middle != null) {
                return this.tar_Middle.apply(p);
            }
            return super.Use_Middle(p);
        }

        @Override
        public boolean Use_Drop(Player p) {
            if (this.tar_Drop != null) {
                return this.tar_Drop.apply(p);
            }
            return super.Use_Drop(p);
        }

        @Override
        public boolean Use_Drop_Ctrl(Player p) {
            if (this.tar_Drop_C != null) {
                return this.tar_Drop_C.apply(p);
            }
            return super.Use_Drop_Ctrl(p);
        }

        @Override
        public boolean Use_Right(Player p) {
            if (tar_Right != null) {
                return tar_Right.apply(p);
            }

            return super.Use_Right(p);
        }

        @Override
        public ItemStack getDisplay(Player p) {
            if (this.dis != null) {
                return this.dis.apply(p);
            }
            return super.getDisplay(p);
        }

        @Override
        public boolean Use_Shift(Player p) {
            if (tar_Shift != null) {
                return tar_Shift.apply(p);
            }
            return super.Use_Shift(p);
        }

        @Override
        public boolean Use_Shift_Left(Player p) {
            if (tar_Shift_L != null) {
                return this.tar_Shift_L.apply(p);
            }
            return super.Use_Shift_Left(p);
        }

        @Override
        public boolean Use_Shift_Right(Player p) {
            if (tar_Shift_R != null) {
                return this.tar_Shift_R.apply(p);
            }
            return super.Use_Shift_Right(p);
        }

        @Override
        public boolean Use(Player p) {
            if (tar != null) {
                return tar.apply(p);
            }
            return true;
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
            this.todo.accept(this);
            return this;
        }

        public ItemBuilder setColddown(int i) {
            super.Colddown = i;
            return this;
        }

        Consumer<ItemBuilder> todo = (t) -> {
        };

        public ItemBuilder doBeforeBuild(Consumer<ItemBuilder> c) {
            todo = todo.andThen(c);
            return this;
        }

        public ItemBuilder Do(Consumer<ItemBuilder> c) {
            c.accept(this);
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
     * 玩家点击之后是更新 前提是keepopen == true
     */
    protected boolean update = true;

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

    public boolean isNeedUpdate() {
        return update;
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

    public String CDMessage(Player p) {
        return "§c你还不能使用这个项目 请稍等后重试";
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

    public boolean Use_Shift_Right(Player p) {
        return this.Use_Shift(p);
    }

    public boolean Use_Shift_Left(Player p) {
        return this.Use_Shift(p);
    }

    /**
     * 玩家对物品按下Q时触发
     *
     * @param p
     * @return
     */
    public boolean Use_Drop(Player p) {
        return this.Use(p);
    }

    /**
     * 玩家按住ctrl时按下Q时触发
     *
     * @param p
     * @return
     */
    public boolean Use_Drop_Ctrl(Player p) {
        return this.Use_Drop(p);
    }

//    public boolean Use_NumberKey(Player p,int num){
//        return this.Use(p);
//    }
    /**
     * 玩家对物品按下中键时触发
     *
     * @param p
     * @return
     */
    public boolean Use_Middle(Player p) {
        return this.Use(p);
    }

    @Override
    @Deprecated
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
        return null;
    }

    public static ItemBuilder getItemBuilder() {
        return new ItemBuilder();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.display);
        hash = 73 * hash + (this.keepopen ? 1 : 0);
        hash = 73 * hash + (this.update ? 1 : 0);
        hash = 73 * hash + this.Colddown;
        hash = 73 * hash + Objects.hashCode(this.LastUseTime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Item other = (Item) obj;
        if (this.keepopen != other.keepopen) {
            return false;
        }
        if (this.update != other.update) {
            return false;
        }
        if (this.Colddown != other.Colddown) {
            return false;
        }
        if (!Objects.equals(this.display, other.display)) {
            return false;
        }
        if (!Objects.equals(this.LastUseTime, other.LastUseTime)) {
            return false;
        }
        return true;
    }

    
    
}
