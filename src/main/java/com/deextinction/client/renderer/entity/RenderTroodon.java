package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelTroodon;
import com.deextinction.entity.animal.EntityTroodon;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTroodon extends RenderLiving<EntityTroodon>
{

	public RenderTroodon(RenderManager renderManager)
	{
		super(renderManager, new ModelTroodon(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityTroodon animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTroodon entity)
	{
		return entity.getTexture();
	}
}
