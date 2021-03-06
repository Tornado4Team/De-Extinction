package com.deextinction.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiImageToggleButtonH extends GuiButton
{
	/** State of the button. */
	protected boolean state;
	/**
	 * This is the texture where the button is. It should be in the following
	 * vertical order: normal, selected, disabled.
	 */
	protected ResourceLocation guiTextureWidgets;
	/**
	 * This is the x position of the left-top corner of the normal button in the
	 * texture.
	 */
	protected int xPosTexture;
	/**
	 * This is the y position of the left-top corner of the normal button in the
	 * texture.
	 */
	protected int yPosTexture;

	public GuiImageToggleButtonH(int id, int xPos, int yPos, boolean flag, int xPosTexture, int yPosTexture, int width, int height, ResourceLocation resourceLocation)
	{
		super(id, xPos, yPos, width, height, "");
		this.guiTextureWidgets = resourceLocation;
		this.xPosTexture = xPosTexture;
		this.yPosTexture = yPosTexture;
		this.state = flag;
	}

	public GuiImageToggleButtonH(int id, int xPos, int yPos, int xPosTexture, int yPosTexture, int width, int height, ResourceLocation resourceLocation)
	{
		this(id, xPos, yPos, false, xPosTexture, yPosTexture, width, height, resourceLocation);
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		if (this.visible)
		{
			FontRenderer fontrenderer = mc.fontRenderer;
			mc.renderEngine.bindTexture(this.guiTextureWidgets);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
			GlStateManager.enableBlend();
			GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
			GlStateManager.blendFunc(770, 771);
			if (this.enabled)
			{
				if (this.state)
				{
					if (this.hovered)
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width, this.yPosTexture, this.width, this.height);
					else
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width, this.yPosTexture, this.width, this.height);
				}
				else
				{
					if (this.hovered)
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture, this.yPosTexture, this.width, this.height);
					else
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture, this.yPosTexture, this.width, this.height);
				}
			}
			else
				this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + 2 * this.width, this.yPosTexture, this.width, this.height);
			this.mouseDragged(mc, mouseX, mouseY);
		}
	}

	public void setState(boolean flag)
	{
		this.state = flag;
	}

	public boolean getState()
	{
		return this.state;
	}

	public void setImage(ResourceLocation resourceLocation, int xPosTexture, int yPosTexture)
	{
		this.guiTextureWidgets = resourceLocation;
		this.xPosTexture = xPosTexture;
		this.yPosTexture = yPosTexture;
	}
}
