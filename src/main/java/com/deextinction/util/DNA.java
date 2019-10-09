package com.deextinction.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DNA
{
	public static final String DEFAULT_DNA_STRING = "AAA";
	public static final int NUCLEOBASES_NUMBER = 3;
	public static final int DNA_INDEX_1 = 0;
	public static final int DNA_INDEX_2 = 1;
	public static final int DNA_INDEX_3 = 2;

	private String dna = "___";

	public DNA(String dna)
	{
		this.dna = dna;
	}

	public DNA()
	{
		this.dna = DNA.DEFAULT_DNA_STRING;
	}

	public String getDNA()
	{
		return this.dna;
	}

	public char[] getDNACharArray()
	{
		return this.dna.toCharArray();
	}

	public void setDNA(String dna)
	{
		this.dna = dna;
	}

	public Nucleobases getNucleobase(int index)
	{
		return Nucleobases.getNucleobase(this.dna.charAt(index));
	}

	public void setNucleobase(int index, Nucleobases nucleobase)
	{
		char[] dnaCharArray = this.dna.toCharArray();
		dnaCharArray[index] = nucleobase.getNucleobaseLetter();
		this.dna = String.copyValueOf(dnaCharArray);
	}

	public void setNucleobase(int index, char latter)
	{
		char[] dnaCharArray = this.dna.toCharArray();
		dnaCharArray[index] = latter;
		this.dna = String.copyValueOf(dnaCharArray);
	}

	public void setNucleobase(int index, int nucleobaseValue)
	{
		char[] dnaCharArray = this.dna.toCharArray();
		dnaCharArray[index] = Nucleobases.getNucleobaseLetter(nucleobaseValue);
		this.dna = String.copyValueOf(dnaCharArray);
	}

	public int length()
	{
		return this.dna.length();
	}

	public String toString()
	{
		return "DNA[" + this.dna + "]";
	}

	public boolean equal(DNA dna)
	{
		return this.dna.equals(dna.getDNA());
	}

	public boolean equal(String dnaString)
	{
		return this.dna.equals(dnaString);
	}

	public static String getRandomDNAString(Random rand)
	{
		String randomDNA = "";
		for (int index = 0; index < DNA.DEFAULT_DNA_STRING.length(); index++)
			randomDNA = randomDNA + Nucleobases.getNucleobase(rand.nextInt(4)).getNucleobaseLetter();
		return randomDNA;
	}

	public static DNA getRandomDNA(Random rand)
	{
		return new DNA(DNA.getRandomDNAString(rand));
	}

	public static int getDNAValue(DNA dna)
	{
		return DNA.getDNAValue(dna.getDNA());
	}

	public static int getDNAValue(String dnaString)
	{
		char[] dnaCharString = dnaString.toCharArray();
		int value = 0;
		for (int index = 0; index < dnaCharString.length; index++)
			value = value + Nucleobases.getNucleobaseValue(dnaCharString[index]);

		return value;
	}

	public static int getDNAValue(DNA dna, int... indexes)
	{
		return DNA.getDNAValue(dna.getDNA(), indexes);
	}

	public static int getDNAValue(String dnaString, int... indexes)
	{
		char[] dnaCharString = dnaString.toCharArray();
		int value = 0;
		for (int index : indexes)
			value = value + Nucleobases.getNucleobaseValue(dnaCharString[index]);

		return value;
	}

	public List<Integer> getDifferentIndexes(DNA dna)
	{
		List<Integer> list = new ArrayList<Integer>();
		if (dna != null && this.length() == dna.length())
		{
			String otherDNAString = dna.getDNA();
			for (int index = 0; index < this.length(); index++)
				if (this.dna.charAt(index) != otherDNAString.charAt(index))
					list.add(index);
		}

		return list;
	}
}
