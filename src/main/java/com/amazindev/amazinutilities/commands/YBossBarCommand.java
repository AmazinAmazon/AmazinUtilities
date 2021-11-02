package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Boss;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;

public class YBossBarCommand implements CommandExecutor {
    public BukkitTask task;
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);
    public static HashMap<Player, BossBar> ybarlist = new HashMap<>();


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(player.hasPermission("amazinutilities.ybossbar")) {
                if(!ybarlist.containsKey(player)) {
                    BossBar ybar = Bukkit.createBossBar("", BarColor.YELLOW, BarStyle.SOLID);
                    player.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("enabledYBar"));
                    Integer y = player.getLocation().getBlockY();
                    String ypos = y.toString();
                    ybar.setTitle(ChatColor.GOLD + "" + ChatColor.BOLD + plugin.getConfig().getString("ybossbarText") + ypos);
                    ybar.addPlayer(player);
                    ybar.setVisible(true);
                    ybarlist.put(player, ybar);

                    task = new BukkitRunnable() {

                        @Override
                        public void run() {
                            Integer y2 = player.getLocation().getBlockY();
                            String ypos2 = y2.toString();
                            ybar.setTitle(ChatColor.GOLD + plugin.getConfig().getString("ybossbarText") + ypos2);

                        }
                    }.runTaskTimer(plugin, 0, 20 * 3);


                } else {
                    if (task != null) {
                        task.cancel();

                    }
                    if (ybarlist.containsKey(player)) {
                        BossBar ybar = ybarlist.get(player);
                        player.sendMessage(ChatColor.RED + plugin.getConfig().getString("disabledYBar"));
                        ybar.removeAll();
                        ybarlist.remove(player);
                    }

                }
            } else {
                sender.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms") + "(amazinutilities.ybossbar)");
            }
        } else {
            sender.sendMessage(plugin.getConfig().getString("onlyPlayer"));
        }

        return true;
    }
}
