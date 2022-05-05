package me.aroze.uwucore.util;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatUtils {

    private static final Pattern hexPattern = Pattern.compile("&#[a-fA-F0-9]{6}");

    public static String color(String text) {
        Matcher match = hexPattern.matcher(text);
        while (match.find()) {
            String color = text.substring(match.start(), match.end());
            text = text.replace(color, ChatColor.of(color.substring(1)).toString());
            match = hexPattern.matcher(text);
        }
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String gradient(double red1,double green1,double blue1, double red2,double green2,double blue2, String text) {

        String[] textSplit = text.split("");

        String newText = "";
        String colour = "";

        double stepRed = (red2 - red1) / text.length();
        double stepGreen = (green2 - green1) / text.length();
        double stepBlue = (blue2 - blue1) / text.length();

        for (int i=0; i<text.length(); i++) {
            red1 += stepRed;
            green1 += stepGreen;
            blue1 += stepBlue;

            colour = String.format("#%02x%02x%02x", red1, green1, blue1);
            newText += "&" + colour + textSplit[i];
        }

        return color(newText);
    }

}
