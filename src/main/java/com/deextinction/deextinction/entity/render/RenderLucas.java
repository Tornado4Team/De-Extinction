package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityLucas;
import com.deextinction.deextinction.entity.model.defectum.ModelLucas;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderLucas extends RenderLiving<EntityLucas>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/lucas.png");
	
	public RenderLucas(RenderManager manager)
	{
		super(manager, new ModelLucas(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityLucas entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityLucas entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
