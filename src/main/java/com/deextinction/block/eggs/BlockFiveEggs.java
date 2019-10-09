package com.deextinction.block.eggs;

import com.deextinction.database.DeExtincted;
import com.deextinction.init.DeCreativeTabs;
import com.deextinction.tileentities.TileEgg;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockFiveEggs extends BlockEgg
{
	public static final PropertyInteger NUMBER_OF_EGGS = PropertyInteger.create("eggs", 1, BlockEgg.EnumNumber.FIVE.getNumber());

	public BlockFiveEggs(DeExtincted deExtincted)
	{
		super(deExtincted, 0.5F, 0.5F, Material.GROUND, SoundType.GROUND, DeCreativeTabs.items);
	}

	@Override
	public IProperty getEggProperty()
	{
		return BlockFiveEggs.NUMBER_OF_EGGS;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEgg(BlockEgg.EnumNumber.FIVE.getNumber());
	}
}
