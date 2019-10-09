package com.deextinction.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockDirectional;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasicFullyOriented extends BlockBasic
{
	public static final PropertyDirection FACING = BlockDirectional.FACING;

	public BlockBasicFullyOriented(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);

		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockBasicFullyOriented.FACING, EnumFacing.NORTH));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos, state.withProperty(BlockBasicFullyOriented.FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer)), 2);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		this.setDefaultFacing(worldIn, pos, state);
	}

	private void setDefaultFacing(World world, BlockPos pos, IBlockState state)
	{
		if (!world.isRemote)
		{
			IBlockState blockNorth = world.getBlockState(pos.north());
			IBlockState blockSouth = world.getBlockState(pos.south());
			IBlockState blockWest = world.getBlockState(pos.west());
			IBlockState blockEast = world.getBlockState(pos.east());
			IBlockState blockUp = world.getBlockState(pos.west());
			IBlockState blockDown = world.getBlockState(pos.east());
			EnumFacing facing = state.getValue(BlockBasicFullyOriented.FACING);

			if (facing == EnumFacing.NORTH && blockNorth.isFullBlock() && !blockSouth.isFullBlock())
				facing = EnumFacing.SOUTH;
			else if (facing == EnumFacing.SOUTH && blockSouth.isFullBlock() && !blockNorth.isFullBlock())
				facing = EnumFacing.NORTH;
			else if (facing == EnumFacing.WEST && blockWest.isFullBlock() && !blockEast.isFullBlock())
				facing = EnumFacing.EAST;
			else if (facing == EnumFacing.EAST && blockEast.isFullBlock() && !blockWest.isFullBlock())
				facing = EnumFacing.WEST;
			else if (facing == EnumFacing.UP && blockUp.isFullBlock() && !blockDown.isFullBlock())
				facing = EnumFacing.DOWN;
			else if (facing == EnumFacing.DOWN && blockDown.isFullBlock() && !blockUp.isFullBlock())
				facing = EnumFacing.UP;

			world.setBlockState(pos, state.withProperty(BlockBasicFullyOriented.FACING, facing), 2);
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(BlockBasicFullyOriented.FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, BlockBasicFullyOriented.getFacing(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BlockBasicFullyOriented.FACING).getIndex();
	}

	@Nullable
	public static EnumFacing getFacing(int meta)
	{
		int i = meta & 7;
		return i > 5 ? null : EnumFacing.getFront(i);
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockBasicFullyOriented.FACING);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return true;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return true;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(BlockBasicFullyOriented.FACING, rot.rotate(state.getValue(BlockBasicFullyOriented.FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(state.getValue(BlockBasicFullyOriented.FACING)));
	}
}
