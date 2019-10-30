/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Data;

import static Br.API.Data.DataManager.toSafe;
import Br.API.PluginData;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Administrator
 */
public class EasyData implements DataService {

    String PluginName;

    Map<String, Object> Datas;

    YamlConfiguration config;

    public EasyData(Plugin p) {
        this.Datas = new HashMap<>();
        this.PluginName = p.getName();
       // LoadFile();
    }

    @Deprecated
    public EasyData(String name) {
        this.Datas = new HashMap<>();
        this.PluginName = name;
        // LoadFile();
    }

    public EasyData(String name, boolean load) {
        if (!load) {
            this.Datas = new HashMap<>();
            this.PluginName = name;
        } else {
            this.Datas = new HashMap<>();
            this.PluginName = name;
            LoadFile();
        }
    }

    EasyData(String name, YamlConfiguration config) {
        this.Datas = new HashMap<>();
        this.PluginName = name;
        this.config = config;
    }

    private void LoadFile() {
        File dataFolder = PluginData.plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        dataFolder = new File(dataFolder, "\\Datas\\");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        File dataFile = new File(dataFolder, PluginName + ".yml");
        try {
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
            config = YamlConfiguration.loadConfiguration(dataFile);
            config = (YamlConfiguration) toSafe(config);
        } catch (IOException ex) {
            Logger.getLogger(EasyData.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    @Override
    public YamlConfiguration getConfig() {
        return this.config;
    }

}
