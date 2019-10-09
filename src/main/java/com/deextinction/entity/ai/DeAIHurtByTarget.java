package com.deextinction.entity.ai;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityOwnable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class DeAIHurtByTarget extends EntityAIBase
{
	private final EntityCreature creature;
	private EntityLivingBase target;

	private int targetSearchStatus;
	private int targetSearchDelay;
	private int targetUnseenTicks;
	private int revengeTimerOld;
	private int unseenMemoryTicks;

	private final boolean nearbyOnly;
	private boolean shouldCheckSight;
	private boolean shouldBeHelped;
	private boolean babiesPanic;
	private boolean babiesAttack;
	private boolean adultsPanic;
	private boolean adultsAttack;

	public DeAIHurtByTarget(EntityCreature creature)
	{
		this(creature, false, false, false, false, false, true, false);
	}

	public DeAIHurtByTarget(EntityCreature creature, boolean adultsAttack, boolean babiesAttack)
	{
		this(creature, true, adultsAttack, !adultsAttack, babiesAttack, !babiesAttack, true, false);
	}

	public DeAIHurtByTarget(EntityCreature creature, boolean adultsAttack, boolean adultsPanic, boolean babiesAttack, boolean babiesPanic)
	{
		this(creature, true, adultsAttack, adultsPanic, babiesAttack, babiesPanic, true, false);
	}

	public DeAIHurtByTarget(EntityCreature creature, boolean shouldBeHelped, boolean adultsAttack, boolean adultsPanic, boolean babiesAttack, boolean babiesPanic, boolean checkSight, boolean onlyNearby)
	{
		this.creature = creature;

		this.shouldCheckSight = checkSight;
		this.nearbyOnly = onlyNearby;

		this.shouldBeHelped = shouldBeHelped;
		this.adultsAttack = adultsAttack;
		this.adultsPanic = adultsPanic;
		this.babiesAttack = babiesAttack;
		this.babiesPanic = babiesPanic;

		this.unseenMemoryTicks = 60;
		this.setMutexBits(DeAIMutex.MOTION.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		int revengeTimer = this.creature.getRevengeTimer();
		EntityLivingBase revengeTarget = this.creature.getRevengeTarget();
		return revengeTimer != this.revengeTimerOld && revengeTarget != null && this.isSuitableTarget(revengeTarget, false);
	}

	@Override
	public void startExecuting()
	{
		this.setEntityAttackTarget(this.creature, this.creature.getRevengeTarget());
		this.target = this.creature.getAttackTarget();
		this.revengeTimerOld = this.creature.getRevengeTimer();
		this.unseenMemoryTicks = 300;

		if (this.shouldBeHelped)
		{
			double targetDistance = this.getTargetDistance();
			for (EntityCreature othercreature : this.creature.world.getEntitiesWithinAABB(this.creature.getClass(),
					(new AxisAlignedBB(this.creature.posX, this.creature.posY, this.creature.posZ, this.creature.posX + 1.0D, this.creature.posY + 1.0D, this.creature.posZ + 1.0D)).grow(targetDistance, 10.0D, targetDistance)))
			{
				if (this.creature != othercreature && othercreature.getAttackTarget() == null && (!(this.creature instanceof EntityTameable) || ((EntityTameable) this.creature).getOwner() == ((EntityTameable) othercreature).getOwner())
						&& !othercreature.isOnSameTeam(this.creature.getRevengeTarget()))
					this.setEntityAttackTarget(othercreature, this.creature.getRevengeTarget());
			}
		}

		this.targetSearchStatus = 0;
		this.targetSearchDelay = 0;
		this.targetUnseenTicks = 0;
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		EntityLivingBase entitylivingbase = this.creature.getAttackTarget();

		if (entitylivingbase == null)
			entitylivingbase = this.target;

		if (entitylivingbase == null)
			return false;
		else if (!entitylivingbase.isEntityAlive())
			return false;
		else
		{
			Team team = this.creature.getTeam();
			Team team1 = entitylivingbase.getTeam();

			if (team != null && team1 == team)
				return false;
			else
			{
				double d0 = this.getTargetDistance();

				if (this.creature.getDistanceSq(entitylivingbase) > d0 * d0)
					return false;
				else
				{
					if (this.shouldCheckSight)
					{
						if (this.creature.getEntitySenses().canSee(entitylivingbase))
							this.targetUnseenTicks = 0;
						else if (this.targetUnseenTicks++ > this.unseenMemoryTicks)
							return false;
					}

					if (entitylivingbase instanceof EntityPlayer && ((EntityPlayer) entitylivingbase).capabilities.disableDamage)
						return false;
					else
					{
						this.creature.setAttackTarget(entitylivingbase);
						return true;
					}
				}
			}
		}
	}

	@Override
	public void resetTask()
	{
		this.creature.setAttackTarget((EntityLivingBase) null);
		this.target = null;
	}

	protected void setEntityAttackTarget(EntityCreature creature, EntityLivingBase target)
	{
		if (creature.isChild())
		{
			if (this.babiesAttack)
			{
				creature.setRevengeTarget(target);
				creature.setAttackTarget(target);
			}
			else if (this.babiesPanic)
			{
				creature.setRevengeTarget(target);
				creature.setAttackTarget((EntityLivingBase) null);
			}
		}
		else
		{
			if (this.adultsAttack)
			{
				creature.setRevengeTarget(target);
				creature.setAttackTarget(target);
			}
			else if (this.adultsPanic)
			{
				creature.setRevengeTarget(target);
				creature.setAttackTarget((EntityLivingBase) null);
			}
		}
	}

	protected double getTargetDistance()
	{
		IAttributeInstance iattributeinstance = this.creature.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
		return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
	}

	public static boolean isSuitableTarget(EntityLiving attacker, @Nullable EntityLivingBase target, boolean includeInvincibles, boolean checkSight)
	{
		if (target == null || target == attacker || !target.isEntityAlive() || !attacker.canAttackClass(target.getClass()) || attacker.isOnSameTeam(target))
			return false;
		else
		{
			if (attacker instanceof IEntityOwnable && ((IEntityOwnable) attacker).getOwnerId() != null)
			{
				if (target instanceof IEntityOwnable && ((IEntityOwnable) attacker).getOwnerId().equals(((IEntityOwnable) target).getOwnerId()))
					return false;

				if (target == ((IEntityOwnable) attacker).getOwner())
					return false;
			}
			else if (target instanceof EntityPlayer && !includeInvincibles && ((EntityPlayer) target).capabilities.disableDamage)
				return false;

			return !checkSight || attacker.getEntitySenses().canSee(target);
		}
	}

	protected boolean isSuitableTarget(@Nullable EntityLivingBase target, boolean includeInvincibles)
	{
		if (!DeAIHurtByTarget.isSuitableTarget(this.creature, target, includeInvincibles, this.shouldCheckSight) || !this.creature.isWithinHomeDistanceFromPosition(new BlockPos(target)))
			return false;
		else
		{
			if (this.nearbyOnly)
			{
				if (--this.targetSearchDelay <= 0)
					this.targetSearchStatus = 0;

				if (this.targetSearchStatus == 0)
					this.targetSearchStatus = this.canEasilyReach(target) ? 1 : 2;

				if (this.targetSearchStatus == 2)
					return false;
			}

			return true;
		}
	}

	private boolean canEasilyReach(EntityLivingBase target)
	{
		this.targetSearchDelay = 10 + this.creature.getRNG().nextInt(5);
		Path path = this.creature.getNavigator().getPathToEntityLiving(target);

		if (path == null)
			return false;
		else
		{
			PathPoint pathpoint = path.getFinalPathPoint();

			if (pathpoint == null)
				return false;
			else
			{
				int i = pathpoint.x - MathHelper.floor(target.posX);
				int j = pathpoint.z - MathHelper.floor(target.posZ);
				return (double) (i * i + j * j) <= 2.25D;
			}
		}
	}

	public DeAIHurtByTarget setUnseenMemoryTicks(int p_190882_1_)
	{
		this.unseenMemoryTicks = p_190882_1_;
		return this;
	}
}
