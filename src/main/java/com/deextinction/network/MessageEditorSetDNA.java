package com.deextinction.network;

import com.deextinction.util.DNA;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageEditorSetDNA implements IMessage
{
	private boolean messageIsValid;
	private int xCoord;
	private int yCoord;
	private int zCoord;
	private String dna;

	public MessageEditorSetDNA(DNA dna, int xCoord, int yCoord, int zCoord)
	{
		this.dna = dna.getDNA();
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.zCoord = zCoord;
		this.messageIsValid = true;
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

	public String getDNA()
	{
		return this.dna;
	}

	public boolean isMessageValid()
	{
		return this.messageIsValid;
	}

	public MessageEditorSetDNA()
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
			this.dna = ByteBufUtils.readUTF8String(buf);
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
		ByteBufUtils.writeUTF8String(buf, this.dna);
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}
