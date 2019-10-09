package com.deextinction.block.plants;

import com.deextinction.database.plants.Sequoiadendron;
import com.deextinction.init.DeDatabase;

import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.AxisAlignedBB;

public class BlockSaplingSequoiadendron extends BlockDeExtinctedSapling
{
	public static final PropertyInteger STAGE = PropertyInteger.create("stage", 0, 4);
	private static final AxisAlignedBB[] SAPLING_AABB = new AxisAlignedBB[] { new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 0.5D, 0.7D), new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.6D, 0.8D), new AxisAlignedBB(0.3D, 0.0D, 0.3D, 0.7D, 0.8D, 0.7D), new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 0.9D, 0.8D),
			new AxisAlignedBB(0.2D, 0.0D, 0.2D, 0.8D, 1.0D, 0.8D) };

	public BlockSaplingSequoiadendron(String variant, CreativeTabs tab)
	{
		super((Sequoiadendron) DeDatabase.LIST_DE_EXTINCTED.get(Sequoiadendron.NAME), variant, tab);
	}

	@Override
	protected PropertyInteger getStageProperty()
	{
		return BlockSaplingSequoiadendron.STAGE;
	}

	@Override
	protected AxisAlignedBB getStageAABB(IBlockState state)
	{
		return BlockSaplingSequoiadendron.SAPLING_AABB[((Integer) state.getValue(BlockSaplingSequoiadendron.STAGE)).intValue()];
	}

	@Override
	protected Integer numberOfStages()
	{
		return 4;
	}
}
