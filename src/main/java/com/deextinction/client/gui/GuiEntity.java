package com.deextinction.client.gui;

import java.awt.Point;
import java.util.Random;

import org.lwjgl.util.Rectangle;

import com.deextinction.client.gui.inventory.GuiMicroscope;
import com.deextinction.util.OrthogonalVector2D;
import com.deextinction.util.RadialVector2D;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public abstract class GuiEntity extends Gui
{
	protected static final Random RANDOM = new Random();

	protected int id;
	protected double posX;
	protected double posY;
	protected int textureX;
	protected int textureY;
	protected int textureWidth;
	protected int textureHeight;
	protected int textureAnim;
	protected int textureAnimMax;
	protected double velocity;
	protected double velocityMax;
	protected double acceleration;
	protected double yaw;
	protected double yawVelocity;
	protected double yawVelocityMax;
	protected double yawAcceleration;
	protected boolean isCollided;
	protected boolean isDead;
	protected int ticksExisted;

	public GuiEntity(int id, int textureX, int textureY, int textureWidth, int textureHeight, int textureAnimMax, double posX, double posY, double velocity, double velocityMax, double acceleration, double yaw, double yawVelocityMax, double yawAcceleration)
	{
		this.id = id;
		this.textureX = textureX;
		this.textureY = textureY;
		this.textureWidth = textureWidth;
		this.textureHeight = textureHeight;
		this.textureAnim = GuiEntity.RANDOM.nextInt(textureAnimMax);
		this.textureAnimMax = textureAnimMax;
		this.posX = posX;
		this.posY = posY;
		this.velocity = velocity;
		this.velocityMax = velocityMax;
		this.acceleration = acceleration;
		this.yaw = yaw;
		this.yawVelocity = 0.0D;
		this.yawVelocityMax = yawVelocityMax;
		this.yawAcceleration = yawAcceleration;
		this.isCollided = false;
		this.isDead = false;
		this.ticksExisted = 0;
	}

	public abstract void tick(GuiMicroscope microscope);

	public abstract void draw(Minecraft mc, int mouseX, int mouseY, float partialTicks);

	public abstract Rectangle getBounds();

	public void setID(int id)
	{
		this.id = id;
	}

	public int getID()
	{
		return this.id;
	}

	public int getPosX()
	{
		return (int) posX;
	}

	public int getPosY()
	{
		return (int) posY;
	}

	public double getVelocity()
	{
		return this.velocity;
	}

	public void setVelocity(double velocity)
	{
		this.yaw = velocity;
	}

	public double getVelocityMax()
	{
		return this.velocityMax;
	}

	public double getAcceleration()
	{
		return this.acceleration;
	}

	public double getYaw()
	{
		return this.yaw;
	}

	public void setYaw(double yaw)
	{
		this.yaw = yaw;
	}

	public double getYawVelocity()
	{
		return this.yawVelocity;
	}

	public double getYawVelocityMax()
	{
		return this.yawVelocityMax;
	}

	public double getYawAcceleration()
	{
		return this.yawAcceleration;
	}

	public double getDistanceTo(GuiEntity object)
	{
		double dx = object.posX - this.posX;
		double dy = object.posY - this.posY;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double getDistanceTo(Point point)
	{
		double dx = point.x - this.posX;
		double dy = point.y - this.posY;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double getDistanceTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.posX;
		double dy = vec.length * Math.sin(vec.yaw) - this.posY;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double getDistanceTo(OrthogonalVector2D vec)
	{
		double dx = vec.x - this.posX;
		double dy = vec.y - this.posY;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double getDistanceSqTo(GuiEntity object)
	{
		double dx = object.posX - this.posX;
		double dy = object.posY - this.posY;
		return dx * dx + dy * dy;
	}

	public double getDistanceSqTo(Point point)
	{
		double dx = point.x - this.posX;
		double dy = point.y - this.posY;
		return dx * dx + dy * dy;
	}

	public double getDistanceSqTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.posX;
		double dy = vec.length * Math.sin(vec.yaw) - this.posY;
		return dx * dx + dy * dy;
	}

	public double getDistanceSqTo(OrthogonalVector2D vec)
	{
		double dx = vec.x - this.posX;
		double dy = vec.y - this.posY;
		return dx * dx + dy * dy;
	}

	public double getYawTo(double angle)
	{
		return angle - this.yaw;
	}

	public double getYawTo(GuiEntity object)
	{
		double dx = object.posX - this.posX;
		double dy = object.posY - this.posY;
		if (dy != 0)
			return this.yaw - Math.atan2(-dy, dx);
		else
			return 0.0D;
	}

	public double getYawTo(Point point)
	{
		double dx = point.getX() - this.posX;
		double dy = point.getY() - this.posY;
		if (dy != 0)
			return this.yaw - Math.atan2(-dy, dx);
		else
			return 0.0D;
	}

	public double getYawTo(int posX, int posY)
	{
		double dx = posX - this.posX;
		double dy = posY - this.posY;
		if (dy != 0)
			return this.yaw - Math.atan2(-dy, dx);
		else
			return 0.0D;
	}

	public double getYawTo(double posX, double posY)
	{
		double dx = posX - this.posX;
		double dy = posY - this.posY;
		if (dy != 0)
			return this.yaw - Math.atan2(-dy, dx);
		else
			return 0.0D;
	}

	public double getYawTo(OrthogonalVector2D vec)
	{
		double dx = vec.getX() - this.posX;
		double dy = vec.getY() - this.posY;
		if (dy != 0)
			return this.yaw - Math.atan2(-dy, dx);
		else
			return 0.0D;
	}

	public double getYawTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.posX;
		double dy = vec.length * Math.sin(vec.yaw) - this.posY;
		if (dy != 0)
			return this.yaw - Math.atan2(-dy, dx);
		else
			return 0.0D;
	}

	public void setDead()
	{
		this.isDead = true;
	}
}
