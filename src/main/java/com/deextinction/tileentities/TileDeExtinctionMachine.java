package com.deextinction.tileentities;

import com.deextinction.DeExtinction;
import com.deextinction.block.BlockContainerHorizontalWorking;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.tileentities.containers.ContainerDeExtinctionMachine;
import com.deextinction.util.DNA;
import com.deextinction.util.ITileWorking;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class TileDeExtinctionMachine extends TileMachine implements ITileWorking
{
	public static final int SLOT_INDEX_FLOPPY_DISK = 0;
	public static final int SLOT_INDEX_EMBRYO_REQUIREMENT = 1;
	public static final int SLOT_INDEX_EMBRYO_CREATED = 2;

	private static final int CREATING_PROGRESS_MAX = 120;

	private int creatingProgress = 0;

	public TileDeExtinctionMachine()
	{
		super(new int[] { TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK }, new int[] { TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT }, new int[] { TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_CREATED });
	}

	@Override
	public boolean isWorking()
	{
		return this.isCreating();
	}

	public int getCreatingProgress()
	{
		return this.creatingProgress;
	}

	public void setCreatingProgress(int value)
	{
		this.creatingProgress = value;
	}

	public boolean isCreating()
	{
		return this.creatingProgress > 0;
	}

	public int getCreatingProgressScaled(int scale)
	{
		return scale * this.creatingProgress / TileDeExtinctionMachine.CREATING_PROGRESS_MAX;
	}

	public boolean isFloppyDisk(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemFloppyDisk;
	}

	public boolean hasFloppyDisk()
	{
		return this.isFloppyDisk(this.getSlot(TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK));
	}

	public String getNameFromFloppyDisk()
	{
		if (this.hasFloppyDisk())
			return ((ItemFloppyDisk) this.getSlot(TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK).getItem()).getDeExtinctedName();
		return null;
	}

	public boolean isEmbryoRequirement(ItemStack itemStack)
	{
		if (itemStack.isEmpty())
			return false;

		String deExtinctedName = this.getNameFromFloppyDisk();
		if (deExtinctedName != null)
		{
			DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName);
			if (deExtincted != null)
				return itemStack.getItem() == deExtincted.getPrecursorItem().getItem();
		}
		return false;
	}

	public boolean hasEmbryoRequirement()
	{
		return this.isEmbryoRequirement(this.getSlot(TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT));
	}

	public boolean hasSlotForEmbryo()
	{
		return this.getSlot(TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_CREATED).isEmpty();
	}

	public boolean shouldCreate()
	{
		if (this.hasFloppyDisk() && this.hasEmbryoRequirement() && this.hasSlotForEmbryo())
			return true;

		this.creatingProgress = 0;
		return false;
	}

	public boolean canCreate()
	{
		if (this.creatingProgress >= TileDeExtinctionMachine.CREATING_PROGRESS_MAX)
			return true;

		this.creatingProgress++;
		return false;
	}

	public void create()
	{
		this.creatingProgress = 0;
		boolean hasSetStack = false;

		ItemStack floppy_disk = this.getSlot(TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK);
		if (floppy_disk.hasTagCompound())
		{
			NBTTagCompound compound = floppy_disk.getTagCompound();
			if (compound != null && compound.hasKey(ItemFloppyDisk.NBT_TAG_VIABILITY) && this.world.rand.nextInt(100) < compound.getInteger(ItemFloppyDisk.NBT_TAG_VIABILITY))
			{
				String deExtinctedName = this.getNameFromFloppyDisk();
				if (deExtinctedName != null)
				{
					DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(deExtinctedName);
					String dna = DNA.DEFAULT_DNA_STRING;
					if (compound.hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
						dna = compound.getString(ItemFloppyDisk.NBT_TAG_DNA_STRING);

					ItemStack itemStackResult = deExtincted.getResultItem(dna);
					if (itemStackResult != null)
					{
						if (deExtincted instanceof DeExtinctedAnimal)
						{
							NBTTagCompound compoundResult = new NBTTagCompound();
							if (compound.hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
								compoundResult.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, dna);

							itemStackResult.setTagCompound(compoundResult);
							this.setInventorySlotContents(TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_CREATED, itemStackResult);

						}
						else if (deExtincted instanceof DeExtinctedPlant)
							this.setInventorySlotContents(TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_CREATED, itemStackResult);

						hasSetStack = true;
					}
				}
			}
			else
			{
				// TODO spawn Failsaur.

				this.world.createExplosion(null, this.pos.getX(), this.pos.getY(), this.pos.getZ(), 1.0F, true);

				EntityZombie zombie = new EntityZombie(this.world);
				zombie.setPosition(this.pos.getX() + 0.25D - 0.50D * this.world.rand.nextDouble(), this.pos.getY() + 1.0D, this.pos.getZ() + 0.25D - 0.50D * this.world.rand.nextDouble());
				this.world.spawnEntity(zombie);
				hasSetStack = true;
			}
		}

		if (hasSetStack)
		{
			this.shrinkStack(TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK, 1);
			this.shrinkStack(TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT, 1);
		}
	}

	@Override
	public void update()
	{
		if (!this.world.isRemote)
		{
			if (this.shouldCreate())
			{
				if (this.canCreate())
					this.create();
				else
					this.updateModel();
			}
			else
				this.updateModel();
		}
	}

	@Override
	public void updateModel()
	{
		IBlockState iblockstate = this.world.getBlockState(this.pos);
		if (iblockstate.getBlock() == DeBlocks.de_extinction_machine && ((Boolean) iblockstate.getValue(BlockContainerHorizontalWorking.WORKING)).booleanValue() != this.isWorking())
		{
			this.world.setBlockState(this.pos, iblockstate.withProperty(BlockContainerHorizontalWorking.WORKING, this.isWorking()), 3);
			this.markDirty();
		}
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
	{
		return (oldState.getBlock() != newState.getBlock());
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerDeExtinctionMachine(playerInventory, this);
	}

	@Override
	public String getGuiID()
	{
		return DeExtinction.prependModID("de_extinction_machine");
	}

	@Override
	public void setCustomInventoryName(String name)
	{
		this.tileCustomName = name;
	}

	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.tileCustomName : I18n.translateToLocal("container.de_extinction_machine.name");
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
			this.creatingProgress = 0;
			this.markDirty();
		}
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case TileDeExtinctionMachine.SLOT_INDEX_FLOPPY_DISK:
				return this.isFloppyDisk(stack);
			case TileDeExtinctionMachine.SLOT_INDEX_EMBRYO_REQUIREMENT:
				return this.isEmbryoRequirement(stack);
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
				return this.creatingProgress;
		}
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{
		switch (id)
		{
			case 0:
				this.creatingProgress = value;
				break;
		}
	}

	@Override
	public int getFieldCount()
	{
		return 1;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("CreatingProgress", this.creatingProgress);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("CreatingProgress"))
			this.creatingProgress = compound.getInteger("CreatingProgress");
	}
}
