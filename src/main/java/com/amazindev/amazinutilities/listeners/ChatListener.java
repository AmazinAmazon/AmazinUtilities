package com.amazindev.amazinutilities.listeners;

import com.amazindev.amazinutilities.commands.ChatColorCommand;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();
        String color = ChatColorCommand.hashmapcolor.get(player);
        String style = ChatColorCommand.hashmapstyle.get(player);
        if(style != null) {
            if(style.equals("reset")) {
                event.setMessage(message);
            }
        }
            if(color != null) {
                if(color.equals("aqua")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.AQUA + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.AQUA + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.AQUA + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.AQUA + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.AQUA + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.AQUA + message);
                    }
                }
                if(color.equals("red")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.RED + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.RED + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.RED + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.RED + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.RED + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.RED + message);
                    }
                }
                if(color.equals("black")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.BLACK + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.BLACK + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.BLACK + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.BLACK + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.BLACK + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.BLACK + message);
                    }
                }
                if(color.equals("blue")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.BLUE + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.BLUE + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.BLUE + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.BLUE + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.BLUE + message);
                    }
                }
                if(color.equals("dark_aqua")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.DARK_AQUA + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.DARK_AQUA + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.DARK_AQUA + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.DARK_AQUA + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.DARK_AQUA + message);
                    }
                }
                if(color.equals("dark_blue")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.DARK_BLUE + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.DARK_BLUE + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.DARK_BLUE + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.DARK_BLUE + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.DARK_BLUE + message);
                    }
                }
                if(color.equals("dark_gray")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.DARK_GRAY + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.DARK_GRAY + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.DARK_GRAY + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.DARK_GRAY + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.DARK_GRAY + message);
                    }
                }
                if(color.equals("dark_green")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.DARK_GREEN + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.DARK_GREEN + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.DARK_GREEN + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.DARK_GREEN + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.DARK_GREEN + message);
                    }
                }
                if(color.equals("dark_purple")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.DARK_PURPLE + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.DARK_PURPLE + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.DARK_PURPLE + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.DARK_PURPLE + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.DARK_PURPLE + message);
                    }
                }
                if(color.equals("dark_red")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.DARK_RED + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.DARK_RED + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.DARK_RED + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.DARK_RED + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.DARK_RED + message);
                    }
                }
                if(color.equals("gold")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.GOLD + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.GOLD + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.GOLD + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.GOLD + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.GOLD + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.GOLD + message);
                    }
                }
                if(color.equals("gray")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.GRAY + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.GRAY + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.GRAY + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.GRAY + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.GRAY + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.GRAY + message);
                    }
                }
                if(color.equals("green")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.GREEN + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.GREEN + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.GREEN + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.GREEN + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.GREEN + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.GREEN + message);
                    }
                }
                if(color.equals("light_purple")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.LIGHT_PURPLE + message);
                    }
                }
                if(color.equals("white")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.WHITE + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.WHITE + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.WHITE + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.WHITE + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.WHITE + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.WHITE + message);
                    }
                }
                if(color.equals("yellow")) {
                    if(style != null) {
                        if(style.equals("bold")) {
                            event.setMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + message);
                        }
                        if(style.equals("italic")) {
                            event.setMessage(ChatColor.YELLOW + "" + ChatColor.ITALIC + message);
                        }
                        if(style.equals("magic")) {
                            event.setMessage(ChatColor.YELLOW + "" + ChatColor.MAGIC + message);
                        }
                        if(style.equals("strikethrough")) {
                            event.setMessage(ChatColor.YELLOW + "" + ChatColor.STRIKETHROUGH + message);
                        }
                        if(style.equals("underline")) {
                            event.setMessage(ChatColor.YELLOW + "" + ChatColor.UNDERLINE + message);
                        }
                    } else {
                        event.setMessage(ChatColor.YELLOW + message);
                    }
                }
            } else {
                event.setMessage(message);
            }

    }


}
