package com.deextinction.entity.ai;

import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.entity.EntityDeExtinctedAnimalAquatic;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

public class DeAIWaterWander extends EntityAIBase
{
	private EntityDeExtinctedAnimal animal;
	private DeAIWaterWander.SwimType swimType;
	private BlockPos target;

	private int deepthInterval;
	private int searchRange;
	private int duration;
	private int timer;

	private double distanceToTargetSq;
	private double speed;
	private int attackTick;

	public DeAIWaterWander(EntityDeExtinctedAnimalAquatic creature, double speed, double distanceToTargetSq, int duration, int searchRange, int deepthInterval)
	{
		this(creature, DeAIWaterWander.SwimType.NORMAL, speed, distanceToTargetSq, duration, searchRange, deepthInterval);
	}

	public DeAIWaterWander(EntityDeExtinctedAnimalAquatic creature, DeAIWaterWander.SwimType swimType, double speed, double distanceToTargetSq, int duration, int searchRange, int deepthInterval)
	{
		this.animal = creature;
		this.deepthInterval = deepthInterval;
		this.searchRange = searchRange;
		this.distanceToTargetSq = distanceToTargetSq;
		this.duration = duration;
		this.timer = 0;
		this.speed = speed;
		this.swimType = swimType;
		this.setMutexBits(DeAIMutex.MOTION.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (!this.animal.isInWater() || !this.animal.getNavigator().noPath())
			return false;

		if (this.animal.getAttackTarget() != null)
		{
			this.target = this.animal.getAttackTarget().getPosition();
			return true;
		}

		BlockPos waterPos = this.findWaterTarget();
		if (waterPos != null)
		{
			this.target = waterPos;
			return true;
		}

		return false;
	}

	@Override
	public void startExecuting()
	{
		this.timer = this.duration + this.animal.getRNG().nextInt(this.duration);
	}

	@Override
	public void updateTask()
	{
		if (this.animal.getAttackTarget() != null)
			this.target = this.animal.getAttackTarget().getPosition();

		double distanceX = this.target.getX() - this.animal.posX;
		double distanceY = this.target.getY() - this.animal.posY;
		double distanceZ = this.target.getZ() - this.animal.posZ;
		double distanceSq = distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ;

		double distance = Math.sqrt(distanceSq);
		this.animal.motionX += distanceX / distance * 0.05D * this.animal.getEntityAttribute(EntityLiving.SWIM_SPEED).getAttributeValue() * this.speed;
		this.animal.motionY += distanceY / distance * 0.10D * this.animal.getEntityAttribute(EntityLiving.SWIM_SPEED).getAttributeValue() * this.speed;
		this.animal.motionZ += distanceZ / distance * 0.05D * this.animal.getEntityAttribute(EntityLiving.SWIM_SPEED).getAttributeValue() * this.speed;

		this.animal.rotationPitch += ((float) Math.atan2(this.animal.motionY, Math.sqrt(this.animal.motionX * this.animal.motionX + this.animal.motionZ * this.animal.motionZ)) * 180.0F / (float) Math.PI - this.animal.rotationPitch) * 0.5F;
		this.animal.renderYawOffset += (-((float) Math.atan2(this.animal.motionX, this.animal.motionZ)) * 180.0F / (float) Math.PI - this.animal.renderYawOffset) * 0.5F;
		this.animal.rotationYaw = this.animal.renderYawOffset;

		if (this.animal.getAttackTarget() != null)
		{
			EntityLivingBase attackTarget = this.animal.getAttackTarget();
			this.attackTick = Math.max(this.attackTick - 1, 0);
			if (distanceSq <= (double) (2.0F * (this.animal.width + attackTarget.width) * (this.animal.width + attackTarget.width)) && this.attackTick <= 0)
			{
				this.attackTick = 20;
				this.animal.attackEntityAsMob(attackTarget);
			}
		}
		else
		{
			if (distanceSq < this.distanceToTargetSq + this.animal.width)
			{
				BlockPos waterPos = this.findWaterTarget();
				if (waterPos != null)
				{
					this.target = waterPos;
					this.timer = this.duration + this.animal.getRNG().nextInt(this.duration);
				}
			}
			else
			{
				if (this.animal.collidedHorizontally)
				{
					BlockPos waterPos = this.findWaterTarget();
					if (waterPos != null)
					{
						this.target = waterPos;
						this.timer = this.duration + this.animal.getRNG().nextInt(this.duration);
					}
				}
			}
		}
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (this.animal.getAttackTarget() == null)
			return this.timer-- > 0 && this.animal.isInWater();
		else
			return this.timer-- > 0 && this.animal.getAttackTarget().isEntityAlive() && this.animal.isInWater();
	}

	@Override
	public void resetTask()
	{
		this.timer = 0;
		this.resetTarget();
	}

	public void setToAttackTarget(EntityLivingBase target)
	{
		BlockPos pos = new BlockPos(1.5D * this.animal.posX - target.posX, 1.5D * this.animal.posY - target.posY, 1.5D * this.animal.posZ - target.posZ);
		if (this.isWaterBlock(pos))
			this.target = pos;
	}

	public void resetTarget()
	{
		this.target = this.animal.getPosition();
	}

	public boolean isWaterBlock(double posX, double posY, double posZ)
	{
		return this.isWaterBlock(new BlockPos(posX, posY, posZ));
	}

	public boolean isWaterBlock(BlockPos pos)
	{
		return this.animal.world.getBlockState(pos).getMaterial() == Material.WATER;
	}

	public BlockPos findWaterTarget()
	{
		Vec3d target = RandomPositionGenerator.findRandomTarget(this.animal, this.searchRange, this.deepthInterval);

		if (target == null)
			return null;

		if (this.swimType == DeAIWaterWander.SwimType.SURFACE)
		{
			BlockPos surfacePos = this.animal.getSurface(this.animal);
			if (surfacePos != null)
				target.addVector(0.0D, surfacePos.getY() - this.animal.height - 1, 0.0D);
			else
				return null;
		}
		else if (this.swimType == DeAIWaterWander.SwimType.NEAR_SURFACE)
		{
			BlockPos surfacePos = this.animal.getSurface(this.animal);
			if (surfacePos != null)
				target.addVector(0.0D, surfacePos.getY() - this.animal.height - 1 - this.animal.getRNG().nextInt(this.deepthInterval), 0.0D);
			else
				return null;
		}
		else if (this.swimType == DeAIWaterWander.SwimType.DEEP_WATER)
		{
			BlockPos surfacePos = this.animal.getSurface(this.animal);
			if (surfacePos != null)
			{
				BlockPos bottomPos = this.animal.getWaterBottom(surfacePos);
				if (bottomPos != null)
					target.addVector(0.0D, bottomPos.getY() + this.animal.getRNG().nextInt(this.deepthInterval), 0.0D);
				else
					return null;
			}
			else
				return null;
		}

		return new BlockPos(target);
	}

	public static enum SwimType
	{
		SURFACE,
		NEAR_SURFACE,
		NORMAL,
		DEEP_WATER;
	}
}
