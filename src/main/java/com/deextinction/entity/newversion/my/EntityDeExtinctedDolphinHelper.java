package com.deextinction.entity.newversion.my;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.util.math.MathHelper;

public class EntityDeExtinctedDolphinHelper extends EntityLookHelper
{
	private final EntityLiving entity_water;
	private float deltaLookYaw_water;
	private float deltaLookPitch_water;
	private boolean isLooking_water;
	private double posX_water;
	private double posY_water;
	private double posZ_water;
	private final int yawLimit;

	public EntityDeExtinctedDolphinHelper(EntityLiving entity, int yawLimit)
	{
		super(entity);
		this.yawLimit = yawLimit;
		this.entity_water = entity;
	}

	@Override
	public void onUpdateLook()
	{
		if (this.isLooking_water)
		{
			this.isLooking_water = false;
			double d0 = this.posX_water - this.entity_water.posX;
			double d1 = this.posY_water - (this.entity_water.posY + (double) this.entity_water.getEyeHeight());
			double d2 = this.posZ_water - this.entity_water.posZ;
			double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
			float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F + 20.0F;
			float f1 = (float) (-(MathHelper.atan2(d1, d3) * (double) (180F / (float) Math.PI))) + 10.0F;
			this.entity_water.rotationPitch = this.updateRotation2(this.entity_water.rotationPitch, f1, this.deltaLookPitch_water);
			this.entity_water.rotationYawHead = this.updateRotation2(this.entity_water.rotationYawHead, f, this.deltaLookYaw_water);
		}
		else
		{
			if (this.entity_water.getNavigator().noPath())
			{
				this.entity_water.rotationPitch = this.updateRotation2(this.entity_water.rotationPitch, 0.0F, 5.0F);
			}

			this.entity_water.rotationYawHead = this.updateRotation2(this.entity_water.rotationYawHead, this.entity_water.renderYawOffset, this.deltaLookYaw_water);
		}

		float f2 = MathHelper.wrapDegrees(this.entity_water.rotationYawHead - this.entity_water.renderYawOffset);
		if (f2 < (float) (-this.yawLimit))
		{
			this.entity_water.renderYawOffset -= 4.0F;
		}
		else if (f2 > (float) this.yawLimit)
		{
			this.entity_water.renderYawOffset += 4.0F;
		}

	}

	@Override
	public void setLookPositionWithEntity(Entity entityIn, float deltaYaw, float deltaPitch)
	{
		this.posX_water = entityIn.posX;

		if (entityIn instanceof EntityLivingBase)
		{
			this.posY_water = entityIn.posY + (double) entityIn.getEyeHeight();
		}
		else
		{
			this.posY_water = (entityIn.getEntityBoundingBox().minY + entityIn.getEntityBoundingBox().maxY) / 2.0D;
		}

		this.posZ_water = entityIn.posZ;
		this.deltaLookYaw_water = deltaYaw;
		this.deltaLookPitch_water = deltaPitch;
		this.isLooking_water = true;
	}

	@Override
	public void setLookPosition(double x, double y, double z, float deltaYaw, float deltaPitch)
	{
		this.posX_water = x;
		this.posY_water = y;
		this.posZ_water = z;
		this.deltaLookYaw_water = deltaYaw;
		this.deltaLookPitch_water = deltaPitch;
		this.isLooking_water = true;
	}

	@Override
	public boolean getIsLooking()
	{
		return this.isLooking_water;
	}

	@Override
	public double getLookPosX()
	{
		return this.posX_water;
	}

	@Override
	public double getLookPosY()
	{
		return this.posY_water;
	}

	@Override
	public double getLookPosZ()
	{
		return this.posZ_water;
	}

	private float updateRotation2(float rotation, float dRotation, float limit)
	{
		float dr = MathHelper.wrapDegrees(dRotation - rotation);

		if (dr > limit)
			dr = limit;

		if (dr < -limit)
			dr = -limit;

		return rotation + dr;
	}
}
