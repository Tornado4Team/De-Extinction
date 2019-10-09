package com.deextinction.entity.ai.predicate;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;

public class DeTargetSelector implements Predicate
{
	private List<TargetSecondary> targetListSecondary = new ArrayList<TargetSecondary>();
	private List<TargetAgeable> targetListAgeable = new ArrayList<TargetAgeable>();
	private EntityDeExtinctedAnimal attackerEntity;

	public DeTargetSelector(EntityDeExtinctedAnimal attackerEntity, Class targetClass, double distance, byte targetMinStage, byte targetMaxStage, byte attackerMinStage, byte attackerMaxStage)
	{
		this.attackerEntity = attackerEntity;
		this.targetListAgeable.add(new TargetAgeable(targetClass, distance, targetMinStage, targetMaxStage, attackerMinStage, attackerMaxStage));
	}

	public DeTargetSelector(EntityDeExtinctedAnimal attackerEntity, Class targetClass, double distance, byte attackerMinStage, byte attackerMaxStage)
	{
		this.attackerEntity = attackerEntity;
		this.targetListSecondary.add(new TargetSecondary(targetClass, distance, attackerMinStage, attackerMaxStage));
	}

	public DeTargetSelector(EntityDeExtinctedAnimal attackerEntity, TargetAgeable... targetsAgeable)
	{
		this.attackerEntity = attackerEntity;
		for (TargetAgeable target : targetsAgeable)
			this.targetListAgeable.add(target);
	}

	public DeTargetSelector(EntityDeExtinctedAnimal attackerEntity, TargetSecondary... targetsSecondary)
	{
		this.attackerEntity = attackerEntity;
		for (TargetSecondary target : targetsSecondary)
			this.targetListSecondary.add(target);
	}

	public DeTargetSelector(EntityDeExtinctedAnimal attackerEntity, TargetAgeable[] targetsAgeable, TargetSecondary[] targetsSecondary)
	{
		this.attackerEntity = attackerEntity;
		for (TargetAgeable target : targetsAgeable)
			this.targetListAgeable.add(target);
		for (TargetSecondary target : targetsSecondary)
			this.targetListSecondary.add(target);
	}

	@Override
	public boolean apply(Object obj)
	{
		if (obj instanceof EntityDeExtinctedAnimal)
		{
			EntityDeExtinctedAnimal targetEntity = (EntityDeExtinctedAnimal) obj;
			if (targetEntity != null)
			{
				for (TargetAgeable target : this.targetListAgeable)
				{
					if (target != null && target.shouldAttackTarget(this.attackerEntity, targetEntity) && targetEntity.getDistanceSq(this.attackerEntity) < target.getDistanceSq())
						return true;
				}
			}
		}
		else
		{
			if (obj instanceof EntityLivingBase)
			{
				EntityLivingBase targetEntity = (EntityLivingBase) obj;
				if (targetEntity != null)
				{
					for (TargetSecondary target : this.targetListSecondary)
					{
						if (target != null && target.shouldAttackTarget(this.attackerEntity, targetEntity) && targetEntity.getDistanceSq(this.attackerEntity) < target.getDistanceSq())
							return true;
					}
				}
			}
		}
		return false;
	}

}
