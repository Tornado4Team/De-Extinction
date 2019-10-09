package com.deextinction.item;

import com.deextinction.database.DeExtincted;
import com.deextinction.database.GeologicEra;

import net.minecraft.creativetab.CreativeTabs;

public class ItemFossilClean extends ItemDeExtincted
{
	private GeologicEra geologicEra;

	public ItemFossilClean(DeExtincted deExtincted, CreativeTabs tab)
	{
		super(deExtincted, tab);
		this.geologicEra = deExtincted.getGeologicEra();
	}
}
