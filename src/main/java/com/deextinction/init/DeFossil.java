package com.deextinction.init;

import java.util.HashMap;

import com.deextinction.database.DeExtincted;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.DeExtinctedFungus;
import com.deextinction.database.DeExtinctedPlant;
import com.deextinction.database.GeologicEra;
import com.deextinction.world.SimplexNoise;

public class DeFossil
{
	public static final SimplexNoise SIMPLEX_NOISE_1 = new SimplexNoise(111);
	public static final SimplexNoise SIMPLEX_NOISE_2 = new SimplexNoise(222);
	public static final SimplexNoise SIMPLEX_NOISE_3 = new SimplexNoise(333);
	private static final HashMap<GeologicEra, HashMap<String, Float>> LIST_NOISE_INTERVAL_ANIMALS = new HashMap<GeologicEra, HashMap<String, Float>>();
	private static final HashMap<GeologicEra, HashMap<String, Float>> LIST_NOISE_INTERVAL_PLANTS = new HashMap<GeologicEra, HashMap<String, Float>>();
	private static final HashMap<GeologicEra, HashMap<String, Float>> LIST_NOISE_INTERVAL_FUNGI = new HashMap<GeologicEra, HashMap<String, Float>>();
	static
	{
		// Init LIST_NOISE_INTERVAL_ANIMALS
		for (GeologicEra era : GeologicEra.values())
		{
			HashMap<String, Float> noiseMap = new HashMap<String, Float>();
			float total_weight = 0.0F;
			for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
				if (deExtincted instanceof DeExtinctedAnimal && era == deExtincted.getGeologicEra())
					total_weight = total_weight + deExtincted.getSpawnWeight();

			if (total_weight > 0.0F)
			{
				float lastNoise = 0.0F;
				for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
					if (deExtincted instanceof DeExtinctedAnimal && era == deExtincted.getGeologicEra())
					{
						lastNoise = lastNoise + deExtincted.getSpawnWeight() / total_weight;
						noiseMap.put(deExtincted.getName(), lastNoise);
					}

				DeFossil.LIST_NOISE_INTERVAL_ANIMALS.put(era, noiseMap);
			}
		}

		// Init LIST_NOISE_INTERVAL_PLANTS
		for (GeologicEra era : GeologicEra.values())
		{
			HashMap<String, Float> noiseMap = new HashMap<String, Float>();
			float total_weight = 0.0F;
			for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
				if (deExtincted instanceof DeExtinctedPlant && era == deExtincted.getGeologicEra())
					total_weight = total_weight + deExtincted.getSpawnWeight();

			if (total_weight > 0.0F)
			{
				float lastNoise = 0.0F;
				for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
					if (deExtincted instanceof DeExtinctedPlant && era == deExtincted.getGeologicEra())
					{
						lastNoise = lastNoise + deExtincted.getSpawnWeight() / total_weight;
						noiseMap.put(deExtincted.getName(), lastNoise);
					}

				DeFossil.LIST_NOISE_INTERVAL_PLANTS.put(era, noiseMap);
			}
		}

		// Init LIST_NOISE_INTERVAL_FUNGI
		for (GeologicEra era : GeologicEra.values())
		{
			HashMap<String, Float> noiseMap = new HashMap<String, Float>();
			float total_weight = 0.0F;
			for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
				if (deExtincted instanceof DeExtinctedFungus && era == deExtincted.getGeologicEra())
					total_weight = total_weight + deExtincted.getSpawnWeight();

			if (total_weight > 0.0F)
			{
				float lastNoise = 0.0F;
				for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
					if (deExtincted instanceof DeExtinctedFungus && era == deExtincted.getGeologicEra())
					{
						lastNoise = lastNoise + deExtincted.getSpawnWeight() / total_weight;
						noiseMap.put(deExtincted.getName(), lastNoise);
					}

				DeFossil.LIST_NOISE_INTERVAL_FUNGI.put(era, noiseMap);
			}
		}
	}

	/**
	 * Generates noise (0.0F to 1.0F) in 2D using a given frequency.
	 *
	 * @param x
	 *            is the x position;
	 * @param z
	 *            is the z position;
	 * @param frequency
	 *            is the frequency;
	 * 
	 * @return noise as a float
	 */
	public static final float getRandomNormalizedNoise2D_1(float x, float z, float frequency)
	{
		return 0.5F + 0.5F * DeFossil.SIMPLEX_NOISE_1.noise(x / frequency, z / frequency);
	}

	/**
	 * Generates noise (0.0F to 1.0F) in 2D using a given frequency.
	 *
	 * @param x
	 *            is the x position;
	 * @param z
	 *            is the z position;
	 * @param frequency
	 *            is the frequency;
	 * 
	 * @return noise as a float
	 */
	public static final float getRandomNormalizedNoise2D_2(float x, float z, float frequency)
	{
		return 0.5F + 0.5F * DeFossil.SIMPLEX_NOISE_2.noise(x / frequency, z / frequency);
	}

	/**
	 * Generates noise (0.0F to 1.0F) in 2D using a given frequency.
	 *
	 * @param x
	 *            is the x position;
	 * @param z
	 *            is the z position;
	 * @param frequency
	 *            is the frequency;
	 * 
	 * @return noise as a float
	 */
	public static final float getRandomNormalizedNoise2D_3(float x, float z, float frequency)
	{
		return 0.5F + 0.5F * DeFossil.SIMPLEX_NOISE_3.noise(x / frequency, z / frequency);
	}

	/**
	 * Generates noise in 2D using a frequency of 40.
	 *
	 * @param x
	 *            is the x position;
	 * @param z
	 *            is the z position;
	 * 
	 * @return noise as a float
	 */
	public static final float getNoise2DForFossils(float x, float z)
	{
		return DeFossil.getRandomNormalizedNoise2D_1(x, z, 40.0F);
	}

	/**
	 * Returns the GeologicEra from a world position.
	 *
	 * @param x
	 *            is the x position;
	 * @param y
	 *            is the y position;
	 * @param z
	 *            is the z position;
	 * 
	 * @return noise as a float
	 */
	public static final GeologicEra getGeologicEraFromNoise(float x, float y, float z)
	{
		int upperLimit = 35 + (int) (30.0F * DeFossil.getRandomNormalizedNoise2D_2(x, z, 600.0F));
		if (y > upperLimit)
			return GeologicEra.CENOZOIC;

		int lowerLimit = 5 + (int) (30.0F * DeFossil.getRandomNormalizedNoise2D_3(x, z, 600.0F));
		if (y > lowerLimit)
			return GeologicEra.MESOZOIC;
		else
			return GeologicEra.PALEOZOIC;
	}

	public static final DeExtincted getAnimalFromNoise(GeologicEra era, float x, float y, float z)
	{
		return DeFossil.getDeExtinctedFromNoise(era, x, y, z, DeFossil.LIST_NOISE_INTERVAL_ANIMALS);
	}

	public static final DeExtincted getPlantFromNoise(GeologicEra era, float x, float y, float z)
	{
		return DeFossil.getDeExtinctedFromNoise(era, x, y, z, DeFossil.LIST_NOISE_INTERVAL_PLANTS);
	}

	public static final DeExtincted getFungusFromNoise(GeologicEra era, float x, float y, float z)
	{
		return DeFossil.getDeExtinctedFromNoise(era, x, y, z, DeFossil.LIST_NOISE_INTERVAL_FUNGI);
	}

	public static final DeExtincted getAnimalFromNoise(float x, float y, float z)
	{
		return DeFossil.getDeExtinctedFromNoise(x, y, z, DeFossil.LIST_NOISE_INTERVAL_ANIMALS);
	}

	public static final DeExtincted getPlantFromNoise(float x, float y, float z)
	{
		return DeFossil.getDeExtinctedFromNoise(x, y, z, DeFossil.LIST_NOISE_INTERVAL_PLANTS);
	}

	public static final DeExtincted getFungusFromNoise(float x, float y, float z)
	{
		return DeFossil.getDeExtinctedFromNoise(x, y, z, DeFossil.LIST_NOISE_INTERVAL_FUNGI);
	}

	private static final DeExtincted getDeExtinctedFromNoise(GeologicEra era, float x, float y, float z, HashMap<GeologicEra, HashMap<String, Float>> list)
	{
		if (era != null)
		{
			HashMap<String, Float> deExtinctedFromEra = list.get(era);
			if (deExtinctedFromEra != null && !deExtinctedFromEra.isEmpty())
			{
				float noise = DeFossil.getNoise2DForFossils(x, z);
				for (String name : deExtinctedFromEra.keySet())
					if (noise < deExtinctedFromEra.get(name))
						return DeDatabase.LIST_DE_EXTINCTED.get(name);
			}
		}
		return null;
	}

	private static final DeExtincted getDeExtinctedFromNoise(float x, float y, float z, HashMap<GeologicEra, HashMap<String, Float>> list)
	{
		return DeFossil.getDeExtinctedFromNoise(DeFossil.getGeologicEraFromNoise(x, y, z), x, y, z, list);
	}
}
