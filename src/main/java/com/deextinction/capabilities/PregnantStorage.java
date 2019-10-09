package com.deextinction.capabilities;

import javax.annotation.Nullable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class PregnantStorage implements Capability.IStorage<IPregnant>
{

	@Nullable
	@Override
	public NBTBase writeNBT(Capability<IPregnant> capability, IPregnant instance, EnumFacing side)
	{
		NBTTagCompound compound = new NBTTagCompound();

		if (instance.getProgress() > 0)
			compound.setInteger("Progress", instance.getProgress());

		if (instance.getDNA() != null)
			compound.setString("DNA", instance.getDNA());

		if (instance.hasBaby())
			compound.setString("AnimalName", instance.getName());

		return compound;
	}

	@Override
	public void readNBT(Capability<IPregnant> capability, IPregnant instance, EnumFacing side, NBTBase nbt)
	{
		NBTTagCompound compound = (NBTTagCompound) nbt;

		if (compound.hasKey("Progress"))
			instance.setProgress(compound.getInteger("Progress"));

		if (compound.hasKey("DNA"))
			instance.setDNA(compound.getString("DNA"));

		if (compound.hasKey("AnimalName"))
			instance.setName(compound.getString("AnimalName"));
	}
}
