package com.jack.crescentmoon.commands;

import com.jack.crescentmoon.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equals("givewand")) {
            player.getInventory().addItem(ItemManager.wand);
        } else if (command.getName().equals("giveenma") && sender.hasPermission("crescentmoon.enma")) {
            player.getInventory().addItem(ItemManager.enma);
        }

        return true;
    }
}
