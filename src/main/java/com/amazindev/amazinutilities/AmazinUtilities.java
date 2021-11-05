package com.amazindev.amazinutilities;

import com.amazindev.amazinutilities.commands.*;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeAdventureCommand;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeCreativeCommand;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeSpectatorCommand;
import com.amazindev.amazinutilities.commands.gamemodecommands.GamemodeSurvivalCommand;
import com.amazindev.amazinutilities.listeners.ChatListener;
import com.amazindev.amazinutilities.listeners.DeathListener;
import com.amazindev.amazinutilities.listeners.JoinLeaveListener;
import com.amazindev.amazinutilities.listeners.MovementListener;
import com.amazindev.amazinutilities.listeners.tabcompleters.AmazinUtilitiesTabCompleter;
import com.amazindev.amazinutilities.listeners.tabcompleters.ChatColorTabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public final class AmazinUtilities extends JavaPlugin {

    public static FileConfiguration config;
    public static double version = 1.1;

    @Override
    public void onEnable() {
        getLogger().info("Plugin started");

        // Enable configs
        config = getConfig();
        config.options().copyDefaults();
        saveDefaultConfig();

        CustomConfig.setup();
        CustomConfig.get().options().copyDefaults(true);
        CustomConfig.save();

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
        getCommand("chatcolor").setTabCompleter(new ChatColorTabCompleter());
        getCommand("tpall").setExecutor(new TpallCommand());
        getCommand("kickall").setExecutor(new KickAllCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("amazinutilities").setExecutor(new AmazinUtilitiesCommand(this));
        getCommand("amazinutilities").setTabCompleter(new AmazinUtilitiesTabCompleter());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("whois").setExecutor(new WhoIsCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("seetime").setExecutor(new TimeCommand());
        getCommand("home").setExecutor(new HomeCommand());

        updateChecker();
    }


    public void updateChecker() {
        try {
            HttpsURLConnection con = (HttpsURLConnection) new URL("https://api.spigotmc.org/legacy/update.php?resource=97240").openConnection();
            con.setConnectTimeout(20000);
            con.setReadTimeout(20000);
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String version = reader.readLine();
            reader.close();
            con.disconnect();
            if (version.equalsIgnoreCase(getDescription().getVersion())) {
                getLogger().warning("Plugin is up to date");
            } else {
                getLogger().warning("A new version is available. Please download it here: https://www.spigotmc.org/resources/97240/");
            }
        } catch (IOException e) {
            getLogger().warning("Couldn't check for updates");
            e.printStackTrace();
        }

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
