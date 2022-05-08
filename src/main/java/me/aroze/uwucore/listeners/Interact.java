package me.aroze.uwucore.listeners;

import me.aroze.uwucore.UwUCore;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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

        String heldItem = e.getItem().getItemMeta().getDisplayName();
        String kittyGun = UwUCore.kittyGun.getItemMeta().getDisplayName();

        if (e.getAction() == Action.PHYSICAL) return;
        if (e.getHand() == EquipmentSlot.OFF_HAND) return;
        if (e.getItem() == null) return;

        if (heldItem.equals(kittyGun)) {
            Cat cat = (Cat) Bukkit.getWorld("flat").spawnEntity(e.getPlayer().getEyeLocation(), EntityType.CAT);
            cat.setVelocity((e.getPlayer().getEyeLocation().getDirection()).multiply(2.5));
        }

    }

}
