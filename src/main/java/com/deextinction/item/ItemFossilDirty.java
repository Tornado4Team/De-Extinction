package com.deextinction.item;

import com.deextinction.database.DeExtincted;
import com.deextinction.database.GeologicEra;

import net.minecraft.creativetab.CreativeTabs;

public class ItemFossilDirty extends ItemDeExtincted
{
	private GeologicEra geologicEra;

	public ItemFossilDirty(DeExtincted deExtincted, CreativeTabs tab)
	{
		super(deExtincted, tab);
		this.geologicEra = deExtincted.getGeologicEra();
	}
}
