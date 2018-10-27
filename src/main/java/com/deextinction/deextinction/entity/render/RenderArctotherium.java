package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivoresMammals.EntityArctotherium;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivorousBirds.EntityKelenken;
import com.deextinction.deextinction.entity.model.cenozoic.ModelArctotherium;
import com.deextinction.deextinction.entity.model.cenozoic.ModelKelenken;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderArctotherium extends RenderLiving<EntityArctotherium>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/arctotherium.png");
	
	public RenderArctotherium(RenderManager manager)
	{
		super(manager, new ModelArctotherium(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityArctotherium entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityArctotherium entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
