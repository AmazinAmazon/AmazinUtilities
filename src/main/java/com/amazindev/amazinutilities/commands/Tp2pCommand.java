package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp2pCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("amazinutilies.tp2person")) {
                if(args.length > 0) {
                    Player player = (Player) sender;
                    Player target = Bukkit.getPlayer(args[0]);
                    if(target != null) {
                        player.teleport(target);
                    } else {
                        sender.sendMessage(ChatColor.RED + "That player doesn't exist or isn't online");
                    }
                } else {
                    return false;
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.tp2person)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }
        return true;
    }
}
