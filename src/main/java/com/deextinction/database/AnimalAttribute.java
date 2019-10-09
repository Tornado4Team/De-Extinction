package com.deextinction.database;

public class AnimalAttribute
{
	private double child_attribute;
	private double adult_attribute;

	public AnimalAttribute(double child_attribute, double adult_attribute)
	{
		this.child_attribute = child_attribute;
		this.adult_attribute = adult_attribute;
	}

	public double getChildAttribute()
	{
		return this.child_attribute;
	}

	public double getAdultAttribute()
	{
		return this.adult_attribute;
	}

	public double interpolate(int animal_age, int max_animal_age)
	{
		if (animal_age > max_animal_age)
			animal_age = max_animal_age;

		return this.child_attribute + (this.adult_attribute - this.child_attribute) * animal_age / max_animal_age;
	}
}
