package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location spawn = player.getWorld().getSpawnLocation();

            if (player.hasPermission("amazinutilities.spawn")) {
                player.teleport(spawn);
                player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("spawnConfirm"));
            } else {
                player.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.spawn)");
            }

        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }
        return true;
    }
}
