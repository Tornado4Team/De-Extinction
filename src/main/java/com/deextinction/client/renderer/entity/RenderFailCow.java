package com.deextinction.client.renderer.entity;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.entity.model.ModelCowFail;
import com.deextinction.entity.fail.EntityCowFail;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFailCow extends RenderLiving<EntityCowFail>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(DeExtinction.MODID, "textures/entities/fails/cow_fail.png");

	public RenderFailCow(RenderManager renderManager)
	{
		super(renderManager, new ModelCowFail(), 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCowFail entity)
	{
		return RenderFailCow.TEXTURE;
	}
}
