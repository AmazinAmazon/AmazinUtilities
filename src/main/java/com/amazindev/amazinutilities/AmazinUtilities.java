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
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class AmazinUtilities extends JavaPlugin {

    public static FileConfiguration config;
    public static PluginManager pm;

    @Override
    public void onEnable() {
        pm = getServer().getPluginManager();
        getLogger().info("Plugin started");

        // Enable config
        saveDefaultConfig();
        config = getConfig();

        // Registering listeners
        pm.registerEvents(new MovementListener(), this);
        pm.registerEvents(new JoinLeaveListener(), this);
        pm.registerEvents(new DeathListener(), this);
        pm.registerEvents(new ChatListener(), this);

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
        getCommand("amazinutilitiesreload").setExecutor(new ReloadConfigCommand(this));
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("whois").setExecutor(new WhoIsCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("seetime").setExecutor(new TimeCommand());

    }

    public void reload() {
        reloadConfig();
        config = getConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin stopped");
    }
}
