package com.amazindev.amazinutilities.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            if(sender.hasPermission("amazinutilities.seetime")) {
                Player player = (Player) sender;
                long time = player.getWorld().getTime();
                String time2 = time+"";
                StringBuilder realtime1 = new StringBuilder();
                    if(time2.length() <= 1) {
                        realtime1.append("00:00").append(time2);
                    } else if(time2.length() <= 2) {
                        realtime1.append("00:0").append(time2);
                    } else if(time2.length() <= 3) {
                        realtime1.append("00:").append(time2);
                    } else if(time2.length() <= 4) {
                        char[] tries1 = new char[time2.length()];
                        char[] tries3 = new char[time2.length()];
                        realtime1.append("0");
                        tries1[0] = time2.charAt(0);
                        realtime1.append(tries1[0]).append(":");
                        tries3[0] = time2.charAt(1);
                        tries3[1] = time2.charAt(2);
                        tries3[2] = time2.charAt(3);
                        realtime1.append(tries3);
                    } else if(time2.length() <= 5) {
                        char[] tries2 = new char[time2.length()];
                        char[] tries4 = new char[time2.length()];
                    tries2[0] = time2.charAt(0);
                    tries2[1] = time2.charAt(1);
                    realtime1.append(tries2[0]).append(tries2[1]).append(":");
                    tries4[0] = time2.charAt(2);
                    tries4[1] = time2.charAt(3);
                    tries4[2] = time2.charAt(4);
                    realtime1.append(tries4);
                }
                String realtime2 = realtime1.toString().trim();
                char[] realtime3 = new char[realtime2.length()];
                realtime3[0] = realtime2.charAt(0);
                realtime3[1] = realtime2.charAt(1);
                realtime3[2] = realtime2.charAt(2);
                realtime3[3] = realtime2.charAt(3);
                realtime3[4] = realtime2.charAt(4);
                StringBuilder realtime4 = new StringBuilder();
                realtime4.append(realtime3);
                String realtime5 = realtime4.toString().trim();
                player.sendMessage(ChatColor.AQUA + "The time in your world is " + realtime5);
            } else {
                sender.sendMessage(ChatColor.RED + "You don't have permission to execute this command (amazinutilities.seetime)");
            }
        } else {
            sender.sendMessage("This command can only be executed by a player");
        }

        return true;
    }
}
