package Br.API.Commands;

import java.util.ArrayList;
import java.util.List;

public class CommandInfo {

    private List<SubCommandInfo> SubCommandInfos = new ArrayList<>();
    private String CommandName;
    private CommandHelper.MainCommand Command;

    public List<SubCommandInfo> getSubCommandInfos() {
        return SubCommandInfos;
    }

    public String getCommandName() {
        return CommandName;
    }

    public void setCommandName(String CommandName) {
        this.CommandName = CommandName;
    }

    public CommandHelper.MainCommand getCommand() {
        return Command;
    }

    public void setCommand(CommandHelper.MainCommand Command) {
        this.Command = Command;
    }

}
