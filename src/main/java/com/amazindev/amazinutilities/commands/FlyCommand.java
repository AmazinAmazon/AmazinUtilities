package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class FlyCommand implements CommandExecutor {

    public static HashMap<Player, Boolean> hashmap = new HashMap<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("amazinutilities.fly")) {
                Player player = (Player) sender;
                Boolean isEnabled = hashmap.get(player);
                if(isEnabled != null) {
                    if(isEnabled.equals(false)) {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        hashmap.put(player, true);
                    } else {
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        hashmap.put(player, false);
                    }
                } else {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    hashmap.put(player, true);
                }
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.fly)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }

        return true;
    }
}
