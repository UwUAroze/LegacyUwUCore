package me.aroze.uwucore.util;

public class MathUtils {

    public static String ticksToTimestamp(int ticks) {

        double remainingTicks = ticks;

        int seconds = (ticks/20) % 60;
        int minutes = (ticks/20/60) % 60;
        int hours = (ticks/20/60/60) % 24;
        int days = ticks/20/60/60 / 24;

        return Integer.parseInt("" + Math.floor(days)) + " days, " + Integer.parseInt("" + Math.floor(hours)) + " hours, " + Integer.parseInt("" + Math.floor(minutes)) + " minutes, " + Integer.parseInt("" + Math.floor(seconds)) + " seconds";
    }

}
