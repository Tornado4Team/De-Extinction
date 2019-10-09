package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelKelenken;
import com.deextinction.entity.animal.EntityKelenken;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKelenken extends RenderLiving<EntityKelenken>
{

	public RenderKelenken(RenderManager renderManager)
	{
		super(renderManager, new ModelKelenken(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityKelenken animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityKelenken entity)
	{
		return entity.getTexture();
	}
}
