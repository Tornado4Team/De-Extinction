package com.deextinction.deextinction.blocks;




import java.util.Random;

import com.deextinction.deextinction.init.DeexItem;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class MesozoicFossilBlock extends BlockBase 
{

	public MesozoicFossilBlock(String name, Material material) 
	{
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(2.5F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
		//setLightlevel();
		//setLightOpacity();
		//setBlockUnbreakable();
		
	}

    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return DeexItem.MESOZOIC_FOSSIL_DIRTY;
    }
   
    public int quantityDropped(Random random) {
        return 1;
    }
   
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0) {
                i = 0;
                }
           
            return this.quantityDropped(random) * (i + 1);          
        }  
       
        else {
            return this.quantityDropped(random);    
        }
       
    }
   
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }
   
    @Override
    public int getExpDrop(IBlockState state, net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune) {
       
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            i = MathHelper.getInt(rand, 3, 7);
            return i;          
        }
   
        return 0;      
    }
 
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this);
    }
 
}
	
	
   

