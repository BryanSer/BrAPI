/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Data;

import Br.API.PluginData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.yaml.snakeyaml.DumperOptions;

/**
 *
 * @author Administrator
 */
public abstract class DataManager {

    private static Map<String, DataService> Datas = new HashMap<>();

    public static void RegisterData(DataService ds, Plugin p) {
        DataManager.Datas.put(p.getName(), ds);
    }

    /**
     *
     * @param ds 储存的数据
     * @param p 插件或文件名
     */
    public static void RegisterData(DataService ds, String p) {
        DataManager.Datas.put(p, ds);
    }

    public static DataService getData(String s) {
        if (!DataManager.Datas.containsKey(s)) {
            return null;
        }
        return DataManager.Datas.get(s);
    }

    public static DataService getData(Plugin s) {
        if (!DataManager.Datas.containsKey(s.getName())) {
            return null;
        }
        return DataManager.Datas.get(s.getName());
    }

    public static void ForciblySave(String s) throws IOException {
        File dataFolder = PluginData.plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        dataFolder = new File(dataFolder, "\\Datas\\");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        DataService ds = DataManager.getData(s);
        File dataFile = new File(dataFolder, ds.getPluginName() + ".yml");
        if (!dataFile.exists()) {
            dataFile.createNewFile();
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(dataFile);
        config = toSafe(config);
        for (String key : ds.getKeySet()) {
            config.set(key, ds.get(key));
        }
        config.save(dataFile);
    }

    public static void SaveAll() {
        File dataFolder = PluginData.plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        dataFolder = new File(dataFolder, "\\Datas\\");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        for (Map.Entry<String, DataService> E : Datas.entrySet()) {
            try {
                File dataFile = new File(dataFolder, E.getValue().getPluginName() + ".yml");
                if (!dataFile.exists()) {

                    dataFile.createNewFile();

                }
                FileConfiguration config = YamlConfiguration.loadConfiguration(dataFile);
                config = toSafe(config);
                for (String key : E.getValue().getKeySet()) {
                    config.set(key, E.getValue().get(key));
                }
                config.save(dataFile);
            } catch (IOException ex) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, "出现了未知的IO异常", ex);
            }
        }
    }

    /**
     *
     * @param plugin 插件或文件名
     * @param rewrite 是否覆盖原内容
     * @throws FileNotFoundException
     */
    public static void LoadData(String plugin, boolean rewrite) throws FileNotFoundException {
        File dataFolder = PluginData.plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        dataFolder = new File(dataFolder, "\\Datas\\");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        File dataFile = new File(dataFolder, plugin + ".yml");
        if (!dataFile.exists()) {
            throw (new FileNotFoundException(dataFile.getAbsolutePath() + "没有被找到 请检查文件名拼写"));
        }
        DataService ds = Load(dataFile);
        if (!DataManager.Datas.containsKey(ds.getPluginName())) {
            DataManager.Datas.put(plugin, ds);
        } else if (rewrite) {
            DataManager.Datas.put(plugin, ds);
        }
    }

    /**
     *
     * @param rewrite 是否覆盖内存中的数据
     */
    public static void LoadAll(boolean rewrite) {
        File dataFolder = PluginData.plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        dataFolder = new File(dataFolder, "\\Datas\\");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        for (File f : dataFolder.listFiles()) {
            if (f.isFile()) {
                DataService ds = Load(f);
                if (DataManager.Datas.containsKey(ds.getPluginName()) && rewrite) {
                    DataManager.Datas.put(ds.getPluginName(), ds);
                }
            }
        }
    }

    private static DataService Load(File f) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        config = (YamlConfiguration) toSafe(config);
        String name = f.getName();
        if (name.contains(".yml")) {
            name = name.replaceAll(".yml", "");
        }
        DataService ds = new EasyData(name);
        for (String key : config.getKeys(true)) {
            ds.set(key, config.get(key));
        }
        return ds;
    }

    private static FileConfiguration toSafe(FileConfiguration config) {
        DumperOptions yamlOptions = null;
        try {
            Field f = YamlConfiguration.class.getDeclaredField("yamlOptions");   //获取类YamlConfiguration里的匿名yamlOptions字段
            f.setAccessible(true);

            yamlOptions = new DumperOptions() {  //将yamlOptions字段替换为一个DumperOptions的匿名内部类，里面替换了setAllowUnicode方法让其永远无法设置为true
                @Override
                public void setAllowUnicode(boolean allowUnicode) {
                    super.setAllowUnicode(false);
                }

                @Override
                public void setLineBreak(DumperOptions.LineBreak lineBreak) {
                    super.setLineBreak(DumperOptions.LineBreak.getPlatformLineBreak());
                }
            };

            yamlOptions.setLineBreak(DumperOptions.LineBreak.getPlatformLineBreak());
            f.set(config, yamlOptions); //把新的yamlOptions偷梁换柱回去
        } catch (ReflectiveOperationException ex) {
        }
        return config;
    }

}
