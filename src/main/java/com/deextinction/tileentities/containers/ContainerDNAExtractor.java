package com.deextinction.tileentities.containers;

import com.deextinction.tileentities.TileDNAExtractor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDNAExtractor extends ContainerMachine
{
	private TileDNAExtractor dnaExtractor;
	private int extractionProcess;

	public ContainerDNAExtractor(InventoryPlayer playerInventory, TileDNAExtractor dna_extractor)
	{
		this.dnaExtractor = dna_extractor;

		// TileEntity inventory
		this.addSlotToContainer(new Slot(this.dnaExtractor, TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN, 48, 17)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaExtractor.isFossilClean(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.dnaExtractor, TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE, 48, 53)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaExtractor.isWaterBottle(stack);
			}
		});
		for (int x = 0; x < 3; x++)
			for (int y = 0; y < 3; y++)
				this.addSlotToContainer(new Slot(this.dnaExtractor, 2 + x + y * 3, 102 + x * 18, 17 + y * 18)
				{
					@Override
					public boolean isItemValid(ItemStack stack)
					{
						return false;
					}
				});

		// Player inventory
		for (int i = 0; i < 9; i++)
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 166 - 24));

		for (int i = 0; i < 3; i++)
			for (int k = 0; k < 9; k++)
				this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 8 + k * 18, 166 - 82 + i * 18));
	}

	@Override
	protected IInventory getTileEntityWithInventory()
	{
		return this.dnaExtractor;
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener icontainerlistener = this.listeners.get(i);

			if (this.extractionProcess != this.dnaExtractor.getField(0))
				icontainerlistener.sendWindowProperty(this, 0, this.dnaExtractor.getField(0));
		}

		this.extractionProcess = this.dnaExtractor.getField(0);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		Slot sourceSlot = (Slot) inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index < this.dnaExtractor.getSizeInventory())
		{
			// TileEntity Inventory, try to merge with player inventory;
			if (!this.mergeItemStack(sourceStack, this.dnaExtractor.getSizeInventory(), this.inventorySlots.size(), false))
				return ItemStack.EMPTY;
		}
		else if (index >= this.dnaExtractor.getSizeInventory())
		{
			// Player Inventory, try to merge with TileEntity inventory;
			if (this.dnaExtractor.isFossilClean(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN, TileDNAExtractor.SLOT_INDEX_FOSSIL_CLEAN + 1, false))
					return ItemStack.EMPTY;
			}
			else if (this.dnaExtractor.isWaterBottle(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE, TileDNAExtractor.SLOT_INDEX_GLASS_BOTTLE + 1, false))
					return ItemStack.EMPTY;
			}
			else
				return ItemStack.EMPTY;
		}
		else
		{
			System.err.print("Invalid slotIndex:" + index);
			return ItemStack.EMPTY;
		}

		if (sourceStack.getCount() == 0)
			sourceSlot.putStack(ItemStack.EMPTY);
		else
			sourceSlot.onSlotChanged();

		sourceSlot.onTake(playerIn, sourceStack);
		return copyOfSourceStack;
	}
}
