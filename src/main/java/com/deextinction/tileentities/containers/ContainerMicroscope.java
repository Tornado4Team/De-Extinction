package com.deextinction.tileentities.containers;

import com.deextinction.tileentities.TileMicroscope;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMicroscope extends ContainerMachine
{
	private TileMicroscope microscope;

	public ContainerMicroscope(InventoryPlayer playerInventory, TileMicroscope microscope)
	{
		this.microscope = microscope;

		// TileEntity inventory
		this.addSlotToContainer(new SlotSwitchable(this.microscope, TileMicroscope.SLOT_INDEX_SLIDE, 91, 73)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return microscope.isSlide(stack);
			}
		});

		this.addSlotToContainer(new SlotSwitchable(this.microscope, TileMicroscope.SLOT_INDEX_SAMPLE, 69, 73)
		{
			@Override
			public boolean isItemValid(ItemStack stack)
			{
				return microscope.isSample(stack);
			}
		});

		// Player inventory
		for (int i = 0; i < 9; i++)
			this.addSlotToContainer(new SlotSwitchable(playerInventory, i, 8 + i * 18, 232));

		for (int i = 0; i < 3; i++)
			for (int k = 0; k < 9; k++)
				this.addSlotToContainer(new SlotSwitchable(playerInventory, k + i * 9 + 9, 8 + k * 18, 174 + i * 18));
	}

	@Override
	protected IInventory getTileEntityWithInventory()
	{
		return this.microscope;
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
	{
		Slot sourceSlot = (Slot) inventorySlots.get(index);
		if (sourceSlot == null || !sourceSlot.getHasStack())
			return ItemStack.EMPTY;

		ItemStack sourceStack = sourceSlot.getStack();
		ItemStack copyOfSourceStack = sourceStack.copy();

		if (index < this.microscope.getSizeInventory())
		{
			// TileEntity Inventory, try to merge with player inventory;
			if (!this.mergeItemStack(sourceStack, this.microscope.getSizeInventory(), this.inventorySlots.size(), false))
				return ItemStack.EMPTY;
		}
		else if (index >= this.microscope.getSizeInventory())
		{
			// Player Inventory, try to merge with TileEntity inventory;
			if (this.microscope.isSlide(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileMicroscope.SLOT_INDEX_SLIDE, TileMicroscope.SLOT_INDEX_SLIDE + 1, false))
					return ItemStack.EMPTY;
			}
			else if (this.microscope.isSample(sourceStack))
			{
				if (!this.mergeItemStack(sourceStack, TileMicroscope.SLOT_INDEX_SAMPLE, TileMicroscope.SLOT_INDEX_SAMPLE + 1, false))
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
