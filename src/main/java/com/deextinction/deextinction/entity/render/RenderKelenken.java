package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivorousBirds.EntityKelenken;
import com.deextinction.deextinction.entity.model.cenozoic.ModelKelenken;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKelenken extends RenderLiving<EntityKelenken>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/kelenkenmale.png");
	
	public RenderKelenken(RenderManager manager)
	{
		super(manager, new ModelKelenken(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityKelenken entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityKelenken entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
