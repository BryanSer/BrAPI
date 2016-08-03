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
 * 可排序的Map
 * @author Bryan_lzh
 */
public class SortableMap<K, V extends Integer> implements Map {

    Map<K, Integer> map = new HashMap<>();

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
    public Integer get(Object key) {
        return map.get(key);
    }

    @Override
    public Object put(Object key, Object value) {
        return map.put((K) key, (Integer) value);
    }

    @Override
    public Object remove(Object key) {
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
    public Set<Entry<K, Integer>> entrySet() {
        return map.entrySet();
    }

    public Map<K, Integer> sortMapByValue() {
        Map<K, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<K, Integer>> entryList = new ArrayList<>();
        for (Entry<K, Integer> E : this.entrySet()) {
            entryList.add(E);
        }
        Collections.sort(entryList, new MapValueComparator());
        Iterator<Map.Entry<K, Integer>> iter = entryList.iterator();
        Map.Entry<K, Integer> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            sortedMap.put(tmpEntry.getKey(), tmpEntry.getValue());
        }
        return sortedMap;
    }
}

class MapValueComparator<K, V extends Integer> implements Comparator<Map.Entry<K, V>> {

    @Override
    public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
        return o2.getValue() - o1.getValue();
    }
}
