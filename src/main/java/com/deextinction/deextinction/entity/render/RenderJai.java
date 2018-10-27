package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityJai;
import com.deextinction.deextinction.entity.model.defectum.ModelJai;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderJai extends RenderLiving<EntityJai>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/jai.png");
	
	public RenderJai(RenderManager manager)
	{
		super(manager, new ModelJai(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityJai entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityJai entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
