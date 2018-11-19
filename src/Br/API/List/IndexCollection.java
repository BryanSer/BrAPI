/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 用于按序号储存的容器
 *
 * @author Administrator
 * @param <T>
 */
public class IndexCollection<T extends Indexable> implements Collection {

    Map<Integer, T> Data = new HashMap<>();

    int maxIndex = 0;

    /**
     * 请勿利用此返回值进行除读取外的数据操作
     *
     * @return
     */
    public Map<Integer, T> getData() {
        return Data;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void add(T t) {
        this.Data.put(t.getIndex(), t);
        if (t.getIndex() > this.maxIndex) {
            this.maxIndex = t.getIndex();
        }
    }

    public void remove(T t) {
        this.Data.remove(t.getIndex());
        if (t.getIndex() == this.maxIndex) {
            this.FindMax();
        }
    }

    public List<Integer> getIndexs() {
        List<Integer> re = new LinkedList<>();
        for (int i = 0; i <= this.maxIndex; i++) {
            if (this.Data.containsKey(i)) {
                re.add(i);
            }
        }
        return re;
    }

    private void FindMax() {
        int max = 0;
        for (T t : this.Data.values()) {
            if (t.getIndex() > max) {
                max = t.getIndex();
            }
        }
        this.maxIndex = max;
    }

    public void remove(int i) {
        this.Data.remove(i);

        if (i == this.maxIndex) {
            this.FindMax();
        }
    }

    public T get(int i) {
        if (this.Data.containsKey(i)) {
            return this.Data.get(i);
        } else {
            return null;
        }
    }

    @Override
    public int size() {
        return this.Data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.Data.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof Indexable)) {
            return false;
        }
        return this.Data.containsValue((T) o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.Data.values().iterator();
    }

    @Override
    public Object[] toArray() {
        return this.Data.values().toArray();
    }

    @Override
    public Object[] toArray(Object[] a) {
        return this.Data.values().toArray(a);
    }

    @Override
    public boolean add(Object e) {
        if (!(e instanceof Indexable)) {
            return false;
        }
        T i = (T) e;
        try {
            this.add(i);
        } catch (Exception ee) {
            ee.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object e) {
        if (!(e instanceof Indexable)) {
            return false;
        }
        T i = (T) e;
        try {
            this.remove(i);
        } catch (Exception ee) {
            ee.printStackTrace(System.out);
            return false;
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!(o instanceof Indexable)) {
                return false;
            }
            try {
                if (!this.Data.containsValue((T) o)) {
                    return false;
                }
            } catch (ClassCastException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c) {
            if (!(o instanceof Indexable)) {
                return false;
            }
            try {
                this.add(o);
            } catch (ClassCastException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        for (Object o : c) {
            if (!(o instanceof Indexable)) {
                return false;
            }
            try {
                this.remove(o);
            } catch (ClassCastException e) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection c) {
        List<Integer> remove = new ArrayList<>();
        for (int i : this.Data.keySet()) {
            remove.add(i);
        }
        for (Object o : c) {
            if (!(o instanceof Indexable)) {

                return false;
            }
            try {
                Indexable ii = (Indexable) o;
                remove.remove(ii.getIndex());
            } catch (ClassCastException e) {
                return false;
            }
        }
        for (int i : remove) {
            this.remove(i);
        }
        this.FindMax();
        return true;
    }

    @Override
    public void clear() {
        this.Data.clear();
        this.maxIndex = 0;
    }

}
