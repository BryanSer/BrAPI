/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Bryan_lzh
 */
public class Menu implements Cloneable {

    protected String Name;
    protected String DisplayName;
    protected Material OpenItem_Mate;
    protected String Permission = "";
    protected short OpenItem_Dam;
    protected List<Item> Contains = new ArrayList<>();
    protected int Size = 0;
    public static final String SplCode = "§c§a§p§r";

    public static class MenuBuilder extends Menu {

        protected MenuBuilder() {
        }

        @Deprecated
        public MenuBuilder setItem(Item i, int index) {
            if (index >= super.Contains.size()) {
                while (true) {
                    this.addItem(null);
                    if (super.Contains.size() == index + 1) {
                        break;
                    }
                }
            }
            super.Contains.set(index, i);
            return this;
        }

        public MenuBuilder setItem(int index, Item i) {
            if (index >= super.Contains.size()) {
                while (true) {
                    this.addItem(null);
                    if (super.Contains.size() == index + 1) {
                        break;
                    }
                }
            }
            super.Contains.set(index, i);
            return this;
        }

        public MenuBuilder addItem(Item i) {
            super.Contains.add(i);
            return this;
        }

        public MenuBuilder fillItem(Item im, int i) {
            for (int j = 0; j < i; j++) {
                super.Contains.add(im.clone());
            }
            return this;
        }

        /**
         *
         * @param i 菜单的行数
         * @return
         */
        public MenuBuilder setSize(int i) {
            super.Size = i;
            return this;
        }

        public MenuBuilder fillAllWithEmpty() {
            while (true) {
                this.addItem(null);
                if (super.Contains.size() >= super.getSize() * 9) {
                    break;
                }
            }
            return this;
        }

        public MenuBuilder setPermission(String s) {
            super.Permission = s;
            return this;
        }

        public MenuBuilder setOpenItem_Damage(short s) {
            super.OpenItem_Dam = s;
            return this;
        }

        public MenuBuilder setOpenItem_Mate(Material m) {
            super.OpenItem_Mate = m;
            return this;
        }

        public MenuBuilder setName(String s) {
            super.Name = s;
            return this;
        }

        public MenuBuilder setDisplayname(String s) {
            super.DisplayName = s;
            return this;
        }

        public Menu build() {
            this.todo.accept(this);
            if (super.DisplayName == null || super.Name == null || super.Size == 0) {
                throw new NullPointerException("在MenuBuilder没有对该赋值的属性赋值");
            }
            return this;
        }

        private Consumer<MenuBuilder> todo = (t) -> {
        };

        public MenuBuilder doBeforeBuild(Consumer<MenuBuilder> c) {
            todo = this.todo.andThen(c);
            return this;
        }

        public MenuBuilder Do(Consumer<MenuBuilder> c) {
            c.accept(this);
            return this;
        }
    }

    private Menu() {
    }

    public static MenuBuilder getBuilder() {
        MenuBuilder mb = new MenuBuilder();
        mb.OpenItem_Mate = null;
        mb.OpenItem_Dam = (short) 0;
        return mb;
    }

    /**
     *
     * @param name
     * @param displayname
     * @param permission
     * @param openitem
     * @param openitemdam
     * @deprecated 现在推荐采用Builder形式生成Menu
     */
    @Deprecated
    public Menu(String name, String displayname, String permission, Material openitem, short openitemdam) {
        this.Name = name;
        this.DisplayName = displayname;
        this.OpenItem_Mate = openitem;
        this.OpenItem_Dam = openitemdam;
        this.Permission = permission;
    }

    /**
     *
     * @param name
     * @param displayname
     * @param permission
     * @param openitem
     * @param openitemdam
     * @param size
     * @deprecated 现在推荐采用Builder形式生成Menu
     */
    @Deprecated
    public Menu(String name, String displayname, String permission, Material openitem, short openitemdam, int size) {
        this.Name = name;
        this.DisplayName = displayname;
        this.OpenItem_Mate = openitem;
        this.OpenItem_Dam = openitemdam;
        this.Permission = permission;
        this.Size = size;
    }

    @Deprecated
    public Item getClick(int index) {
        if (index >= this.Contains.size()) {
            return null;
        }
        return this.Contains.get(index);
    }
    
    public Item getClick(int index,Player p){
        return this.getClick(index);
    }

    public Inventory getInv(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9 * this.Size, this.DisplayName + SplCode + MenuManager.toCode(this.Name));
        for (int i = 0; i < 9 * this.Size; i++) {
            if (i == this.Contains.size()) {
                break;
            }
            Item item = this.Contains.get(i);
            if (item != null) {
                ItemStack is = item.getDisplay(p);
                if (is != null) {
                    ItemMeta im = is.getItemMeta();
                    im.addItemFlags(ItemFlag.values());
                    is.setItemMeta(im);
                }
                inv.setItem(i, is);
            }
        }
        return inv;
    }

    public boolean canOpen(Player p) {
        if (p.isOp()) {
            return true;
        }
        if (!this.getPermission().isEmpty() && !p.hasPermission(this.Permission)) {
            return false;
        }

        return true;
    }

    public String getName() {
        return Name;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    public String getPermission() {
        return Permission;
    }

    public Material getOpenItem_Mate() {
        return OpenItem_Mate;
    }

    public short getOpenItem_Dam() {
        return OpenItem_Dam;
    }

    public List<Item> getContains() {
        return Contains;
    }

    public int getSize() {
        return Size;
    }

    public static String getSplCode() {
        return SplCode;
    }

    @Override
    public Object clone() {
        Menu m = this;
        try {
            m = (Menu) super.clone();
            m.Contains = new ArrayList<>(m.Contains);
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }

}
