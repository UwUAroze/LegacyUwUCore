package me.aroze.uwucore.listeners;

import me.aroze.uwucore.commands.TestCommand;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(org.bukkit.event.inventory.InventoryClickEvent e) {
        if (e.getInventory() == TestCommand.inv) {
            e.setCancelled(true);
            e.getWhoClicked().sendMessage("§cclicc! §7" + e.getAction());
        }
    }


}
