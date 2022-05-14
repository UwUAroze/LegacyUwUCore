package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlaytimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        String player = sender.getName();

        if (args.length != 0) player = args[0];

        if (!(Bukkit.getOfflinePlayer(player).hasPlayedBefore())) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eThat user has never played here before!"));
            return true;
        }


        int ticks = (Bukkit.getOfflinePlayer(player)).getStatistic(Statistic.PLAY_ONE_MINUTE);
        double seconds = ticks / 20;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;
        sender.sendMessage(ChatUtils.color("\n&#947c9cPlaytime of &#cda2db" + player + "&#947c9c in different units:"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + ticks + " &#678580ticks"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + seconds + " &#678580seconds"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + minutes + " &#678580minutes"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + hours + " &#678580hours"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + days + " &#678580days"));
        sender.sendMessage("\n");
        return true;
    }
}
