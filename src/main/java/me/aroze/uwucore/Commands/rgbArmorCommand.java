package me.aroze.uwucore.Commands;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class rgbArmorCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length > 3) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou only need 3 arguments!"));
            return true;
        } if (args.length < 3) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou need 3 arguments!"));
            return true;
        }

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        try {
            int red = Integer.parseInt(args[0]);
            int green = Integer.parseInt(args[1]);
            int blue = Integer.parseInt(args[2]);
            if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
                sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou can only have RGB values between 0 and 255!"));
                return true;
            }
            helmetMeta.setColor(Color.fromRGB(red, green, blue));
            chestMeta.setColor(Color.fromRGB(red, green, blue));
            legsMeta.setColor(Color.fromRGB(red, green, blue));
            bootsMeta.setColor(Color.fromRGB(red, green, blue));
            helmet.setItemMeta(helmetMeta);
            chestplate.setItemMeta(chestMeta);
            leggings.setItemMeta(legsMeta);
            boots.setItemMeta(bootsMeta);

            ((Player) sender).getInventory().addItem(helmet, chestplate, leggings, boots);


        } catch (NumberFormatException e) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eUse RGB values, so: /rgbArmor [Red (0-255)] [Green (0-255)] [Blue (0-255)]"));
            return true;
        }

        return true;

    }

}
