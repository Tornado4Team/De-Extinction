package com.deextinction.database.animals;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.ISyringe;
import com.deextinction.database.TypeOfLife;
import com.deextinction.entity.animal.EntityBasilosaurus;
import com.deextinction.init.DeItems;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Basilosaurus extends DeExtinctedAnimal implements ISyringe
{
	public static final String NAME = "basilosaurus";

	public Basilosaurus()
	{
		super(Basilosaurus.NAME);
	}

	@Override
	public GeologicEra getGeologicEra()
	{
		return GeologicEra.CENOZOIC;
	}

	@Override
	public TypeOfLife getTypeOfLife()
	{
		return TypeOfLife.MAMMALS;
	}

	@Override
	public ItemStack getPrecursorItem()
	{
		return new ItemStack(DeItems.syringe);
	}

	@Override
	public ItemStack getResultItem(String dna)
	{
		return new ItemStack(DeItems.syringes.get(this.getName()));
	}

	@Override
	public boolean isMother(EntityLivingBase mother)
	{
		return mother instanceof EntityCow || mother instanceof EntityLlama || mother instanceof EntitySheep || mother instanceof EntityPig || mother instanceof EntityBasilosaurus;
	}

	@Override
	public EntityCreature getEntity(World worldIn)
	{
		return new EntityBasilosaurus(worldIn);
	}

	@Override
	public String getEntityName()
	{
		return DeExtinction.getNameFromEntityClass(EntityBasilosaurus.class);
	}

	@Override
	public void initTexturesMale()
	{
		this.registerTextureMale(0);
		this.registerTextureMale(1);
	}

	@Override
	public void initTexturesFemale()
	{
		this.registerTextureFemale(0);
		this.registerTextureFemale(1);
	}

	@Override
	public void initAttributes()
	{
		this.attributes.setGrowthByDays(22);
		this.attributes.setScaleBaby(0.4D, 1.9D);
		this.attributes.setScaleAdult(0.4D, 1.9D);
		this.attributes.setHealth(12.0D, 60.0D);
		this.attributes.setKnockbackResistance(0.9D, 1.0D);
		this.attributes.setMovementSpeed(0.2D, 0.2D);
		this.attributes.setArmor(0.0D, 0.0D);
		this.attributes.setArmorToughness(0.0D, 0.0D);
		this.attributes.setSwimSpeed(0.4D, 0.6D);
		this.attributes.setFollowRange(16.0D, 16.0D);
		this.attributes.setAttack(0.5D, 8.0D);
		this.attributes.setFlyingSpeed(0.0D, 0.0D);
	}
}
