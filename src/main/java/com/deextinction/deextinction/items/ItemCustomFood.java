package com.deextinction.deextinction.items;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.init.DeexItem;
import com.deextinction.deextinction.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

public class ItemCustomFood extends ItemFood implements IHasModel {
	public ItemCustomFood (String name, int amount, boolean isWolfFood)
	{
		super(amount, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.FOOD);
		
		DeexItem.ITEMS.add(this);
		
	}
	
	@Override
	public  void registerModels()
	{
		Deextinction.proxy.registerItemRenderer(this, 0, "inventory");
	}
	
	
	
}
