package com.deextinction;

import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeCapabilities;
import com.deextinction.init.DeCreativeTabs;
import com.deextinction.init.DeDatabase;
import com.deextinction.init.DeEntities;
import com.deextinction.init.DeItems;
import com.deextinction.init.DeLivingEvent;
import com.deextinction.init.DeMessages;
import com.deextinction.init.DeRecipes;
import com.deextinction.init.DeRecipesSmelting;
import com.deextinction.init.DeRegistry;
import com.deextinction.init.DeVillagerRegistry;
import com.deextinction.world.gen.ores.DeWorldGenOres;
import com.deextinction.world.gen.structures.DeWorldGenStructures;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class CommonProxy
{

	public void preInit()
	{
		DeDatabase.preInitDatabase();
		DeCreativeTabs.preInitCreativeTabs();
		DeBlocks.preInitBlocks();
		DeItems.preInitItems();
		DeEntities.preInitEntities();

		DeRegistry.preInitRegistryEvent();
	}

	public void init()
	{
		DeDatabase.initDatabase();
		DeVillagerRegistry.initVillagerHouses();
		DeVillagerRegistry.initVillagerCareers();

		DeRecipes.initRecipes();
		DeMessages.initMessages();
		DeWorldGenOres.initWorldGen();
		DeWorldGenStructures.initWorldGen();

		DeCapabilities.initCapabilites();
		DeVillagerRegistry.initVillagerProfessions();
		// DeOnSpawnEvent.initOnSpawnEventEvent();
		DeLivingEvent.initLivingEvent();
	}

	public void postInit()
	{
		this.initTimer();
		DeBlocks.postInitOreDictionaryBlocks();
		DeItems.postInitOreDictionaryItems();
		DeRecipesSmelting.postInitRecipesSmelting();
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public void initTimer()
	{

	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public float getPartialTick()
	{
		return 1.0F;
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public World getWorldClient()
	{
		return null;
	}

	abstract public boolean playerIsInCreativeMode(EntityPlayer player);

	abstract public boolean isDedicatedServer();
}
