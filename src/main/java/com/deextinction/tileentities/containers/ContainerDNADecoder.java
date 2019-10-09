package com.deextinction.tileentities.containers;

import com.deextinction.tileentities.TileDNADecoder;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDNADecoder extends ContainerMachine
{
	private TileDNADecoder dnaDecoder;
	private int decodingProgress;
	private int researchProgress;
	private int pageID;

	public ContainerDNADecoder(InventoryPlayer playerInventory, TileDNADecoder dna_decoder)
	{
		this.dnaDecoder = dna_decoder;

		// TileEntity inventory
		this.addSlotToContainer(new SlotSwitchable(this.dnaDecoder, TileDNADecoder.SLOT_INDEX_DNA_BOTTLE, 38, 32)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaDecoder.isDNABottle(stack);
			}
		});

		this.addSlotToContainer(new SlotSwitchable(this.dnaDecoder, TileDNADecoder.SLOT_INDEX_DISK_EMPTY, 73, 32)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaDecoder.isFloppyDiskEmpty(stack);
			}
		});

		for (int x = 0; x < 2; x++)
			for (int y = 0; y < 2; y++)
				this.addSlotToContainer(new SlotSwitchable(this.dnaDecoder, 2 + x + y * 2, 110 + x * 18, 34 + y * 18)
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
		return this.dnaDecoder;
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener icontainerlistener = this.listeners.get(i);

			if (this.decodingProgress != this.dnaDecoder.getField(0))
				icontainerlistener.sendWindowProperty(this, 0, this.dnaDecoder.getField(0));
			if (this.researchProgress != this.dnaDecoder.getField(1))
				icontainerlistener.sendWindowProperty(this, 1, this.dnaDecoder.getField(1));
			if (this.pageID != this.dnaDecoder.getField(2))
				icontainerlistener.sendWindowProperty(this, 2, this.dnaDecoder.getField(2));
		}

		this.decodingProgress = this.dnaDecoder.getField(0);
		this.researchProgress = this.dnaDecoder.getField(1);
		this.pageID = this.dnaDecoder.getField(2);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		Slot sourceSlot = (Slot) inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index < this.dnaDecoder.getSizeInventory())
		{
			// TileEntity Inventory, try to merge with player inventory;
			if (!this.mergeItemStack(sourceStack, this.dnaDecoder.getSizeInventory(), this.inventorySlots.size(), false))
				return ItemStack.EMPTY;
		}
		else if (index >= this.dnaDecoder.getSizeInventory())
		{
			// Player Inventory, try to merge with TileEntity inventory;
			if (this.dnaDecoder.isDNABottle(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDNADecoder.SLOT_INDEX_DNA_BOTTLE, TileDNADecoder.SLOT_INDEX_DNA_BOTTLE + 1, false))
					return ItemStack.EMPTY;
			}
			else if (this.dnaDecoder.isFloppyDiskEmpty(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDNADecoder.SLOT_INDEX_DISK_EMPTY, TileDNADecoder.SLOT_INDEX_DISK_EMPTY + 1, false))
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
