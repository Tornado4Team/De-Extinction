package com.deextinction.entity.newversion.my;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedDolphin extends EntityDeExtinctedAnimalWater
{
	private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(EntityDeExtinctedDolphin.class, DataSerializers.VARINT);

	private static final DataParameter<Boolean> GOT_FISH = EntityDataManager.createKey(EntityDeExtinctedDolphin.class, DataSerializers.BOOLEAN);
	public static final Predicate<EntityItem> ITEM_SELECTOR = (itemEntity) -> {
		return !itemEntity.cannotPickup() && itemEntity.isEntityAlive() && itemEntity.isInWater();
	};

	private final EntityLookHelper lookHelper_new;

	public EntityDeExtinctedDolphin(World world)
	{
		super(world);
		this.moveHelper = new EntityDeExtinctedDolphin.MoveHelper(this);
		this.lookHelper_new = new EntityDeExtinctedDolphinHelper(this, 10);
		this.setCanPickUpLoot(true);
	}

	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(0, new EntityAIBreathAir(this));
		this.tasks.addTask(0, new EntityAIFindWater(this));
		this.tasks.addTask(4, new EntityAIWanderSwim(this, 1.0D, 10));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAIJump(this, 10));
		this.tasks.addTask(6, new EntityAIAttackMelee(this, (double) 1.2F, true));
		this.tasks.addTask(9, new EntityAIAvoidEntity<>(this, EntityGuardian.class, 8.0F, 1.0D, 1.0D));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, EntityGuardian.class));
	}

	@Override
	@Nullable
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
	{
		this.setAir(this.getMaxAir());
		this.rotationPitch = 0.0F;
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataManager.register(EntityDeExtinctedDolphin.GOT_FISH, false);
		this.dataManager.register(EntityDeExtinctedDolphin.MOISTNESS, 2400);
	}

	public boolean hasGotFish()
	{
		return this.dataManager.get(EntityDeExtinctedDolphin.GOT_FISH);
	}

	public void setGotFish(boolean gotFish)
	{
		this.dataManager.set(EntityDeExtinctedDolphin.GOT_FISH, gotFish);
	}

	public int getMoistness()
	{
		return this.dataManager.get(EntityDeExtinctedDolphin.MOISTNESS);
	}

	public void setMoistness(int moistness)
	{
		this.dataManager.set(EntityDeExtinctedDolphin.MOISTNESS, moistness);
	}

	@Override
	public EntityLookHelper getLookHelper()
	{
		return this.lookHelper_new;
	}

	@Override
	public boolean canBreatheUnderwater()
	{
		return false;
	}

	@Override
	protected void updateAir(int prevAir)
	{
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound tagCompound)
	{
		super.writeEntityToNBT(tagCompound);
		tagCompound.setBoolean("GotFish", this.hasGotFish());
		tagCompound.setInteger("Moistness", this.getMoistness());
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound tagCompound)
	{
		super.readEntityFromNBT(tagCompound);
		this.setGotFish(tagCompound.getBoolean("GotFish"));
		this.setMoistness(tagCompound.getInteger("Moistness"));
	}

	@Override
	protected PathNavigate createNavigator(World worldIn)
	{
		return new PathNavigateSwimmer(this, worldIn);
	}

	@Override
	public boolean attackEntityAsMob(Entity entityIn)
	{
		boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) ((int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
		if (flag)
			this.applyEnchantments(this, entityIn);

		return flag;
	}

	@Override
	public int getMaxAir()
	{
		return 4800;
	}

	protected int determineNextAir(int currentAir)
	{
		return this.getMaxAir();
	}

	@Override
	public int getVerticalFaceSpeed()
	{
		return 1;
	}

	@Override
	public int getHorizontalFaceSpeed()
	{
		return 1;
	}

	@Override
	protected boolean canBeRidden(Entity entityIn)
	{
		return true;
	}

	@Override
	protected void updateEquipmentIfNeeded(EntityItem itemEntity)
	{
		if (this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty())
		{
			ItemStack itemstack = itemEntity.getItem();
			if (this.canEquipItem(itemstack))
			{
				this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack);
				this.inventoryHandsDropChances[EntityEquipmentSlot.MAINHAND.getIndex()] = 2.0F;
				this.onItemPickup(itemEntity, itemstack.getCount());
				itemEntity.setDead();
			}
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();
		if (!this.isAIDisabled())
		{
			if (this.world.isRainingAt(this.getPosition()))
				this.setMoistness(2400);
			else
			{
				this.setMoistness(this.getMoistness() - 1);
				if (this.getMoistness() <= 0)
					this.attackEntityFrom(DamageSource.ON_FIRE, 1.0F);

				if (this.shouldJumpOnLand() && this.onGround)
				{
					this.motionY += 0.5D;
					this.motionX += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F);
					this.motionZ += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.2F);
					this.rotationYaw = this.rand.nextFloat() * 360.0F;
					this.onGround = false;
					this.isAirBorne = true;
				}
			}

			if (this.world.isRemote && this.isInWater() && this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ > 0.03D)
			{
				Vec3d vec3d = this.getLook(0.0F);
				float f = MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F)) * 0.3F;
				float f1 = MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F)) * 0.3F;
				float f2 = 1.2F - this.rand.nextFloat() * 0.7F;

				for (int i = 0; i < 2; ++i)
				{
					this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - vec3d.x * (double) f2 + (double) f, this.posY - vec3d.y, this.posZ - vec3d.z * (double) f2 + (double) f1, 0.0D, 0.0D, 0.0D);
					this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - vec3d.x * (double) f2 - (double) f, this.posY - vec3d.y, this.posZ - vec3d.z * (double) f2 - (double) f1, 0.0D, 0.0D, 0.0D);
				}
			}
		}
	}

	@Override
	public boolean processInteract(EntityPlayer player, EnumHand hand)
	{
		ItemStack itemstack = player.getHeldItem(hand);
		if (!itemstack.isEmpty() && itemstack.getItem() == Items.FISH)
		{
			if (!this.world.isRemote)
				this.playSound(SoundEvents.ENTITY_EGG_THROW, 1.0F, 1.0F);

			this.setGotFish(true);
			if (!player.capabilities.isCreativeMode)
				itemstack.shrink(1);

			return true;
		}
		else
			return super.processInteract(player, hand);
	}

	@Nullable
	public EntityItem throwItem(ItemStack itemStack)
	{
		if (itemStack.isEmpty())
			return null;
		else
		{
			double d0 = this.posY - (double) 0.3F + (double) this.getEyeHeight();
			EntityItem entityitem = new EntityItem(this.world, this.posX, d0, this.posZ, itemStack);
			entityitem.setPickupDelay(40);
			float f = 0.3F;
			entityitem.motionX = (double) (-MathHelper.sin(this.rotationYaw * ((float) Math.PI / 180F)) * MathHelper.cos(this.rotationPitch * ((float) Math.PI / 180F)) * f);
			entityitem.motionY = (double) (MathHelper.sin(this.rotationPitch * ((float) Math.PI / 180F)) * f * 1.5F);
			entityitem.motionZ = (double) (MathHelper.cos(this.rotationYaw * ((float) Math.PI / 180F)) * MathHelper.cos(this.rotationPitch * ((float) Math.PI / 180F)) * f);
			float f1 = this.rand.nextFloat() * ((float) Math.PI * 2F);
			f = 0.02F * this.rand.nextFloat();
			entityitem.motionX += (double) (MathHelper.cos(f1) * f);
			entityitem.motionZ += (double) (MathHelper.sin(f1) * f);
			this.world.spawnEntity(entityitem);
			return entityitem;
		}
	}

	@Override
	public void travel(float strafe, float vertical, float forward)
	{
		if (this.isServerWorld() && this.isInWater())
		{
			this.moveRelative(strafe, vertical, forward, this.getAIMoveSpeed());
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
			this.motionX *= (double) 0.9F;
			this.motionY *= (double) 0.9F;
			this.motionZ *= (double) 0.9F;
			if (this.getAttackTarget() == null)
				this.motionY -= 0.005D;

			this.renderYawOffset = this.rotationYaw;
			double dPosX = this.posX - this.prevPosX;
			double dPosZ = this.posZ - this.prevPosZ;
			double dPosY = this.posY - this.prevPosY;

			float dPos = MathHelper.sqrt(dPosX * dPosX + dPosY * dPosY + dPosZ * dPosZ) * 4.0F;
			if (dPos > 1.0F)
				dPos = 1.0F;

			this.prevRotationPitch = this.rotationPitch;
			this.rotationPitch -= 180.0F * (float) (dPosY / dPos);
		}
		else
			super.travel(strafe, vertical, forward);
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer player)
	{
		return true;
	}

	static class MoveHelper extends EntityMoveHelper
	{
		private final EntityDeExtinctedDolphin dolphin;

		public MoveHelper(EntityDeExtinctedDolphin animal)
		{
			super(animal);
			this.dolphin = animal;
		}

		public void tick()
		{
			if (this.dolphin.isInWater())
			{
				this.dolphin.motionY += 0.005D;
			}

			if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.dolphin.getNavigator().noPath())
			{
				double d0 = this.posX - this.dolphin.posX;
				double d1 = this.posY - this.dolphin.posY;
				double d2 = this.posZ - this.dolphin.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;
				if (d3 < (double) 2.5000003E-7F)
					this.entity.setMoveForward(0.0F);
				else
				{
					float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
					this.dolphin.rotationYaw = this.limitAngle(this.dolphin.rotationYaw, f, 10.0F);
					this.dolphin.renderYawOffset = this.dolphin.rotationYaw;
					this.dolphin.rotationYawHead = this.dolphin.rotationYaw;
					float f1 = (float) (this.speed * this.dolphin.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
					if (this.dolphin.isInWater())
					{
						this.dolphin.setAIMoveSpeed(f1 * 0.02F);
						float f2 = -((float) (MathHelper.atan2(d1, (double) MathHelper.sqrt(d0 * d0 + d2 * d2)) * (double) (180F / (float) Math.PI)));
						f2 = MathHelper.clamp(MathHelper.wrapDegrees(f2), -85.0F, 85.0F);
						this.dolphin.rotationPitch = this.limitAngle(this.dolphin.rotationPitch, f2, 5.0F);
						float f3 = MathHelper.cos(this.dolphin.rotationPitch * ((float) Math.PI / 180F));
						float f4 = MathHelper.sin(this.dolphin.rotationPitch * ((float) Math.PI / 180F));
						this.dolphin.moveForward = f3 * f1;
						this.dolphin.moveVertical = -f4 * f1;
					}
					else
						this.dolphin.setAIMoveSpeed(f1 * 0.1F);
				}
			}
			else
			{
				this.dolphin.setAIMoveSpeed(0.0F);
				this.dolphin.setMoveStrafing(0.0F);
				this.dolphin.setMoveVertical(0.0F);
				this.dolphin.setMoveForward(0.0F);
			}
		}
	}
}
