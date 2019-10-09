package com.deextinction.item;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.util.SampleTag;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;

public class ItemSyringeBlood extends ItemBasic
{
	public static final List<String> LIST_OF_INVALID_ENTITIES = new ArrayList<String>();
	static
	{
		ItemSyringeBlood.registerInvalidEntity(EntitySkeleton.class);
		ItemSyringeBlood.registerInvalidEntity(EntitySkeletonHorse.class);
		ItemSyringeBlood.registerInvalidEntity(EntityWitherSkeleton.class);
		ItemSyringeBlood.registerInvalidEntity(EntityBlaze.class);
		ItemSyringeBlood.registerInvalidEntity(EntityArmorStand.class);
	}

	public ItemSyringeBlood(CreativeTabs tab)
	{
		super(tab);
	}

	public String getItemStackDisplayName(ItemStack stack)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound compound = stack.getTagCompound();

			if (compound.hasKey(SampleTag.NBT_TAG_NAME))
			{
				String name = compound.getString(SampleTag.NBT_TAG_NAME);
				if (I18n.canTranslate(name))
					return super.getItemStackDisplayName(stack) + " (" + I18n.translateToLocal(name) + ")";
				else
					return super.getItemStackDisplayName(stack) + " (" + name + ")";
			}
		}

		return super.getItemStackDisplayName(stack);
	}

	private static void registerInvalidEntity(Class clazz)
	{
		ItemSyringeBlood.LIST_OF_INVALID_ENTITIES.add(DeExtinction.getNameFromEntityClass(clazz));
	}

	public static boolean hasBlood(EntityLivingBase target)
	{
		return !ItemSyringeBlood.LIST_OF_INVALID_ENTITIES.contains(DeExtinction.getNameFromEntity(target));
	}
}
