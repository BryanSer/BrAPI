/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
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

    public static NashornScriptEngine evalAsUTF8(Plugin p, File f) {
        return eval(p, (t) -> {
            try {
                t.eval(new InputStreamReader(new FileInputStream(f), "UTF-8"));
            } catch (ScriptException ex) {
                Logger.getLogger(ScriptLoader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ScriptLoader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
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
        /*  
        nashorn脚本引擎存在一个明显的BUG
        位于 jdk.nashorn.api.scripting.NashornScriptEngineFactory:431的静态方法getAppClassLoader
        其中字节码描述如下: 
             * 0: invokestatic  java/lang/Thread.currentThread:()Ljava/lang/Thread;
             * 3: invokevirtual java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader;
             * 6: astore_0
             * 7: aload_0
             * 8: ifnonnull     19
             * 11: ldc           jdk/nashorn/api/scripting/NashornScriptEngineFactory
             * 13: invokevirtual java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
             * 16: goto          20
             * 19: aload_0
             * 20: areturn
        显然 代码返回的类加载器首先选取当前线程的类加载器(位于Thread.currentThread().getContextClassLoader())
        若返回null则返回NashornScriptEngineFactory的类加载器(NashornScriptEngineFactory.class.getClassLoader())
        这意味着 通过构造ScriptEngineManager所传入的类加载器没有任何用处
        导致返回的ScriptEngine不使用所指定的类加载器
        故本方法做了修改当前线程类加载器的修改
        */
        ClassLoader backup = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(p.getClass().getClassLoader());
        ScriptEngineManager EngineManager = new ScriptEngineManager(p.getClass().getClassLoader());
        NashornScriptEngine ns = (NashornScriptEngine) EngineManager.getEngineByName("nashorn");
        c.accept(ns);
        Thread.currentThread().setContextClassLoader(backup);
        return ns;
    }
}
