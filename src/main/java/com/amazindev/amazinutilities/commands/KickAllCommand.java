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

public class KickAllCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);
    public FileConfiguration config = plugin.getConfig();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("amazinutilities.kickall")) {
            if (args.length > 0) {
                for(Player target : Bukkit.getOnlinePlayers()) {
                    StringBuilder reason1 = new StringBuilder();
                    for (int i = 0; i < args.length; i++) {
                        reason1.append(args[i] + " ");
                    }


                    String reason2 = reason1.toString().trim();
                    if(sender instanceof Player) {
                        Player player = (Player) sender;
                        if(target != player) {
                            target.kickPlayer(reason2);
                        }
                    } else {
                        target.kickPlayer(reason2);
                    }
                }
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("successfullyKickedEveryone"));
            } else {
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.kickall)");
        }

        return true;
    }
}
