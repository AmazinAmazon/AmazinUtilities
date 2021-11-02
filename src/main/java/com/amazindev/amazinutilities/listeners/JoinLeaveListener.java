package com.amazindev.amazinutilities.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class JoinLeaveListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        Location location = player.getLocation();
        if (player.hasPlayedBefore()) {
            e.setJoinMessage(ChatColor.YELLOW + "Welcome back " + player.getName());
        } else {
            e.setJoinMessage(ChatColor.LIGHT_PURPLE + "Welcome " + player.getName() + " to the server! Have fun!");

            Firework firework = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
            FireworkMeta fireworkMeta = firework.getFireworkMeta();
            fireworkMeta.setPower(1);
            fireworkMeta.addEffect(FireworkEffect.builder().withColor(Color.AQUA).flicker(true).trail(true).withFade(Color.BLUE).build());
            firework.setFireworkMeta(fireworkMeta);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(ChatColor.YELLOW + "" + player.getName() + " has left the server. See you soon!");
    }
}
