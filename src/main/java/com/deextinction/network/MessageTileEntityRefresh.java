package com.deextinction.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

/** RafaMv's updated version of thehippomaster21's AnimationAPI. */
public class MessageTileEntityRefresh implements IMessage
{
	private boolean messageIsValid;
	public NonNullList fields;
	private BlockPos pos;
	public ByteBuf fieldBuffer = null;

	public MessageTileEntityRefresh(BlockPos pos, NonNullList fields)
	{
		this.messageIsValid = true;
		this.fields = fields;
		this.pos = pos;
	}

	public NonNullList getFields()
	{
		return this.fields;
	}

	public BlockPos getPos()
	{
		return this.pos;
	}

	public boolean isMessageValid()
	{
		return this.messageIsValid;
	}

	public MessageTileEntityRefresh()
	{
		this.messageIsValid = false;
	}

	@Override
	public void fromBytes(ByteBuf buffer)
	{
		try
		{
			this.pos = BlockPos.fromLong(buffer.readLong());
			this.fieldBuffer = buffer.copy();
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

		buffer.writeLong(this.pos.toLong());
		Object[] objL = this.fields.toArray();
		for (Object obj : objL)
		{

			if (obj instanceof Boolean)
			{
				buffer.writeBoolean((Boolean) obj);
			}
			else if (obj instanceof Byte)
			{
				buffer.writeByte((Byte) obj);
			}
			else if (obj instanceof Integer)
			{
				buffer.writeInt((Integer) obj);
			}
			else if (obj instanceof Short)
			{
				buffer.writeShort((Short) obj);
			}
			else if (obj instanceof Long)
			{
				buffer.writeLong((Long) obj);
			}
			else if (obj instanceof Float)
			{
				buffer.writeFloat((Float) obj);
			}
			else if (obj instanceof Double)
			{
				buffer.writeDouble((Double) obj);
			}
			else if (obj instanceof String)
			{
				ByteBufUtils.writeUTF8String(buffer, (String) obj);
			}
			else if (obj instanceof NBTTagCompound)
			{
				ByteBufUtils.writeTag(buffer, (NBTTagCompound) obj);
			}
			else if (obj instanceof ItemStack)
			{
				ByteBufUtils.writeItemStack(buffer, (ItemStack) obj);
			}
		}
	}

	@Override
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}
