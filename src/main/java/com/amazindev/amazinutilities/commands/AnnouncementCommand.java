package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AnnouncementCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("amazinutilities.announce")) {
            StringBuilder announcedesc1 = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                announcedesc1.append(args[i] + " ");
            }

            Player player = (Player) sender;


            String announcedesc2 = announcedesc1.toString().trim();
            Bukkit.broadcastMessage(ChatColor.RED + "Announcement by " + player.getDisplayName() + " : " + ChatColor.GOLD + announcedesc2);
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.announce)");
        }

        return true;
    }
}
