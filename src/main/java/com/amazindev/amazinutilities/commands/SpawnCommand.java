package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location spawn = player.getWorld().getSpawnLocation();

            if (player.hasPermission("amazinutilities.spawn")) {
                player.teleport(spawn);
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.spawn)");
            }

        } else {
            sender.sendMessage("You have to be a player to execute this command");
        }
        return true;
    }
}
