package me.aroze.uwucore.Listeners;

import me.aroze.uwucore.Util.ChatUtils;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatUtils.color("&#ffb5cf[&d+&#ffb5cf] " + e.getPlayer().getName()));
        e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(ChatUtils.color("&#ffd4e3Welcome back!!")));
        e.getPlayer().sendTitle(ChatUtils.color("&#ffb5cfWelcome back"), ChatUtils.color("&#ffd4e3Enjoy your stay <3"),30,75,15);
        e.getPlayer().setPlayerListName(ChatUtils.color("&#ffe6ef" + e.getPlayer().getDisplayName()));
        e.getPlayer().setPlayerListHeaderFooter(
                ChatUtils.color("&#eb9bb7▶&8&m                                                  &#eb9bb7◀\n" +
                        "\n" +
                        "&#ffb5cfWelcome to &#9c89c7Server name\n" +
                        "&#ffb5cfThere are &#ffe6ef" + Bukkit.getOnlinePlayers().size() + " &#ffb5cfonline players!\n"),

                ChatUtils.color("\n" +
                        "&#eb9bb7Discord &8&l| &#ffb5cfdiscord.gg/abcd\n" +
                        "&#a16a7dWebstore &8&l| &#ffb5cfummmmmm\n" +
                        "\n" +
                        "&#eb9bb7▶&8&m                                                  &#eb9bb7◀")
        );
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        e.setQuitMessage(ChatUtils.color("&#ffb5cf[&d-&#ffb5cf] " + e.getPlayer().getName()));
    }

}
