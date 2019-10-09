package com.deextinction.client.renderer.entity;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.entity.model.ModelSheepFail;
import com.deextinction.entity.fail.EntitySheepFail;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFailSheep extends RenderLiving<EntitySheepFail>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(DeExtinction.MODID, "textures/entities/fails/sheep_fail.png");

	public RenderFailSheep(RenderManager renderManager)
	{
		super(renderManager, new ModelSheepFail(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySheepFail entity)
	{
		return RenderFailSheep.TEXTURE;
	}
}
