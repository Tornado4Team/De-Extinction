package com.deextinction.client.renderer.entity.layers;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerHeldItemAnimal implements LayerRenderer<EntityDeExtinctedAnimal>
{
	protected final RenderLivingBase<?> animalRenderer;

	public LayerHeldItemAnimal(RenderLivingBase<?> animalRenderer)
	{
		this.animalRenderer = animalRenderer;
	}

	@Override
	public void doRenderLayer(EntityDeExtinctedAnimal animal, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
	{
		ItemStack heldStack = animal.getHeldItemMainhand();

		if (!heldStack.isEmpty())
		{
			GlStateManager.pushMatrix();

			GlStateManager.translate(0.0F, 1.501F, 0.0F);

			this.renderHeldItem(animal, heldStack, ItemCameraTransforms.TransformType.GROUND);
			GlStateManager.popMatrix();
		}
	}

	private void renderHeldItem(EntityDeExtinctedAnimal animal, ItemStack heldStack, ItemCameraTransforms.TransformType transformType)
	{
		if (!heldStack.isEmpty())
		{
			GlStateManager.pushMatrix();

			float headRotation = MathHelper.clamp((animal.renderYawOffset - animal.rotationYawHead) / 180.0F, -1.0F, 1.0F);
			float naturalMovement = MathHelper.sin(animal.ticksExisted * 0.2F * 0.375F);
			float growthScale = 1.0F;
			if (animal.isAdult())
				growthScale = (float) animal.getAttributes().getScaleAdult().interpolate((int) animal.getGrowthStage(), (int) animal.getMaxGrowthStage());
			else
				growthScale = (float) animal.getAttributes().getScaleBaby().interpolate((int) animal.getGrowthStage(), (int) animal.getMaxGrowthStage());

			GlStateManager.translate(0.075F + 0.5F * headRotation, -0.7F * animal.getMaxHeight() + naturalMovement * 0.0175F, -1.5F * animal.getMaxWidth());
			GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(-45.0F, 0.0F, 0.0F, 1.0F);

			Minecraft.getMinecraft().getItemRenderer().renderItemSide(animal, heldStack, transformType, true);
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return false;
	}
}
