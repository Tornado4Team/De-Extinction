package com.deextinction.database.animals;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.ISyringe;
import com.deextinction.database.TypeOfLife;
import com.deextinction.entity.animal.EntityLivyatan;
import com.deextinction.init.DeItems;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Livyatan extends DeExtinctedAnimal implements ISyringe
{
	public static final String NAME = "livyatan";

	public Livyatan()
	{
		super(Livyatan.NAME);
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
		return mother instanceof EntityCow || mother instanceof EntityLlama || mother instanceof EntitySheep || mother instanceof EntityPig || mother instanceof EntityLivyatan;
	}

	@Override
	public EntityCreature getEntity(World worldIn)
	{
		return new EntityLivyatan(worldIn);
	}

	@Override
	public String getEntityName()
	{
		return DeExtinction.getNameFromEntityClass(EntityLivyatan.class);
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
		this.attributes.setGrowthByDays(28);
		this.attributes.setScaleBaby(0.35D, 2.1D);
		this.attributes.setScaleAdult(0.35D, 2.1D);
		this.attributes.setHealth(16.0D, 80.0D);
		this.attributes.setKnockbackResistance(0.9D, 1.0D);
		this.attributes.setMovementSpeed(0.2D, 0.2D);
		this.attributes.setArmor(0.0D, 0.0D);
		this.attributes.setArmorToughness(0.0D, 0.0D);
		this.attributes.setSwimSpeed(0.4D, 0.6D);
		this.attributes.setFollowRange(16.0D, 16.0D);
		this.attributes.setAttack(0.5D, 10.0D);
		this.attributes.setFlyingSpeed(0.0D, 0.0D);
	}
}
