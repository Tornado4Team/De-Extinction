package com.deextinction.block;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockContainerHorizontalWorking extends BlockContainerHorizontal
{
	public static final PropertyBool WORKING = PropertyBool.create("working");

	public BlockContainerHorizontalWorking(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockContainerHorizontalWorking.FACING, EnumFacing.NORTH).withProperty(BlockContainerHorizontalWorking.WORKING, Boolean.valueOf(false)));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		if (((Boolean) stateIn.getValue(BlockContainerHorizontalWorking.WORKING)).booleanValue())
			this.randomWorkingTick(stateIn, worldIn, pos, rand);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockContainerHorizontalWorking.FACING, BlockContainerHorizontalWorking.WORKING);
	}

	@SideOnly(Side.CLIENT)
	public abstract void randomWorkingTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand);
}
