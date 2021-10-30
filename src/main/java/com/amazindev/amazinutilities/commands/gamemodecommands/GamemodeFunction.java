package com.amazindev.amazinutilities.commands.gamemodecommands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeFunction {

    public static void Gamemode(String[] args, CommandSender sender, String permission, String othersPermission, GameMode gameMode) {
        if (args.length > 0) {
            if (sender.hasPermission(permission)) {
                String targetArg = args[0];
                Player target = Bukkit.getPlayer(targetArg);
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "That player doesn't exist or isn't online");
                } else {
                    target.setGameMode(gameMode);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command ("+othersPermission+")");
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(permission)) {
                    player.setGameMode(gameMode);
                } else {
                    sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command ("+othersPermission+")");
                }
            } else {
                sender.sendMessage("This command can only be executed by a player");
            }
        }
    }

}
