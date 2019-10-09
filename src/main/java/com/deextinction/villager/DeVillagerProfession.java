package com.deextinction.villager;

import com.deextinction.DeExtinction;

import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class DeVillagerProfession extends VillagerRegistry.VillagerProfession
{
	private String unlocalizedName;

	public DeVillagerProfession(String name)
	{
		super(DeExtinction.prependModID(name), DeExtinction.prependModID("textures/entities/villagers/" + name + ".png"), DeExtinction.prependModID("textures/entities/villagers/" + name + "_zombie.png"));
		this.unlocalizedName = name;
	}

	public String getName()
	{
		return this.unlocalizedName;
	}
}
