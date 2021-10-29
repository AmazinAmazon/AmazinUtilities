package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeSurvivalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if (args.length > 0) {
            if (player.hasPermission("amazinutilities.gamemode.survival.others")) {
                String targetArg = args[0];
                Player target = Bukkit.getPlayer(targetArg);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "That player doesn't exist or isn't online");
                } else {
                    target.setGameMode(GameMode.SURVIVAL);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.gamemode.survival.others)");
            }
        } else {
            if (player.hasPermission("amazinutilities.gamemode.survival")) {
                player.setGameMode(GameMode.SURVIVAL);
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.gamemode.survival)");
            }
        }

        return true;
    }
}
