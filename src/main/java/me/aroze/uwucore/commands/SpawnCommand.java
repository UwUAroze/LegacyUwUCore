package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        Location spawnLoc = player.getWorld().getSpawnLocation(); // for now just gets world spawn, /setspawn soon:tm:
        int spawnTimer = 3; //in seconds and should be a config option soon.

        // Instant spawning (if config option for spawn timer is set to 0 (or less))
        if (spawnTimer <= 0) {
            player.teleport(spawnLoc);
            player.sendMessage(ChatUtils.color("&#eb9bb7✔ &#ffd4e3You've been teleported to spawn. woah!"));
            return true;
        }

        return true;
    }
}
