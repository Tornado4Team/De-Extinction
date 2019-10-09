package com.deextinction.villager;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.DeExtinction;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeItems;
import com.deextinction.init.DeVillagerRegistry;

import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraftforge.fml.common.registry.VillagerRegistry;

public class DeVillagerCareerEngineering extends VillagerRegistry.VillagerCareer
{
	public static final String CAREER_NAME = "engineering";

	public DeVillagerCareerEngineering()
	{
		super(DeVillagerRegistry.RESEARCHER_PROFESSION, DeExtinction.prependModID(DeVillagerCareerEngineering.CAREER_NAME));

		EntityVillager.ITradeList tradeListLevel1 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 2 + random.nextInt(4)), new ItemStack(DeItems.dna_floppy_disk_empty, 1 + random.nextInt(3))));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 2 + random.nextInt(4)), new ItemStack(DeItems.rockpick)));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 2 + random.nextInt(4)), new ItemStack(DeItems.brush)));

			int count = 1;
			if (random.nextInt(3) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		EntityVillager.ITradeList tradeListLevel2 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 1 + random.nextInt(2)), new ItemStack(DeBlocks.microscope), 0, 3));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 1 + random.nextInt(2)), new ItemStack(DeBlocks.cleaning_table_block), 0, 3));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 1 + random.nextInt(2)), new ItemStack(DeBlocks.dna_extractor), 0, 3));

			int count = 1;
			if (random.nextInt(5) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		EntityVillager.ITradeList tradeListLevel3 = (EntityVillager.ITradeList) (merchant, recipeList, random) -> {
			List<MerchantRecipe> possible = new ArrayList<>();
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 1 + random.nextInt(2)), new ItemStack(DeBlocks.dna_decoder), 0, 3));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 1 + random.nextInt(2)), new ItemStack(DeBlocks.dna_editor), 0, 3));
			possible.add(new MerchantRecipe(new ItemStack(Items.EMERALD, 8 + random.nextInt(5)), new ItemStack(Items.DIAMOND, 1 + random.nextInt(2)), new ItemStack(DeBlocks.de_extinction_machine), 0, 3));

			int count = 1;
			if (random.nextInt(5) == 0)
				count++;

			for (int i = 0; i < count; i++)
				recipeList.add(possible.get(random.nextInt(possible.size())));
		};

		this.addTrade(1, tradeListLevel1);
		this.addTrade(1, tradeListLevel1);
		this.addTrade(2, tradeListLevel2);
		this.addTrade(3, tradeListLevel2);
		this.addTrade(4, tradeListLevel3);
		this.addTrade(5, tradeListLevel3);
	}
}
