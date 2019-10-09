package com.deextinction.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageEditorToggleAllowEdit implements IMessage
{
	private boolean messageIsValid;
	private int xCoord;
	private int yCoord;
	private int zCoord;

	public MessageEditorToggleAllowEdit(int xCoord, int yCoord, int zCoord)
	{
		this.messageIsValid = true;
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

	public MessageEditorToggleAllowEdit()
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
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}
