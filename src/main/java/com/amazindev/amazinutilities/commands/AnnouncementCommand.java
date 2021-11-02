package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AnnouncementCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("amazinutilities.announce")) {
            StringBuilder announcedesc1 = new StringBuilder();
            for (int i = 0; i < args.length; i++) {
                announcedesc1.append(args[i] + " ");
            }

            Player player = (Player) sender;


            String announcedesc2 = announcedesc1.toString().trim();
            Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("announcementBy") + player.getDisplayName() + " : " + ChatColor.GOLD + announcedesc2);
        } else {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.announce)");
        }

        return true;
    }
}
