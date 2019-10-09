package com.deextinction.world.gen.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.deextinction.DeExtinction;
import com.deextinction.world.StructureUtils;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class DeStructure extends WorldGenerator
{
	private List<ResourceLocation> structureChest;
	private ResourceLocation structureLocation;
	private EnumFacing facing;
	private Rotation rotation;
	private boolean checkGround;
	private boolean removeAir;

	public DeStructure(String name, EnumFacing facing)
	{
		this(name, facing, true, false);
	}

	public DeStructure(String name, EnumFacing facing, boolean checkGround, boolean removeAir)
	{
		super(false);
		this.structureLocation = new ResourceLocation(DeExtinction.MODID, name);
		this.structureChest = null;
		this.checkGround = checkGround;
		this.removeAir = removeAir;
		this.facing = facing;

		switch (facing)
		{
			case SOUTH:
				this.rotation = Rotation.CLOCKWISE_180;
				break;
			case EAST:
				this.rotation = Rotation.CLOCKWISE_90;
				break;
			case WEST:
				this.rotation = Rotation.COUNTERCLOCKWISE_90;
				break;
			default:
				this.rotation = Rotation.NONE;
				break;
		}
	}

	public DeStructure(String name, EnumFacing facing, int numberOfLootTables)
	{
		this(name, facing, numberOfLootTables, true, false);
	}

	public DeStructure(String name, EnumFacing facing, int numberOfLootTables, boolean checkGround, boolean removeAir)
	{
		super(false);
		this.structureLocation = new ResourceLocation(DeExtinction.MODID, name);
		this.checkGround = checkGround;
		this.removeAir = removeAir;
		this.facing = facing;

		this.structureChest = new ArrayList<ResourceLocation>();
		for (int i = 0; i < numberOfLootTables; i++)
			this.structureChest.add(new ResourceLocation(DeExtinction.MODID, name + "_" + i));

		switch (facing)
		{
			case SOUTH:
				this.rotation = Rotation.CLOCKWISE_180;
				break;
			case EAST:
				this.rotation = Rotation.CLOCKWISE_90;
				break;
			case WEST:
				this.rotation = Rotation.COUNTERCLOCKWISE_90;
				break;
			default:
				this.rotation = Rotation.NONE;
				break;
		}
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
	{
		if (worldIn == null)
			return false;

		System.out.println("generate " + this.structureLocation);

		if (this.structureChest != null && !this.structureChest.isEmpty())
		{
			boolean flag = StructureUtils.generateStructure(this.structureLocation, this.structureChest.get(rand.nextInt(this.structureChest.size())), worldIn, position, rand, this.checkGround, this.removeAir);

			System.out.println("flag structureChest " + flag);
			return flag;
		}
		else
		{
			boolean flag = StructureUtils.generateStructure(this.structureLocation, worldIn, position, rand, this.checkGround, this.removeAir);

			System.out.println("flag no chest" + flag);
			return flag;
		}
	}
}
