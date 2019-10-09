package com.deextinction.world;

import javax.annotation.Nullable;

import com.deextinction.world.gen.structures.villagers.VillageResearchLabComponent;

import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;

public class DeBlockProcessorVillage extends DeBlockProcessorLoot
{
	public static final int VILLAGE_PLAINS = 0;
	public static final int VILLAGE_SAND = 1;
	public static final int VILLAGE_SAVANNA = 2;
	public static final int VILLAGE_CONIFEROUS = 3;

	protected VillageResearchLabComponent village;
	protected Biome biome;

	public DeBlockProcessorVillage(BlockPos pos, PlacementSettings settings, ResourceLocation loot, VillageResearchLabComponent village, Biome biome)
	{
		super(pos, settings, loot);
		this.village = village;
		this.biome = biome;
	}

	@Nullable
	public Template.BlockInfo processBlock(World worldIn, BlockPos pos, Template.BlockInfo blockInfoIn)
	{
		if (blockInfoIn.blockState.getBlock() instanceof BlockChest && this.loot_table != null)
			return super.processBlock(worldIn, pos, blockInfoIn);
		else
			return new Template.BlockInfo(pos, this.getBiomeSpecificBlockState(blockInfoIn.blockState, this.biome), null);
	}

	protected IBlockState getBiomeSpecificBlockState(IBlockState blockstateIn, Biome biome)
	{
		BiomeEvent.GetVillageBlockID event = new BiomeEvent.GetVillageBlockID(biome, blockstateIn);
		MinecraftForge.TERRAIN_GEN_BUS.post(event);

		int structureType = DeBlockProcessorVillage.VILLAGE_PLAINS;
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) && BiomeDictionary.hasType(biome, BiomeDictionary.Type.DRY))
			structureType = DeBlockProcessorVillage.VILLAGE_SAND;
		else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))
			structureType = DeBlockProcessorVillage.VILLAGE_SAVANNA;
		else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS))
			structureType = DeBlockProcessorVillage.VILLAGE_CONIFEROUS;

		if (event.getResult() == net.minecraftforge.fml.common.eventhandler.Event.Result.DENY)
			return event.getReplacement();

		if (blockstateIn.getBlock() instanceof BlockDoor && blockstateIn.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER)
		{
			EnumFacing facing = blockstateIn.getValue(BlockDoor.FACING);
			return biomeDoor(structureType).withProperty(BlockDoor.FACING, facing);
		}

		if (blockstateIn.getBlock() instanceof BlockDoor && blockstateIn.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.UPPER)
		{
			EnumFacing facing = blockstateIn.getValue(BlockDoor.FACING);
			return biomeDoor(structureType).withProperty(BlockDoor.FACING, facing).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
		}

		switch (structureType)
		{
			case DeBlockProcessorVillage.VILLAGE_SAND:
				if (blockstateIn.getBlock() == Blocks.LOG || blockstateIn.getBlock() == Blocks.LOG2)
					return Blocks.SANDSTONE.getDefaultState();

				else if (blockstateIn.getBlock() == Blocks.COBBLESTONE)
					return Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.DEFAULT.getMetadata());

				else if (blockstateIn.getBlock() == Blocks.DIRT)
					return Blocks.SAND.getDefaultState();

				else if (blockstateIn.getBlock() == Blocks.GRASS)
					return Blocks.SANDSTONE.getDefaultState();

				else if (blockstateIn.getBlock() == Blocks.PLANKS)
					return Blocks.SANDSTONE.getStateFromMeta(BlockSandStone.EnumType.SMOOTH.getMetadata());

				else if (blockstateIn.getBlock() == Blocks.OAK_STAIRS)
					return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING));

				else if (blockstateIn.getBlock() == Blocks.STONE_STAIRS)
					return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING));

				else if (blockstateIn.getBlock() == Blocks.GRAVEL)
					return Blocks.SANDSTONE.getDefaultState();
				break;
			case DeBlockProcessorVillage.VILLAGE_SAVANNA:
				if (blockstateIn.getBlock() == Blocks.LOG || blockstateIn.getBlock() == Blocks.LOG2)
					return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, blockstateIn.getValue(BlockLog.LOG_AXIS));

				else if (blockstateIn.getBlock() == Blocks.PLANKS)
					return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);

				else if (blockstateIn.getBlock() == Blocks.OAK_STAIRS)
					return Blocks.ACACIA_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING));

				else if (blockstateIn.getBlock() == Blocks.COBBLESTONE)
					return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y);

				else if (blockstateIn.getBlock() == Blocks.OAK_FENCE)
					return Blocks.ACACIA_FENCE.getDefaultState();
				break;
			case DeBlockProcessorVillage.VILLAGE_CONIFEROUS:
				if (blockstateIn.getBlock() == Blocks.LOG || blockstateIn.getBlock() == Blocks.LOG2)
					return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLog.LOG_AXIS, blockstateIn.getValue(BlockLog.LOG_AXIS));

				else if (blockstateIn.getBlock() == Blocks.PLANKS)
					return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);

				else if (blockstateIn.getBlock() == Blocks.OAK_STAIRS)
					return Blocks.SPRUCE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING));

				else if (blockstateIn.getBlock() == Blocks.OAK_FENCE)
					return Blocks.SPRUCE_FENCE.getDefaultState();
				break;
			default:
				if (blockstateIn.getBlock() == Blocks.GRASS && structureType != 1)
					return Blocks.GRASS_PATH.getDefaultState();
		}

		return blockstateIn;
	}

	protected IBlockState biomeDoor(int structureType)
	{
		switch (structureType)
		{
			case DeBlockProcessorVillage.VILLAGE_SAVANNA:
				return Blocks.ACACIA_DOOR.getDefaultState();
			case DeBlockProcessorVillage.VILLAGE_CONIFEROUS:
				return Blocks.SPRUCE_DOOR.getDefaultState();
			default:
				return Blocks.OAK_DOOR.getDefaultState();
		}
	}
}
