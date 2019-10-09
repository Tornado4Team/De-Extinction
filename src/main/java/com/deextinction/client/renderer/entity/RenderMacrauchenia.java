package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelMacrauchenia;
import com.deextinction.entity.animal.EntityMacrauchenia;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMacrauchenia extends RenderLiving<EntityMacrauchenia>
{

	public RenderMacrauchenia(RenderManager renderManager)
	{
		super(renderManager, new ModelMacrauchenia(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityMacrauchenia animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityMacrauchenia entity)
	{
		return entity.getTexture();
	}
}
