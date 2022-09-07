package com.jack.crescentmoon.items;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ItemManager {

    public static ItemStack wand;
    public static ItemStack nichirin;
    public static HashMap<String, ItemStack> zoroSet = new HashMap<>();

    public static void init() {
        createWand();
        createZoroSet();
        createNichirin();
    }

    private static void createWand() {
        wand = new ItemBuilder(Material.STICK, 1)
                .setDisplayName("§6Stick of Truth")
                .setLore(
                        " ",
                        "§7This powerful artifact is a relic of ",
                        "§7Minecraft's ancient history!")
                .addEnchant(Enchantment.LUCK, 1, true)
                .addAttributeModifier("generic.attack_damage", 100, AttributeModifier.Operation.ADD_NUMBER, Attribute.GENERIC_ATTACK_DAMAGE)
                .addItemFlag(ItemFlag.HIDE_ENCHANTS)
                .addItemFlag(ItemFlag.HIDE_ATTRIBUTES).build();
    }

    private static void createZoroSet() {
        ItemStack zoroSword = new ItemBuilder(Material.NETHERITE_SWORD, 1)
                .setDisplayName("§8Enma")
                .setLore(
                        " ",
                        "§7Enma is one of the 21 Great Grade swords crafted ",
                        "§7by Shimotsuki Kozaburo in the Wano Country")
                .addEnchant(Enchantment.DAMAGE_ALL, 10, true)
                .addEnchant(Enchantment.DURABILITY, 10, true).build();

        ItemStack zoroChestplate = new ItemBuilder(Material.NETHERITE_CHESTPLATE, 1)
                .setDisplayName("§cZoro Chestplate")
                .addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 10, true).build();

        zoroSet.put("zoroSword" , zoroSword);
        zoroSet.put("zoroChestplate", zoroChestplate);
    }

    private static void createNichirin() {
        nichirin = new ItemBuilder(Material.DIAMOND_SWORD, 1)
                .setDisplayName("§8Nichirin Sword")
                .setLore(
                        "§7This Nichirin Katana is ",
                        "§7the greatest katana!")
                .addEnchant(Enchantment.DAMAGE_ALL, 20, true)
                .addItemFlag(ItemFlag.HIDE_ENCHANTS).build();
    }
}
