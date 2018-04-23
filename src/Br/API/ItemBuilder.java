/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.Artifice.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public class ItemBuilder {

    private ItemBuilder() {
    }

    private ItemStack Item;
    private Consumer<ItemBuilder> Do = (is) -> {
    };

    public ItemBuilder type(Material m) {
        if(this.Item == null){
            this.Item = new ItemStack(m);
            return this;
        }
        this.Item.setType(m);
        return this;
    }

    public ItemBuilder name(String name) {
        ItemMeta im = this.Item.getItemMeta();
        im.setDisplayName(name);
        this.Item.setItemMeta(im);
        return this;
    }

    public ItemBuilder ammount(int a) {
        this.Item.setAmount(a);
        return this;
    }

    public ItemBuilder durability(short s) {
        this.Item.setDurability(s);
        return this;
    }

    public ItemBuilder lore(String... s) {
        ItemMeta im = this.Item.getItemMeta();
        List<String> lore = im.hasLore() ? im.getLore() : new ArrayList<>();
        lore.addAll(Arrays.asList(s));
        im.setLore(lore);
        this.Item.setItemMeta(im);
        return this;
    }

    public ItemBuilder Do(Consumer<ItemBuilder> what) {
        this.Do.andThen(what);
        return this;
    }

    public ItemStack build() {
        this.Do.accept(this);
        return this.Item;
    }

    public static ItemBuilder getBuilder(Material type) {
        ItemBuilder ib = new ItemBuilder();
        ib.type(type);
        return ib;
    }
}
