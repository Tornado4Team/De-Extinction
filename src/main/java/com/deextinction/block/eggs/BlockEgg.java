package com.deextinction.block.eggs;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.IEgg;
import com.deextinction.init.DeDatabase;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.tileentities.TileEgg;
import com.deextinction.util.DNA;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockEgg extends BlockContainer
{
	private final AxisAlignedBB egg_aabb;
	private final String deExtinctedName;
	private final int maxHatchingProgress;

	public BlockEgg(DeExtincted deExtincted, float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(material);
		if (tab != null)
			this.setCreativeTab(tab);

		this.setHardness(hardness);
		this.setResistance(resistance);
		this.setSoundType(soundType);

		IEgg iEgg = (IEgg) deExtincted;
		this.egg_aabb = iEgg.getEggAABB();
		this.deExtinctedName = deExtincted.getName();
		this.maxHatchingProgress = iEgg.getMaxHatchingProgress();
	}

	public String getDeExtinctedName()
	{
		return this.deExtinctedName;
	}

	public static boolean isBlockEgg(ItemStack itemStack)
	{
		return Block.getBlockFromItem(itemStack.getItem()) instanceof BlockEgg;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound compound = stack.getTagCompound();
			if (compound != null)
			{
				if (!compound.hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
					stack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Block.RANDOM));
				tooltip.add(I18n.translateToLocal("item.item_floppy_disk.dna") + ": " + compound.getString(ItemFloppyDisk.NBT_TAG_DNA_STRING));
			}
		}
		else
			tooltip.add(I18n.translateToLocal("tile.block_egg.creative"));
	}

	@Override
	public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	{
		IBlockState downState = worldIn.getBlockState(pos.down());
		return worldIn.getBlockState(pos).getBlock().isReplaceable(worldIn, pos) && (downState.isTopSolid() || downState.getBlockFaceShape(worldIn, pos.down(), EnumFacing.UP) == BlockFaceShape.SOLID);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		this.checkAndDestroyEggBlock(worldIn, pos, state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		this.checkAndDestroyEggBlock(worldIn, pos, state);
	}

	protected void checkAndDestroyEggBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!this.canPlaceBlockAt(worldIn, pos))
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof TileEgg)
			{
				TileEgg tileEgg = ((TileEgg) tileEntity);
				int numberOfEggs = tileEgg.getNumberOfEgg();
				for (int i = 0; i < numberOfEggs; i++)
					this.removeEggFromBlockEgg(worldIn, pos, tileEgg);
			}
		}
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		if (DeDatabase.LIST_DE_EXTINCTED.containsKey(this.getDeExtinctedName()))
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof TileEgg)
			{
				TileEgg tileEgg = ((TileEgg) tileEntity);
				ItemStack eggStack = stack.copy();
				eggStack.setCount(1);

				if (placer instanceof EntityPlayer)
				{
					EntityPlayer player = (EntityPlayer) placer;
					if (player.capabilities.isCreativeMode)
					{
						if (eggStack.hasTagCompound())
						{
							if (!eggStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
								eggStack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Block.RANDOM));
						}
						else
						{
							NBTTagCompound compound = new NBTTagCompound();
							compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Block.RANDOM));
							eggStack.setTagCompound(compound);
						}
					}
					else
					{
						if (eggStack.hasTagCompound())
						{
							if (!eggStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
								eggStack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
						}
						else
						{
							NBTTagCompound compound = new NBTTagCompound();
							compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
							eggStack.setTagCompound(compound);
						}
					}
				}
				else
				{
					if (eggStack.hasTagCompound())
					{
						if (!eggStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
							eggStack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
					}
					else
					{
						NBTTagCompound compound = new NBTTagCompound();
						compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
						eggStack.setTagCompound(compound);
					}
				}

				tileEgg.setAnimalName(this.getDeExtinctedName());
				tileEgg.setHatchingProgressMax(this.maxHatchingProgress);
				tileEgg.addEgg(eggStack);

				worldIn.setBlockState(pos, state.withProperty(this.getEggProperty(), 1), 2);
			}
		}
		else
			DeExtinction.logger.error("ItemEgg is trying to spawn a block egg from an animal that is not in the database! THIS IS A BUG!");

		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
			return true;
		else
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if (tileEntity instanceof TileEgg)
			{
				ItemStack heldItemStack = playerIn.getHeldItemMainhand();
				if (BlockEgg.isBlockEgg(heldItemStack))
					this.addEggToBlockEgg(playerIn, ((TileEgg) tileEntity), heldItemStack);
				else if (heldItemStack == ItemStack.EMPTY)
					this.removeEggFromBlockEgg(worldIn, pos);
			}
			return true;
		}
	}

	public void addEggToBlockEgg(EntityPlayer player, TileEgg tileEgg, ItemStack heldItemStack)
	{
		if (BlockEgg.isBlockEgg(heldItemStack))
		{
			String animalName = ((BlockEgg) Block.getBlockFromItem(heldItemStack.getItem())).getDeExtinctedName();
			if (DeDatabase.LIST_DE_EXTINCTED.containsKey(animalName))
			{
				if (tileEgg.getAnimalName() == animalName)
				{
					ItemStack eggStack = heldItemStack.copy();
					if (tileEgg.canAddEgg(eggStack))
					{
						eggStack.setCount(1);

						if (player.capabilities.isCreativeMode)
						{
							if (eggStack.hasTagCompound())
							{
								if (!eggStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
									eggStack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Block.RANDOM));
							}
							else
							{
								NBTTagCompound compound = new NBTTagCompound();
								compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Block.RANDOM));
								eggStack.setTagCompound(compound);
							}
						}
						else
						{
							if (eggStack.hasTagCompound())
							{
								if (!eggStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
									eggStack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
							}
							else
							{
								NBTTagCompound compound = new NBTTagCompound();
								compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
								eggStack.setTagCompound(compound);
							}
						}

						tileEgg.addEgg(eggStack);
						if (!player.capabilities.isCreativeMode)
							heldItemStack.shrink(1);
					}
				}
			}
			else
				DeExtinction.logger.error("BlockItemEgg is trying to add an egg from an animal that is not in the database! THIS IS A BUG!");
		}
	}

	public void removeEggFromBlockEgg(World worldIn, BlockPos pos)
	{
		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof TileEgg)
		{
			TileEgg tileEgg = ((TileEgg) tileEntity);
			if (tileEgg.canRemoveEgg())
				Block.spawnAsEntity(worldIn, pos, tileEgg.removeEgg());
		}
	}

	public void removeEggFromBlockEgg(World worldIn, BlockPos pos, TileEgg tileEgg)
	{
		if (tileEgg.canRemoveEgg())
			Block.spawnAsEntity(worldIn, pos, tileEgg.removeEgg());
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return null;
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	{
		if (willHarvest)
			return true;
		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity tileEntity, ItemStack stack)
	{
		super.harvestBlock(world, player, pos, state, tileEntity, stack);
		world.setBlockToAir(pos);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> drops = super.getDrops(worldIn, pos, state, fortune);

		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof TileEgg)
		{
			TileEgg tileEgg = (TileEgg) tileEntity;
			if (tileEgg.hasEggs())
				drops.addAll(tileEgg.getEggs());
		}
		return drops;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return this.egg_aabb;
	}

	public void setState(int numberOfEggs, World worldIn, BlockPos pos)
	{
		IBlockState iblockstate = worldIn.getBlockState(pos);
		worldIn.setBlockState(pos, iblockstate.withProperty(this.getEggProperty(), numberOfEggs), 3);
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
			TileEntity tileEntity = world.getTileEntity(pos);
			if (tileEntity instanceof TileEgg)
			{
				TileEgg tileEgg = (TileEgg) tileEntity;
				world.setBlockState(pos, state.withProperty(this.getEggProperty(), 1), 2);
			}
		}
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return this.getDefaultState().withProperty(this.getEggProperty(), 1);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(this.getEggProperty(), meta);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return (int) state.getValue(this.getEggProperty());
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, this.getEggProperty());
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return ItemStack.EMPTY;
	}

	public abstract IProperty getEggProperty();

	public static enum EnumNumber implements IStringSerializable
	{
		ONE(1, "one_egg"),
		TWO(2, "two_eggs"),
		THREE(3, "three_eggs"),
		FOUR(4, "four_eggs"),
		FIVE(5, "five_eggs");

		private EnumNumber(int number, String unlocalizedName)
		{
			this.number = number;
			this.unlocalizedName = unlocalizedName;
		}

		public int getNumber()
		{
			return this.number;
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

		private final int number;
		private final String unlocalizedName;
	}
}
