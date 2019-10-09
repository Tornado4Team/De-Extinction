package com.deextinction.client.gui.inventory;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.GuiBase;
import com.deextinction.tileentities.TileDNAExtractor;
import com.deextinction.tileentities.containers.ContainerDNAExtractor;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDNAExtractor extends GuiBase
{
	private static final ResourceLocation GUI_TEXTURE_MAIN = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_dna_extractor.png");

	private final InventoryPlayer playerInventory;
	private TileDNAExtractor dna_extractor;

	public GuiDNAExtractor(InventoryPlayer playerInventory, TileDNAExtractor dna_extractor)
	{
		super(new ContainerDNAExtractor(playerInventory, dna_extractor));
		this.playerInventory = playerInventory;
		this.dna_extractor = dna_extractor;
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
		this.writeCenteredTextInGui(this.dna_extractor.getName(), 6, 4210752);
		this.writeText(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiDNAExtractor.GUI_TEXTURE_MAIN);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		if (this.dna_extractor.isExtracting())
			this.drawTexturedModalRect(this.guiLeft + 71, this.guiTop + 36, 176, 0, this.dna_extractor.getExtractingProgressScaled(24), 17);
	}
}
