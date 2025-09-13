package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.GameRule;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class CFWWorldListener implements Listener {
    private final JavaPlugin plugin;
    private final Set<String> processedWorlds = new HashSet<>();

    public CFWWorldListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onWorldInit(WorldInitEvent event) {
        World world = event.getWorld();
        String worldName = world.getName();
        World.Environment environment = world.getEnvironment();

        // Check if the world has already been processed by this plugin.
        // We use a small file to persist this, so it works across server restarts.
        File processedFlag = new File(plugin.getDataFolder(), worldName + ".flag");
        if (processedFlag.exists()) {
            CFWLogger.log(CFWLogger.LogLevel.INFO, "World already processed: " + worldName);
            return;
        }

        CFWLogger.log(CFWLogger.LogLevel.INFO, "New world detected: " + worldName);

        world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
        CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set doDaylightCycle: false");
        world.setTime(6000);
        CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set time: 6000 (noon)");
        world.setGameRule(GameRule.DO_MOB_SPAWNING, false);
        CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set doMobSpawning: false");
        world.setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set doWeatherCycle: false");
        world.setStorm(false);
        world.setThundering(false);
        CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "clear current weather");
        world.setGameRule(GameRule.KEEP_INVENTORY, true);
        CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set keepInventory: true");
        if(environment == World.Environment.NORMAL) {
            world.setSpawnLocation(0, 0, 0);
            CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set spawnLocation: 0,0,0");
            world.setGameRule(GameRule.SPAWN_RADIUS, 10);
            CFWLogger.log(CFWLogger.LogLevel.INFO, worldName + "set spawnRadius: 10");
        }

        // Create a flag file to mark this world as processed.
        try {
            plugin.getDataFolder().mkdirs(); // Ensure the plugin folder exists
            Files.write(Paths.get(processedFlag.getPath()), "processed".getBytes());
        } catch (IOException e) {
            plugin.getLogger().severe("Failed to write flag file for world: " + worldName);
            CFWLogger.log(CFWLogger.LogLevel.ERROR, "Failed to write flag file for world: " + worldName);
            e.printStackTrace();
        }
    }
}