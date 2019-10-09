package com.deextinction.client.renderer.entity;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.entity.model.ModelChickenFail;
import com.deextinction.entity.fail.EntityChickenFail;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFailChicken extends RenderLiving<EntityChickenFail>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(DeExtinction.MODID, "textures/entities/fails/chicken_fail.png");

	public RenderFailChicken(RenderManager renderManager)
	{
		super(renderManager, new ModelChickenFail(), 0.3F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityChickenFail entity)
	{
		return RenderFailChicken.TEXTURE;
	}
}
