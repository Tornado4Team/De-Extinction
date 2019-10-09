package com.deextinction.tileentities.containers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerItemDeExtincted extends Container
{

	public ContainerItemDeExtincted()
	{

	}

	@Override
	public boolean canInteractWith(EntityPlayer player)
	{
		return player.isEntityAlive();
	}
}
