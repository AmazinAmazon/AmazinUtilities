package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TphereCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender.hasPermission("amazinutilies.tphere")) {
            if(args.length > 0) {
                Player player = (Player) sender;
                String target = args[0];
                Player target1 = Bukkit.getPlayer(target);
                if(target1 != null) {
                    target1.teleport(player);
                } else {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist or isn't online");
                }
            } else {
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.tphere)");
        }


        return true;
    }
}
