package com.deextinction.entity.ai.animation;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.util.DamageSource;

public class DeAIAnimationAttack extends DeAIAnimation
{
	private EntityLivingBase entityLivingBaseTarget;
	private int damageTick;
	private int duration;

	public DeAIAnimationAttack(EntityDeExtinctedAnimal animal, int duration, int damageTick)
	{
		super(animal);
		this.damageTick = (damageTick > duration) ? duration : damageTick;
		this.duration = duration;
		this.entityLivingBaseTarget = null;
	}

	@Override
	public int getAnimID()
	{
		return DeAnimationList.ATTACKING;
	}

	@Override
	public boolean isAutomatic()
	{
		return true;
	}

	@Override
	public int getDuration()
	{
		return this.duration;
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();
		this.entityLivingBaseTarget = this.getEntity().getAttackTarget();
	}

	@Override
	public void updateTask()
	{
		if (this.getEntityAsIAnimatedEntity().getAnimTick() == this.damageTick && this.entityLivingBaseTarget != null)
		{
			EntityDeExtinctedAnimal animal = this.getEntity();
			double distanceSqFromTarget = animal.getDistanceSq(this.entityLivingBaseTarget.posX, this.entityLivingBaseTarget.getEntityBoundingBox().minY, this.entityLivingBaseTarget.posZ);
			double minDistanceSqToAttack = (double) (10.0F * (animal.width * animal.width + this.entityLivingBaseTarget.width * this.entityLivingBaseTarget.width));
			if (distanceSqFromTarget <= minDistanceSqToAttack)
				this.entityLivingBaseTarget.attackEntityFrom(DamageSource.causeMobDamage(animal), (float) animal.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
		}
	}

	@Override
	public void resetTask()
	{
		super.resetTask();
		this.entityLivingBaseTarget = null;
	}
}
