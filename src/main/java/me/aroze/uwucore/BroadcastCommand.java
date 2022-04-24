package me.aroze.uwucore;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    //    String message = String.join(" ", args);
        String[] lines = String.join(" ", args).split(",");

        Bukkit.broadcastMessage(ChatUtils.color("\n&e&lAnnouncement"));
        for (String line : lines) {
            Bukkit.broadcastMessage(ChatUtils.color("&8>> &7&o" + line));
        }
        Bukkit.broadcastMessage(ChatUtils.color("\n&c - " + sender.getName() ));

        return true;
    }

}