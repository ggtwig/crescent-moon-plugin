package com.jack.crescentmoon.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack wand;
    public static ItemStack enma;

    public static ItemStack nichirin;

    public static void init() {
        createWand();
        createEnma();
        createNichirin();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        AttributeModifier modifier = new AttributeModifier("generic.attack_damage", 100, AttributeModifier.Operation.ADD_NUMBER);
        meta.setDisplayName("§6Stick of Truth");
        List<String> lore = new ArrayList<>();
        lore.add("§7This powerful artifact is a relic of");
        lore.add("§7Minecraft's ancient history!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        wand = item;
    }

    private static void createEnma() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§8Enma");
        List<String> lore = new ArrayList<>();
        lore.add(" ");
        lore.add("§7Enma is one of the 21 Great Grade swords crafted ");
        lore.add("§7by Shimotsuki Kozaburo in the Wano Country");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        meta.addEnchant(Enchantment.DURABILITY, 10, true);
        //meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        enma = item;
    }

    private static void createNichirin() {
        nichirin = new ItemBuilder(Material.DIAMOND_SWORD, 1)
                .setDisplayName("§8Nichirin Sword")
                .setLore(
                        "§7This Nichirin Katana is ",
                        "§7the greatest katana!")
                .addEnchant(Enchantment.DAMAGE_ALL, 10, true).build();
    }
}
