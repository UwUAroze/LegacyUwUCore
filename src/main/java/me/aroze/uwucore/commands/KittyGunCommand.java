package me.aroze.uwucore.commands;

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
        if (!(sender instanceof Player)) return true;

        ItemStack gun = new ItemStack(Material.END_ROD);
        ItemMeta gunMeta = gun.getItemMeta();
        gunMeta.setDisplayName(ChatUtils.color("&#b9ffb3Kitty Gun"));
        gun.setItemMeta(gunMeta);
        ((Player) sender).getInventory().addItem(gun);

        return true;

    }
}
