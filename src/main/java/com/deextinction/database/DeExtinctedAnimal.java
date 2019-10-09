package com.deextinction.database;

import java.util.HashMap;

import com.deextinction.DeExtinction;

import net.minecraft.entity.EntityCreature;
import net.minecraft.world.World;

public abstract class DeExtinctedAnimal extends DeExtincted
{
	protected HashMap<Integer, AnimalTexture> listTextureMale = new HashMap<Integer, AnimalTexture>();
	protected HashMap<Integer, AnimalTexture> listTextureFemale = new HashMap<Integer, AnimalTexture>();
	protected AnimalAttributes attributes = new AnimalAttributes();

	public DeExtinctedAnimal(String unlocalizedName)
	{
		super(unlocalizedName);
	}

	public void initAnimal()
	{
		this.initAttributes();
		this.initTexturesMale();
		this.initTexturesFemale();
	}

	public String getUnlocalizedName()
	{
		return "entity." + this.unlocalizedName + ".name";
	}

	public AnimalAttributes getAttributes()
	{
		return this.attributes;
	}

	public HashMap<Integer, AnimalTexture> getMaleAnimalTextures()
	{
		return this.listTextureMale;
	}

	public HashMap<Integer, AnimalTexture> getFemaleAnimalTextures()
	{
		return this.listTextureFemale;
	}

	public void registerTextureMale(int textureID)
	{
		AnimalTexture texture = new AnimalTexture(textureID, this.getName(), "male");
		if (this.listTextureMale != null)
		{
			if (!this.listTextureMale.containsValue(texture))
			{
				if (!this.listTextureMale.containsKey(textureID))
					this.listTextureMale.put(textureID, texture);
				else
					DeExtinction.logger.error("Male texture with  id '" + textureID + "' was already registed in the " + this.unlocalizedName + " class. THIS IS A BUG!");
			}
			else
				DeExtinction.logger.error("Male texture with  name '" + this.getName() + "' was already registed in the " + this.unlocalizedName + " class. THIS IS A BUG!");
		}
		else
			DeExtinction.logger.error("ListTextureFemale was null in the " + this.unlocalizedName + " class. THIS IS A BUG!");
	}

	public void registerTextureFemale(int textureID)
	{
		AnimalTexture texture = new AnimalTexture(textureID, this.getName(), "female");
		if (this.listTextureFemale != null)
		{
			if (!this.listTextureFemale.containsValue(texture))
			{
				if (!this.listTextureFemale.containsKey(textureID))
					this.listTextureFemale.put(textureID, texture);
				else
					DeExtinction.logger.error("Male texture with  id '" + textureID + "' was already registed in the " + this.unlocalizedName + " class. THIS IS A BUG!");
			}
			else
				DeExtinction.logger.error("Male texture with  name '" + this.getName() + "' was already registed in the " + this.unlocalizedName + " class. THIS IS A BUG!");
		}
		else
			DeExtinction.logger.error("ListTextureFemale was null in the " + this.unlocalizedName + " class. THIS IS A BUG!");
	}

	public final String displayHeight()
	{
		return "entity." + this.unlocalizedName + ".height";
	}

	public final String displayLength()
	{
		return "entity." + this.unlocalizedName + ".length";
	}

	public final String displayWeight()
	{
		return "entity." + this.unlocalizedName + ".weight";
	}

	public final String displayDiet()
	{
		return "entity." + this.unlocalizedName + ".diet";
	}

	public abstract EntityCreature getEntity(World worldIn);

	public abstract String getEntityName();

	public abstract void initTexturesMale();

	public abstract void initTexturesFemale();

	public abstract void initAttributes();
}
