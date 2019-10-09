package com.deextinction.init;

import java.util.Set;

import com.deextinction.DeExtinction;
import com.deextinction.network.MessageAnimation;
import com.deextinction.network.MessageDecoderPage;
import com.deextinction.network.MessageEditorDisallowEdit;
import com.deextinction.network.MessageEditorSetDNA;
import com.deextinction.network.MessageEditorToggleAllowEdit;
import com.deextinction.network.MessageHandlerAnimation;
import com.deextinction.network.MessageHandlerDecoderPage;
import com.deextinction.network.MessageHandlerEditorDisallowEdit;
import com.deextinction.network.MessageHandlerEditorSetDNA;
import com.deextinction.network.MessageHandlerEditorToggleAllowEdit;
import com.deextinction.network.MessageHandlerMicroscopeSample;
import com.deextinction.network.MessageHandlerTileEntityRefresh;
import com.deextinction.network.MessageMicroscopeSample;
import com.deextinction.network.MessageTileEntityRefresh;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class DeMessages
{
	public static SimpleNetworkWrapper wrapper = NetworkRegistry.INSTANCE.newSimpleChannel(DeExtinction.MODID);
	private static int NEXT_ID = 0;

	public static void initMessages()
	{
		DeMessages.registerMessageOnServer(MessageDecoderPage.class, MessageHandlerDecoderPage.class);
		DeMessages.registerMessageOnServer(MessageEditorToggleAllowEdit.class, MessageHandlerEditorToggleAllowEdit.class);
		DeMessages.registerMessageOnServer(MessageEditorDisallowEdit.class, MessageHandlerEditorDisallowEdit.class);
		DeMessages.registerMessageOnServer(MessageEditorSetDNA.class, MessageHandlerEditorSetDNA.class);
		DeMessages.registerMessageOnServer(MessageMicroscopeSample.class, MessageHandlerMicroscopeSample.class);

		DeMessages.registerMessageOnClient(MessageTileEntityRefresh.class, MessageHandlerTileEntityRefresh.class);
		// RafaMv's updated version of thehippomaster21's AnimationAPI.
		DeMessages.registerMessageOnClient(MessageAnimation.class, MessageHandlerAnimation.class);
	}

	public static void registerMessageOnServer(Class iMessage, Class iMessageHandler)
	{
		DeMessages.wrapper.registerMessage(iMessageHandler, iMessage, DeMessages.NEXT_ID++, Side.SERVER);
	}

	public static void registerMessageOnClient(Class iMessage, Class iMessageHandler)
	{
		DeMessages.wrapper.registerMessage(iMessageHandler, iMessage, DeMessages.NEXT_ID++, Side.CLIENT);
	}

	public static void sendToAllTracking(IMessage message, Entity entity)
	{
		if (!entity.world.isRemote)
		{
			Set<? extends EntityPlayer> players = ((WorldServer) entity.world).getEntityTracker().getTrackingPlayers(entity);

			for (EntityPlayer player : players)
				DeMessages.wrapper.sendTo(message, (EntityPlayerMP) player);
		}
		else
			DeExtinction.logger.warn("Massege: " + message + " attempted to send a message to other players from the client.");
	}
}
