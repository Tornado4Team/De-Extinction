package com.deextinction.block.plants;

import java.util.Random;

import com.deextinction.database.DeExtinctedTree;
import com.deextinction.init.DeDatabase;

import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockDeExtinctedSapling extends BlockBush implements IGrowable
{
	private final String treeName;
	private final String variant;

	public BlockDeExtinctedSapling(DeExtinctedTree tree, String variant, CreativeTabs tab)
	{
		this.treeName = tree.getName();
		this.variant = variant;
		if (tab != null)
			this.setCreativeTab(tab);

		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getStageProperty(), Integer.valueOf(0)));
		this.setSoundType(SoundType.PLANT);
	}

	public String getTreeName()
	{
		return this.treeName;
	}

	public DeExtinctedTree getTree()
	{
		return (DeExtinctedTree) DeDatabase.LIST_DE_EXTINCTED.get(this.treeName);
	}

	public String getVariant()
	{
		return this.variant;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess blockAccess, BlockPos pos)
	{
		return this.getStageAABB(state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (!worldIn.isRemote)
		{
			super.updateTick(worldIn, pos, state, rand);

			if (!worldIn.isAreaLoaded(pos, 1))
				return;

			if (worldIn.getLightFromNeighbors(pos.up()) >= 9 && rand.nextInt(7) == 0)
				this.grow(worldIn, pos, state, rand);
		}
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return 0;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> list)
	{
		list.add(new ItemStack(this, 1, 0));
	}

	@Override
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		return worldIn.rand.nextFloat() < 0.45D;
	}

	@Override
	public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
	{
		return true;
	}

	@Override
	public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state)
	{
		this.grow(worldIn, pos, state, rand);
	}

	public void grow(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		if (state.getValue(this.getStageProperty()) < this.numberOfStages())
			worldIn.setBlockState(pos, state.cycleProperty(this.getStageProperty()), 4);
		else
			this.getTree().getTreeGenerator(this.variant).generate(worldIn, worldIn.rand, pos);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(this.getStageProperty(), meta);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return (int) state.getValue(this.getStageProperty());
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, this.getStageProperty());
	}

	protected abstract PropertyInteger getStageProperty();

	protected abstract AxisAlignedBB getStageAABB(IBlockState state);

	protected abstract Integer numberOfStages();
}
