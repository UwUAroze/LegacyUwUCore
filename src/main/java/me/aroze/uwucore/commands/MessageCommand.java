package me.aroze.uwucore.commands;

import me.aroze.uwucore.listeners.Chat;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;

        if (args.length < 2) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eUsage: /msg <player> <message>"));
            return true;
        }

        if (!(Bukkit.getOfflinePlayer(args[0]).isOnline())) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eThere is no online player matching '" + args[0] + "'"));
            return true;
        }

        Player target = Bukkit.getPlayer(args[0]);
        String message = ChatUtils.color(String.join(" ", args).replaceFirst(args[0], ""));

        sender.sendMessage(ChatUtils.color("&#b4a2db[&#ccbbf0To: " + target.getName() + "&#b4a2db]&#eb94af" + message));
        target.sendMessage(ChatUtils.color("&#b4a2db[&#ccbbf0From: " + sender.getName() + "&#b4a2db]&#eb94af" + message));


        return true;
    }
}
