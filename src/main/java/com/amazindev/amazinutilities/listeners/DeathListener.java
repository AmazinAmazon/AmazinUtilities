package com.amazindev.amazinutilities.listeners;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeathListener implements Listener {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if(player.hasPermission("amazinutilities.deathcords")) {
            player.sendMessage(ChatColor.GOLD + plugin.getConfig().getString("deathLocation") + "X." + player.getLocation().getBlockX() + " Y." + player.getLocation().getBlockY() + " Z." + player.getLocation().getBlockZ());
        }

    }

}
