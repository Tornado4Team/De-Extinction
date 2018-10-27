package com.deextinction.deextinction.blocks;

import com.deextinction.deextinction.client.Deextinction;
import com.deextinction.deextinction.init.DeexBlocks;
import com.deextinction.deextinction.init.DeexItem;
import com.deextinction.deextinction.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block implements IHasModel
{
	public BlockBase(String name, Material material)
	{
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(Deextinction.modtab);
	
		DeexBlocks.BLOCKS.add(this);
		DeexItem.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public void registerModels()
	{
		Deextinction.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
	

}
