package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.WorldCreator;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.logging.Level;

public final class CreativeFlatWorld extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().log(Level.INFO, "WorldGenerator was enabled successfully.");
    }

    @Override
    public void onDisable() {
        getLogger().log(Level.INFO, "WorldGenerator was disabled successfully.");
    }

    @Override
    public ChunkGenerator getDefaultWorldGenerator(String worldName, String id) {
        getLogger().log(Level.WARNING, "CustomChunkGenerator is used!");
        return new CFWChunkGenerator(); // Return an instance of the chunk generator we want to use.
    }

    @Override
    public BiomeProvider getDefaultBiomeProvider(@NotNull
                                                     String worldName,
                                                 @Nullable
                                                     String id){
        return new CFWBiomeProvider();
    }
}