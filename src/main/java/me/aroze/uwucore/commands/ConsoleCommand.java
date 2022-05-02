package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConsoleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("*")) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou aren't allowed to do this! smh!"));
            return true;
        }

        if (args.length >= 1) {

            String fullCommand = String.join(" ", args);

            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), fullCommand);
            sender.sendMessage(ChatUtils.color("&#eb9bb7✔ &#ffd4e3Executed console command: &#eb9bb7/" + fullCommand));
            return true;
        }

        sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou must specify a command to be executed."));
        return true;

    }

}
