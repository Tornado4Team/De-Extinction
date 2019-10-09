package com.deextinction.capabilities;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class PregnantCapabilityProvider implements ICapabilitySerializable<NBTBase>
{
	@CapabilityInject(IPregnant.class)
	public static final Capability<IPregnant> PREGNANT_CAPABILITY = null;

	private IPregnant instance = PREGNANT_CAPABILITY.getDefaultInstance();

	@Override
	public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing)
	{
		return capability == PREGNANT_CAPABILITY;
	}

	@Nullable
	@Override
	public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing)
	{
		return capability == PREGNANT_CAPABILITY ? PREGNANT_CAPABILITY.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT()
	{
		return PREGNANT_CAPABILITY.getStorage().writeNBT(PREGNANT_CAPABILITY, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt)
	{
		PREGNANT_CAPABILITY.getStorage().readNBT(PREGNANT_CAPABILITY, this.instance, null, nbt);
	}
}
