package me.aroze.uwucore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCommand implements CommandExecutor {

    float yaw;
    float pitch;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ArmorStand stand = (ArmorStand) Bukkit.getWorld("flat").spawnEntity(new Location(Bukkit.getWorld("flat"), 0, -60, 0), EntityType.ARMOR_STAND);

//        AtomicInteger i = new AtomicInteger(100);
//        Bukkit.getScheduler().runTaskTimer(UwUCore.getInstance(), (task) -> {
//            if (i.get() == 0) {
//                task.cancel();
//                return;
//            }
//            i.getAndDecrement();
//            yaw = (float) Math.random()*180;
//            pitch = (float) Math.random()*90;
//            stand.setRotation(yaw,pitch);;
//        }, 0L, 1);


        return true;
    }

    @EventHandler
    public void kbGoBrrrr(EntityDamageEvent e) {
        e.getEntity().setVelocity(new Vector(1.5,1.5,1.5));
    }

}
