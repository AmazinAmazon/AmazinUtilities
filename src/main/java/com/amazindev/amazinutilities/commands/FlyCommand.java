package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class FlyCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    public ArrayList<Player> playerArrayList = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("amazinutilities.fly")) {
                Player player = (Player) sender;
                if (playerArrayList.contains(player)) {
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    playerArrayList.remove(player);
                    player.sendMessage(ChatColor.RED + "Disabled flight");
                } else {
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    playerArrayList.add(player);
                    player.sendMessage(ChatColor.GREEN + "Enabled flight");
                }
            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.fly)");
            }
        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }

        return true;
    }
}
