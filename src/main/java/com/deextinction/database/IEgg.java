package com.deextinction.database;

import com.deextinction.block.eggs.BlockEgg;

import net.minecraft.util.math.AxisAlignedBB;

public interface IEgg
{
	public static final AxisAlignedBB EGG_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.4D, 0.9D);

	public BlockEgg.EnumNumber getTotalNumberOfEgg();

	public int getMaxHatchingProgress();

	public default AxisAlignedBB getEggAABB()
	{
		return IEgg.EGG_AABB;
	}
}
