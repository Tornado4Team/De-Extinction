package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelToxodon;
import com.deextinction.entity.animal.EntityToxodon;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderToxodon extends RenderLiving<EntityToxodon>
{

	public RenderToxodon(RenderManager renderManager)
	{
		super(renderManager, new ModelToxodon(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityToxodon animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityToxodon entity)
	{
		return entity.getTexture();
	}
}
