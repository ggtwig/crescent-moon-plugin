package com.jack.crescentmoon.events;

import com.jack.crescentmoon.items.ItemManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemEvents implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (e.getItem() != null) {
                if (e.getItem().getItemMeta().equals(ItemManager.wand.getItemMeta())) {
                    player.getWorld().createExplosion(player.getLocation(), 2.0f);
                    player.sendMessage("§6You dare use the Stick of Truth?!");
                } else if (e.getItem().getItemMeta().equals(ItemManager.nichirin.getItemMeta())) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 10));
                }
            }
        }
    }

}
