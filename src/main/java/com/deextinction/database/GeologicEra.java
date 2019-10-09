package com.deextinction.database;

public enum GeologicEra
{
	CENOZOIC(0, "cenozoic"),
	MESOZOIC(1, "mesozoic"),
	PALEOZOIC(2, "paleozoic");

	private GeologicEra(int metadata, String unlocalizedName)
	{
		this.metadata = metadata;
		this.unlocalizedName = unlocalizedName;
	}

	public int getMetadata()
	{
		return this.metadata;
	}

	public String displayName()
	{
		return "era." + this.unlocalizedName + ".name";
	}

	public String getUnlocalizedName()
	{
		return this.unlocalizedName;
	}

	private final int metadata;
	private final String unlocalizedName;
}
