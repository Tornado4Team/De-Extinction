package com.deextinction.entity.ai;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

public class DeAIAttackMelee extends EntityAIBase
{
	private EntityDeExtinctedAnimal attacker;
	private int attackTick;
	private int attackInterval;
	private int delayCounter;
	private int failedPathFindingPenalty;
	private boolean longMemory;
	private boolean canPenalize;
	private double targetX;
	private double targetY;
	private double targetZ;
	private double speed;
	private Path path;

	public DeAIAttackMelee(EntityDeExtinctedAnimal attacker, double speed, int attackInterval, boolean useLongMemory)
	{
		this.attacker = attacker;
		this.attackInterval = attackInterval;
		this.longMemory = useLongMemory;
		this.failedPathFindingPenalty = 0;
		this.canPenalize = false;
		this.speed = speed;
		this.setMutexBits(3);
	}

	@Override
	public boolean shouldExecute()
	{
		EntityLivingBase target = this.attacker.getAttackTarget();

		if (target == null || !target.isEntityAlive())
			return false;
		else
		{
			if (this.canPenalize)
			{
				if (--this.delayCounter <= 0)
				{
					this.path = this.attacker.getNavigator().getPathToEntityLiving(target);
					this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
					return this.path != null;
				}
				else
					return true;
			}
			this.path = this.attacker.getNavigator().getPathToEntityLiving(target);

			if (this.path != null)
				return true;
			else
				return this.getAttackReachSq(target) >= this.attacker.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);
		}
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		EntityLivingBase target = this.attacker.getAttackTarget();

		if (target == null || !target.isEntityAlive())
			return false;
		else if (!this.longMemory)
			return !this.attacker.getNavigator().noPath();
		else if (!this.attacker.isWithinHomeDistanceFromPosition(new BlockPos(target)))
			return false;
		else
			return !(target instanceof EntityPlayer) || !((EntityPlayer) target).isSpectator() && !((EntityPlayer) target).isCreative();
	}

	@Override
	public void startExecuting()
	{
		this.attacker.getNavigator().setPath(this.path, this.speed);
		this.delayCounter = 0;
	}

	@Override
	public void resetTask()
	{
		EntityLivingBase target = this.attacker.getAttackTarget();

		if (target instanceof EntityPlayer && (((EntityPlayer) target).isSpectator() || ((EntityPlayer) target).isCreative()))
			this.attacker.setAttackTarget((EntityLivingBase) null);

		this.attacker.getNavigator().clearPath();
	}

	@Override
	public void updateTask()
	{
		EntityLivingBase target = this.attacker.getAttackTarget();
		this.attacker.getLookHelper().setLookPositionWithEntity(target, 30.0F, 30.0F);
		double distance_to_target = this.attacker.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);
		--this.delayCounter;

		if ((this.longMemory || this.attacker.getEntitySenses().canSee(target)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || target.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F))
		{
			this.targetX = target.posX;
			this.targetY = target.getEntityBoundingBox().minY;
			this.targetZ = target.posZ;
			this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);

			if (this.canPenalize)
			{
				this.delayCounter += failedPathFindingPenalty;
				if (this.attacker.getNavigator().getPath() != null)
				{
					net.minecraft.pathfinding.PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
					if (finalPathPoint != null && target.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
						failedPathFindingPenalty = 0;
					else
						failedPathFindingPenalty += 10;
				}
				else
					failedPathFindingPenalty += 10;
			}

			if (distance_to_target > 1024.0D)
				this.delayCounter += 10;
			else if (distance_to_target > 256.0D)
				this.delayCounter += 5;

			if (!this.attacker.getNavigator().tryMoveToEntityLiving(target, this.speed))
				this.delayCounter += 15;
		}

		this.attackTick = Math.max(this.attackTick - 1, 0);
		this.checkAndPerformAttack(target, distance_to_target);
	}

	protected void checkAndPerformAttack(EntityLivingBase target, double distance_to_target)
	{
		double distance_to_attack = this.getAttackReachSq(target);

		if (distance_to_target <= distance_to_attack && this.attackTick <= 0)
		{
			this.attackTick = this.attackInterval;
			this.attacker.swingArm(EnumHand.MAIN_HAND);
			this.attacker.attackEntityAsMob(target);
		}
	}

	protected double getAttackReachSq(EntityLivingBase attackTarget)
	{
		return (double) (this.attacker.width * 2.0F * this.attacker.width * 2.0F + attackTarget.width);
	}
}
