package me.aroze.uwucore.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.util.Vector;

public class Knockback implements Listener {

    @EventHandler
    public void kbGoBrrrr(EntityDamageEvent e) {
        e.getEntity().setVelocity(new Vector(1.5,1.5,1.5));
    }

}
