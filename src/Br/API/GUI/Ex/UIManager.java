/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.ClickType;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public class UIManager {

    public static ClickType getSuperClickType(ClickType t) {
        switch (t) {
            case SHIFT_RIGHT:
                return ClickType.SHIFT_LEFT;
            case CONTROL_DROP:
                return ClickType.DROP;
            default:
                return ClickType.LEFT;
        }
    }

    public static String encode(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append('§').append(c);
        }
        return sb.toString();
    }

    public static String decode(String s) {
        return ChatColor.stripColor(s);
    }
}
