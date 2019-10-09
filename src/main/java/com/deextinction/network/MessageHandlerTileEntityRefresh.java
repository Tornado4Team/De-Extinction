package com.deextinction.network;

import com.deextinction.DeExtinction;
import com.deextinction.util.IRefresh;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageHandlerTileEntityRefresh implements IMessageHandler<MessageTileEntityRefresh, IMessage>
{
	public IMessage onMessage(final MessageTileEntityRefresh message, MessageContext ctx)
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
			TileEntity tileEntity = world.getTileEntity(message.getPos());
			if (tileEntity != null)
			{
				IRefresh tileRefresh = (IRefresh) tileEntity;
				if (message.fieldBuffer != null)
				{
					try
					{
						tileRefresh.setFieldsToRefresh(message.fieldBuffer);
					}
					catch (Exception e)
					{
						e.printStackTrace();
					}
					message.fieldBuffer.release();
				}
			}
		}
		else
			DeExtinction.logger.error("Null instance of client world when MessageTileEntityRefresh1 was received.");

		return null;
	}
}
