/*package com.deextinction.client.gui.inventory;

import java.io.IOException;
import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.GuiPage;
import com.deextinction.client.gui.GuiPages;
import com.deextinction.tileentities.containers.SlotSwitchable;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDNADecoderDecoding extends GuiPage
{
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_dna_decoder.png");

	public GuiDNADecoderDecoding(GuiDNADecoder gui)
	{
		super(gui, GuiDNADecoder.PAGE_DECODING, 176, 166, GuiDNADecoderDecoding.GUI_TEXTURE);
	}

	@Override
	public void updateInventory(List<Slot> inventorySlots)
	{
		for (Slot slot : inventorySlots)
		{
			if (slot instanceof SlotSwitchable)
				((SlotSwitchable) slot).setState(true);
		}
	}

	@Override
	public void actionPerformed(GuiPages gui, GuiButton button) throws IOException
	{

	}

	@Override
	public void drawGuiContainerForegroundLayer(GuiPages gui, int mouseX, int mouseY)
	{

	}

	@Override
	public void drawGuiContainerBackgroundLayer(GuiPages gui, float partialTicks, int mouseX, int mouseY)
	{
		}
}
*/