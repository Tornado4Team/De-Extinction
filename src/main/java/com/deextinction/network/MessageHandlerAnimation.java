package com.deextinction.network;

import com.deextinction.DeExtinction;
import com.deextinction.entity.IAnimatedEntity;
import com.deextinction.entity.ai.animation.DeAnimationList;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
public class MessageHandlerAnimation implements IMessageHandler<MessageAnimation, IMessage>
{
	public IMessage onMessage(final MessageAnimation message, MessageContext ctx)
	{
		if (ctx.side != Side.CLIENT)
		{
			System.err.println(this.getClass().getSimpleName() + " received on wrong side:" + ctx.side);
			return null;
		}
		if (!message.isMessageValid())
		{
			System.err.println(this.getClass().getSimpleName() + " was invalid" + message.toString());
			return null;
		}

		World world = DeExtinction.proxy.getWorldClient();
		if (world != null)
		{
			IAnimatedEntity entity = (IAnimatedEntity) world.getEntityByID(message.getEntityID());
			if (entity != null)
			{
				if (message.getAnimationID() == -1)
					entity.setAnimID(DeAnimationList.NO_ANIMATION);
				else
					entity.setAnimID(message.getAnimationID());
				entity.setAnimTick(0);
			}
		}
		else
			DeExtinction.logger.error("Null instance of client world when MessageAnimation was received.");

		return null;
	}
}
