/*
 * 开发者:Bryan_lzh
 * QQ:390807154
 * 保留一切所有权
 * 若为Bukkit插件 请前往plugin.yml查看剩余协议
 */
package Br.API;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * @author Bryan_lzh
 * @version 1.0
 */
public class CallBack implements Listener {
    @Deprecated
    public static void SendSignRequest(Player p, BiConsumer<Player, String> callback) {
        sendSignRequest(p, callback);
    }

    public static void sendSignRequest(Player p, BiConsumer<Player, String> callback) {
        SignUtils.getSignUtils().sendSignRequest(p, callback);
    }

    private static boolean Register = false;
    private static Map<String, ButtonInfo> ButtonInfos = new HashMap<>();

    @Deprecated
    public static boolean SendButtonRequest(Player p, String[] msg, BiConsumer<Player, Integer> callback, int overtime) {
        return sendButtonRequest(p, msg, callback, overtime);
    }
    
    public static void cancelButtonRequest(Player p){
        ButtonInfo bi = ButtonInfos.remove(p.getName());
        if(bi != null){
            bi.canceled = true;
            bi.cancel();
            bi.Callback.accept(p, null);
        }
    }

    /**
     * 向玩家发送一堆按钮 按钮的的内容将由msg决定,最后通过BiConsumer来返回执行玩家按下的按钮<p>
     * 按钮计数从0开始 超时overtime秒则传入null
     *
     * @param p
     * @param msg
     * @param callback 注意 Integer参数为null时表示超时 玩家如果中途退出游戏也会触发null
     * @param overtime 超时时间 单位秒
     * @return true时表示 请求成功 false时表示 上个处理还未完成
     */
    public static boolean sendButtonRequest(Player p, String[] msg, BiConsumer<Player, Integer> callback, int overtime) {
        RegisterListener();
        if (ButtonInfos.containsKey(p.getName())) {
            return false;
        }
        ButtonInfo bi = new ButtonInfo(p, msg, callback, overtime);
        ButtonInfos.put(p.getName(), bi);
        List<BaseComponent> bs = new ArrayList<>();
        for (int i = 0; i < msg.length; i++) {
            String key = msg[i];
            bs.addAll(Arrays.asList(getButton(String.format("§r[%s§r]", key), bi.getKeys().get(i))));
            bs.add(new TextComponent("    "));
        }
        BaseComponent[] comps = new BaseComponent[bs.size()];
        for (int i = 0; i < comps.length; i++) {
            comps[i] = bs.get(i);
        }
        p.spigot().sendMessage(comps);
        return true;
    }


    private static Map<String, InputInfo> InputInfos = new ConcurrentHashMap<>();
    //聊天输入
    public static boolean sendInputRequest(Player p, BiConsumer<Player, String> callback, int overtime) {
        RegisterListener();
        if (InputInfos.containsKey(p.getName())) {
            return false;
        }
        InputInfo ii = new InputInfo(p.getName(), callback, p);
        InputInfos.put(p.getName(), ii);
        ii.runTaskLater(PluginData.plugin, overtime * 20);
        return true;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent evt) {
        if (evt.getMessage().matches(REGex)) {
            evt.setCancelled(true);
            String key = evt.getMessage().split(" ")[2];
            ButtonInfo bi = ButtonInfos.get(evt.getPlayer().getName());
            if (bi == null) {
                return;
            }
            int index = bi.getKeys().indexOf(key);
            if (index == -1) {
                bi.getCallback().accept(evt.getPlayer(), null);
            }
            bi.getCallback().accept(evt.getPlayer(), index);
            bi.cancel();
        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent evt) {
        InputInfo ii = InputInfos.get(evt.getPlayer().getName());
        if (ii != null) {
            if (ii.isCancel()) {
                InputInfos.remove(evt.getPlayer().getName());
                return;
            } else {
                ii.getCallback().accept(evt.getPlayer(), evt.getMessage());
                evt.setCancelled(true);
                ii.cancel();
            }
        }
    }

    public static BaseComponent[] getButton(String text, String cmd) {
        return new ComponentBuilder(text).event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/BrAPI Button " + cmd)).create();
    }

    public static void RegisterListener() {
        if (!Register) {
            Bukkit.getPluginManager().registerEvents(new CallBack(), PluginData.plugin);
        }
        Register = true;
    }

    private static final int CHARAMOUNT = 26 + 26 + 10;
    private static final int LENGTH = 6;
    private static final char[] CHAR = new char[CHARAMOUNT];
    private static final Random Random = new Random();
    private static final String REGex = "\\/?BrAPI Button .*";

    private static String getRandomString() {
        char[] c = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            c[i] = CHAR[Random.nextInt(CHARAMOUNT)];
        }
        return new String(c);
    }

    static {
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            CHAR[index++] = c;
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            CHAR[index++] = c;
        }
        for (char c = '0'; c <= '9'; c++) {
            CHAR[index++] = c;
        }
    }

    public static class ButtonInfo extends BukkitRunnable {

        private String Name;
        private List<String> Keys = new ArrayList<>();
        private BiConsumer<Player, Integer> Callback;
        private boolean canceled = false;
        private Player Player;
        private boolean overtime = true;

        ButtonInfo(Player p, String[] display, BiConsumer<Player, Integer> callback, int overtime) {
            this.Name = p.getName();
            Player = p;
            for (String s : display) {
                Keys.add(CallBack.getRandomString());
            }
            this.Callback = callback;
            super.runTaskLater(PluginData.plugin, overtime * 20L);
        }

        @Override
        public synchronized void cancel() throws IllegalStateException {
            overtime = false;
            if (!canceled) {
                this.run();
                this.canceled = true;
            }
            super.cancel();
        }

        @Override
        public void run() {
            if (canceled) {
                return;
            }
            if (overtime) {
                Callback.accept(Player, null);
            }
            ButtonInfos.remove(this.Name);
        }

        public String getName() {
            return Name;
        }

        public List<String> getKeys() {
            return Keys;
        }

        public boolean isCanceled() {
            return canceled;
        }

        public BiConsumer<Player, Integer> getCallback() {
            return Callback;
        }

    }

    public static class InputInfo extends BukkitRunnable {
        private String Name;
        private BiConsumer<Player, String> Callback;
        private boolean overtime = true;
        private boolean cancel = false;
        private Player Player;

        public InputInfo(String Name, BiConsumer<Player, String> Callback, Player Player) {
            this.Name = Name;
            this.Callback = Callback;
            this.Player = Player;
        }


        @Override
        public void run() {
            if (cancel) {
                return;
            }
            if (overtime) {
                Callback.accept(Player, null);
            }
            InputInfos.remove(this.Name);
        }

        @Override
        public synchronized void cancel() throws IllegalStateException {
            overtime = false;
            if (!cancel) {
                this.run();
                this.cancel = true;
            }
            super.cancel();
        }

        public BiConsumer<Player, String> getCallback() {
            return Callback;
        }

        public Player getPlayer() {
            return Player;
        }

        public boolean isCancel() {
            return cancel;
        }

    }

    private CallBack() {
    }
}
