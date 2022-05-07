package me.aroze.uwucore.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
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

        if (e.getAction() == Action.PHYSICAL) return;
        if (e.getHand() == EquipmentSlot.OFF_HAND) return;

        if (e.getItem() != null && e.getItem().getType() == Material.END_ROD) {
            Cat cat = (Cat) Bukkit.getWorld("flat").spawnEntity(e.getPlayer().getEyeLocation(), EntityType.CAT);
            cat.setVelocity((e.getPlayer().getEyeLocation().getDirection()).multiply(2.5));
        }

    }

}
