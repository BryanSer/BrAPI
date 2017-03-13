/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Br.API.Scoreboard;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import me.winterguardian.easyscoreboards.ScoreboardUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * 只是用来挂载另外一个插件的 防止自己忘记使用方法 没有实际意义
 * @author Administrator
 */
public class ScoreboardManager {
    
    boolean Enable = false;

    private ScoreboardManager() {
        if (Bukkit.getPluginManager().getPlugin("EasyScoreboards") != null) {
            Enable = true;
        }
    }
    private static ScoreboardManager SM = null;

    public static ScoreboardManager getScoreboardManager() {
        if (ScoreboardManager.SM == null) {
            ScoreboardManager.SM = new ScoreboardManager();
        }
        return ScoreboardManager.SM;
    }
    
    public void Display(Collection<Player> players, String[] s){
        for (int i = 0; i < s.length; i++) {
            s[i] = ChatColor.translateAlternateColorCodes('&', s[i]);
        }
        ScoreboardUtil.unrankedSidebarDisplay(players, s);
    }
    
    public void Display(Player p ,String[] s){
        for (int i = 0; i < s.length; i++) {
            s[i] = ChatColor.translateAlternateColorCodes('&', s[i]);
        }
        ScoreboardUtil.unrankedSidebarDisplay(p, s);
    }
    
    public void Display(Player p,String title,HashMap<String,Integer> map){
        ScoreboardUtil.rankedSidebarDisplay(p, title, map);
    }
    
    
}
