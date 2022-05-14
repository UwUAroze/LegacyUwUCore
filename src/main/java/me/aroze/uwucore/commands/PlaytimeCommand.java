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
        sender.sendMessage(ChatUtils.color("\n&#947c9cPlaytime of &#cda2db" + player + "&#947c9c in different units:"));
        sender.sendMessage(ChatUtils.color("&#93c9c1" + ticks + " &#678580ticks"));
        sender.sendMessage("\n");
        return true;
    }
}
