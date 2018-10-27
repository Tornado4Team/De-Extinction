package com.deextinction.deextinction.tab;

import com.deextinction.deextinction.init.DeexItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ModTab  extends CreativeTabs
{
	public ModTab(String label) { super("modtab");}
	public ItemStack getTabIconItem() { return new ItemStack(DeexItem.CHISEL);}
}