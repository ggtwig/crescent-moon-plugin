package com.jack.crescentmoon.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Random;

public class MenuListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (e.getView().getTitle().equals("§4Main Menu!") && e.getCurrentItem() != null) {
            e.setCancelled(true);

            Player player = (Player) e.getWhoClicked();

            switch (e.getRawSlot()) {
                case 0: // close
                    break;
                case 20: // kits
                    player.performCommand("zoro");
                    break;
                case 22: // teleport

                    break;
                case 24: // block shuffle

                    break;
                case 30: // kill yourself
                    player.setHealth(0);
                    player.sendMessage("§cYou killed yourself!");
                    break;
                case 32: // clear inventory
                    player.closeInventory();
                    player.getInventory().clear();
                    player.sendMessage("§cYou cleared your inventory!");
                    break;
                default:
                    return;
            }
            player.closeInventory();
        }
    }

}
