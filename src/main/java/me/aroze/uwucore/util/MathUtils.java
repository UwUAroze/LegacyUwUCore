package me.aroze.uwucore.util;

public class MathUtils {

    public static String ticksToTimestamp(int ticks) {

        double remainingTicks = ticks;

        int seconds = (ticks/20) % 60;
        int minutes = (ticks/20/60) % 60;
        int hours = (ticks/20/60/60) % 24;
        int days = ticks/20/60/60 / 24;

        return Math.floor(days) + " days" + Math.floor(hours) + " hours" + Math.floor(minutes) + " minutes" + Math.floor(seconds) + " seconds";
    }

}
