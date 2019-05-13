package Br.API.GUI.Ex;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;
import java.util.function.Function;

public interface ExItem {
    boolean getClick(ClickType ct,Player p);

    default boolean getClickLambda(ClickType ct,Player p) {
        boolean t = getClick(ct,p);
        while (!t && ct != ClickType.LEFT) {
            t = getClick(ct, p);
            ct = UIManager.getSuperClickType(ct);
        }
        return t;
    }

    boolean isKeepOpen();

    boolean isUpdateIcon();

    boolean isUpdate();

    ItemStack getDisplayItem(Player p, Snapshot s);

    boolean getButtonPlaceable(Player p);

    ItemStack update(Player p, Snapshot s);
}
