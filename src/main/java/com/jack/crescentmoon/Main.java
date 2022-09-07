package com.jack.crescentmoon;

import com.jack.crescentmoon.commands.ItemCommands;
import com.jack.crescentmoon.commands.MenuCommands;
import com.jack.crescentmoon.events.ItemEvents;
import com.jack.crescentmoon.events.MenuEvents;
import com.jack.crescentmoon.items.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ItemManager.init();

        Bukkit.getPluginManager().registerEvents(new ItemEvents(), this);
        Bukkit.getPluginManager().registerEvents(new MenuEvents(), this);

        getCommand("givewand").setExecutor(new ItemCommands());
        getCommand("givezoro").setExecutor(new ItemCommands());
        getCommand("givenichirin").setExecutor(new ItemCommands());
        getCommand("menu").setExecutor(new MenuCommands());
    }

    @Override
    public void onDisable() {

    }
}
