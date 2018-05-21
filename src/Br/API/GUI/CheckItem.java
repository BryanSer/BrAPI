/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 */
public class CheckItem {

    public CheckItem() {
    }
    public Material m;
    public short s;

    public boolean isItem(ItemStack is) {
        return is.getType() == m && is.getDurability() == s;
    }

}
