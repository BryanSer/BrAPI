package Br.API.Commands;

import org.bukkit.command.CommandSender;

public interface SubCommandExecutor {

    /**
     *
     * @param sender
     * @param args args[0]不包括子命令名
     * @param lable
     */
    void onCommand(CommandSender sender, String args[], String lable);
}
