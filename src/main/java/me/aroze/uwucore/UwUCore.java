package me.aroze.uwucore;

import org.bukkit.plugin.java.JavaPlugin;

public final class UwUCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("console").setExecutor(new ConsoleCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
