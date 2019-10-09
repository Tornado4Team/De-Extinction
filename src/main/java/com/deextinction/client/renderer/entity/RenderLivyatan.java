package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelLivyatan;
import com.deextinction.entity.animal.EntityLivyatan;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLivyatan extends RenderLiving<EntityLivyatan>
{

	public RenderLivyatan(RenderManager renderManager)
	{
		super(renderManager, new ModelLivyatan(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityLivyatan animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityLivyatan entity)
	{
		return entity.getTexture();
	}
}
