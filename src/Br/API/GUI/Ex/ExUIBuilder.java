/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import Br.API.ItemBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 * @since 2018-11-27
 */
public class ExUIBuilder {

    private String[] shape;
    private Map<Character, Item> items = new HashMap<>();
    private String name;
    private String displayName;
    private boolean allowShift = false;
    private SnapshotFactory snapshotFactory;
    private BiConsumer<Player, Snapshot> onClose = (p, s) -> {
    };
    
    public int find(char c){
        for (int i = 0; i < shape.length; i++) {
            String s = shape[i];
            for (int j = 0; j < s.toCharArray().length; j++) {
                char d = s.toCharArray()[j];
                if(d == c){
                    return i * 9 + j;
                }
            }
        }
        return -1;
    }

    public void build() {
        if (this.name == null) {
            throw new IllegalArgumentException("UI名不能为空");
        }
        if (this.displayName == null) {
            throw new IllegalArgumentException("UI显示名不能为空");
        }
        if (this.shape == null) {
            throw new IllegalArgumentException("UI外形不能为空");
        }
        BaseUI ui = new BaseUI() {
            SnapshotFactory snapshotFactory;

            {
                super.AllowShift = allowShift;
                super.Name = name;
                super.DisplayName = displayName;
                super.Rows = shape.length;

                if (ExUIBuilder.this.snapshotFactory == null) {
                    snapshotFactory = SnapshotFactory.getDefaultSnapshotFactory(this);
                } else {
                    snapshotFactory = ExUIBuilder.this.snapshotFactory;
                }
            }
            Item[] contains = new Item[super.Rows * 9];

            {
                for (int i = 0; i < shape.length; i++) {
                    String sh = shape[i];
                    for (int j = 0; j < sh.toCharArray().length && j < 9; j++) {
                        char c = sh.toCharArray()[j];
                        if (c == ' ') {
                            continue;
                        }
                        Item item = items.get(c);
                        contains[i * 9 + j] = item;
                    }
                }
            }

            @Override
            public Item getItem(Player p, int slot) {
                return contains[slot];
            }

            @Override
            public SnapshotFactory getSnapshotFactory() {
                return snapshotFactory;
            }

            @Override
            public void onClose(Player p, Snapshot s) {
                onClose.accept(p, s);
            }
            
        };
        UIManager.RegisterUI(ui);
    }

    private ExUIBuilder() {
    }

    public ExUIBuilder(SnapshotFactory snapshotFactory) {
        this.snapshotFactory = snapshotFactory;
    }

    public ExUIBuilder shape(String... shape) {
        if (shape.length == 0 || shape.length > 6) {
            throw new IllegalArgumentException("UI外形行数必须在[1,6]");
        }
        this.shape = shape;
        return this;
    }

    public ExUIBuilder item(char target, Item i) {
        items.put(target, i);
        return this;
    }

    public ExUIBuilder shift(boolean allowShift) {
        this.allowShift = allowShift;
        return this;
    }

    public ExUIBuilder name(String name) {
        this.name = name;
        return this;
    }

    public ExUIBuilder displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public ExUIBuilder item(char target, ItemStack i) {
        items.put(target, Item.getNewInstance(i));
        return this;
    }

    public ExUIBuilder item(char target, ItemBuilder i) {
        items.put(target, Item.getNewInstance(i.build()));
        return this;
    }

    public ExUIBuilder onClose(BiConsumer<Player, Snapshot> oc) {
        this.onClose = oc;
        return this;
    }

    public static ExUIBuilder create() {
        return new ExUIBuilder();
    }

    public static ExUIBuilder create(SnapshotFactory snapshotFactory) {
        return new ExUIBuilder(snapshotFactory);
    }

}
