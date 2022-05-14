package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

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

        Player target = (Player) Bukkit.getOfflinePlayer(args[0]);

        switch(args[1].toLowerCase()) {
            case "kick":
                target.kickPlayer(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou have been kicked from the server"));
                break;
            case "ban":
                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatUtils.color("&#ff6e6e⚠ &#ff7f6eThe ban hammer has spoken!\n\n&#ff6e6eThe ban hammer: " + sender.getName()), null, sender.getName());
                target.kickPlayer(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou have been banned from the server"));
                break;
            case "tempban":
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.HOUR,12);
                Bukkit.getBanList(BanList.Type.NAME).addBan(target.getName(), ChatUtils.color("&#ff6e6e⚠ &#ff7f6eThe ban hammer has spoken!\n&#ff6e6eThe ban hammer: " + sender.getName()) + "&#ff6e6e\n\nExpires: &#ff7f6e" + cal.getTime(), cal.getTime(), sender.getName());
                target.kickPlayer(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou have been temporarily banned from the server"));
                break;

            default:
                return true;
        }

        return true;
    }
}
