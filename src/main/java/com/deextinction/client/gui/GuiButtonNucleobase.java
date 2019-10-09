package com.deextinction.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiButtonNucleobase extends GuiButton
{
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
	 * This is the x position that is added to the xPosTexture in order to
	 * change image.
	 */
	protected int xPosTextureOffset;
	/**
	 * This is the y position of the left-top corner of the normal button in the
	 * texture.
	 */
	protected int yPosTexture;
	/** State of the button. */
	protected boolean state;
	/** This is the number used to change the texture. */
	protected int imageIndex;

	public GuiButtonNucleobase(int id, int xPos, int yPos, int xPosTexture, int yPosTexture, int width, int height, int imageIndex, boolean flag, ResourceLocation resourceLocation)
	{
		super(id, xPos, yPos, width, height, "");
		this.guiTextureWidgets = resourceLocation;
		this.xPosTexture = xPosTexture;
		this.yPosTexture = yPosTexture;
		this.xPosTextureOffset = imageIndex;
		this.state = flag;
	}

	public GuiButtonNucleobase(int id, int xPos, int yPos, int xPosTexture, int yPosTexture, int width, int height, int xPosTextureOffset, ResourceLocation resourceLocation)
	{
		this(id, xPos, yPos, xPosTexture, yPosTexture, width, height, xPosTextureOffset, true, resourceLocation);
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
				if (!this.hovered)
				{
					if (this.state)
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width * this.imageIndex, this.yPosTexture, this.width, this.height);
					else
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width * this.imageIndex, this.yPosTexture, this.width, this.height);
				}
				else
				{
					if (this.state)
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width * this.imageIndex, this.yPosTexture + this.height, this.width, this.height);
					else
						this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width * this.imageIndex, this.yPosTexture + this.height, this.width, this.height);
				}
			}
			else
				this.drawTexturedModalRect(this.x, this.y, this.xPosTexture + this.width * this.imageIndex, this.yPosTexture + 2 * this.height, this.width, this.height);
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

	public void setImageIndex(int imageIndex)
	{
		this.imageIndex = imageIndex;
	}

	public int getImageIndex()
	{
		return this.imageIndex;
	}

	public int nextImageIndex()
	{
		this.imageIndex++;
		if (this.imageIndex > 3)
			this.imageIndex = 0;
		return this.imageIndex;
	}

	public void setImage(ResourceLocation resourceLocation, int xPosTexture, int yPosTexture)
	{
		this.guiTextureWidgets = resourceLocation;
		this.xPosTexture = xPosTexture;
		this.yPosTexture = yPosTexture;
	}
}
