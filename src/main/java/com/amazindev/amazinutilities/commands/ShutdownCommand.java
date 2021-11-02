package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class ShutdownCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender.hasPermission("amazinutilities.shutdown")) {
            Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown"));

            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown15"));
                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                    Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown10"));
                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                        Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown4"));
                        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                            Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown3"));
                            Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown2"));
                                Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                    Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("serverShuttingDown1"));
                                    Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, () -> {
                                        Bukkit.broadcastMessage(ChatColor.RED + plugin.getConfig().getString("noPerms"));
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
        } else {
            sender.sendMessage(plugin.getConfig().getString("noPerms") + "(amazinutilities.shutdown)");
        }

        return true;
    }
}
