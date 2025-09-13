package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public final class CreativeFlatWorld extends JavaPlugin {

    @Override
    public void onEnable() {
        CFWLogger.log(CFWLogger.LogLevel.INFO, "CreativeFlatWorldGenerator has been enabled.");
        getServer().getPluginManager().registerEvents(new CFWWorldListener(this), this);
    }

    @Override
    public void onDisable() {
        CFWLogger.log(CFWLogger.LogLevel.INFO, "CreativeFlatWorldGenerator has been disabled.");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(@NotNull String worldName, @Nullable String id) {
        return new CFWChunkGenerator();
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull String worldName, @Nullable String id) {
        return new CFWBiomeProvider();
    }
}
