package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class CFWBiomeProvider extends BiomeProvider {

    @NotNull
    @Override
    public Biome getBiome(@NotNull WorldInfo worldInfo, int x, int y, int z) {
        World.Environment environment = worldInfo.getEnvironment();
        int chunkX = x >> 4;
        int chunkZ = z >> 4;

        switch (environment) {
            case NETHER:
                if (chunkZ < 0 && chunkX < 0) return Biome.NETHER_WASTES;
                if (chunkZ < 0) return Biome.SOUL_SAND_VALLEY;
                if (chunkX < 0) return Biome.BASALT_DELTAS;
                return Biome.CRIMSON_FOREST;
            case THE_END:
                if (chunkZ < 0 && chunkX < 0) return Biome.THE_END;
                if (chunkZ < 0) return Biome.SMALL_END_ISLANDS;
                if (chunkX < 0) return Biome.END_HIGHLANDS;
                return Biome.END_BARRENS;
            case NORMAL:
            default:
                if (chunkZ < 0 && chunkX < 0) return Biome.PLAINS;
                if (chunkZ < 0) return Biome.DESERT;
                if (chunkX < 0) return Biome.FOREST;
                return Biome.OCEAN;
        }
    }

    @NotNull
    @Override
    public List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
        World.Environment environment = worldInfo.getEnvironment();
        switch (environment) {
            case NETHER:
                return Arrays.asList(Biome.NETHER_WASTES, Biome.SOUL_SAND_VALLEY, Biome.BASALT_DELTAS, Biome.CRIMSON_FOREST);
            case THE_END:
                return Arrays.asList(Biome.THE_END, Biome.SMALL_END_ISLANDS, Biome.END_HIGHLANDS, Biome.END_BARRENS);
            case NORMAL:
            default:
                return Arrays.asList(Biome.PLAINS, Biome.DESERT, Biome.FOREST, Biome.OCEAN);
        }
    }
}
