package com.deextinction.network;

import com.deextinction.DeExtinction;
import com.deextinction.tileentities.TileMicroscope;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageHandlerMicroscopeSample implements IMessageHandler<MessageMicroscopeSample, IMessage>
{
	public IMessage onMessage(final MessageMicroscopeSample message, MessageContext ctx)
	{
		if (ctx.side != Side.SERVER)
		{
			System.err.println(this.getClass().getSimpleName() + " received on wrong side:" + ctx.side);
			return null;
		}
		if (!message.isMessageValid())
		{
			System.err.println(this.getClass().getSimpleName() + " was invalid" + message.toString());
			return null;
		}

		final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
		if (sendingPlayer == null)
		{
			System.err.println("EntityPlayerMP was null when " + this.getClass().getSimpleName() + " was received");
			return null;
		}

		final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
		playerWorldServer.addScheduledTask(new Runnable()
		{
			public void run()
			{
				processMessage(message, sendingPlayer);
			}
		});

		return null;
	}

	private void processMessage(MessageMicroscopeSample message, EntityPlayerMP sendingPlayer)
	{
		TileEntity tileEntity = sendingPlayer.world.getTileEntity(new BlockPos(message.getX(), message.getY(), message.getZ()));
		if (tileEntity != null)
		{
			if (tileEntity instanceof TileMicroscope)
			{
				TileMicroscope microscope = (TileMicroscope) tileEntity;
				if (message.shouldAnalyze())
					microscope.analyze();
				else
					microscope.removeSample();
			}
			else
				DeExtinction.logger.error("Wrong instance of tile entity when MessageMicroscopeSample was received.");
		}
		else
			DeExtinction.logger.error("Null instance of tile entity when MessageMicroscopeSample was received.");
	}
}
