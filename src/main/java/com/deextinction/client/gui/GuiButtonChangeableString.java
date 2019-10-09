package com.deextinction.client.gui;

import com.deextinction.DeExtinction;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonChangeableString extends GuiButton
{

	/**
	 * Note that the xPos and yPos is the center of the button.
	 */
	public GuiButtonChangeableString(int id, int xPos, int yPos, String displayString, Minecraft mc)
	{
		super(id, xPos, yPos, 0, 20, displayString);
		this.setDisplayString(mc, displayString);
	}

	/** Sets the button display string. */
	public void setDisplayString(Minecraft mc, String displayString)
	{
		if (displayString != null)
		{
			this.displayString = displayString;
			this.width = mc.fontRenderer.getStringWidth(this.displayString) + 10;
		}
		else
			DeExtinction.logger.error("GuiButtonChangeable with id " + this.id + " has a display string equals to null. Display string was set to 'None'. THIS IS A BUG!");
	}

	/** Sets the button display string. */
	public void setDisplayString(Minecraft mc, String displayString, int button_width)
	{
		if (displayString != null)
		{
			this.displayString = displayString;
			this.width = button_width;
		}
		else
			DeExtinction.logger.error("GuiButtonChangeable with id " + this.id + " has a display string equals to null. Display string was set to 'None'. THIS IS A BUG!");
	}
}
