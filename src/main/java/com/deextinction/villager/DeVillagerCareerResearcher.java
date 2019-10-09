package com.deextinction.villager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeDatabase;
import com.deextinction.init.DeVillagerRegistry;
import com.deextinction.item.ItemFloppyDisk;
import com.deextinction.util.DNA;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.village.MerchantRecipe;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class DeVillagerCareerResearcher extends VillagerRegistry.VillagerCareer
{
	public static final String CAREER_NAME = "researcher";

	public DeVillagerCareerResearcher()
	{
		super(DeVillagerRegistry.RESEARCHER_PROFESSION, DeExtinction.prependModID(DeVillagerCareerResearcher.CAREER_NAME));

		EntityVillager.ITradeList tradeListLevel1 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();

			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 6 + random.nextInt(5)), this.getRandomFossilDirty(random, 1)));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 6 + random.nextInt(5)), this.getRandomFossilDirty(random, 1)));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 6 + random.nextInt(5)), this.getRandomFossilDirty(random, 1)));

			int count = 1;
			if (random.nextInt(3) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		EntityVillager.ITradeList tradeListLevel2 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), this.getRandomFossilClean(random, 1)));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), this.getRandomFossilClean(random, 1)));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), this.getRandomFossilClean(random, 1)));

			int count = 1;
			if (random.nextInt(5) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		EntityVillager.ITradeList tradeListLevel3 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 10 + random.nextInt(6)), new ItemStack(Items.DIAMOND, 4 + random.nextInt(2)), this.getRandomDataDiskDefault(random, 1), 0, 1));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 10 + random.nextInt(6)), new ItemStack(Items.DIAMOND, 4 + random.nextInt(2)), this.getRandomDataDiskDefault(random, 1), 0, 1));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 10 + random.nextInt(6)), new ItemStack(Items.DIAMOND, 4 + random.nextInt(2)), this.getRandomDataDiskDefault(random, 1), 0, 1));

			int count = 1;
			if (random.nextInt(5) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		EntityVillager.ITradeList tradeListLevel4 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 12 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 5 + random.nextInt(2)), this.getRandomDataDiskRandom(random, 1), 0, 1));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 12 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 5 + random.nextInt(2)), this.getRandomDataDiskRandom(random, 1), 0, 1));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 12 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 5 + random.nextInt(2)), this.getRandomDataDiskRandom(random, 1), 0, 1));

			int count = 1;
			if (random.nextInt(5) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		this.addTrade(1, tradeListLevel1);
		this.addTrade(2, tradeListLevel2);
		this.addTrade(3, tradeListLevel2);
		this.addTrade(4, tradeListLevel3);
		this.addTrade(5, tradeListLevel4);
	}

	private ItemStack getRandomFossilDirty(Random random, int count)
	{
		ItemStack stack = DeDatabase.getRandomDeExtincted(random).getFossilItemDirty();
		stack.setCount(count);
		return stack;
	}

	private ItemStack getRandomFossilClean(Random random, int count)
	{
		ItemStack stack = DeDatabase.getRandomDeExtincted(random).getFossilItemClean();
		stack.setCount(count);
		return stack;
	}

	private ItemStack getRandomDnaBottle(Random random, int count)
	{
		ItemStack stack = DeDatabase.getRandomDeExtincted(random).getDNABottle();
		stack.setCount(count);
		return stack;
	}

	private ItemStack getRandomDataDiskDefault(Random random, int count)
	{
		ItemStack stack = DeDatabase.getRandomDeExtincted(random).getFloppyDisk();
		stack.setCount(count);

		NBTTagCompound compound_disk = new NBTTagCompound();
		compound_disk.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.DEFAULT_DNA_STRING);
		compound_disk.setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70);
		stack.setTagCompound(compound_disk);

		return stack;
	}

	private ItemStack getRandomDataDiskRandom(Random random, int count)
	{
		ItemStack stack = DeDatabase.getRandomDeExtincted(random).getFloppyDisk();
		stack.setCount(count);

		NBTTagCompound compound_disk = new NBTTagCompound();
		compound_disk.setString(ItemFloppyDisk.NBT_TAG_DNA_STRING, DNA.getRandomDNAString(random));
		compound_disk.setInteger(ItemFloppyDisk.NBT_TAG_VIABILITY, 70 + 10 * random.nextInt(4));
		stack.setTagCompound(compound_disk);

		return stack;
	}
}
