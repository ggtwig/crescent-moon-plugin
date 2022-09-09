package com.jack.crescentmoon.utils;

import com.jack.crescentmoon.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Random;

public class RTPUtils {

    static Main main;

    public RTPUtils(Main main) {
        this.main = main;
    }

    public static HashSet<Material> unsafeBlocks = new HashSet<>();

    static{
        unsafeBlocks.add(Material.LAVA);
        unsafeBlocks.add(Material.FIRE);
    }

    public static Location generateLocation(Player player) {
        Random random = new Random();

        int x;
        int y;
        int z;

        if(main.getConfig().getBoolean("worldBorder")) {
            x = random.nextInt(main.getConfig().getInt("border") + main.getConfig().getInt("border")) - main.getConfig().getInt("border");
            y = 256;
            //z = random.nextInt(main.getConfig().getInt("border"));
            z = random.nextInt(main.getConfig().getInt("border") + main.getConfig().getInt("border")) - main.getConfig().getInt("border");
        } else {
            x = random.nextInt(25000 + 25000) - 25000;
            y = 256;
            z = random.nextInt(25000 + 25000) - 25000;
        }

        Location randomLocation = new Location(player.getWorld(), x, y, z);

        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);

        randomLocation.setY(y + 1);

        if (!(isLocationSafe(randomLocation))) {
            player.sendMessage("§cCould not find a safe location!");
            return player.getLocation();
        }

        player.sendMessage("§aSuccessfully teleported to new location!");

        return randomLocation;
    }

    public static boolean isLocationSafe(Location location) {

        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();

        Block block = location.getWorld().getBlockAt(x, y, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);

        return !(unsafeBlocks.contains(below.getType()) || (block.getType().isSolid()) || (above.getType().isSolid()));
    }
}
