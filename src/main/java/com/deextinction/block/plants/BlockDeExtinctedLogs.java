package com.deextinction.block.plants;

import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeDatabase;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BlockDeExtinctedLogs extends BlockLog
{
	private final String treeName;

	public BlockDeExtinctedLogs(DeExtinctedTree tree, CreativeTabs tab)
	{
		this.treeName = tree.getName();
		if (tab != null)
			this.setCreativeTab(tab);

		this.setResistance(0.5F);
		this.setDefaultState(this.getBlockState().getBaseState().withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));

		Blocks.FIRE.setFireInfo(this, 5, 5);
	}

	public String getTreeName()
	{
		return this.treeName;
	}

	public DeExtinctedPlant getTree()
	{
		return (DeExtinctedPlant) DeDatabase.LIST_DE_EXTINCTED.get(this.treeName);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.values()[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BlockLog.LOG_AXIS).ordinal();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockLog.LOG_AXIS);
	}
}
