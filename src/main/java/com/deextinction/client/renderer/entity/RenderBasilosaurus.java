package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelBasilosaurus;
import com.deextinction.entity.animal.EntityBasilosaurus;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBasilosaurus extends RenderLiving<EntityBasilosaurus>
{

	public RenderBasilosaurus(RenderManager renderManager)
	{
		super(renderManager, new ModelBasilosaurus(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityBasilosaurus animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityBasilosaurus entity)
	{
		return entity.getTexture();
	}
}
