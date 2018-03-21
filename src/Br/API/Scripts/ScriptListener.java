/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Scripts;

import org.bukkit.event.Event;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 * @param <E>
 */
public interface ScriptListener<E extends Event> extends Listener {

    public void onEvent(E e);

    public Class<E> getEventClass();

    public default EventPriority getPriority() {
        return EventPriority.NORMAL;
    }

    public default boolean ignoreCancelled(){
        return true;
    }
}
