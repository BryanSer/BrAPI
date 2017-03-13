package Br.API;

import Br.API.Data.DataManager;
import Br.API.Item.ItemManager;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static int PluginsAmount = 0;
    public static Set<String> Plugins = new HashSet();

    public void onEnable() {
        PluginData.plugin = this;
        File dataFolder = PluginData.plugin.getDataFolder();
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        dataFolder = new File(dataFolder, "\\Datas\\");
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }
        //DataManager.LoadAll(true);
        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
        ItemManager.loadConfig();
    }

    public static void RegisterMetrics() {
        int vaule = 0;
        for (Plugin p : Bukkit.getPluginManager().getPlugins()) {
            if (p.getDescription().getDepend().contains("BrAPI")) {
                vaule++;
                Plugins.add(p.getName());
            }
        }
        final int v = vaule;
        PluginsAmount = v;
        try {
            Metrics metrics = new Metrics(PluginData.plugin);
            Metrics.Graph g = metrics.createGraph("SubPlugin");
            g.addPlotter(new Metrics.Plotter() {
                final int va = v;

                public int getValue() {
                    return this.va;
                }
            });
            metrics.addGraph(g);
            metrics.start();
        } catch (IOException e) {
        }
    }

    public void onDisable() {
        DataManager.SaveAll();
        ItemManager.saveData();
        HandlerList.unregisterAll(this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("BrAPI")) {
            if (EventListener.Reg) {
                RegisterMetrics();
                EventListener.Reg = false;
            }
            String plugins = "§a";
            for (String s : Plugins) {
                plugins = plugins + s + "|";
            }
            sender.sendMessage(new String[]{
                ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------"),
                ChatColor.translateAlternateColorCodes('&', "&aBrAPI已安装 版本: " + getDescription().getVersion()),
                "§b当前依赖的插件数:" + PluginsAmount,
                plugins,
                ChatColor.translateAlternateColorCodes('&', "&aBrAPI has been installed, Version: " + getDescription().getVersion()),
                ChatColor.translateAlternateColorCodes('&', "&b&l---------------------------------------------------------------")
            });

            return true;
        }
        return false;
    }
}
