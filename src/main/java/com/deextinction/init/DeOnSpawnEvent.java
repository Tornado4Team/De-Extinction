package com.deextinction.init;

import com.deextinction.DeExtinction;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = DeExtinction.MODID)
public class DeOnSpawnEvent
{
	public static void initOnSpawnEventEvent()
	{
		MinecraftForge.EVENT_BUS.register(new DeOnSpawnEvent());
	}

	@SubscribeEvent
	public static void onEntitySpawn(final EntityJoinWorldEvent event)
	{
		/*
		 * Entity entity = event.getEntity(); if (entity instanceof
		 * EntityVillager) { EntityVillager villager = (EntityVillager) entity;
		 * if (villager.getProfessionForge().equals(DeVillagerRegistry.
		 * RESEARCHER_PROFESSION)) { villager.tasks.addTask(1, new
		 * DeAIVillagerAdvanced(villager, 0.6D)); } }
		 */
	}
}
