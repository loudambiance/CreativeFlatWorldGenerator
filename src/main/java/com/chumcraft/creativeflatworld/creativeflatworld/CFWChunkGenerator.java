package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CFWChunkGenerator extends ChunkGenerator {
    @Override
    public void generateSurface(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {

        World.Environment environment = worldInfo.getEnvironment();

        Material material1; // For chunkZ < 0 && chunkX < 0
        Material material2; // For chunkZ < 0
        Material material3; // For chunkX < 0
        Material material4; // For the last quadrant

        switch (environment) {
            case NETHER:
                material1 = Material.NETHERRACK;
                material2 = Material.SOUL_SAND;
                material3 = Material.BLACKSTONE;
                material4 = Material.LAVA;
                break;
            case THE_END:
                material1 = Material.END_STONE;
                material2 = Material.END_STONE_BRICKS;
                material3 = Material.PURPUR_BLOCK;
                material4 = Material.OBSIDIAN;
                break;
            case NORMAL:
            default:
                material1 = Material.GRASS_BLOCK;
                material2 = Material.SAND;
                material3 = Material.STONE;
                material4 = Material.WATER;
                break;
        }

        Material chunkMaterial;
        if (chunkZ < 0 && chunkX < 0) {
            chunkMaterial = material1;
        } else if (chunkZ < 0) {
            chunkMaterial = material2;
        } else if (chunkX < 0) {
            chunkMaterial = material3;
        } else {
            chunkMaterial = material4;
        }

        for (int y = worldInfo.getMinHeight(); y < worldInfo.getMinHeight()+60; y++) {
            for (int x = 0; x < 16; x++) {
                for (int z = 0; z < 16; z++) {
                    // Create a 4-block thick bedrock layer at the bottom of the world
                    if (y < worldInfo.getMinHeight() + 4) {
                        chunkData.setBlock(x, y, z, Material.BEDROCK);
                    } else {
                        chunkData.setBlock(x, y, z, chunkMaterial);
                    }
                }
            }
        }
    }

    @Override
    @Nullable
    public BiomeProvider getDefaultBiomeProvider(@NotNull WorldInfo worldInfo) {
        return new CFWBiomeProvider();
    }
}
