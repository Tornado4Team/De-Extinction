package com.deextinction.util;

import java.util.Random;

public enum Nucleobases
{
	ADENINE("adenine", 'A', 0),
	CYTOSINE("cytosine", 'C', 1),
	GUANINE("guanine", 'G', 2),
	THYMINE("thymine", 'T', 3),
	URACIL("uracil", 'U', 3),
	BLANK("blank", '_', 0);

	private Nucleobases(String nucleobaseName, char nucleobaseLetter, int nucleobaseValue)
	{
		this.nucleobaseName = nucleobaseName;
		this.nucleobaseLetter = nucleobaseLetter;
		this.nucleobaseValue = nucleobaseValue;
	}

	/**
	 * Returns the nucleobase letter.
	 * 
	 * @return nucleobaseLetter
	 */
	public char getNucleobaseLetter()
	{
		return this.nucleobaseLetter;
	}

	/**
	 * Returns the nucleobase value.
	 * 
	 * @return nucleobaseValue
	 */
	public int getNucleobaseValue()
	{
		return this.nucleobaseValue;
	}

	/**
	 * Returns the nucleobase name.
	 * 
	 * @return
	 */
	public String getNucleobaseName()
	{
		return this.nucleobaseName;
	}

	/**
	 * Returns the nucleobase name for translation.
	 * 
	 * @return "nucleobase." + this.nucleobaseName + ".name"
	 */
	public String getNucleobaseUnlocalizedName()
	{
		return "nucleobase." + this.nucleobaseName + ".name";
	}

	/**
	 * Returns true if this nucleobase is equal to another one.
	 * 
	 * @param nucleobase
	 * @return this.nucleobaseLetter == nucleobase.getNucleobaseLetter()
	 */
	public boolean isEqual(Nucleobases nucleobase)
	{
		return this.nucleobaseLetter == nucleobase.getNucleobaseLetter();
	}

	/**
	 * Returns the nucleobase from a nucleobase letter.
	 * 
	 * @param c
	 * @return
	 */
	public static Nucleobases getNucleobase(char letter)
	{
		switch (letter)
		{
			case 'A':
				return Nucleobases.ADENINE;
			case 'C':
				return Nucleobases.CYTOSINE;
			case 'G':
				return Nucleobases.GUANINE;
			case 'T':
				return Nucleobases.THYMINE;
			case 'U':
				return Nucleobases.URACIL;
			default:
				return Nucleobases.BLANK;
		}
	}

	/**
	 * Returns the nucleobase from a nucleobase value.
	 * 
	 * @param c
	 * @return
	 */
	public static Nucleobases getNucleobase(int nucleobaseValue)
	{
		switch (nucleobaseValue)
		{
			case 0:
				return Nucleobases.ADENINE;
			case 1:
				return Nucleobases.CYTOSINE;
			case 2:
				return Nucleobases.GUANINE;
			case 3:
				return Nucleobases.THYMINE;
			default:
				return Nucleobases.BLANK;
		}
	}

	/**
	 * Returns the nucleobase letter from a nucleobase value.
	 * 
	 * @param nucleobase
	 * @return
	 */
	public static char getNucleobaseLetter(int nucleobaseValue)
	{
		switch (nucleobaseValue)
		{
			case 0:
				return 'A';
			case 1:
				return 'C';
			case 2:
				return 'G';
			case 3:
				return 'T';
			default:
				return '_';
		}
	}

	/**
	 * Returns the nucleobase value from a nucleobase latter.
	 * 
	 * @param nucleobase
	 * @return
	 */
	public static int getNucleobaseValue(char letter)
	{
		switch (letter)
		{
			case 'A':
				return 0;
			case 'C':
				return 1;
			case 'G':
				return 2;
			case 'T':
			case 'U':
				return 3;
			default:
				return '_';
		}
	}

	/**
	 * Returns the opposite nucleobase.
	 * 
	 * @param c
	 * @return
	 */
	public static Nucleobases getOpposite(Nucleobases nucleobase)
	{
		switch (nucleobase)
		{
			case ADENINE:
				return Nucleobases.THYMINE;
			case CYTOSINE:
				return Nucleobases.GUANINE;
			case GUANINE:
				return Nucleobases.CYTOSINE;
			case THYMINE:
				return Nucleobases.ADENINE;
			case URACIL:
				return Nucleobases.ADENINE;
			case BLANK:
				return Nucleobases.BLANK;
			default:
				return Nucleobases.BLANK;
		}
	}

	public static Nucleobases getRandomACGT(Random rand)
	{
		return Nucleobases.getNucleobase(rand.nextInt(4));
	}

	public static Nucleobases getRandomAT(Random rand)
	{
		if (rand.nextBoolean())
			return Nucleobases.ADENINE;
		else
			return Nucleobases.THYMINE;
	}

	public static Nucleobases getRandomCG(Random rand)
	{
		if (rand.nextBoolean())
			return Nucleobases.CYTOSINE;
		else
			return Nucleobases.GUANINE;
	}

	private final String nucleobaseName;
	private final char nucleobaseLetter;
	private final int nucleobaseValue;
}
