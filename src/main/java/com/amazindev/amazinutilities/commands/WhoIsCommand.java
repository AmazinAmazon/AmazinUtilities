package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class WhoIsCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

                if(sender.hasPermission("amazinutilities.whois")) {
                    if(args.length > 0) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if(target != null) {
                            sender.sendMessage("Name: " + target.getDisplayName() + "\nIp: " + target.getAddress().getAddress() + "\nProfile: https://namemc.com/profile/" + target.getDisplayName() + "\nPing: " + target.getPing() + "\nLocation: X." + target.getLocation().getBlockX() + " Y." + target.getLocation().getBlockY() + " Z." + target.getLocation().getBlockZ() + "\nWorld: " + target.getWorld().getName() + "\nBed Spawn Location: " + target.getBedSpawnLocation() + "\nExp: " + target.getExp() + "\nLevel: " + target.getLevel() + "\nHealth: " + target.getHealth() + "\nFood Level: " + target.getFoodLevel() + "\nGamemode: " + target.getGameMode() + "\nServer: " + target.getServer().getName());
                        } else {
                            sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("playerNotFound"));
                        }
                    } else {
                        return false;
                    }
                } else {
                    sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.whois)");
                }

        return true;
    }
}
