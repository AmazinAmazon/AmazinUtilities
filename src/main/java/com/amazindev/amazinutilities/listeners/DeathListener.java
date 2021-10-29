package com.amazindev.amazinutilities.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity().getPlayer();

        if(player.hasPermission("amazinutilities.deathcords")) {
            player.sendMessage(ChatColor.GOLD + "Your death location is: X." + player.getLocation().getBlockX() + " Y." + player.getLocation().getBlockY() + " Z." + player.getLocation().getBlockZ());
        }

    }

}
