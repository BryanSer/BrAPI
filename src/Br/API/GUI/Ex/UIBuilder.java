/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.bukkit.entity.Player;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 * @deprecated 已托管给旧UI操作
 */
@Deprecated
public class UIBuilder extends BaseUI {

    protected List<Item> Contains = new ArrayList<>();
    protected SnapshotFactory Factory;

    public UIBuilder(String name, String displayname, int row) {
        super.Name = name;
        super.DisplayName = displayname;
        super.Rows = row;
        Factory = SnapshotFactory.getDefaultSnapshotFactory(this);
    }

    public UIBuilder(String name, String displayname, int row, SnapshotFactory sf) {
        super.Name = name;
        super.DisplayName = displayname;
        super.Rows = row;
        Factory = sf;
    }

    @Override
    public Item getItem(Player p, int slot) {
        return Contains.get(slot);
    }

    @Override
    public SnapshotFactory getSnapshotFactory() {
        return Factory;
    }

    public UIBuilder setItem(int index, Item i) {
        if (index >= this.Contains.size()) {
            while (true) {
                this.addItem(null);
                if (this.Contains.size() == index + 1) {
                    break;
                }
            }
        }
        this.Contains.set(index, i);
        return this;
    }

    public UIBuilder addItem(Item i) {
        this.Contains.add(i);
        return this;
    }

    public UIBuilder fillItem(Item im, int i) {
        for (int j = 0; j < i; j++) {
            this.Contains.add(im);
        }
        return this;
    }

    public UIBuilder fillAllWithEmpty() {
        while (true) {
            this.addItem(null);
            if (this.Contains.size() >= super.getSize() * 9) {
                break;
            }
        }
        return this;
    }

    public UIBuilder Do(Consumer<UIBuilder> c) {
        c.accept(this);
        return this;
    }

    public BaseUI build() {
        return this;
    }

}
