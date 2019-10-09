package com.deextinction.entity.ai;

import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.world.World;

public class DeAISittingNatural extends EntityAIBase
{
	private EntityDeExtinctedAnimal animal;
	private World world;
	private int sittingInterval;
	private int durationVariation;
	private int duration;
	private int chance;
	private int timer;

	public DeAISittingNatural(EntityDeExtinctedAnimal animal, int chance, int duration, int durationVariation, int sittingInterval)
	{
		this.animal = animal;
		this.world = animal.world;
		this.chance = chance;

		this.duration = duration;
		this.durationVariation = durationVariation;
		this.sittingInterval = sittingInterval;

		this.timer = this.sittingInterval + this.world.rand.nextInt(this.sittingInterval);
		this.setMutexBits(DeAIMutex.MOTION_SWIMMING.getMutex());
	}

	public DeAISittingNatural(EntityDeExtinctedAnimal animal)
	{
		this(animal, 100, MinecraftTime.TICKS_PER_MINUTE, 2 * MinecraftTime.TICKS_PER_MINUTE, MinecraftTime.MC_DAY_LENGHT);
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.timer-- < 0 && this.world.rand.nextInt(this.chance) == 0)
			return !this.animal.isSitting() && !this.animal.isInWater() && this.animal.getRidingEntity() == null && this.animal.onGround && this.animal.isEntityAlive();
		return false;
	}

	@Override
	public void startExecuting()
	{
		this.animal.getNavigator().clearPath();
		this.animal.setSitting(true, null);
		this.timer = this.duration + this.world.rand.nextInt(this.durationVariation);
	}

	@Override
	public void updateTask()
	{
		this.timer--;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return this.timer > 0 && this.animal.isSitting() && !this.animal.hasBeenHurt() && !this.animal.isInWater() && !this.animal.isInLava() && this.animal.getAttackTarget() == null && this.animal.isEntityAlive();
	}

	@Override
	public void resetTask()
	{
		this.timer = this.sittingInterval + this.world.rand.nextInt(this.sittingInterval);
		this.animal.setSitting(false, null);
	}
}
