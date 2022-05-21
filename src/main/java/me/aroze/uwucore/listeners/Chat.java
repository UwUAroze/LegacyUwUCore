package me.aroze.uwucore.listeners;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class Chat implements Listener {

    ArrayList<String> chatLog = new ArrayList<>();

    @EventHandler
    public void onChat(org.bukkit.event.player.AsyncPlayerChatEvent e) {
        chatLog.add(e.getMessage());
        String messege = e.getMessage().replace("%", "%%");
        e.setFormat(ChatUtils.color("&c" + e.getPlayer().getName() + "&7: &f" + messege));
    }

}
