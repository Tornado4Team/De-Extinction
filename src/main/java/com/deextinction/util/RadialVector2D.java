package com.deextinction.util;

public class RadialVector2D
{
	/** The length of the vector. */
	public double length;
	/** The yaw of the vector. */
	public double yaw;

	public RadialVector2D()
	{
		this.length = 0.0F;
		this.yaw = 0.0F;
	}

	public RadialVector2D(double length, double yaw)
	{
		this.length = length;
		this.yaw = yaw;
	}

	/** Sets the length of this vector. */
	public void setLength(double length)
	{
		this.length = length;
	}

	/** Returns the length of this vector. */
	public int getLength()
	{
		return (int) this.length;
	}

	/** Sets the yaw of this vector. */
	public void setYaw(double yaw)
	{
		this.yaw = yaw;
	}

	/** Returns the yaw of this vector. */
	public int getYaw()
	{
		return (int) this.yaw;
	}

	/** Copies a given vector. */
	public void copy(RadialVector2D vec)
	{
		this.length = vec.length;
		this.yaw = vec.yaw;
	}

	/**
	 * Adds a value to the current length.
	 * 
	 * @param addition
	 *            Value to be added.
	 */
	public void addLength(double addition)
	{
		this.length += addition;
	}

	/**
	 * Adds a value to the current yaw.
	 * 
	 * @param addition
	 *            Value to be added.
	 */
	public void addYaw(double addition)
	{
		this.yaw += addition;
	}

	/**
	 * Divides the length by a certain values.
	 * 
	 * @param scalar
	 *            Value to divide the vector length.
	 */
	public void divideLength(double scalar)
	{
		this.length /= scalar;
	}

	/**
	 * Divides the yaw by a certain values.
	 * 
	 * @param scalar
	 *            Value to divide the vector yaw.
	 */
	public void divideYaw(double scalar)
	{
		this.yaw /= scalar;
	}

	/**
	 * Multiplies the length by a certain values.
	 * 
	 * @param scalar
	 *            Value to multiply the vector length.
	 */
	public void multiplyLength(double multiplier)
	{
		this.length *= multiplier;
	}

	/**
	 * Multiplies the yaw by a certain values.
	 * 
	 * @param scalar
	 *            Value to multiply the vector yaw.
	 */
	public void multiplyYaw(double multiplier)
	{
		this.yaw *= multiplier;
	}

	/**
	 * Returns the dot-product result of: (this) dot vec.
	 * 
	 * @param vec
	 *            Second vector in the dot product.
	 */
	public double dot(RadialVector2D vec)
	{
		return this.length * Math.cos(this.yaw) * vec.length * Math.cos(vec.yaw) + this.length * Math.sin(this.yaw) * vec.length * Math.sin(vec.yaw);
	}

	/**
	 * Returns the dot-product result of: (this) dot vec.
	 * 
	 * @param vec
	 *            Second vector in the dot product.
	 */
	public double dot(OrthogonalVector2D vec)
	{
		return this.length * Math.cos(this.yaw) * vec.x + this.length * Math.sin(this.yaw) * vec.y;
	}

	/**
	 * Returns the vector represented by: (this) + vec.
	 * 
	 * @param B
	 *            Vector to add to this one.
	 * @return A new Vector2D.
	 */
	public RadialVector2D addVector(RadialVector2D vec)
	{
		return new RadialVector2D(this.length + vec.length, this.yaw + vec.yaw);
	}

	/**
	 * Returns a new instance containing the same information as this one.
	 * 
	 * @return A new Vector2D.
	 */
	@Override
	public RadialVector2D clone()
	{
		return new RadialVector2D(this.length, this.yaw);
	}

	/**
	 * Returns a string depicting this vector.
	 * 
	 * @return "Vector2D(x, y)".
	 */
	@Override
	public String toString()
	{
		return "Vector2D(" + this.length + ", " + this.yaw + ")";
	}

	/**
	 * Returns the distance between this and the specified vector.
	 * 
	 * @return Distance to another vector.
	 */
	public double getDistanceTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.length * Math.cos(this.yaw);
		double dy = vec.length * Math.sin(vec.yaw) - this.length * Math.sin(this.yaw);
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Returns the distance between this and the specified vector.
	 * 
	 * @return Distance to another vector.
	 */
	public double getDistanceTo(OrthogonalVector2D vec)
	{
		double dx = vec.x - this.length * Math.cos(this.yaw);
		double dy = vec.y - this.length * Math.sin(this.yaw);
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Returns the squared distance between this and the specified vector.
	 * 
	 * @return Distance to another vector.
	 */
	public double getDistanceSqTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.length * Math.cos(this.yaw);
		double dy = vec.length * Math.sin(vec.yaw) - this.length * Math.sin(this.yaw);
		return dx * dx + dy * dy;
	}

	/**
	 * Returns the squared distance between this and the specified vector.
	 * 
	 * @return Distance to another vector.
	 */
	public double getDistanceSqTo(OrthogonalVector2D vec)
	{
		double dx = vec.x - this.length * Math.cos(this.yaw);
		double dy = vec.y - this.length * Math.sin(this.yaw);
		return dx * dx + dy * dy;
	}
}
