package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityZeinner;
import com.deextinction.deextinction.entity.model.defectum.ModelZeinner;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderZeinner extends RenderLiving<EntityZeinner>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/zeinner.png");
	
	public RenderZeinner(RenderManager manager)
	{
		super(manager, new ModelZeinner(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityZeinner entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityZeinner entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
