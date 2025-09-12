package com.chumcraft.creativeflatworld.creativeflatworld;

import org.bukkit.block.Biome;
import org.bukkit.generator.BiomeProvider;
import org.bukkit.generator.WorldInfo;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CFWBiomeProvider extends BiomeProvider {

    @NotNull
    @Override
    public Biome getBiome(@NotNull
                              WorldInfo worldInfo,
                                   int x,
                                   int y,
                                   int z)
    {
        Biome biome;
        if(z<0 && x<0){
            biome = Biome.MUSHROOM_FIELDS;
        } else if (z<0) {
            biome = Biome.THE_END;
        } else if (x<0) {
            biome = Biome.BASALT_DELTAS;
        } else {
            biome = Biome.THE_END;
        }
        return biome;
    }

    @NotNull
    @Override
    public List<Biome> getBiomes(@NotNull WorldInfo worldInfo) {
        List<Biome> biomes = new ArrayList<Biome>();
        biomes.add(Biome.BASALT_DELTAS);
        biomes.add(Biome.MUSHROOM_FIELDS);
        biomes.add(Biome.THE_END);
        return biomes;
    }
}
