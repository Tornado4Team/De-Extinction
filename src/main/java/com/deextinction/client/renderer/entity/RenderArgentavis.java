package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelArgentavis;
import com.deextinction.entity.animal.EntityArgentavis;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArgentavis extends RenderLiving<EntityArgentavis>
{

	public RenderArgentavis(RenderManager renderManager)
	{
		super(renderManager, new ModelArgentavis(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityArgentavis animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityArgentavis entity)
	{
		return entity.getTexture();
	}
}
