package com.deextinction.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumHand;
import net.minecraft.world.IBlockAccess;

public class BlockBasic extends Block
{

	public BlockBasic(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(material);
		if (tab != null)
			this.setCreativeTab(tab);

		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(soundType);
	}

	public BlockBasic(Material material, SoundType soundType, CreativeTabs tab)
	{
		this(1.5F, 10.0F, material, soundType, tab);
	}

	public BlockBasic(CreativeTabs tab)
	{
		this(1.5F, 10.0F, Material.ROCK, SoundType.STONE, tab);
	}

	public boolean isPlayerBreakingWithItem(IBlockAccess world, Item item)
	{
		EntityPlayer player = harvesters.get();
		if (player != null)
			return player.getHeldItem(EnumHand.MAIN_HAND).getItem() == item;
		return false;
	}
}
