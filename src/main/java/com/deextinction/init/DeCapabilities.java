package com.deextinction.init;

import com.deextinction.DeExtinction;
import com.deextinction.capabilities.IPregnant;
import com.deextinction.capabilities.Pregnant;
import com.deextinction.capabilities.PregnantCapabilityProvider;
import com.deextinction.capabilities.PregnantStorage;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class DeCapabilities
{
	public static final ResourceLocation PREGNANT_CAPABILITY_KEY = new ResourceLocation(DeExtinction.MODID, "DePregnantKey");

	public static void initCapabilites()
	{
		CapabilityManager.INSTANCE.register(IPregnant.class, new PregnantStorage(), Pregnant::new);
		MinecraftForge.EVENT_BUS.register(new DeCapabilities());
	}

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event)
	{
		if (event.getObject() != null && Pregnant.isValidMother(event.getObject()))
			event.addCapability(DeCapabilities.PREGNANT_CAPABILITY_KEY, new PregnantCapabilityProvider());
	}
}
