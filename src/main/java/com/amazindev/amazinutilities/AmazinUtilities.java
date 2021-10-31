package com.amazindev.amazinutilities;

import com.amazindev.amazinutilities.commands.*;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeAdventureCommand;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeCreativeCommand;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeSpectatorCommand;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeSurvivalCommand;
import com.amazindev.amazinutilities.listeners.DeathListener;
import com.amazindev.amazinutilities.listeners.JoinLeaveListener;
import com.amazindev.amazinutilities.listeners.ChatListener;
import com.amazindev.amazinutilities.listeners.MovementListener;
import com.amazindev.amazinutilities.listeners.tabcompleters.ChatColorTabComplete;
import org.bukkit.plugin.java.JavaPlugin;

public final class AmazinUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin started");

        // Enable config
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        // Registering listeners
        getServer().getPluginManager().registerEvents(new MovementListener(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);

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
        getCommand("ybar").setExecutor(new YBossBarCommand());
        getCommand("shutdown").setExecutor(new ShutdownCommand());
        getCommand("chatcolor").setExecutor(new ChatColorCommand());
        getCommand("chatcolor").setTabCompleter(new ChatColorTabComplete());
        getCommand("tpall").setExecutor(new TpallCommand());
        getCommand("kickall").setExecutor(new KickAllCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("seetime").setExecutor(new TimeCommand());
        getCommand("whois").setExecutor(new WhoIsCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
