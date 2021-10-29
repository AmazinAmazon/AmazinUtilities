package com.amazindev.amazinutilities.listeners;

import com.amazindev.amazinutilities.commands.AfkCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;

public class MovementListener implements Listener {
    ArrayList<Player> afkList = AfkCommand.afkList;
    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        if(afkList.contains(player)) {
            player.sendMessage(ChatColor.YELLOW + "You are now back from being AFK");
            Bukkit.broadcastMessage(ChatColor.GRAY + player.getDisplayName() + " is back from being AFK");
            afkList.remove(player);
            player.setInvulnerable(false);
            player.setCollidable(true);
        }
    }

}
