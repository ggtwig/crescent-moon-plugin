package com.jack.crescentmoon.commands;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.jack.crescentmoon.items.ItemManager;
import com.jack.crescentmoon.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class ItemCommands implements CommandExecutor {

    private Cache<UUID, Long> zoroCooldown = CacheBuilder.newBuilder().expireAfterWrite(10, TimeUnit.SECONDS).build();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            ChatUtils.notPlayerErrorMessage(sender);
            return true;
        }

        Player player = (Player) sender;

        if (command.getName().equals("givewand")) {
            player.getInventory().addItem(ItemManager.wand);
        } else if (command.getName().equals("givezoro") && sender.hasPermission("crescentmoon.zoroset") && (!zoroCooldown.asMap().containsKey(player.getUniqueId()))) {
            for (ItemStack i : ItemManager.zoroSet.values()) {
                player.getInventory().addItem(i);
            }
            ChatUtils.sendSuccessMessage(sender, "Successfully claimed Zoro Kit!");
            zoroCooldown.put(player.getUniqueId(), System.currentTimeMillis() + 5000);
        } else if (command.getName().equals("givedemonslayer")) {
            for (ItemStack i : ItemManager.demonSlayerSet.values()) {
                player.getInventory().addItem(i);
            }
            ChatUtils.sendSuccessMessage(sender, "Successfully claimed Demon Slayer Kit!");
        } else if (zoroCooldown.asMap().containsKey(player.getUniqueId())){
            long cooldownLeft = zoroCooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            player.sendMessage("§cYou must wait " + TimeUnit.MILLISECONDS.toSeconds(cooldownLeft) + " seconds to use this again!");
        }

        return true;
    }
}
