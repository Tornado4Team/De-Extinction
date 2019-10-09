package com.deextinction.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockSlab extends ItemBlock
{
	private final BlockSlab singleSlab;
	private final BlockSlab doubleSlab;

	public ItemBlockSlab(Block block, BlockSlab singleSlab, BlockSlab doubleSlab)
	{
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

		this.singleSlab = singleSlab;
		this.doubleSlab = doubleSlab;
	}

	@Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
		return this.singleSlab.getUnlocalizedName(stack.getMetadata());
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		ItemStack itemstack = player.getHeldItem(hand);

		if (!itemstack.isEmpty() && player.canPlayerEdit(pos.offset(facing), facing, itemstack))
		{
			IBlockState singleSlabState = worldIn.getBlockState(pos);

			if (singleSlabState.getBlock() == this.singleSlab)
			{
				BlockSlab.EnumBlockHalf enumHalf = (BlockSlab.EnumBlockHalf) singleSlabState.getValue(BlockSlab.HALF);

				if (facing == EnumFacing.UP && enumHalf == BlockSlab.EnumBlockHalf.BOTTOM || facing == EnumFacing.DOWN && enumHalf == BlockSlab.EnumBlockHalf.TOP)
				{
					IBlockState doubleSlabState = this.doubleSlab.getDefaultState();
					AxisAlignedBB collisionBoundingBox = doubleSlabState.getCollisionBoundingBox(worldIn, pos);

					if (collisionBoundingBox != Block.NULL_AABB && worldIn.checkNoEntityCollision(collisionBoundingBox.offset(pos)) && worldIn.setBlockState(pos, doubleSlabState, 11))
					{
						SoundType soundtype = this.doubleSlab.getSoundType(doubleSlabState, worldIn, pos, player);
						worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
						itemstack.shrink(1);
					}

					return EnumActionResult.SUCCESS;
				}
			}

			return this.tryPlace(player, itemstack, worldIn, pos.offset(facing)) ? EnumActionResult.SUCCESS : super.onItemUse(player, worldIn, pos, hand, facing, hitX, hitY, hitZ);
		}
		else
			return EnumActionResult.FAIL;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
	{
		BlockPos blockpos = pos;
		IBlockState singleSlabState = worldIn.getBlockState(pos);

		if (singleSlabState.getBlock() == this.singleSlab)
		{
			boolean flag = singleSlabState.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.TOP;
			if (side == EnumFacing.UP && !flag || side == EnumFacing.DOWN && flag)
				return true;
		}

		pos = pos.offset(side);
		IBlockState iblockstateSide = worldIn.getBlockState(pos);
		return iblockstateSide.getBlock() == this.singleSlab || super.canPlaceBlockOnSide(worldIn, blockpos, side, player, stack);
	}

	private boolean tryPlace(EntityPlayer player, ItemStack stack, World worldIn, BlockPos pos)
	{
		IBlockState singleSlabState = worldIn.getBlockState(pos);

		if (singleSlabState.getBlock() == this.singleSlab)
		{
			AxisAlignedBB collisionBoundingBox = singleSlabState.getCollisionBoundingBox(worldIn, pos);

			if (collisionBoundingBox != Block.NULL_AABB && worldIn.checkNoEntityCollision(collisionBoundingBox.offset(pos)) && worldIn.setBlockState(pos, singleSlabState, 11))
			{
				SoundType soundtype = this.doubleSlab.getSoundType(singleSlabState, worldIn, pos, player);
				worldIn.playSound(player, pos, soundtype.getPlaceSound(), SoundCategory.BLOCKS, (soundtype.getVolume() + 1.0F) / 2.0F, soundtype.getPitch() * 0.8F);
				stack.shrink(1);
			}

			return true;
		}

		return false;
	}
}
