package com.deextinction.block;

import java.util.Random;

import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeBlocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDeExtinctedSlabDouble extends BlockDeExtinctedSlab
{
	public BlockDeExtinctedSlabDouble(DeExtinctedTree tree, IBlockState baseState, CreativeTabs tab)
	{
		super(tree, baseState, tab);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(DeBlocks.slabs_single.get(this.getTreeName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return new ItemStack(Item.getItemFromBlock(DeBlocks.slabs_single.get(this.getTreeName())));
	}

	@Override
	public boolean isDouble()
	{
		return true;
	}
}
