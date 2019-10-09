package com.deextinction.world.gen.trees;

import java.util.Random;

import com.deextinction.database.plants.Sequoiadendron;
import com.deextinction.init.DeBlocks;

import net.minecraft.block.BlockLog;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;

public class WorldGenSequoiadendronGrayHuge extends WorldGenDeExtinctedTree
{
	public WorldGenSequoiadendronGrayHuge()
	{
		super(true, DeBlocks.logs.get(Sequoiadendron.NAME).getDefaultState(), DeBlocks.leaves.get(Sequoiadendron.NAME).getDefaultState(), DeBlocks.saplings.get(Sequoiadendron.NAME).getDefaultState());
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		if (TerrainGen.saplingGrowTree(worldIn, rand, pos))
		{
			int height = 30 + rand.nextInt(21);
			int brachesHeight = (int) (0.4F * height);
			if (this.checkPillarPositiveY(worldIn, pos, 1, brachesHeight) && this.checkPillarPositiveY(worldIn, pos.add(0, brachesHeight, 0), 8, height - brachesHeight))
			{
				int largeTrunkHeight = (int) (0.5F * height);
				this.buildPillarPositiveY(worldIn, pos, 0, largeTrunkHeight, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(-1, 0, 0), 0, largeTrunkHeight, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(0, 0, -1), 0, largeTrunkHeight, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(1, 0, 0), 0, largeTrunkHeight, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(0, 0, 1), 0, largeTrunkHeight, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				int randomHeight = (int) (0.2 * height);
				this.buildPillarPositiveY(worldIn, pos.add(1, 0, 1), 0, largeTrunkHeight - rand.nextInt(randomHeight), this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(1, 0, -1), 0, largeTrunkHeight - rand.nextInt(randomHeight), this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(-1, 0, 1), 0, largeTrunkHeight - rand.nextInt(randomHeight), this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(-1, 0, -1), 0, largeTrunkHeight - rand.nextInt(randomHeight), this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildCircleXZ(worldIn, pos.add(0, height - 2, 0), 3, this.leavesState);
				this.buildCircleXZ(worldIn, pos.add(0, height - 1, 0), 2, this.leavesState);
				this.buildCircleXZ(worldIn, pos.add(0, height, 0), 1, this.leavesState);
				this.buildPillarPositiveY(worldIn, pos.add(0, largeTrunkHeight, 0), 0, (height - largeTrunkHeight), this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(-1, largeTrunkHeight, 0), 0, (height - largeTrunkHeight) - 1, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(0, largeTrunkHeight, -1), 0, (height - largeTrunkHeight) - 1, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(1, largeTrunkHeight, 0), 0, (height - largeTrunkHeight) - 1, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildPillarPositiveY(worldIn, pos.add(0, largeTrunkHeight, 1), 0, (height - largeTrunkHeight) - 1, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));

				if (height > 42)
				{
					this.buildSequoiaBranches(worldIn, rand, pos, 4, 3, 2, brachesHeight);
					this.buildSequoiaBranches(worldIn, rand, pos, 4, 2, 2, (int) (0.5F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 1, 2, (int) (0.6F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 1, 2, (int) (0.7F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 1, 2, (int) (0.8F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 2, 1, 2, (int) (0.9F * height));
				}
				else if (height > 36)
				{
					this.buildSequoiaBranches(worldIn, rand, pos, 4, 3, 2, brachesHeight);
					this.buildSequoiaBranches(worldIn, rand, pos, 4, 2, 2, (int) (0.52F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 1, 2, (int) (0.64F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 1, 2, (int) (0.76F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 1, 2, (int) (0.88F * height));
				}
				else
				{
					this.buildSequoiaBranches(worldIn, rand, pos, 4, 1, 2, brachesHeight);
					this.buildSequoiaBranches(worldIn, rand, pos, 3, 2, 2, (int) (0.55F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 2, 1, 2, (int) (0.7F * height));
					this.buildSequoiaBranches(worldIn, rand, pos, 2, 1, 2, (int) (0.85F * height));
				}
				return true;
			}
		}
		return false;
	}

	private void buildSequoiaBranches(World worldIn, Random rand, BlockPos pos, int lenght, int extraLenght, int withOffset, int atHeight)
	{
		int leaveHeightBottom = atHeight - 1;
		int leaveHeightTop = atHeight + 1;
		int leaveOffset = withOffset + 1;
		extraLenght += 1;

		int branchLength = 0;
		int leaveLength = 0;
		if (rand.nextFloat() < 0.95F)
		{
			branchLength = lenght + rand.nextInt(extraLenght);
			leaveLength = branchLength - 1;
			this.buildPillarPositiveX(worldIn, pos.add(withOffset, atHeight, 0), 0, branchLength, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.X));
			this.buildPillarPositiveX(worldIn, pos.add(leaveOffset, leaveHeightBottom, 0), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveX(worldIn, pos.add(leaveOffset, atHeight, -1), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveX(worldIn, pos.add(leaveOffset, atHeight, 1), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveX(worldIn, pos.add(leaveOffset, leaveHeightTop, 0), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveXMissingSpots(worldIn, rand, 0.7F, pos.add(leaveOffset, leaveHeightBottom, -1), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveXMissingSpots(worldIn, rand, 0.7F, pos.add(leaveOffset, leaveHeightBottom, 1), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveXMissingSpots(worldIn, rand, 0.7F, pos.add(leaveOffset, leaveHeightTop, -1), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveXMissingSpots(worldIn, rand, 0.7F, pos.add(leaveOffset, leaveHeightTop, 1), 0, leaveLength, this.leavesState);
			this.buildSingleBlock(worldIn, pos.add(withOffset + branchLength, atHeight, 0), this.leavesState);
		}

		if (rand.nextFloat() < 0.95F)
		{
			branchLength = lenght + rand.nextInt(extraLenght);
			leaveLength = branchLength - 1;
			this.buildPillarNegativeX(worldIn, pos.add(-withOffset, atHeight, 0), 0, branchLength, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.X));
			this.buildPillarNegativeX(worldIn, pos.add(-leaveOffset, leaveHeightBottom, 0), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeX(worldIn, pos.add(-leaveOffset, atHeight, -1), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeX(worldIn, pos.add(-leaveOffset, atHeight, 1), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeX(worldIn, pos.add(-leaveOffset, leaveHeightTop, 0), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeXMissingSpots(worldIn, rand, 0.7F, pos.add(-leaveOffset, leaveHeightBottom, -1), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeXMissingSpots(worldIn, rand, 0.7F, pos.add(-leaveOffset, leaveHeightBottom, 1), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeXMissingSpots(worldIn, rand, 0.7F, pos.add(-leaveOffset, leaveHeightTop, -1), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeXMissingSpots(worldIn, rand, 0.7F, pos.add(-leaveOffset, leaveHeightTop, 1), 0, leaveLength, this.leavesState);
			this.buildSingleBlock(worldIn, pos.add(-withOffset - branchLength, atHeight, 0), this.leavesState);
		}

		if (rand.nextFloat() < 0.95F)
		{
			branchLength = lenght + rand.nextInt(extraLenght);
			leaveLength = branchLength - 1;
			this.buildPillarPositiveZ(worldIn, pos.add(0, atHeight, withOffset), 0, branchLength, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Z));
			this.buildPillarPositiveZ(worldIn, pos.add(0, leaveHeightBottom, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZ(worldIn, pos.add(-1, atHeight, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZ(worldIn, pos.add(1, atHeight, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZ(worldIn, pos.add(0, leaveHeightTop, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZMissingSpots(worldIn, rand, 0.7F, pos.add(-1, leaveHeightBottom, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZMissingSpots(worldIn, rand, 0.7F, pos.add(1, leaveHeightBottom, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZMissingSpots(worldIn, rand, 0.7F, pos.add(-1, leaveHeightTop, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarPositiveZMissingSpots(worldIn, rand, 0.7F, pos.add(1, leaveHeightTop, leaveOffset), 0, leaveLength, this.leavesState);
			this.buildSingleBlock(worldIn, pos.add(0, atHeight, withOffset + branchLength), this.leavesState);
		}

		if (rand.nextFloat() < 0.95F)
		{
			branchLength = lenght + rand.nextInt(extraLenght);
			leaveLength = branchLength - 1;
			this.buildPillarNegativeZ(worldIn, pos.add(0, atHeight, -withOffset), 0, branchLength, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Z));
			this.buildPillarNegativeZ(worldIn, pos.add(0, leaveHeightBottom, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZ(worldIn, pos.add(-1, atHeight, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZ(worldIn, pos.add(1, atHeight, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZ(worldIn, pos.add(0, leaveHeightTop, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZMissingSpots(worldIn, rand, 0.7F, pos.add(-1, leaveHeightBottom, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZMissingSpots(worldIn, rand, 0.7F, pos.add(1, leaveHeightBottom, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZMissingSpots(worldIn, rand, 0.7F, pos.add(-1, leaveHeightTop, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildPillarNegativeZMissingSpots(worldIn, rand, 0.7F, pos.add(1, leaveHeightTop, -leaveOffset), 0, leaveLength, this.leavesState);
			this.buildSingleBlock(worldIn, pos.add(0, atHeight, -withOffset - branchLength), this.leavesState);
		}
	}
}
