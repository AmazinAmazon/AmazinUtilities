package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TphereCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("amazinutilies.tphere")) {
                if(args.length > 0) {
                    Player player = (Player) sender;
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        target.teleport(player);
                    } else {
                        sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("playerNotFound"));
                    }
                } else {
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.tphere)");
            }
        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }
        return true;
    }
}
