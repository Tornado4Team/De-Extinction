package com.deextinction.entity;

import com.deextinction.util.MinecraftTime;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedAnimalAmphibious extends EntityDeExtinctedAnimal
{
	private static final int MAX_TIME_ON_LAND = MinecraftTime.TICKS_PER_MINUTE;
	public int timeOnLand = 0;

	public EntityDeExtinctedAnimalAmphibious(World worldIn)
	{
		super(worldIn);
	}

	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();

		if (!this.world.isRemote && this.isInWater())
			this.switchToWaterNavigator();
		else if (!this.world.isRemote && !this.isInWater())
			this.switchToLandNavigator();

		if (this.isInWater())
		{
			this.timeOnLand--;

			if (this.isSitting())
				this.setSitting(false);

			if (this.isSleeping())
				this.setSleeping(false);
		}
		else
		{
			this.timeOnLand++;
		}
	}

	@Override
	public void travel(float strafe, float vertical, float forward)
	{
		if (this.isServerWorld() && this.isInLiquid())
		{
			this.moveRelative(strafe, vertical, forward, 0.1F);
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			this.motionX *= 0.8999999761581421D;
			this.motionY *= 0.8999999761581421D;
			this.motionZ *= 0.8999999761581421D;

			this.renderYawOffset = this.rotationYaw;
			this.prevLimbSwingAmount = this.limbSwingAmount;
			double dPosX = this.posX - this.prevPosX;
			double dPosZ = this.posZ - this.prevPosZ;
			double dPosY = this.isFlying() ? this.posY - this.prevPosY : 0.0D;

			float dLimbSwingAmount = MathHelper.sqrt(dPosX * dPosX + dPosY * dPosY + dPosZ * dPosZ) * 4.0F;
			if (dLimbSwingAmount > 1.0F)
				dLimbSwingAmount = 1.0F;

			this.limbSwingAmount += (dLimbSwingAmount - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;
		}
		else
			super.travel(strafe, vertical, forward);
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	public boolean isOnLadder()
	{
		return false;
	}

	@Override
	protected PathNavigate createNavigator(World worldIn)
	{
		if (this.isInLiquid())
			return new PathNavigateSwimmer(this, world);
		else
			return new PathNavigateAmphibious(this, world);
	}

	@Override
	public boolean isNotColliding()
	{
		return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
	}

	@Override
	public boolean isInWater()
	{
		return super.isInWater() || this.isInsideOfMaterial(Material.CORAL);
	}

	protected boolean isInLiquid()
	{
		return this.isInWater() || this.isInLava();
	}

	@Override
	public boolean shouldDismountInWater(Entity rider)
	{
		return false;
	}

	@Override
	public boolean canBreatheUnderwater()
	{
		return true;
	}

	@Override
	public boolean isPushedByWater()
	{
		return false;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
	{
		super.writeEntityToNBT(compound);
		compound.setInteger("TimeOnLand", this.timeOnLand);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.timeOnLand = compound.getInteger("TimeOnLand");
	}

	protected void switchNavigator(boolean onLand)
	{
		if (onLand)
			this.switchToLandNavigator();
		else
			this.switchToWaterNavigator();
	}

	protected void switchToLandNavigator()
	{
		this.navigator = new PathNavigateAmphibious(this, world);
	}

	protected void switchToWaterNavigator()
	{
		this.navigator = new PathNavigateSwimmer(this, world);
	}
}
