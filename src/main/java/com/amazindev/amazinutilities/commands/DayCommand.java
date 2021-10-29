package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DayCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("amazinutilities.setday")) {
                player.getWorld().setTime(1000);
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.setday)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }

        return true;
    }
}
