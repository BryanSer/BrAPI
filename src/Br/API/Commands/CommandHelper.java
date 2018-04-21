/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API.Commands;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Bryan_lzh
 * @version 1.0
 */
public interface CommandHelper extends CommandExecutor {

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
            if(sci.getSubCommand().equals(args[0])){
                args = Arrays.copyOfRange(args, 1, args.length);
                sci.getExecutor().onCommand(sender, args, label);
                return true;
            }
        }
        return true;
    }

    @FunctionalInterface
    public static interface SubCommandExecutor {

        /**
         *
         * @param sender
         * @param args args[0]不包括子命令名
         * @param lable
         */
        void onCommand(CommandSender sender, String args[], String lable);
    }

    public static class CommandInfo {

        private List<SubCommandInfo> SubCommandInfos = new ArrayList<>();
        private String CommandName;
        private MainCommand Command;

        public List<SubCommandInfo> getSubCommandInfos() {
            return SubCommandInfos;
        }

        public String getCommandName() {
            return CommandName;
        }

        public void setCommandName(String CommandName) {
            this.CommandName = CommandName;
        }

        public MainCommand getCommand() {
            return Command;
        }

        public void setCommand(MainCommand Command) {
            this.Command = Command;
        }

    }

    public static class SubCommandInfo {

        private String SubCommand;
        private SubCommand Command;
        private SubCommandExecutor Executor;

        public SubCommandInfo(String SubCommand, SubCommand Command, SubCommandExecutor Executor) {
            this.SubCommand = SubCommand;
            this.Command = Command;
            this.Executor = Executor;
        }

        public static <T extends CommandHelper> SubCommandInfo getSubCommandInfo(Field f, T t) {
            f.setAccessible(true);
            if (!f.isAnnotationPresent(SubCommand.class)) {
                return null;
            }
            if (!SubCommandExecutor.class.isAssignableFrom(f.getType())) {
                return null;
            }
            SubCommand cmd = f.getAnnotation(SubCommand.class);
            try {
                return new SubCommandInfo(cmd.command(), cmd, (SubCommandExecutor) f.get(t));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(CommandHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }

        public String getSubCommand() {
            return SubCommand;
        }

        public SubCommand getCommand() {
            return Command;
        }

        public SubCommandExecutor getExecutor() {
            return Executor;
        }

    }
}
