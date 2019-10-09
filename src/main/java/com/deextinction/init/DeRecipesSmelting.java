package com.deextinction.init;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class DeRecipesSmelting
{

	public static void postInitRecipesSmelting()
	{
		for (Block logBlock : DeBlocks.logs.values())
		{
			GameRegistry.addSmelting(new ItemStack(logBlock), new ItemStack(Items.COAL, 1, 1), 0.15F);
		}
	}
}
