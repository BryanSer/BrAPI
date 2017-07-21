/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author Bryan_lzh
 */
public class Menu {

    protected String Name;
    protected String DisplayName;
    protected Material OpenItem_Mate;
    protected String Permission;
    protected short OpenItem_Dam;
    protected List<Item> Contains = new ArrayList<>();
    protected int Size;
    public static final String SplCode = "§c§a§p§i§b§r§s§p§r";

    public Menu(String name, String displayname,String permission, Material openitem, short openitemdam) {
        this.Name = name;
        this.DisplayName = displayname;
        this.OpenItem_Mate = openitem;
        this.OpenItem_Dam = openitemdam;
        this.Permission = permission;
    }

    public Item getClick(int index) {
        return this.Contains.get(index);
    }

    public Inventory getInv(Player p) {
        Inventory inv = Bukkit.createInventory(p, 9 * this.Size, this.DisplayName + SplCode + MenuManager.toCode(this.Name));
        for (int i = 0; i < 9 * this.Size; i++) {
            Item item = this.Contains.get(i);
            if (item != null) {
                inv.setItem(i, item.getDisplay(p));
            }
        }
        return inv;
    }
    
    public boolean canOpen(Player p) {
        if (p.isOp()) {
            return true;
        }
        if (!this.getPermission().isEmpty()) {
            if (!p.hasPermission(this.Permission)) {
                return false;
            }
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


}
