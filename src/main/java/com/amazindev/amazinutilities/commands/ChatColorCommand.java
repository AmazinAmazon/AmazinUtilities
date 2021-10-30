package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ChatColorCommand implements CommandExecutor {

    public static HashMap<Player, String> hashmap = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("amazinutilities.chatcolor")) {
                if(args[0].equals("aqua") | args[0].equals("red") | args[0].equals("black") | args[0].equals("blue") | args[0].equals("dark_aqua") | args[0].equals("dark_blue") | args[0].equals("dark_gray") | args[0].equals("dark_green") | args[0].equals("dark_purple") | args[0].equals("dark_red") | args[0].equals("gold") | args[0].equals("gray") | args[0].equals("green") | args[0].equals("light_purple") | args[0].equals("white") | args[0].equals("yellow")) {
                    hashmap.put(player, args[0]);
                    player.sendMessage(ChatColor.GREEN + "Your chat color has been set to " + args[0]);
                } else {
                    player.sendMessage(ChatColor.RED + "That color isn't available!");
                }

            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.chatcolor)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }

        return true;
    }
}
