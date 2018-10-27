package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.cenozoic.Reptiles.EntitySebecus;
import com.deextinction.deextinction.entity.model.cenozoic.ModelSebecus;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSebecus extends RenderLiving<EntitySebecus>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/sebecus.png");
	
	public RenderSebecus(RenderManager manager)
	{
		super(manager, new ModelSebecus(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntitySebecus entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntitySebecus entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
