package com.amazindev.amazinutilities;

import com.amazindev.amazinutilities.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class AmazinUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin started");

        // Registering commands
        getCommand("gma").setExecutor(new GamemodeAdventureCommand());
        getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        getCommand("gmsp").setExecutor(new GamemodeSpectatorCommand());
        getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
        getCommand("tphere").setExecutor(new TphereCommand());
        getCommand("announcement").setExecutor(new AnnouncementCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
