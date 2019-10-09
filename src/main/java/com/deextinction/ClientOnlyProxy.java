package com.deextinction;

import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeEntities;
import com.deextinction.init.DeRendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Timer;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class ClientOnlyProxy extends CommonProxy
{
	public static final Minecraft MC = Minecraft.getMinecraft();

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	private Timer mcTimer;

	public void preInit()
	{
		super.preInit();
		DeEntities.preInitEntityRenderers();

		DeRendering.preInitRegistryEvent();
	}

	public void init()
	{
		super.init();
	}

	public void postInit()
	{
		super.postInit();
		DeBlocks.postInitTileEntitySpecialRenderer();
	}

	@Override
	public boolean playerIsInCreativeMode(EntityPlayer player)
	{
		if (player instanceof EntityPlayerMP)
		{
			EntityPlayerMP entityPlayerMP = (EntityPlayerMP) player;
			return entityPlayerMP.interactionManager.isCreative();
		}
		else if (player instanceof EntityPlayerSP)
		{
			return Minecraft.getMinecraft().playerController.isInCreativeMode();
		}
		return false;
	}

	@Override
	public boolean isDedicatedServer()
	{
		return false;
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	@Override
	public void initTimer()
	{
		this.mcTimer = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), DeExtinction.fTimer);
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	@Override
	public float getPartialTick()
	{
		return this.mcTimer.renderPartialTicks;
	}

	/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
	@Override
	public World getWorldClient()
	{
		return FMLClientHandler.instance().getWorldClient();
	}

	public static void sendChatMessage(String text, TextFormatting color, ChatType chatType)
	{
		TextComponentString textComponent = new TextComponentString(text);
		textComponent.getStyle().setColor(color);
		ClientOnlyProxy.MC.ingameGUI.addChatMessage(chatType, textComponent);
	}
}
