/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Administrator
 * @param <K>
 * @param <V>
 * @deprecated 年轻的时候不知道SortedMap
 */
@Deprecated
public class SortableMap<K, V extends Comparable> implements Map<K, V> {

    LinkedHashMap<K, V> map = new LinkedHashMap<>();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public V get(Object key) {
        return map.get(key);
    }

    public V put(K key, V value) {
        return map.put(key, value);
    }

    @Override
    public V remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();;
    }

    @Override
    public Set keySet() {
        return map.keySet();
    }

    @Override
    public Collection values() {
        return map.values();
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    /**
     * 返回排序的结果
     *
     * @return
     */
    public Map<K, V> sortMapByValue() {
        LinkedHashMap<K, V> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<K, V>> entryList = new ArrayList<>();
        for (Map.Entry<K, V> E : this.entrySet()) {
            entryList.add(E);
        }
        Collections.sort(entryList, new MapValueComparator<>());
        Iterator<Map.Entry<K, V>> iter = entryList.iterator();
        Map.Entry<K, V> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        this.map = sortedMap;
        return sortedMap;
    }

    public Map<K, V> sortMapByValue(Comparator<Map.Entry<K, V>> com) {
        LinkedHashMap<K, V> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<K, V>> entryList = new ArrayList<>();
        for (Map.Entry<K, V> E : this.entrySet()) {
            entryList.add(E);
        }
        Collections.sort(entryList, com);
        Iterator<Map.Entry<K, V>> iter = entryList.iterator();
        Map.Entry<K, V> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        this.map = sortedMap;
        return sortedMap;
    }
}

class MapValueComparator<K, V extends Comparable> implements Comparator<Map.Entry<K, V>> {

    @Override
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
