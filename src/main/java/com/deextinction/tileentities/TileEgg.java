package com.deextinction.tileentities;

import com.deextinction.DeExtinction;
import com.deextinction.block.eggs.BlockEgg;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.init.DeDatabase;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.util.DNA;
import com.deextinction.util.MinecraftTime;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TileEgg extends TileEntity implements ITickable
{
	private NonNullList<ItemStack> slots;
	private String animalName;

	private int hatchingProgressMax = MinecraftTime.MC_DAY_LENGHT;
	private int hatchingProgress = 0;
	private int totalNumberOfEgg;

	public TileEgg(int totalNumberOfEgg)
	{
		this.slots = NonNullList.<ItemStack> withSize(totalNumberOfEgg, ItemStack.EMPTY);
		this.totalNumberOfEgg = totalNumberOfEgg;
		this.clear();
	}

	public String getAnimalName()
	{
		return this.animalName;
	}

	public void setAnimalName(String name)
	{
		this.animalName = name;
	}

	public int getHatchingProgress()
	{
		return this.hatchingProgress;
	}

	public void setHatchingProgress(int value)
	{
		this.hatchingProgress = value;
	}

	public boolean isHatching()
	{
		return this.hatchingProgress > 0;
	}

	public void setHatchingProgressMax(int hatchingProgressMax)
	{
		this.hatchingProgressMax = hatchingProgressMax;
	}

	public int getHatchingProgressMax()
	{
		return this.hatchingProgressMax;
	}

	public int getNumberOfEgg()
	{
		int numberOfEggs = 0;
		for (ItemStack itemStack : this.slots)
			if (itemStack != ItemStack.EMPTY)
				numberOfEggs++;
		return numberOfEggs;
	}

	public void setTotalNumberOfEgg(int totalNumberOfEgg)
	{
		this.totalNumberOfEgg = totalNumberOfEgg;
		this.slots = NonNullList.<ItemStack> withSize(totalNumberOfEgg, ItemStack.EMPTY);
		this.clear();
	}

	public int getTotalNumberOfEgg()
	{
		return this.totalNumberOfEgg;
	}

	protected void updateEggBlockState(int numberOfEggs2, World world, BlockPos pos)
	{
		IBlockState state = this.world.getBlockState(this.pos);
		if (state.getBlock() instanceof BlockEgg)
		{
			((BlockEgg) state.getBlock()).setState(this.getNumberOfEgg(), this.world, this.pos);
			this.markDirty();
		}
	}

	public NonNullList<ItemStack> getEggs()
	{
		return this.slots;
	}

	public boolean canAddEgg(ItemStack itemStack)
	{
		return !this.isFull() && this.isEgg(itemStack);
	}

	public void addEgg(ItemStack itemStack)
	{
		if (!this.isFull() && this.isEgg(itemStack))
		{
			this.slots.set(this.getNumberOfEgg(), itemStack);
			this.updateEggBlockState(this.getNumberOfEgg(), this.world, this.pos);
		}
	}

	public boolean canRemoveEgg()
	{
		return !this.isEmpty();
	}

	public ItemStack removeEgg()
	{
		if (!this.isEmpty())
		{
			ItemStack egg = this.slots.get(this.getNumberOfEgg() - 1).copy();
			this.slots.set(this.getNumberOfEgg() - 1, ItemStack.EMPTY);
			if (this.getNumberOfEgg() <= 0)
				this.world.setBlockToAir(this.pos);
			else
				this.updateEggBlockState(this.getNumberOfEgg(), this.world, this.pos);
			return egg;
		}
		else
			return ItemStack.EMPTY;
	}

	public void destroyAnEgg()
	{
		if (!this.isEmpty())
			this.slots.set(this.getNumberOfEgg() - 1, ItemStack.EMPTY);
	}

	public boolean isEgg(ItemStack itemStack)
	{
		return itemStack != ItemStack.EMPTY && BlockEgg.isBlockEgg(itemStack);
	}

	private boolean isEggModified(ItemStack itemStack)
	{
		if (this.isEgg(itemStack) && itemStack.hasTagCompound())
			return itemStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING);
		return false;
	}

	public boolean hasEggs()
	{
		for (ItemStack itemstack : this.slots)
			if (this.isEgg(itemstack))
				return true;
		return false;
	}

	public boolean hasEggs(int numberOfEggs)
	{
		int totalNumberOfEggs = 0;
		for (ItemStack itemstack : this.slots)
			if (this.isEgg(itemstack))
				totalNumberOfEggs++;
		return numberOfEggs <= totalNumberOfEggs;
	}

	public boolean isFull()
	{
		for (ItemStack itemstack : this.slots)
			if (itemstack.isEmpty())
				return false;
		return true;
	}

	public boolean isEmpty()
	{
		for (ItemStack itemstack : this.slots)
			if (!itemstack.isEmpty())
				return false;
		return true;
	}

	@Override
	public void update()
	{
		if (!this.world.isRemote)
		{
			if (this.hasEggs())
			{
				this.hatchingProgress++;
				if (this.hatchingProgress >= this.getHatchingProgressMax() * this.getNumberOfEgg())
					this.hatch();
			}
			else
				this.hatchingProgress = 0;
		}
	}

	private void hatch()
	{
		this.hatchingProgress = 0;
		for (int index = 0; index < this.getTotalNumberOfEgg(); index++)
		{
			ItemStack itemStack = this.slots.get(index);
			if (this.isEgg(itemStack))
				this.hatchAnimal(index, itemStack);

			if (this.getNumberOfEgg() <= 0)
				this.world.setBlockToAir(this.pos);
			else
				this.updateEggBlockState(this.getNumberOfEgg(), this.world, this.pos);
		}
	}

	private void breakEggs()
	{
		this.world.setBlockToAir(pos);
	}

	private void hatchAnimal(int index, ItemStack itemStack)
	{
		if (DeDatabase.LIST_DE_EXTINCTED.containsKey(this.getAnimalName()))
		{
			DeExtincted deExtincted = DeDatabase.LIST_DE_EXTINCTED.get(this.getAnimalName());
			if (deExtincted instanceof DeExtinctedAnimal)
			{
				EntityCreature entityCreature = ((DeExtinctedAnimal) deExtincted).getEntity(this.world);
				if (entityCreature instanceof EntityDeExtinctedAnimal)
				{
					EntityDeExtinctedAnimal entityAnimal = (EntityDeExtinctedAnimal) entityCreature;

					entityAnimal.setPosition(this.pos.getX() + 0.25D - 0.50D * this.world.rand.nextDouble(), this.pos.getY() + 0.25D, this.pos.getZ() + 0.25D - 0.50D * this.world.rand.nextDouble());

					if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey(ItemFloppyDisk.NBT_TAG_DNA_STRING))
						entityAnimal.initAnimalBabe(itemStack.getTagCompound().getString(ItemFloppyDisk.NBT_TAG_DNA_STRING));
					else
						entityAnimal.initAnimalBabe(DNA.DEFAULT_DNA_STRING);

					this.world.spawnEntity(entityAnimal);
					this.slots.set(index, ItemStack.EMPTY);
				}
				else
				{
					entityCreature.setPosition(this.pos.getX() + 0.25D - 0.50D * this.world.rand.nextDouble(), this.pos.getY() + 0.25D, this.pos.getZ() + 0.25D - 0.50D * this.world.rand.nextDouble());
					this.world.spawnEntity(entityCreature);
					this.slots.set(index, ItemStack.EMPTY);
				}
			}
		}
		else
			DeExtinction.logger.error("TileEgg is trying to spawn an animal that is not in the database! THIS IS A BUG!");
	}

	public boolean isUsableByPlayer(EntityPlayer player)
	{
		if (this.world.getTileEntity(this.pos) != this)
			return false;
		else
			return player.getDistanceSq((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
	}

	public void clear()
	{
		this.slots.clear();
	}

	@Override
	public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
	{
		return (oldState.getBlock() != newState.getBlock());
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		ItemStackHelper.saveAllItems(compound, this.slots);
		if (this.animalName != null)
			compound.setString("AnimalName", this.animalName);
		compound.setInteger("HatchingProgress", this.hatchingProgress);
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		this.slots = NonNullList.<ItemStack> withSize(this.getTotalNumberOfEgg(), ItemStack.EMPTY);
		ItemStackHelper.loadAllItems(compound, this.slots);
		if (compound.hasKey("AnimalName", 8))
			this.animalName = compound.getString("AnimalName");
		if (compound.hasKey("HatchingProgress", 8))
			this.hatchingProgress = compound.getInteger("HatchingProgress");
	}
}
