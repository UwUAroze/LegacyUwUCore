package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import me.aroze.uwucore.util.MathUtils;
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
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + Double.parseDouble("" + Math.round(minutes * 100))/100 + " &#678580minutes"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + Double.parseDouble("" + Math.round(hours * 100))/100 + " &#678580hours"));
        sender.sendMessage(ChatUtils.color("&#93c9c1 • " + Double.parseDouble("" + Math.round(days * 100))/100 + " &#678580days\n\n"));
        sender.sendMessage(ChatUtils.color("&#947c9cFor non-nerds: &#cda2db " + MathUtils.ticksToTimestamp(ticks)));
        sender.sendMessage("\n");
        return true;

    }
}
