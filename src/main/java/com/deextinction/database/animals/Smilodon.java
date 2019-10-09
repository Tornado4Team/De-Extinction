package com.deextinction.database.animals;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.tileentity.ModelFossilBoneFemur;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.FossilRenderInfo;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.ISyringe;
import com.deextinction.database.TypeOfLife;
import com.deextinction.entity.animal.EntitySmilodon;
import com.deextinction.init.DeItems;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Smilodon extends DeExtinctedAnimal implements ISyringe
{
	public static final String NAME = "smilodon";

	public Smilodon()
	{
		super(Smilodon.NAME);
	}

	@Override
	public FossilRenderInfo getFossilInfo()
	{
		return new FossilRenderInfo(new ModelFossilBoneFemur(), "fossil_stone", 0.5F);
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
		return mother instanceof EntityOcelot || mother instanceof EntitySmilodon;
	}

	@Override
	public EntityCreature getEntity(World worldIn)
	{
		return new EntitySmilodon(worldIn);
	}

	@Override
	public String getEntityName()
	{
		return DeExtinction.getNameFromEntityClass(EntitySmilodon.class);
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
		this.attributes.setGrowthByDays(12);
		this.attributes.setScaleBaby(0.4D, 1.4D);
		this.attributes.setScaleAdult(0.4D, 1.4D);
		this.attributes.setHealth(8.0D, 24.0D);
		this.attributes.setKnockbackResistance(0.2D, 0.35D);
		this.attributes.setMovementSpeed(0.42D, 0.38D);
		this.attributes.setArmor(0.0D, 0.0D);
		this.attributes.setArmorToughness(0.0D, 0.0D);
		this.attributes.setSwimSpeed(1.0D, 1.0D);
		this.attributes.setFollowRange(16.0D, 16.0D);
		this.attributes.setAttack(0.5D, 6.0D);
		this.attributes.setFlyingSpeed(0.0D, 0.0D);
	}
}
