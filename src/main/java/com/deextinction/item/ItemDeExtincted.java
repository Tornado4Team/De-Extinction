package com.deextinction.item;

import com.deextinction.database.DeExtincted;

import net.minecraft.creativetab.CreativeTabs;

public abstract class ItemDeExtincted extends ItemBasic
{
	protected String deExtinctedName;

	public ItemDeExtincted(DeExtincted deExtincted, CreativeTabs tab)
	{
		super(tab);
		this.deExtinctedName = deExtincted.getName();
	}

	public String getDeExtinctedName()
	{
		return this.deExtinctedName;
	}
}
