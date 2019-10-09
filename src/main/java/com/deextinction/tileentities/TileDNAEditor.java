package com.deextinction.tileentities;

import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockFossil;
import com.deextinction.database.DeExtincted;
import com.deextinction.init.DeDatabase;
import com.deextinction.init.DeItems;
import com.deextinction.item.ItemDNABottle;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.tileentities.containers.ContainerDNAEditor;
import com.deextinction.util.DNA;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;

public class TileDNAEditor extends TileMachine
{
	public static final int SLOT_INDEX_DNA_BOTTLE_1 = 0;
	public static final int SLOT_INDEX_DNA_BOTTLE_2 = 1;
	public static final int SLOT_INDEX_DNA_BOTTLE_3 = 2;
	public static final int SLOT_INDEX_FLOPPY_DISK = 3;
	public static final int SLOT_INDEX_FLOPPY_DISK_EDITED = 4;

	private static final int EDITING_PROGRESS_MAX = 120;
	private ItemStack prev_floppy_disk = ItemStack.EMPTY;
	private boolean allowedToEdit = false;
	private int editingProgress = 0;
	private DNA new_dna;
	private DNA dna;

	public TileDNAEditor()
	{
		super(new int[] { TileDNAEditor.SLOT_INDEX_FLOPPY_DISK }, new int[] { TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_2, TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3 }, new int[] { TileDNAEditor.SLOT_INDEX_FLOPPY_DISK_EDITED });
		this.new_dna = new DNA();
		this.dna = new DNA();
	}

	public int getEditingProgress()
	{
		return this.editingProgress;
	}

	public void setEditingProgress(int value)
	{
		this.editingProgress = value;
	}

	public boolean isEditing()
	{
		return this.editingProgress > 0;
	}

	public boolean isEditingProgressPastMiddle()
	{
		return this.editingProgress >= TileDNAEditor.EDITING_PROGRESS_MAX / 2.0F;
	}

	public int getEditingProgressScaled(int scale)
	{
		return scale * this.editingProgress / TileDNAEditor.EDITING_PROGRESS_MAX;
	}

	public float getEditingProgressScaled()
	{
		return this.editingProgress / TileDNAEditor.EDITING_PROGRESS_MAX;
	}

	public boolean isAllowedToEdit()
	{
		return this.allowedToEdit;
	}

	public void toggleAllowedToEdit()
	{
		this.allowedToEdit = !this.allowedToEdit;
	}

	public void setAllowedToEdit(boolean allowedToEdit)
	{
		this.allowedToEdit = allowedToEdit;
	}

	public void setDNA(DNA dna)
	{
		this.dna = dna;
	}

	public void setDNA(String dna)
	{
		this.dna.setDNA(dna);
	}

	public DNA getDNA()
	{
		return this.dna;
	}

	public void setNewDNA(DNA dna)
	{
		this.new_dna = dna;
	}

	public void setNewDNA(String dna)
	{
		this.new_dna.setDNA(dna);
	}

	public DNA getNewDNA()
	{
		return this.new_dna;
	}

	public int getSlotIndexFromDNAIndex(int index)
	{
		switch (index)
		{
			case DNA.DNA_INDEX_1:
				return TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1;
			case DNA.DNA_INDEX_2:
				return TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_2;
			case DNA.DNA_INDEX_3:
				return TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3;
			default:
				return -1;
		}
	}

	public String getWarnings()
	{
		if (this.hasFloppyDisk())
		{
			ItemStack floppyDisk = this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK);
			if (floppyDisk.hasTagCompound() && floppyDisk.getTagCompound().hasKey(BlockFossil.NBT_TAG_FOSSIL_NAME))
			{
				DeExtincted deExtinct = DeDatabase.LIST_DE_EXTINCTED.get(floppyDisk.getTagCompound().getString(BlockFossil.NBT_TAG_FOSSIL_NAME));
				if (deExtinct != null)
					return I18n.translateToLocal(deExtinct.getUnlocalizedName());
			}
		}
		return I18n.translateToLocal("container.dna_editor.no_floppy_disk");
	}

	public DNA getDNAFromFloppyDisk()
	{
		if (this.hasFloppyDisk())
		{
			ItemStack floppy_disk = this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK);
			if (floppy_disk.hasTagCompound() && floppy_disk.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
				return new DNA(floppy_disk.getTagCompound().getString(ItemFloppyDisk.NBT_TAG_DNA_STRING));
		}
		return null;
	}

	public String getDNAStringFromFloppyDisk()
	{
		if (this.hasFloppyDisk())
		{
			ItemStack floppy_disk = this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK);
			if (floppy_disk.hasTagCompound() && floppy_disk.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
				return floppy_disk.getTagCompound().getString(ItemFloppyDisk.NBT_TAG_DNA_STRING);
		}
		return null;
	}

	public String getNameFromFloppyDisk()
	{
		if (this.hasFloppyDisk())
			return ((ItemFloppyDisk) this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK).getItem()).getDeExtinctedName();
		return null;
	}

	public String getNameFromDNABottle(int index)
	{
		if (this.hasDNABottle(index))
			return ((ItemDNABottle) this.getSlot(index).getItem()).getDeExtinctedName();
		return null;
	}

	public String getNameFromDNABottleForDisplay(int index)
	{
		String deExtinctedName = this.getNameFromDNABottle(index);
		if (deExtinctedName != null)
		{
			DeExtincted deExtinct = DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName);
			if (deExtinct != null)
				return deExtinct.getName();
			else
				DeExtinction.logger.error("TileDNAEditor tried to get the name of a deextinct that does not exist! THIS IS A BUG!");
		}
		return null;
	}

	public boolean isFloppyDisk(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemFloppyDisk;
	}

	public boolean hasFloppyDisk()
	{
		return this.isFloppyDisk(this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK));
	}

	private boolean hasSlotForFloppyDiskEdited()
	{
		return this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK_EDITED).isEmpty();
	}

	public boolean isDNABottle(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemDNABottle;
	}

	public boolean isDNABottleValid(ItemStack itemStack)
	{
		if (this.isDNABottle(itemStack))
		{
			String floppyDiskName = this.getNameFromFloppyDisk();
			if (floppyDiskName != null)
				return floppyDiskName.equals(((ItemDNABottle) itemStack.getItem()).getDeExtinctedName());
		}
		return false;
	}

	public boolean hasDNABottles()
	{
		return this.isDNABottleValid(this.getSlot(TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1)) || this.isDNABottleValid(this.getSlot(TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_2)) || this.isDNABottleValid(this.getSlot(TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3));
	}

	public boolean hasDNABottle(int index)
	{
		if (index >= TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1 && index <= TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3)
			return this.isDNABottle(this.getSlot(index));
		else
			return false;
	}

	public boolean hasDNABottleValid(int index)
	{
		String nameFromBottle = this.getNameFromDNABottle(index);
		if (nameFromBottle != null)
		{
			String nameFromFloppyDisk = this.getNameFromFloppyDisk();
			if (nameFromFloppyDisk != null)
				return nameFromFloppyDisk.equals(nameFromBottle);
		}
		return false;
	}

	private boolean checkDNABottleRequirements()
	{
		List<Integer> indexes = this.dna.getDifferentIndexes(this.new_dna);
		if (indexes == null || indexes.size() <= 0)
			return false;

		for (int index : indexes)
		{
			if (!this.hasDNABottleValid(this.getSlotIndexFromDNAIndex(index)))
				return false;
		}
		return true;
	}

	public boolean shouldAllowEditButton()
	{
		return this.hasFloppyDisk() && !this.dna.equal(this.new_dna) && this.checkDNABottleRequirements() && this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK_EDITED).isEmpty();
	}

	public boolean shouldEditDNA()
	{
		if (this.allowedToEdit)
			return this.hasFloppyDisk() && !this.dna.equal(this.new_dna) && this.checkDNABottleRequirements() && this.hasSlotForFloppyDiskEdited();

		this.editingProgress = 0;
		return false;
	}

	public boolean canEditDNA()
	{
		if (this.editingProgress >= TileDNAEditor.EDITING_PROGRESS_MAX)
			return true;

		if (this.hasSlotForFloppyDiskEdited())
		{
			this.editingProgress++;
			return false;
		}

		this.editingProgress = 0;
		return false;
	}

	public void editDNA()
	{
		this.editingProgress = 0;
		boolean hasSetStack = false;

		ItemStack floppy_disk = this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK);
		if (floppy_disk.hasTagCompound())
		{
			NBTTagCompound compound_floppy_disk = floppy_disk.getTagCompound();
			if (compound_floppy_disk != null && compound_floppy_disk.hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
			{
				NBTTagCompound compound_floppy_disk_new = compound_floppy_disk.copy();
				compound_floppy_disk_new.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, this.new_dna.getDNA());
				if (!compound_floppy_disk_new.hasKey(ItemFloppyDisk.NBT_TAG_VIABILITY))
					compound_floppy_disk_new.setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70);

				ItemStack floppy_disk_new = new ItemStack(DeItems.dna_floppy_disks.get(this.getNameFromFloppyDisk()));
				floppy_disk_new.setTagCompound(compound_floppy_disk_new);

				List<Integer> indexes = this.dna.getDifferentIndexes(this.new_dna);
				if (indexes != null)
				{
					for (int index : indexes)
					{
						int new_viability = floppy_disk_new.getTagCompound().getInteger(ItemFloppyDisk.NBT_TAG_VIABILITY) + 10;
						floppy_disk_new.getTagCompound().setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, new_viability > 100 ? 100 : new_viability);
						this.shrinkStack(index, 1);
						hasSetStack = true;
					}
				}

				if (hasSetStack)
				{
					this.setInventorySlotContents(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK_EDITED, floppy_disk_new);

					this.shrinkStack(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK, 1);
					this.setDNA(DNA.DEFAULT_DNA_STRING);
					this.setNewDNA(DNA.DEFAULT_DNA_STRING);
				}
			}
		}
	}

	@Override
	public void update()
	{
		if (!this.world.isRemote)
		{
			if (this.prev_floppy_disk != this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK))
			{
				this.prev_floppy_disk = this.getSlot(TileDNAEditor.SLOT_INDEX_FLOPPY_DISK);
				if (this.hasFloppyDisk())
				{
					this.dna.setDNA(this.getDNAStringFromFloppyDisk());
					this.new_dna.setDNA(this.getDNAStringFromFloppyDisk());
				}
				else
				{
					this.dna.setDNA(DNA.DEFAULT_DNA_STRING);
					this.new_dna.setDNA(DNA.DEFAULT_DNA_STRING);
				}
			}

			if (this.shouldEditDNA())
				if (this.canEditDNA())
					this.editDNA();
		}
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerDNAEditor(playerInventory, this);
	}

	@Override
	public String getGuiID()
	{
		return DeExtinction.prependModID("dna_editor");
	}

	@Override
	public void setCustomInventoryName(String name)
	{
		this.tileCustomName = name;
	}

	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.tileCustomName : I18n.translateToLocal("container.dna_editor.name");
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
			this.editingProgress = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case TileDNAEditor.SLOT_INDEX_FLOPPY_DISK:
				return this.isFloppyDisk(stack);
			case TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_1:
			case TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_2:
			case TileDNAEditor.SLOT_INDEX_DNA_BOTTLE_3:
				return this.isDNABottleValid(stack);
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
				return this.editingProgress;
			case 1:
				return this.dna.getNucleobase(DNA.DNA_INDEX_1).getNucleobaseValue();
			case 2:
				return this.dna.getNucleobase(DNA.DNA_INDEX_2).getNucleobaseValue();
			case 3:
				return this.dna.getNucleobase(DNA.DNA_INDEX_3).getNucleobaseValue();
			case 4:
				return this.new_dna.getNucleobase(DNA.DNA_INDEX_1).getNucleobaseValue();
			case 5:
				return this.new_dna.getNucleobase(DNA.DNA_INDEX_2).getNucleobaseValue();
			case 6:
				return this.new_dna.getNucleobase(DNA.DNA_INDEX_3).getNucleobaseValue();
		}
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		switch (id)
		{
			case 0:
				this.editingProgress = value;
				break;
			case 1:
				this.dna.setNucleobase(DNA.DNA_INDEX_1, value);
				break;
			case 2:
				this.dna.setNucleobase(DNA.DNA_INDEX_2, value);
				break;
			case 3:
				this.dna.setNucleobase(DNA.DNA_INDEX_3, value);
				break;
			case 4:
				this.new_dna.setNucleobase(DNA.DNA_INDEX_1, value);
				break;
			case 5:
				this.new_dna.setNucleobase(DNA.DNA_INDEX_2, value);
				break;
			case 6:
				this.new_dna.setNucleobase(DNA.DNA_INDEX_3, value);
				break;
		}
	}

	@Override
	public int getFieldCount()
	{
		return 7;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("EditingProgress", this.editingProgress);
		compound.setBoolean("AllowedToEdit", this.allowedToEdit);
		compound.setString("New_DNA", this.new_dna.getDNA());
		compound.setString("DNA", this.dna.getDNA());
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("EditingProgress"))
			this.editingProgress = compound.getInteger("EditingProgress");
		if (compound.hasKey("AllowedToDecode"))
			this.allowedToEdit = compound.getBoolean("AllowedToEdit");
		if (compound.hasKey("New_DNA"))
			this.setDNA(compound.getString("New_DNA"));
		if (compound.hasKey("DNA"))
			this.setNewDNA(compound.getString("New_DNA"));
	}
}
