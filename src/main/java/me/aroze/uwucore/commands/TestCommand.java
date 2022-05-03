package me.aroze.uwucore.commands;

import me.aroze.uwucore.util.ChatUtils;
import me.aroze.uwucore.UwUCore;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCommand implements CommandExecutor {

    float yaw;
    float pitch;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!sender.hasPermission("*")) {
            sender.sendMessage(ChatUtils.color("&#ff6e6e⚠ &#ff7f6eYou aren't allowed to do this! smh!"));
            return true;
        };

        if (args[0].equals("stand")) {
            ArmorStand stand = (ArmorStand) Bukkit.getWorld("flat").spawnEntity(new Location(Bukkit.getWorld("flat"), 0, -60, 0), EntityType.ARMOR_STAND);

            AtomicInteger i = new AtomicInteger(1000);
            Bukkit.getScheduler().runTaskTimer(UwUCore.getInstance(), (task) -> {
                if (i.get() == 0) {
                    task.cancel();
                    return;
                }
                i.getAndDecrement();
                yaw = (float) Math.random()*180;
                pitch = (float) Math.random()*90;
                stand.setRotation(yaw,pitch);;
            }, 0L, 1);
            return true;
        }

        if (args[0].equals("firework")) {
            Firework firework = ((Player) sender).getWorld().spawn(((Player) sender).getLocation(), Firework.class);
            FireworkMeta meta = (FireworkMeta) firework.getFireworkMeta();
            meta.addEffect(FireworkEffect.builder().withColor(Color.YELLOW).withColor(Color.FUCHSIA).with(FireworkEffect.Type.CREEPER).withFade(Color.AQUA).build());
            meta.setPower(1);
            firework.setFireworkMeta(meta);
            return true;
        }

        if (args[0].equals("potion")) {
            ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
            ((Player) sender).addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 100000, 1, true, true, false));
            return true;
        }

        if (args[0].equals("milk")) {
            for (PotionEffect effect : ((Player) sender).getActivePotionEffects() ) {
                ((Player) sender).removePotionEffect(effect.getType());
            }
        }

        return true;
    }

}
