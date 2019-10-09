package com.deextinction.tileentities;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageTileEntityRefresh;
import com.deextinction.util.IRefresh;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TileMachineRefresh extends TileMachine implements IRefresh
{
	public TileMachineRefresh(int[] slots_top, int[] slots_sides, int[] slots_bottom)
	{
		super(slots_top, slots_sides, slots_bottom);
	}

	protected void refresh()
	{
		if (DeExtinction.isEffectiveClient())
			return;
		DeMessages.wrapper.sendToAll(new MessageTileEntityRefresh(this.pos, this.getFieldsToRefresh(NonNullList.create())));
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack)
	{
		super.setInventorySlotContents(index, stack);
		this.refresh();
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		return new SPacketUpdateTileEntity(this.pos, 0, this.getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag()
	{
		return this.writeToNBT(new NBTTagCompound());
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void onDataPacket(NetworkManager networkManager, SPacketUpdateTileEntity packet)
	{
		this.readFromNBT(packet.getNbtCompound());
	}

	@Override
	public NonNullList getFieldsToRefresh(NonNullList fields)
	{
		for (ItemStack stack : this.getSlots())
			fields.add(stack);
		return fields;
	}

	@Override
	public void setFieldsToRefresh(ByteBuf fields)
	{
		if (FMLCommonHandler.instance().getSide().isClient())
		{
			for (int index = 0; index < this.getSlots().size(); index++)
				this.setInventorySlotContents(index, ByteBufUtils.readItemStack(fields));
		}
	}
}
