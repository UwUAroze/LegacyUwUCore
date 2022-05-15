package me.aroze.uwucore.commands;

import me.aroze.uwucore.UwUCore;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ReplyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eUsage: /reply <message>"));
            return true;
        }

        if (!(UwUCore.recentMessager.containsKey(((Player) sender).getUniqueId()))) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eNobody has messaged you, use /msg!"));
            return true;
        }

        Player target = Bukkit.getPlayer(UwUCore.recentMessager.get(((Player) sender).getUniqueId()));
        String message = ChatUtils.color(String.join(" ", args));

        sender.sendMessage(ChatUtils.color("&#b4a2db[&#ccbbf0To " + target.getName() + "&#b4a2db] &#eb94af" + message));
        target.sendMessage(ChatUtils.color("&#b4a2db[&#ccbbf0From " + sender.getName() + "&#b4a2db] &#eb94af" + message));

        return true;
    }
}
