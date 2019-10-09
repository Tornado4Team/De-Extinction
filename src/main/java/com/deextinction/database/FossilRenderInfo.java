package com.deextinction.database;

import com.deextinction.DeExtinction;

import net.minecraft.client.model.ModelBase;
import net.minecraft.util.ResourceLocation;

public class FossilRenderInfo
{
	private ResourceLocation texture;
	private ModelBase model;
	private float scale;

	public FossilRenderInfo(ModelBase model, String textureName, float scale)
	{
		this.texture = new ResourceLocation(DeExtinction.MODID, "textures/blocks/fossils/" + textureName + ".png");
		this.model = model;
		this.scale = scale;
	}

	public ModelBase getModel()
	{
		return this.model;
	}

	public ResourceLocation getTexture()
	{
		return this.texture;
	}

	public static enum FossilTextureType
	{
		GRAY("fossil_gray"),
		BLACK("fossil_black"),
		BROWN("fossil_brown");

		private FossilTextureType(String fossil_texture_name)
		{
			this.fossil_texture_name = fossil_texture_name;
		}

		public String getName()
		{
			return this.fossil_texture_name;
		}

		private final String fossil_texture_name;
	}

	public float getScale()
	{
		return this.scale;
	}
}
