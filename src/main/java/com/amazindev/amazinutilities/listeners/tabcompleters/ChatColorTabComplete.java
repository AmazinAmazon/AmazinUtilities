package com.amazindev.amazinutilities.listeners.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class ChatColorTabComplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender,Command cmd, String label, String[] args) {
        if (args.length == 1) {
            List<String> mainArguments = Arrays.asList("aqua", "red", "black", "blue", "dark_aqua", "dark_blue", "dark_grey", "dark_green", "dark_red", "gray", "green", "light_purple", "white", "yellow");
            if (sender.hasPermission("amazinutilities.chatcolor")) {
                return mainArguments;
            }
        }
        return null;
    }

}
