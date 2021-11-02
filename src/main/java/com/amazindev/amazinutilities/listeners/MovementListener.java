package com.amazindev.amazinutilities.listeners;

import com.amazindev.amazinutilities.AmazinUtilities;
import com.amazindev.amazinutilities.commands.AfkCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class MovementListener implements Listener {
    ArrayList<Player> afkList = AfkCommand.afkList;
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);
    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if(afkList.contains(player)) {
            player.sendMessage(ChatColor.YELLOW + plugin.getConfig().getString("playerOffAfk"));
            Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + plugin.getConfig().getString("broadcastOffAfk"));
            afkList.remove(player);
            player.setInvulnerable(false);
            player.setCollidable(true);
        }
    }

}
