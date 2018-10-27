package com.deextinction.deextinction.entity.creature.defectum;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityZeinner extends EntityDefectum


{

	public EntityZeinner(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 2.5F);
	}

	//@Override
	//protected void entityInit() {
		 //TODO Auto-generated method stub
		
	//}
	
	//@Override
	//public void readEntityFromNBT(NBTTagCompound compound)	
//	{
		
//	}
	
//	@Override
//	public void writeEntityToNBT(NBTTagCompound compound)	
//	{
		
//	}

//	public boolean isAIEnabled() {
//		return true;
//	}
	
	@Override
	protected void initEntityAI()
	{
		
		
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
		this.experienceValue = 0;
		
	}
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return false;
    }
	
	 public void onEntityUpdate()
	    {
	        int i = this.getAir();
	        super.onEntityUpdate();

	        if (this.isEntityAlive() && !this.isInWater())
	        {
	            --i;
	            this.setAir(i);

	            if (this.getAir() == -20)
	            {
	                this.setAir(0);
	                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
	            }
	        }
	        else
	        {
	            this.setAir(300);
	        }
	    }

	
	
	
	

	
	
	
	
}
	 
	
	    




