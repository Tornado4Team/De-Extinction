package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityRafa;
import com.deextinction.deextinction.entity.model.defectum.ModelRafa;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderRafa extends RenderLiving<EntityRafa>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/rafa.png");
	
	public RenderRafa(RenderManager manager)
	{
		super(manager, new ModelRafa(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityRafa entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityRafa entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
