package com.deextinction.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemBasic extends Item
{

	public ItemBasic(CreativeTabs tab)
	{
		if (tab != null)
			this.setCreativeTab(tab);
	}

	protected static void spawnItem(World worldIn, BlockPos pos, ItemStack drop)
	{
		if (!worldIn.isRemote && !drop.isEmpty() && worldIn.getGameRules().getBoolean("doTileDrops") && !worldIn.restoringBlockSnapshots)
		{
			EntityItem entityitem = new EntityItem(worldIn, (double) pos.getX() + (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D, (double) pos.getY() + (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D, (double) pos.getZ() + (double) (worldIn.rand.nextFloat() * 0.5F) + 0.25D, drop);
			entityitem.setDefaultPickupDelay();
			worldIn.spawnEntity(entityitem);
		}
	}
}
