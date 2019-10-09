package com.deextinction.block.plants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDeExtinctedLeaves extends BlockLeaves
{
	private final String treeName;

	public BlockDeExtinctedLeaves(DeExtinctedTree tree, CreativeTabs tab)
	{
		this.treeName = tree.getName();
		if (tab != null)
			this.setCreativeTab(tab);

		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockLeaves.DECAYABLE, Boolean.valueOf(true)).withProperty(BlockLeaves.CHECK_DECAY, Boolean.valueOf(false)));

		Blocks.FIRE.setFireInfo(this, 30, 60);
	}

	public String getTreeName()
	{
		return this.treeName;
	}

	public DeExtinctedPlant getTree()
	{
		return (DeExtinctedPlant) DeDatabase.LIST_DE_EXTINCTED.get(this.treeName);
	}

	@Override
	protected void dropApple(World world, BlockPos pos, IBlockState state, int chance)
	{
		DeExtinctedTree tree = (DeExtinctedTree) DeDatabase.LIST_DE_EXTINCTED.get(this.treeName);
		ItemStack drop = tree.getSpecialDropFromLeaves(chance);
		if (drop != null && drop != ItemStack.EMPTY)
			Block.spawnAsEntity(world, pos, drop);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(DeBlocks.leaves.get(this.treeName));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
	{
		list.add(new ItemStack(this, 1, 0));
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(BlockLeaves.DECAYABLE, meta < 4).withProperty(BlockLeaves.CHECK_DECAY, meta < 8);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		int i = 0;

		if (!state.getValue(BlockLeaves.DECAYABLE))
			i = 4;

		if (!state.getValue(BlockLeaves.CHECK_DECAY))
			i = 8;

		return i;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockLeaves.CHECK_DECAY, BlockLeaves.DECAYABLE);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return Blocks.LEAVES.isOpaqueCube(state);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return Blocks.LEAVES.getBlockLayer();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing side)
	{
		return Blocks.LEAVES.shouldSideBeRendered(state, world, pos, side);
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune)
	{
		List<ItemStack> list = new ArrayList<ItemStack>();
		list.add(new ItemStack(this));
		return list;
	}

	@Override
	public BlockPlanks.EnumType getWoodType(int meta)
	{
		return BlockPlanks.EnumType.SPRUCE;
	}
}
