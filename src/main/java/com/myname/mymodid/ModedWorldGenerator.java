package com.myname.mymodid;

import java.util.Random;

import lotr.common.world.biome.LOTRBiomeGenBreeland;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import cpw.mods.fml.common.IWorldGenerator;
import lotr.common.world.LOTRWorldProvider;
import lotr.common.world.biome.LOTRBiomeGenShire;

public class ModedWorldGenerator implements IWorldGenerator {

    private final GoodForcesCamp goodCamp = new GoodForcesCamp();

    @Override
    public void generate(Random random, int ChunkX, int ChunkZ, World world, IChunkProvider chunkGenerator,
        IChunkProvider chunkProvider) {
        if (world.provider instanceof LOTRWorldProvider) {
            genrateMiddleEarth(random, ChunkX * 16, ChunkZ * 16, world);
        }
    }

    private void genrateMiddleEarth(Random random, int blockX, int BlockZ, World world) {
        int x = blockX + random.nextInt(16);
        int z = BlockZ + random.nextInt(16);
        int y = world.getTopSolidOrLiquidBlock(x, z);

        BiomeGenBase Biome = world.getBiomeGenForCoords(x, z);

        if (random.nextInt(200) == 0) {

            if (Biome instanceof LOTRBiomeGenBreeland) {
                goodCamp.generate(world, random, x, y, z);
            }

        }

    }

}
