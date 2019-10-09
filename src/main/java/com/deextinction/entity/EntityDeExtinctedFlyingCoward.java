package com.deextinction.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedFlyingCoward extends EntityDeExtinctedFlyingCreature
{

	public EntityDeExtinctedFlyingCoward(World world)
	{
		super(world);
	}

	@Override
	protected void handleFlying()
	{
		if (!this.world.isRemote)
		{
			if (this.motionY < 0.0D)
				this.motionY *= 0.6D;

			if (this.isSitting())
			{
				if (this.getAttackTarget() != null)
				{
					if (this.isSitting())
						this.setSitting(false, null);
					this.setFlying(true);
				}
			}
			else
			{
				if (this.hasAgeToFly())
				{
					if (this.getAttackTarget() == null)
					{
						if (this.rand.nextInt(300) == 0)
							this.setFlying(!this.isFlying());
					}
					else
					{
						if (this.rand.nextInt(60) == 0)
							this.setAttackTarget(null);

						if (!this.isFlying())
							this.setFlying(true);
					}

					if (this.isFlying())
					{
						this.flyAroundUntilXZ(this.onGround, 15, 5, 15);
						if (this.rand.nextInt(500) == 0)
						{
							this.flyingTarget = null;
							this.flyAroundUntilXZ(this.onGround, 30, 8, 30);
						}
						if (this.collidedHorizontally && this.rand.nextInt(10) == 0)
							this.setFlying(false);
					}
					else if (this.inWater)
						this.motionY += 0.2F;
				}
				else
				{
					if (this.getAttackTarget() == null)
					{
						if (this.rand.nextInt(150) == 0)
							this.jump();
						else if (this.rand.nextInt(600) == 0)
							this.setFlying(true);
					}
					else
					{
						if (this.rand.nextInt(60) == 0)
							this.setAttackTarget(null);

						if (!this.isFlying())
							this.setFlying(true);
					}

					if (this.isFlying())
					{
						this.flyAroundUntilXZ(this.onGround, 5, 3, 5);

						if (this.collidedHorizontally && this.rand.nextInt(10) == 0)
							this.setFlying(false);
					}
					else if (this.inWater)
						this.motionY += 0.2F;
				}
			}
		}
	}

	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
	{
		if (this.isEntityInvulnerable(source))
			return false;
		else
		{
			if (amount == 0 && this.isFlying())
				return false;

			Entity entity = source.getTrueSource();

			if (entity instanceof EntityLivingBase)
			{
				EntityLivingBase attacker = (EntityLivingBase) entity;
				List list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(16.0D, 8.0D, 16.0D));
				list.add(this);

				for (int i = 0; i < list.size(); i++)
				{
					Entity nearEntity = (Entity) list.get(i);
					if (nearEntity.getClass() == this.getClass())
					{
						EntityDeExtinctedFlyingCoward validNearEntity = (EntityDeExtinctedFlyingCoward) nearEntity;

						if (validNearEntity.isSitting())
							validNearEntity.setSitting(false);

						if (validNearEntity.isSleeping())
							validNearEntity.setSleeping(false);

						validNearEntity.setAttackTarget(attacker);
					}
				}
			}

			if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
				amount = (amount + 1.0F) / 2.0F;

			return super.attackEntityFrom(source, amount);
		}
	}

	public void forceFly()
	{
		if (!this.isFlying())
			this.setFlying(true);
		this.flyingTarget = null;
		this.flyAroundUntilXZ(this.onGround, 30, 8, 30);
	}
}
