/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Map;

import java.util.HashMap;
import java.util.Map;
import org.bukkit.entity.Player;

/**
 *
 * @author Bryan_lzh
 */
public class PlayerMap<V> extends HashMap<String, V> {

    public PlayerMap(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public PlayerMap(int initialCapacity) {
        super(initialCapacity);
    }

    public PlayerMap(Map<Player, ? extends V> m) {
        Map<String, ? extends V> r = new HashMap<>();
    }

    public V get(Player key) {
        return super.get(key.getName());
    }

    public V put(Player key, V value) {
        return super.put(key.getName(), value);
    }

    public V remove(Player key) {
        return super.remove(key.getName());
    }

}
