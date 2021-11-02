package com.amazindev.amazinutilities.listeners.tabcompleters;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class AmazinUtilitiesTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            List<String> mainArguments = Arrays.asList("reload");
            if (sender.hasPermission("amazinutilities.amazinutilities")) {
                return mainArguments;
            }

        }
        return null;
    }
}

