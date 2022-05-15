package me.aroze.uwucore.listeners;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import java.net.URL;

public class ServerListPing implements Listener {

    @EventHandler
    public void onPing(ServerListPingEvent e) {
        e.setMaxPlayers(69);
        e.setMotd(ChatUtils.color("&#b7e8cbawozey's supwer coowl dev sewvar\n&#d0b7e8woah!!11!!"));
    }

}
