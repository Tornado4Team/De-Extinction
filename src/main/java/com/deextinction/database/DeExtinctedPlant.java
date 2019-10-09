package com.deextinction.database;

public abstract class DeExtinctedPlant extends DeExtincted
{
	public DeExtinctedPlant(String unlocalizedName)
	{
		super(unlocalizedName);
	}

	@Override
	public String getUnlocalizedName()
	{
		return "tile." + this.unlocalizedName + ".name";
	}

	public final String displayHeight()
	{
		return "entity." + this.unlocalizedName + ".height";
	}
}
