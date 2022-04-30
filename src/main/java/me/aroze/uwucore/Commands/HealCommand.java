package me.aroze.uwucore.Commands;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class HealCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("uwucore.heal")) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou aren't allowed to do this! smh!"));
            return true;
        }

        if (!(sender instanceof Player)) return true;

        Player player;

        if (args.length > 0) {
            try {
                player = Bukkit.getPlayer(args[0]);
                sender.sendMessage(ChatUtils.color("&#ffd4e3You have healed &#eb9bb7" + player.getName()));
                player.sendMessage(ChatUtils.color("&#ffd4e3You have been healed by &#eb9bb7" + sender.getName()));
            } catch (NullPointerException e) {
                sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eThere is no online player named &#ff6e6e" + args[0]));
                return true;
            }

        } else {
            player = (Player) sender;
            player.sendMessage(ChatUtils.color("&#ffd4e3You have been healed"));
        }

        player.setHealth(20);
        player.setFoodLevel(20);
        for (PotionEffect potion : player.getActivePotionEffects()) {
            player.removePotionEffect(potion.getType());
        }
        player.setFireTicks(0);
        return true;
    }

}