package me.aroze.uwucore.commands;

import me.aroze.uwucore.UwUCore;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KittyGunCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("uwucore.kittygun")) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou aren't allowed to do this! smh!"));
            return true;
        }

        if (!(sender instanceof Player)) return true;
        ((Player) sender).getInventory().addItem(UwUCore.kittyGun);
        return true;

    }
}
