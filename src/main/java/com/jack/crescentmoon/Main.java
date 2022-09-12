package com.jack.crescentmoon;

import com.jack.crescentmoon.commands.ItemCommands;
import com.jack.crescentmoon.commands.MenuCommands;
import com.jack.crescentmoon.commands.RTPCommands;
import com.jack.crescentmoon.events.ItemEvents;
import com.jack.crescentmoon.events.MenuEvents;
import com.jack.crescentmoon.items.ItemManager;
import com.jack.crescentmoon.utils.RTPUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        registerCommands();

        ItemManager.init();

        Bukkit.getPluginManager().registerEvents(new ItemEvents(), this);
        Bukkit.getPluginManager().registerEvents(new MenuEvents(), this);

        RTPUtils rtpUtils = new RTPUtils(this);
    }

    @Override
    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("givewand").setExecutor(new ItemCommands());
        getCommand("givezoro").setExecutor(new ItemCommands());
        getCommand("givedemonslayer").setExecutor(new ItemCommands());
        getCommand("menu").setExecutor(new MenuCommands());
        getCommand("randomtp").setExecutor(new RTPCommands());
    }
}
