package com.deextinction.client.gui;

import org.lwjgl.util.Rectangle;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.inventory.GuiMicroscope;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class GuiEntityBlood extends GuiEntityLiving
{
	private static final ResourceLocation CELL_TEXTURES = new ResourceLocation(DeExtinction.MODID, "textures/gui/microscope/gui_blood_cells.png");

	public GuiEntityBlood(int id, int textureX, int textureY, int textureWidth, int textureHeight, int textureAnimMax, double posX, double posY, double velocity, double velocityMax, double acceleration, double yaw, double yawVelocityMax, double yawAcceleration)
	{
		super(id, textureX, textureY, textureWidth, textureHeight, textureAnimMax, posX, posY, velocity, velocityMax, acceleration, yaw, yawVelocityMax, yawAcceleration);
	}

	@Override
	public void tick(GuiMicroscope gui)
	{
		this.handleAnimationRandomly(200);
		this.handleMovement(gui.getFriction(), gui.getGuiLeft() + gui.getBorderLeft(), gui.getGuiTop() + gui.getBorderTop(), gui.getGuiLeft() + gui.getXSize() - gui.getBorderRight(), gui.getGuiTop() + gui.getYSize() - gui.getBorderBottom());
	}

	@Override
	public void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		FontRenderer fontrenderer = mc.fontRenderer;
		mc.getTextureManager().bindTexture(GuiEntityBlood.CELL_TEXTURES);
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.enableBlend();
		GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
		this.drawTexturedModalRectDouble(this.posX, this.posY, this.textureX, this.textureY + this.textureHeight * this.textureAnim, this.textureWidth, this.textureHeight);
	}

	public void drawTexturedModalRectDouble(double x, double y, int textureX, int textureY, int width, int height)
	{
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
		bufferbuilder.pos(x, y + height, (double) this.zLevel).tex((double) ((float) (textureX + 0) * 0.00390625F), (double) ((float) (textureY + height) * 0.00390625F)).endVertex();
		bufferbuilder.pos(x + width, y + height, (double) this.zLevel).tex((double) ((float) (textureX + width) * 0.00390625F), (double) ((float) (textureY + height) * 0.00390625F)).endVertex();
		bufferbuilder.pos(x + width, y, (double) this.zLevel).tex((double) ((float) (textureX + width) * 0.00390625F), (double) ((float) (textureY + 0) * 0.00390625F)).endVertex();
		bufferbuilder.pos(x, y, (double) this.zLevel).tex((double) ((float) (textureX + 0) * 0.00390625F), (double) ((float) (textureY + 0) * 0.00390625F)).endVertex();
		tessellator.draw();
	}

	@Override
	public Rectangle getBounds()
	{
		return new Rectangle((int) this.posX, (int) this.posY, 8, 8);
	}
}
