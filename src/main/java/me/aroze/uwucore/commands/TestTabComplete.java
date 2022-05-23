package me.aroze.uwucore.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {

        List<String> tabComplete = new ArrayList<>();
        if (args[0].equals("tabfruit")) {
            if (args.length == 2) {
                return StringUtil.copyPartialMatches(args[1], Arrays.asList("apple", "banana", "orange", "pear"), new ArrayList<>());
            }
            if (args.length == 3) {
                tabComplete.add("aaa");
                tabComplete.add("bbb");
                tabComplete.add("ccc");
                tabComplete.add("123");
                tabComplete.add("dafssdf");
                tabComplete.add("abc");
            }
        }
        return tabComplete;
    }
}

