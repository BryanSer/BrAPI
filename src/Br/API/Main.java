package Br.API;

import Br.API.Item.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Bryan_lzh
 */
public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        Data.plugin = this;
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        ItemManager.loadConfig();
    }

    @Override
    public void onDisable() {
        ItemManager.saveData();
        HandlerList.unregisterAll(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("BrAPI")) {
            sender.sendMessage(new String[]{
                ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"),
                ChatColor.translateAlternateColorCodes('&', "&aBrAPI已安装 版本: " + this.getDescription().getVersion()),
                ChatColor.translateAlternateColorCodes('&', "&aBrAPI has been installed, Version: " + this.getDescription().getVersion()),
                ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"),});
            return true;
        }
        return false;
    }
}
