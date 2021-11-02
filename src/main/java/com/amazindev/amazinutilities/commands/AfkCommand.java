package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class AfkCommand implements CommandExecutor {
    public static ArrayList<Player> afkList = new ArrayList<>();
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("amazinutilities.afk")) {
                if (!afkList.contains(player)) {
                    player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("playerOnAfk"));
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + plugin.getConfig().getString("boadcastOnAfk"));
                    afkList.add(player);
                    player.setInvulnerable(true);
                    player.setCollidable(false);
                } else {
                    player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("playerOffAfk"));
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + plugin.getConfig().getString("broadcastOffAfk"));
                    afkList.remove(player);
                    player.setInvulnerable(false);
                    player.setCollidable(true);
                }
            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.afk)");

            }

        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }


        return true;
    }
}
