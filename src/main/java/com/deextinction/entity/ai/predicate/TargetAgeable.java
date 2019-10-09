package com.deextinction.entity.ai.predicate;

import com.deextinction.entity.EntityDeExtinctedAnimal;

public class TargetAgeable
{
	private Class targetClass;
	private byte targetMinStage;
	private byte targetMaxStage;
	private byte attackerMinStage;
	private byte attackerMaxStage;
	private double distanceSq;

	public TargetAgeable(Class targetClass, double distance, int targetMinStage, int targetMaxStage, int attackerMinStage, int attackerMaxStage)
	{
		this.targetClass = targetClass;
		this.targetMinStage = (byte) targetMinStage;
		this.targetMaxStage = (byte) targetMaxStage;
		this.attackerMinStage = (byte) attackerMinStage;
		this.attackerMaxStage = (byte) attackerMaxStage;
		this.distanceSq = distance * distance;
	}

	public boolean shouldAttackTarget(EntityDeExtinctedAnimal attacker, EntityDeExtinctedAnimal target)
	{
		if (target.getClass() == this.targetClass)
		{
			byte targetStage = target.getGrowthStage();
			if (targetStage >= this.targetMinStage && targetStage <= this.targetMaxStage)
			{
				byte attackerStage = attacker.getGrowthStage();
				if (attackerStage >= this.attackerMinStage && attackerStage <= this.attackerMaxStage)
					return true;
			}
		}
		return false;
	}

	public double getDistanceSq()
	{
		return this.distanceSq;
	}
}
