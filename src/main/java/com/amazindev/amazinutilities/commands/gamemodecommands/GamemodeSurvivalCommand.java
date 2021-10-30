package com.amazindev.amazinutilities.commands.gamemodecommands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GamemodeSurvivalCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        GamemodeFunction.Gamemode(args, sender, "amazinutilities.gamemode.survival", "amazinutilities.gamemode.survival.others", GameMode.SURVIVAL);

        return true;
    }
}
