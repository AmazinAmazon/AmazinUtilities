package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ShutdownCommand implements CommandExecutor {
    private Plugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("amazinutilities.shutdown")) {
            Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 20 SECONDS, MAKE SURE YOU GET OUT OF COMBAT. SORRY FOR THE INCONVENIENCE.");

            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 15 SECONDS");
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 10 SECONDS");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 5 SECONDS");
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 4 SECONDS");
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 3 SECONDS");
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                    Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 2 SECONDS");
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                        Bukkit.broadcastMessage(ChatColor.RED + "SERVER SHUTTING DOWN IN 1 SECONDS");
                                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                            Bukkit.shutdown();
                                        }, 20*1);
                                    }, 20*1);
                                }, 20*1);
                            }, 20*1);
                        }, 20*1);
                    }, 20*5);
                }, 20*5);
            }, 20*5);
        }

        return true;
    }
}
