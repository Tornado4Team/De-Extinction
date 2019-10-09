package com.deextinction.tileentities;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.FossilRenderInfo;
import com.deextinction.init.DeDatabase;
import com.deextinction.init.DeMessages;
import com.deextinction.network.MessageTileEntityRefresh;
import com.deextinction.util.IRefresh;
import com.deextinction.util.MathHelper;

import io.netty.buffer.ByteBuf;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileFossilBroken extends TileEntity implements IRefresh
{
	public static final int SLOT_INDEX_FOSSIL = 0;

	private NonNullList<ItemStack> slots;
	private FossilRenderInfo fossilInfo;
	private String animalName;
	private int uniqueRotation;
	private float uniqueScale;
	private float uniquePosition1;
	private float uniquePosition2;

	public TileFossilBroken()
	{
		this.slots = NonNullList.<ItemStack> withSize(1, ItemStack.EMPTY);
		this.slots.clear();
	}

	public NonNullList<ItemStack> getSlots()
	{
		return this.slots;
	}

	public ItemStack getSlot(int index)
	{
		return this.slots.get(index);
	}

	public void setSlot(int index, ItemStack itemStack)
	{
		this.setInventorySlotContents(index, itemStack);
	}

	public void setInventorySlotContents(int index, ItemStack stack)
	{
		ItemStack itemstack = this.slots.get(index);
		boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
		this.slots.set(index, stack);

		if (stack.getCount() > this.getInventoryStackLimit())
			stack.setCount(this.getInventoryStackLimit());

		this.refresh();
	}

	public int getInventoryStackLimit()
	{
		return 64;
	}

	protected void refresh()
	{
		if (DeExtinction.isEffectiveClient())
			return;
		DeMessages.wrapper.sendToAll(new MessageTileEntityRefresh(this.pos, this.getFieldsToRefresh(NonNullList.create())));
	}

	public float getUniqueScale()
	{
		return uniqueScale;
	}

	public float getUniquePosition1()
	{
		return this.uniquePosition1;
	}

	public float getUniquePosition2()
	{
		return this.uniquePosition2;
	}

	public float getUniqueRotation()
	{
		return this.uniqueRotation;
	}

	public void setFossil(DeExtincted deExtincted)
	{
		this.uniqueScale = 0.5F;

		if (deExtincted != null && DeDatabase.LIST_DE_EXTINCTED.containsKey(deExtincted.getName()))
		{
			this.animalName = deExtincted.getName();
			this.fossilInfo = deExtincted.getFossilInfo();
			this.setSlot(TileFossilBroken.SLOT_INDEX_FOSSIL, deExtincted.getFossilItemDirty());
			if (this.fossilInfo != null)
				this.uniqueScale = deExtincted.getFossilInfo().getScale();
		}
		else
		{
			this.animalName = null;
			this.fossilInfo = null;
			this.setSlot(TileFossilBroken.SLOT_INDEX_FOSSIL, ItemStack.EMPTY);
		}

		this.uniquePosition1 = -0.2F + 0.4F * MathHelper.RAND.nextFloat();
		this.uniquePosition2 = -0.2F + 0.4F * MathHelper.RAND.nextFloat();
		this.uniqueRotation = 10 * MathHelper.RAND.nextInt(37);

		this.refresh();
		this.markDirty();
	}

	public FossilRenderInfo getFossilInfo()
	{
		return this.fossilInfo;
	}

	public boolean hasFossilInfo()
	{
		return this.fossilInfo != null;
	}

	public ItemStack getFossilStack()
	{
		return this.getSlot(TileFossilBroken.SLOT_INDEX_FOSSIL);
	}

	public boolean hasFossilStack()
	{
		return !this.getSlots().isEmpty();
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		if (this.animalName != null)
			compound.setString("AnimalName", this.animalName);

		compound.setInteger("Rotation", this.uniqueRotation);
		compound.setFloat("Position1", this.uniquePosition1);
		compound.setFloat("Position2", this.uniquePosition2);
		compound.setFloat("Scale", this.uniqueScale);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("AnimalName", 8))
			this.animalName = compound.getString("AnimalName");
		this.setFossil(DeDatabase.LIST_DE_EXTINCTED.get(this.animalName));

		this.uniqueRotation = compound.getInteger("Rotation");
		this.uniquePosition1 = compound.getFloat("Position1");
		this.uniquePosition2 = compound.getFloat("Position2");
		this.uniqueScale = compound.getFloat("Scale");
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
		fields.add(this.uniqueRotation);
		fields.add(this.uniquePosition1);
		fields.add(this.uniquePosition2);
		fields.add(this.uniqueScale);
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
		this.uniqueRotation = fields.readInt();
		this.uniquePosition1 = fields.readFloat();
		this.uniquePosition2 = fields.readFloat();
		this.uniqueScale = fields.readFloat();
	}
}
