package com.deextinction.entity.ai;

import javax.annotation.Nullable;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;

public class DeAIWander extends EntityAIBase
{
	protected final EntityDeExtinctedAnimal animal;
	protected int rangeXZ;
	protected int rangeY;
	protected int chance;
	protected double speed;
	protected double x;
	protected double y;
	protected double z;

	public DeAIWander(EntityDeExtinctedAnimal animal, double speed)
	{
		this(animal, speed, 10, 7, 120);
	}

	public DeAIWander(EntityDeExtinctedAnimal animal, double speed, int chance)
	{
		this(animal, speed, 10, 7, chance);
	}

	public DeAIWander(EntityDeExtinctedAnimal animal, double speed, int rangeXZ, int rangeY)
	{
		this(animal, speed, rangeXZ, rangeY, 120);
	}

	public DeAIWander(EntityDeExtinctedAnimal animal, double speed, int rangeXZ, int rangeY, int chance)
	{
		this.animal = animal;
		this.speed = speed;
		this.rangeXZ = rangeXZ;
		this.rangeY = rangeY;
		this.chance = chance;
		this.setMutexBits(DeAIMutex.MOTION.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.animal.getRNG().nextInt(this.chance) != 0)
			return false;

		Vec3d pos = this.getPosition();

		if (pos == null)
			return false;
		else
		{
			this.x = pos.x;
			this.y = pos.y;
			this.z = pos.z;
			return true;
		}
	}

	@Nullable
	protected Vec3d getPosition()
	{
		return RandomPositionGenerator.findRandomTarget(this.animal, this.rangeXZ, this.rangeY);
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return this.animal.getAttackTarget() != null && !this.animal.getNavigator().noPath();
	}

	@Override
	public void startExecuting()
	{
		this.animal.getNavigator().tryMoveToXYZ(this.x, this.y, this.z, this.speed);
	}
}
