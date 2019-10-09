package com.deextinction.client.renderer.entity;

import com.deextinction.client.renderer.entity.model.ModelArchaeorhynchus;
import com.deextinction.entity.animal.EntityArchaeorhynchus;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArchaeorhynchus extends RenderLiving<EntityArchaeorhynchus>
{

	public RenderArchaeorhynchus(RenderManager renderManager)
	{
		super(renderManager, new ModelArchaeorhynchus(), 0.5F);
	}

	@Override
	protected void preRenderCallback(EntityArchaeorhynchus animal, float partialTickTime)
	{
		float scale = animal.getModelScale();
		this.shadowSize = 0.5F * scale;
		GlStateManager.scale(scale, scale, scale);
	}

	@Override
	protected void applyRotations(EntityArchaeorhynchus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityArchaeorhynchus entity)
	{
		return entity.getTexture();
	}
}
