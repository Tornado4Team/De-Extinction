package com.deextinction.deextinction.world.gen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import com.deextinction.deextinction.init.DeexBlocks;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeJungle;
import net.minecraft.world.biome.BiomeMesa;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraft.world.biome.BiomeSavanna;
import net.minecraft.world.biome.BiomeSnow;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenCustomOres implements IWorldGenerator {
	   
    private WorldGenerator cenozoic_fossil_block;
    private WorldGenerator mesozoic_fossil_block;
    private WorldGenerator paleozoic_fossil_block;
   
   
    public WorldGenCustomOres() {
       cenozoic_fossil_block = new WorldGenMinable(DeexBlocks.CENOZOIC_FOSSIL_BLOCK.getDefaultState(), 5, BlockMatcher.forBlock(Blocks.STONE));
       mesozoic_fossil_block = new WorldGenMinable(DeexBlocks.MESOZOIC_FOSSIL_BLOCK.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
       paleozoic_fossil_block = new WorldGenMinable(DeexBlocks.PALEOZOIC_FOSSIL_BLOCK.getDefaultState(), 4, BlockMatcher.forBlock(Blocks.STONE));
        
       
    }
   
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        switch(world.provider.getDimension()) {
        case 0:
            runGenerator(cenozoic_fossil_block, world, random, chunkX, chunkZ, 25, 57, 100 );
            runGenerator(mesozoic_fossil_block, world, random, chunkX, chunkZ, 18, 24, 57);
            runGenerator(paleozoic_fossil_block, world, random, chunkX, chunkZ, 22, 1, 24 );
            //runGenerator(topaz_ore, world, random, chunkX, chunkZ, 8, 4, 32, BiomeSavanna.class);
            
            break;
        case -1:
            break;
        case 1:
            break;
           
        }
       
    }
 
    public void runGenerator(WorldGenerator gen, World world, Random rand, int chunkX, int chunkZ, int chance, int minHeight, int maxHeight) {
        if(minHeight > maxHeight || minHeight < 0 || maxHeight > 256) throw new IllegalArgumentException("Ore generated out of bounds.");
       
     
        int heightDifference = maxHeight - minHeight + 1;
       
        for(int i = 0; i < chance; i++) {
            int x = chunkX * 16 + rand.nextInt(16);
            int z = chunkZ * 16 + rand.nextInt(16);
            int y = minHeight + rand.nextInt(heightDifference);
            BlockPos pos = new BlockPos(x,y,z);
            gen.generate(world, rand,pos);
           
        }
       
    }
   
}