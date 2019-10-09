/*package com.deextinction.client.gui;

import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class GuiPage
{
	protected final List<GuiButton> buttonList = Lists.<GuiButton> newArrayList();
	protected final ResourceLocation texture;
	protected final int pageID;
	protected final int xSize;
	protected final int ySize;
	protected final int guiLeft;
	protected final int guiTop;

	public GuiPage(GuiPages gui, int pageID, int xSize, int ySize, ResourceLocation texture)
	{
		this.buttonList.clear();
		this.texture = texture;
		this.pageID = pageID;
		this.xSize = xSize;
		this.ySize = ySize;
        this.guiLeft = (gui.width - xSize) / 2;
        this.guiTop = (gui.height - ySize) / 2;
	}

	public abstract void actionPerformed(GuiPages gui, GuiButton button) throws IOException;

	public abstract void drawGuiContainerForegroundLayer(GuiPages gui, int mouseX, int mouseY);

	public abstract void drawGuiContainerBackgroundLayer(GuiPages gui, float partialTicks, int mouseX, int mouseY);

	public abstract void updateInventory(List<Slot> inventorySlots);
}
*/