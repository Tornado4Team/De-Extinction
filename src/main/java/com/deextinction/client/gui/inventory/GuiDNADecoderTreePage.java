/*package com.deextinction.client.gui.inventory;

import java.io.IOException;
import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.GuiImageButtonH;
import com.deextinction.client.gui.GuiPage;
import com.deextinction.client.gui.GuiPages;
import com.deextinction.database.DeExtincted;
import com.deextinction.init.DeDatabase;
import com.deextinction.tileentities.containers.SlotSwitchable;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDNADecoderTreePage extends GuiPage
{
	private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_dna_decoder_tree.png");
	private static final ResourceLocation GUI_TEXTURE_WIDGETS = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_widgets_tree.png");

	public static final int BUTTON_MONERA = 0;
	public static final int BUTTON_PROTISTA = 1;
	public static final int BUTTON_FUNGI = 2;
	public static final int BUTTON_BRYOPHYTA = 3;
	public static final int BUTTON_PTERIDOPHYTA = 4;
	public static final int BUTTON_GYMNOSPERM = 5;
	public static final int BUTTON_ANGIOSPERM = 6;
	public static final int BUTTON_PORIFERA = 7;
	public static final int BUTTON_CNIDARIA = 8;
	public static final int BUTTON_MOLLUSCA = 9;
	public static final int BUTTON_ARTHROPODA = 10;
	public static final int BUTTON_ECHINODERMATA = 11;
	public static final int BUTTON_FISH = 12;
	public static final int BUTTON_AMPHIBIANS = 13;
	public static final int BUTTON_MAMMALS = 14;
	public static final int BUTTON_REPTILES = 15;
	public static final int BUTTON_AVES = 16;

	public GuiDNADecoderTreePage(GuiDNADecoder gui)
	{
		super(gui, GuiDNADecoder.PAGE_TREE, 256, 256, GuiDNADecoderTreePage.GUI_TEXTURE);
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_MONERA, this.guiLeft + 175, this.guiTop + 175, 	0, 0, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_PROTISTA, this.guiLeft + 155, this.guiTop + 155, 	0, 48, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_FUNGI, this.guiLeft + 30, this.guiTop + 175, 		0, 72, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_BRYOPHYTA, this.guiLeft + 70, this.guiTop + 100, 	0, 96, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_PTERIDOPHYTA, this.guiLeft + 45, this.guiTop + 150, 0, 120, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_GYMNOSPERM, this.guiLeft + 20, this.guiTop + 130,	 72, 0, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_ANGIOSPERM, this.guiLeft + 30, this.guiTop + 100,	 72, 24, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_PORIFERA, this.guiLeft + 200, this.guiTop + 150, 	72, 48, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_CNIDARIA, this.guiLeft + 140, this.guiTop + 110, 	72, 72, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_ARTHROPODA, this.guiLeft + 195, this.guiTop + 95,	 72, 96, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_MOLLUSCA, this.guiLeft + 170, this.guiTop + 120,	 72, 120, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_ECHINODERMATA, this.guiLeft + 180, this.guiTop + 40, 144, 0, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_FISH, this.guiLeft + 140, this.guiTop + 55,		 144, 24, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_AMPHIBIANS, this.guiLeft + 100, this.guiTop + 65, 	144, 48, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_MAMMALS, this.guiLeft + 80, this.guiTop + 25, 		144, 72, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_REPTILES, this.guiLeft + 40, this.guiTop + 60, 	144, 96, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.buttonList.add(new GuiImageButtonH(GuiDNADecoderTreePage.BUTTON_AVES, this.guiLeft + 30, this.guiTop + 30, 		144, 120, 24, 24, GuiDNADecoderTreePage.GUI_TEXTURE_WIDGETS));
		this.updateButtons(gui);
	}

	public void updateButtons(GuiPages gui)
	{
		for(GuiButton button : this.buttonList)
			button.enabled = false;
		
		for(DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			switch(deExtincted.getTypeOfLife())
			{
				case AMPHIBIANS: //p³azy
					this.buttonList.get(BUTTON_AMPHIBIANS).enabled = true;
					break;
				case ANGIOSPERM: //okrytonasienne
					this.buttonList.get(BUTTON_ANGIOSPERM).enabled = true;
					break;
				case ARTHROPODA: //stawonogi
					this.buttonList.get(BUTTON_ARTHROPODA).enabled = true;
					break;
				case AVES: //ptaki
					this.buttonList.get(BUTTON_AVES).enabled = true;
					break;
				case BRYOPHYTA: //mchlaki
					this.buttonList.get(BUTTON_BRYOPHYTA).enabled = true;
					break;
				case CNIDARIA: //parzyde³kowce
					this.buttonList.get(BUTTON_CNIDARIA).enabled = true;
					break;
				case ECHINODERMATA: //rozgwiazdy
					this.buttonList.get(BUTTON_ECHINODERMATA).enabled = true;
					break;
				case FISH: //ryby
					this.buttonList.get(BUTTON_FISH).enabled = true;
					break;
				case FUNGI: //grzyby
					this.buttonList.get(BUTTON_FUNGI).enabled = true;
					break;
				case GYMNOSPERM: //szyszynioe
					this.buttonList.get(BUTTON_GYMNOSPERM).enabled = true;
					break;
				case MAMMALS: //ssaki
					this.buttonList.get(BUTTON_MAMMALS).enabled = true;
					break;
				case MOLLUSCA: //miêczaki
					this.buttonList.get(BUTTON_MOLLUSCA).enabled = true;
					break;
				case MONERA: //komórki
					this.buttonList.get(BUTTON_MONERA).enabled = true;
					break;
				case PORIFERA: //g¹bki
					this.buttonList.get(BUTTON_PORIFERA).enabled = true;
					break;
				case PROTISTA: //protisty
					this.buttonList.get(BUTTON_PROTISTA).enabled = true;
					break;
				case PTERIDOPHYTA: //paprotniki
					this.buttonList.get(BUTTON_PTERIDOPHYTA).enabled = true;
					break;
				case REPTILES: //jaszczurki
					this.buttonList.get(BUTTON_REPTILES).enabled = true;
					break;
			}
		}
	}

	@Override
	public void updateInventory(List<Slot> inventorySlots)
	{
		for (Slot slot : inventorySlots)
		{
			if (slot instanceof SlotSwitchable)
				((SlotSwitchable) slot).setState(false);
		}
	}

	@Override
	public void actionPerformed(GuiPages gui, GuiButton button) throws IOException
	{
		if (button.id == GuiDNADecoderTreePage.BUTTON_AVES)
			gui.changePage(GuiDNADecoder.PAGE_DECODING);
		if (button.id == GuiDNADecoderTreePage.BUTTON_REPTILES)
			gui.changePage(GuiDNADecoder.PAGE_DECODING);
		if (button.id == GuiDNADecoderTreePage.BUTTON_MAMMALS)
			gui.changePage(GuiDNADecoder.PAGE_DECODING);
		if (button.id == GuiDNADecoderTreePage.BUTTON_GYMNOSPERM)
			gui.changePage(GuiDNADecoder.PAGE_DECODING);
		if (button.id == GuiDNADecoderTreePage.BUTTON_PTERIDOPHYTA)
			gui.changePage(GuiDNADecoder.PAGE_DECODING);
		
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