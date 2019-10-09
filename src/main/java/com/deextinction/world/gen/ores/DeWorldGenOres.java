package com.deextinction.world.gen.ores;

import java.util.HashMap;
import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockFossil;
import com.deextinction.init.DeBlocks;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DeWorldGenOres implements IWorldGenerator
{
	private static final ResourceLocation FOSSIL_SITE = new ResourceLocation(DeExtinction.MODID, "fossil_site");

	private WorldGenMinableStates gen_fossil_animal;
	private WorldGenMinableStates gen_fossil_plant;

	public DeWorldGenOres()
	{
		HashMap<Predicate<IBlockState>, IBlockState> replace_to_place_list = new HashMap<Predicate<IBlockState>, IBlockState>();
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.STONE.getMetadata())), DeBlocks.fossil_block_animal.getStateFromMeta(BlockFossil.BaseBlockType.STONE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.GRANITE.getMetadata())), DeBlocks.fossil_block_animal.getStateFromMeta(BlockFossil.BaseBlockType.GRANITE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.DIORITE.getMetadata())), DeBlocks.fossil_block_animal.getStateFromMeta(BlockFossil.BaseBlockType.DIORITE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.ANDESITE.getMetadata())), DeBlocks.fossil_block_animal.getStateFromMeta(BlockFossil.BaseBlockType.ANDESITE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.getMetadata())), DeBlocks.fossil_block_animal.getStateFromMeta(BlockFossil.BaseBlockType.SANDSTONE.getMetadata()));
		this.gen_fossil_animal = new WorldGenMinableStates(replace_to_place_list, 4);

		replace_to_place_list.clear();
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.STONE.getMetadata())), DeBlocks.fossil_block_plant.getStateFromMeta(BlockFossil.BaseBlockType.STONE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.GRANITE.getMetadata())), DeBlocks.fossil_block_plant.getStateFromMeta(BlockFossil.BaseBlockType.GRANITE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.DIORITE.getMetadata())), DeBlocks.fossil_block_plant.getStateFromMeta(BlockFossil.BaseBlockType.DIORITE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.STONE.getStateFromMeta(BlockStone.EnumType.ANDESITE.getMetadata())), DeBlocks.fossil_block_plant.getStateFromMeta(BlockFossil.BaseBlockType.ANDESITE.getMetadata()));
		replace_to_place_list.put(Predicates.equalTo(Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.getMetadata())), DeBlocks.fossil_block_plant.getStateFromMeta(BlockFossil.BaseBlockType.SANDSTONE.getMetadata()));
		this.gen_fossil_plant = new WorldGenMinableStates(replace_to_place_list, 4);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
			case 0:
				// Overworld
				this.runGenerator(this.gen_fossil_animal, world, random, chunkX, chunkZ, 16, 35, 80);
				this.runGenerator(this.gen_fossil_plant, world, random, chunkX, chunkZ, 6, 35, 80);
				break;
			case -1:
				// Nether
				break;
			case 1:
				// End
				break;
		}
	}

	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight)
	{
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++)
		{
			int x = chunk_X * 16 + rand.nextInt(16);
			int z = chunk_Z * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	public static void initWorldGen()
	{
		GameRegistry.registerWorldGenerator(new DeWorldGenOres(), 0);
	}
}
