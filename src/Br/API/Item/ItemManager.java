/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Item;

import Br.API.Data.DataManager;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.yaml.snakeyaml.DumperOptions;

/**
 *
 * @author Bryan_lzh
 */
public abstract class ItemManager {

    protected static Map<String, ItemData> ItemDatas = new HashMap<>();

    public static FileConfiguration Data;
    public static File saveFolder;

    /**
     * 创建一个新的ItemData<P>
     * 若已存在相同的ItemData将直接返回
     * @param is 传入的物品堆叠
     * @return ItemData
     */
    public static ItemData createItem(ItemStack is) {
        if (ItemManager.hasData(is)) {
            return ItemManager.getItemByItemStack(is);
        }
        ItemData id = new ItemData(ItemManager.createName(is), is.clone());
        ItemManager.ItemDatas.put(id.getUniqueID(), id);
        return id;
    }

    /**
     * 通过唯一值来移除某ItemData
     * @param name 唯一值
     */
    public static void removeDataByName(String name) {
        if (ItemManager.ItemDatas.containsKey(name)) {
            ItemManager.ItemDatas.remove(name);
        }
    }

    /**
     * 通过物品堆叠来删除ItemData
     * @param is ItemStack
     */
    public static void removeDataByItem(ItemStack is) {
        ItemData id = ItemManager.getItemByItemStack(is);
        if (id == null) {
            return;
        }
        ItemManager.removeDataByName(id.getUniqueID());
    }

    private static String createName(ItemStack is) {
        String name = "" + is.getType().name() + "$" + is.hashCode();
        return name;
    }

    /**
     * 该物品是否储存过
     * @param s
     * @return
     */
    public static boolean hasData(ItemStack s) {
        for (Entry<String, ItemData> E : ItemManager.ItemDatas.entrySet()) {
            if (E.getValue().getItemStack().isSimilar(s)) {
                if (s.getAmount() == E.getValue().getItemStack().getAmount()) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 通过唯一值寻找ItemData
     * @param u
     * @return
     */
    public static ItemData getItemByName(String u) {
        if (ItemManager.ItemDatas.containsKey(u)) {
            return ItemManager.ItemDatas.get(u);
        } else {
            return null;
        }
    }

    /**
     * 通过物品堆叠寻找ItemData
     * @param is
     * @return
     */
    public static ItemData getItemByItemStack(ItemStack is) {
        for (Entry<String, ItemData> E : ItemManager.ItemDatas.entrySet()) {
            if (E.getValue().getItemStack().equals(is)) {
                return E.getValue();
            }
        }
        return null;
    }

    public static void loadConfig() {
        try {
            File dataFolder = Br.API.PluginData.plugin.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }
            File dataFile = new File(dataFolder, "Items.yml");
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
            Data = YamlConfiguration.loadConfiguration(dataFile);
            Data = DataManager.toSafe(Data);
            
            ItemManager.saveFolder = dataFile;

            if (Data.contains("Data")) {
                ConfigurationSection CS = Data.getConfigurationSection("Data");
                for (String s : CS.getKeys(false)) {
                    ItemManager.ItemDatas.put(s, new ItemData(s, CS.getItemStack(s)));
                }
            }
        } catch (IllegalArgumentException | SecurityException | IOException ex) {
            Logger.getLogger(ItemManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveData() {
        try {
            for (ItemData ID : ItemManager.ItemDatas.values()) {
                Data.set("Data." + ID.getUniqueID(), ID.getItemStack());
            }
            ItemManager.Data.save(ItemManager.saveFolder);
        } catch (IOException ex) {
            Logger.getLogger(ItemManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
