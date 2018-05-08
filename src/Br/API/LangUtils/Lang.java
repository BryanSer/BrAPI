/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.LangUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 */
@Deprecated
public class Lang {

    public static List<Lang> LangDatas = new ArrayList<>();

    private Plugin pn;
    private Map<String, String> Langs = new HashMap<>();
    private boolean NeedSave = false;

    public Lang(Plugin p) {
        this.pn = p;
        if (p.getDataFolder().exists()) {
            File lang = new File(p.getDataFolder(), "lang.yml");
            if (lang.exists()) {
                YamlConfiguration config = YamlConfiguration.loadConfiguration(lang);
                config.getKeys(true).forEach((key) -> Langs.put(key, config.getString(key)));
            }
        }
        LangDatas.add(this);
    }

    public void Save() throws IOException {
        if (!NeedSave) {
            return;
        }
        File folder = pn.getDataFolder();
        if (!folder.exists()) {
            folder.mkdir();
        }
        File lang = new File(folder, "lang.yml");
        if (!lang.exists()) {
            lang.createNewFile();
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(lang);
        Langs.entrySet().stream()
                .filter((e) -> (!config.contains(e.getKey())))
                .forEachOrdered((e) -> config.set(e.getKey(), e.getValue()));
        config.save(lang);
        NeedSave = false;
    }

    public String getLang(String key, String def) {
        if (!Langs.containsKey(key)) {
            def = ChatColor.translateAlternateColorCodes('&', def);
            Langs.put(key, def);
            NeedSave = true;
        }
        return Langs.get(key);
    }

    public String getLang(String key) {
        return Langs.get(key);
    }
}
