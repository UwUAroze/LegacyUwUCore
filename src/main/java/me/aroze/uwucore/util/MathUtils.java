package me.aroze.uwucore.util;

public class MathUtils {

    public static String ticksToTimestamp(int ticks) {

        double remainingTicks = ticks;

        int seconds = (ticks/20) % 60;
        int minutes = (ticks/20/60) % 60;
        int hours = (ticks/20/60/60) % 24;
        int days = ticks/20/60/60 / 24;

        return (int) Math.floor(days) + " days, " + (int) Math.floor(hours) + " hours, " + (int) Math.floor(minutes) + " minutes, " + (int) Math.floor(seconds) + " seconds";
    }

}
