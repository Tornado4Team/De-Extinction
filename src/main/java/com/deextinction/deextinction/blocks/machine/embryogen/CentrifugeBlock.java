package com.deextinction.deextinction.blocks.machine.embryogen;

import com.deextinction.deextinction.blocks.BlockBase;
import com.deextinction.deextinction.init.DeexBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class CentrifugeBlock extends BlockBase{


	public static final AxisAlignedBB CLEANING_TABLE_BLOCK_AABB = new AxisAlignedBB (0, 0, 0, 1, 1.0D, 1);
		
	public CentrifugeBlock(String name, Material material) {
super(name, material);
		
		setSoundType(SoundType.METAL);
		setHardness(2.5F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 1);
		//setLightlevel();
		//setLightOpacity();
		//setBlockUnbreakable();
		
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return CLEANING_TABLE_BLOCK_AABB;
	}

	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	{
	    this.setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH)); 
	}
	
	

	@Override
	public IBlockState getStateFromMeta(int meta) 
    	{
			EnumFacing facing = EnumFacing.getFront(meta);

			if(facing.getAxis()==EnumFacing.Axis.Y) 
			{
				facing=EnumFacing.NORTH;
			}
			return getDefaultState().withProperty(FACING, facing);
    	}

	  @Override
	  public int getMetaFromState(IBlockState state) 
               {
	       	   		return ((EnumFacing) state.getValue(FACING)).getIndex();
               }
	    
	   @Override
	   protected BlockStateContainer createBlockState() 
               {
	           		return new BlockStateContainer(this, new IProperty[]{FACING});
               }
	  @Override
	    public IBlockState getStateForPlacement(World worldIn, BlockPos pos,EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) 
	    {
		  return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	    }
	  
	  public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
	    {
	        return super.canPlaceBlockAt(worldIn, pos) ? this.canBlockStay(worldIn, pos) : false;       
	    }

	    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	    {    
	        if (!this.canBlockStay(worldIn, pos))
	        {    
	            worldIn.setBlockToAir(pos);
	            InventoryHelper.spawnItemStack(worldIn, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(DeexBlocks.CENTRIFUGE_BLOCK, 1));
	        }      
	    }

	    private boolean canBlockStay(World worldIn, BlockPos pos)
	    {
	        return worldIn.getBlockState(pos.down()).isSideSolid(worldIn, pos, EnumFacing.UP);
	    }
}


