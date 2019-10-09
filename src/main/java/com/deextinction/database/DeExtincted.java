package com.deextinction.database;

import com.deextinction.init.DeItems;

import net.minecraft.item.ItemStack;

public abstract class DeExtincted
{
	protected String unlocalizedName;

	public DeExtincted(String unlocalizedName)
	{
		this.unlocalizedName = unlocalizedName;
	}

	public String getName()
	{
		return this.unlocalizedName;
	}

	public String getUnlocalizedName()
	{
		return this.unlocalizedName + ".name";
	}

	public float getSpawnWeight()
	{
		return 1.0F;
	}

	public int getResearchNeeded()
	{
		return 5;
	}

	public FossilRenderInfo getFossilInfo()
	{
		return null;
	}

	public ItemStack getFossilItemDirty()
	{
		return new ItemStack(DeItems.fossils_dirty.get(this.getName()));
	}

	public ItemStack getFossilItemClean()
	{
		return new ItemStack(DeItems.fossils_clean.get(this.getName()));
	}

	public ItemStack getDNABottle()
	{
		return new ItemStack(DeItems.dna_bottles.get(this.getName()));
	}

	public ItemStack getFloppyDisk()
	{
		return new ItemStack(DeItems.dna_floppy_disks.get(this.getName()));
	}

	public final String displayName()
	{
		return "entity." + this.unlocalizedName + ".name";
	}

	public final String displayEra()
	{
		return this.getGeologicEra().displayName();
	}

	public final String displayWorldLocation()
	{
		return "entity." + this.unlocalizedName + ".where";
	}

	public abstract ItemStack getPrecursorItem();

	public abstract ItemStack getResultItem(String dna);

	public abstract GeologicEra getGeologicEra();

	public abstract TypeOfLife getTypeOfLife();
}
