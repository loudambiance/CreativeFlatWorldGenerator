package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.Material;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class CFWChunkGenerator extends ChunkGenerator {
    @Override
    public void generateNoise(@NotNull WorldInfo worldInfo, @NotNull Random random, int chunkX, int chunkZ, @NotNull ChunkData chunkData) {

        Material chunkMaterial;
        if(chunkZ<0 && chunkX<0){
            chunkMaterial = Material.GRASS_BLOCK;
        } else if (chunkZ<0) {
            chunkMaterial = Material.END_STONE;
        } else if (chunkX<0) {
            chunkMaterial = Material.NETHERRACK;
        } else {
            chunkMaterial = Material.BEDROCK;
        }

        for(int y = chunkData.getMinHeight(); y < 0 && y < chunkData.getMaxHeight(); y++) {
            for(int x = 0; x < 16; x++) {
                for(int z = 0; z < 16; z++) {
                    if(y<-60){
                        chunkData.setBlock(x, y, z, Material.BEDROCK);
                    }else{
                        chunkData.setBlock(x, y, z, chunkMaterial);
                    }
                }
            }
        }
    }

    @Override
    @Nullable
    public BiomeProvider getDefaultBiomeProvider(@NotNull
                                                 WorldInfo worldInfo){
        return new CFWBiomeProvider();
    }
}