package com.deextinction.client.gui.inventory;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.GuiBase;
import com.deextinction.tileentities.TileDNADecoder;
import com.deextinction.tileentities.containers.ContainerDNADecoder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDNADecoder extends GuiBase
{
	private static final ResourceLocation GUI_TEXTURE_MAIN = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_dna_decoder.png");

	private final InventoryPlayer playerInventory;
	private TileDNADecoder dna_decoder;

	public GuiDNADecoder(InventoryPlayer playerInventory, TileDNADecoder dna_decoder)
	{
		super(new ContainerDNADecoder(playerInventory, dna_decoder));
		this.playerInventory = playerInventory;
		this.dna_decoder = dna_decoder;
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
		this.writeCenteredTextInGui(this.dna_decoder.getName(), 6, 4210752);
		this.writeText(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiDNADecoder.GUI_TEXTURE_MAIN);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		this.drawTexturedModalRect(this.guiLeft + 36, this.guiTop + 61, 176, 2, this.dna_decoder.getResearchProgressScaled(55), 9);
		    
		
		if (this.dna_decoder.isDecoding())
			this.drawTexturedModalRect(this.guiLeft + 36, this.guiTop + 55, 176, 0, this.dna_decoder.getDecodingProgressScaled(55), 2);
	}
}































/*

import com.deextinction.client.gui.GuiPage;
import com.deextinction.client.gui.GuiPages;
import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageDecoderPage;
import com.deextinction.tileentities.TileDNADecoder;
import com.deextinction.tileentities.containers.ContainerDNADecoder;
import com.deextinction.tileentities.containers.SlotSwitchable;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDNADecoder extends GuiPages
{
	private final InventoryPlayer playerInventory;
	private TileDNADecoder dna_decoder;

	public static final int PAGE_TREE = 0;
	public static final int PAGE_DECODING = 1;

	public GuiDNADecoder(InventoryPlayer playerInventory, TileDNADecoder dna_decoder)
	{
		super(new ContainerDNADecoder(playerInventory, dna_decoder));
		this.playerInventory = playerInventory;
		this.dna_decoder = dna_decoder;
		this.pageID = this.dna_decoder.getPage();
	}
	
	@Override
	protected void initPages()
	{
		this.buttonList.clear();
		this.listPages.clear();

		this.listPages.add(new GuiDNADecoderTreePage(this));
		this.listPages.add(new GuiDNADecoderDecoding(this));

		this.changePage(this.pageID);
	}

	@Override
	protected void sendMessage(int pageID)
	{
		BlockPos pos = this.dna_decoder.getPos();
		DeMessages.wrapper.sendToServer(new MessageDecoderPage(pageID, pos.getX(), pos.getY(), pos.getZ()));
	}
}
*/
