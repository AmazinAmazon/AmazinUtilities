package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class SetSpawnCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                World world = player.getWorld();
                if (player.hasPermission("amazinutilities.setspawn")) {
                    world.setSpawnLocation(player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ(), player.getLocation().getYaw());
                    player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullySetSpawn"));
                } else {
                    player.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.setspawn)");
                }
            } else {
                sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
            }
            return true;
        }
}
