/*package com.deextinction.client.gui;

import java.io.IOException;
import java.util.List;

import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageMicroscopeSample;
import com.deextinction.tileentities.containers.SlotSwitchable;
import com.google.common.collect.Lists;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract class GuiPages extends GuiBase
{
	protected List<GuiPage> listPages = Lists.<GuiPage> newArrayList();
	protected int pageID;

	public GuiPages(Container container)
	{
		super(container);
	}

	@Override
	public void initGui()
	{
		super.initGui();
		this.initPages();
	}

	protected GuiPage getPage(int pageID)
	{
		return this.listPages.get(pageID);
	}

	protected GuiPage getPage()
	{
		return this.listPages.get(this.pageID);
	}

	protected int getPageID()
	{
		return this.pageID;
	}

	protected void setPageID(int pageID)
	{
		this.pageID = pageID;
	}

	public void changePage(int pageID)
	{
		this.sendMessage(pageID);
		this.pageID = pageID;
		GuiPage page = this.getPage();
		this.xSize = page.xSize;
		this.ySize = page.ySize;
		this.guiLeft = (this.width - this.xSize) / 2;
		this.guiTop = (this.height - this.ySize) / 2;
		this.buttonList.clear();
		this.buttonList = page.buttonList;
		page.updateInventory(this.inventorySlots.inventorySlots);
	}
    
	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		GuiPage page = this.getPage();
		page.actionPerformed(this, button);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GuiPage page = this.getPage();
		page.drawGuiContainerForegroundLayer(this, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

		GuiPage page = this.getPage();
		this.mc.getTextureManager().bindTexture(page.texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		page.drawGuiContainerBackgroundLayer(this, partialTicks, mouseX, mouseY);
	}

	protected abstract void initPages();
	
	protected abstract void sendMessage(int pageID);
}
*/