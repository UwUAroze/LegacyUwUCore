package me.aroze.uwucore.listeners;

import me.aroze.uwucore.util.ChatUtils;
import me.aroze.uwucore.UwUCore;
import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerVelocityEvent;
import org.bukkit.util.Vector;

public class Knockback implements Listener {

//    @EventHandler
//    public void customKB(PlayerVelocityEvent e) {
//        Vector vel = e.getPlayer().getVelocity().clone();
//
//        Bukkit.broadcastMessage(ChatUtils.color("&a" + vel.getX() + ", " + vel.getY() + ", " + vel.getZ()));
//
//
//        vel.setX(vel.getX() * UwUCore.getInstance().getConfig().getDouble("Knockback.XZ"));
//        vel.setY(vel.getY() * UwUCore.getInstance().getConfig().getDouble("Knockback.Y"));
//        vel.setZ(vel.getZ() * UwUCore.getInstance().getConfig().getDouble("Knockback.XZ"));
//
//        if (!e.getPlayer().isOnGround()) {
//            vel.setX(vel.getX() * UwUCore.getInstance().getConfig().getDouble("Knockback.AirXZ"));
//            vel.setZ(vel.getZ() * UwUCore.getInstance().getConfig().getDouble("Knockback.AirXZ"));
//        }
//
////        if (vel.getX() > 0) {
////            vel.setX(0.25);
////        } else {vel.setX(-0.25);}
////
////        if (vel.getZ() > 0) {
////            vel.setZ(0.25);
////        } else {vel.setZ(-0.25);}
////
////        vel.setY(0.3);
//
//        e.setVelocity(vel);
//
//
//        Bukkit.broadcastMessage(ChatUtils.color("&e" + vel.getX() + ", " + vel.getY() + ", " + vel.getZ() + "\n"));
//
//    }
//
//    @EventHandler
//    public void customHitDelay(EntityDamageByEntityEvent e) {
//
//        if (!(e.getDamager() instanceof Player)) return;
//
//        LivingEntity player = (LivingEntity) e.getEntity();
//        player.setNoDamageTicks(UwUCore.getInstance().getConfig().getInt("noDamageTicks"));
//        player.setMaximumNoDamageTicks(UwUCore.getInstance().getConfig().getInt("noDamageTicks"));
//        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(UwUCore.getInstance().getConfig().getInt("attackSpeed"));
//
//    }


}
