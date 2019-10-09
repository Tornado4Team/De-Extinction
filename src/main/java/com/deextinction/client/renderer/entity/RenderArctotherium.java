package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelArctotherium;
import com.deextinction.entity.animal.EntityArctotherium;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArctotherium extends RenderLiving<EntityArctotherium>
{

	public RenderArctotherium(RenderManager renderManager)
	{
		super(renderManager, new ModelArctotherium(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityArctotherium animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityArctotherium entity)
	{
		return entity.getTexture();
	}
}
