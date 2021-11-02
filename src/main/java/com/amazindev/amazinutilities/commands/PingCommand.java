package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PingCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("amazinutilities.ping")) {
                Player player = (Player) sender;
                player.sendMessage(plugin.getConfig().getString("ping") + player.getPing());
            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.afk)");
            }
        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }

        return true;
    }
}
