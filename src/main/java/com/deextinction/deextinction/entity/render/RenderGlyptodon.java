package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.cenozoic.HerbMammals.EntityGlyptodon;
import com.deextinction.deextinction.entity.model.cenozoic.ModelGlyptodon;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGlyptodon extends RenderLiving<EntityGlyptodon>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/glyptodon.png");
	
	public RenderGlyptodon(RenderManager manager)
	{
		super(manager, new ModelGlyptodon(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityGlyptodon entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityGlyptodon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
