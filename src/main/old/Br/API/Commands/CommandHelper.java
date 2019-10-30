/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 * @author Bryan_lzh
 * @version 1.0
 */
public interface CommandHelper extends CommandExecutor {

    @Override
    public default boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        CommandInfo ci = CommandInfos.get(this.getClass());
        if (ci == null) {
            throw new IllegalStateException("命令未初始化");
        }
        if (!command.getName().equals(ci.getCommandName())) {
            return false;
        }
        if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ci.getCommand().description());
            for (SubCommandInfo sci : ci.getSubCommandInfos()) {
                sender.sendMessage("    " + sci.getCommand().usage());
            }
            return true;
        }
        for (SubCommandInfo sci : ci.getSubCommandInfos()) {
            if (sci.getSubCommand().equals(args[0])) {
                args = Arrays.copyOfRange(args, 1, args.length);
                sci.getExecutor().onCommand(sender, args, label);
                return true;
            }
        }
        return true;
    }

    public static final Map<Class<? extends CommandHelper>, CommandInfo> CommandInfos = new HashMap<>();

    public default void init(Plugin p) {
        Class<? extends CommandHelper> cls = this.getClass();
        if (!cls.isAnnotationPresent(MainCommand.class)) {
            throw new IllegalArgumentException("找不到@MainCommand");
        }
        MainCommand mc = cls.getAnnotation(MainCommand.class);
        CommandInfo ci = new CommandInfo();
        Arrays.stream(cls.getDeclaredFields()).map(f -> SubCommandInfo.getSubCommandInfo(f, this)).filter(f -> f != null).forEach(ci.getSubCommandInfos()::add);
        ci.setCommand(mc);
        ci.setCommandName(mc.command());
        CommandInfos.put(this.getClass(), ci);
        Bukkit.getPluginCommand(mc.command()).setExecutor(this);
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MainCommand {
        String command();

        String[] aliases();

        String description();
    }

}
