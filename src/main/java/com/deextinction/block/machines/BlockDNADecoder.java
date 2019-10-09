package com.deextinction.block.machines;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import com.deextinction.block.BlockContainerHorizontal;
import com.deextinction.database.DeExtincted;
import com.deextinction.init.DeBlocks;
import com.deextinction.init.DeDatabase;
import com.deextinction.tileentities.TileDNADecoder;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockDNADecoder extends BlockContainerHorizontal
{

	public BlockDNADecoder(float hardness, float resistance, Material material, SoundType soundType, CreativeTabs tab)
	{
		super(hardness, resistance, material, soundType, tab);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	{
		TileEntity tileentity = worldIn.getTileEntity(pos);
		if (tileentity instanceof TileDNADecoder)
		{
			TileDNADecoder dna_decoder = ((TileDNADecoder) tileentity);

			if (stack.hasTagCompound())
			{
				NBTTagCompound compound = stack.getTagCompound();

				if (compound.hasKey("CustomName"))
					dna_decoder.setCustomInventoryName(compound.getString("CustomName"));
				else if (stack.hasDisplayName())
					dna_decoder.setCustomInventoryName(stack.getDisplayName());

				for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
					if (compound.hasKey(deExtincted.getName()))
						dna_decoder.setResearchPoints(deExtincted.getName(), compound.getInteger(deExtincted.getName()));
			}
		}

		super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return null;
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
	{
		if (willHarvest)
			return true;
		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity tileEntity, ItemStack stack)
	{
		super.harvestBlock(world, player, pos, state, tileEntity, stack);
		world.setBlockToAir(pos);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune)
	{
		List<ItemStack> drops = super.getDrops(worldIn, pos, state, fortune);

		TileEntity tileEntity = worldIn.getTileEntity(pos);
		if (tileEntity instanceof TileDNADecoder)
			drops.add(this.getBlockWithTag((TileDNADecoder) tileEntity, pos));
		return drops;
	}

	private ItemStack getBlockWithTag(TileDNADecoder tileEntity, BlockPos pos)
	{
		ItemStack stack = new ItemStack(DeBlocks.dna_decoder);
		if (tileEntity != null)
		{
			NBTTagCompound compound = new NBTTagCompound();
			for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
				if (tileEntity.hasResearchPoints(deExtincted.getName()))
					compound.setInteger(deExtincted.getName(), tileEntity.getResearchPoints(deExtincted.getName()));

			if (tileEntity.hasCustomName())
				compound.setString("CustomName", tileEntity.getName());

			stack.setTagCompound(compound);
		}
		return stack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if (stack.hasTagCompound())
		{
			NBTTagCompound compound = stack.getTagCompound();

			int numberOfResearches = 0;

			for (DeExtincted deExtincted : DeDatabase.LIST_DE_EXTINCTED.values())
			{
				if (compound.hasKey(deExtincted.getName()) && compound.getInteger(deExtincted.getName()) > 0)
					numberOfResearches++;
			}

			if (numberOfResearches > 1)
				tooltip.add(numberOfResearches + " " + I18n.translateToLocal("tile.block_dna_decoder.tooltip.2"));
			else if (numberOfResearches == 1)
				tooltip.add(numberOfResearches + " " + I18n.translateToLocal("tile.block_dna_decoder.tooltip.1"));
		}
		else
			tooltip.add(I18n.translateToLocal("tile.block_dna_decoder.tooltip.0"));
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileDNADecoder();
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
