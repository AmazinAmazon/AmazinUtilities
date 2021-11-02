package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import me.rayzr522.jsonmessage.JSONMessage;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AmazinUtilitiesCommand implements CommandExecutor {

    AmazinUtilities plugin;

    public AmazinUtilitiesCommand(AmazinUtilities plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("reload")) {
                if (sender.hasPermission("amazinutilities.reload")) {
                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullyReloadedConfig"));
                } else {
                    sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.reload)");
                }
            }
        } else {
//            sender.sendMessage(ChatColor.YELLOW + "|----------------------------------------------------|" + ChatColor.GRAY + "\nYour current version is " + ChatColor.YELLOW + AmazinUtilities.version + ChatColor.GRAY + ".\nPlugin made by AmazinAmazon and Enrimangamer on github: https://github.com/AmazinAmazon/AmazinUtilities \nCheck out the plugin here: https://www.spigotmc.org/resources/amazinutilities.97240/\n" + ChatColor.YELLOW + "|----------------------------------------------------|");
            JSONMessage.create("|-------------------------------------------|").color(ChatColor.YELLOW)
                    .then("\nYour current version is ").color(ChatColor.GRAY)
                    .then(AmazinUtilities.version + "").color(ChatColor.GREEN)
                    .then(".\n").color(ChatColor.GRAY)
                    .then("\nPlugin made by AmazinAmazon and Enrimangamer on \ngithub ").color(ChatColor.GRAY)
                    .then("here\n").color(ChatColor.GRAY).style(ChatColor.UNDERLINE).tooltip("Click to open the github repository").openURL("https://github.com/AmazinAmazon/AmazinUtilities")
                    .then("\nCheck out the plugin on spigot ").color(ChatColor.GRAY)
                    .then("here\n").color(ChatColor.GRAY).style(ChatColor.UNDERLINE).tooltip("Click to open spigot").openURL("https://www.spigotmc.org/resources/amazinutilities.97240/")
                    .then("|-------------------------------------------|").color(ChatColor.YELLOW)
                    .send((Player) sender);

        }
        return true;
    }
}
