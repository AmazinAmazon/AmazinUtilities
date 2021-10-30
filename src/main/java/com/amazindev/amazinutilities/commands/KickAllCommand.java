package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickAllCommand implements CommandExecutor {

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
                sender.sendMessage(ChatColor.RED + "Succesfully kicked everyone");
            } else {
                return false;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.kickall)");
        }

        return true;
    }
}
