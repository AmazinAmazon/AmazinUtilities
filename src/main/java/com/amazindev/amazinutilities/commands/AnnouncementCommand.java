package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnnouncementCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        StringBuilder announcedesc1 = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            announcedesc1.append(args[i] + " ");
        }


        String announcedesc2 = announcedesc1.toString().trim();
        Bukkit.broadcastMessage(ChatColor.RED + "Announcement by " + sender + " : " + ChatColor.GOLD + announcedesc2);
        return true;
    }
}
