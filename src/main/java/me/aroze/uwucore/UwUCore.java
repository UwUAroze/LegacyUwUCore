package me.aroze.uwucore;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import me.aroze.uwucore.commands.*;
import me.aroze.uwucore.listeners.*;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class UwUCore extends JavaPlugin {

    public static HashMap<UUID, UUID> recentMessager = new HashMap<>();
    public static ProtocolManager protocolManager;
    public static ItemStack kittyGun = new ItemStack(Material.END_ROD);

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
        getCommand("kittygun").setExecutor(new KittyGunCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("punish").setExecutor(new PunishCommand());
        getCommand("playtime").setExecutor(new PlaytimeCommand());
        getCommand("msg").setExecutor(new MessageCommand());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("setbites").setExecutor(new SetBitesCommand());
        getCommand("hat").setExecutor(new HatCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());

        getCommand("test").setTabCompleter(new TestTabComplete());

        getServer().getPluginManager().registerEvents(new Chat(), this);
        getServer().getPluginManager().registerEvents(new Knockback(), this);
        getServer().getPluginManager().registerEvents(new JoinQuit(), this);
        getServer().getPluginManager().registerEvents(new Interact(), this);
        getServer().getPluginManager().registerEvents(new ServerListPing(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);

        ItemMeta kittyGunMeta = kittyGun.getItemMeta();
        kittyGunMeta.setDisplayName(ChatUtils.color("&#b9ffb3Kitty Gun"));
        kittyGun.setItemMeta(kittyGunMeta);

        protocolManager = ProtocolLibrary.getProtocolManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static UwUCore getInstance() {
        return getPlugin(UwUCore.class);
    }

}
