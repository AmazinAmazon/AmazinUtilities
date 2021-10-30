package com.amazindev.amazinutilities.listeners;

import com.amazindev.amazinutilities.commands.ChatColorCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MessageListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        String color = ChatColorCommand.hashmap.get(player);
            if(color != null) {
                if(color.equals("aqua")) {
                    event.setMessage(ChatColor.AQUA + message);
                }
                if(color.equals("red")) {
                    event.setMessage(ChatColor.RED + message);
                }
                if(color.equals("black")) {
                    event.setMessage(ChatColor.BLACK + message);
                }
                if(color.equals("blue")) {
                    event.setMessage(ChatColor.BLUE + message);
                }
                if(color.equals("dark_aqua")) {
                    event.setMessage(ChatColor.DARK_AQUA + message);
                }
                if(color.equals("dark_blue")) {
                    event.setMessage(ChatColor.DARK_BLUE + message);
                }
                if(color.equals("dark_gray")) {
                    event.setMessage(ChatColor.DARK_GRAY + message);
                }
                if(color.equals("dark_green")) {
                    event.setMessage(ChatColor.DARK_GREEN + message);
                }
                if(color.equals("dark_purple")) {
                    event.setMessage(ChatColor.DARK_PURPLE + message);
                }
                if(color.equals("dark_red")) {
                    event.setMessage(ChatColor.DARK_RED + message);
                }
                if(color.equals("gold")) {
                    event.setMessage(ChatColor.GOLD + message);
                }
                if(color.equals("gray")) {
                    event.setMessage(ChatColor.GRAY + message);
                }
                if(color.equals("green")) {
                    event.setMessage(ChatColor.GREEN + message);
                }
                if(color.equals("light_purple")) {
                    event.setMessage(ChatColor.LIGHT_PURPLE + message);
                }
                if(color.equals("white")) {
                    event.setMessage(ChatColor.WHITE + message);
                }
                if(color.equals("yellow")) {
                    event.setMessage(ChatColor.YELLOW + message);
                }
            } else {
                event.setMessage(message);
            }

    }


}
