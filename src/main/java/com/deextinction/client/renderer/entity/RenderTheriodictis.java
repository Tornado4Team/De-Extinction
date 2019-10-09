package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelTheriodictis;
import com.deextinction.entity.animal.EntityTheriodictis;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTheriodictis extends RenderLiving<EntityTheriodictis>
{

	public RenderTheriodictis(RenderManager renderManager)
	{
		super(renderManager, new ModelTheriodictis(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityTheriodictis animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityTheriodictis entity)
	{
		return entity.getTexture();
	}
}
