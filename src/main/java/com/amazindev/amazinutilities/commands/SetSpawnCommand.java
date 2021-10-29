package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                World world = player.getWorld();
                if (player.hasPermission("amazinutilities.setspawn")) {
                    world.setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ(), player.getLocation().getYaw());
                    player.sendMessage(ChatColor.GREEN + "Spawn set successfully");
                } else {
                    player.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.setspawn)");
                }
            } else {
                sender.sendMessage("You have to be a player to execute this command");
            }
            return true;
        }
}
