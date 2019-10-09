package com.deextinction.client.gui.inventory;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.GuiBase;
import com.deextinction.tileentities.TileDeExtinctionMachine;
import com.deextinction.tileentities.containers.ContainerDeExtinctionMachine;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDeExtinctionMachine extends GuiBase
{
	private static final ResourceLocation GUI_TEXTURE_MAIN = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_de_extinction_machine.png");

	private final InventoryPlayer playerInventory;
	private TileDeExtinctionMachine de_extinction_machine;

	public GuiDeExtinctionMachine(InventoryPlayer playerInventory, TileDeExtinctionMachine de_extinction_machine)
	{
		super(new ContainerDeExtinctionMachine(playerInventory, de_extinction_machine));
		this.playerInventory = playerInventory;
		this.de_extinction_machine = de_extinction_machine;
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
		this.writeCenteredTextInGui(this.de_extinction_machine.getName(), 6, 4210752);
		this.writeText(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiDeExtinctionMachine.GUI_TEXTURE_MAIN);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		if (this.de_extinction_machine.isCreating())
			this.drawTexturedModalRect(this.guiLeft + 72, this.guiTop + 35, 176, 0, this.de_extinction_machine.getCreatingProgressScaled(24), 17);
	}
}
