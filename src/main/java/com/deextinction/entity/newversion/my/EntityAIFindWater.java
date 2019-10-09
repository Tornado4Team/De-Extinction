package com.deextinction.entity.newversion.my;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class EntityAIFindWater extends EntityAIBase
{
	private final EntityCreature entity;

	public EntityAIFindWater(EntityCreature p_i48936_1_)
	{
		this.entity = p_i48936_1_;
	}

	/**
	 * Returns whether the EntityAIBase should begin execution.
	 */
	public boolean shouldExecute()
	{
		return this.entity.onGround && !this.entity.world.getBlockState(new BlockPos(this.entity)).getMaterial().isLiquid();
	}

	/**
	 * Execute a one shot task or start executing a continuous task
	 */
	public void startExecuting()
	{
		BlockPos blockpos = null;

		for (BlockPos blockpos1 : BlockPos.MutableBlockPos.getAllInBoxMutable(MathHelper.floor(this.entity.posX - 2.0D), MathHelper.floor(this.entity.posY - 2.0D), MathHelper.floor(this.entity.posZ - 2.0D), MathHelper.floor(this.entity.posX + 2.0D), MathHelper.floor(this.entity.posY),
				MathHelper.floor(this.entity.posZ + 2.0D)))
		{
			if (this.entity.world.getBlockState(blockpos1).getMaterial().isLiquid())
			{
				blockpos = blockpos1;
				break;
			}
		}

		if (blockpos != null)
		{
			this.entity.getMoveHelper().setMoveTo((double) blockpos.getX(), (double) blockpos.getY(), (double) blockpos.getZ(), 1.0D);
		}

	}
}
