/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.injector.GamePhase;
import com.comphenix.protocol.wrappers.BlockPosition;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

/**
 *
 * @author Bryan_lzh
 */
public class SignUtils {

    private static SignUtils SU = null;

    // private Set<String> Listener = new HashSet<>();
    private Map<String, String> Listener = new HashMap<>();

    public void SendSignRequest(Player p, String id) {
        Listener.put(p.getName(), id);
        ProtocolManager pm = ProtocolLibrary.getProtocolManager();
        PacketContainer pc = new PacketContainer(PacketType.Play.Server.OPEN_SIGN_EDITOR);
        Location loc = p.getLocation();
        pc.getBlockPositionModifier().write(0, new BlockPosition(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ()));
        try {
            pm.sendServerPacket(p, pc, false);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SignUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static Map<String, Map.Entry<String, BiConsumer<Player, String>>> Callbacks = new HashMap<>();

    public void SendSignRequest(Player p, BiConsumer<Player, String> callback) {
        String id = String.valueOf(System.currentTimeMillis());
        Callbacks.put(p.getName(), new AbstractMap.SimpleEntry<>(id, callback));
        SendSignRequest(p, id);
    }

    private SignUtils() {
        Bukkit.getPluginManager().registerEvents(new Listener() {
            @EventHandler
            public void onSign(WriteSignEvent evt) {
                if (Callbacks.containsKey(evt.getPlayer().getName())) {
                    Map.Entry<String, BiConsumer<Player, String>> v = Callbacks.get(evt.getPlayer().getName());
                    Callbacks.remove(evt.getPlayer().getName());
                    if(evt.getID().equals(v.getKey())){
                        v.getValue().accept(evt.getPlayer(), evt.getWrite());
                    }
                }
            }
        }, PluginData.plugin);
        ProtocolManager pm = ProtocolLibrary.getProtocolManager();
        pm.addPacketListener(new PacketAdapter(PacketAdapter
                .params()
                .plugin(PluginData.plugin)
                .clientSide()
                .listenerPriority(ListenerPriority.LOWEST)
                .gamePhase(GamePhase.PLAYING)
                .types(PacketType.Play.Client.UPDATE_SIGN)) {
            @Override
            public void onPacketReceiving(PacketEvent e) {
                Player p = e.getPlayer();
                if (Listener.containsKey(p.getName())) {
                    final String id = Listener.get(p.getName());
                    Listener.remove(p.getName());
                    String w = null;
                    String[] read = e.getPacket().getStringArrays().read(0);
                    for (int i = 0; i < 4; i++) {
                        if (w == null || w.isEmpty()) {
                            w = read[i];
                        } else {
                            break;
                        }
                    }
                    WriteSignEvent wse = new WriteSignEvent(p, w, id);
                    Bukkit.getPluginManager().callEvent(wse);
                    e.setCancelled(true);
                }
            }

        });
    }

    public static SignUtils getSignUtils() throws NullPointerException {
        if (SU == null) {
            if (!Bukkit.getPluginManager().isPluginEnabled("ProtocolLib")) {
                throw new NullPointerException("§c找不到插件ProtocolLib");
            }
            SU = new SignUtils();
        }
        return SU;
    }

}
