package com.deextinction.database.plants;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.block.plants.BlockDeExtinctedSapling;
import com.deextinction.block.plants.BlockSaplingSequoiadendron;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.TypeOfLife;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeCreativeTabs;
import com.deextinction.world.gen.trees.WorldGenSequoiadendronGraySmall;

import net.minecraft.block.BlockPlanks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class Sequoiadendron extends DeExtinctedTree
{
	public static final String NAME = "sequoiadendron";

	public Sequoiadendron()
	{
		super(Sequoiadendron.NAME);
	}

	@Override
	public ItemStack getPrecursorItem()
	{
		return new ItemStack(Blocks.SAPLING, 1, BlockPlanks.EnumType.SPRUCE.getMetadata());
	}

	@Override
	public ItemStack getResultItem(String dna)
	{
		return new ItemStack(DeBlocks.saplings.get(Sequoiadendron.NAME));
	}

	@Override
	public GeologicEra getGeologicEra()
	{
		return GeologicEra.CENOZOIC;
	}

	@Override
	public TypeOfLife getTypeOfLife()
	{
		return TypeOfLife.GYMNOSPERM;
	}

	public List<BlockDeExtinctedSapling> getTreeSaplings()
	{
		List<BlockDeExtinctedSapling> parts = new ArrayList<BlockDeExtinctedSapling>();
		parts.add(new BlockSaplingSequoiadendron(DeExtinctedTree.DEFAULT_SAPLING, DeCreativeTabs.blocks));
		return parts;
	}

	@Override
	public WorldGenAbstractTree getTreeGenerator(String variant)
	{
		return new WorldGenSequoiadendronGraySmall();
	}

	@Override
	public ItemStack getSpecialDropFromLeaves(int chance)
	{
		return ItemStack.EMPTY;
	}
}
