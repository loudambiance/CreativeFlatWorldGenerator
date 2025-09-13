package com.chumcraft.creativeflatworld.creativeflatworld;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;

/*
 * This class was adapted from Logger in the TeakIvy's Teak's Tweaks project.
 *
 * Original source: https://github.com/teakivy/teaks-tweaks
 * The project is licensed under the MIT License.
 */
public class CFWLogger {

    private static String getPrefix(LogLevel level) {
        String prefix = "";
        switch (level) {
            case ERROR ->
                    prefix = "<dark_gray>[<red><bold>ERROR</bold></red>]";
            case WARNING ->
                    prefix = "<dark_gray>[<gold><bold>WARNING</bold></gold>]";
            case INFO ->
                    prefix = "<dark_gray>[<yellow><bold>INFO</bold></yellow>]";
            case SUCCESS ->
                    prefix = "<dark_gray>[<green><bold>SUCCESS</bold></green>]";
            case OUTLINE ->
                    prefix = "<dark_gray>[<gray><bold>OUTLINE</bold></gray>]";
        }
        return prefix;
    }

    /**
     * Logs a message to the console
     * @param level The log level
     * @param message The message
     */
    public static void log(LogLevel level, Component message) {
        if (message == null) return;

        String text = "<dark_gray>[<blue><bold>CreativeFlatWorld</bold></blue>]<reset> " + getPrefix(level) + " <reset>" + MiniMessage.miniMessage().serialize(message);

        Bukkit.getConsoleSender().sendMessage(MiniMessage.miniMessage().deserialize(text));
    }

    /**
     * Logs a message to the console
     * @param level The log level
     * @param message The message
     */
    public static void log(LogLevel level, String message) {
        log(level, MiniMessage.miniMessage().deserialize(message));
    }

    /**
     * Logs an error message to the console
     * @param message The message
     */
    public static void error(Component message) {
        log(LogLevel.ERROR, message);
    }

    /**
     * Logs an error message to the console
     * @param message The message
     */
    public static void error(String message) {
        log(LogLevel.ERROR, message);
    }

    /**
     * Logs a warning message to the console
     * @param message The message
     */
    public static void warning(Component message) {
        log(LogLevel.WARNING, message);
    }

    /**
     * Logs a warning message to the console
     * @param message The message
     */
    public static void warning(String message) {
        log(LogLevel.WARNING, message);
    }

    /**
     * Logs an info message to the console
     * @param message The message
     */
    public static void info(Component message) {
        log(LogLevel.INFO, message);
    }

    /**
     * Logs an info message to the console
     * @param message The message
     */
    public static void info(String message) {
        log(LogLevel.INFO, message);
    }

    /**
     * Logs a success message to the console
     * @param message The message
     */
    public static void success(Component message) {
        log(LogLevel.SUCCESS, message);
    }

    /**
     * Logs a success message to the console
     * @param message The message
     */
    public static void success(String message) {
        log(LogLevel.SUCCESS, message);
    }

    /**
     * Logs an outline message to the console
     * @param message The message
     */
    public static void outline(Component message) {
        log(LogLevel.OUTLINE, message);
    }

    /**
     * Logs an outline message to the console
     * @param message The message
     */
    public static void outline(String message) {
        log(LogLevel.OUTLINE, message);
    }

    /**
     * Logger levels
     */
    public enum LogLevel { ERROR, WARNING, INFO, SUCCESS, OUTLINE }
}
