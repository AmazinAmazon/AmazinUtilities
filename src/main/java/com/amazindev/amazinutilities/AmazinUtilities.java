package com.amazindev.amazinutilities;

import com.amazindev.amazinutilities.commands.*;
import com.amazindev.amazinutilities.listeners.DeathListener;
import com.amazindev.amazinutilities.listeners.JoinLeaveListener;
import com.amazindev.amazinutilities.listeners.MessageListener;
import com.amazindev.amazinutilities.listeners.MovementListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AmazinUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin started");

        // Registering listeners
        getServer().getPluginManager().registerEvents(new MovementListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new MessageListener(), this);

        // Registering commands
        getCommand("gma").setExecutor(new GamemodeAdventureCommand());
        getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        getCommand("gmsp").setExecutor(new GamemodeSpectatorCommand());
        getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("announcement").setExecutor(new AnnouncementCommand());
        getCommand("afk").setExecutor(new AfkCommand());
        getCommand("tp2p").setExecutor(new Tp2pCommand());
        getCommand("day").setExecutor(new DayCommand());
        getCommand("night").setExecutor(new NightCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("chatcolor").setExecutor(new ChatColorCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
