package com.deextinction.database.plants;

import com.deextinction.block.plants.BlockBanksia;
import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.TypeOfLife;
import com.deextinction.init.DeBlocks;
import com.deextinction.util.DNA;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Banksia extends DeExtinctedPlant
{
	public static final String NAME = "banksia";

	public Banksia()
	{
		super(Banksia.NAME);
	}

	@Override
	public ItemStack getPrecursorItem()
	{
		return new ItemStack(Items.WHEAT_SEEDS);
	}

	@Override
	public ItemStack getResultItem(String dna)
	{
		int value = DNA.getDNAValue(dna);
		switch (value)
		{
			case 0:
			case 1:
			case 2:
			case 3:
				return new ItemStack(DeBlocks.banksia, 1, BlockBanksia.EnumTypes.YELLOW.getMetadata());
			case 4:
			case 5:
			case 6:
				return new ItemStack(DeBlocks.banksia, 1, BlockBanksia.EnumTypes.ORANGE.getMetadata());
			case 7:
			case 8:
			case 9:
				return new ItemStack(DeBlocks.banksia, 1, BlockBanksia.EnumTypes.RED.getMetadata());
			default:
				return new ItemStack(DeBlocks.banksia, 1, BlockBanksia.EnumTypes.YELLOW.getMetadata());
		}
	}

	@Override
	public GeologicEra getGeologicEra()
	{
		return GeologicEra.CENOZOIC;
	}

	@Override
	public TypeOfLife getTypeOfLife()
	{
		return TypeOfLife.PTERIDOPHYTA;
	}
}
