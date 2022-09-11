package com.jack.crescentmoon.commands;

import com.jack.crescentmoon.menus.MenuManager;
import com.jack.crescentmoon.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            ChatUtils.notPlayerErrorMessage(sender);
            return true;
        }

        Player player = (Player) sender;

        MenuManager.openMainMenu(player);



        return true;
    }
}
