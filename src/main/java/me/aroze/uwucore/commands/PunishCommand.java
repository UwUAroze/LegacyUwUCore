package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PunishCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(args.length == 2)) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eSyntax: /punish <player> <kick/ban/tempban>"));
            return true;
        }

        if (!(args[1].equalsIgnoreCase("kick") || args[1].equalsIgnoreCase("ban") || args[1].equalsIgnoreCase("tempban"))) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eSyntax: /punish <player> <kick/ban/tempban>"));
            return true;
        }

        if (Bukkit.getOfflinePlayer(args[0]) == null) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6ePlayer '" + args[0] + "' not found"));
            return true;
        }

        if (args[1].equalsIgnoreCase("ban")) {

        }

        return true;
    }
}
