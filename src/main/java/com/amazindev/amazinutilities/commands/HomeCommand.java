package com.amazindev.amazinutilities.commands;

import com.amazindev.amazinutilities.AmazinUtilities;
import com.amazindev.amazinutilities.CustomConfig;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HomeCommand implements CommandExecutor {
    public JavaPlugin plugin = AmazinUtilities.getPlugin(AmazinUtilities.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (plugin.getConfig().getBoolean("enableHomes")) {
                int numberOfHomes;
                    try {
                        numberOfHomes = CustomConfig.get().getConfigurationSection("savedLocations." + p.getName()).getKeys(false).size();
                    } catch (CommandException | NullPointerException e) {
                        numberOfHomes = 0;
                    }
                    int defaultMaxHomes = plugin.getConfig().getInt("defaultMaxHomes");
                    if (args.length == 2 && args[0].equalsIgnoreCase("set")) {
                        String homeName = args[1];
                        Location l = p.getLocation();
                        String playerWorld = l.getWorld().getName();
                        if (p.hasPermission("amazinutilities.sethome")) {
                            if (CustomConfig.get().isConfigurationSection("savedLocations." + p.getName() + "." + homeName)) {
                                setLocationInConfig(homeName, p, playerWorld, l);
                                p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullyReplacedHome"));
                            } else {
                                if (p.hasPermission("amazinutilities.home.default")) {
                                    if (p.hasPermission("amazinutilities.home.bypass")) {
                                        setLocationInConfig(homeName, p, playerWorld, l);
                                        p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullySetHome"));
                                    } else {
                                        if (numberOfHomes < defaultMaxHomes) {
                                            setLocationInConfig(homeName, p, playerWorld, l);
                                            p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullySetHome"));
                                        } else {
                                            p.sendMessage(ChatColor.RED + plugin.getConfig().getString("maxHomes"));
                                        }
                                    }
                                } else {
                                    p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms"));
                                }
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms"));
                        }
                    } else if (args.length == 2 && args[0].equalsIgnoreCase("delete")) {
                        String homeName = args[1];
                        if (p.hasPermission("amazinutilities.deletehome")) {
                            if (CustomConfig.get().isConfigurationSection("savedLocations." + p.getName() + "." + homeName)) {
                                CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName, null);
                                CustomConfig.save();
                                p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullyDeletedHome"));
                            } else {
                                p.sendMessage(ChatColor.RED + plugin.getConfig().getString("unvalidHome"));
                            }
                        } else {
                            p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms"));
                        }
                        } else if (args.length == 1 && args[0].equalsIgnoreCase("check")) {
                            p.sendMessage(ChatColor.BLUE + plugin.getConfig().getString("numberOfHomes").replace("{0}", Integer.toString(numberOfHomes)));
                        } else if (args.length == 1 && args[0].equalsIgnoreCase("set")) {
                            p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noHome"));
                        } else if (args.length == 1 && args[0].equalsIgnoreCase("delete")) {
                         p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noHome"));
                        } else if (args.length == 1) {
                            if (p.hasPermission("amazinutilities.home")) {
                                String homeName = args[0];
                                if (CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName) == null) {
                                    p.sendMessage(ChatColor.RED + plugin.getConfig().getString("unvalidHome"));
                                } else {
                                    String playerWorld = CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName + ".world");
                                    String locationx = CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName + ".x");
                                    String locationy = CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName + ".y");
                                    String locationz = CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName + ".z");
                                    String yaw = CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName + ".yaw");
                                    String pitch = CustomConfig.get().getString("savedLocations." + p.getName() + "." + homeName + ".pitch");

                                    double locx = Double.parseDouble(locationx);
                                    double locy = Double.parseDouble(locationy);
                                    double locz = Double.parseDouble(locationz);
                                    float yawf = Float.parseFloat(yaw);
                                    float pitchf = Float.parseFloat(pitch);


                                    Location location = new Location(Bukkit.getWorld(playerWorld), locx, locy, locz, yawf, pitchf);
                                    p.teleport(location);
                                    p.sendMessage(ChatColor.GREEN + plugin.getConfig().getString("successfullyTeleportedHome"));
                                }
                            } else {
                                p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noPerms"));
                            }
                        } else if (args.length == 0) {
                            p.sendMessage(ChatColor.RED + plugin.getConfig().getString("noHome"));
                        }
            } else {
                p.sendMessage(ChatColor.RED + plugin.getConfig().getString("homeDisabled"));
            }
        }
        return true;
    }

    public void setLocationInConfig(String homeName, Player p, String playerWorld, Location l) {
        CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName + ".world", playerWorld);
        CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName + ".x", l.getX());
        CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName + ".y", l.getY());
        CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName + ".z", l.getZ());
        CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName + ".yaw", l.getYaw());
        CustomConfig.get().set("savedLocations." + p.getName() + "." + homeName + ".pitch", l.getPitch());

        CustomConfig.save();
    }
}


