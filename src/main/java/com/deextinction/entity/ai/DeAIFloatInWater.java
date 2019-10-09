package com.deextinction.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAISwimming;

public class DeAIFloatInWater extends EntityAISwimming
{
	private final EntityCreature animal;
	protected float chance;

	public DeAIFloatInWater(EntityCreature animal)
	{
		this(animal, 0.8F);
	}

	public DeAIFloatInWater(EntityCreature animal, float chance)
	{
		super(animal);
		this.animal = animal;
		this.chance = chance;
	}

	@Override
	public void updateTask()
	{
		if (this.animal.getRNG().nextFloat() < this.chance)
			this.animal.getJumpHelper().setJumping();
	}
}
