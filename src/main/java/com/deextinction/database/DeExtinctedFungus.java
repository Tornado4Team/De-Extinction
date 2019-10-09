package com.deextinction.database;

public abstract class DeExtinctedFungus extends DeExtincted
{
	public DeExtinctedFungus(String unlocalizedName)
	{
		super(unlocalizedName);
	}

	@Override
	public String getUnlocalizedName()
	{
		return "tile." + this.unlocalizedName + ".name";
	}
}
