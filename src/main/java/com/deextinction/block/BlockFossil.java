package com.deextinction.block;

import java.util.Random;

import com.deextinction.database.DeExtincted;
import com.deextinction.database.GeologicEra;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;
import com.deextinction.init.DeFossil;
import com.deextinction.item.ItemRockPick;
import com.deextinction.tileentities.TileFossilBroken;
import com.deextinction.util.ISubBlock;

import net.minecraft.block.BlockSandStone;
import net.minecraft.block.BlockStone;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFossil extends BlockBasic implements ISubBlock
{
	public static final PropertyEnum<BlockFossil.BaseBlockType> BASE_BLOCK_TYPE = PropertyEnum.create("base_block", BlockFossil.BaseBlockType.class);
	public static final String NBT_TAG_FOSSIL_NAME = "FOSSIL_INFO";
	private final FossilType fossilType;

	public BlockFossil(FossilType fossilType, float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);
		this.fossilType = fossilType;
		this.setHarvestLevel("pickaxe", 2);
		this.setDefaultState(this.blockState.getBaseState().withProperty(BlockFossil.BASE_BLOCK_TYPE, BlockFossil.BaseBlockType.STONE));
	}

	@Override
	public ItemBlock getItemBlock()
	{
		return new ItemBlockFossil(this);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
	{
		BlockFossil.BaseBlockType[] stonetypes = BlockFossil.BaseBlockType.values();
		for (BlockFossil.BaseBlockType stonetype : stonetypes)
			items.add(new ItemStack(this, 1, stonetype.getMetadata()));
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	{
		if (player != null && !player.capabilities.isCreativeMode)
		{
			ItemStack heldItem = player.getHeldItem(EnumHand.MAIN_HAND);
			if (heldItem.getItem() instanceof ItemRockPick)
			{
				GeologicEra era = DeFossil.getGeologicEraFromNoise(pos.getX(), pos.getY(), pos.getZ());
				if (era != null)
				{
					DeExtincted deExtincted = null;
					switch (this.fossilType)
					{
						case ANIMAL:
							deExtincted = DeFossil.getAnimalFromNoise(era, pos.getX(), pos.getY(), pos.getZ());
							break;
						case PLANT:
							deExtincted = DeFossil.getPlantFromNoise(era, pos.getX(), pos.getY(), pos.getZ());
							break;
					}

					if (deExtincted != null && DeDatabase.LIST_DE_EXTINCTED.containsKey(deExtincted.getName()))
					{
						world.setBlockState(pos, BlockFossil.BaseBlockType.byMetadata(this.getMetaFromState(state)).getBrokenBlockState().withProperty(BlockFossilBroken.FACING, EnumFacing.getDirectionFromEntityLiving(pos, player)));
						TileEntity tileEntity = world.getTileEntity(pos);
						if (tileEntity instanceof TileFossilBroken)
						{
							TileFossilBroken tileFossilBroken = (TileFossilBroken) tileEntity;
							tileFossilBroken.setFossil(deExtincted);
							return true;
						}
					}
				}
			}
		}

		return world.setBlockState(pos, Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
	}

	@Override
	public boolean canHarvestBlock(IBlockAccess world, BlockPos pos, EntityPlayer player)
	{
		return false;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 0;
	}

	@Override
	public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		return false;
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosion)
	{
		return false;
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockFossil.BaseBlockType) state.getValue(BlockFossil.BASE_BLOCK_TYPE)).getMetadata();
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(BlockFossil.BASE_BLOCK_TYPE, BlockFossil.BaseBlockType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockFossil.BaseBlockType) state.getValue(BlockFossil.BASE_BLOCK_TYPE)).getMetadata();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(BlockFossil.BASE_BLOCK_TYPE, BlockFossil.BaseBlockType.byMetadata(meta));
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { BlockFossil.BASE_BLOCK_TYPE });
	}

	public static enum BaseBlockType implements IStringSerializable
	{
		STONE(0, BlockStone.EnumType.STONE, DeBlocks.fossil_block_broken_stone),
		GRANITE(1, BlockStone.EnumType.GRANITE, DeBlocks.fossil_block_broken_granite),
		DIORITE(2, BlockStone.EnumType.DIORITE, DeBlocks.fossil_block_broken_diorite),
		ANDESITE(3, BlockStone.EnumType.ANDESITE, DeBlocks.fossil_block_broken_andesite),
		SANDSTONE(4, BlockSandStone.EnumType.DEFAULT, DeBlocks.fossil_block_broken_sandstone);

		private BaseBlockType(int metadata, Enum baseBlock, BlockFossilBroken brokenBlock)
		{
			this.metadata = metadata;
			this.baseBlock = baseBlock;
			this.brokenBlockState = brokenBlock.getDefaultState();
			;
		}

		public int getMetadata()
		{
			return this.metadata;
		}

		public Enum getBaseBlock()
		{
			return this.baseBlock;
		}

		public IBlockState getBrokenBlockState()
		{
			return this.brokenBlockState;
		}

		@Override
		public String getName()
		{
			return this.baseBlock.toString();
		}

		@Override
		public String toString()
		{
			return this.getName();
		}

		public static BlockFossil.BaseBlockType byMetadata(int meta)
		{
			if (meta < 0 || meta >= BlockFossil.BaseBlockType.META_LOOKUP.length)
				meta = 0;

			return BlockFossil.BaseBlockType.META_LOOKUP[meta];
		}

		private final int metadata;
		private final Enum baseBlock;
		private final IBlockState brokenBlockState;
		private static final BlockFossil.BaseBlockType[] META_LOOKUP = new BlockFossil.BaseBlockType[values().length];
		static
		{
			for (BlockFossil.BaseBlockType block : BlockFossil.BaseBlockType.values())
				BlockFossil.BaseBlockType.META_LOOKUP[block.getMetadata()] = block;
		}
	}

	public static enum FossilType
	{
		ANIMAL,
		PLANT;
	}
}
