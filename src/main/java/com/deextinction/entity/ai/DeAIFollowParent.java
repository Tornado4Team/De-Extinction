package com.deextinction.entity.ai;

import java.util.List;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.ai.EntityAIBase;

public class DeAIFollowParent extends EntityAIBase
{
	private EntityDeExtinctedAnimal childAnimal;
	private EntityDeExtinctedAnimal parentAnimal;
	private int delayCounter;
	private double speed;
	private double searchDistance;
	private double minDistanceSq;

	public DeAIFollowParent(EntityDeExtinctedAnimal animal, double speed, int minDistance, double searchDistance)
	{
		this.childAnimal = animal;
		this.searchDistance = searchDistance;
		this.minDistanceSq = minDistance * minDistance;
		this.speed = speed;
		this.setMutexBits(DeAIMutex.MOTION.getMutex());
	}

	public boolean shouldExecute()
	{
		if (this.childAnimal.isAdult())
			return false;
		else
		{
			List<EntityDeExtinctedAnimal> list = this.childAnimal.world.<EntityDeExtinctedAnimal> getEntitiesWithinAABB(this.childAnimal.getClass(), this.childAnimal.getEntityBoundingBox().grow(this.searchDistance, this.searchDistance / 2.0D, this.searchDistance));
			EntityDeExtinctedAnimal entityParent = null;
			double last_distance = Double.MAX_VALUE;

			for (EntityDeExtinctedAnimal entityParentPossible : list)
			{
				if (entityParentPossible.isAdult())
				{
					double distance_to_parent = this.childAnimal.getDistanceSq(entityParentPossible);

					if (distance_to_parent <= last_distance)
					{
						last_distance = distance_to_parent;
						entityParent = entityParentPossible;
					}
				}
			}

			if (entityParent == null)
				return false;
			else if (last_distance < this.minDistanceSq)
				return false;
			else
			{
				this.parentAnimal = entityParent;
				return true;
			}
		}
	}

	public boolean shouldContinueExecuting()
	{
		if (this.childAnimal.isAdult() || !this.parentAnimal.isEntityAlive())
			return false;
		else
		{
			double distance_to_parent = this.childAnimal.getDistanceSq(this.parentAnimal);
			return distance_to_parent >= this.minDistanceSq && distance_to_parent <= 256.0D;
		}
	}

	public void startExecuting()
	{
		if (this.childAnimal.isSitting())
			this.childAnimal.setSitting(false);
		this.delayCounter = 0;
	}

	public void resetTask()
	{
		this.parentAnimal = null;
	}

	public void updateTask()
	{
		if (--this.delayCounter <= 0)
		{
			this.delayCounter = 10;
			this.childAnimal.getNavigator().tryMoveToEntityLiving(this.parentAnimal, this.speed);
		}
	}
}
