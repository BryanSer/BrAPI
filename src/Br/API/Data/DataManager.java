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
 * @author Bryan_lzh
 */
public abstract class DataManager {

    private static Map<String, DataService> Datas = new HashMap<>();

    /**
     * 注册插件数据<p>
     * 将会覆盖原注册数据
     *
     * @param ds 数据
     * @param p 插件
     */
    public static void RegisterData(DataService ds, Plugin p) {
        DataManager.Datas.put(p.getName(), ds);
    }

    /**
     * 注册插件数据<p>
     * 将会覆盖原注册数据
     *
     * @param ds 储存的数据
     * @param p 插件或文件名
     */
    public static void RegisterData(DataService ds, String p) {
        DataManager.Datas.put(p, ds);
    }

    /**
     * 按指定字符串返回储存的数据(找不到将尝试读取)
     *
     * @param s
     * @return DataService
     */
    public static DataService getData(String s) {
        if (!DataManager.Datas.containsKey(s)) {
            try {
                LoadData(s, true);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return DataManager.Datas.get(s);
        }

        return DataManager.Datas.get(s);
    }

    /**
     * 按指定插件返回储存的数据(不会读取硬盘里的)
     * <p>
     * 与getData(p.getName())相同意义
     *
     * @param p
     * @return DataService
     */
    public static DataService getData(Plugin p) {
        return DataManager.getData(p.getName());
    }

    /**
     * 强制储存一个数据
     *
     * @param s 插件名或数据名
     * @throws IOException
     */
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

    /**
     *
     * @param config
     * @author andylizi
     * @return
     */
    public static FileConfiguration toSafe(FileConfiguration config) {
        DumperOptions yamlOptions = null;
        try {
            Field f = YamlConfiguration.class.getDeclaredField("yamlOptions");
            f.setAccessible(true);

            yamlOptions = new DumperOptions() {
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
            f.set(config, yamlOptions);
        } catch (ReflectiveOperationException ex) {
        }
        return config;
    }

}
