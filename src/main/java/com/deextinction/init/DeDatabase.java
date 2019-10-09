package com.deextinction.init;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.GeologicEra;
import com.deextinction.database.animals.Archaeorhynchus;
import com.deextinction.database.animals.Arctotherium;
import com.deextinction.database.animals.Basilosaurus;
import com.deextinction.database.animals.CanisNehringi;
import com.deextinction.database.animals.Glyptodon;
import com.deextinction.database.animals.Kelenken;
import com.deextinction.database.animals.Livyatan;
import com.deextinction.database.animals.Macrauchenia;
import com.deextinction.database.animals.Sebecus;
import com.deextinction.database.animals.Smilodon;
import com.deextinction.database.animals.Theriodictis;
import com.deextinction.database.animals.Toxodon;
import com.deextinction.database.animals.Troodon;
import com.deextinction.database.plants.Banksia;
import com.deextinction.database.plants.Sequoiadendron;
import com.deextinction.util.MinecraftTime;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class DeDatabase
{
	public static final HashMap<String, DeExtincted> LIST_DE_EXTINCTED = new HashMap<String, DeExtincted>();
	public static final HashMap<String, Integer> FOOD_LIST = new HashMap<String, Integer>();

	public static void preInitDatabase()
	{
		DeDatabase.registerAnimals();
		DeDatabase.registerPlants();
		DeDatabase.registerFood();
	}

	public static void initDatabase()
	{
		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
			if (deExtincted instanceof DeExtinctedAnimal)
				((DeExtinctedAnimal) deExtincted).initAnimal();
	}

	public static String getRandomDeExtinctedName(Random rand)
	{
		int size = DeDatabase.LIST_DE_EXTINCTED.size();
		int randIndex = rand.nextInt(size);
		int index = 0;
		for (String name : DeDatabase.LIST_DE_EXTINCTED.keySet())
		{
			if (index == randIndex)
				return name;
			index++;
		}

		return null;
	}

	public static DeExtincted getRandomDeExtincted(Random rand)
	{
		int size = DeDatabase.LIST_DE_EXTINCTED.size();
		int randIndex = rand.nextInt(size);
		int index = 0;
		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
		{
			if (index == randIndex)
				return deExtincted;
			index++;
		}

		return null;
	}

	public static DeExtincted getRandomDeExtincted(Random rand, GeologicEra geologicEra)
	{
		List<DeExtincted> list = new ArrayList<DeExtincted>();
		for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
			if (deExtincted.getGeologicEra() == geologicEra)
				list.add(deExtincted);

		if (!list.isEmpty())
			return list.get(rand.nextInt(list.size()));
		else
			return null;
	}

	public static DeExtincted getRandomDeExtincted(Random rand, GeologicEra geologicEra, String excludeDeExtinctedName)
	{
		if (DeDatabase.LIST_DE_EXTINCTED.containsKey(excludeDeExtinctedName))
		{
			DeExtincted excludeDeExtincted = DeDatabase.LIST_DE_EXTINCTED.get(excludeDeExtinctedName);
			if (excludeDeExtincted != null)
			{
				List<DeExtincted> list = new ArrayList<DeExtincted>();
				for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
					if (deExtincted.getGeologicEra() == geologicEra)
						list.add(deExtincted);

				if (list.contains(excludeDeExtincted))
					list.remove(excludeDeExtincted);

				if (!list.isEmpty())
					return list.get(rand.nextInt(list.size()));
			}
			return null;
		}
		else
			return DeDatabase.getRandomDeExtincted(rand, geologicEra);
	}

	private static void registerAnimals()
	{
		DeDatabase.registerDeExtincted(new Archaeorhynchus());
		DeDatabase.registerDeExtincted(new Troodon());
		DeDatabase.registerDeExtincted(new Smilodon());
		DeDatabase.registerDeExtincted(new Macrauchenia());
		DeDatabase.registerDeExtincted(new Kelenken());
		DeDatabase.registerDeExtincted(new Arctotherium());
		DeDatabase.registerDeExtincted(new Basilosaurus());
		DeDatabase.registerDeExtincted(new CanisNehringi());
		DeDatabase.registerDeExtincted(new Glyptodon());
		DeDatabase.registerDeExtincted(new Livyatan());
		DeDatabase.registerDeExtincted(new Sebecus());
		DeDatabase.registerDeExtincted(new Theriodictis());
		DeDatabase.registerDeExtincted(new Toxodon());
	}

	private static void registerPlants()
	{
		DeDatabase.registerDeExtincted(new Banksia());
		DeDatabase.registerDeExtincted(new Sequoiadendron());
	}

	private static void registerFood()
	{
		DeDatabase.registerFood(Items.APPLE, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.BAKED_POTATO, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.BREAD, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.CAKE, (int) (1.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.CARROT, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.COOKED_CHICKEN, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.COOKED_FISH, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.COOKED_MUTTON, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.COOKED_PORKCHOP, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.COOKED_BEEF, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.COOKED_RABBIT, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.COOKIE, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.MELON, (int) (0.125F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.MUSHROOM_STEW, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Items.POTATO, (int) (0.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.PUMPKIN_PIE, (int) (1.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.RABBIT_STEW, (int) (1.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.BEEF, (int) (0.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.CHICKEN, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.FISH, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.MUTTON, (int) (0.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.PORKCHOP, (int) (0.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.RABBIT, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.ROTTEN_FLESH, (int) (0.01F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.BONE, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.SUGAR, (int) (0.05F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.WHEAT_SEEDS, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.WHEAT, (int) (0.5F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.MELON_SEEDS, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.PUMPKIN_SEEDS, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Items.EGG, (int) (0.25F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Blocks.PUMPKIN, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Blocks.MELON_BLOCK, MinecraftTime.MC_DAY_LENGHT);
		DeDatabase.registerFood(Blocks.YELLOW_FLOWER, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Blocks.RED_FLOWER, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Blocks.BROWN_MUSHROOM, (int) (0.15F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Blocks.RED_MUSHROOM, (int) (0.15F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Blocks.SAPLING, (int) (0.1F * MinecraftTime.MC_DAY_LENGHT));
		DeDatabase.registerFood(Blocks.LEAVES, (int) (0.05F * MinecraftTime.MC_DAY_LENGHT));
	}

	private static void registerFood(Block block, int hunger)
	{
		DeDatabase.FOOD_LIST.put(block.getUnlocalizedName(), hunger);
	}

	private static void registerFood(Item item, int hunger)
	{
		DeDatabase.FOOD_LIST.put(item.getUnlocalizedName(), hunger);
	}

	private static void registerDeExtincted(DeExtincted deExtincted)
	{
		if (deExtincted != null)
		{
			String deExtinctedName = deExtincted.getName();
			if (!DeDatabase.LIST_DE_EXTINCTED.containsValue(deExtincted))
				DeDatabase.LIST_DE_EXTINCTED.put(deExtinctedName, deExtincted);
			else
				DeExtinction.logger.error("De-Extincted " + deExtinctedName + " is already registered in the DeDatabase.LIST_DE_EXTINCTED. THIS IS A BUG!");
		}
		else
			DeExtinction.logger.error("De-Extincted is null. THIS IS A BUG!");
	}
}
