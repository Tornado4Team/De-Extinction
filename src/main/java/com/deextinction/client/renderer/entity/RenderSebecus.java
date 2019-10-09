package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelSebecus;
import com.deextinction.entity.animal.EntitySebecus;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSebecus extends RenderLiving<EntitySebecus>
{

	public RenderSebecus(RenderManager renderManager)
	{
		super(renderManager, new ModelSebecus(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntitySebecus animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySebecus entity)
	{
		return entity.getTexture();
	}
}
