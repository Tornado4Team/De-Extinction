package com.deextinction.util;

import java.util.Collections;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MultipartStateMap extends StateMapperBase
{
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state)
	{
		String blockName = Block.REGISTRY.getNameForObject(state.getBlock()).toString();
		return new ModelResourceLocation(blockName, this.getPropertyString(Collections.emptyMap()));
	}
}
