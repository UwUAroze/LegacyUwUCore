package me.aroze.uwucore.Util;

import net.md_5.bungee.api.ChatColor;

public class ChatUtils {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

}
