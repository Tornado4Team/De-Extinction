package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityCreepy;
import com.deextinction.deextinction.entity.model.defectum.ModelCreepy;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCreepy extends RenderLiving<EntityCreepy>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/creepy.png");
	
	public RenderCreepy(RenderManager manager)
	{
		super(manager, new ModelCreepy(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityCreepy entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityCreepy entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
