/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 */
public class Log {

    /**
     * 创建一个单独文件作为log的对象
     *
     * @param p 插件主类
     * @param c 缓存空间
     * @return
     */
    public static Log getOneFileLog(Plugin p, int c) {
        return new OneFileLog(p, c);
    }

    /**
     * 将旧的.\\Log\\文件夹里的全部xxx.log合并到.\Log.log中 并且创建一个单独文件作为log的对象
     *
     * @param p 插件主类
     * @param c 缓存空间
     * @return
     */
    public static Log CombineOldLog(Plugin p, int c) {
        Log log = new OneFileLog(p, c);
        File fold = p.getDataFolder();
        fold = new File(fold, "\\Logs\\");
        if (fold.exists()) {
            for (File f : fold.listFiles()) {
                try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    while (br.ready()) {
                        log.LogRaw(br.readLine());
                    }
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Log.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            log.Save();
            for (File f : fold.listFiles()) {
                f.delete();
            }
            fold.delete();
        }
        return log;
    }

    int DeleteDay;
    List<String> LogCache = new ArrayList<>();
    int CacheLength;
    Plugin plugin;

    /**
     *
     * @param p 插件主类
     * @param deleteday 多少天后删除 -1为永不删除
     * @param cachelength
     */
    public Log(Plugin p, int deleteday, int cachelength) {
        this.plugin = p;
        if (deleteday < -1 || deleteday == 0) {
            throw new IllegalArgumentException("参数错误 删除日期不得小于-1且不为0");
        }
        this.DeleteDay = deleteday;
        this.CacheLength = cachelength;
    }

    public void Log(String s) {
        this.LogRaw("[" + this.getTime() + "] " + s);
    }

    public void LogRaw(String s) {
        LogCache.add(s);
        if (LogCache.size() >= CacheLength) {
            this.Save();
        }
    }

    public void Save() {
        String now = this.getDate();
        File fold = this.plugin.getDataFolder();
        fold = new File(fold, "\\Logs\\");
        if (!fold.exists()) {
            fold.mkdirs();
        }
        File aim = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date nowdata = new Date();
        for (File f : fold.listFiles()) {
            String name = f.getName().replaceAll("\\.log", "");
            if (DeleteDay != -1) {
                try {
                    Date d = format.parse(name);
                    if (nowdata.getTime() - d.getTime() >= DeleteDay * 24 * 60 * 60 * 1000) {
                        f.deleteOnExit();
                    }
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (aim == null && f.getName().startsWith(now)) {
                aim = f;
            }
        }
        if (aim == null) {
            aim = new File(fold, now + ".log");
            if (!aim.exists()) {
                try {
                    aim.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        try (FileWriter fw = new FileWriter(aim, true)) {
            for (String s : this.LogCache) {
                fw.write(s + "\n");
            }
            fw.close();
            this.LogCache.clear();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return df.format(date);
    }

    public String getTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return df.format(date);
    }
}

class OneFileLog extends Log {

    public OneFileLog(Plugin p, int cachelength) {
        super(p, -1, cachelength);
    }

    @Override
    public void Log(String s) {
        super.LogRaw("[" + super.getDate() + " " + super.getTime() + "] " + s);;
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
