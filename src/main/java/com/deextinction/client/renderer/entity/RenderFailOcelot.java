package com.deextinction.client.renderer.entity;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.entity.model.ModelOcelotFail;
import com.deextinction.entity.fail.EntityOcelotFail;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFailOcelot extends RenderLiving<EntityOcelotFail>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation(DeExtinction.MODID, "textures/entities/fails/ocelot_fail.png");

	public RenderFailOcelot(RenderManager renderManager)
	{
		super(renderManager, new ModelOcelotFail(), 0.3F);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityOcelotFail entity)
	{
		return RenderFailOcelot.TEXTURE;
	}
}
