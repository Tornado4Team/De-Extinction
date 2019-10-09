package com.deextinction.database.animals;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.ISyringe;
import com.deextinction.database.TypeOfLife;
import com.deextinction.entity.animal.EntityCanisNehringi;
import com.deextinction.init.DeItems;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CanisNehringi extends DeExtinctedAnimal implements ISyringe
{
	public static final String NAME = "canis_nehringi";

	public CanisNehringi()
	{
		super(CanisNehringi.NAME);
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
		return mother instanceof EntityWolf || mother instanceof EntityCanisNehringi;
	}

	@Override
	public EntityCreature getEntity(World worldIn)
	{
		return new EntityCanisNehringi(worldIn);
	}

	@Override
	public String getEntityName()
	{
		return DeExtinction.getNameFromEntityClass(EntityCanisNehringi.class);
	}

	@Override
	public void initTexturesMale()
	{
		this.registerTextureMale(0);
	}

	@Override
	public void initTexturesFemale()
	{
		this.registerTextureFemale(0);
	}

	@Override
	public void initAttributes()
	{
		this.attributes.setGrowthByDays(5);
		this.attributes.setScaleBaby(0.3D, 0.55D);
		this.attributes.setScaleAdult(0.3D, 0.55D);
		this.attributes.setHealth(8.0D, 22.0D);
		this.attributes.setKnockbackResistance(0.2D, 0.5D);
		this.attributes.setMovementSpeed(0.42D, 0.36D);
		this.attributes.setArmor(0.0D, 0.0D);
		this.attributes.setArmorToughness(0.0D, 0.0D);
		this.attributes.setSwimSpeed(1.0D, 1.0D);
		this.attributes.setFollowRange(16.0D, 16.0D);
		this.attributes.setAttack(0.5D, 4.0D);
		this.attributes.setFlyingSpeed(0.0D, 0.0D);
	}
}
