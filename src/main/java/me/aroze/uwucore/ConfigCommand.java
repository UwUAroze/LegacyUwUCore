package me.aroze.uwucore;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ConfigCommand implements CommandExecutor {

    private UwUCore main;

    public ConfigCommand(UwUCore main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            player.sendMessage(ChatUtils.color("\n&e&lConfig:\n"));
            player.sendMessage(ChatUtils.color("  &7testWord: &f" + main.getConfig().getString("testWord")));
            player.sendMessage(ChatUtils.color("  &7testNumber: &f" + main.getConfig().getInt("testNumber") + ""));
            if (main.getConfig().getBoolean("testBoolean")) {
                player.sendMessage(ChatUtils.color("  &7testBoolean: &aEnabled"));
            } else {player.sendMessage(ChatUtils.color("  &7testBoolean: &cDisabled"));}

            player.sendMessage(ChatUtils.color("\n  &7testStringList:"));
            for (String string : main.getConfig().getStringList("testStringList")) {
                player.sendMessage(ChatUtils.color("    - " + string));
            }

        }

        return false;
    }
}
