package com.deextinction.block;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeGuiHandler;
import com.deextinction.util.ITileName;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class BlockContainerHorizontal extends BlockContainer
{
	public static final PropertyDirection FACING = BlockHorizontal.FACING;

	public BlockContainerHorizontal(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(material);
		if (tab != null)
			this.setCreativeTab(tab);

		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(soundType);

		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockContainerHorizontal.FACING, EnumFacing.NORTH));
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof ITileName)
		{
			ITileName iTileName = ((ITileName) tileentity);
			if (stack.hasTagCompound())
			{
				NBTTagCompound compound = stack.getTagCompound();
				if (compound.hasKey("CustomName"))
					iTileName.setCustomInventoryName(compound.getString("CustomName"));
				else if (stack.hasDisplayName())
					iTileName.setCustomInventoryName(stack.getDisplayName());
			}
		}

		worldIn.setBlockState(pos, state.withProperty(BlockContainerHorizontal.FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;

		playerIn.openGui(DeExtinction.instance, DeGuiHandler.ID_BLOCK, worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof IInventory)
			InventoryHelper.dropInventoryItems(worldIn, pos, (IInventory) tileEntity);

		super.breakBlock(worldIn, pos, state);
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
			EnumFacing facing = state.getValue(BlockContainerHorizontal.FACING);

			if (facing == EnumFacing.NORTH && blockNorth.isFullBlock() && !blockSouth.isFullBlock())
				facing = EnumFacing.SOUTH;
			else if (facing == EnumFacing.SOUTH && blockSouth.isFullBlock() && !blockNorth.isFullBlock())
				facing = EnumFacing.NORTH;
			else if (facing == EnumFacing.WEST && blockWest.isFullBlock() && !blockEast.isFullBlock())
				facing = EnumFacing.EAST;
			else if (facing == EnumFacing.EAST && blockEast.isFullBlock() && !blockWest.isFullBlock())
				facing = EnumFacing.WEST;

			world.setBlockState(pos, state.withProperty(BlockContainerHorizontal.FACING, facing), 2);
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(BlockContainerHorizontal.FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing facing = EnumFacing.getFront(meta);

		if (facing.getAxis() == EnumFacing.Axis.Y)
			facing = EnumFacing.NORTH;

		return this.getDefaultState().withProperty(BlockContainerHorizontal.FACING, facing);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BlockContainerHorizontal.FACING).getIndex();
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(BlockContainerHorizontal.FACING, rot.rotate(state.getValue(BlockContainerHorizontal.FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(state.getValue(BlockContainerHorizontal.FACING)));
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockContainerHorizontal.FACING);
	}

	@Override
	public abstract TileEntity createNewTileEntity(World worldIn, int meta);
}
