package com.deextinction.client.gui;

import java.awt.Point;

import net.minecraft.util.math.MathHelper;

public abstract class GuiEntityLiving extends GuiEntity
{
	public static final int MOVING = 1 << 0;
	public static final int STOPPING = 1 << 1;
	public static final int TURNING_LEFT = 1 << 2;
	public static final int TURNING_RIGHT = 1 << 3;
	public static final int WANDERING = 1 << 4;
	public static final int FLOATING_TOWARDS = 1 << 5;
	public static final int ATTACKING = 1 << 6;
	public static final int FOLLOWING = 1 << 7;
	public static final int FOLLOWING_FRIEND = 1 << 8;

	protected Point targetPos;
	private int states;

	public GuiEntityLiving(int id, int textureX, int textureY, int textureWidth, int textureHeight, int textureAnimMax, double posX, double posY, double velocity, double velocityMax, double acceleration, double yaw, double yawVelocityMax, double yawAcceleration)
	{
		super(id, textureX, textureY, textureWidth, textureHeight, textureAnimMax, posX, posY, velocity, velocityMax, acceleration, yaw, yawVelocityMax, yawAcceleration);
	}

	public void setStates(int states)
	{
		this.states = states;
	}

	public int getStates()
	{
		return this.states;
	}

	public void setMoving(boolean flag)
	{
		if (flag && !this.isStopping())
			this.setStates(this.states | GuiEntityLiving.MOVING);
		else
			this.setStates(this.states & ~GuiEntityLiving.MOVING);
	}

	public boolean isMoving()
	{
		return (this.states & GuiEntityLiving.MOVING) == GuiEntityLiving.MOVING;
	}

	public void setStopping(boolean flag)
	{
		if (flag && !this.isMoving())
			this.setStates(this.states | GuiEntityLiving.STOPPING);
		else
			this.setStates(this.states & ~GuiEntityLiving.STOPPING);
	}

	public boolean isStopping()
	{
		return (this.states & GuiEntityLiving.STOPPING) == GuiEntityLiving.STOPPING;
	}

	public void setTurningLeft(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.TURNING_LEFT);
		else
			this.setStates(this.states & ~GuiEntityLiving.TURNING_LEFT);
	}

	public boolean isTurningLeft()
	{
		return (this.states & GuiEntityLiving.TURNING_LEFT) == GuiEntityLiving.TURNING_LEFT;
	}

	public void setTurningRight(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.TURNING_RIGHT);
		else
			this.setStates(this.states & ~GuiEntityLiving.TURNING_RIGHT);
	}

	public boolean isTurningRight()
	{
		return (this.states & GuiEntityLiving.TURNING_RIGHT) == GuiEntityLiving.TURNING_RIGHT;
	}

	public void setWandering(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.WANDERING);
		else
			this.setStates(this.states & ~GuiEntityLiving.WANDERING);
	}

	public boolean isWandering()
	{
		return (this.states & GuiEntityLiving.WANDERING) == GuiEntityLiving.WANDERING;
	}

	public void setFloatingTowards(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.FLOATING_TOWARDS);
		else
			this.setStates(this.states & ~GuiEntityLiving.FLOATING_TOWARDS);
	}

	public boolean isFloatingTowards()
	{
		return (this.states & GuiEntityLiving.FLOATING_TOWARDS) == GuiEntityLiving.FLOATING_TOWARDS;
	}

	public void setFollowing(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.FOLLOWING);
		else
			this.setStates(this.states & ~GuiEntityLiving.FOLLOWING);
	}

	public boolean isFollowing()
	{
		return (this.states & GuiEntityLiving.FOLLOWING) == GuiEntityLiving.FOLLOWING;
	}

	public void setFollowingFriend(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.FOLLOWING_FRIEND);
		else
			this.setStates(this.states & ~GuiEntityLiving.FOLLOWING_FRIEND);
	}

	public boolean isFollowingFriend()
	{
		return (this.states & GuiEntityLiving.FOLLOWING_FRIEND) == GuiEntityLiving.FOLLOWING_FRIEND;
	}

	public void setAttacking(boolean flag)
	{
		if (flag)
			this.setStates(this.states | GuiEntityLiving.ATTACKING);
		else
			this.setStates(this.states & ~GuiEntityLiving.ATTACKING);
	}

	public boolean isAttacking()
	{
		return (this.states & GuiEntityLiving.ATTACKING) == GuiEntityLiving.ATTACKING;
	}

	public void clearStatus()
	{
		this.setStates(0);
	}

	protected void handleAnimation(int chance)
	{
		if (GuiEntity.RANDOM.nextInt(chance) == 0)
		{
			this.textureAnim++;
			if (this.textureAnim > this.textureAnimMax)
				this.textureAnim = 0;
		}
	}

	protected void handleAnimationRandomly(int chance)
	{
		if (GuiEntity.RANDOM.nextInt(chance) == 0)
		{
			if (GuiEntity.RANDOM.nextBoolean())
				this.textureAnim++;
			else
				this.textureAnim--;

			if (this.textureAnim > this.textureAnimMax)
				this.textureAnim = 0;
			else if (this.textureAnim < 0)
				this.textureAnim = this.textureAnimMax;
		}
	}

	protected void handleMovement(double friction, int minX, int minY, int maxX, int maxY)
	{
		if (this.isMoving())
		{
			this.velocity += this.acceleration;
			this.velocity = MathHelper.clamp(this.velocity, 0.0D, this.velocityMax);
		}
		else if (this.isStopping())
		{
			this.velocity = this.velocity * friction - this.acceleration;
			this.velocity = MathHelper.clamp(this.velocity, 0.0D, this.velocityMax);
		}
		else
		{
			if (this.velocity > this.acceleration)
			{
				this.velocity *= friction;
			}
			else
				this.velocity = 0.0D;
		}

		if (this.isTurningRight() && this.isTurningLeft())
		{

		}
		else
		{
			if (this.isTurningLeft())
			{
				this.yawVelocity += this.yawAcceleration;
				this.yawVelocity = MathHelper.clamp(this.yawVelocity, -this.yawVelocityMax, this.yawVelocityMax);
			}
			else if (this.isTurningRight())
			{
				this.yawVelocity -= this.yawAcceleration;
				this.yawVelocity = MathHelper.clamp(this.yawVelocity, -this.yawVelocityMax, this.yawVelocityMax);
			}
			else
			{
				if (this.yawVelocity * this.yawVelocity > this.yawAcceleration * this.yawAcceleration)
					this.yawVelocity *= friction;
				else
					this.yawVelocity = 0.0D;
			}
		}

		this.yaw += this.yawVelocity;
		this.yaw = MathHelper.wrapDegrees(this.yaw);
		double yawRadians = Math.toRadians(this.yaw);
		double nextX = this.posX + this.velocity * Math.cos(yawRadians);
		double nextY = this.posY - this.velocity * Math.sin(yawRadians);

		if (Math.floor(nextX) < minX)
		{
			if (this.yaw > 0)
				this.yaw = 180 - this.yaw;
			else
				this.yaw = 180 - this.yaw;
		}
		else if (Math.ceil(nextX) > maxX - this.getBounds().getWidth())
		{
			if (this.yaw > 180)
				this.yaw = 180 - this.yaw;
			else
				this.yaw = 180 - this.yaw;
		}
		else
			this.posX = nextX;

		if (Math.floor(nextY) < minY)
		{
			if (this.yaw > 0)
				this.yaw = -this.yaw;
			else
				this.yaw = -this.yaw;
		}
		else if (Math.ceil(nextY) > maxY - this.getBounds().getHeight())
		{
			if (this.yaw > 180)
				this.yaw = -this.yaw;
			else
				this.yaw = -this.yaw;
		}
		else
			this.posY = nextY;
	}

	protected void moveRandomly()
	{
		if (this.isMoving())
		{
			if (GuiEntityLiving.RANDOM.nextInt(200) == 0)
				this.setMoving(false);

			if (this.isTurningLeft() || this.isTurningRight())
			{
				if (GuiEntityLiving.RANDOM.nextInt(10) == 0)
				{
					this.setTurningLeft(false);
					this.setTurningRight(false);
				}
			}
			else
			{
				if (GuiEntityLiving.RANDOM.nextInt(20) == 0)
				{
					if (GuiEntityLiving.RANDOM.nextBoolean())
						this.setTurningLeft(true);
					else
						this.setTurningRight(true);
				}
			}
		}
		else
		{
			if (GuiEntityLiving.RANDOM.nextInt(100) == 0)
				this.setMoving(true);

			if (this.isTurningLeft() || this.isTurningRight())
			{
				if (GuiEntityLiving.RANDOM.nextInt(10) == 0)
				{
					this.setTurningLeft(false);
					this.setTurningRight(false);
				}
			}
			else
			{
				if (GuiEntityLiving.RANDOM.nextInt(100) == 0)
				{
					if (GuiEntityLiving.RANDOM.nextBoolean())
						this.setTurningLeft(true);
					else
						this.setTurningRight(true);
				}
			}
		}
	}

	protected void moveSlowlyRandomly()
	{
		if (this.isMoving())
		{
			if (GuiEntityLiving.RANDOM.nextInt(200) == 0)
				this.setMoving(false);

			if (this.isTurningLeft() || this.isTurningRight())
			{
				if (GuiEntityLiving.RANDOM.nextInt(10) == 0)
				{
					this.setTurningLeft(false);
					this.setTurningRight(false);
				}
			}
			else
			{
				if (GuiEntityLiving.RANDOM.nextInt(20) == 0)
				{
					if (GuiEntityLiving.RANDOM.nextBoolean())
						this.setTurningLeft(true);
					else
						this.setTurningRight(true);
				}
			}
		}
		else
		{
			if (GuiEntityLiving.RANDOM.nextInt(100) == 0)
				this.setMoving(true);

			if (this.isTurningLeft() || this.isTurningRight())
			{
				if (GuiEntityLiving.RANDOM.nextInt(10) == 0)
				{
					this.setTurningLeft(false);
					this.setTurningRight(false);
				}
			}
			else
			{
				if (GuiEntityLiving.RANDOM.nextInt(100) == 0)
				{
					if (GuiEntityLiving.RANDOM.nextBoolean())
						this.setTurningLeft(true);
					else
						this.setTurningRight(true);
				}
			}
		}

		double velocityLimit = 0.2D * this.velocityMax;
		if (this.velocity > velocityLimit)
			this.setMoving(false);
		else
			this.setMoving(true);
	}

	protected void moveTowards(GuiEntity object)
	{
		if (!this.isMoving())
			this.setMoving(true);

		if (this.getPosY() != object.getPosY())
		{
			double yawToTarget = this.getYawTo(object);
			if (yawToTarget * yawToTarget > 4.0D * this.yawVelocityMax * this.yawVelocityMax)
			{
				if (!this.isTurningLeft() && !this.isTurningRight())
				{
					if (yawToTarget < 0.0D)
					{
						this.setTurningLeft(true);
						this.setTurningRight(false);
					}
					else
					{
						this.setTurningLeft(false);
						this.setTurningRight(true);
					}
				}
			}
			else
			{
				if (this.isTurningLeft())
				{
					this.setTurningLeft(false);
					this.yawVelocity = 0.0D;
				}
				if (this.isTurningRight())
				{
					this.setTurningRight(false);
					this.yawVelocity = 0.0D;
				}
			}
		}
		else
		{
			if (!this.isTurningLeft())
				this.setTurningLeft(true);
		}
	}

	protected void moveTowards(Point targetPos)
	{
		if (!this.isMoving())
			this.setMoving(true);

		if (this.getPosY() != targetPos.getY())
		{
			double yawToTarget = this.getYawTo(targetPos);
			if (yawToTarget * yawToTarget > 4.0D * this.yawVelocityMax * this.yawVelocityMax)
			{
				if (!this.isTurningLeft() && !this.isTurningRight())
				{
					if (yawToTarget < 0.0D)
					{
						this.setTurningLeft(true);
						this.setTurningRight(false);
					}
					else
					{
						this.setTurningLeft(false);
						this.setTurningRight(true);
					}
				}
			}
			else
			{
				if (this.isTurningLeft())
				{
					this.setTurningLeft(false);
					this.yawVelocity = 0.0D;
				}
				if (this.isTurningRight())
				{
					this.setTurningRight(false);
					this.yawVelocity = 0.0D;
				}
			}
		}
		else
		{
			if (!this.isTurningLeft())
				this.setTurningLeft(true);
		}
	}

	protected void setToFloatTowards(GuiEntity object)
	{
		if (object != null)
		{
			this.setFloatingTowards(true);
			this.targetPos = new Point(object.getPosX(), object.getPosY());
		}
	}

	protected void setToFloatTowards(Point targetPos)
	{
		if (targetPos != null)
		{
			this.setFloatingTowards(true);
			this.targetPos = targetPos;
		}
	}

	protected void AIWandering()
	{
		if (this.isWandering())
		{
			if (this.isFollowing() || this.isAttacking())
			{
				this.setWandering(false);
				this.setMoving(false);
				this.setTurningLeft(false);
				this.setTurningRight(false);
			}
			else
				this.moveRandomly();
		}
		else
		{
			if (!this.isFollowing() && !this.isAttacking())
				this.setWandering(true);
		}
	}

	protected void AIMovingStraightForword()
	{
		if (this.isWandering())
		{
			if (this.isFollowing() || this.isAttacking())
			{
				this.setWandering(false);
				this.setMoving(false);
				this.setTurningLeft(false);
				this.setTurningRight(false);
			}
			else
				this.moveRandomly();
		}
		else
		{
			if (!this.isFollowing() && !this.isAttacking())
				this.setWandering(true);
		}
	}

	protected void AIFloatingToTarget()
	{
		if (this.isFloatingTowards())
		{
			if (this.targetPos == null)
			{
				this.setMoving(false);
				this.setTurningLeft(false);
				this.setTurningRight(false);
				this.setFloatingTowards(false);
			}
			else
			{
				this.moveTowards(this.targetPos);

				double distanceSq = this.getDistanceSqTo(this.targetPos);
				if (distanceSq < 4.0D * this.getBounds().getHeight() * this.getBounds().getHeight())
				{
					this.setMoving(false);
					this.setTurningLeft(false);
					this.setTurningRight(false);
					this.setFloatingTowards(false);
					this.targetPos = null;
				}
			}
		}
	}
}
