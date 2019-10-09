package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelGlyptodon;
import com.deextinction.entity.animal.EntityGlyptodon;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGlyptodon extends RenderLiving<EntityGlyptodon>
{

	public RenderGlyptodon(RenderManager renderManager)
	{
		super(renderManager, new ModelGlyptodon(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityGlyptodon animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected void applyRotations(EntityGlyptodon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGlyptodon entity)
	{
		return entity.getTexture();
	}
}
