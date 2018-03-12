/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Scripts;

import java.io.Reader;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.NashornScriptEngine;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public class ScriptLoader {

    public static NashornScriptEngine eval(Plugin p, Reader fr) {
        return eval(p, (t) -> {
            try {
                t.eval(fr);
            } catch (ScriptException ex) {
                Logger.getLogger(ScriptLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public static NashornScriptEngine eval(Plugin p, String fr) {
        return eval(p, (t) -> {
            try {
                t.eval(fr);
            } catch (ScriptException ex) {
                Logger.getLogger(ScriptLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    public static NashornScriptEngine eval(Plugin p, Consumer<NashornScriptEngine> c) {
        ClassLoader backup = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(p.getClass().getClassLoader());
        ScriptEngineManager EngineManager = new ScriptEngineManager(p.getClass().getClassLoader());
        NashornScriptEngine ns = (NashornScriptEngine) EngineManager.getEngineByName("nashorn");
        c.accept(ns);
        Thread.currentThread().setContextClassLoader(backup);
        return ns;
    }
}
