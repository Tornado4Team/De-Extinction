package com.deextinction.block;

import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeDatabase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BlockDeExtinctedFence extends BlockFence
{
	private final String treeName;

	public BlockDeExtinctedFence(DeExtinctedTree tree, IBlockState baseState, CreativeTabs tab)
	{
		super(baseState.getBlock().getMaterial(baseState), baseState.getBlock().getMaterial(baseState).getMaterialMapColor());
		this.treeName = tree.getName();
		if (tab != null)
			this.setCreativeTab(tab);

		Block baseBlock = baseState.getBlock();
		this.setHardness(baseBlock.getBlockHardness(baseState, null, null));
		this.setResistance((baseBlock.getExplosionResistance(null) * 5.0F) / 3.0F);
		this.setSoundType(baseBlock.getSoundType());

		Blocks.FIRE.setFireInfo(this, 5, 20);
	}

	public String getTreeName()
	{
		return this.treeName;
	}

	public DeExtinctedPlant getTree()
	{
		return (DeExtinctedPlant) DeDatabase.LIST_DE_EXTINCTED.get(this.treeName);
	}
}
