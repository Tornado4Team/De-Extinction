package com.deextinction.block.machines;

import java.util.Random;

import com.deextinction.block.BlockContainerHorizontalWorking;
import com.deextinction.tileentities.TileDNAExtractor;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDNAExtractor extends BlockContainerHorizontalWorking
{

	public BlockDNAExtractor(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public int tickRate(World worldIn)
	{
		return 10;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomWorkingTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		double dx = (double) pos.getX() + 0.2D + rand.nextDouble() * 0.6D;
		double dy = (double) pos.getY() + 1.0D;
		double dz = (double) pos.getZ() + 0.2D + rand.nextDouble() * 0.6D;
		double speed = 0.05D;
		worldIn.spawnParticle(EnumParticleTypes.CLOUD, dx, dy, dz, (rand.nextDouble() - 0.5D) * speed, rand.nextDouble() * speed, (rand.nextDouble() - 0.5D) * speed);

		if (rand.nextDouble() < 0.1D)
			worldIn.playSound((double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, SoundEvents.BLOCK_METAL_BREAK, SoundCategory.BLOCKS, 0.1F, 0.05F, false);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileDNAExtractor();
	}

	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
	{
		return BlockFaceShape.UNDEFINED;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}
}
