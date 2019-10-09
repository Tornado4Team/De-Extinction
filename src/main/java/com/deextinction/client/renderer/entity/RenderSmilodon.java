package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.layers.LayerHeldItemAnimal;
import com.deextinction.client.renderer.entity.model.ModelSmilodon;
import com.deextinction.entity.animal.EntitySmilodon;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSmilodon extends RenderLiving<EntitySmilodon>
{

	public RenderSmilodon(RenderManager renderManager)
	{
		super(renderManager, new ModelSmilodon(), 0.5F);
		this.addLayer(new LayerHeldItemAnimal(this));
	}

	@Override
	protected void preRenderCallback(EntitySmilodon animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected void applyRotations(EntitySmilodon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySmilodon entity)
	{
		return entity.getTexture();
	}

	@Override
	public void transformHeldFull3DItemLayer()
	{
		GlStateManager.translate(0.0F, 0.1875F, 0.0F);
	}
}
