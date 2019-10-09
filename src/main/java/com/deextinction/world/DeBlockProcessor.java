package com.deextinction.world;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.template.ITemplateProcessor;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;

public class DeBlockProcessor implements ITemplateProcessor
{
	public final Random random;
	public final float chance;

	public DeBlockProcessor(BlockPos pos, PlacementSettings settings)
	{
		this.chance = settings.getIntegrity();
		this.random = settings.getRandom(pos);
	}

	@Nullable
	public Template.BlockInfo processBlock(World worldIn, BlockPos pos, Template.BlockInfo blockInfoIn)
	{
		return this.chance < 1.0F && this.random.nextFloat() > this.chance ? null : blockInfoIn;
	}
}
