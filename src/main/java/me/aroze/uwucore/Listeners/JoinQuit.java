package me.aroze.uwucore.Listeners;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage("&#ffb5cf[&d+&#ffb5cf] " + e.getPlayer().getName());
        e.getPlayer().sendTitle(ChatUtils.color("&#ffb5cfWelcome back"), ChatUtils.color("&#ffd4e3Enjoy your stay <3"),30,75,15);
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage("&#ffb5cf[&d-&#ffb5cf] " + e.getPlayer().getName());
    }

}
