/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 */
class OneFileLog extends Log {

    public OneFileLog(Plugin p, int cachelength) {
        super(p, -1, cachelength);
    }

    @Override
    public void Save() {
        File fold = super.plugin.getDataFolder();
        File log = new File(fold, "log.log");
        if (!log.exists()) {
            try {
                log.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try (final FileWriter fw = new FileWriter(log, true)) {
            for (String s : super.LogCache) {
                fw.write(s + "\n");
            }
            fw.close();
            super.LogCache.clear();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
