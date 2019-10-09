package com.deextinction.capabilities;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.DNA;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityLlama;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;

public class Pregnant implements IPregnant
{
	public static final String NOT_PREGNANT = "not_pregnant";
	public static final int PREGNANT_PROGRESS_MAX = MinecraftTime.MC_DAY_LENGHT;

	private EntityLivingBase mother = null;
	private String animalName = Pregnant.NOT_PREGNANT;
	private String dna = DNA.DEFAULT_DNA_STRING;
	private int progress = 0;

	@Override
	public void setMother(EntityLivingBase mother)
	{
		this.mother = mother;
	}

	@Override
	public void resetMother()
	{
		this.mother = null;
	}

	@Override
	public EntityLivingBase getMother()
	{
		return this.mother;
	}

	@Override
	public boolean hasMother()
	{
		return this.mother != null;
	}

	@Override
	public void setProgress(int progress)
	{
		this.progress = progress;
	}

	@Override
	public void resetProgress()
	{
		this.progress = 0;
	}

	@Override
	public void increaseProgress()
	{
		this.progress++;
	}

	@Override
	public int getProgress()
	{
		return this.progress;
	}

	@Override
	public boolean isBabyReady()
	{
		return this.progress >= Pregnant.PREGNANT_PROGRESS_MAX;
	}

	@Override
	public void setName(String animalName)
	{
		this.animalName = animalName;
	}

	@Override
	public void resetName()
	{
		this.animalName = Pregnant.NOT_PREGNANT;
	}

	@Override
	public String getName()
	{
		return this.animalName;
	}

	@Override
	public boolean hasBaby()
	{
		return this.animalName != null && this.animalName != Pregnant.NOT_PREGNANT;
	}

	@Override
	public void setDNA(String dna)
	{
		this.dna = dna;
	}

	@Override
	public void resetDNA()
	{
		this.dna = null;
	}

	@Override
	public String getDNA()
	{
		return this.dna;
	}

	@Override
	public void born()
	{
		if (this.mother != null && !this.mother.world.isRemote)
		{
			if (DeDatabase.LIST_DE_EXTINCTED.containsKey(this.animalName))
			{
				DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(this.animalName);
				if (deExtincted instanceof DeExtinctedAnimal)
				{
					EntityCreature entityCreature = ((DeExtinctedAnimal) deExtincted).getEntity(this.mother.world);
					if (entityCreature instanceof EntityDeExtinctedAnimal)
					{
						EntityDeExtinctedAnimal entityAnimal = (EntityDeExtinctedAnimal) entityCreature;
						entityAnimal.setPosition(this.mother.posX + 0.25D - 0.50D * this.mother.world.rand.nextDouble(), this.mother.posY + 0.25D, this.mother.posZ + 0.25D - 0.50D * this.mother.world.rand.nextDouble());

						if (this.getDNA() != null && !this.getDNA().isEmpty())
							entityAnimal.initAnimalBabe(this.getDNA());
						else
							entityAnimal.initAnimalBabe(DNA.DEFAULT_DNA_STRING);

						this.mother.world.spawnEntity(entityAnimal);
					}
					else
					{
						entityCreature.setPosition(this.mother.posX + 0.25D - 0.50D * this.mother.world.rand.nextDouble(), this.mother.posY + 0.25D, this.mother.posZ + 0.25D - 0.50D * this.mother.world.rand.nextDouble());
						this.mother.world.spawnEntity(entityCreature);
					}

					this.resetMother();
					this.resetProgress();
					this.resetDNA();
					this.resetName();
				}
			}
			else
				DeExtinction.logger.error("Pregnant is trying to spawn an animal that is not in the database! THIS IS A BUG!");
		}
	}

	public static final boolean isValidMother(Entity entity)
	{
		return entity instanceof EntityHorse || entity instanceof EntityCow || entity instanceof EntitySheep || entity instanceof EntityLlama || entity instanceof EntityPig || entity instanceof EntityWolf || entity instanceof EntityOcelot;
	}
}
