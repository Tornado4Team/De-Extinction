package com.deextinction.tileentities;

import java.util.HashMap;

import com.deextinction.DeExtinction;
import com.deextinction.block.machines.BlockMicroscope.MicroscopeSample;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.TypeOfLife;
import com.deextinction.init.DeDatabase;
import com.deextinction.item.ItemSyringeBlood;
import com.deextinction.tileentities.containers.ContainerMicroscope;
import com.deextinction.util.SampleTag;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;

public class TileMicroscope extends TileMachine
{
	public static final int SLOT_INDEX_SLIDE = 0;
	public static final int SLOT_INDEX_SAMPLE = 1;

	private MicroscopeSample sample;
	private SampleTag sampleTag;

	public TileMicroscope()
	{
		super(new int[] { TileMicroscope.SLOT_INDEX_SLIDE }, new int[] { TileMicroscope.SLOT_INDEX_SAMPLE }, new int[] {});
		this.sample = MicroscopeSample.NONE;
		this.sampleTag = new SampleTag();
	}

	public SampleTag getSampleTag()
	{
		return this.sampleTag;
	}

	public void removeSample()
	{
		this.sampleTag = new SampleTag();
		this.sample = MicroscopeSample.NONE;
	}

	public boolean setSample()
	{
		ItemStack itemStack = this.getSlot(TileMicroscope.SLOT_INDEX_SAMPLE);
		if (this.isSampleBlood(itemStack) && itemStack.hasTagCompound())
		{
			NBTTagCompound tag = itemStack.getTagCompound();

			if (tag.hasKey(SampleTag.NBT_TAG_SAMPLER))
			{
				String name = tag.getString(SampleTag.NBT_TAG_SAMPLER);

				for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
				{
					if (deExtincted instanceof DeExtinctedAnimal)
					{
						DeExtinctedAnimal animal = (DeExtinctedAnimal) deExtincted;
						if (animal.getEntityName() != null && animal.getEntityName() == name)
						{
							if (animal.getTypeOfLife() == TypeOfLife.ARTHROPODA)
								this.sample = MicroscopeSample.HEMOLYMPH;
							else
								this.sample = MicroscopeSample.BLOOD;

							this.sampleTag.setTag(tag);
							return true;
						}
					}
				}

				for (MicroscopeSample sample : MicroscopeSample.values())
				{
					if (sample.getEntityList().contains(name))
					{
						this.sample = sample;
						this.sampleTag.setTag(tag);
						return true;
					}
				}

				Class clazz = DeExtinction.getEntityClassFromName(name);
				if (clazz == EntitySpider.class)
				{
					this.sample = MicroscopeSample.HEMOLYMPH;
					this.sampleTag.setTag(tag);
					return true;
				}
				else if (clazz == EntityZombie.class)
				{
					this.sample = MicroscopeSample.BLOOD_DECAYED;
					this.sampleTag.setTag(tag);
					return true;
				}
				else if (clazz == EntityCreature.class)
				{
					this.sample = MicroscopeSample.BLOOD;
					this.sampleTag.setTag(tag);
					return true;
				}
			}
		}

		this.sampleTag.removeTag();
		this.sample = MicroscopeSample.NONE;
		return false;
	}

	public MicroscopeSample getSample()
	{
		return this.sample;
	}

	public boolean isSlide(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && Block.getBlockFromItem(itemStack.getItem()) instanceof BlockPane;
	}

	public boolean hasSlide()
	{
		return this.isSlide(this.getSlot(TileMicroscope.SLOT_INDEX_SLIDE));
	}

	public boolean isSampleBlood(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemSyringeBlood;
	}

	public boolean isSample(ItemStack itemStack)
	{
		return !itemStack.isEmpty() && itemStack.getItem() instanceof ItemSyringeBlood;
	}

	public boolean hasSample()
	{
		return this.isSample(this.getSlot(TileMicroscope.SLOT_INDEX_SAMPLE));
	}

	public boolean isAnalyzing()
	{
		return this.sample != MicroscopeSample.NONE;
	}

	public boolean shouldAnalyze()
	{
		return this.hasSlide() && this.hasSample();
	}

	public void analyze()
	{
		if (this.setSample())
		{
			this.shrinkStack(TileMicroscope.SLOT_INDEX_SLIDE, 1);
			this.shrinkStack(TileMicroscope.SLOT_INDEX_SAMPLE, 1);
		}
	}

	@Override
	public void update()
	{

	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerMicroscope(playerInventory, this);
	}

	@Override
	public String getGuiID()
	{
		return DeExtinction.prependModID("microscope");
	}

	@Override
	public void setCustomInventoryName(String name)
	{
		this.tileCustomName = name;
	}

	@Override
	public String getName()
	{
		return this.hasCustomName() ? this.tileCustomName : I18n.translateToLocal("container.microscope.name");
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
			this.markDirty();
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		switch (index)
		{
			case TileMicroscope.SLOT_INDEX_SLIDE:
				return this.isSlide(stack);
			case TileMicroscope.SLOT_INDEX_SAMPLE:
				return this.isSample(stack);
			default:
				return false;
		}
	}

	@Override
	public int getField(int id)
	{
		return 0;
	}

	@Override
	public void setField(int id, int value)
	{

	}

	@Override
	public int getFieldCount()
	{
		return 0;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		if (this.sample != null && this.sample != MicroscopeSample.NONE)
			compound.setInteger("Sample", this.sample.getMetadata());

		if (this.sampleTag != null)
		{
			HashMap<String, String> sampleTags = this.sampleTag.getTags();
			for (String tagName : sampleTags.keySet())
			{
				String tagValue = sampleTags.get(tagName);
				if (tagValue != null && !tagValue.isEmpty())
					compound.setString(tagName, tagValue);
			}
		}
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		if (compound.hasKey("Sample"))
			this.sample = MicroscopeSample.byMetadata(compound.getInteger("Sample"));

		this.sampleTag.setTag(compound);
	}
}
