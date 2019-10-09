package com.deextinction.world;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class DeBlockProcessorLoot extends DeBlockProcessor
{
	protected ResourceLocation loot_table;

	public DeBlockProcessorLoot(BlockPos pos, PlacementSettings settings, ResourceLocation loot)
	{
		super(pos, settings);
		this.loot_table = loot;
	}

	@Nullable
	public Template.BlockInfo processBlock(World worldIn, BlockPos pos, Template.BlockInfo blockInfoIn)
	{
		IBlockState processedBlock = blockInfoIn.blockState;

		if (processedBlock.getBlock() == Blocks.CHEST)
		{
			Random rand = new Random(worldIn.getSeed() + pos.toLong());
			NBTTagCompound tag = blockInfoIn.tileentityData == null ? new NBTTagCompound() : blockInfoIn.tileentityData;
			tag.setString("LootTable", this.loot_table.toString());
			tag.setLong("LootTableSeed", rand.nextLong());
			Template.BlockInfo newInfo = new Template.BlockInfo(pos, Blocks.CHEST.getDefaultState(), tag);
			return newInfo;
		}

		return super.processBlock(worldIn, pos, blockInfoIn);
	}
}
