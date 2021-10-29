package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.listeners.MovementListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AfkCommand implements CommandExecutor {
    public static ArrayList<Player> afkList = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("amazinutilities.afk")) {
                if (!afkList.contains(player)) {
                    player.sendMessage(ChatColor.YELLOW + "You are now AFK");
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " is now AFK");
                    afkList.add(player);
                    player.setInvulnerable(true);
                    player.setCollidable(false);
                } else {
                    player.sendMessage(ChatColor.YELLOW + "You are now back from being AFK");
                    Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " is back from being AFK");
                    afkList.remove(player);
                    player.setInvulnerable(false);
                    player.setCollidable(true);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.afk)");

            }

        } else {
            sender.sendMessage("This command can only be executed by a player.");
        }


        return true;
    }
}
