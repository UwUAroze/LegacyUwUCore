package me.aroze.uwucore;

import me.aroze.uwucore.commands.*;
import me.aroze.uwucore.listeners.Interact;
import me.aroze.uwucore.listeners.JoinQuit;
import me.aroze.uwucore.listeners.Knockback;
import org.bukkit.plugin.java.JavaPlugin;

public final class UwUCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        saveDefaultConfig();

        getCommand("config").setExecutor(new ConfigCommand(this));
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("broadcast").setExecutor(new BroadcastCommand());
        getCommand("console").setExecutor(new ConsoleCommand());
        getCommand("test").setExecutor(new TestCommand());
        getCommand("colouredarmor").setExecutor(new ColouredArmorCommand());

        getServer().getPluginManager().registerEvents(new Knockback(), this);
        getServer().getPluginManager().registerEvents(new JoinQuit(), this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static UwUCore getInstance() {
        return getPlugin(UwUCore.class);
    }

}
