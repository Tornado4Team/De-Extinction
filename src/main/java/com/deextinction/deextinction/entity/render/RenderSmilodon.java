package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivoresMammals.EntitySmilodon;
import com.deextinction.deextinction.entity.creature.cenozoic.CarnivorousBirds.EntityKelenken;
import com.deextinction.deextinction.entity.model.cenozoic.ModelKelenken;
import com.deextinction.deextinction.entity.model.cenozoic.ModelSmilodon;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSmilodon extends RenderLiving<EntitySmilodon>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/smilodonmale.png");
	
	public RenderSmilodon(RenderManager manager)
	{
		super(manager, new ModelSmilodon(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntitySmilodon entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntitySmilodon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
