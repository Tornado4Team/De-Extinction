package com.deextinction.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedAnimalAquatic extends EntityDeExtinctedAnimal
{

	public EntityDeExtinctedAnimalAquatic(World worldIn)
	{
		super(worldIn);
		this.moveHelper = new EntityDeExtinctedAnimalAquatic.SwimmingMoveHelper(this);
		this.navigator = new PathNavigateSwimmer(this, world);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.shouldJumpOnLand() && !this.inWater && this.onGround)
		{
			if (this.rand.nextDouble() < 0.01D)
			{
				this.motionY += this.height * 0.25D;
				this.motionX += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.25D);
				this.motionZ += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.25D);
				this.rotationYaw = 45.0F - 90.0F * this.rand.nextFloat();
				this.onGround = false;
				this.isAirBorne = true;
			}
		}

		if (this.world.isRemote)
		{
			if (this.isInWater())
			{
				if (this.motionX * this.motionX > 0.01D || this.motionZ * this.motionZ > 0.01D)
				{
					if (this.rand.nextFloat() < 0.2F)
					{
						Vec3d lookDirection = this.getLook(0.0F);
						for (int i = 0; i < 2; i++)
							this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX + (this.rand.nextDouble() - 0.5D) * (double) this.width - lookDirection.x * 1.5D, this.posY + this.rand.nextDouble() * (double) this.height - lookDirection.y * 1.5D,
									this.posZ + (this.rand.nextDouble() - 0.5D) * (double) this.width - lookDirection.z * 1.5D, 0.0D, 0.0D, 0.0D);
					}
				}
				else if (this.rand.nextFloat() < 0.01F)
					this.spawnBubbleParticles(3, this.width, 0.9F * this.getEyeHeight(), 0.5D);
			}
		}
	}

	@Override
	public void onEntityUpdate()
	{
		int air = this.getAir();
		super.onEntityUpdate();

		if (this.isEntityAlive() && !this.isInWater())
		{
			this.setAir(air--);

			if (this.getAir() == -20)
			{
				this.setAir(0);
				this.attackEntityFrom(DamageSource.DROWN, 2.0F);
			}
		}
		else
			this.setAir(this.getMaxAir());
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
			double dPosY = this.posY - this.prevPosY;

			float dPos = MathHelper.sqrt(dPosX * dPosX + dPosY * dPosY + dPosZ * dPosZ) * 4.0F;
			if (dPos > 1.0F)
				dPos = 1.0F;

			this.limbSwingAmount += (dPos - this.limbSwingAmount) * 0.4F;
			this.limbSwing += this.limbSwingAmount;

			this.prevRotationPitch = this.rotationPitch;
			this.rotationPitch -= 180.0F * (float) (dPosY / dPos);
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
		return new PathNavigateSwimmer(this, world);
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

	public int getMaxAir()
	{
		return 300;
	}

	protected boolean shouldJumpOnLand()
	{
		return true;
	}

	protected static class WaterMoveHelper extends EntityMoveHelper
	{

		public WaterMoveHelper(EntityDeExtinctedAnimalAquatic animal)
		{
			super(animal);
		}

		@Override
		public void onUpdateMoveHelper()
		{
			if (this.entity.isInWater())
				this.entity.motionY += 0.005D;

			if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.entity.getNavigator().noPath())
			{
				double dPosX = this.posX - this.entity.posX;
				double dPosY = this.posY - this.entity.posY;
				double dPosZ = this.posZ - this.entity.posZ;
				double dPos = dPosX * dPosX + dPosY * dPosY + dPosZ * dPosZ;
				if (dPos < (double) 2.5000003E-7F)
					this.entity.setMoveForward(0.0F);
				else
				{
					float dYaw = (float) (MathHelper.atan2(dPosZ, dPosX) * (double) (180F / (float) Math.PI)) - 90.0F;
					this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, dYaw, 10.0F);
					this.entity.renderYawOffset = this.entity.rotationYaw;
					this.entity.rotationYawHead = this.entity.rotationYaw;

					float speed = 0.0F;
					if (this.entity.isInWater())
						speed = (float) (this.speed * this.entity.getEntityAttribute(EntityLivingBase.SWIM_SPEED).getAttributeValue());
					else
						speed = (float) (this.speed * this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());

					if (this.entity.isInWater())
					{
						this.entity.setAIMoveSpeed(speed * 0.02F);
						float dPitch = -((float) (MathHelper.atan2(dPosY, (double) MathHelper.sqrt(dPosX * dPosX + dPosZ * dPosZ)) * (double) (180F / (float) Math.PI)));
						dPitch = MathHelper.clamp(MathHelper.wrapDegrees(dPitch), -85.0F, 85.0F);
						this.entity.rotationPitch = this.limitAngle(this.entity.rotationPitch, dPitch, 5.0F);
						float motionFoward = MathHelper.cos(this.entity.rotationPitch * ((float) Math.PI / 180F));
						float motionVertical = MathHelper.sin(this.entity.rotationPitch * ((float) Math.PI / 180F));
						this.entity.moveForward = motionFoward * speed;
						this.entity.moveVertical = -motionVertical * speed;
					}
					else
						this.entity.setAIMoveSpeed(speed * 0.1F);
				}
			}
			else
			{
				this.entity.setAIMoveSpeed(0.0F);
				this.entity.setMoveStrafing(0.0F);
				this.entity.setMoveVertical(0.0F);
				this.entity.setMoveForward(0.0F);
			}
		}
	}

	class SwimmingMoveHelper extends EntityMoveHelper
	{

		public SwimmingMoveHelper(EntityDeExtinctedAnimalAquatic swimmer)
		{
			super(swimmer);
		}

		@Override
		public void onUpdateMoveHelper()
		{
			if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.entity.getNavigator().noPath())
			{
				double distanceX = this.posX - this.entity.posX;
				double distanceY = this.posY - this.entity.posY;
				double distanceZ = this.posZ - this.entity.posZ;
				double distance = Math.abs(distanceX * distanceX + distanceY * distanceY + distanceZ * distanceZ);
				distance = (double) MathHelper.sqrt(distance);
				distanceY /= distance;
				float f = (float) (Math.atan2(distanceZ, distanceX) * 180.0D / Math.PI) - 90.0F;
				this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, f, 30.0F);

				if (this.entity.isInWater())
					this.entity.setAIMoveSpeed((float) (this.entity.getEntityAttribute(EntityLivingBase.SWIM_SPEED).getAttributeValue() * this.speed));
				else
					this.entity.setAIMoveSpeed((float) (this.entity.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * this.speed));

				this.entity.motionY += (double) this.entity.getAIMoveSpeed() * distanceY * 0.1D;
			}
			else
			{
				this.entity.setAIMoveSpeed(0.0F);
			}
		}
	}
}
