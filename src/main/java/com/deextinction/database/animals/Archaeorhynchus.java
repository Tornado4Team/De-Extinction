
package com.deextinction.database.animals;

import com.deextinction.DeExtinction;
import com.deextinction.block.eggs.BlockEgg;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.IEgg;
import com.deextinction.database.TypeOfLife;
import com.deextinction.entity.animal.EntityArchaeorhynchus;
import com.deextinction.init.DeBlocks;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.EntityCreature;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Archaeorhynchus extends DeExtinctedAnimal implements IEgg
{
	public static final String NAME = "archaeorhynchus";

	public Archaeorhynchus()
	{
		super(Archaeorhynchus.NAME);
	}

	@Override
	public GeologicEra getGeologicEra()
	{
		return GeologicEra.MESOZOIC;
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
		return BlockEgg.EnumNumber.FIVE;
	}

	@Override
	public int getMaxHatchingProgress()
	{
		return 30 * MinecraftTime.MC_MINUTE_LENGHT;
	}

	@Override
	public EntityCreature getEntity(World worldIn)
	{
		return new EntityArchaeorhynchus(worldIn);
	}

	@Override
	public String getEntityName()
	{
		return DeExtinction.getNameFromEntityClass(EntityArchaeorhynchus.class);
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
		this.attributes.setGrowthByDays(4);
		this.attributes.setScaleBaby(0.3D, 0.5D);
		this.attributes.setScaleAdult(0.3D, 0.5D);
		this.attributes.setHealth(4.0D, 12.0D);
		this.attributes.setKnockbackResistance(0.1D, 0.2D);
		this.attributes.setMovementSpeed(0.42D, 0.4D);
		this.attributes.setArmor(0.0D, 0.0D);
		this.attributes.setArmorToughness(0.0D, 0.0D);
		this.attributes.setSwimSpeed(1.0D, 1.0D);
		this.attributes.setFollowRange(16.0D, 16.0D);
		this.attributes.setAttack(0.0D, 0.0D);
		this.attributes.setFlyingSpeed(0.0D, 0.0D);
	}
}
