package com.deextinction.tileentities.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class ContainerMachine extends Container
{

	@Override
	public void addListener(IContainerListener listener)
	{
		super.addListener(listener);
		listener.sendAllWindowProperties(this, this.getTileEntityWithInventory());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data)
	{
		this.getTileEntityWithInventory().setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn)
	{
		return this.getTileEntityWithInventory().isUsableByPlayer(playerIn);
	}

	protected abstract IInventory getTileEntityWithInventory();
}
