package com.deextinction.init;

import com.deextinction.DeExtinction;
import com.deextinction.villager.DeVillagerCareerEngineering;
import com.deextinction.villager.DeVillagerCareerResearcher;
import com.deextinction.villager.DeVillagerProfession;
import com.deextinction.world.gen.structures.villagers.VillageResearchLabComponent;

import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

@Mod.EventBusSubscriber(modid = DeExtinction.MODID)
public class DeVillagerRegistry
{
	public static final DeVillagerProfession RESEARCHER_PROFESSION = new DeVillagerProfession("researcher");
	public static DeVillagerCareerResearcher researcherCareer;
	public static DeVillagerCareerEngineering researchEngineerCareer;

	public static void initVillagerProfessions()
	{
		MinecraftForge.EVENT_BUS.register(new DeVillagerRegistry());
	}

	@SubscribeEvent
	public static void onRegister(RegistryEvent.Register<VillagerRegistry.VillagerProfession> event)
	{
		event.getRegistry().register(DeVillagerRegistry.RESEARCHER_PROFESSION);
	}

	public static void initVillagerCareers()
	{
		DeVillagerRegistry.researcherCareer = new DeVillagerCareerResearcher();
		DeVillagerRegistry.researchEngineerCareer = new DeVillagerCareerEngineering();
	}

	public static void initVillagerHouses()
	{
		MapGenStructureIO.registerStructureComponent(VillageResearchLabComponent.class, DeExtinction.prependModID("researcher_villager_house"));
		VillagerRegistry.instance().registerVillageCreationHandler(VillageResearchLabComponent.VillageResearchLabHandler.VILLAGE_RESEARCH_LAB_HANDLER);
	}
}
