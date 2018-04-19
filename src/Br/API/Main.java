package Br.API;

import Br.API.Data.DataManager;
import Br.API.Data.DatabaseSerializable;
import Br.API.Item.ItemManager;
import Br.API.LangUtils.Lang;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
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
        Utils.econ = this.setupEconomy();
    }

    private Economy setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return null;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return null;
        }
        Economy econ = rsp.getProvider();
        return econ;
    }

    public static void RegisterMetrics() {
        int vaule = 0;
        for (Plugin p : Bukkit.getPluginManager().getPlugins()) {
            if (p.getDescription().getDepend().contains("BrAPI")) {
                vaule++;
                Plugins.add(p.getName());
            }
        }
        int v = vaule;
        PluginsAmount = v;
        Metrics metrics = new Metrics(PluginData.plugin);
        metrics.addCustomChart(new Metrics.AdvancedPie("subpluginamount", () -> {
            Map<String, Integer> map = new HashMap<>();
            map.put(String.valueOf(PluginsAmount), 1);
            return map;
        }));
        metrics.addCustomChart(new Metrics.AdvancedPie("installedsubplugin", () -> {
            Map<String, Integer> map = new HashMap<>();
            for (String n : Plugins) {
                map.put(n, 1);
            }
            return map;
        }));
    }

    public void onDisable() {
        DataManager.SaveAll();
        ItemManager.saveData();
        HandlerList.unregisterAll(this);
        Lang.LangDatas.forEach((l) -> {
            try {
                l.Save();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        DatabaseSerializable.PreparedStatements.Close();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("BrAPI")) {
            if (args.length > 1 && args[0].equals("Button")) {
                sender.sendMessage("§c按钮监听器异常 请重启服务器");
                return true;
            }
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
