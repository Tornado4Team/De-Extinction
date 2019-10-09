package com.deextinction.database;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.util.MinecraftTime;

public class AnimalAttributes
{
	private List<Integer> growth;
	private AnimalAttribute scaleAdult;
	private AnimalAttribute scaleBaby;
	private AnimalAttribute max_health;
	private AnimalAttribute knockback_resistance;
	private AnimalAttribute movement_speed;
	private AnimalAttribute armor;
	private AnimalAttribute armor_toughness;
	private AnimalAttribute swim_speed;
	private AnimalAttribute follow_range;
	private AnimalAttribute attack;
	private AnimalAttribute flying_speed;

	public AnimalAttributes()
	{
		this.growth = new ArrayList<Integer>();
		this.growth.add(-MinecraftTime.MC_DAY_LENGHT);
		this.growth.add(0);
		this.scaleAdult = new AnimalAttribute(0.5D, 1.0D);
		this.scaleBaby = new AnimalAttribute(0.5D, 2.0D);
		this.max_health = new AnimalAttribute(1.0D, 1.0D);
		this.knockback_resistance = new AnimalAttribute(0.0D, 0.0D);
		this.movement_speed = new AnimalAttribute(0.0D, 0.0D);
		this.armor = new AnimalAttribute(0.0D, 0.0D);
		this.armor_toughness = new AnimalAttribute(0.0D, 0.0D);
		this.swim_speed = new AnimalAttribute(0.0D, 0.0D);
		this.follow_range = new AnimalAttribute(0.0D, 0.0D);
		this.attack = new AnimalAttribute(0.0D, 0.0D);
		this.flying_speed = new AnimalAttribute(0.0D, 0.0D);
	}

	public List<Integer> getGrowth()
	{
		return this.growth;
	}

	public void setGrowth(int... ages)
	{
		this.growth.clear();
		for (int i : ages)
			this.growth.add(i);
	}

	public void setGrowthByDays(int numberOfDays)
	{
		this.growth.clear();
		for (int day = numberOfDays; day >= 0; day--)
			this.growth.add(-day * MinecraftTime.MC_DAY_LENGHT);
	}

	public AnimalAttribute getScaleAdult()
	{
		return this.scaleAdult;
	}

	public AnimalAttribute getScaleBaby()
	{
		return this.scaleBaby;
	}

	public void setScaleAdult(double min, double max)
	{
		this.scaleAdult = new AnimalAttribute(min, max);
	}

	public void setScaleBaby(double min, double max)
	{
		this.scaleBaby = new AnimalAttribute(min, max);
	}

	public AnimalAttribute getHealth()
	{
		return this.max_health;
	}

	public void setHealth(double child, double adult)
	{
		this.max_health = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getKnockbackResistance()
	{
		return this.knockback_resistance;
	}

	public void setKnockbackResistance(double child, double adult)
	{
		this.knockback_resistance = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getMovementSpeed()
	{
		return this.movement_speed;
	}

	public void setMovementSpeed(double child, double adult)
	{
		this.movement_speed = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getArmor()
	{
		return this.armor;
	}

	public void setArmor(double child, double adult)
	{
		this.armor = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getArmorToughness()
	{
		return this.armor_toughness;
	}

	public void setArmorToughness(double child, double adult)
	{
		this.armor_toughness = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getSwimSpeed()
	{
		return this.swim_speed;
	}

	public void setSwimSpeed(double child, double adult)
	{
		this.swim_speed = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getFollowRange()
	{
		return this.follow_range;
	}

	public void setFollowRange(double child, double adult)
	{
		this.follow_range = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getAttack()
	{
		return this.attack;
	}

	public void setAttack(double child, double adult)
	{
		this.attack = new AnimalAttribute(child, adult);
	}

	public AnimalAttribute getFlyingSpeed()
	{
		return this.flying_speed;
	}

	public void setFlyingSpeed(double child, double adult)
	{
		this.flying_speed = new AnimalAttribute(child, adult);
	}
}
