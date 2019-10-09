package com.deextinction.tileentities.containers;

import com.deextinction.tileentities.TileCleaningTable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerCleaningTable extends ContainerMachine
{
	private TileCleaningTable cleaningTable;
	private int cleaningProgress;

	public ContainerCleaningTable(InventoryPlayer playerInventory, TileCleaningTable cleaning_table)
	{
		this.cleaningTable = cleaning_table;

		// TileEntity inventory
		this.addSlotToContainer(new Slot(this.cleaningTable, TileCleaningTable.SLOT_INDEX_BRUSH, 22, 35)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return cleaningTable.isBrush(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.cleaningTable, TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY, 48, 35)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return cleaningTable.isDirtyFossil(stack);
			}
		});

		for (int x = 0; x < 3; x++)
			for (int y = 0; y < 3; y++)
				this.addSlotToContainer(new Slot(this.cleaningTable, 2 + x + y * 3, 102 + x * 18, 17 + y * 18)
				{
					@Override
					public boolean isItemValid(ItemStack stack)
					{
						return false;
					}
				});

		// Player inventory
		for (int i = 0; i < 9; i++)
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));

		for (int i = 0; i < 3; i++)
			for (int k = 0; k < 9; k++)
				this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
	}

	@Override
	protected IInventory getTileEntityWithInventory()
	{
		return this.cleaningTable;
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener icontainerlistener = this.listeners.get(i);

			if (this.cleaningProgress != this.cleaningTable.getField(0))
				icontainerlistener.sendWindowProperty(this, 0, this.cleaningTable.getField(0));
		}

		this.cleaningProgress = this.cleaningTable.getField(0);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		Slot sourceSlot = (Slot) inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index < this.cleaningTable.getSizeInventory())
		{
			// TileEntity Inventory, try to merge with player inventory;
			if (!this.mergeItemStack(sourceStack, this.cleaningTable.getSizeInventory(), this.inventorySlots.size(), false))
				return ItemStack.EMPTY;
		}
		else if (index >= this.cleaningTable.getSizeInventory())
		{
			// Player Inventory, try to merge with TileEntity inventory;
			if (this.cleaningTable.isBrush(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileCleaningTable.SLOT_INDEX_BRUSH, TileCleaningTable.SLOT_INDEX_BRUSH + 1, false))
					return ItemStack.EMPTY;
			}
			else if (this.cleaningTable.isDirtyFossil(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY, TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY + 1, false))
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
