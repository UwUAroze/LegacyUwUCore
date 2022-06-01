package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetBitesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("uwucore.setbites")) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou aren't allowed to do this! smh!"));
            return true;
        }

        Block cakeBlock = player.getTargetBlockExact(6);

        if (cakeBlock == null) {
            player.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou're staring at air smh."));
            return true;
        }

        if (!(cakeBlock.getType().equals(Material.CAKE))) {
            player.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou need to be looking at a cake, dummy!"));
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6ePsst! /editcake <0-6>"));
            return true;
        }

        return true;
    }
}
