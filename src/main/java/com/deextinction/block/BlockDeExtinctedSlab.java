package com.deextinction.block;

import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.ISubBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public abstract class BlockDeExtinctedSlab extends BlockSlab implements ISubBlock
{
	private final String treeName;

	public BlockDeExtinctedSlab(DeExtinctedTree tree, IBlockState baseState, CreativeTabs tab)
	{
		super(baseState.getBlock().getMaterial(baseState));
		this.treeName = tree.getName();
		if (tab != null)
			this.setCreativeTab(tab);

		Block baseBlock = baseState.getBlock();
		this.setHardness(baseBlock.getBlockHardness(baseState, null, null));
		this.setResistance((baseBlock.getExplosionResistance(null) * 5.0F) / 3.0F);
		this.setSoundType(baseBlock.getSoundType());

		IBlockState state = this.blockState.getBaseState();
		if (!this.isDouble())
			state = state.withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		this.setDefaultState(state);

		Blocks.FIRE.setFireInfo(this, 5, 20);
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
		return new ItemBlockSlab(this, (BlockSlab) DeBlocks.slabs_single.get(this.treeName), (BlockSlab) DeBlocks.slabs_double.get(this.treeName));
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		IBlockState state = this.getDefaultState();
		if (!this.isDouble())
			state = state.withProperty(BlockSlab.HALF, meta == 0 ? BlockSlab.EnumBlockHalf.BOTTOM : BlockSlab.EnumBlockHalf.TOP);

		return state;
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(BlockSlab.HALF) == BlockSlab.EnumBlockHalf.BOTTOM ? 0 : 1;
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, BlockSlab.HALF);
	}

	@Override
	public String getUnlocalizedName(int meta)
	{
		return super.getUnlocalizedName();
	}

	@Override
	public IProperty<?> getVariantProperty()
	{
		return null;
	}

	@Override
	public Comparable<?> getTypeForItem(ItemStack stack)
	{
		return null;
	}
}
