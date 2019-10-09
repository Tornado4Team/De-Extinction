package com.deextinction.client.gui.inventory;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.block.machines.BlockMicroscope.MicroscopeSample;
import com.deextinction.client.gui.GuiBase;
import com.deextinction.client.gui.GuiEntityBlood;
import com.deextinction.client.gui.GuiEntityLiving;
import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageMicroscopeSample;
import com.deextinction.tileentities.TileMicroscope;
import com.deextinction.tileentities.containers.ContainerMicroscope;
import com.deextinction.tileentities.containers.SlotSwitchable;
import com.deextinction.util.SampleTag;
import com.google.common.collect.Lists;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiMicroscope extends GuiBase
{
	private static final ResourceLocation GUI_TEXTURE_MAIN = new ResourceLocation(DeExtinction.MODID, "textures/gui/microscope/gui_microscope.png");
	private static final ResourceLocation GUI_TEXTURE_SLIDE_BACKGROUND = new ResourceLocation(DeExtinction.MODID, "textures/gui/microscope/gui_microscope_slide_background.png");
	private static final ResourceLocation GUI_TEXTURE_SLIDE_FOREGROUND = new ResourceLocation(DeExtinction.MODID, "textures/gui/microscope/gui_microscope_slide_foreground.png");
	private static final Random RANDOM = new Random();
	private static final int GUI_BUTTON_VIEW = 0;

	protected List<GuiEntityLiving> listOfCells = Lists.<GuiEntityLiving> newArrayList();

	private final InventoryPlayer playerInventory;
	private TileMicroscope microscope;
	private int guiTick;

	public GuiMicroscope(InventoryPlayer playerInventory, TileMicroscope microscope)
	{
		super(new ContainerMicroscope(playerInventory, microscope));
		this.playerInventory = playerInventory;
		this.microscope = microscope;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		this.listOfCells.clear();
		this.buttonList.clear();

		if (this.microscope.isAnalyzing())
		{
			this.xSize = 256;
			this.ySize = 202;
			this.guiLeft = (this.width - this.xSize) / 2;
			this.guiTop = (this.height - this.ySize) / 2;

			for (Slot slot : this.inventorySlots.inventorySlots)
			{
				if (slot instanceof SlotSwitchable)
					((SlotSwitchable) slot).setState(false);
			}

			String buttonText = I18n.translateToLocal("container.microscope.remove");
			this.buttonList.add(new GuiButton(GuiMicroscope.GUI_BUTTON_VIEW, this.guiLeft + this.xSize / 2 - (this.getTextSize(buttonText) + 20) / 2, this.guiTop + 175, this.getTextSize(buttonText) + 20, 20, buttonText));

			this.createSlide();
		}
		else
		{
			this.xSize = 176;
			this.ySize = 256;
			this.guiLeft = (this.width - this.xSize) / 2;
			this.guiTop = (this.height - this.ySize) / 2;

			for (Slot slot : this.inventorySlots.inventorySlots)
			{
				if (slot instanceof SlotSwitchable)
					((SlotSwitchable) slot).setState(true);
			}

			String buttonText = I18n.translateToLocal("container.microscope.view");
			this.buttonList.add(new GuiButton(GuiMicroscope.GUI_BUTTON_VIEW, this.guiLeft + this.xSize / 2 - (this.getTextSize(buttonText) + 20) / 2, this.guiTop + 123, this.getTextSize(buttonText) + 20, 20, buttonText));
			this.buttonList.get(GuiMicroscope.GUI_BUTTON_VIEW).enabled = this.microscope.shouldAnalyze();

			this.removeSlide();
		}
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		switch (button.id)
		{
			case GuiMicroscope.GUI_BUTTON_VIEW:

				if (!this.microscope.isAnalyzing())
				{
					this.microscope.setSample();
					BlockPos pos = this.microscope.getPos();
					DeMessages.wrapper.sendToServer(new MessageMicroscopeSample(true, pos.getX(), pos.getY(), pos.getZ()));

					if (this.microscope.isAnalyzing())
					{
						this.xSize = 256;
						this.ySize = 202;
						this.guiLeft = (this.width - this.xSize) / 2;
						this.guiTop = (this.height - this.ySize) / 2;

						for (Slot slot : this.inventorySlots.inventorySlots)
						{
							if (slot instanceof SlotSwitchable)
								((SlotSwitchable) slot).setState(false);
						}

						String buttonText = I18n.translateToLocal("container.microscope.remove");
						button.displayString = buttonText;
						button.x = this.guiLeft + this.xSize / 2 - (this.getTextSize(buttonText) + 20) / 2;
						button.y = this.guiTop + 175;
						button.width = this.getTextSize(buttonText) + 20;

						this.createSlide();
					}
				}
				else
				{
					this.microscope.removeSample();
					BlockPos pos = this.microscope.getPos();
					DeMessages.wrapper.sendToServer(new MessageMicroscopeSample(false, pos.getX(), pos.getY(), pos.getZ()));

					this.xSize = 176;
					this.ySize = 256;
					this.guiLeft = (this.width - this.xSize) / 2;
					this.guiTop = (this.height - this.ySize) / 2;

					for (Slot slot : this.inventorySlots.inventorySlots)
					{
						if (slot instanceof SlotSwitchable)
							((SlotSwitchable) slot).setState(true);
					}

					String buttonText = I18n.translateToLocal("container.microscope.view");
					button.displayString = buttonText;
					button.x = this.guiLeft + this.xSize / 2 - (this.getTextSize(buttonText) + 20) / 2;
					button.y = this.guiTop + 123;
					button.width = this.getTextSize(buttonText) + 20;

					this.removeSlide();

					this.guiTick = 0;
				}
				break;
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks)
	{
		this.drawDefaultBackground();
		super.drawScreen(mouseX, mouseY, partialTicks);
		this.renderHoveredToolTip(mouseX, mouseY);

		if (!this.listOfCells.isEmpty())
			for (GuiEntityLiving cell : this.listOfCells)
				cell.tick(this);

		if (!this.microscope.isAnalyzing())
			this.buttonList.get(GuiMicroscope.GUI_BUTTON_VIEW).enabled = this.microscope.shouldAnalyze();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		if (this.microscope.isAnalyzing())
		{
			this.writeCenteredTextInGui(this.microscope.getName(), 6, 4210752);

			SampleTag tag = this.microscope.getSampleTag();
			if (tag != null)
			{
				int posY = 100;
				if (I18n.canTranslate(tag.getName()))
					posY = this.drawSampleText(I18n.translateToLocal("container.microscope.sample") + ": ", I18n.translateToLocal(tag.getName()), posY, 12, 4210752) + 6;
				else
					posY = this.drawSampleText(I18n.translateToLocal("container.microscope.sample") + ": ", tag.getName(), posY, 12, 4210752) + 6;

				if (this.guiTick++ < 120)
				{
					String analizingText = I18n.translateToLocal("container.microscope.analyzing");
					String analizingDots = "";
					int analizingTime = (int) (this.guiTick / 15) % 4;
					for (int i = 0; i < analizingTime; i++)
						analizingDots += ".";

					int textHalfWidth = this.fontRenderer.getStringWidth(analizingText) / 2;
					this.fontRenderer.drawString(analizingText + analizingDots, this.xSize / 2 - textHalfWidth, posY, 4210752);
					posY += 12;
				}
				else
				{
					if (this.guiTick > 140)
						posY = this.drawSampleText(I18n.translateToLocal("container.microscope.dna") + ": ", tag.getDna(), posY, 12, 4210752);

					if (this.guiTick > 160)
						posY = this.drawSampleText(I18n.translateToLocal("container.microscope.health") + ": ", I18n.translateToLocal(tag.getHealth()), posY, 12, 4210752);

					if (this.guiTick > 180)
					{
						if (tag.getAge() == "1")
							posY = this.drawSampleText(I18n.translateToLocal("container.microscope.age") + ": ", tag.getAge() + " " + I18n.translateToLocal("entity.creature.day"), posY, 12, 4210752);
						else
							posY = this.drawSampleText(I18n.translateToLocal("container.microscope.age") + ": ", tag.getAge() + " " + I18n.translateToLocal("entity.creature.days"), posY, 12, 4210752);
					}

					if (this.guiTick > 200)
						posY = this.drawSampleText(I18n.translateToLocal("container.microscope.gender") + ": ", I18n.translateToLocal(tag.getGender()), posY, 12, 4210752);
				}
			}
		}
		else
		{
			this.writeText(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
		}
	}

	private int drawSampleText(String text, String value, int posY, int dY, int color)
	{
		if (value != null && !value.isEmpty())
		{
			this.writeCenteredTextInGui(text + value, posY, color);
			return posY + dY;
		}
		return posY;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		if (this.microscope.isAnalyzing())
		{
			this.mc.getTextureManager().bindTexture(GuiMicroscope.GUI_TEXTURE_SLIDE_BACKGROUND);
			this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

			this.drawGuiContainerSlideLayer(partialTicks, mouseX, mouseY);

			GlStateManager.enableBlend();
			this.mc.getTextureManager().bindTexture(GuiMicroscope.GUI_TEXTURE_SLIDE_FOREGROUND);
			this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
			GlStateManager.disableBlend();
		}
		else
		{
			this.mc.getTextureManager().bindTexture(GuiMicroscope.GUI_TEXTURE_MAIN);
			this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		}
	}

	private void drawGuiContainerSlideLayer(float partialTicks, int mouseX, int mouseY)
	{
		if (!this.listOfCells.isEmpty())
			for (GuiEntityLiving cell : this.listOfCells)
				cell.draw(mc, mouseX, mouseY, partialTicks);
	}

	public double getFriction()
	{
		return this.microscope.getSample().getFriction();
	}

	public int getBorderLeft()
	{
		return 16;
	}

	public int getBorderRight()
	{
		return 16;
	}

	public int getBorderTop()
	{
		return 18;
	}

	public int getBorderBottom()
	{
		return 110;
	}

	private void createSlide()
	{
		this.listOfCells.clear();
		MicroscopeSample sample = this.microscope.getSample();
		int prevNumberCells = 0;
		int numberCells = 0;
		switch (sample)
		{
			case BLOOD:
				prevNumberCells = 0;
				numberCells = 20 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getRedBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));

				prevNumberCells = numberCells;
				numberCells += 4 + GuiMicroscope.RANDOM.nextInt(5);
				for (int id = prevNumberCells; id < numberCells; id++)
					this.listOfCells.add(this.getWhiteBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));

				prevNumberCells = numberCells;
				numberCells += 3 + GuiMicroscope.RANDOM.nextInt(4);
				for (int id = prevNumberCells; id < numberCells; id++)
					this.listOfCells.add(this.getPlatelet(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case BLOOD_DECAYED:
				prevNumberCells = 0;
				numberCells = 20 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getGreenBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));

				prevNumberCells = numberCells;
				numberCells += 4 + GuiMicroscope.RANDOM.nextInt(5);
				for (int id = prevNumberCells; id < numberCells; id++)
					this.listOfCells.add(this.getWhiteBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));

				prevNumberCells = numberCells;
				numberCells += 3 + GuiMicroscope.RANDOM.nextInt(4);
				for (int id = prevNumberCells; id < numberCells; id++)
					this.listOfCells.add(this.getPlatelet(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case HEMOLYMPH:
				prevNumberCells = 0;
				numberCells = 20 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getRedBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));

				prevNumberCells = numberCells;
				numberCells += 4 + GuiMicroscope.RANDOM.nextInt(5);
				for (int id = prevNumberCells; id < numberCells; id++)
					this.listOfCells.add(this.getWhiteBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));

				prevNumberCells = numberCells;
				numberCells += 3 + GuiMicroscope.RANDOM.nextInt(4);
				for (int id = prevNumberCells; id < numberCells; id++)
					this.listOfCells.add(this.getPlatelet(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case BLOOD_ENDER:
				prevNumberCells = 0;
				numberCells = 30 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getEnderBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case BLOOD_CREEPER:
				prevNumberCells = 0;
				numberCells = 30 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getCreeperBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case BLOOD_WITHER:
				prevNumberCells = 0;
				numberCells = 30 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getRedBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case SLIME:
				prevNumberCells = 0;
				numberCells = 30 + GuiMicroscope.RANDOM.nextInt(11);
				for (int id = 0; id < numberCells; id++)
					this.listOfCells.add(this.getGreenBloodCell(id, this.guiLeft, this.guiTop, this.xSize, this.ySize, this.getBorderLeft(), this.getBorderRight(), this.getBorderTop(), this.getBorderBottom()));
				break;
			case NONE:
			default:
				break;
		}
	}

	private GuiEntityBlood getRedBloodCell(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 16, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private GuiEntityBlood getWhiteBloodCell(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 0, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private GuiEntityBlood getPlatelet(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 8, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private GuiEntityBlood getGreenBloodCell(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 24, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private GuiEntityBlood getBlackBloodCell(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 32, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private GuiEntityBlood getCreeperBloodCell(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 40, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private GuiEntityBlood getEnderBloodCell(int id, int guiLeft, int guiTop, int xSize, int ySize, int borderLeft, int borderRight, int borderTop, int borderBottom)
	{
		int size = 8;
		return new GuiEntityBlood(id, 48, 0, size, size, 5, guiLeft + borderLeft + 2 + (xSize - borderLeft - borderRight - size - 4) * GuiMicroscope.RANDOM.nextDouble(), guiTop + borderTop + 2 + (ySize - borderTop - borderBottom - size - 4) * GuiMicroscope.RANDOM.nextDouble(),
				0.1D * GuiMicroscope.RANDOM.nextDouble(), 0.1D, 0.0D, 360D * GuiMicroscope.RANDOM.nextDouble(), 0.0D, 0.0D);
	}

	private void removeSlide()
	{
		this.listOfCells.clear();
	}
}
