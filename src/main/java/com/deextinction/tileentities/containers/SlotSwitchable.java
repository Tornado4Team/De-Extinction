package com.deextinction.tileentities.containers;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

public class SlotSwitchable extends Slot
{
	/** Initial display position of the inventory slot on the screen x axis */
	private final int initxPos;

	/** Initial display position of the inventory slot on the screen y axis */
	private final int inityPos;

	public SlotSwitchable(IInventory inventoryIn, int index, int xPosition, int yPosition)
	{
		super(inventoryIn, index, xPosition, yPosition);
		this.initxPos = xPosition;
		this.inityPos = yPosition;
	}

	public void setState(boolean flag)
	{
		if (flag)
		{
			this.xPos = this.initxPos;
			this.yPos = this.inityPos;
		}
		else
		{
			this.xPos = Integer.MAX_VALUE;
			this.yPos = Integer.MAX_VALUE;
		}
	}

	public void setPos(int posX, int posY)
	{
		this.xPos = posX;
		this.yPos = posY;
	}

	public void addPosX(int addX)
	{
		this.xPos = this.initxPos + addX;
	}

	public void setPosX(int posX)
	{
		this.xPos = posX;
	}

	public int getPosX()
	{
		return this.xPos;
	}

	public void addPosY(int addY)
	{
		this.yPos = this.inityPos + addY;
	}

	public void setPosY(int posY)
	{
		this.yPos = posY;
	}

	public int getPosY()
	{
		return this.yPos;
	}
}
