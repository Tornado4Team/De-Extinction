package com.deextinction.tileentities;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockContainerHorizontalWorking;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeItems;
import com.deextinction.item.ItemBrush;
import com.deextinction.item.ItemFossilClean;
import com.deextinction.item.ItemFossilDirty;
import com.deextinction.tileentities.containers.ContainerCleaningTable;
import com.deextinction.util.ITileWorking;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class TileCleaningTable extends TileMachineRefresh implements ITileWorking
{
	public static final int SLOT_INDEX_BRUSH = 0;
	public static final int SLOT_INDEX_FOSSIL_DIRTY = 1;

	private static final int CLEANING_PROGRESS_MAX = 120;
	private static final float FOSSIL_CHANCE = 0.5F;

	private int cleaningProgress = 0;

	public TileCleaningTable()
	{
		super(new int[] { TileCleaningTable.SLOT_INDEX_BRUSH }, new int[] { TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY }, new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 });
	}

	@Override
	public boolean isWorking()
	{
		return this.isCleaning();
	}

	public int getCleaningProgress()
	{
		return this.cleaningProgress;
	}

	public void setCleaningProgress(int value)
	{
		this.cleaningProgress = value;
	}

	public boolean isCleaning()
	{
		return this.cleaningProgress > 0;
	}

	public int getCleaningProgressScaled(int scale)
	{
		return scale * this.cleaningProgress / TileCleaningTable.CLEANING_PROGRESS_MAX;
	}

	public boolean isBrush(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemBrush;
	}

	public boolean hasBrush()
	{
		return this.isBrush(this.getSlot(TileCleaningTable.SLOT_INDEX_BRUSH));
	}

	public boolean isDirtyFossil(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemFossilDirty;
	}

	public boolean hasDirtyFossil()
	{
		return this.isDirtyFossil(this.getSlot(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY));
	}

	public boolean isCleanFossil(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemFossilClean;
	}

	public boolean shouldCleanFossil()
	{
		if (this.hasBrush())
			if (this.hasDirtyFossil())
				return true;

		this.cleaningProgress = 0;
		return false;
	}

	public boolean canCleanFossil()
	{
		if (this.cleaningProgress >= TileCleaningTable.CLEANING_PROGRESS_MAX)
			return true;

		for (int slot_index : this.getSlotsBottom())
		{
			if (this.getSlot(slot_index).isEmpty())
			{
				this.cleaningProgress++;
				return false;
			}
		}

		this.cleaningProgress = 0;
		return false;
	}

	public void cleanFossil()
	{
		this.cleaningProgress = 0;

		ItemStack dirty_fossil = this.getSlot(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY);
		ItemStack clean_fossil = ItemStack.EMPTY;
		boolean hasCleanedFossil = false;
		boolean hasSetStack = false;

		if (this.world.rand.nextFloat() <= TileCleaningTable.FOSSIL_CHANCE)
		{
			String deExtinctedName = ((ItemFossilDirty) dirty_fossil.getItem()).getDeExtinctedName();
			clean_fossil = new ItemStack(DeItems.fossils_clean.get(deExtinctedName));
			if (!clean_fossil.isEmpty() && clean_fossil.getItem() instanceof ItemFossilClean)
				hasCleanedFossil = true;
		}

		if (hasCleanedFossil)
		{
			for (int search_index : this.getSlotsBottom())
			{
				if (!this.getSlot(search_index).isEmpty() && this.getSlot(search_index).getItem() == clean_fossil.getItem() && this.getSlot(search_index).getCount() < this.getInventoryStackLimit())
				{
					this.growStack(search_index, 1);
					hasSetStack = true;
					break;
				}
			}
		}
		else
		{
			clean_fossil = this.getRandomResult();

			for (int search_index : this.getSlotsBottom())
			{
				if (!this.getSlot(search_index).isEmpty() && this.getSlot(search_index).getItem() == clean_fossil.getItem() && this.getSlot(search_index).getCount() < this.getInventoryStackLimit())
				{
					this.growStack(search_index, 1);
					hasSetStack = true;
					break;
				}
			}
		}

		if (!hasSetStack)
		{
			for (int search_index : this.getSlotsBottom())
			{
				if (this.getSlot(search_index).isEmpty())
				{
					this.setInventorySlotContents(search_index, clean_fossil);
					hasSetStack = true;
					break;
				}
			}
		}

		if (hasSetStack)
		{
			this.shrinkStack(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY, 1);

			ItemStack brush = this.getSlot(TileCleaningTable.SLOT_INDEX_BRUSH);
			brush.setItemDamage(brush.getItemDamage() + 1);
			if (brush.getItemDamage() >= brush.getMaxDamage())
				this.setInventorySlotContents(TileCleaningTable.SLOT_INDEX_BRUSH, ItemStack.EMPTY);
		}
	}

	private ItemStack getRandomResult()
	{
		if (this.world.rand.nextFloat() < 0.99F)
		{
			switch (this.world.rand.nextInt(3))
			{
				case 0:
					return new ItemStack(Blocks.SAND);
				case 1:
					return new ItemStack(Blocks.COBBLESTONE);
				case 2:
					return new ItemStack(Items.BONE);
			}
		}
		else
		{
			switch (this.world.rand.nextInt(3))
			{
				case 0:
					return new ItemStack(Items.PAINTING);
				case 1:
					return new ItemStack(Items.COMPASS);
				case 2:
					return new ItemStack(Items.CLOCK);
			}
		}
		return new ItemStack(Items.BONE);
	}

	@Override
	public void update()
	{
		if (!this.world.isRemote)
		{
			if (this.shouldCleanFossil())
			{
				if (this.canCleanFossil())
					this.cleanFossil();
				else
					this.updateModel();
			}
			else
				this.updateModel();
		}
	}

	public void updateModel()
	{
		IBlockState iblockstate = this.world.getBlockState(this.pos);
		if (iblockstate.getBlock() == DeBlocks.cleaning_table_block && ((Boolean) iblockstate.getValue(BlockContainerHorizontalWorking.WORKING)).booleanValue() != this.isWorking())
		{
			this.world.setBlockState(this.pos, iblockstate.withProperty(BlockContainerHorizontalWorking.WORKING, this.isWorking()), 3);
			this.markDirty();
		}
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
	{
		return (oldState.getBlock() != newState.getBlock());
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerCleaningTable(playerInventory, this);
	}

	@Override
	public String getGuiID()
	{
		return DeExtinction.prependModID("cleaning_table");
	}

	@Override
	public void setCustomInventoryName(String name)
	{
		this.tileCustomName = name;
	}

	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.tileCustomName : I18n.translateToLocal("container.cleaning_table.name");
	}

	@Override
	public boolean hasCustomName()
	{
		return this.tileCustomName != null && this.tileCustomName.length() > 0;
	}

	@Override
	public void setInventorySlotContents(boolean flag, int index, ItemStack stack)
	{
		if (index == 0 && !flag)
		{
			this.cleaningProgress = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY:
				return this.isDirtyFossil(stack);
			case TileCleaningTable.SLOT_INDEX_BRUSH:
				return this.isBrush(stack);
			default:
				return false;
		}
	}

	@Override
	public int getField(int id)
	{
		switch (id)
		{
			case 0:
				return this.cleaningProgress;
		}
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		switch (id)
		{
			case 0:
				this.cleaningProgress = value;
				break;
		}
	}

	@Override
	public int getFieldCount()
	{
		return 1;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("CleaningProgress", this.cleaningProgress);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("CleaningProgress"))
			this.cleaningProgress = compound.getInteger("CleaningProgress");
	}
}
