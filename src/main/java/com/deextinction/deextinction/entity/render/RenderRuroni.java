package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityRuroni;
import com.deextinction.deextinction.entity.model.defectum.ModelRuroni;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRuroni extends RenderLiving<EntityRuroni>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/ruroni.png");
	
	public RenderRuroni(RenderManager manager)
	{
		super(manager, new ModelRuroni(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityRuroni entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityRuroni entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
