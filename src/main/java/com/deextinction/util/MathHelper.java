package com.deextinction.util;

import java.util.Random;

public class MathHelper
{
	public static final Random RAND = new Random();
	public static final float PI_F = (float) Math.PI;
	public static final float SQRT_2 = (float) Math.sqrt(2.0D);
	private static final float[] SIN_TABLE = new float[65536];
	static
	{
		for (int i = 0; i < 65536; ++i)
			MathHelper.SIN_TABLE[i] = (float) Math.sin((double) i * Math.PI * 2.0D / 65536.0D);
	}

	public static float sinFast(float rads)
	{
		return MathHelper.SIN_TABLE[(int) (rads * 10430.378F) & 65535];
	}

	public static float cosFast(float rads)
	{
		return MathHelper.SIN_TABLE[(int) (rads * 10430.378F + 16384.0F) & 65535];
	}

	/** Returns the sine of value */
	public static float sin(float rads)
	{
		return (float) Math.sin((double) rads);
	}

	/** Returns the sine of value */
	public static float sin(double rads)
	{
		return (float) Math.sin(rads);
	}

	/** Returns the cosine of value */
	public static float cos(float rads)
	{
		return (float) Math.cos((double) rads);
	}

	/** Returns the cosine of value */
	public static float cos(double rads)
	{
		return (float) Math.cos(rads);
	}

	/** Returns the tangent of value */
	public static float tan(float rads)
	{
		return (float) Math.tan((double) rads);
	}

	/** Returns the tangent of value */
	public static float tan(double rads)
	{
		return (float) Math.tan(rads);
	}

	/** Returns the tangent of value */
	public static float atan2(float y, float x)
	{
		return (float) Math.atan2((double) y, (double) x);
	}

	/** Returns the tangent of value */
	public static float atan2(double y, double x)
	{
		return (float) Math.atan2(y, x);
	}

	/** Returns the square root of a value */
	public static float sqrt(float value)
	{
		return (float) Math.sqrt((double) value);
	}

	/** Returns the square root of a value */
	public static float sqrt(double value)
	{
		return (float) Math.sqrt(value);
	}

	/** Returns the absolute of a value */
	public static int abs(int value)
	{
		return value >= 0 ? value : -value;
	}

	/** Returns the absolute of a value */
	public static float abs(float value)
	{
		return value >= 0.0F ? value : -value;
	}

	/** Returns the absolute of a value */
	public static double abs(double value)
	{
		return value >= 0 ? value : -value;
	}

	/** Returns the greatest integer less than or equal to the float argument */
	public static int floor(double value)
	{
		int i = (int) value;
		return value < (double) i ? i - 1 : i;
	}

	/** Returns the greatest integer less than or equal to the float argument */
	public static int floor(float value)
	{
		int i = (int) value;
		return value < (float) i ? i - 1 : i;
	}

	/** Returns the next integer based on the double argument */
	public static int ceiling(float value)
	{
		int i = (int) value;
		return value > (float) i ? i + 1 : i;
	}

	/** Returns the next integer based on the double argument */
	public static int ceiling(double value)
	{
		int i = (int) value;
		return value > (double) i ? i + 1 : i;
	}

	/** Returns the number of radians of a certain angle in degrees */
	public static float toRadians(double degrees)
	{
		return (float) Math.toRadians(degrees);
	}

	/** Returns the number of degrees of a certain angle in radians */
	public static float toDegrees(double radians)
	{
		return (float) Math.toDegrees(radians);
	}

	/** Wraps an angle in degrees between 180.0F and -180.0F */
	public static float wrapDegrees(float value)
	{
		value %= 360.0F;
		return value >= 180.0F ? value -= 360.0F : (value < -180.0F ? value += 360.0F : value);
	}

	/** Wraps an angle in degrees between 180.0D and -180.0D */
	public static double wrapDegrees(double value)
	{
		value %= 360.0D;
		return value >= 180.0D ? value -= 360.0D : (value < -180.0D ? value += 360.0D : value);
	}

	/** Wraps an angle in radians between PI and -PI */
	public static float wrapRadians(float value)
	{
		value %= MathHelper.PI_F * 2.0F;
		return value >= MathHelper.PI_F ? value -= MathHelper.PI_F * 2.0F : (value < -MathHelper.PI_F ? value += MathHelper.PI_F * 2.0F : value);
	}

	/** Wraps an angle in radians between PI and -PI */
	public static double wrapRadians(double radians)
	{
		radians %= Math.PI * 2.0D;
		return radians >= Math.PI ? radians -= Math.PI * 2.0D : (radians < -Math.PI ? radians += Math.PI * 2.0D : radians);
	}

	/** Returns the hypothenuse of a right-angled triangle */
	public static float hypothenuse(float side0, float side1)
	{
		return MathHelper.sqrt(side0 * side0 + side1 * side1);
	}

	/** Returns the hypothenuse of a right-angled triangle */
	public static double hypothenuse(double side0, double side1)
	{
		return Math.sqrt(side0 * side0 + side1 * side1);
	}

	/** Returns the hypothenuse squared of a right-angled triangle */
	public static int hypothenuseSq(int side0, int side1)
	{
		return side0 * side0 + side1 * side1;
	}

	/** Returns the hypothenuse squared of a right-angled triangle */
	public static float hypothenuseSq(float side0, float side1)
	{
		return side0 * side0 + side1 * side1;
	}

	/** Returns the hypothenuse squared of a right-angled triangle */
	public static double hypothenuseSq(double side0, double side1)
	{
		return side0 * side0 + side1 * side1;
	}

	/** Clamps a value between a minimum and maximum values */
	public static int clamp(int value, int min, int max)
	{
		return (value < min ? min : (value > max ? max : value));
	}

	/** Clamps a value between a minimum and maximum values */
	public static float clamp(float value, float min, float max)
	{
		return (value < min ? min : (value > max ? max : value));
	}

	/** Clamps a value between a minimum and maximum values */
	public static double clamp(double value, double min, double max)
	{
		return (value < min ? min : (value > max ? max : value));
	}

	/** Returns the linear interpolation considering x0 = 0 and x1 = 1 */
	public static float lerp(float value, float y0, float y1)
	{
		return y0 + (y1 - y0) * value;
	}

	/** Returns the linear interpolation considering x0 = 0 and x1 = 1 */
	public static double lerp(double value, double y0, double y1)
	{
		return y0 + (y1 - y0) * value;
	}

	/** Returns the linear interpolation */
	public static float lerp(float value, float x0, float x1, float y0, float y1)
	{
		return y0 + (y1 - y0) * ((value - x0) / (x1 - x0));
	}

	/** Returns the linear interpolation */
	public static double lerp(double value, double x0, double x1, double y0, double y1)
	{
		return y0 + (y1 - y0) * ((value - x0) / (x1 - x0));
	}

	public static double maxOfObsoluteValues(double value0, double value1)
	{
		if (value0 < 0.0D)
			value0 = -value0;

		if (value1 < 0.0D)
			value1 = -value1;

		return value0 > value1 ? value0 : value1;
	}

	public static int getRandomIntegerInRange(Random random, int minimum, int maximum)
	{
		return random.nextInt(maximum - minimum + 1) + minimum;
	}

	public static float getRandomFloat(Random random, float minimum, float maximum)
	{
		return random.nextFloat() * (maximum - minimum) + minimum;
	}

	public static float getRandomFloat(Random random, double minimum, double maximum)
	{
		return (float) (random.nextFloat() * (maximum - minimum) + minimum);
	}

	public static double getRandomDouble(Random random, float minimum, float maximum)
	{
		return random.nextDouble() * (double) (maximum - minimum) + (double) minimum;
	}

	public static double getRandomDouble(Random random, double minimum, double maximum)
	{
		return random.nextDouble() * (maximum - minimum) + minimum;
	}

	/** Returns a random yaw between 0 and 2PI */
	public static double getRandomYawRadians_2PI()
	{
		return 2.0D * Math.PI * MathHelper.RAND.nextDouble();
	}

	/** Returns a random yaw between 0 and 360 */
	public static double getRandomYawDegrees_360()
	{
		return 360.0D * MathHelper.RAND.nextDouble();
	}

	/** Returns a random yaw between -PI and PI */
	public static double getRandomYawRadians_PI()
	{
		return Math.PI * (2.0D * MathHelper.RAND.nextDouble() - 1.0D);
	}

	/** Returns a random yaw between -180 and 180 */
	public static double getRandomYawDegrees_180()
	{
		return 360.0D * MathHelper.RAND.nextDouble() - 180.0D;
	}
}
