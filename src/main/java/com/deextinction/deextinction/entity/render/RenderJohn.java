package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityJohn;
import com.deextinction.deextinction.entity.model.defectum.ModelJohn;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderJohn extends RenderLiving<EntityJohn>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/john.png");
	
	public RenderJohn(RenderManager manager)
	{
		super(manager, new ModelJohn(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityJohn entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityJohn entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
