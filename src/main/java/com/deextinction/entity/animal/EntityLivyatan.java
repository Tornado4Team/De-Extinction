package com.deextinction.entity.animal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.client.renderer.animations.YawChainAnimator;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.animals.Livyatan;
import com.deextinction.entity.EntityDeExtinctedAnimalAquatic;
import com.deextinction.entity.ai.DeAIEatDroppedItem;
import com.deextinction.entity.ai.DeAIFollowFood;
import com.deextinction.entity.ai.DeAIWaterWander;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityLivyatan extends EntityDeExtinctedAnimalAquatic
{
	public YawChainAnimator tailBuffer = new YawChainAnimator(this);

	protected static final List<Item> foodList = new ArrayList<Item>();
	static
	{
		EntityLivyatan.foodList.add(Items.FISH);
		EntityLivyatan.foodList.add(Items.COOKED_FISH);
	}

	public EntityLivyatan(World worldIn)
	{
		super(worldIn);
	}

	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(0, new DeAIWaterWander(this, DeAIWaterWander.SwimType.DEEP_WATER, 1.0D, 5.0D, 200, 12, 4));
		this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(2, new DeAIEatDroppedItem(this, 1.0D, 10, 1.0D, 16.0D, EntityLivyatan.foodList));
		this.tasks.addTask(3, new DeAIFollowFood(this, 1.0D, 2.0D, 30, EntityLivyatan.foodList));
		this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true, new Class[0]));
	}

	@Override
	public DeExtinctedAnimal getAnimal()
	{
		return (DeExtinctedAnimal) DeDatabase.LIST_DE_EXTINCTED.get(Livyatan.NAME);
	}

	@Override
	public boolean isAdult()
	{
		return this.getGrowthStage() > 4;
	}

	@Override
	public int getMaxHunger()
	{
		return 2 * MinecraftTime.MC_DAY_LENGHT;
	}

	@Override
	public float getMaxWidth()
	{
		return 1.0F;
	}

	@Override
	public float getMaxHeight()
	{
		return 1.0F;
	}

	@Override
	public float getEyeHeight()
	{
		return 0.7F * this.height;
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		if (this.isInWater())
			return SoundEvents.ENTITY_SQUID_AMBIENT;
		return null;
	}

	@Override
	public List<Item> getCreatureFoodList()
	{
		return EntityLivyatan.foodList;
	}

	@Override
	protected void updateAIFromGrowthStage(int growthStage)
	{

	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.world.isRemote)
			this.tailBuffer.update(7, 60.0F, 3.0F);
	}

	@Override
	public int getMaxAir()
	{
		return MinecraftTime.MC_HOUR_LENGHT;
	}
}
