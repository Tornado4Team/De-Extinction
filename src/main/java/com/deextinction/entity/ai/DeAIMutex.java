package com.deextinction.entity.ai;

public enum DeAIMutex
{
	MOTION("motion", 0b0001),
	LOOK("look", 0b0010),
	MOTION_LOOK("motion_look", 0b0011),
	SWIMMING("swimming", 0b0100),
	MOTION_SWIMMING("swimming", 0b0101),
	LOOK_SWIMMING("swimming", 0b0110),
	ALL_VANILLA("all_vanilla", 0b0111),
	COMPATIBLE_VANILLA("compatible_vanilla", 0b1000);

	private DeAIMutex(String mutex_name, int mutex)
	{
		this.mutex_name = mutex_name;
		this.mutex = mutex;
	}

	public String getMutexName()
	{
		return this.mutex_name;
	}

	public int getMutex()
	{
		return this.mutex;
	}

	public String getNucleobaseUnlocalizedName()
	{
		return "mutex." + this.mutex_name + ".name";
	}

	public boolean isEqual(DeAIMutex mutex)
	{
		return this.mutex == mutex.getMutex();
	}

	private final String mutex_name;
	private final int mutex;
}
