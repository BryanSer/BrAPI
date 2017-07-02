package Br.API;

import java.lang.reflect.InvocationTargetException;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author yeongpin99
 */
public class ActionBar {

    public static Class<?> getNmsClass(String paramString) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + paramString);
    }

    public static String getServerVersion() {
        return Bukkit.getServer().getClass().getPackage().getName().substring(23);
    }

    public static void send(Player paramPlayer, String paramString) {
        try {
            Object o1, o2, o3, o4;
            if ((getServerVersion().equalsIgnoreCase("v1_9_R1") | getServerVersion().equalsIgnoreCase("v1_9_R2"))) {
                o1 = getNmsClass("ChatComponentText").getConstructor(new Class[]{String.class}).newInstance(new Object[]{paramString});
                o2 = getNmsClass("PacketPlayOutChat").getConstructor(new Class[]{getNmsClass("IChatBaseComponent"), Byte.TYPE}).newInstance(new Object[]{o1, (byte) 2});
                o3 = paramPlayer.getClass().getMethod("getHandle", new Class[0]).invoke(paramPlayer, new Object[0]);
                o4 = o3.getClass().getField("playerConnection").get(o3);
                o4.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(o4, new Object[]{o2});
            } else if ((getServerVersion().equalsIgnoreCase("v1_8_R2") | getServerVersion().equalsIgnoreCase("v1_8_R3"))) {
                o1 = getNmsClass("IChatBaseComponent$ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, new Object[]{"{'text': '" + paramString + "'}"});
                o2 = getNmsClass("PacketPlayOutChat").getConstructor(new Class[]{getNmsClass("IChatBaseComponent"), Byte.TYPE}).newInstance(new Object[]{o1, (byte) 2});
                o3 = paramPlayer.getClass().getMethod("getHandle", new Class[0]).invoke(paramPlayer, new Object[0]);
                o4 = o3.getClass().getField("playerConnection").get(o3);
                o4.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(o4, new Object[]{o2});
            } else {
                o1 = getNmsClass("ChatSerializer").getMethod("a", new Class[]{String.class}).invoke(null, new Object[]{"{'text': '" + paramString + "'}"});
                o2 = getNmsClass("PacketPlayOutChat").getConstructor(new Class[]{getNmsClass("IChatBaseComponent"), Byte.TYPE}).newInstance(new Object[]{o1, (byte) 2});
                o3 = paramPlayer.getClass().getMethod("getHandle", new Class[0]).invoke(paramPlayer, new Object[0]);
                o4 = o3.getClass().getField("playerConnection").get(o3);
                o4.getClass().getMethod("sendPacket", new Class[]{getNmsClass("Packet")}).invoke(o4, new Object[]{o2});
            }
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException | InstantiationException | NoSuchFieldException localIllegalAccessException) {
            localIllegalAccessException.printStackTrace(System.out);
        }
    }
}
