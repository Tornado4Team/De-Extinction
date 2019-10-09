package com.deextinction.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class StructureUtils
{

	public static boolean generateStructure(ResourceLocation structure, World world, BlockPos position, Random random, boolean checkGround, boolean removeAir)
	{
		Template template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), structure);
		Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
		Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
		BlockPos center = position;

		switch (rotation)
		{
			case NONE:
				center = position;
				break;
			case CLOCKWISE_90:
				center = position.add(template.getSize().getZ() - 1, 0, 0);
				break;
			case COUNTERCLOCKWISE_90:
				center = position.add(0, 0, template.getSize().getX() - 1);
				break;
			case CLOCKWISE_180:
				center = position.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
		}

		PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(mirror);
		if (removeAir)
			settings.setReplacedBlock(Blocks.AIR);

		System.out.println("generating");

		if (checkGround)
		{
			System.out.println("checkGround");
			BlockPos corner1 = position.down();
			BlockPos corner2 = position.add(template.getSize().getX(), -1, 0);
			BlockPos corner3 = position.add(template.getSize().getX(), -1, template.getSize().getZ());
			BlockPos corner4 = position.add(0, -1, template.getSize().getZ());

			System.out.println("center " + center);
			System.out.println("world.getBlockState(center) " + world.getBlockState(center));
			System.out.println("world.getBlockState(corner1) " + world.getBlockState(corner1));
			System.out.println("world.getBlockState(corner2) " + world.getBlockState(corner2));
			System.out.println("world.getBlockState(corner3) " + world.getBlockState(corner3));
			System.out.println("world.getBlockState(corner4) " + world.getBlockState(corner4));

			if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube())
			{
				template.addBlocksToWorldChunk(world, center, settings);
				return true;
			}
		}
		else
		{
			System.out.println("not checkGround");
			System.out.println("center " + center);
			template.addBlocksToWorldChunk(world, center, settings);
			return true;
		}

		return false;
	}

	public static boolean generateStructure(ResourceLocation structure, ResourceLocation lootTable, World world, BlockPos position, Random random, boolean checkGround, boolean removeAir)
	{
		Template template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), structure);
		Rotation rotation = Rotation.values()[random.nextInt(Rotation.values().length)];
		Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
		BlockPos center = position;

		switch (rotation)
		{
			case NONE:
				center = position;
				break;
			case CLOCKWISE_90:
				center = position.add(template.getSize().getZ() - 1, 0, 0);
				break;
			case COUNTERCLOCKWISE_90:
				center = position.add(0, 0, template.getSize().getX() - 1);
				break;
			case CLOCKWISE_180:
				center = position.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
		}

		PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(mirror);
		if (removeAir)
			settings.setReplacedBlock(Blocks.AIR);

		if (checkGround)
		{
			BlockPos corner1 = position.down();
			BlockPos corner2 = position.add(template.getSize().getX(), -1, 0);
			BlockPos corner3 = position.add(template.getSize().getX(), -1, template.getSize().getZ());
			BlockPos corner4 = position.add(0, -1, template.getSize().getZ());
			if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube())
			{
				template.addBlocksToWorld(world, center, new DeBlockProcessorLoot(center, settings, lootTable), settings, 2);
				return true;
			}
		}
		else
		{
			template.addBlocksToWorld(world, center, new DeBlockProcessorLoot(center, settings, lootTable), settings, 2);
			return true;
		}

		return false;
	}

	public static boolean generateStructure(ResourceLocation structure, World world, BlockPos position, Rotation rotation, Random random, boolean checkGround, boolean removeAir)
	{
		Template template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), structure);
		Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
		BlockPos center = position;

		switch (rotation)
		{
			case NONE:
				center = position;
				break;
			case CLOCKWISE_90:
				center = position.add(template.getSize().getZ() - 1, 0, 0);
				break;
			case COUNTERCLOCKWISE_90:
				center = position.add(0, 0, template.getSize().getX() - 1);
				break;
			case CLOCKWISE_180:
				center = position.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
		}

		PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(mirror);
		if (removeAir)
			settings.setReplacedBlock(Blocks.AIR);

		if (checkGround)
		{
			BlockPos corner1 = position.down();
			BlockPos corner2 = position.add(template.getSize().getX(), -1, 0);
			BlockPos corner3 = position.add(template.getSize().getX(), -1, template.getSize().getZ());
			BlockPos corner4 = position.add(0, -1, template.getSize().getZ());

			if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube())
			{
				template.addBlocksToWorldChunk(world, center, settings);
				return true;
			}
		}
		else
		{
			template.addBlocksToWorldChunk(world, center, settings);
			return true;
		}

		return false;
	}

	public static boolean generateStructure(ResourceLocation structure, ResourceLocation lootTable, World world, BlockPos position, Rotation rotation, Random random, boolean checkGround, boolean removeAir)
	{
		Template template = world.getSaveHandler().getStructureTemplateManager().getTemplate(world.getMinecraftServer(), structure);
		Mirror mirror = Mirror.values()[random.nextInt(Mirror.values().length)];
		BlockPos center = position;

		switch (rotation)
		{
			case NONE:
				center = position;
				break;
			case CLOCKWISE_90:
				center = position.add(template.getSize().getZ() - 1, 0, 0);
				break;
			case COUNTERCLOCKWISE_90:
				center = position.add(0, 0, template.getSize().getX() - 1);
				break;
			case CLOCKWISE_180:
				center = position.add(template.getSize().getX() - 1, 0, template.getSize().getZ() - 1);
		}

		PlacementSettings settings = new PlacementSettings().setRotation(rotation).setMirror(mirror);
		if (removeAir)
			settings.setReplacedBlock(Blocks.AIR);

		if (checkGround)
		{
			BlockPos corner1 = position.down();
			BlockPos corner2 = position.add(template.getSize().getX(), -1, 0);
			BlockPos corner3 = position.add(template.getSize().getX(), -1, template.getSize().getZ());
			BlockPos corner4 = position.add(0, -1, template.getSize().getZ());
			if (world.getBlockState(center).isOpaqueCube() && world.getBlockState(corner1).isOpaqueCube() && world.getBlockState(corner2).isOpaqueCube() && world.getBlockState(corner3).isOpaqueCube() && world.getBlockState(corner4).isOpaqueCube())
			{
				template.addBlocksToWorld(world, center, new DeBlockProcessorLoot(center, settings, lootTable), settings, 2);
				return true;
			}
		}
		else
		{
			template.addBlocksToWorld(world, center, new DeBlockProcessorLoot(center, settings, lootTable), settings, 2);
			return true;
		}

		return false;
	}

}
