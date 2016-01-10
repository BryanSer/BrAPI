package Br.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Bryan_lzh
 */
public class Main extends JavaPlugin {

    /**
     * @param args the command line arguments
     */
    /*    public static void main(String[] args) {
     System.out.print("(123".replaceFirst("\\(", " ("));
     }*/
    @Override
    public void onEnable() {
        Data.plugin = this;
        Data.initialization();
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        HandlerList.unregisterAll(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("BrAPI")) {
            sender.sendMessage(new String[]{
                        ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"),
                        ChatColor.translateAlternateColorCodes('&', "&aBrAPI已安装 版本: 1.0"),
                        ChatColor.translateAlternateColorCodes('&', "&aBrAPI has been installed, Version: 1.0"),
                        ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"),});
            return true;
        }
        return false;
    }
}