package com.deextinction.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageMicroscopeSample implements IMessage
{
	private boolean messageIsValid;
	private boolean analyze;
	private int xCoord;
	private int yCoord;
	private int zCoord;

	public MessageMicroscopeSample(boolean analyze, int xCoord, int yCoord, int zCoord)
	{
		this.messageIsValid = true;
		this.analyze = analyze;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
	}

	public int getX()
	{
		return this.xCoord;
	}

	public int getY()
	{
		return this.yCoord;
	}

	public int getZ()
	{
		return this.zCoord;
	}

	public boolean isMessageValid()
	{
		return this.messageIsValid;
	}

	public boolean shouldAnalyze()
	{
		return this.analyze;
	}

	public MessageMicroscopeSample()
	{
		this.messageIsValid = false;
	}

	@Override
	public void fromBytes(ByteBuf buf)
	{
		try
		{
			this.xCoord = buf.readInt();
			this.yCoord = buf.readInt();
			this.zCoord = buf.readInt();
			this.analyze = buf.readBoolean();
		}
		catch (IndexOutOfBoundsException ioe)
		{
			System.err.println("Exception while reading " + this.getClass().getSimpleName() + ": " + ioe);
			return;
		}
		this.messageIsValid = true;
	}

	@Override
	public void toBytes(ByteBuf buf)
	{
		if (!this.messageIsValid)
			return;
		buf.writeInt(this.xCoord);
		buf.writeInt(this.yCoord);
		buf.writeInt(this.zCoord);
		buf.writeBoolean(this.analyze);
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}
