package com.deextinction.item;

import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.database.DeExtincted;
import com.deextinction.util.DNA;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFloppyDisk extends ItemDeExtincted
{
	public static final String NBT_TAG_DNA_STRING = "DNA_String";
	public static final String NBT_TAG_VIABILITY = "DNA_Viability";

	public ItemFloppyDisk(DeExtincted deExtincted, CreativeTabs tab)
	{
		super(deExtincted, tab);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		if (playerIn.capabilities.isCreativeMode)
		{
			ItemStack heldStack = playerIn.getHeldItem(handIn);
			if (heldStack.hasTagCompound())
			{
				NBTTagCompound tags = heldStack.getTagCompound();
				tags.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(this.itemRand));
				tags.setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70 + 10 * Item.itemRand.nextInt(4));
				heldStack.setTagCompound(tags);
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldStack);
			}
			else
			{
				NBTTagCompound tags = new NBTTagCompound();
				tags.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
				tags.setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70);
				heldStack.setTagCompound(tags);
				return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, heldStack);
			}
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World world, List<String> tooltip, ITooltipFlag advanced)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound compound = stack.getTagCompound();

			if (!compound.hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
				stack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Item.itemRand));
			tooltip.add(I18n.translateToLocal("item.item_floppy_disk.dna") + ": " + compound.getString(ItemFloppyDisk.NBT_TAG_DNA_STRING));

			if (!compound.hasKey(ItemFloppyDisk.NBT_TAG_VIABILITY))
				stack.getTagCompound().setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70 + 10 * Item.itemRand.nextInt(4));
			tooltip.add(I18n.translateToLocal("item.item_floppy_disk.viability") + ": " + compound.getInteger(ItemFloppyDisk.NBT_TAG_VIABILITY) + "%");
		}
		else
			tooltip.add(I18n.translateToLocal("item.item_floppy_disk.creative"));
	}
}
