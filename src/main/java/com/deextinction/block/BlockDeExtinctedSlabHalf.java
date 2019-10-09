package com.deextinction.block;

import com.deextinction.database.DeExtinctedTree;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;

public class BlockDeExtinctedSlabHalf extends BlockDeExtinctedSlab
{
	public BlockDeExtinctedSlabHalf(DeExtinctedTree tree, IBlockState baseState, CreativeTabs tab)
	{
		super(tree, baseState, tab);
	}

	@Override
	public boolean isDouble()
	{
		return false;
	}
}
