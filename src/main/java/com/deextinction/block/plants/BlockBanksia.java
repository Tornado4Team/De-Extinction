package com.deextinction.block.plants;

import com.deextinction.block.BlockDeExtinctedBush;
import com.deextinction.util.ISubBlock;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBanksia extends BlockDeExtinctedBush implements ISubBlock
{
	public static final PropertyEnum<BlockBanksia.EnumTypes> FLOWER_TYPE = PropertyEnum.create("type", BlockBanksia.EnumTypes.class);
	public static final AxisAlignedBB BANKSIA_AABB = new AxisAlignedBB(0.1D, 0.0D, 0.1D, 0.9D, 0.3D, 0.9D);

	public BlockBanksia(CreativeTabs tab)
	{
		super(tab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(this.getTypeProperty(), BlockBanksia.EnumTypes.YELLOW));
	}

	@Override
	public ItemBlock getItemBlock()
	{
		return new ItemBlockBanksia(this);
	}

	public IProperty<BlockBanksia.EnumTypes> getTypeProperty()
	{
		return BlockBanksia.FLOWER_TYPE;
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		BlockBanksia.EnumTypes[] flowertypes = BlockBanksia.EnumTypes.values();
		for (BlockBanksia.EnumTypes flowertype : flowertypes)
			items.add(new ItemStack(this, 1, flowertype.getMetadata()));
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BlockBanksia.BANKSIA_AABB.offset(state.getOffset(source, pos));
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockBanksia.EnumTypes) state.getValue(this.getTypeProperty())).getMetadata();
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(this.getTypeProperty(), BlockBanksia.EnumTypes.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockBanksia.EnumTypes) state.getValue(this.getTypeProperty())).getMetadata();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { this.getTypeProperty() });
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(this.getTypeProperty(), BlockBanksia.EnumTypes.byMetadata(meta));
	}

	@Override
	public Block.EnumOffsetType getOffsetType()
	{
		return Block.EnumOffsetType.XZ;
	}

	public static enum EnumTypes implements IStringSerializable
	{
		YELLOW(0, "yellow"),
		ORANGE(1, "orange"),
		RED(2, "red");

		private EnumTypes(int metadata, String unlocalizedName)
		{
			this.metadata = metadata;
			this.unlocalizedName = unlocalizedName;
		}

		public int getMetadata()
		{
			return this.metadata;
		}

		@Override
		public String getName()
		{
			return this.unlocalizedName;
		}

		@Override
		public String toString()
		{
			return this.unlocalizedName;
		}

		public static BlockBanksia.EnumTypes byMetadata(int meta)
		{
			if (meta < 0 || meta >= BlockBanksia.EnumTypes.META_LOOKUP.length)
				meta = 0;

			return BlockBanksia.EnumTypes.META_LOOKUP[meta];
		}

		private final int metadata;
		private final String unlocalizedName;
		private static final BlockBanksia.EnumTypes[] META_LOOKUP = new BlockBanksia.EnumTypes[values().length];
		static
		{
			for (EnumTypes colour : values())
				BlockBanksia.EnumTypes.META_LOOKUP[colour.getMetadata()] = colour;
		}
	}
}
