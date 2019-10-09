package com.deextinction.world;

import com.deextinction.block.BlockContainerHorizontal;
import com.deextinction.block.machines.BlockDNADecoder;
import com.deextinction.block.machines.BlockDNAEditor;
import com.deextinction.block.machines.BlockDNAExtractor;
import com.deextinction.block.machines.BlockDeExtinctionMachine;
import com.deextinction.block.machines.BlockMicroscope;
import com.deextinction.init.DeBlocks;
import com.deextinction.world.gen.structures.villagers.VillageResearchLabComponent;

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
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.BiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class DeBlockProcessorVillageResearchLab extends DeBlockProcessorVillage
{

	public DeBlockProcessorVillageResearchLab(BlockPos pos, PlacementSettings settings, ResourceLocation loot, VillageResearchLabComponent village, Biome biome)
	{
		super(pos, settings, loot, village, biome);
	}

	@Override
	protected IBlockState getBiomeSpecificBlockState(IBlockState blockstateIn, Biome biome)
	{
		BiomeEvent.GetVillageBlockID event = new BiomeEvent.GetVillageBlockID(biome, blockstateIn);
		MinecraftForge.TERRAIN_GEN_BUS.post(event);

		int structureType = DeBlockProcessorVillageResearchLab.VILLAGE_PLAINS;
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) && BiomeDictionary.hasType(biome, BiomeDictionary.Type.DRY))
			structureType = DeBlockProcessorVillageResearchLab.VILLAGE_SAND;
		else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))
			structureType = DeBlockProcessorVillageResearchLab.VILLAGE_SAVANNA;
		else if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS))
			structureType = DeBlockProcessorVillageResearchLab.VILLAGE_CONIFEROUS;

		if (event.getResult() == Event.Result.DENY)
			return event.getReplacement();

		EnumFacing facingHouse = this.village.rotation.rotate(this.village.coordBaseMode).getOpposite();
		if (this.village.coordBaseMode == EnumFacing.NORTH || this.village.coordBaseMode == EnumFacing.SOUTH)
			facingHouse = this.village.rotation.rotate(this.village.coordBaseMode).getOpposite();
		else
			facingHouse = this.village.rotation.rotate(this.village.coordBaseMode);

		if (this.village.mirror == Mirror.LEFT_RIGHT)
			facingHouse = facingHouse.getOpposite();

		if (blockstateIn.getBlock() instanceof BlockDoor && blockstateIn.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.LOWER)
		{
			return this.biomeDoor(structureType).withProperty(BlockDoor.FACING, blockstateIn.getValue(BlockDoor.FACING));
		}

		if (blockstateIn.getBlock() instanceof BlockDoor && blockstateIn.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.UPPER)
		{
			return this.biomeDoor(structureType).withProperty(BlockDoor.FACING, blockstateIn.getValue(BlockDoor.FACING)).withProperty(BlockDoor.HALF, BlockDoor.EnumDoorHalf.UPPER);
		}

		if (blockstateIn == Blocks.IRON_BLOCK.getDefaultState())
		{
			if (this.random.nextInt(3) == 0)
			{
				switch (this.random.nextInt(5))
				{
					case 0:
						return DeBlocks.dna_extractor.getDefaultState().withProperty(BlockDNAExtractor.FACING, facingHouse);
					case 1:
						return DeBlocks.dna_editor.getDefaultState().withProperty(BlockDNAEditor.FACING, facingHouse);
					case 2:
						return DeBlocks.dna_decoder.getDefaultState().withProperty(BlockDNADecoder.FACING, facingHouse);
					case 3:
						return DeBlocks.de_extinction_machine.getDefaultState().withProperty(BlockDeExtinctionMachine.FACING, facingHouse);
					case 4:
						return DeBlocks.microscope.getDefaultState().withProperty(BlockMicroscope.FACING, facingHouse);
				}
			}

			return Blocks.AIR.getDefaultState();
		}

		if (blockstateIn == Blocks.GOLD_BLOCK.getDefaultState())
		{
			if (this.random.nextInt(3) > 0)
				return DeBlocks.cleaning_table_block.getDefaultState().withProperty(BlockContainerHorizontal.FACING, facingHouse.rotateYCCW());

			return Blocks.AIR.getDefaultState();
		}

		switch (structureType)
		{
			case DeBlockProcessorVillageResearchLab.VILLAGE_SAND:
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
					return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING)).withProperty(BlockStairs.HALF, blockstateIn.getValue(BlockStairs.HALF)).withProperty(BlockStairs.SHAPE, blockstateIn.getValue(BlockStairs.SHAPE));
				else if (blockstateIn.getBlock() == Blocks.STONE_STAIRS)
					return Blocks.SANDSTONE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING)).withProperty(BlockStairs.HALF, blockstateIn.getValue(BlockStairs.HALF)).withProperty(BlockStairs.SHAPE, blockstateIn.getValue(BlockStairs.SHAPE));

				else if (blockstateIn.getBlock() == Blocks.GRAVEL)
					return Blocks.SANDSTONE.getDefaultState();
				break;
			case DeBlockProcessorVillageResearchLab.VILLAGE_SAVANNA:
				if (blockstateIn.getBlock() == Blocks.LOG || blockstateIn.getBlock() == Blocks.LOG2)
					return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, blockstateIn.getValue(BlockLog.LOG_AXIS));

				else if (blockstateIn.getBlock() == Blocks.PLANKS)
					return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA);

				else if (blockstateIn.getBlock() == Blocks.OAK_STAIRS)
					return Blocks.ACACIA_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING)).withProperty(BlockStairs.HALF, blockstateIn.getValue(BlockStairs.HALF)).withProperty(BlockStairs.SHAPE, blockstateIn.getValue(BlockStairs.SHAPE));

				else if (blockstateIn.getBlock() == Blocks.COBBLESTONE)
					return Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA).withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y);

				else if (blockstateIn.getBlock() == Blocks.OAK_FENCE)
					return Blocks.ACACIA_FENCE.getDefaultState();
				break;
			case DeBlockProcessorVillageResearchLab.VILLAGE_CONIFEROUS:
				if (blockstateIn.getBlock() == Blocks.LOG || blockstateIn.getBlock() == Blocks.LOG2)
					return Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE).withProperty(BlockLog.LOG_AXIS, blockstateIn.getValue(BlockLog.LOG_AXIS));

				else if (blockstateIn.getBlock() == Blocks.PLANKS)
					return Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE);

				else if (blockstateIn.getBlock() == Blocks.OAK_STAIRS)
					return Blocks.SPRUCE_STAIRS.getDefaultState().withProperty(BlockStairs.FACING, blockstateIn.getValue(BlockStairs.FACING)).withProperty(BlockStairs.HALF, blockstateIn.getValue(BlockStairs.HALF)).withProperty(BlockStairs.SHAPE, blockstateIn.getValue(BlockStairs.SHAPE));

				else if (blockstateIn.getBlock() == Blocks.OAK_FENCE)
					return Blocks.SPRUCE_FENCE.getDefaultState();
				break;
		}

		return blockstateIn;
	}
}
