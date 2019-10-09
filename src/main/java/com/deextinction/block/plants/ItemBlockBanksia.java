package com.deextinction.block.plants;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockBanksia extends ItemBlock
{
	public ItemBlockBanksia(Block block)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return super.getUnlocalizedName() + "_" + BlockBanksia.EnumTypes.byMetadata(stack.getMetadata()).toString();
	}
}
