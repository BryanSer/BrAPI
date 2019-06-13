package Br.API.Commands;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubCommandInfo {

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
