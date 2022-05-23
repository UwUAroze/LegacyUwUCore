package me.aroze.uwucore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class TestTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> tabComplete = new ArrayList<>();
        if (args[0].equals("tabfruit")) {
            if (args.length == 2) {
                tabComplete.add("Pear");
                tabComplete.add("Orange");
                tabComplete.add("Apple");
                tabComplete.add("Banana");
            }
            if (args.length == 3) {
                tabComplete.add("a");
                tabComplete.add("b");
                tabComplete.add("c");
            }
        }
        return tabComplete;
    }
}

