package com.amazindev.amazinutilities.commands.gamemodecommands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class GamemodeFunction {
    public static JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    public static void Gamemode(String[] args, CommandSender sender, String permission, String othersPermission, GameMode gameMode) {
        if (args.length > 0) {
            if (sender.hasPermission(permission)) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("playerNotFound"));
                } else {
                    target.setGameMode(gameMode);
                }
            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "("+othersPermission+")");
            }
        } else {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission(permission)) {
                    player.setGameMode(gameMode);
                } else {
                    sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "("+permission+")");
                }
            } else {
                sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
            }
        }
    }

}
