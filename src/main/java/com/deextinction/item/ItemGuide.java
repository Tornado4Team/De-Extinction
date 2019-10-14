package com.deextinction.item;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeGuiHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemGuide extends ItemBasic
{

	public ItemGuide(CreativeTabs tab)
	{
		super(tab);
		this.setMaxStackSize(1);
	}

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        OpenGUI(worldIn, playerIn.getPosition(), playerIn);
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    private void OpenGUI(World world, BlockPos pos, EntityPlayer player) {
        player.openGui(DeExtinction.instance, DeGuiHandler.ID_GUIDE, world, pos.getX(), pos.getY(), pos.getZ());
    }
}