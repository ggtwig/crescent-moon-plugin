package com.jack.crescentmoon.utils;

import org.bukkit.command.CommandSender;

public class ChatUtils {

    public static void notPlayerErrorMessage(CommandSender sender) {
        sender.sendMessage("§cYou must be a player to run this command!");
    }

    public static void sendSuccessMessage(CommandSender sender, String message) {
        sender.sendMessage("§a" + message);
    }
}
