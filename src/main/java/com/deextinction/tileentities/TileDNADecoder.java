package com.deextinction.tileentities;

import java.util.HashMap;

import com.deextinction.DeExtinction;
import com.deextinction.client.gui.inventory.GuiDNADecoder;
import com.deextinction.database.DeExtincted;
import com.deextinction.init.DeDatabase;
import com.deextinction.init.DeItems;
import com.deextinction.item.ItemDNABottle;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.item.ItemFloppyDiskEmpty;
import com.deextinction.tileentities.containers.ContainerDNADecoder;
import com.deextinction.util.DNA;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;

public class TileDNADecoder extends TileMachine
{
	public static final int SLOT_INDEX_DNA_BOTTLE = 0;
	public static final int SLOT_INDEX_DISK_EMPTY = 1;

	private static final int DECODING_PROGRESS_MAX = 120;
	private static final int DECODING_OFF = 0;
	private static final int DECODING_ON = 1;

	private int decodingProgress = 0;
	private int researchProgress = 0;

	private HashMap<String, Integer> listDeExtincted = new HashMap<String, Integer>();

	public TileDNADecoder()
	{
		super(new int[] { TileDNADecoder.SLOT_INDEX_DNA_BOTTLE }, new int[] { TileDNADecoder.SLOT_INDEX_DISK_EMPTY }, new int[] { 2, 3, 4, 5 });
	}


	public int getDecodingProgress()
	{
		return (this.decodingProgress);
	}

	public void setDecodingProgress(int value)
	{
		this.decodingProgress = value;
	}

	public boolean isDecoding()
	{
		return (this.decodingProgress > 0);
	}

	public int getDecodingProgressScaled(int scale)
	{
		return (scale * this.decodingProgress / TileDNADecoder.DECODING_PROGRESS_MAX);
	}

	public int getResearchPoints(String name)
	{
		return (this.listDeExtincted.get(name));
	}

	public void setResearchPoints(String name, int points)
	{
		this.listDeExtincted.put(name, points);
	}

	public boolean hasResearchPoints(String name)
	{
		return (this.listDeExtincted.containsKey(name));
	}

	public int getResearchProgress()
	{
		return (this.researchProgress);
	}

	public void setResearchProgress(int researchProgress)
	{
		this.researchProgress = researchProgress;
	}

	public int getResearchProgressScaled(int scale)
	{
		String deExtinctedName = this.getNameFromDNABottle();
		if (deExtinctedName != null)
			return (scale * this.researchProgress / DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName).getResearchNeeded());
		else
			return 0;
	}

	public String getWarningForGui()
	{
		String deExtinctedName = this.getNameFromDNABottle();
		if (deExtinctedName != null)
		{
			DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName);
			if (deExtincted != null)
			{
				if (this.researchProgress < deExtincted.getResearchNeeded())
					return I18n.translateToLocal(deExtincted.getUnlocalizedName());
				else
				{
					if (this.hasFloppyDiskEmpty())
						return I18n.translateToLocal(deExtincted.getUnlocalizedName());
					else
						return I18n.translateToLocal("container.dna_decoder.no_floppy_disk");
				}
			}
			return I18n.translateToLocal("ERROR: This creature is not registered!");
		}
		return I18n.translateToLocal("container.dna_decoder.no_dna");
	}

	private String getNameFromDNABottle()
	{
		if (this.hasDNABottle())
			return ((ItemDNABottle) this.getSlot(TileDNADecoder.SLOT_INDEX_DNA_BOTTLE).getItem()).getDeExtinctedName();
		else
			return null;
	}

	public boolean isDNABottle(ItemStack itemStack)
	{
		return (!itemStack.isEmpty() && itemStack.getItem() instanceof ItemDNABottle);
	}

	public boolean hasDNABottle()
	{
		return (this.isDNABottle(this.getSlot(TileDNADecoder.SLOT_INDEX_DNA_BOTTLE)));
	}

	public boolean isFloppyDiskEmpty(ItemStack itemStack)
	{
		return (!itemStack.isEmpty() && itemStack.getItem() instanceof ItemFloppyDiskEmpty);
	}

	public boolean hasFloppyDiskEmpty()
	{
		return (this.isFloppyDiskEmpty(this.getSlot(TileDNADecoder.SLOT_INDEX_DISK_EMPTY)));
	}

	public boolean hasSlotForFloppyDiskFull()
	{
		for (int slotIndex : this.getSlotsBottom())
			if (this.getSlot(slotIndex).isEmpty())
				return true;
		return false;
	}

	private void uptadeResearchProgress()
	{
		if (this.hasDNABottle())
		{
			String deExtinctedName = this.getNameFromDNABottle();
			if (deExtinctedName != null)
			{
				if (this.listDeExtincted.containsKey(deExtinctedName))
					this.researchProgress = this.listDeExtincted.get(deExtinctedName);
				else
				{
					this.listDeExtincted.put(deExtinctedName, 0);
					this.researchProgress = 0;
				}
			}
		}
		else
			this.researchProgress = 0;
	}

	public boolean canRecord()
	{
		return (this.researchProgress >= 5 && this.hasFloppyDiskEmpty());
	}

	public boolean shouldDecode()
	{
		if (this.canRecord())
		{
			if (this.hasDNABottle())
				return true;
		}
		else
		{
			if (this.hasDNABottle())
			{
				if (this.researchProgress < 5)
					return true;
			}
		}

		this.decodingProgress = 0;
		return false;
	}

	public boolean canDecode()
	{
		if (this.decodingProgress >= TileDNADecoder.DECODING_PROGRESS_MAX)
			return true;

		String deExtinctedName = this.getNameFromDNABottle();
		if (deExtinctedName != null)
		{
			DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName);
			if (deExtincted != null)
			{
				for (int slotIndex : this.getSlotsBottom())
				{
					if (this.getSlot(slotIndex).isEmpty())
					{
						this.decodingProgress++;
						if (!this.listDeExtincted.containsKey(deExtincted.getName()))
							this.listDeExtincted.put(deExtincted.getName(), 0);
						return false;
					}
				}
			}
		}

		this.decodingProgress = 0;
		return false;
	}

	public void decode()
	{
		this.decodingProgress = 0;
		boolean hasSetStack = false;

		String deExtinctedName = this.getNameFromDNABottle();
		if (deExtinctedName != null)
		{
			if (this.listDeExtincted.containsKey(deExtinctedName))
			{
				DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName);
				if (deExtincted != null)
				{
					if (this.listDeExtincted.get(deExtinctedName) < deExtincted.getResearchNeeded())
						this.listDeExtincted.put(deExtinctedName, this.listDeExtincted.get(deExtinctedName) + 1);
				}
			}
			else
				this.listDeExtincted.put(deExtinctedName, 1);

			if (this.canRecord())
			{
				ItemStack dna_floppy_disk = new ItemStack(DeItems.dna_floppy_disks.get(deExtinctedName));
				if (!dna_floppy_disk.isEmpty())
				{
					NBTTagCompound compound_disk = new NBTTagCompound();
					compound_disk.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
					compound_disk.setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70);
					dna_floppy_disk.setTagCompound(compound_disk);

					for (int slotIndex : this.getSlotsBottom())
					{
						if (!this.getSlot(slotIndex).isEmpty() && this.getSlot(slotIndex).getItem() instanceof ItemFloppyDisk && this.getSlot(slotIndex).getTagCompound().equals(compound_disk))
						{
							this.growStack(slotIndex, 1);
							hasSetStack = true;
							break;
						}
					}

					if (!hasSetStack)
					{
						for (int slotIndex : this.getSlotsBottom())
						{
							if (this.getSlot(slotIndex).isEmpty())
							{
								this.setInventorySlotContents(slotIndex, dna_floppy_disk);

								hasSetStack = true;
								break;
							}
						}
					}
				}
			}
		}

		if (hasSetStack)
			this.shrinkStack(TileDNADecoder.SLOT_INDEX_DISK_EMPTY, 1);
		this.shrinkStack(TileDNADecoder.SLOT_INDEX_DNA_BOTTLE, 1);
	}

	@Override
	public void update()
	{
		if (!this.world.isRemote)
		{
			//if (this.pageID == GuiDNADecoder.PAGE_DECODING)
			{
				this.uptadeResearchProgress();

				if (this.shouldDecode())
				{
					if (this.canDecode())
						this.decode();
				}
				else
					this.decodingProgress = 0;
			}
		}
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerDNADecoder(playerInventory, this);
	}

	@Override
	public String getGuiID()
	{
		return DeExtinction.prependModID("dna_decoder");
	}

	@Override
	public void setCustomInventoryName(String name)
	{
		this.tileCustomName = name;
	}

	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.tileCustomName : I18n.translateToLocal("container.dna_decoder.name");
	}

	@Override
	public boolean hasCustomName()
	{
		return this.tileCustomName != null && this.tileCustomName.length() > 0;
	}

	@Override
	public void setInventorySlotContents(boolean flag, int index, ItemStack stack)
	{
		if (index == 0 && !flag)
		{
			this.decodingProgress = 0;
			this.markDirty();
		}
		else if (index == 1 && !flag)
		{
			this.researchProgress = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case TileDNADecoder.SLOT_INDEX_DNA_BOTTLE:
				return this.isDNABottle(stack);
			case TileDNADecoder.SLOT_INDEX_DISK_EMPTY:
				return this.isFloppyDiskEmpty(stack);
			default:
				return false;
		}
	}

	@Override
	public int getField(int id)
	{
		switch (id)
		{
			case 0:
				return this.decodingProgress;
			case 1:
				return this.researchProgress;
			}
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		switch (id)
		{
			case 0:
				this.decodingProgress = value;
				break;
			case 1:
				this.researchProgress = value;
				break;
			
		}
	}

	@Override
	public int getFieldCount()
	{
		return 3;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("DecodingProgress", this.decodingProgress);
		compound.setInteger("ResearchProgress", this.researchProgress);

		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			if (this.listDeExtincted.containsKey(deExtincted.getName()))
				compound.setInteger(deExtincted.getName(), this.listDeExtincted.get(deExtincted.getName()));
		}
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("DecodingProgress"))
			this.decodingProgress = compound.getInteger("DecodingProgress");
		if (compound.hasKey("ResearchProgress"))
			this.researchProgress = compound.getInteger("ResearchProgress");
		

		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			if (compound.hasKey(deExtincted.getName()))
				this.setResearchPoints(deExtincted.getName(), compound.getInteger(deExtincted.getName()));
		}
	}
}
