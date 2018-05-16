/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public class Item {

    /**
     * 玩家点击之后是否保持开启界面
     */
    protected boolean KeepOpen = true;

    /**
     * 玩家点击之后是更新 前提是keepopen == true
     */
    protected boolean Update = true;

    /**
     * 按钮的回调函数 返回true时表示点击事件不取消 (也就是可以移动物品)
     */
    protected Function<Player, Boolean> ButtonCellback = p -> true;

    /**
     * 显示物品用
     */
    protected Function<Player, ItemStack> DisplayLambda;

    /**
     * 全部的点击事件储存于此
     */
    protected Map<ClickType, Consumer<Player>> ClickLambdas = new EnumMap<>(ClickType.class);

    protected Item() {
    }

    public static Item getNewInstance(Function<Player, ItemStack> display) {
        return new Item().setDisplay(display);
    }

    public Consumer<Player> getClickLambda(ClickType ct) {
        Consumer<Player> c = ClickLambdas.get(ct);
        while (c == null && ct != ClickType.LEFT) {
            c = ClickLambdas.get(ct);
            ct = UIManager.getSuperClickType(ct);
        }
        return c;
    }

    public boolean isKeepOpen() {
        return KeepOpen;
    }

    public boolean isUpdate() {
        return Update;
    }

    public ItemStack getDisplayItem(Player p) {
        return this.DisplayLambda.apply(p);
    }

    public Item setDisplay(Function<Player, ItemStack> f) {
        this.DisplayLambda = f;
        return this;
    }

    public Function<Player, Boolean> getButtonCellback() {
        return ButtonCellback;
    }

    public Function<Player, ItemStack> getDisplayLambda() {
        return DisplayLambda;
    }

    public Item setKeepOpen(boolean ko) {
        this.KeepOpen = ko;
        return this;
    }

    public Item setUpdate(boolean u) {
        this.Update = u;
        return this;
    }

    public Item setButtonCellback(Function<Player, Boolean> b) {
        this.ButtonCellback = b;
        return this;
    }

    public Item setClick(ClickType ct, Consumer<Player> c) {
        this.ClickLambdas.put(ct, c);
        return this;
    }

}
