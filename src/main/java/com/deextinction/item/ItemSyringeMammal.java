package com.deextinction.item;

import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.capabilities.IPregnant;
import com.deextinction.capabilities.PregnantCapabilityProvider;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.ISyringe;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.DNA;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSyringeMammal extends ItemDeExtincted
{

	public ItemSyringeMammal(DeExtincted deExtincted, CreativeTabs tab)
	{
		super(deExtincted, tab);
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
		}
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack stack, EntityPlayer playerIn, EntityLivingBase target, EnumHand hand)
	{
		System.out.println(target.getEntityAttribute(EntityLiving.SWIM_SPEED).getAttributeValue());
		
		NBTTagCompound compound = stack.getTagCompound();
		if (playerIn.capabilities.isCreativeMode)
		{
			if (compound != null)
			{
				if (!stack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
					stack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Item.itemRand));
			}
			else
			{
				compound = new NBTTagCompound();
				compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(Item.itemRand));
				stack.setTagCompound(compound);
			}
		}
		else
		{
			if (compound != null)
			{
				if (!stack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
					stack.getTagCompound().setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
			}
			else
			{
				compound = new NBTTagCompound();
				compound.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
				stack.setTagCompound(compound);
			}
		}

		DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(this.getDeExtinctedName());
		if (deExtincted != null)
		{
			if (deExtincted instanceof ISyringe)
			{
				ISyringe iSyringe = (ISyringe) deExtincted;
				if (iSyringe.isMother(target))
				{
					String dna = compound.getString(ItemFloppyDisk.NBT_TAG_DNA_STRING);

					if (target instanceof EntityAgeable)
					{
						EntityAgeable vanillaAgeable = (EntityAgeable) target;
						if (!vanillaAgeable.isChild())
							this.setBaby(playerIn, vanillaAgeable, stack, dna);
						return true;
					}
					else if (target instanceof EntityDeExtinctedAnimal)
					{
						EntityDeExtinctedAnimal entityAnimal = (EntityDeExtinctedAnimal) target;
						if (entityAnimal.isFullyGrown())
							this.setBaby(playerIn, entityAnimal, stack, dna);
						return true;
					}
					return true;
				}
			}
		}
		else
			DeExtinction.logger.error("Item Syringe from " + this.getDeExtinctedName() + " has atempted to inject a null creature! THIS IS A BUG!");

		return false;
	}

	private void setBaby(EntityPlayer playerIn, EntityLivingBase target, ItemStack syringe, String dna)
	{
		IPregnant pregnant = target.getCapability(PregnantCapabilityProvider.PREGNANT_CAPABILITY, null);
		if (pregnant != null)
		{
			if (!pregnant.hasBaby())
			{
				pregnant.setName(this.getDeExtinctedName());
				pregnant.setDNA(dna);
				pregnant.setProgress(0);

				if (!playerIn.capabilities.isCreativeMode)
					syringe.shrink(1);

				if (playerIn.world.isRemote && playerIn != null)
					playerIn.sendMessage(new TextComponentString(I18n.translateToLocal("item.item_syringe.inseminated")));
			}
		}
	}
}
