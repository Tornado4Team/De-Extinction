package com.deextinction.world.gen.trees;

import java.util.Random;

import com.deextinction.database.plants.Sequoiadendron;
import com.deextinction.init.DeBlocks;

import net.minecraft.block.BlockLog;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.terraingen.TerrainGen;

public class WorldGenSequoiadendronGraySmall extends WorldGenDeExtinctedTree
{
	public WorldGenSequoiadendronGraySmall()
	{
		super(true, DeBlocks.logs.get(Sequoiadendron.NAME).getDefaultState(), DeBlocks.leaves.get(Sequoiadendron.NAME).getDefaultState(), DeBlocks.saplings.get(Sequoiadendron.NAME).getDefaultState());
	}

	@Override
	public boolean generate(World worldIn, Random rand, BlockPos pos)
	{
		if (TerrainGen.saplingGrowTree(worldIn, rand, pos))
		{
			int height = 10 + rand.nextInt(11);
			if (this.checkPillarPositiveY(worldIn, pos, 1, height))
			{
				int leavesStartHeight = (int) (0.4F * height);
				int leavesEndheight = height - leavesStartHeight;
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.08F, pos.add(-1, leavesStartHeight, 0), 0, leavesEndheight, this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.08F, pos.add(1, leavesStartHeight, 0), 0, leavesEndheight, this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.08F, pos.add(0, leavesStartHeight, -1), 0, leavesEndheight, this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.08F, pos.add(0, leavesStartHeight, 1), 0, leavesEndheight, this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.75F, pos.add(-1, leavesStartHeight, -1), 0, leavesEndheight - 1 - rand.nextInt(2), this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.75F, pos.add(-1, leavesStartHeight, 1), 0, leavesEndheight - 1 - rand.nextInt(2), this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.75F, pos.add(1, leavesStartHeight, -1), 0, leavesEndheight - 1 - rand.nextInt(2), this.leavesState);
				this.buildPillarPositiveYMissingSpots(worldIn, rand, 0.75F, pos.add(1, leavesStartHeight, 1), 0, leavesEndheight - 1 - rand.nextInt(2), this.leavesState);
				this.buildPillarPositiveY(worldIn, pos, 0, height, this.logState.withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.Y));
				this.buildSingleBlock(worldIn, pos.add(0, height, 0), this.leavesState);
				return true;
			}
		}
		return false;
	}
}
