package me.aroze.uwucore.commands;

import me.aroze.uwucore.UwUCore;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class VanishCommand implements CommandExecutor {

    private List<UUID> vanished = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (vanished.contains(player.getUniqueId())) {
            vanished.remove(player.getUniqueId());
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.showPlayer(UwUCore.getInstance(), player);
            }
            player.sendMessage(ChatUtils.color("&#7f6d85You are now &#a3ff99visible &#7f6d85to everyone!"));
        }

        else {
            vanished.add(player.getUniqueId());
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.hidePlayer(UwUCore.getInstance(), player);
            }
            player.sendMessage(ChatUtils.color("&#7f6d85You are now &#ff9999vanished &#7f6d85from everyone!"));
        }

        return false;
    }
}
