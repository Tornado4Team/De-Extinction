package com.deextinction.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
public class MessageAnimation implements IMessage
{
	private boolean messageIsValid;
	private byte animID;
	private int entityID;

	public MessageAnimation(byte anim, int entity)
	{
		this.messageIsValid = true;
		this.animID = anim;
		this.entityID = entity;
	}

	public byte getAnimationID()
	{
		return this.animID;
	}

	public int getEntityID()
	{
		return this.entityID;
	}

	public boolean isMessageValid()
	{
		return this.messageIsValid;
	}

	public MessageAnimation()
	{
		this.messageIsValid = false;
	}

	@Override
	public void fromBytes(ByteBuf buffer)
	{
		try
		{
			this.animID = buffer.readByte();
			this.entityID = buffer.readInt();
		}
		catch (IndexOutOfBoundsException ioe)
		{
			System.err.println("Exception while reading " + this.getClass().getSimpleName() + ": " + ioe);
			return;
		}
		this.messageIsValid = true;
	}

	@Override
	public void toBytes(ByteBuf buffer)
	{
		if (!this.messageIsValid)
			return;
		buffer.writeByte(this.animID);
		buffer.writeInt(this.entityID);
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}
