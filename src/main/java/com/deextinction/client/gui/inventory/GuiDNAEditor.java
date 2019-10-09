package com.deextinction.client.gui.inventory;

import java.io.IOException;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.GuiBase;
import com.deextinction.client.gui.GuiButtonNucleobase;
import com.deextinction.client.gui.GuiToggleButton2;
import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageEditorDisallowEdit;
import com.deextinction.network.MessageEditorSetDNA;
import com.deextinction.network.MessageEditorToggleAllowEdit;
import com.deextinction.tileentities.TileDNAEditor;
import com.deextinction.tileentities.containers.ContainerDNAEditor;
import com.deextinction.util.DNA;
import com.deextinction.util.Nucleobases;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiDNAEditor extends GuiBase
{
	private static final ResourceLocation GUI_TEXTURE_MAIN = new ResourceLocation(DeExtinction.MODID, "textures/gui/gui_dna_editor.png");
	private static final int GUI_BUTTON_ID_NUCLEOBASE_1 = 0;
	private static final int GUI_BUTTON_ID_NUCLEOBASE_2 = 1;
	private static final int GUI_BUTTON_ID_NUCLEOBASE_3 = 2;
	private static final int GUI_BUTTON_ID_ALLOW = 3;

	private final InventoryPlayer playerInventory;
	private TileDNAEditor dnaEditor;

	public GuiDNAEditor(InventoryPlayer playerInventory, TileDNAEditor dna_editor)
	{
		super(new ContainerDNAEditor(playerInventory, dna_editor));
		this.playerInventory = playerInventory;
		this.dnaEditor = dna_editor;
		this.xSize = 202;
		this.ySize = 226;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		this.buttonList.clear();
		this.buttonList.add(new GuiButtonNucleobase(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_1, this.guiLeft + 79, this.guiTop + 33, 0, 226, 44, 10, this.getButtonIconFromDNALetter(Nucleobases.ADENINE.getNucleobaseLetter()), GuiDNAEditor.GUI_TEXTURE_MAIN));
		this.buttonList.add(new GuiButtonNucleobase(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_2, this.guiLeft + 79, this.guiTop + 67, 0, 226, 44, 10, this.getButtonIconFromDNALetter(Nucleobases.ADENINE.getNucleobaseLetter()), GuiDNAEditor.GUI_TEXTURE_MAIN));
		this.buttonList.add(new GuiButtonNucleobase(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_3, this.guiLeft + 79, this.guiTop + 101, 0, 226, 44, 10, this.getButtonIconFromDNALetter(Nucleobases.ADENINE.getNucleobaseLetter()), GuiDNAEditor.GUI_TEXTURE_MAIN));
		this.buttonList.add(new GuiToggleButton2(GuiDNAEditor.GUI_BUTTON_ID_ALLOW, this.guiLeft + this.xSize / 2, this.guiTop + 120, false, I18n.translateToLocal("container.dna_editor.not_editing"), I18n.translateToLocal("container.dna_editor.editing"), mc));
		this.updateButtons();
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		BlockPos pos = this.dnaEditor.getPos();
		switch (button.id)
		{
			case GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_1:
			case GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_2:
			case GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_3:
				if (button instanceof GuiButtonNucleobase)
					this.actionNucleobaseButtons((GuiButtonNucleobase) button, pos);
				break;
			case GuiDNAEditor.GUI_BUTTON_ID_ALLOW:
				this.dnaEditor.toggleAllowedToEdit();
				DeMessages.wrapper.sendToServer(new MessageEditorToggleAllowEdit(pos.getX(), pos.getY(), pos.getZ()));
				((GuiToggleButton2) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW)).toogleState();
				break;
		}
	}

	private void actionNucleobaseButtons(GuiButtonNucleobase button, BlockPos pos)
	{
		int index = button.nextImageIndex();
		DNA dna = this.dnaEditor.getNewDNA();
		if (dna != null)
		{
			char[] dnaCharArray = dna.getDNACharArray();
			switch (index)
			{
				case 0:
					dna.setNucleobase(button.id, Nucleobases.ADENINE);
					break;
				case 1:
					dna.setNucleobase(button.id, Nucleobases.THYMINE);
					break;
				case 2:
					dna.setNucleobase(button.id, Nucleobases.CYTOSINE);
					break;
				case 3:
					dna.setNucleobase(button.id, Nucleobases.GUANINE);
					break;
				default:
					dna.setNucleobase(button.id, Nucleobases.BLANK);
			}
			this.dnaEditor.setNewDNA(dna);
			DeMessages.wrapper.sendToServer(new MessageEditorSetDNA(dna, pos.getX(), pos.getY(), pos.getZ()));
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);

		this.updateButtonsIcon(this.dnaEditor.getNewDNA());
		this.updateButtons();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.writeCenteredTextInGui(this.dnaEditor.getName(), 6, 4210752);
		this.writeText(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
		this.writeCenteredTextInGui(this.dnaEditor.getWarnings(), 18, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(GuiDNAEditor.GUI_TEXTURE_MAIN);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		if (this.dnaEditor.isEditing())
		{
			if (this.dnaEditor.isEditingProgressPastMiddle())
			{
				this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + 58, 202, 0, 9, 34);
				this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + 92 - (this.dnaEditor.getEditingProgressScaled(68) - 34), 211, 34 - (this.dnaEditor.getEditingProgressScaled(68) - 34), 9, this.dnaEditor.getEditingProgressScaled(68) - 34);
			}
			else
				this.drawTexturedModalRect(this.guiLeft + 173, this.guiTop + 58, 202, 0, 9, this.dnaEditor.getEditingProgressScaled(68));
		}
	}

	private void updateButtonsIcon(DNA dna)
	{
		char[] dnaString = dna.getDNACharArray();
		((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_1)).setImageIndex(this.getButtonIconFromDNALetter(dnaString[DNA.DNA_INDEX_1]));
		((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_2)).setImageIndex(this.getButtonIconFromDNALetter(dnaString[DNA.DNA_INDEX_2]));
		((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_3)).setImageIndex(this.getButtonIconFromDNALetter(dnaString[DNA.DNA_INDEX_3]));
	}

	private void updateButtons()
	{
		boolean last_allow_state = this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW).enabled;
		if (this.dnaEditor.hasFloppyDisk())
		{
			this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW).enabled = this.dnaEditor.shouldAllowEditButton();
			((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_1)).enabled = this.dnaEditor.hasDNABottleValid(TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1);
			((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_2)).enabled = this.dnaEditor.hasDNABottleValid(TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_2);
			((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_3)).enabled = this.dnaEditor.hasDNABottleValid(TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3);

			if (last_allow_state != this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW).enabled && !this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW).enabled)
			{
				BlockPos pos = this.dnaEditor.getPos();
				this.dnaEditor.setAllowedToEdit(false);
				DeMessages.wrapper.sendToServer(new MessageEditorDisallowEdit(pos.getX(), pos.getY(), pos.getZ()));
				((GuiToggleButton2) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW)).setState(false);
			}
		}
		else
		{
			this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW).enabled = false;
			((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_1)).enabled = false;
			((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_2)).enabled = false;
			((GuiButtonNucleobase) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_3)).enabled = false;

			if (last_allow_state != this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW).enabled)
			{
				BlockPos pos = this.dnaEditor.getPos();
				this.dnaEditor.setAllowedToEdit(false);
				DeMessages.wrapper.sendToServer(new MessageEditorDisallowEdit(pos.getX(), pos.getY(), pos.getZ()));
				((GuiToggleButton2) this.buttonList.get(GuiDNAEditor.GUI_BUTTON_ID_ALLOW)).setState(false);
			}
		}
	}

	private int getDNAIndexFromButtonID(int id)
	{
		switch (id)
		{
			case GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_1:
				return DNA.DNA_INDEX_1;
			case GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_2:
				return DNA.DNA_INDEX_2;
			case GuiDNAEditor.GUI_BUTTON_ID_NUCLEOBASE_3:
				return DNA.DNA_INDEX_3;
			default:
				return -1;
		}
	}

	private int getButtonIconFromDNALetter(char letter)
	{
		switch (letter)
		{
			case 'A':
				return 0;
			case 'T':
			case 'U':
				return 1;
			case 'C':
				return 2;
			case 'G':
				return 3;
			default:
				return -1;
		}
	}
}
