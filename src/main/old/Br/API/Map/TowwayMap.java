/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 闲着无聊写的双向Map 虽然本质还是HashMap
 *
 * @author Bryan_lzh
 */
public class TowwayMap<K, V> implements Map<K, V> {

    private Map<K, V> KtoV = new HashMap<>();
    private Map<V, K> VtoK = new HashMap<>();

    @Override
    public int size() {
        return this.KtoV.size();
    }

    @Override
    public boolean isEmpty() {
        return this.KtoV.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.KtoV.containsKey((K) key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.VtoK.containsKey((V) value);
    }

    @Override
    public V get(Object key) {
        return this.KtoV.get((K) key);
    }

    /**
     * 通过V找K
     *
     * @param value
     * @return
     */
    public K getKey(V value) {
        return this.VtoK.get((V) value);
    }

    @Override
    public V put(K key, V value) {
        if (this.KtoV.containsKey(key)) {
            this.VtoK.remove(this.KtoV.get(key));
        }
        this.KtoV.put((K) key, (V) value);
        this.VtoK.put((V) value, (K) key);
        return (V) value;
    }

    @Override
    public V remove(Object key) {
        V v = this.KtoV.remove((K) key);
        this.VtoK.remove(v);
        return v;
    }

    @Override
    public void putAll(Map m) {
        for (Object E : m.entrySet()) {
            if (E instanceof Entry) {
                Entry e = (Entry) E;
                this.KtoV.put((K) e.getKey(), (V) e.getValue());
                this.VtoK.put((V) e.getValue(), (K) e.getKey());
            }
        }
    }

    @Override
    public void clear() {
        this.VtoK.clear();
        this.KtoV.clear();;
    }

    @Override
    public Set<K> keySet() {
        return this.KtoV.keySet();
    }

    @Override
    public Collection<V> values() {
        return this.VtoK.keySet();
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return this.KtoV.entrySet();
    }

}
