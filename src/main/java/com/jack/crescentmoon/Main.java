package com.jack.crescentmoon;

import com.jack.crescentmoon.commands.ItemCommands;
import com.jack.crescentmoon.events.ItemEvents;
import com.jack.crescentmoon.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();

        Bukkit.getPluginManager().registerEvents(new ItemEvents(), this);

        getCommand("givewand").setExecutor(new ItemCommands());
        getCommand("giveenma").setExecutor(new ItemCommands());
        getCommand("givenichirin").setExecutor(new ItemCommands());
    }

    @Override
    public void onDisable() {

    }
}
