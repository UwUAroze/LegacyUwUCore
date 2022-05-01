package me.aroze.uwucore.Listeners;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("&#ffb5cf[&d+&#ffb5cf] " + e.getPlayer().getName());
    }

}
