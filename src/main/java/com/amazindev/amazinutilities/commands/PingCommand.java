package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("amazinutilities.ping")) {
                Player player = (Player) sender;
                player.sendMessage("Your ping is " + player.getPing());
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.afk)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }

        return true;
    }
}
