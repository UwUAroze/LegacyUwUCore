package me.aroze.uwucore.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import me.aroze.uwucore.util.ChatUtils;
import me.aroze.uwucore.UwUCore;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
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
            return true;
        }

        if (args[0].equals("gradient")) {
            ArrayList<String> text = new ArrayList<>(Arrays.asList(args));
            Bukkit.broadcastMessage(ChatUtils.gradient(
                    Integer.parseInt(args[1]),
                    Integer.parseInt(args[2]),
                    Integer.parseInt(args[3]),
                    Integer.parseInt(args[4]),
                    Integer.parseInt(args[5]),
                    Integer.parseInt(args[6]),
                    String.join(" ", text.subList(7, text.size()))
            ));
            return true;
        }

        if (args[0].equals("bossbar")) {
            BossBar bossBar = Bukkit.createBossBar(
                args[1],
                BarColor.PURPLE,
                BarStyle.SOLID
            );
            bossBar.addPlayer((Player) sender);
            return true;
        }

        if (args[0].equals("sound")) {
            ((Player) sender).playSound(((Player) sender).getLocation(), Sound.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, Float.parseFloat(args[1]));
            return true;
        }

        if (args[0].equals("particle")) {
            if (args[1].equals("player")) {
                ((Player) sender).spawnParticle(Particle.DRAGON_BREATH, ((Player) sender).getLocation(), 20);
            }
            if (args[1].equals("world")) {
                ((Player) sender).getWorld().spawnParticle(Particle.WATER_BUBBLE, ((Player) sender).getLocation().add(0,2,0), 20);
            }
            return true;
        }

        if (args[0].equals("gamestate")) {
            PacketContainer packet = new PacketContainer(PacketType.Play.Server.GAME_STATE_CHANGE);

            if (args[2].equals("credits")) {
                packet.getGameStateIDs().write(0, 4);
                packet.getFloat().write(0, 1.0F);
            }

            if (args[2].equals("demo")) {
                packet.getGameStateIDs().write(0, 5);
                packet.getFloat().write(0, 0F);
            }

            if (args[2].equals("custom")) {
                packet.getGameStateIDs().write(0, Integer.valueOf(args[3]));
                packet.getFloat().write(0, Float.valueOf(args[4]));
            }

            try {
                UwUCore.protocolManager.sendServerPacket(Bukkit.getPlayer(args[1]), packet);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(
                        "Cannot send packet " + packet, e);
            }
        }

        return true;
    }

}
