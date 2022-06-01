package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HatCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (!player.hasPermission("uwucore.hat")) {
            player.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou aren't allowed to do this! smh!"));
            return true;
        }

        ItemStack playerTool = new ItemStack(player.getInventory().getItemInMainHand());

        player.getInventory().getItemInMainHand().setType(Material.AIR);
        player.getInventory().setHelmet(playerTool);

        player.sendMessage(ChatUtils.color("&#eb9bb7✔ &#ffd4e3Woo, your head is now way cooler :flushed: :eyes:"));

        return true;
    }
}
