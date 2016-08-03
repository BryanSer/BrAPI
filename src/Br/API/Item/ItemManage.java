/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Item;

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
public abstract class ItemManage {

    protected static Map<String, ItemData> ItemDatas = new HashMap<>();

    public static FileConfiguration Data;
    public static File saveFolder;

    public static ItemData createItem(ItemStack is) {
        if (ItemManage.hasData(is)) {
            return ItemManage.getItemByItemStack(is);
        }
        ItemData id = new ItemData(ItemManage.createName(is), is.clone());
        ItemManage.ItemDatas.put(id.getUniqueID(), id);
        return id;
    }

    public static void removeDataByName(String name) {
        if (ItemManage.ItemDatas.containsKey(name)) {
            ItemManage.ItemDatas.remove(name);
        }
    }

    public static void removeDataByItem(ItemStack is) {
        ItemData id = ItemManage.getItemByItemStack(is);
        if (id == null) {
            return;
        }
        ItemManage.removeDataByName(id.getUniqueID());
    }

    private static String createName(ItemStack is) {
        String name = "" + is.getType().name() + "$" + is.hashCode();
        return name;
    }

    public static boolean hasData(ItemStack s) {
        for (Entry<String, ItemData> E : ItemManage.ItemDatas.entrySet()) {
            if (E.getValue().getItemStack().isSimilar(s)) {
                if (s.getAmount() == E.getValue().getItemStack().getAmount()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ItemData getItemByName(String u) {
        if (ItemManage.ItemDatas.containsKey(u)) {
            return ItemManage.ItemDatas.get(u);
        } else {
            return null;
        }
    }

    public static ItemData getItemByItemStack(ItemStack is) {
        for (Entry<String, ItemData> E : ItemManage.ItemDatas.entrySet()) {
            if (E.getValue().getItemStack().equals(is)) {
                return E.getValue();
            }
        }
        return null;
    }

    public static void loadConfig() {
        try {
            File dataFolder = Br.API.Data.plugin.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdirs();
            }
            File dataFile = new File(dataFolder, "Items.yml");
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
            Data = YamlConfiguration.loadConfiguration(dataFile);
            DumperOptions yamlOptions = null;

            Field f = YamlConfiguration.class.getDeclaredField("yamlOptions");
            f.setAccessible(true);

            yamlOptions = new DumperOptions() {
                private TimeZone timeZone = TimeZone.getDefault();

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
            f.set(Data, yamlOptions);
            ItemManage.saveFolder = dataFile;

            if (Data.contains("Data")) {
                ConfigurationSection CS = Data.getConfigurationSection("Data");
                for (String s : CS.getKeys(false)) {
                    ItemManage.ItemDatas.put(s, new ItemData(s, CS.getItemStack(s)));
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | IOException ex) {
            Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void saveData() {
        try {
            for (ItemData ID : ItemManage.ItemDatas.values()) {
                Data.set("Data." + ID.getUniqueID(), ID.getItemStack());
            }
            ItemManage.Data.save(ItemManage.saveFolder);
        } catch (IOException ex) {
            Logger.getLogger(ItemManage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
