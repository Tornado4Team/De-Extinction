package com.deextinction.tileentities.containers;

import com.deextinction.tileentities.TileDeExtinctionMachine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDeExtinctionMachine extends ContainerMachine
{
	private TileDeExtinctionMachine deExtinctionMachine;
	private int creatingProcess;

	public ContainerDeExtinctionMachine(InventoryPlayer playerInventory, TileDeExtinctionMachine de_extinction_machine)
	{
		this.deExtinctionMachine = de_extinction_machine;

		// TileEntity inventory
		this.addSlotToContainer(new Slot(this.deExtinctionMachine, TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK, 49, 17)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return deExtinctionMachine.isFloppyDisk(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.deExtinctionMachine, TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT, 49, 53));

		this.addSlotToContainer(new Slot(this.deExtinctionMachine, TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_CREATED, 107, 35)
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
		return this.deExtinctionMachine;
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); i++)
		{
			IContainerListener listener = (IContainerListener) this.listeners.get(i);
			if (this.creatingProcess != this.deExtinctionMachine.getCreatingProgress())
				listener.sendWindowProperty(this, 0, this.deExtinctionMachine.getCreatingProgress());
		}
		this.creatingProcess = this.deExtinctionMachine.getCreatingProgress();
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		Slot sourceSlot = (Slot) inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index < this.deExtinctionMachine.getSizeInventory())
		{
			// TileEntity Inventory, try to merge with player inventory;
			if (!this.mergeItemStack(sourceStack, this.deExtinctionMachine.getSizeInventory(), this.inventorySlots.size(), false))
				return ItemStack.EMPTY;
			else if (!this.mergeItemStack(sourceStack, 0, this.deExtinctionMachine.getSizeInventory(), false))
				return ItemStack.EMPTY;
		}
		else if (index >= this.deExtinctionMachine.getSizeInventory())
		{
			// Player Inventory, try to merge with TileEntity inventory;
			if (this.deExtinctionMachine.isFloppyDisk(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK, TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK + 1, false))
					return ItemStack.EMPTY;
			}
			else if (this.deExtinctionMachine.isEmbryoRequirement(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT, TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT + 1, false))
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
