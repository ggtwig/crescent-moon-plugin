package com.jack.crescentmoon.commands;

import com.jack.crescentmoon.items.ItemManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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
        } else if (command.getName().equals("givezoro") && sender.hasPermission("crescentmoon.zoroset")) {
            for (ItemStack i : ItemManager.zoroSet.values()) {
                player.getInventory().addItem(i);
            }
        } else if (command.getName().equals("givenichirin")) {
            player.getInventory().addItem(ItemManager.nichirin);
        }

        return true;
    }
}
