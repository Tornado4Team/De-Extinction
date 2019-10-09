package com.deextinction.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class ItemRockPick extends ItemPickaxe
{

	public ItemRockPick(CreativeTabs tab)
	{
		super(ToolMaterial.IRON);
		this.setCreativeTab(tab);
		this.setMaxStackSize(1);
		this.setMaxDamage(64);
	}
}
