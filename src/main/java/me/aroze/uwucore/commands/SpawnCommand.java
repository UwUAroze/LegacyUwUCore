package me.aroze.uwucore.commands;

import me.aroze.uwucore.UwUCore;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

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

        player.sendMessage(ChatUtils.color("&#ffd4e3Try not to move for the next &#eb9bb7" + spawnTimer + " &#ffd4e3or so seconds!"));



        BukkitTask spawnTask = new BukkitRunnable() {

            Location startLoc = player.getLocation();
            int ticks = 1;

            @Override
            public void run() {
                ticks++;
                if (ticks >= spawnTimer*20)  {
                    player.teleport(spawnLoc);
                    player.sendMessage(ChatUtils.color("&#eb9bb7✔ &#ffd4e3You've been teleported to spawn. woah!"));
                    this.cancel();
                    return;
                }
                if (player.getLocation().distance(startLoc) > 0.5) {
                    player.sendMessage(ChatUtils.color("a"));
                    this.cancel();
                    return;
                }
            }

        }.runTaskTimer(UwUCore.getInstance(), 0, 1);

        return true;
    }

}
