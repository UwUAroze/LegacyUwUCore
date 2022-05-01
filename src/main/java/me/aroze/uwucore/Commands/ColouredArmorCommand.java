package me.aroze.uwucore.Commands;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.Color;

public class ColouredArmorCommand implements CommandExecutor {

    @SuppressWarnings("ConstantConditions")
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        boolean providedHex = false;

        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta helmetMeta = (LeatherArmorMeta) helmet.getItemMeta();
        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chestplate.getItemMeta();
        LeatherArmorMeta legsMeta = (LeatherArmorMeta) leggings.getItemMeta();
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();

        Color color = Color.WHITE;

        if (args.length == 0) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou need to provide hex or rgb values!"));
            sender.sendMessage(ChatUtils.color("&#ff6e6e • Example: &#ff7f6e/colouredArmor 243 215 236"));
            sender.sendMessage(ChatUtils.color("&#ff6e6e • Example: &#ff7f6e/colouredArmor #91ffc1"));
            return true;
        }

        if (args.length == 1) {

            if (args[0].matches("#[0-9A-Fa-f]{6}")) {
                int r = Integer.valueOf(args[0].substring(1, 3), 16);
                int g = Integer.valueOf(args[0].substring(3, 5), 16);
                int b = Integer.valueOf(args[0].substring(5, 7), 16);
                providedHex = true;
                color = Color.fromRGB(r, g, b);
            } else {
                if (args.length > 3) {
                    sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou only need 3 arguments for rgb, or one for hex!"));
                    return true;
                } if (args.length < 3) {
                    sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou need 3 arguments for rgb, or just one for hex!"));
                    return true;
                }
            }

        }

        try {
            if (color == Color.WHITE) {
                int red = Integer.parseInt(args[0]);
                int green = Integer.parseInt(args[1]);
                int blue = Integer.parseInt(args[2]);
                if (red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
                    sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou can only have RGB values between 0 and 255!"));
                    return true;
                }
            }
        } catch (NumberFormatException e) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eSmh silly. Use RGB values, so:\n/colouredArmor [0-255] [0-255] [0-255]"));
            return true;
        }

        helmetMeta.setColor(color);
        chestMeta.setColor(color);
        legsMeta.setColor(color);
        bootsMeta.setColor(color);

        helmet.setItemMeta(helmetMeta);
        chestplate.setItemMeta(chestMeta);
        leggings.setItemMeta(legsMeta);
        boots.setItemMeta(bootsMeta);

        ((Player) sender).getInventory().addItem(helmet, chestplate, leggings, boots);
        String toHex = String.format("#%02x%02x%02x", color.getRed(), color.getGreen(), color.getBlue());

        if (providedHex) {
            sender.sendMessage(ChatUtils.color("&#eb9bb7✔ &#ffd4e3Created set of leather armor with hex value: &" + toHex + toHex));
        } else {
            sender.sendMessage(ChatUtils.color("&#eb9bb7✔ &#ffd4e3Created set of leather armor with rgb values: &" + toHex + color.getRed() + ", " + color.getGreen() + ", " + color.getBlue()));
        }
        return true;

    }

}
