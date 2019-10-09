package com.deextinction.tileentities.containers;

import com.deextinction.tileentities.TileDNAEditor;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerDNAEditor extends ContainerMachine
{
	private TileDNAEditor dnaEditor;
	private int editingProcess;
	private int dna_1;
	private int dna_2;
	private int dna_3;
	private int new_dna_1;
	private int new_dna_2;
	private int new_dna_3;

	public ContainerDNAEditor(InventoryPlayer playerInventory, TileDNAEditor dna_extractor)
	{
		this.dnaEditor = dna_extractor;

		// TileEntity inventory
		this.addSlotToContainer(new Slot(this.dnaEditor, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1, 17, 33)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaEditor.isDNABottleValid(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.dnaEditor, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_2, 17, 67)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaEditor.isDNABottleValid(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.dnaEditor, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3, 17, 101)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaEditor.isDNABottleValid(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.dnaEditor, TileDNAEditor.SLOT_INDEX_FLOPPY_DISK, 169, 33)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return dnaEditor.isFloppyDisk(stack);
			}
		});

		this.addSlotToContainer(new Slot(this.dnaEditor, TileDNAEditor.SLOT_INDEX_FLOPPY_DISK_EDITED, 169, 101)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return false;
			}
		});

		// Player inventory
		for (int i = 0; i < 9; i++)
			this.addSlotToContainer(new Slot(playerInventory, i, 21 + i * 18, 226 - 24));

		for (int i = 0; i < 3; i++)
			for (int k = 0; k < 9; k++)
				this.addSlotToContainer(new Slot(playerInventory, k + i * 9 + 9, 21 + k * 18, 226 - 82 + i * 18));
	}

	@Override
	protected IInventory getTileEntityWithInventory()
	{
		return this.dnaEditor;
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for (int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener icontainerlistener = this.listeners.get(i);

			if (this.editingProcess != this.dnaEditor.getField(0))
				icontainerlistener.sendWindowProperty(this, 0, this.dnaEditor.getField(0));

			if (this.dna_1 != this.dnaEditor.getField(1))
				icontainerlistener.sendWindowProperty(this, 1, this.dnaEditor.getField(1));
			if (this.dna_2 != this.dnaEditor.getField(2))
				icontainerlistener.sendWindowProperty(this, 2, this.dnaEditor.getField(2));
			if (this.dna_3 != this.dnaEditor.getField(3))
				icontainerlistener.sendWindowProperty(this, 3, this.dnaEditor.getField(3));

			if (this.new_dna_1 != this.dnaEditor.getField(4))
				icontainerlistener.sendWindowProperty(this, 4, this.dnaEditor.getField(4));
			if (this.new_dna_2 != this.dnaEditor.getField(5))
				icontainerlistener.sendWindowProperty(this, 5, this.dnaEditor.getField(5));
			if (this.new_dna_3 != this.dnaEditor.getField(6))
				icontainerlistener.sendWindowProperty(this, 6, this.dnaEditor.getField(6));
		}

		this.editingProcess = this.dnaEditor.getField(0);

		this.dna_1 = this.dnaEditor.getField(1);
		this.dna_2 = this.dnaEditor.getField(2);
		this.dna_3 = this.dnaEditor.getField(3);

		this.new_dna_1 = this.dnaEditor.getField(4);
		this.new_dna_2 = this.dnaEditor.getField(5);
		this.new_dna_3 = this.dnaEditor.getField(6);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		Slot sourceSlot = (Slot) inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index < this.dnaEditor.getSizeInventory())
		{
			// TileEntity Inventory, try to merge with player inventory;
			if (!this.mergeItemStack(sourceStack, this.dnaEditor.getSizeInventory(), this.inventorySlots.size(), false))
				return ItemStack.EMPTY;
		}
		else if (index >= this.dnaEditor.getSizeInventory())
		{
			// Player Inventory, try to merge with TileEntity inventory;
			if (this.dnaEditor.isDNABottleValid(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3 + 1, false))
					return ItemStack.EMPTY;
			}
			else if (this.dnaEditor.isFloppyDisk(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileDNAEditor.SLOT_INDEX_FLOPPY_DISK, TileDNAEditor.SLOT_INDEX_FLOPPY_DISK + 1, false))
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
