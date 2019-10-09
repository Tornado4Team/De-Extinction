package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelCanisNehringi;
import com.deextinction.entity.animal.EntityCanisNehringi;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCanisNehringi extends RenderLiving<EntityCanisNehringi>
{

	public RenderCanisNehringi(RenderManager renderManager)
	{
		super(renderManager, new ModelCanisNehringi(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityCanisNehringi animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCanisNehringi entity)
	{
		return entity.getTexture();
	}
}
