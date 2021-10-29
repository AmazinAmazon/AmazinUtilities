package com.amazindev.amazinutilities;

import com.amazindev.amazinutilities.commands.AnnouncementCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class AmazinUtilities extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Banana");

        getCommand("announcement").setExecutor(new AnnouncementCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
