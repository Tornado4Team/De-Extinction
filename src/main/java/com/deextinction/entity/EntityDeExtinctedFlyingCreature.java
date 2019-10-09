package com.deextinction.entity;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedFlyingCreature extends EntityDeExtinctedAnimal
{
	public BlockPos flyingTarget;

	public EntityDeExtinctedFlyingCreature(World world)
	{
		super(world);
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{

	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		this.handleFlying();
	}

	/** Returns true if the target is invalid */
	public boolean validateTarget(BlockPos pos)
	{
		return !this.world.isAirBlock(pos);
	}

	public void flyTowardsTarget(BlockPos pos)
	{
		this.flyTowardsTarget(pos, 1.0D);
	}

	public void flyTowardsTarget(BlockPos pos, double speed)
	{
		if (pos != null)
		{
			double targetX = pos.getX() + 0.5D - this.posX;
			double targetY = pos.getY() + 1.0D - this.posY;
			double targetZ = pos.getZ() + 0.5D - this.posZ;
			this.motionX += (Math.signum(targetX) * 0.5D - this.motionX) * 0.10000000149011612D;
			this.motionY += (Math.signum(targetY) * 0.699999988079071D - this.motionY) * 0.10000000149011612D;
			this.motionZ += (Math.signum(targetZ) * 0.5D - this.motionZ) * 0.10000000149011612D;
			float dRotationYaw = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0D / Math.PI) - 90.0F;
			this.rotationYaw += MathHelper.wrapDegrees(dRotationYaw - this.rotationYaw);
			this.moveForward = (float) (this.getFlyingSpeed() * speed);
		}
	}

	public void flyAround(boolean shouldJump, int rangeX, int rangeY, int rangeZ)
	{
		if (shouldJump)
			this.jump();

		if (this.flyingTarget == null || this.getDistanceSq(this.flyingTarget) < 4.0F)
		{
			this.flyingTarget = new BlockPos((int) this.posX - (int) (rangeX / 2) + this.rand.nextInt(rangeX), (int) this.posY + this.rand.nextInt(rangeY) - 2, (int) this.posZ - (int) (rangeX / 2) + this.rand.nextInt(rangeZ));

			if (this.validateTarget(this.flyingTarget))
				this.flyingTarget = null;
		}

		this.flyTowardsTarget(this.flyingTarget);
	}

	public void flyAroundUntilXZ(boolean shouldJump, int rangeX, int rangeY, int rangeZ)
	{
		if (shouldJump || this.rand.nextInt(100) == 0)
			this.jump();

		if (this.flyingTarget == null || this.getDistanceSq(this.flyingTarget) < 4.0F || ((int) this.posX == this.flyingTarget.getX() || (int) this.posZ == this.flyingTarget.getZ()))
		{
			this.flyingTarget = new BlockPos((int) this.posX - (int) (rangeX / 2) + this.rand.nextInt(rangeX), (int) this.posY + this.rand.nextInt(rangeY) - 2, (int) this.posZ - (int) (rangeX / 2) + this.rand.nextInt(rangeZ));

			if (this.validateTarget(this.flyingTarget))
				this.flyingTarget = null;
		}

		this.flyTowardsTarget(this.flyingTarget);
	}

	public void flyAround(boolean shouldJump, int rangeX, int rangeY, int rangeZ, int chanceToChangeTarget)
	{
		if (shouldJump || this.rand.nextInt(100) == 0)
			this.jump();

		if (this.flyingTarget == null || this.getDistanceSq(this.flyingTarget) < 4.0F || this.rand.nextInt(chanceToChangeTarget) == 0)
		{
			this.flyingTarget = new BlockPos((int) this.posX - (int) (rangeX / 2) + this.rand.nextInt(rangeX), (int) this.posY + this.rand.nextInt(rangeY) - 2, (int) this.posZ - (int) (rangeX / 2) + this.rand.nextInt(rangeZ));

			if (this.validateTarget(this.flyingTarget))
				this.flyingTarget = null;
		}

		this.flyTowardsTarget(this.flyingTarget);
	}

	protected abstract void handleFlying();

	protected abstract boolean hasAgeToFly();
}
