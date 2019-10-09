package com.deextinction.util;

public class OrthogonalVector2D
{
	/** The x coordinate of the vector. */
	public double x;
	/** The y coordinate of the vector. */
	public double y;

	public OrthogonalVector2D()
	{
		this.x = 0.0F;
		this.y = 0.0F;
	}

	public OrthogonalVector2D(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/**
	 * Returns the length of this vector.
	 * 
	 * @return Length of the vector.
	 */
	public double getLength()
	{
		return Math.sqrt(this.x * this.x + this.y * this.y);
	}

	/** Sets the x and y. */
	public void setVector(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	/** Sets the x. */
	public void setX(double x)
	{
		this.x = x;
	}

	/** Returns the x. */
	public int getX()
	{
		return (int) this.x;
	}

	/** Sets the y. */
	public void setY(double y)
	{
		this.y = y;
	}

	/** Returns the y. */
	public int getY()
	{
		return (int) this.y;
	}

	public void setLength(double length)
	{
		double oldLength = this.getLength();
		if (oldLength != 0.0D)
		{
			this.x = this.x * length / oldLength;
			this.y = this.y * length / oldLength;
		}
	}

	public void setYaw(double yaw)
	{
		double legth = this.getLength();
		this.x = legth * Math.cos(yaw);
		this.y = legth * Math.sin(yaw);
	}

	public double getYaw_Rad(double yaw)
	{
		return Math.acos(this.x / this.getLength());
	}

	public double getYaw_Degrees(double yaw)
	{
		return Math.toDegrees(Math.acos(this.x / this.getLength()));
	}

	/** Copies a given vector. */
	public void copy(OrthogonalVector2D vec)
	{
		this.x = vec.x;
		this.y = vec.y;
	}

	/**
	 * Adds values to the current x and y.
	 * 
	 * @param x
	 *            Value x to be added.
	 * @param y
	 *            Value y to be added.
	 */
	public void add(double x, double y)
	{
		this.x += x;
		this.y += y;
	}

	/**
	 * Adds a value to the current x.
	 * 
	 * @param x
	 *            Value x to be added.
	 */
	public void add(double x)
	{
		this.x += x;
	}

	/**
	 * Adds a value to the current y.
	 * 
	 * @param y
	 *            Value y to be added.
	 */
	public void addY(double y)
	{
		this.y += y;
	}

	/**
	 * Divides x and y by a certain values.
	 * 
	 * @param scalar
	 *            Value to divide the vector coordinates.
	 */
	public void divide(double scalar)
	{
		this.x /= scalar;
		this.y /= scalar;
	}

	/**
	 * Divides x by a certain values.
	 * 
	 * @param scalar
	 *            Value to divide the vector coordinates.
	 */
	public void divideX(double scalar)
	{
		this.x /= scalar;
	}

	/**
	 * Divides y value by a certain values.
	 * 
	 * @param scalar
	 *            Value to divide the vector coordinates.
	 */
	public void divideY(double scalar)
	{
		this.y /= scalar;
	}

	/**
	 * Multiplies x and y by a certain values.
	 * 
	 * @param scalar
	 *            Value to multiply the vector coordinates.
	 */
	public void multiply(double multiplier)
	{
		this.x *= multiplier;
		this.y *= multiplier;
	}

	/**
	 * Multiplies x by a certain values.
	 * 
	 * @param scalar
	 *            Value to multiply the vector coordinates.
	 */
	public void multiplyX(double multiplier)
	{
		this.x *= multiplier;
	}

	/**
	 * Multiplies y by a certain values.
	 * 
	 * @param scalar
	 *            Value to multiply the vector coordinates.
	 */
	public void multiplyY(double multiplier)
	{
		this.y *= multiplier;
	}

	/**
	 * Changes the length of this vector to 1.0.
	 */
	public void normalize()
	{
		double length = this.getLength();
		if (length != 0.0D)
		{
			this.x /= length;
			this.y /= length;
		}
	}

	/**
	 * Returns the dot-product result of: (this) dot vec.
	 * 
	 * @param vec
	 *            Second vector in the dot product.
	 */
	public double dot(OrthogonalVector2D vec)
	{
		return this.x * vec.x + this.y * vec.y;
	}

	/**
	 * Returns the dot-product result of: (this) dot vec.
	 * 
	 * @param vec
	 *            Second vector in the dot product.
	 */
	public double dot(RadialVector2D vec)
	{
		return this.x * vec.length * Math.cos(vec.yaw) + this.y * vec.length * Math.sin(vec.yaw);
	}

	/**
	 * Returns the vector represented by: (this) + vec.
	 * 
	 * @param B
	 *            Vector to add to this one.
	 * @return A new Vector2D.
	 */
	public OrthogonalVector2D addVector(OrthogonalVector2D vec)
	{
		return new OrthogonalVector2D(this.x + vec.x, this.y + vec.y);
	}

	/**
	 * Returns a new instance containing the same information as this one.
	 * 
	 * @return A new Vector2D.
	 */
	@Override
	public OrthogonalVector2D clone()
	{
		return new OrthogonalVector2D(this.x, this.y);
	}

	/**
	 * Returns a string depicting this vector.
	 * 
	 * @return "Vector2D(x, y)".
	 */
	@Override
	public String toString()
	{
		return "Vector2D(" + this.x + ", " + this.y + ")";
	}

	/**
	 * Returns the distance between this and the specified vector.
	 * 
	 * @return Distance to another vector.
	 */
	public double getDistanceTo(OrthogonalVector2D vec)
	{
		double dx = vec.x - this.x;
		double dy = vec.y - this.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/**
	 * Returns the distance between this and the specified vector.
	 * 
	 * @return Distance to another vector.
	 */
	public double getDistanceTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.x;
		double dy = vec.length * Math.sin(vec.yaw) - this.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	/** Returns the squared distance between this and the specified vector. */
	public double getDistanceSqTo(OrthogonalVector2D vec)
	{
		double dx = vec.x - this.x;
		double dy = vec.y - this.y;
		return dx * dx + dy * dy;
	}

	/** Returns the squared distance between this and the specified vector. */
	public double getDistanceSqTo(RadialVector2D vec)
	{
		double dx = vec.length * Math.cos(vec.yaw) - this.x;
		double dy = vec.length * Math.sin(vec.yaw) - this.y;
		return dx * dx + dy * dy;
	}
}
