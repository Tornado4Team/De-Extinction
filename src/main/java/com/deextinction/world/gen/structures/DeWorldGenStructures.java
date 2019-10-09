package com.deextinction.world.gen.structures;

import java.util.ArrayList;
import java.util.Random;

import com.deextinction.world.StructureUtils;

import net.minecraft.block.Block;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.VillagerRegistry;
import scala.actors.threadpool.Arrays;

public class DeWorldGenStructures implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.getDimension())
		{
			case 0:
				// Overworld
				break;
			case -1:
				// Nether
				break;
			case 1:
				// End
				break;
		}
	}

	public void generateStructure(ResourceLocation generator, World world, Random random, int chunkX, int chunkZ, int yOffset, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int y = this.calculateGenerationHeight(world, x, z, topBlock);

		BlockPos position = new BlockPos(x, y, z);
		if (classesList.contains(world.provider.getBiomeForCoords(position).getClass()))
		{
			if (random.nextInt(chance) == 0)
				StructureUtils.generateStructure(generator, world, position.down(yOffset), random, true, false);
		}
	}

	public void generateStructure(ResourceLocation generator, ResourceLocation lootTable, World world, Random random, int chunkX, int chunkZ, int yOffset, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int y = this.calculateGenerationHeight(world, x, z, topBlock);

		BlockPos position = new BlockPos(x, y, z);
		if (classesList.contains(world.provider.getBiomeForCoords(position).getClass()))
		{
			if (random.nextInt(chance) == 0)
				StructureUtils.generateStructure(generator, lootTable, world, position.down(yOffset), random, true, false);
		}
	}

	public void generateStructure(ResourceLocation generator, VillagerRegistry.VillagerProfession profession, World world, Random random, int chunkX, int chunkZ, int yOffset, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int y = this.calculateGenerationHeight(world, x, z, topBlock);

		BlockPos position = new BlockPos(x, y, z);
		if (classesList.contains(world.provider.getBiomeForCoords(position).getClass()))
		{
			if (random.nextInt(chance) == 0)
			{
				if (StructureUtils.generateStructure(generator, world, position.down(yOffset), random, true, false))
				{
					position = position.up(1);
					EntityVillager villager = new EntityVillager(world);
					villager.setProfession(profession);
					villager.setLocationAndAngles(position.getX() - 0.5D, position.getY() - 0.5D, position.getZ() - 0.5D, 0, 0);
					world.spawnEntity(villager);
				}
			}
		}
	}

	public void generateStructure(ResourceLocation generator, ResourceLocation lootTable, VillagerRegistry.VillagerProfession profession, World world, Random random, int chunkX, int chunkZ, int yOffset, int chance, Block topBlock, Class<?>... classes)
	{
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>(Arrays.asList(classes));

		int x = chunkX * 16 + random.nextInt(16);
		int z = chunkZ * 16 + random.nextInt(16);
		int y = this.calculateGenerationHeight(world, x, z, topBlock);

		BlockPos position = new BlockPos(x, y, z);
		if (classesList.contains(world.provider.getBiomeForCoords(position).getClass()))
		{
			if (random.nextInt(chance) == 0)
			{
				if (StructureUtils.generateStructure(generator, lootTable, world, position.down(yOffset), random, true, false))
				{
					position = position.up(1);
					EntityVillager villager = new EntityVillager(world);
					villager.setProfession(profession);
					villager.setLocationAndAngles(position.getX() - 0.5D, position.getY() - 0.5D, position.getZ() - 0.5D, 0, 0);
					world.spawnEntity(villager);
				}
			}
		}
	}

	private static int calculateGenerationHeight(World world, int x, int z, Block topBlock)
	{
		int y = world.getHeight();
		boolean foundGround = false;

		Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
		while (block != topBlock && y-- >= 0)
			block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

		return y + 1;
	}

	public static void initWorldGen()
	{
		GameRegistry.registerWorldGenerator(new DeWorldGenStructures(), 0);
	}
}
