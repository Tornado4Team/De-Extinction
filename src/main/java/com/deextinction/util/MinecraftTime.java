package com.deextinction.util;

public class MinecraftTime
{
	public static final int TICKS_PER_SECOND = 20;
	public static final int TICKS_PER_MINUTE = 1200;
	public static final int TICKS_PER_HOUR = 72000;

	public static final int MC_YEAR_LENGHT = 8640000;
	public static final int MC_MONTH_LENGHT = 720000;
	public static final int MC_DAY_LENGHT = 24000;
	public static final int MC_HOUR_LENGHT = 1000;
	public static final int MC_MINUTE_LENGHT = (1000 / 60);
	public static final int MC_SECOND_LENGHT = (int) (1000 / 3600);

	public static int getInGameSeconds(int ticks)
	{
		return (int) (ticks / MinecraftTime.MC_SECOND_LENGHT);
	}

	public static int getInGameMinutes(int ticks)
	{
		return (int) (ticks / MinecraftTime.MC_MINUTE_LENGHT);
	}

	public static int getInGameHours(int ticks)
	{
		return (int) (ticks / MinecraftTime.MC_HOUR_LENGHT);
	}

	public static int getInGameDays(int ticks)
	{
		return (int) (ticks / MinecraftTime.MC_DAY_LENGHT);
	}

	public static int getInGameMonths(int ticks)
	{
		return (int) (ticks / MinecraftTime.MC_MONTH_LENGHT);
	}

	public static int getInGameYears(int ticks)
	{
		return (int) (ticks / MinecraftTime.MC_YEAR_LENGHT);
	}
}
