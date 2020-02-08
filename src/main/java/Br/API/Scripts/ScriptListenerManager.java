/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Scripts;

import java.nio.charset.Charset;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public class ScriptListenerManager {

    public static void RegisterListener(Plugin p, ScriptListener listener) {
        Class cls = listener.getEventClass();
        if (cls != null) {
            Bukkit.getPluginManager().registerEvent(cls, listener, listener.getPriority(), (l, e) -> listener.castEvent(e), p, listener.ignoreCancelled());
        }
    }

    public static void UnregisterListener(ScriptListener l) {
        HandlerList.unregisterAll(l);
    }

    private ScriptListenerManager() {
    }
}
