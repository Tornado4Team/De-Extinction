package com.deextinction.tileentities;

import com.deextinction.util.ITileName;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;

public abstract class TileMachine extends TileEntityLockable implements ITickable, ISidedInventory, ITileName
{
	private int[] slots_top;
	private int[] slots_sides;
	private int[] slots_bottom;

	private NonNullList<ItemStack> slots;
	protected String tileCustomName;

	public TileMachine(int[] slots_top, int[] slots_sides, int[] slots_bottom)
	{
		this.slots_top = slots_top;
		this.slots_sides = slots_sides;
		this.slots_bottom = slots_bottom;
		this.slots = NonNullList.<ItemStack> withSize(slots_top.length + slots_sides.length + slots_bottom.length, ItemStack.EMPTY);
	}

	public NonNullList<ItemStack> getSlots()
	{
		return this.slots;
	}

	public ItemStack getSlot(int index)
	{
		return this.slots.get(index);
	}

	public void setSlot(int index, ItemStack itemStack)
	{
		this.setInventorySlotContents(index, itemStack);
	}

	public void growStack(int index, int value)
	{
		ItemStack grown = this.slots.get(index).copy();
		grown.grow(value);
		this.setInventorySlotContents(index, grown);
	}

	public void shrinkStack(int index, int value)
	{
		ItemStack shrinked = this.slots.get(index).copy();
		shrinked.shrink(value);
		this.setInventorySlotContents(index, shrinked);
	}

	public int[] getSlotsTop()
	{
		return this.slots_top;
	}

	public int[] getSlotsBottom()
	{
		return this.slots_bottom;
	}

	public int[] getSlotsSides()
	{
		return this.slots_sides;
	}

	@Override
	public int getSizeInventory()
	{
		return this.slots.size();
	}

	@Override
	public boolean isEmpty()
	{
		for (ItemStack itemstack : this.slots)
			if (!itemstack.isEmpty())
				return false;

		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return this.slots.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		ItemStack itemstack = ItemStackHelper.getAndSplit(this.slots, index, count);
		if (!itemstack.isEmpty())
			this.markDirty();

		return itemstack;
	}

	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		return ItemStackHelper.getAndRemove(this.slots, index);
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		if (side == EnumFacing.DOWN)
			return this.getSlotsBottom();
		else
			return side == EnumFacing.UP ? this.getSlotsTop() : this.getSlotsSides();
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return this.isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
	{
		return true;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		ItemStack itemstack = this.slots.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.slots.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit())
			stack.setCount(this.getInventoryStackLimit());

		this.setInventorySlotContents(flag, index, stack);
	}

	@Override
	public int getInventoryStackLimit()
	{
		return 64;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player)
	{
		if (this.world.getTileEntity(this.pos) != this)
			return false;
		else
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player)
	{

	}

	@Override
	public void closeInventory(EntityPlayer player)
	{

	}

	@Override
	public void clear()
	{
		this.slots.clear();
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		ItemStackHelper.saveAllItems(compound, this.slots);

		if (this.hasCustomName())
			compound.setString("CustomName", this.tileCustomName);

		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.slots = NonNullList.<ItemStack> withSize(this.getSizeInventory(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.slots);

		if (compound.hasKey("CustomName", 8))
			this.tileCustomName = compound.getString("CustomName");
	}

	public abstract void setInventorySlotContents(boolean flag, int index, ItemStack stack);
}
