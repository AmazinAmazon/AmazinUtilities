package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpallCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            if (sender.hasPermission("amazinutilies.tpall")) {
                Player player = (Player) sender;
                for(Player target : Bukkit.getOnlinePlayers()) {
                    target.teleport(player);
                }

            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.tpall)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }

        return true;
    }
}
