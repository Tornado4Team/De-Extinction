
package com.deextinction.database.animals;

import com.deextinction.DeExtinction;
import com.deextinction.block.eggs.BlockEgg;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.IEgg;
import com.deextinction.database.TypeOfLife;
import com.deextinction.entity.animal.EntityKelenken;
import com.deextinction.init.DeBlocks;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.EntityCreature;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Kelenken extends DeExtinctedAnimal implements IEgg
{
	public static final String NAME = "kelenken";

	public Kelenken()
	{
		super(Kelenken.NAME);
	}

	@Override
	public GeologicEra getGeologicEra()
	{
		return GeologicEra.CENOZOIC;
	}

	@Override
	public TypeOfLife getTypeOfLife()
	{
		return TypeOfLife.AVES;
	}

	@Override
	public ItemStack getPrecursorItem()
	{
		return new ItemStack(Items.EGG);
	}

	@Override
	public ItemStack getResultItem(String dna)
	{
		return new ItemStack(DeBlocks.eggs.get(this.getName()));
	}

	@Override
	public BlockEgg.EnumNumber getTotalNumberOfEgg()
	{
		return BlockEgg.EnumNumber.THREE;
	}

	@Override
	public int getMaxHatchingProgress()
	{
		return 30 * MinecraftTime.MC_MINUTE_LENGHT;
	}

	@Override
	public EntityCreature getEntity(World worldIn)
	{
		return new EntityKelenken(worldIn);
	}

	@Override
	public String getEntityName()
	{
		return DeExtinction.getNameFromEntityClass(EntityKelenken.class);
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
		this.attributes.setGrowthByDays(10);
		this.attributes.setScaleBaby(0.275D, 1.2D);
		this.attributes.setScaleAdult(0.275D, 1.2D);
		this.attributes.setHealth(8.0D, 26.0D);
		this.attributes.setKnockbackResistance(0.3D, 0.6D);
		this.attributes.setMovementSpeed(0.42D, 0.34D);
		this.attributes.setArmor(0.0D, 0.0D);
		this.attributes.setArmorToughness(0.0D, 0.0D);
		this.attributes.setSwimSpeed(1.0D, 1.0D);
		this.attributes.setFollowRange(16.0D, 16.0D);
		this.attributes.setAttack(1.0D, 6.0D);
		this.attributes.setFlyingSpeed(0.0D, 0.0D);
	}
}
