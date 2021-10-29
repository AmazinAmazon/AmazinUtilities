package com.amazindev.amazinutilities.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCreativeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.setGameMode(GameMode.CREATIVE);

        if (args[0] != null) {
            String targetArg = args[0];
            Player target = Bukkit.getPlayer(targetArg);

            if (target == null) {
                player.sendMessage("This player isn't online");
            } else {
                target.setGameMode(GameMode.SPECTATOR);
            }
        }

        return true;
    }
}
