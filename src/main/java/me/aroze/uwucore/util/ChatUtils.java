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

    public static String gradient(int red1,int green1,int blue1, int red2,int green2,int blue2, String text) {

        String[] textSplit = text.split("");

        String newText = "";
        String colour = "";
        int spaces = 0;

        for (int i=0; i<text.length(); i++) {
            if (textSplit[i].equals(" ")) {
                spaces ++;
            }
        }

        double stepRed = (red2 - red1) / (text.length() - spaces);
        double stepGreen = (green2 - green1) / (text.length() - spaces);
        double stepBlue = (blue2 - blue1) / (text.length() - spaces);

        for (int i=0; i<text.length(); i++) {

            if (textSplit[i].equals(" ")) {
                newText += " ";
                continue;
            }

            red1 += stepRed;
            green1 += stepGreen;
            blue1 += stepBlue;

            colour = String.format("#%02x%02x%02x", red1, green1, blue1);
            newText += "&" + colour + textSplit[i];
        }

        return color(newText);
    }

}
