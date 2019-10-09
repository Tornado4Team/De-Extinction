package com.deextinction.database;

import com.deextinction.DeExtinction;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

public class AnimalTexture
{
	private String textureName;
	private int textureID;
	private ResourceLocation resourceLocation;

	public AnimalTexture(int textureID, String animalName, String gender)
	{
		this.textureName = animalName + "_" + gender + "_texture_" + textureID;
		this.textureID = textureID;
		this.resourceLocation = new ResourceLocation(DeExtinction.MODID, "textures/entities/animals/" + animalName + "/" + this.textureName + ".png");
	}

	public String getTextureName()
	{
		return I18n.translateToLocal("entity." + this.textureName);
	}

	public String getTextureUnlocalizedName()
	{
		return "entity." + this.textureName + ".name";
	}

	public int getTextureID()
	{
		return this.textureID;
	}

	public ResourceLocation getResourceLocation()
	{
		return this.resourceLocation;
	}
}
