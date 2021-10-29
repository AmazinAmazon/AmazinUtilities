package com.amazindev.amazinutilities;

import com.amazindev.amazinutilities.commands.*;
import com.amazindev.amazinutilities.listeners.MovementListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class AmazinUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin started");

        // Registering listeners
        getServer().getPluginManager().registerEvents(new MovementListener(), this);

        // Registering commands
        getCommand("gma").setExecutor(new GamemodeAdventureCommand());
        getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        getCommand("gmsp").setExecutor(new GamemodeSpectatorCommand());
        getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("announcement").setExecutor(new AnnouncementCommand());
        getCommand("afk").setExecutor(new AfkCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
