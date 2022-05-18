package me.aroze.uwucore.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import me.aroze.uwucore.UwUCore;
import me.aroze.uwucore.util.ChatUtils;
import org.bukkit.*;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestCommand implements CommandExecutor {

    public static Inventory inv;
    float yaw;
    float pitch;

    BukkitTask task;

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
            return true;
        }

        if (args[0].equals("banner")) {
            ItemStack banner = new ItemStack(Material.PINK_BANNER);
            BannerMeta bannerMeta = (BannerMeta) banner.getItemMeta();

            List<Pattern> patterns = new ArrayList<>();
            patterns.add(new Pattern(DyeColor.BROWN, PatternType.RHOMBUS_MIDDLE));
            patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_MIDDLE));
            patterns.add(new Pattern(DyeColor.PINK, PatternType.HALF_HORIZONTAL));
            patterns.add(new Pattern(DyeColor.WHITE, PatternType.CIRCLE_MIDDLE));
            patterns.add(new Pattern(DyeColor.PINK, PatternType.BORDER));

            bannerMeta.setPatterns(patterns);
            banner.setItemMeta(bannerMeta);

            ((Player) sender).getInventory().addItem(banner);
            return true;
        }

        if (args[0].equals("book")) {
            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) book.getItemMeta();

            bookMeta.setTitle(ChatUtils.color("&ctest book!"));
            bookMeta.setAuthor(ChatUtils.color("&dSantio71"));
            bookMeta.addPage(ChatUtils.color((
                    "&1dark blue &2green" +
                    "\n&3cyan &4dark red" +
                    "\n&5purple &6gold" +
                    "\n&7gray &8dark gray" +
                    "\n&9blue &0black" +
                    "\n&alime &baqua" +
                    "\n&cred &dpink"
                    )));

            book.setItemMeta(bookMeta);
            ((Player) sender).getInventory().addItem(book);
            return true;
        }

        if (args[0].equals("stress")) {

            ArrayList<Double> lol = new ArrayList<>();

            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                lol.add(Math.random());
            }
            sender.sendMessage(ChatUtils.color("&a" + lol.size() + " random numbers generated"));

            return true;

        }

        if (args[0].equals("delay")) {
            for (int i = 0; i <= 10; i++) {
                int finalI = i;
                Bukkit.getScheduler().runTaskLater(UwUCore.getInstance(), () -> {
                    sender.sendMessage(ChatUtils.color("&a" + finalI));
                }, 10 * finalI);
            }
            return true;
        }

        if (args[0].equals("repeat")) {

            if (args.length > 1) {
                if (args[1].equals("stop")) {
                    task.cancel();
                    sender.sendMessage(ChatUtils.color("&cStopped repeating task"));
                    return true;
                }
            }

            AtomicInteger i = new AtomicInteger();
            task = Bukkit.getScheduler().runTaskTimer(UwUCore.getInstance(), () -> {
                i.addAndGet(1);
                sender.sendMessage(ChatUtils.color("&aIt's been &c" + i.get() + " &cseconds &a(/test repeat stop)"));
            } , 0, 20);
        }

        if (args[0].equals("gui")) {
            inv = Bukkit.createInventory((Player) sender, 9, ChatUtils.gradient(255,255,255,255,0,255,"Super cool super epic test gui!"));

            ItemStack wool = new ItemStack(Material.PINK_WOOL, 14);
            ItemMeta woolMeta = wool.getItemMeta();
            woolMeta.setDisplayName(ChatUtils.color("&#a0d9bchohly shiuyt its wool!"));
            woolMeta.setLore(Arrays.asList("\n", ChatUtils.color("&#c2a378woah this is gold"), ChatUtils.color("&#9ae3abwOAH THIS IS GREEN!")));
            wool.setItemMeta(woolMeta);

            ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) book.getItemMeta();
            bookMeta.setDisplayName(ChatUtils.color(ChatUtils.color("&#a0d9bchohly shiuyt its book!")));
            book.setItemMeta(bookMeta);

            inv.setItem(3, wool);
            inv.setItem(5, book);


            ((Player) sender).openInventory(inv);
        }

        return true;
    }

}
