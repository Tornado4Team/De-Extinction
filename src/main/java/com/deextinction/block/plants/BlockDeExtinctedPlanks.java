package com.deextinction.block.plants;

import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeDatabase;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

public class BlockDeExtinctedPlanks extends Block
{
	private final String treeName;

	public BlockDeExtinctedPlanks(DeExtinctedTree tree, CreativeTabs tab)
	{
		super(Material.WOOD);
		if (tab != null)
			this.setCreativeTab(tab);
		this.treeName = tree.getName();

		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setSoundType(SoundType.WOOD);

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
