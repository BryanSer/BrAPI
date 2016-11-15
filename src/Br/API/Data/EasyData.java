/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Administrator
 */
public class EasyData implements DataService {

    String PluginName;

    Map<String, Object> Datas;

    public EasyData(Plugin p) {
        this.Datas = new HashMap<>();
        this.PluginName = p.getName();
    }

    public EasyData(String name) {
        this.Datas = new HashMap<>();
        this.PluginName = name;
    }

    @Override
    public String getPluginName() {
        return this.PluginName;
    }

    @Override
    public Object get(String path) {
        if (this.Datas.containsKey(path)) {
            return this.Datas.get(path);
        } else {
            return null;
        }
    }

    @Override
    public boolean contains(String path) {
        return this.Datas.containsKey(path);
    }

    @Override
    public boolean containsType(String path, Class<?> c) {
        if (!this.contains(path)) {
            return false;
        }
        Object obj = this.Datas.get(path);
        return c.isInstance(obj);
    }

    @Override
    public void set(String path, Object o) {
        this.Datas.put(path, o);
    }

    @Override
    public Set<String> getKeySet() {
        return this.Datas.keySet();
    }

}
