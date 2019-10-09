package com.deextinction.database;

import java.util.HashMap;
import java.util.List;

import com.deextinction.block.BlockDeExtinctedDoor;
import com.deextinction.block.BlockDeExtinctedFence;
import com.deextinction.block.BlockDeExtinctedFenceGate;
import com.deextinction.block.BlockDeExtinctedSlabDouble;
import com.deextinction.block.BlockDeExtinctedSlabHalf;
import com.deextinction.block.BlockDeExtinctedStairs;
import com.deextinction.block.BlockDeExtinctedTrapDoor;
import com.deextinction.block.plants.BlockDeExtinctedLeaves;
import com.deextinction.block.plants.BlockDeExtinctedLogs;
import com.deextinction.block.plants.BlockDeExtinctedPlanks;
import com.deextinction.block.plants.BlockDeExtinctedSapling;
import com.deextinction.init.DeCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public abstract class DeExtinctedTree extends DeExtinctedPlant
{
	public static final String DEFAULT_SAPLING = "default";

	public DeExtinctedTree(String unlocalizedName)
	{
		super(unlocalizedName);
	}

	public HashMap<EnumTreeBlocks, Block> getTreeBlocks()
	{
		HashMap<DeExtinctedTree.EnumTreeBlocks, Block> parts = new HashMap<DeExtinctedTree.EnumTreeBlocks, Block>();
		parts.put(DeExtinctedTree.EnumTreeBlocks.LOG, new BlockDeExtinctedLogs(this, DeCreativeTabs.blocks));
		parts.put(DeExtinctedTree.EnumTreeBlocks.LEAVES, new BlockDeExtinctedLeaves(this, DeCreativeTabs.blocks));
		parts.put(DeExtinctedTree.EnumTreeBlocks.PLANKS, new BlockDeExtinctedPlanks(this, DeCreativeTabs.blocks));
		return parts;
	}

	public HashMap<EnumTreeBlocks, Block> getTreeBlocksDerivatives(BlockDeExtinctedPlanks planks)
	{
		HashMap<DeExtinctedTree.EnumTreeBlocks, Block> parts = new HashMap<DeExtinctedTree.EnumTreeBlocks, Block>();
		IBlockState plankState = planks.getDefaultState();
		if (plankState != null)
		{
			parts.put(DeExtinctedTree.EnumTreeBlocks.STAIRS, new BlockDeExtinctedStairs(this, plankState, DeCreativeTabs.blocks));
			parts.put(DeExtinctedTree.EnumTreeBlocks.SLAB_SINGLE, new BlockDeExtinctedSlabHalf(this, plankState, DeCreativeTabs.blocks));
			parts.put(DeExtinctedTree.EnumTreeBlocks.SLAB_DOUBLE, new BlockDeExtinctedSlabDouble(this, plankState, null));
			parts.put(DeExtinctedTree.EnumTreeBlocks.DOOR, new BlockDeExtinctedDoor(this, plankState, DeCreativeTabs.blocks));
			parts.put(DeExtinctedTree.EnumTreeBlocks.TRAP_DOOR, new BlockDeExtinctedTrapDoor(this, plankState, DeCreativeTabs.blocks));
			parts.put(DeExtinctedTree.EnumTreeBlocks.FENCE, new BlockDeExtinctedFence(this, plankState, DeCreativeTabs.blocks));
			parts.put(DeExtinctedTree.EnumTreeBlocks.FENCE_GATE, new BlockDeExtinctedFenceGate(this, plankState, DeCreativeTabs.blocks));
		}
		return parts;
	}

	public abstract List<BlockDeExtinctedSapling> getTreeSaplings();

	public abstract WorldGenAbstractTree getTreeGenerator(String variant);

	public abstract ItemStack getSpecialDropFromLeaves(int chance);

	public static enum EnumTreeBlocks implements IStringSerializable
	{
		SAPLING("sapling"),
		LOG("log"),
		LEAVES("leaves"),
		PLANKS("planks"),
		STAIRS("stairs"),
		SLAB_SINGLE("slab_single"),
		SLAB_DOUBLE("slab_double"),
		DOOR("door"),
		TRAP_DOOR("trapdoor"),
		FENCE("fence"),
		FENCE_GATE("fence_gate");

		private EnumTreeBlocks(String unlocalizedName)
		{
			this.unlocalizedName = unlocalizedName;
		}

		@Override
		public String getName()
		{
			return this.unlocalizedName;
		}

		@Override
		public String toString()
		{
			return this.unlocalizedName;
		}

		private final String unlocalizedName;
	}
}
