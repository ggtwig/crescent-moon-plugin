package com.jack.crescentmoon.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ItemBuilder {

    private ItemStack itemStack;
    private ItemMeta itemMeta;

    public ItemBuilder(Material material, int amount) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = this.itemStack.getItemMeta();
    }

    private void updateItemMeta() {
        this.itemStack.setItemMeta(this.itemMeta);
    }

    public ItemBuilder setDisplayName(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    public ItemBuilder setLore(String... lines) {
        this.itemMeta.setLore(Arrays.asList(lines));
        return this;
    }

    public ItemBuilder addEnchant(Enchantment enchantment, int level, boolean ignoreRestriction) {
        this.itemMeta.addEnchant(enchantment, level, ignoreRestriction);
        return this;
    }

    public ItemBuilder addItemFlag(ItemFlag flag) {
        this.itemMeta.addItemFlags(flag);
        return this;
    }



    public ItemStack build() {
        this.updateItemMeta();
        return this.itemStack;
    }
}
