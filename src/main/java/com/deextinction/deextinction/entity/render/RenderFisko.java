package com.deextinction.deextinction.entity.render;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.entity.creature.defectum.EntityFisko;
import com.deextinction.deextinction.entity.model.defectum.ModelFisko;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFisko extends RenderLiving<EntityFisko>

{

	public static final ResourceLocation TEXTURES = new ResourceLocation(Deextinction.MODID + ":" + "textures/entity/fisko.png");
	
	public RenderFisko(RenderManager manager)
	{
		super(manager, new ModelFisko(), 0.5F);
	
	}

	@Override 
	protected ResourceLocation getEntityTexture(EntityFisko entity)
	{
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityFisko entityLiving, float p_77043_2_, float rotationYaw, float partialTicks)
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
	
	
}
