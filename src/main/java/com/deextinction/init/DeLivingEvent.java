package com.deextinction.init;

import com.deextinction.capabilities.IPregnant;
import com.deextinction.capabilities.Pregnant;
import com.deextinction.capabilities.PregnantCapabilityProvider;

import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeLivingEvent
{
	public static void initLivingEvent()
	{
		MinecraftForge.EVENT_BUS.register(new DeLivingEvent());
	}

	@SubscribeEvent
	public void onEntityLiving(LivingUpdateEvent event)
	{
		EntityLivingBase entityLivingBase = event.getEntityLiving();
		if (entityLivingBase != null && !entityLivingBase.world.isRemote)
		{
			if (Pregnant.isValidMother(entityLivingBase))
			{
				IPregnant pregnant = entityLivingBase.getCapability(PregnantCapabilityProvider.PREGNANT_CAPABILITY, null);

				if (pregnant != null && pregnant.hasBaby())
				{
					if (!pregnant.isBabyReady())
						pregnant.increaseProgress();
					else
					{
						if (!pregnant.hasMother())
							pregnant.setMother(entityLivingBase);
						pregnant.born();
					}
					pregnant.increaseProgress();
				}
			}
		}
	}
}
