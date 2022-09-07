package com.jack.crescentmoon.menus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuManager {

    public static void openMainMenu(Player player) {
        Inventory mainMenu = Bukkit.createInventory(player, 54, "§4Main Menu!");

        // NETHERITE SWORD --- KITS
        ItemStack menuKits = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta menuKitsMeta = menuKits.getItemMeta();
        menuKitsMeta.setDisplayName("§3Kits");
        menuKitsMeta.setLore(Arrays.asList("§7Opens the kits menu!"));
        menuKitsMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        menuKits.setItemMeta(menuKitsMeta);

        // ENDERPEARL --- RANDOM TELEPORT
        ItemStack menuTeleport = new ItemStack(Material.ENDER_PEARL);
        ItemMeta menuTeleportMeta = menuTeleport.getItemMeta();
        menuTeleportMeta.setDisplayName("§3Random Teleport");
        menuTeleportMeta.setLore(Arrays.asList("§7Teleports to a random location on the map!"));
        menuTeleport.setItemMeta(menuTeleportMeta);

        // GILDED BLACKSTONE --- BLOCK SHUFFLE
        ItemStack menuBlockShuffle = new ItemStack(Material.GILDED_BLACKSTONE);
        ItemMeta menuBlockShuffleMeta = menuBlockShuffle.getItemMeta();
        menuBlockShuffleMeta.setDisplayName("§3Block Shuffle");
        menuBlockShuffleMeta.setLore(Arrays.asList("§7Starts the Block Shuffle Minigame!"));
        menuBlockShuffle.setItemMeta(menuBlockShuffleMeta);

        // PUFFERFISH --- KILL YOURSELF
        ItemStack menuKys = new ItemStack(Material.PUFFERFISH);
        ItemMeta menuKysMeta = menuKys.getItemMeta();
        menuKysMeta.setDisplayName("§3Kill Yourself");
        menuKysMeta.setLore(Arrays.asList("§7Kills you."));
        menuKys.setItemMeta(menuKysMeta);

        // EMPTY BUCKET --- CLEAR INVENTORY
        ItemStack menuClearInv = new ItemStack(Material.BUCKET);
        ItemMeta menuClearInvMeta = menuClearInv.getItemMeta();
        menuClearInvMeta.setDisplayName("§3Clear Inventory");
        menuClearInvMeta.setLore(Arrays.asList("§7Clears your inventory."));
        menuClearInv.setItemMeta(menuClearInvMeta);

        // BARRIER --- CLOSE BUTTON
        ItemStack menuClose = new ItemStack(Material.BARRIER);
        ItemMeta menuCloseMeta = menuClose.getItemMeta();
        menuCloseMeta.setDisplayName("§cClose!");
        menuClose.setItemMeta(menuCloseMeta);

        // LIGHT BLUE PANE --- FRAME
        ItemStack menuFrame = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta menuFrameMeta = menuFrame.getItemMeta();
        menuFrameMeta.setDisplayName("§r");
        menuFrame.setItemMeta(menuFrameMeta);
        for (int i : new int[]{1,2,3,4,5,6,7,8,9,17,18,26,27,35,36,44,45,46,47,48,49,50,51,52,53}) {
            mainMenu.setItem(i, menuFrame);
        }

        mainMenu.setItem(0, menuClose);

        mainMenu.setItem(20, menuKits);
        mainMenu.setItem(22, menuTeleport);
        mainMenu.setItem(24, menuBlockShuffle);
        mainMenu.setItem(30, menuKys);
        mainMenu.setItem(32, menuClearInv);


        player.openInventory(mainMenu);
    }
}
