package com.deextinction.entity.ai;

import javax.annotation.Nullable;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.Vec3d;

public class DeAIWanderAvoidWater extends DeAIWander
{
	protected final float probability;

	public DeAIWanderAvoidWater(EntityDeExtinctedAnimal animal, double speed)
	{
		this(animal, speed, 10, 7, 120, 0.001F);
	}

	public DeAIWanderAvoidWater(EntityDeExtinctedAnimal animal, double speed, int chance)
	{
		this(animal, speed, 10, 7, chance, 0.001F);
	}

	public DeAIWanderAvoidWater(EntityDeExtinctedAnimal animal, double speed, int rangeXZ, int rangeY)
	{
		this(animal, speed, rangeXZ, rangeY, 120, 0.001F);
	}

	public DeAIWanderAvoidWater(EntityDeExtinctedAnimal animal, double speed, int rangeXZ, int rangeY, int chance)
	{
		this(animal, speed, rangeXZ, rangeY, chance, 0.001F);
	}

	public DeAIWanderAvoidWater(EntityDeExtinctedAnimal animal, double speed, int rangeXZ, int rangeY, int chance, float probability)
	{
		super(animal, speed, rangeXZ, rangeY, chance);
		this.probability = probability;
	}

	@Nullable
	@Override
	protected Vec3d getPosition()
	{
		return RandomPositionGenerator.getLandPos(this.animal, this.rangeXZ, this.rangeY);
	}
}
