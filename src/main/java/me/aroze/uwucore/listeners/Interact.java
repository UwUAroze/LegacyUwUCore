package me.aroze.uwucore.listeners;

import me.aroze.uwucore.UwUCore;
import org.bukkit.entity.Cat;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class Interact implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        if (e.getItem() == null) return;
        if (e.getAction() == Action.PHYSICAL) return;
        if (e.getHand() == EquipmentSlot.OFF_HAND) return;

        String heldItem = e.getItem().getItemMeta().getDisplayName();
        String kittyGun = UwUCore.kittyGun.getItemMeta().getDisplayName();

        if (heldItem.equals(kittyGun)) {
            Cat cat = (Cat) e.getPlayer().getWorld().spawnEntity(e.getPlayer().getEyeLocation(), EntityType.CAT);
            cat.setVelocity((e.getPlayer().getEyeLocation().getDirection()).multiply(2.5));
        }

    }

}
