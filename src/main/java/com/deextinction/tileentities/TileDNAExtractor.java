package com.deextinction.tileentities;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockContainerHorizontalWorking;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;
import com.deextinction.item.ItemDNABottle;
import com.deextinction.item.ItemFossilClean;
import com.deextinction.tileentities.containers.ContainerDNAExtractor;
import com.deextinction.util.ITileWorking;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class TileDNAExtractor extends TileMachine implements ITileWorking
{
	public static final int SLOT_INDEX_FOSSIL_CLEAN = 0;
	public static final int SLOT_INDEX_GLASS_BOTTLE = 1;

	private static final int EXTRACTING_PROGRESS_MAX = 120;

	private int extractingProgress = 0;

	public TileDNAExtractor()
	{
		super(new int[] { TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN }, new int[] { TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE }, new int[] { 2, 3, 4, 5, 6, 7, 8, 9, 10 });
	}

	@Override
	public boolean isWorking()
	{
		return this.isExtracting();
	}

	public int getExtractionProgress()
	{
		return this.extractingProgress;
	}

	public void setExtractingProgress(int value)
	{
		this.extractingProgress = value;
	}

	public boolean isExtracting()
	{
		return this.extractingProgress > 0;
	}

	public int getExtractingProgressScaled(int scale)
	{
		return scale * this.extractingProgress / TileDNAExtractor.EXTRACTING_PROGRESS_MAX;
	}

	public boolean isFossilClean(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemFossilClean;
	}

	public boolean hasFossilClean()
	{
		return this.isFossilClean(this.getSlot(TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN));
	}

	private String getNameFromFossil()
	{
		if (this.hasFossilClean())
			return ((ItemFossilClean) this.getSlot(TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN).getItem()).getDeExtinctedName();
		return null;
	}

	public boolean isWaterBottle(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemGlassBottle;
	}

	public boolean hasWaterBottle()
	{
		return this.isWaterBottle(this.getSlot(TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE));
	}

	public boolean isDNABottle(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemDNABottle;
	}

	public boolean shouldExtractDNA()
	{
		if (this.hasFossilClean())
			if (this.hasWaterBottle())
				return true;

		this.extractingProgress = 0;
		return false;
	}

	public boolean canExtractDNA()
	{
		if (this.extractingProgress >= TileDNAExtractor.EXTRACTING_PROGRESS_MAX)
			return true;

		for (int slot_index : this.getSlotsBottom())
		{
			if (this.getSlot(slot_index).isEmpty())
			{
				this.extractingProgress++;
				return false;
			}
		}
		this.extractingProgress = 0;
		return false;
	}

	public void extractDNA()
	{
		ItemStack dna_bottle = ItemStack.EMPTY;
		boolean hasDnaBottle = false;
		boolean hasSetStack = false;

		String fossilName = this.getNameFromFossil();
		if (fossilName != null)
		{
			if (DeDatabase.LIST_DE_EXTINCTED.containsKey(fossilName))
			{
				dna_bottle = DeDatabase.LIST_DE_EXTINCTED.get(fossilName).getDNABottle();
				if (!dna_bottle.isEmpty())
					hasDnaBottle = true;
			}
		}

		if (hasDnaBottle)
		{
			for (int search_index : this.getSlotsBottom())
			{
				if (!this.getSlot(search_index).isEmpty() && this.getSlot(search_index).getItem() == dna_bottle.getItem() && this.getSlot(search_index).getCount() < this.getInventoryStackLimit())
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
					this.setInventorySlotContents(search_index, dna_bottle);
					hasSetStack = true;
					break;
				}
			}
		}

		if (hasSetStack)
		{
			this.shrinkStack(TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN, 1);
			this.shrinkStack(TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE, 1);
		}

		this.extractingProgress = 0;
	}

	@Override
	public void update()
	{
		if (!this.world.isRemote)
		{
			if (this.shouldExtractDNA())
			{
				if (this.canExtractDNA())
					this.extractDNA();
				else
					this.updateModel();
			}
			else
				this.updateModel();
		}
	}

	@Override
	public void updateModel()
	{
		IBlockState iblockstate = this.world.getBlockState(this.pos);
		if (iblockstate.getBlock() == DeBlocks.dna_extractor && ((Boolean) iblockstate.getValue(BlockContainerHorizontalWorking.WORKING)).booleanValue() != this.isWorking())
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
		return new ContainerDNAExtractor(playerInventory, this);
	}

	@Override
	public String getGuiID()
	{
		return DeExtinction.prependModID("dna_extractor");
	}

	@Override
	public void setCustomInventoryName(String name)
	{
		this.tileCustomName = name;
	}

	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.tileCustomName : I18n.translateToLocal("container.dna_extractor.name");
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
			this.extractingProgress = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN:
				return this.isFossilClean(stack);
			case TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE:
				return this.isWaterBottle(stack);
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
				return this.extractingProgress;
		}
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		switch (id)
		{
			case 0:
				this.extractingProgress = value;
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
		compound.setInteger("ExtractingProgress", this.extractingProgress);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("ExtractingProgress"))
			this.extractingProgress = compound.getInteger("ExtractingProgress");
	}

	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		return new SPacketUpdateTileEntity(this.pos, 5, this.getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag()
	{
		return this.writeToNBT(new NBTTagCompound());
	}
}
