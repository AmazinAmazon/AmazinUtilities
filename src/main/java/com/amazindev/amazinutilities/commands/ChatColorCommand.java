package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ChatColorCommand implements CommandExecutor {

    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);
    public static HashMap<Player, String> hashmapcolor = new HashMap<>();
    public static HashMap<Player, String> hashmapstyle = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("amazinutilities.customchat")) {
                if(args.length > 0) {
                    if(args[0].equals("reset")) {
                        hashmapstyle.put(player, "reset");
                        player.sendMessage(ChatColor.GREEN + "Your chat color and your style have been reset");
                    } else {
                        if(args[0].equals("aqua") | args[0].equals("red") | args[0].equals("black") | args[0].equals("blue") | args[0].equals("dark_aqua") | args[0].equals("dark_blue") | args[0].equals("dark_gray") | args[0].equals("dark_green") | args[0].equals("dark_purple") | args[0].equals("dark_red") | args[0].equals("gold") | args[0].equals("gray") | args[0].equals("green") | args[0].equals("light_purple") | args[0].equals("white") | args[0].equals("yellow")) {
                            hashmapcolor.put(player, args[0]);
                            if(args.length > 1) {
                                if(args[1].equals("bold") | args[1].equals("italic") | args[1].equals("magic") | args[1].equals("strikethrough") | args[1].equals("underline")) {
                                    hashmapstyle.put(player, args[1]);
                                    player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("colorSet") + args[0] + "and " + args[1]);
                                } else {
                                    player.sendMessage(ChatColor.RED + plugin.getConfig().getString("colorUnavailable"));
                                }
                            } else {
                                player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("colorSet") + args[0]);
                            }
                        } else {
                            player.sendMessage(ChatColor.RED + plugin.getConfig().getString("colorUnavailable"));
                        }
                    }
                } else {
                    return false;
                }

            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.customchat)");
            }
        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }

        return true;
    }
}
