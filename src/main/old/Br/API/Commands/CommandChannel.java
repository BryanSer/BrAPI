/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Commands;

import Br.API.PluginData;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 * @since 2018-11-9
 */
public class CommandChannel implements PluginMessageListener {

    public static final String CHANNEL_OUT = "brapi:commandout";
    public static final String CHANNEL_IN = "brapi:commandin";


    public enum PermissionLevel {
        Player {
            @Override
            public boolean canCast(CommandSender cs) {
                return cs instanceof Player;
            }
        },
        OP {
            @Override
            public boolean canCast(CommandSender cs) {
                return cs.isOp() && cs instanceof Player;
            }
        },
        Admin {//包括后台
            @Override
            public boolean canCast(CommandSender cs) {
                return cs.isOp();
            }
        },
        Console {
            @Override
            public boolean canCast(CommandSender cs) {
                return cs instanceof ConsoleCommandSender;
            }
        },
        All {
            @Override
            public boolean canCast(CommandSender cs) {
                return true;
            }

        };

        public abstract boolean canCast(CommandSender cs);
    }

    private static class RegisterCommand extends Command {

        private String Fallback;
        private PermissionLevel Permission;
        private List<RegisterSubCommand> SubCommands = new ArrayList<>();

        private RegisterCommand(String name) {
            super(name);
        }

        public static RegisterCommand createRegisterCommand(JsonObject json) {
            String name = json.get("Command").getAsString();
            RegisterCommand rc = new RegisterCommand(name);
            rc.json(json);
            return rc;
        }

        public void json(JsonObject json) {
            this.Fallback = json.get("Fallback").getAsString();
            this.Permission = json.has("Permission") ? PermissionLevel.valueOf(json.get("Permission").getAsString()) : PermissionLevel.Player;
            JsonArray usage = json.has("Usage") ? json.getAsJsonArray("Usage") : null;
            if (usage != null) {
                String[] Usage = new String[usage.size()];
                int index = 0;
                for (JsonElement e : usage) {
                    Usage[index++] = e.getAsString();
                }

                this.setUsage(Arrays.stream(Usage).reduce("", (s1, s2) -> s1 + "\n" + s2));
            }

            JsonArray ali = json.has("Aliases") ? json.getAsJsonArray("Aliases") : null;
            if (ali != null) {
                List<String> aliases = new ArrayList<>();
                for (JsonElement je : ali) {
                    aliases.add(je.getAsString());
                }
                this.setAliases(aliases);
            }
            JsonArray sc = json.has("SubCommands") ? json.getAsJsonArray("SubCommands") : null;
            if (sc != null) {
                for (JsonElement e : sc) {
                    SubCommands.add(new RegisterSubCommand(e.getAsJsonObject()));
                }
            }
        }

        /*
        返回的信息格式如下
        使用者 Fallback:Command 参数...
        使用者* Fallback:Command 参数...             OP以上权限的格式
         */
        @Override
        public boolean execute(CommandSender sender, String label, String[] args) {
            if (!this.Permission.canCast(sender)) {
                sender.sendMessage("§c你没有使用这个命令的权限");
                return true;
            }
            if (args.length != 0 && args[0].equalsIgnoreCase("help")) {
                return false;
            }
            String msg = sender.getName() + (sender.isOp() ? "* " : " ") + this.Fallback + ":" + this.getName();
            T:
            if (!this.SubCommands.isEmpty() && args.length != 0) {
                for (RegisterSubCommand rs : this.SubCommands) {
                    if (args[0].equalsIgnoreCase(rs.getSubCommand())) {
                        if (args.length < rs.getMinArg()) {
                            return false;
                        }
                        msg += " ";
                        for (String arg : args) {
                            msg += arg + " ";
                        }
                        msg = msg.trim();
                        break T;
                    }
                }
                return false;
            }
            Bukkit.getServer().sendPluginMessage(PluginData.plugin, CHANNEL_OUT, msg.getBytes());
            return true;
        }

        public String getFallback() {
            return Fallback;
        }

    }

    private static class RegisterSubCommand {

        private String SubCommand;
        private PermissionLevel Permission;
        private int minArg;//包括参数本身

        public RegisterSubCommand(JsonObject json) {
            this.SubCommand = json.get("SubCommand").getAsString();
            this.Permission = json.has("Permission") ? PermissionLevel.valueOf(json.get("Permission").getAsString()) : PermissionLevel.Player;
            this.minArg = json.has("minArg") ? json.get("minArg").getAsInt() : 0;
        }

        public String getSubCommand() {
            return SubCommand;
        }

        public PermissionLevel getPermission() {
            return Permission;
        }

        public int getMinArg() {
            return minArg;
        }

    }
    private static final JsonParser JSON_PARSER = new JsonParser();

    @Override
    public void onPluginMessageReceived(String channel, Player player, byte[] message) {
        if (channel.equals(CHANNEL_IN)) {
            String msg = new String(message);
            JsonObject json = JSON_PARSER.parse(msg).getAsJsonObject();
            RegisterCommand rm = RegisterCommand.createRegisterCommand(json);
            writeCommand(rm);
        }
    }

    private static void writeCommand(RegisterCommand cmd) {
        Server server = Bukkit.getServer();
        try {
            Method m = server.getClass().getDeclaredMethod("getCommandMap", new Class[0]);
            m.setAccessible(true);
            CommandMap cm = (CommandMap) m.invoke(server, new Object[0]);
            cm.register(cmd.getFallback(), cmd);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(CommandChannel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(CommandChannel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CommandChannel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(CommandChannel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(CommandChannel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
