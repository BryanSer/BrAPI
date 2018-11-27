/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.GUI.Ex;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public abstract class SnapshotFactory<T extends BaseUI> {

    protected Map<String, Snapshot<T>> LastSnapshot = new ConcurrentHashMap<>();

    protected SnapshotFactory(String name) {
    }

    protected SnapshotFactory() {
    }

    protected abstract Snapshot<T> createSnapshot(Player p, T ui);

    public void deleteSanpshop(Player p) {
        Snapshot<T> v = LastSnapshot.remove(p.getName());
        if (v != null) {
            v.Delete();
        }
    }

    public Snapshot<T> getNewSnapshot(Player p, T ui) {
        Snapshot<T> s = createSnapshot(p, ui);
        Snapshot<T> v = LastSnapshot.put(p.getName(), s);
        if (v != null) {
            v.Delete();
        }
        return s;
    }

    public Snapshot<T> getSnapshot(Player p) {
        return LastSnapshot.get(p.getName());
    }

    public static <T extends BaseUI> SnapshotFactory<T> getDefaultSnapshotFactory(T ui) {
        return new SnapshotFactory<T>(ui.getName()) {
            @Override
            protected Snapshot<T> createSnapshot(Player p, T ui) {
                Item[] items = new Item[ui.getSize()];
                for (int i = 0; i < ui.getSize(); i++) {
                    items[i] = ui.getItem(p, i);
                }
                return new Snapshot<T>() {
                    private Map<String, Object> data = new HashMap<>();

                    @Override
                    public String getPlayerName() {
                        return p.getName();
                    }

                    @Override
                    public void Delete() {
                        data = null;
                        inv = null;
                    }

                    @Override
                    public Item[] getContains() {
                        return items;
                    }

                    @Override
                    public T getUI() {
                        return ui;
                    }

                    @Override
                    public Item getItem(int solt) {
                        return items[solt];
                    }

                    @Override
                    public void setData(String key, Object value) {
                        data.put(key, value);
                    }

                    @Override
                    public Object getData(String key) {
                        return data.get(key);
                    }

                    @Override
                    public void removeData(String key) {
                        data.remove(key);
                    }

                    private Inventory inv;

                    @Override
                    public Inventory getInventory() {
                        return inv;
                    }

                    @Override
                    public void setInventory(Inventory inv) {
                        this.inv = inv;
                    }
                };
            }
        };
    }
    public static <T extends BaseUI> SnapshotFactory<T> getDefaultSnapshotFactory() {
        return new SnapshotFactory<T>() {
            @Override
            protected Snapshot<T> createSnapshot(Player p, T ui) {
                Item[] items = new Item[ui.getSize()];
                for (int i = 0; i < ui.getSize(); i++) {
                    items[i] = ui.getItem(p, i);
                }
                return new Snapshot<T>() {
                    private Map<String, Object> data = new HashMap<>();

                    @Override
                    public String getPlayerName() {
                        return p.getName();
                    }

                    @Override
                    public void Delete() {
                        data = null;
                        inv = null;
                    }

                    @Override
                    public Item[] getContains() {
                        return items;
                    }

                    @Override
                    public T getUI() {
                        return ui;
                    }

                    @Override
                    public Item getItem(int solt) {
                        return items[solt];
                    }

                    @Override
                    public void setData(String key, Object value) {
                        data.put(key, value);
                    }

                    @Override
                    public Object getData(String key) {
                        return data.get(key);
                    }

                    @Override
                    public void removeData(String key) {
                        data.remove(key);
                    }

                    private Inventory inv;

                    @Override
                    public Inventory getInventory() {
                        return inv;
                    }

                    @Override
                    public void setInventory(Inventory inv) {
                        this.inv = inv;
                    }
                };
            }
        };
    }

    public static <T extends BaseUI> SnapshotFactory<T> getDefaultSnapshotFactory(T ui, BiConsumer<Player, Map<String, Object>> oncreate) {
        return new SnapshotFactory<T>(ui.getName()) {
            @Override
            protected Snapshot<T> createSnapshot(Player p, T ui) {
                Item[] items = new Item[ui.getSize()];
                for (int i = 0; i < ui.getSize(); i++) {
                    items[i] = ui.getItem(p, i);
                }
                return new Snapshot<T>() {
                    private Map<String, Object> data = new HashMap<>();

                    {
                        if (oncreate != null) {
                            oncreate.accept(p, data);
                        }
                    }

                    @Override
                    public String getPlayerName() {
                        return p.getName();
                    }

                    @Override
                    public void Delete() {
                        data = null;
                        inv = null;
                    }

                    @Override
                    public Item[] getContains() {
                        return items;
                    }

                    @Override
                    public T getUI() {
                        return ui;
                    }

                    @Override
                    public Item getItem(int solt) {
                        return items[solt];
                    }

                    @Override
                    public void setData(String key, Object value) {
                        data.put(key, value);
                    }

                    @Override
                    public Object getData(String key) {
                        return data.get(key);
                    }

                    @Override
                    public void removeData(String key) {
                        data.remove(key);
                    }

                    private Inventory inv;

                    @Override
                    public Inventory getInventory() {
                        return inv;
                    }

                    @Override
                    public void setInventory(Inventory inv) {
                        this.inv = inv;
                    }
                };
            }
        };
    }
    public static <T extends BaseUI> SnapshotFactory<T> getDefaultSnapshotFactory(BiConsumer<Player, Map<String, Object>> oncreate) {
        return new SnapshotFactory<T>() {
            @Override
            protected Snapshot<T> createSnapshot(Player p, T ui) {
                Item[] items = new Item[ui.getSize()];
                for (int i = 0; i < ui.getSize(); i++) {
                    items[i] = ui.getItem(p, i);
                }
                return new Snapshot<T>() {
                    private Map<String, Object> data = new HashMap<>();

                    {
                        if (oncreate != null) {
                            oncreate.accept(p, data);
                        }
                    }

                    @Override
                    public String getPlayerName() {
                        return p.getName();
                    }

                    @Override
                    public void Delete() {
                        data = null;
                        inv = null;
                    }

                    @Override
                    public Item[] getContains() {
                        return items;
                    }

                    @Override
                    public T getUI() {
                        return ui;
                    }

                    @Override
                    public Item getItem(int solt) {
                        return items[solt];
                    }

                    @Override
                    public void setData(String key, Object value) {
                        data.put(key, value);
                    }

                    @Override
                    public Object getData(String key) {
                        return data.get(key);
                    }

                    @Override
                    public void removeData(String key) {
                        data.remove(key);
                    }

                    private Inventory inv;

                    @Override
                    public Inventory getInventory() {
                        return inv;
                    }

                    @Override
                    public void setInventory(Inventory inv) {
                        this.inv = inv;
                    }
                };
            }
        };
    }

}
