package com.deextinction.client.gui.inventory;

import com.deextinction.client.gui.GuiBase;
import com.deextinction.tileentities.containers.ContainerItemDeExtincted;

public class GuiItemDeExtinction extends GuiBase
{

	public GuiItemDeExtinction()
	{
		super(new ContainerItemDeExtincted());
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{

	}
}
