package com.deextinction.capabilities;

import net.minecraft.entity.EntityLivingBase;

public interface IPregnant
{
	public void setMother(EntityLivingBase mother);

	public void resetMother();

	public EntityLivingBase getMother();

	public boolean hasMother();

	public void setProgress(int progress);

	public void resetProgress();

	public void increaseProgress();

	public int getProgress();

	public boolean isBabyReady();

	public void setName(String animalName);

	public void resetName();

	public String getName();

	public boolean hasBaby();

	public void setDNA(String dna);

	public void resetDNA();

	public String getDNA();

	public void born();
}
