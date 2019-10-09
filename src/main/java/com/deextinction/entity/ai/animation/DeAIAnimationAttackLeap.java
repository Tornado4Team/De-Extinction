package com.deextinction.entity.ai.animation;

import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.entity.ai.DeAIMutex;

import net.minecraft.util.math.MathHelper;

public class DeAIAnimationAttackLeap extends DeAIAnimation
{
	private double leapMotionY;
	private int damageTick;
	private int duration;

	public DeAIAnimationAttackLeap(EntityDeExtinctedAnimal animal, double leapMotionY, int duration, int damageTick)
	{
		super(animal);
		this.damageTick = (damageTick > duration) ? duration : damageTick;
		this.duration = duration;
		this.leapMotionY = leapMotionY;
		this.setMutexBits(DeAIMutex.MOTION_SWIMMING.getMutex());
	}

	@Override
	public int getAnimID()
	{
		return DeAnimationList.ATTACKING;
	}

	@Override
	public boolean isAutomatic()
	{
		return false;
	}

	@Override
	public int getDuration()
	{
		return 40;
	}

	@Override
	public boolean shouldAnimate()
	{
		if (this.getEntity().getAttackTarget() == null)
			return false;

		double distanceSq = this.getEntity().getDistanceSq(this.getEntity().getAttackTarget());
		if (distanceSq >= 4.0D && distanceSq <= 9.0D)
		{
			if (!this.getEntity().onGround)
				return false;
			else
				return ((EntityDeExtinctedAnimal) this.getEntity()).getAnimID() == DeAnimationList.NO_ANIMATION && this.getEntity().getRNG().nextInt(5) == 0;
		}
		return false;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return super.shouldContinueExecuting() && !this.getEntity().onGround;
	}

	@Override
	public void startExecuting()
	{
		super.startExecuting();

		double dx = this.getEntity().getAttackTarget().posX - this.getEntity().posX;
		double dz = this.getEntity().getAttackTarget().posZ - this.getEntity().posZ;
		float dmax = MathHelper.sqrt(dx * dx + dz * dz);

		if ((double) dmax >= 1.0E-4D)
		{
			this.getEntity().motionX += dx / (double) dmax * 0.5D * 0.800000011920929D + this.getEntity().motionX * 0.20000000298023224D;
			this.getEntity().motionZ += dz / (double) dmax * 0.5D * 0.800000011920929D + this.getEntity().motionZ * 0.20000000298023224D;
		}

		this.getEntity().motionY = (double) this.leapMotionY;
	}

	public void updateTask()
	{
		if (this.getEntity().getAttackTarget().isEntityAlive())
			this.getEntity().getLookHelper().setLookPositionWithEntity(this.getEntity().getAttackTarget(), 30.0F, 30.0F);
	}

	@Override
	public void resetTask()
	{
		super.resetTask();
	}
}
