package com.deextinction.block;

import java.util.Random;

import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.ISubBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDeExtinctedDoor extends BlockDoor implements ISubBlock
{
	private final String treeName;

	public BlockDeExtinctedDoor(DeExtinctedTree tree, IBlockState baseState, CreativeTabs tab)
	{
		super(baseState.getBlock().getMaterial(baseState));
		this.treeName = tree.getName();
		if (tab != null)
			this.setCreativeTab(tab);

		Block baseBlock = baseState.getBlock();
		this.setHardness(baseBlock.getBlockHardness(baseState, null, null));
		this.setResistance((baseBlock.getExplosionResistance(null) * 5.0F) / 3.0F);
		this.setSoundType(baseBlock.getSoundType());
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
	public ItemBlock getItemBlock()
	{
		return new ItemBlockDoor(this);
	}

	private Item getDoorItem()
	{
		return Item.getItemFromBlock(DeBlocks.doors.get(this.treeName));
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return state.getValue(BlockDoor.HALF) == BlockDoor.EnumDoorHalf.UPPER ? Items.AIR : this.getDoorItem();
	}

	@Override
	public ItemStack getItem(World world, BlockPos pos, IBlockState state)
	{
		return new ItemStack(this.getDoorItem());
	}
}
