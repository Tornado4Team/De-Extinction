package com.deextinction.util;

import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;

public class SampleTag
{
	public static final String NBT_TAG_SAMPLER = "Sampler";
	public static final String NBT_TAG_NAME = "Name";
	public static final String NBT_TAG_DNA = "Dna";
	public static final String NBT_TAG_HEALTH = "Health";
	public static final String NBT_TAG_AGE = "Age";
	public static final String NBT_TAG_GENDER = "Gender";

	private String sampler;
	private String name;
	private String dna;
	private String health;
	private String age;
	private String gender;

	public String getSampler()
	{
		return this.sampler;
	}

	public String getName()
	{
		return this.name;
	}

	public String getDna()
	{
		return this.dna;
	}

	public String getHealth()
	{
		return this.health;
	}

	public String getAge()
	{
		return this.age;
	}

	public String getGender()
	{
		return this.gender;
	}

	public void removeTag()
	{
		this.sampler = null;
		this.name = null;
		this.dna = null;
		this.health = null;
		this.age = null;
		this.gender = null;
	}

	public void setTag(NBTTagCompound tag)
	{
		if (tag.hasKey(SampleTag.NBT_TAG_SAMPLER))
			this.sampler = tag.getString(SampleTag.NBT_TAG_SAMPLER);
		if (tag.hasKey(SampleTag.NBT_TAG_NAME))
			this.name = tag.getString(SampleTag.NBT_TAG_NAME);
		if (tag.hasKey(SampleTag.NBT_TAG_DNA))
			this.dna = tag.getString(SampleTag.NBT_TAG_DNA);
		if (tag.hasKey(SampleTag.NBT_TAG_HEALTH))
			this.health = tag.getString(SampleTag.NBT_TAG_HEALTH);
		if (tag.hasKey(SampleTag.NBT_TAG_AGE))
			this.age = tag.getString(SampleTag.NBT_TAG_AGE);
		if (tag.hasKey(SampleTag.NBT_TAG_GENDER))
			this.gender = tag.getString(SampleTag.NBT_TAG_GENDER);
	}

	public HashMap<String, String> getTags()
	{
		HashMap<String, String> tags = new HashMap<String, String>();
		tags.put(SampleTag.NBT_TAG_SAMPLER, this.sampler);
		tags.put(SampleTag.NBT_TAG_NAME, this.name);
		tags.put(SampleTag.NBT_TAG_DNA, this.dna);
		tags.put(SampleTag.NBT_TAG_HEALTH, this.health);
		tags.put(SampleTag.NBT_TAG_AGE, this.age);
		tags.put(SampleTag.NBT_TAG_GENDER, this.gender);
		return tags;
	}
}
