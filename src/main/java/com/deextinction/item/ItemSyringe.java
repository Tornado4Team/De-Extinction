package com.deextinction.item;

import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.init.DeItems;
import com.deextinction.util.DNA;
import com.deextinction.util.MinecraftTime;
import com.deextinction.util.SampleTag;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;

public class ItemSyringe extends ItemBasic
{
	public ItemSyringe(CreativeTabs tab)
	{
		super(tab);
	}

	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 30;
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand)
	{
		if (ItemSyringeBlood.hasBlood(target))
		{
			String registerName = DeExtinction.getNameFromEntity(target);
			if (registerName != null)
			{
				NBTTagCompound compound = stack.getTagCompound();
				if (compound == null)
					compound = new NBTTagCompound();

				compound.setString(SampleTag.NBT_TAG_SAMPLER, registerName);

				if (target.hasCustomName())
					compound.setString(SampleTag.NBT_TAG_NAME, target.getCustomNameTag());
				else
				{
					String name = EntityList.getEntityString(target);
					if (name == null)
						name = "generic";
					compound.setString(SampleTag.NBT_TAG_NAME, "entity." + name + ".name");
				}

				compound.setString(SampleTag.NBT_TAG_AGE, "" + MinecraftTime.getInGameDays(target.ticksExisted));

				float healthBar = target.getHealth() / target.getMaxHealth();
				compound.setString(SampleTag.NBT_TAG_HEALTH, healthBar == 1.0F ? "container.microscope.health.healty" : (healthBar >= 0.75F ? "container.microscope.health.slightly_injured" : (healthBar >= 0.5F ? "container.microscope.health.injured" : "container.microscope.health.badly_injured")));

				if (target instanceof EntityDeExtinctedAnimal)
				{
					EntityDeExtinctedAnimal animal = (EntityDeExtinctedAnimal) target;
					compound.setString(SampleTag.NBT_TAG_DNA, animal.getDNAString());
					compound.setString(SampleTag.NBT_TAG_GENDER, animal.isMale() ? "entity.creature.male" : "entity.creature.female");
				}
				else
				{
					Random rand = new Random(target.getEntityId());
					compound.setString(SampleTag.NBT_TAG_DNA, DNA.getRandomDNAString(rand));
				}

				ItemStack bloodSyringeStack = new ItemStack(DeItems.syringe_blood);
				bloodSyringeStack.setTagCompound(compound);
				playerIn.addItemStackToInventory(bloodSyringeStack);

				if (!playerIn.capabilities.isCreativeMode)
					stack.shrink(1);

				return true;
			}

		}
		return false;
	}
}
