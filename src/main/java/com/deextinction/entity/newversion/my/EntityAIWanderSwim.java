package com.deextinction.entity.newversion.my;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class EntityAIWanderSwim extends EntityAIWander
{
	public EntityAIWanderSwim(EntityCreature p_i48937_1_, double p_i48937_2_, int p_i48937_4_)
	{
		super(p_i48937_1_, p_i48937_2_, p_i48937_4_);
	}

	@Nullable
	protected Vec3d getPosition()
	{
		Vec3d vec3d = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);

		for (int i = 0; vec3d != null && !this.entity.world.getBlockState(new BlockPos(vec3d)).getMaterial().isLiquid() && i++ < 10; vec3d = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7))
		{
			;
		}

		return vec3d;
	}
}
