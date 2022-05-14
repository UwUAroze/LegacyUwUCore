package me.aroze.uwucore.util;

public class MathUtils {

    public static String ticksToTimestamp(int ticks) {
        double seconds = ticks / 20;
        double minutes = seconds / 60;
        double hours = minutes / 60;
        double days = hours / 24;

        return Math.floor(days) + " days" + Math.floor(hours) + " hours" + Math.floor(minutes) + " minutes" + Math.floor(seconds) + " seconds";
    }

}
