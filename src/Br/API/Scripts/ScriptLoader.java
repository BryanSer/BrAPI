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
import jdk.nashorn.api.scripting.NashornScriptEngineFactory;
import org.bukkit.plugin.Plugin;

/**
 * nashorn脚本引擎存在一个明显的BUG<br>
 * 位于<br>
 * jdk.nashorn.api.scripting.NashornScriptEngineFactory:431的静态方法getAppClassLoader<br>
 * 其中字节码描述如下:
 * <p>
 * <br>
 * 0: invokestatic java/lang/Thread.currentThread:()Ljava/lang/Thread;<br>
 * 3: invokevirtual
 * java/lang/Thread.getContextClassLoader:()Ljava/lang/ClassLoader;<br>
 * 6: astore_0<br>
 * 7: aload_0<br>
 * 8: ifnonnull 19<br>
 * 11: ldc jdk/nashorn/api/scripting/NashornScriptEngineFactory<br>
 * 13: invokevirtual
 * java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;<br>
 * 16: goto 20<br>
 * 19: aload_0<br>
 * 20: areturn<br></p>
 * 显然<br>
 * 代码返回的类加载器首先选取当前线程的类加载器(位于Thread.currentThread().getContextClassLoader())<br>
 * 若返回null则返回NashornScriptEngineFactory的类加载器(NashornScriptEngineFactory.class.getClassLoader())<br>
 * 这意味着 通过构造ScriptEngineManager所传入的类加载器没有任何用处 导致返回的ScriptEngine不使用所指定的类加载<br>
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
        ClassLoader backup = Thread.currentThread().getContextClassLoader();
        Thread.currentThread().setContextClassLoader(p.getClass().getClassLoader());
        ScriptEngineManager EngineManager = new ScriptEngineManager(p.getClass().getClassLoader());
        NashornScriptEngine ns = (NashornScriptEngine) EngineManager.getEngineByName("nashorn");
        if(ns == null){
            NashornScriptEngineFactory nsef = new NashornScriptEngineFactory();
            ns = (NashornScriptEngine) nsef.getScriptEngine();
        }
        c.accept(ns);
        Thread.currentThread().setContextClassLoader(backup);
        return ns;
    }
}
