package me.aroze.uwucore.Listeners;

import me.aroze.uwucore.Util.ChatUtils;
import me.aroze.uwucore.UwUCore;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.util.Vector;

public class Knockback implements Listener {

    @EventHandler
    public void uhh(PlayerVelocityEvent e) {
        Vector vel = e.getVelocity();

        Bukkit.broadcastMessage(ChatUtils.color("&a" + vel.getX() + ", " + vel.getY() + ", " + vel.getZ()));

        vel.setX(vel.getX() * UwUCore.getInstance().getConfig().getDouble("Knockback.X"));
        vel.setY(vel.getY() * UwUCore.getInstance().getConfig().getDouble("Knockback.Y"));
        vel.setZ(vel.getZ() * UwUCore.getInstance().getConfig().getDouble("Knockback.Z"));



        Bukkit.broadcastMessage(ChatUtils.color("&e" + vel.getX() + ", " + vel.getY() + ", " + vel.getZ() + "\n"));

    }


}
