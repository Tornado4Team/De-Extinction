package com.deextinction.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class DeCreativeTabs
{
	public static CreativeTabs blocks;
	public static CreativeTabs items;
	public static CreativeTabs research;

	public static void preInitCreativeTabs()
	{
		DeCreativeTabs.blocks = new CreativeTabs("de_tab_blocks")
		{
			@Override
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem()
			{
				return new ItemStack(Item.getItemFromBlock(Blocks.STONE));
			}
		};

		DeCreativeTabs.items = new CreativeTabs("de_tab_items")
		{
			@Override
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem()
			{
				return new ItemStack(Items.BONE);
			}
		};

		DeCreativeTabs.research = new CreativeTabs("de_tab_research")
		{
			@Override
			@SideOnly(Side.CLIENT)
			public ItemStack getTabIconItem()
			{
				return new ItemStack(DeItems.syringe);
			}
		};
	}
}
