package me.aroze.uwucore;

import me.aroze.uwucore.Util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConsoleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String fullCommand = String.join(" ", args);

        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), fullCommand);
        sender.sendMessage(ChatUtils.color("&a✔ &2&l| &aExecuted console command: &7/" + fullCommand));
        return true;

    }

}
