package com.deextinction.block;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeGuiHandler;
import com.deextinction.util.ITileName;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
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

public abstract class BlockContainerFullyOriented extends BlockContainer
{
	public static final PropertyDirection FACING = BlockDirectional.FACING;

	public BlockContainerFullyOriented(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(material);
		if (tab != null)
			this.setCreativeTab(tab);

		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(soundType);

		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockContainerFullyOriented.FACING, EnumFacing.NORTH));
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

		this.setDefaultFacingBy(worldIn, pos, state, placer);
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
			IBlockState blockUp = world.getBlockState(pos.up());
			IBlockState blockDown = world.getBlockState(pos.down());

			EnumFacing facing = state.getValue(BlockContainerFullyOriented.FACING);
			switch (facing)
			{
				case NORTH:
					if (blockNorth.isFullBlock())
					{
						if (!blockSouth.isFullBlock())
							facing = EnumFacing.SOUTH;
						else
						{

							// TODO CHECK THE CLOSEST BLOCK TO PLACE
							if (!blockEast.isFullBlock())
								facing = EnumFacing.EAST;
							else if (!blockSouth.isFullBlock())
								facing = EnumFacing.WEST;
							else if (!blockUp.isFullBlock())
								facing = EnumFacing.UP;
							else if (!blockDown.isFullBlock())
								facing = EnumFacing.DOWN;
						}
					}

					break;
				case SOUTH:
					if (blockSouth.isFullBlock())
					{
						if (!blockNorth.isFullBlock())
							facing = EnumFacing.NORTH;
						else
						{
							if (!blockEast.isFullBlock())
								facing = EnumFacing.EAST;
							else if (!blockSouth.isFullBlock())
								facing = EnumFacing.WEST;
							else if (!blockUp.isFullBlock())
								facing = EnumFacing.UP;
							else if (!blockDown.isFullBlock())
								facing = EnumFacing.DOWN;
						}
					}

					break;
				case EAST:
					if (blockEast.isFullBlock())
					{
						if (!blockWest.isFullBlock())
							facing = EnumFacing.WEST;
						else
						{
							if (!blockNorth.isFullBlock())
								facing = EnumFacing.NORTH;
							else if (!blockSouth.isFullBlock())
								facing = EnumFacing.SOUTH;
							else if (!blockUp.isFullBlock())
								facing = EnumFacing.UP;
							else if (!blockDown.isFullBlock())
								facing = EnumFacing.DOWN;
						}
					}

					break;
				case WEST:
					if (blockWest.isFullBlock())
					{
						if (!blockEast.isFullBlock())
							facing = EnumFacing.EAST;
						else
						{
							if (!blockNorth.isFullBlock())
								facing = EnumFacing.NORTH;
							else if (!blockSouth.isFullBlock())
								facing = EnumFacing.SOUTH;
							else if (!blockUp.isFullBlock())
								facing = EnumFacing.UP;
							else if (!blockDown.isFullBlock())
								facing = EnumFacing.DOWN;
						}
					}

					break;
				case DOWN:
					if (blockDown.isFullBlock())
					{
						if (!blockUp.isFullBlock())
							facing = EnumFacing.UP;
						else
						{
							if (!blockNorth.isFullBlock())
								facing = EnumFacing.NORTH;
							else if (!blockEast.isFullBlock())
								facing = EnumFacing.EAST;
							else if (!blockSouth.isFullBlock())
								facing = EnumFacing.SOUTH;
							else if (!blockWest.isFullBlock())
								facing = EnumFacing.WEST;
						}
					}
					break;
				case UP:
					if (blockUp.isFullBlock())
					{
						if (!blockDown.isFullBlock())
							facing = EnumFacing.DOWN;
						else
						{
							if (!blockNorth.isFullBlock())
								facing = EnumFacing.NORTH;
							else if (!blockEast.isFullBlock())
								facing = EnumFacing.EAST;
							else if (!blockSouth.isFullBlock())
								facing = EnumFacing.SOUTH;
							else if (!blockWest.isFullBlock())
								facing = EnumFacing.WEST;
						}
					}
			}

			world.setBlockState(pos, state.withProperty(BlockContainerFullyOriented.FACING, facing), 2);
		}
	}

	private void setDefaultFacingBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer)
	{
		if (!world.isRemote)
		{
			IBlockState blockNorth = world.getBlockState(pos.north());
			IBlockState blockSouth = world.getBlockState(pos.south());
			IBlockState blockWest = world.getBlockState(pos.west());
			IBlockState blockEast = world.getBlockState(pos.east());
			IBlockState blockUp = world.getBlockState(pos.up());
			IBlockState blockDown = world.getBlockState(pos.down());
			boolean correctedState = false;

			EnumFacing facing = state.getValue(BlockContainerFullyOriented.FACING);
			switch (facing)
			{
				case NORTH:
					if (blockNorth.isFullBlock() && !blockSouth.isFullBlock())
					{
						facing = EnumFacing.SOUTH;
						correctedState = true;
					}
					break;
				case SOUTH:
					if (blockSouth.isFullBlock() && !blockNorth.isFullBlock())
					{
						facing = EnumFacing.NORTH;
						correctedState = true;
					}
					break;
				case EAST:
					if (blockEast.isFullBlock() && !blockWest.isFullBlock())
					{
						facing = EnumFacing.WEST;
						correctedState = true;
					}
					break;
				case WEST:
					if (blockWest.isFullBlock() && !blockEast.isFullBlock())
					{
						facing = EnumFacing.EAST;
						correctedState = true;
					}
					break;
				case DOWN:
					if (blockDown.isFullBlock() && !blockUp.isFullBlock())
					{
						facing = EnumFacing.UP;
						correctedState = true;
					}
					break;
				case UP:
					if (blockUp.isFullBlock() && !blockDown.isFullBlock())
					{
						facing = EnumFacing.DOWN;
						correctedState = true;
					}
			}

			if (!correctedState)
			{
				List<EnumFacing> possiblePlaces = new ArrayList<EnumFacing>();
				if (!blockNorth.isFullBlock())
					possiblePlaces.add(EnumFacing.NORTH);
				if (!blockEast.isFullBlock())
					possiblePlaces.add(EnumFacing.EAST);
				if (!blockSouth.isFullBlock())
					possiblePlaces.add(EnumFacing.SOUTH);
				if (!blockWest.isFullBlock())
					possiblePlaces.add(EnumFacing.WEST);
				if (!blockUp.isFullBlock())
					possiblePlaces.add(EnumFacing.UP);
				if (!blockDown.isFullBlock())
					possiblePlaces.add(EnumFacing.DOWN);

				double minDistance = Double.MAX_VALUE;
				for (EnumFacing possiblePlace : possiblePlaces)
				{
					if (placer.getDistanceSq(pos.offset(possiblePlace)) < minDistance)
						facing = possiblePlace;
				}
			}

			world.setBlockState(pos, state.withProperty(BlockContainerFullyOriented.FACING, facing), 2);
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(BlockContainerFullyOriented.FACING, EnumFacing.getDirectionFromEntityLiving(pos, placer));
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(FACING, BlockContainerFullyOriented.getFacing(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BlockContainerFullyOriented.FACING).getIndex();
	}

	@Override
	public IBlockState withRotation(IBlockState state, Rotation rot)
	{
		return state.withProperty(BlockContainerFullyOriented.FACING, rot.rotate(state.getValue(BlockContainerFullyOriented.FACING)));
	}

	@Override
	public IBlockState withMirror(IBlockState state, Mirror mirrorIn)
	{
		return state.withRotation(mirrorIn.toRotation(state.getValue(BlockContainerFullyOriented.FACING)));
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
		return new BlockStateContainer(this, BlockContainerFullyOriented.FACING);
	}

	@Override
	public abstract TileEntity createNewTileEntity(World worldIn, int meta);
}
