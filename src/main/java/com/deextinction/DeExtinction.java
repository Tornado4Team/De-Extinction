package com.deextinction;

import org.apache.logging.log4j.Logger;

import com.deextinction.entity.IAnimatedEntity;
import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageAnimation;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Mod(modid = DeExtinction.MODID, name = DeExtinction.MODNAME, version = DeExtinction.MODVERSION)
public class DeExtinction
{
	public static final String MODID = "deextinction";
	public static final String MODNAME = "De-Extinction Mod";
	public static final String MODVERSION = "2.0.2";
	public static final String MODDESCRIPTION = "Bringing Extinct life forms to modern day Minecraft (We are alive!).";
	public static final String MODAUTHOR = "De-Extinction Team";
	public static final String MODCREDITS = "De-Extinction Team";
	public static final String MODURL = "https://www.minecraftforum.net/forums/mapping-and-modding-java-edition/minecraft-mods/wip-mods/2601757-de-extinction-mod-dinosaurs-prehistoric-creatures";
	public static final String MODLOGO = "de_logo.png";

	@Mod.Instance(DeExtinction.MODID)
	public static DeExtinction instance;

	@SidedProxy(clientSide = "com.deextinction.ClientOnlyProxy", serverSide = "com.deextinction.DedicatedServerProxy")
	public static CommonProxy proxy;
	public static Logger logger;

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public static final String[] fTimer = new String[] { "field_71428_T", "S", "timer" };

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		this.logger = event.getModLog();
		DeExtinction.proxy.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		DeExtinction.proxy.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		DeExtinction.proxy.postInit();
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public static boolean isClient()
	{
		return FMLCommonHandler.instance().getSide().isClient();
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public static boolean isEffectiveClient()
	{
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	public static void sendAnimPacket(IAnimatedEntity entity, int animID)
	{
		if (DeExtinction.isEffectiveClient())
			return;
		entity.setAnimID(animID);
		DeMessages.wrapper.sendToAll(new MessageAnimation((byte) animID, ((Entity) entity).getEntityId()));
	}

	/**
	 * Prepend the name with the mod ID, suitable for ResourceLocations such as
	 * textures.
	 * 
	 * @param name
	 * @return e.g. "deextinction:name"
	 */
	public static String prependModID(String name)
	{
		return DeExtinction.MODID + ":" + name;
	}

	/**
	 * Returns class of an entity from its name
	 * 
	 * @param EntityLivingBase
	 *            target
	 */
	public static Class<? extends Entity> getEntityClassFromName(String name)
	{
		return EntityList.getClassFromName(name);
	}

	/**
	 * Returns name of an entity from its object
	 * 
	 * @param EntityLivingBase
	 *            target
	 */
	public static String getNameFromEntity(EntityLivingBase entity)
	{
		return EntityRegistry.getEntry(entity.getClass()).getName();
	}

	/**
	 * Returns name of an entity from its class
	 * 
	 * @param Class
	 *            clazz
	 */
	public static String getNameFromEntityClass(Class clazz)
	{
		return EntityRegistry.getEntry(clazz).getName();
	}

	/**
	 * Returns translated name of an entity from its object
	 * 
	 * @param EntityLivingBase
	 *            target
	 */
	public static String getTranslatedNameFromEntity(EntityLivingBase entity)
	{
		return I18n.translateToLocal("entity." + EntityRegistry.getEntry(entity.getClass()).getName() + ".name");
	}

	/**
	 * Returns translated name of an entity from its class
	 * 
	 * @param Class
	 *            clazz
	 */
	public static String getTranslatedNameFromEntityClass(Class clazz)
	{
		return I18n.translateToLocal("entity." + EntityRegistry.getEntry(clazz).getName() + ".name");
	}

	/**
	 * Returns translated name of an entity from its class
	 * 
	 * @param Class
	 *            clazz
	 */
	public static String getTranslatedNameFromEntityClass(String name)
	{
		return I18n.translateToLocal("entity." + name + ".name");
	}
}
