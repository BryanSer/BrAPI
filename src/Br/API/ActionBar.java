package Br.API;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers;
import com.comphenix.protocol.wrappers.WrappedChatComponent;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.entity.Player;

public class ActionBar {

    public static void sendActionBar(Player p, String msg) {
        if (msg == null) {
            return;
        }
        ProtocolManager pm = ProtocolLibrary.getProtocolManager();
        PacketContainer pc = new PacketContainer(PacketType.Play.Server.CHAT);
        pc.getChatComponents().write(0, WrappedChatComponent.fromText(msg));
        pc.getChatTypes().write(0, EnumWrappers.ChatType.GAME_INFO);
        try {
            pm.sendServerPacket(p, pc);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ActionBar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
