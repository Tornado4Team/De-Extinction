package com.deextinction.block;

import javax.annotation.Nullable;

import com.deextinction.item.ItemRockPick;
import com.deextinction.tileentities.TileFossilBroken;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFossilBroken extends BlockContainerFullyOriented
{
	protected static final AxisAlignedBB BLOCK_NORTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.375D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB BLOCK_SOUTH_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 1.0D, 0.625D);
	protected static final AxisAlignedBB BLOCK_WEST_AABB = new AxisAlignedBB(0.375D, 0.0D, 0.0D, 1.0D, 1.0D, 1.0D);
	protected static final AxisAlignedBB BLOCK_EAST_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 0.625D, 1.0D, 1.0D);
	protected static final AxisAlignedBB BLOCK_UP_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.625D, 1.0D);
	protected static final AxisAlignedBB BLOCK_DOWN_AABB = new AxisAlignedBB(0.0D, 0.375D, 0.0D, 1.0D, 1.0D, 1.0D);

	public BlockFossilBroken(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	{
		if (willHarvest)
			return true;

		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack tool)
	{
		super.harvestBlock(world, player, pos, state, te, tool);
		world.setBlockToAir(pos);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		super.onBlockHarvested(worldIn, pos, state, player);

		if (player.capabilities.isCreativeMode)
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);

			if (tileEntity instanceof TileFossilBroken)
				((TileFossilBroken) tileEntity).setFossil(null);
		}
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		EntityPlayer player = harvesters.get();
		if (player != null)
		{
			ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
			if (heldItem.getItem() instanceof ItemRockPick)
			{
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity instanceof TileFossilBroken)
				{
					TileFossilBroken tileFossilBroken = (TileFossilBroken) tileEntity;
					if (tileFossilBroken.hasFossilStack())
						drops.add(tileFossilBroken.getFossilStack());
				}
			}
		}
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		switch ((EnumFacing) state.getValue(BlockFossilBroken.FACING))
		{
			case EAST:
			default:
				return BlockFossilBroken.BLOCK_EAST_AABB;
			case WEST:
				return BlockFossilBroken.BLOCK_WEST_AABB;
			case SOUTH:
				return BlockFossilBroken.BLOCK_SOUTH_AABB;
			case NORTH:
				return BlockFossilBroken.BLOCK_NORTH_AABB;
			case UP:
				return BlockFossilBroken.BLOCK_UP_AABB;
			case DOWN:
				return BlockFossilBroken.BLOCK_DOWN_AABB;
		}
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileFossilBroken();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullBlock(IBlockState state)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
}
