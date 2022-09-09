package com.jack.crescentmoon.events;

import com.jack.crescentmoon.menus.MenuManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getView().getTitle().equals("§4Main Menu") && e.getCurrentItem() != null) {
            e.setCancelled(true);

            switch (e.getRawSlot()) {
                case 0: // close
                    player.closeInventory();
                    break;
                case 20: // kits
                    player.closeInventory();
                    MenuManager.openKitsMenu(player);
                    break;
                case 22: // random teleport

                    break;
                case 24: // block shuffle
                    player.closeInventory();
                    player.performCommand("shuffle");
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
            }
        } else if (e.getView().getTitle().equals("§4Kits") && e.getCurrentItem() != null) {
            e.setCancelled(true);

            switch (e.getRawSlot()) {
                case 0: // kit zoro
                    player.closeInventory();
                    player.performCommand("givezoro");
                    break;

                case 8: // go back
                    player.closeInventory();
                    MenuManager.openMainMenu(player);
                    break;
            }
        }
    }

}
