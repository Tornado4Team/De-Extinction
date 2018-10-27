package com.deextinction.deextinction.entity.creature.cenozoic.HerbMammals;

import com.deextinction.deextinction.entity.EntityDeex;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.world.World;

public class EntityGlyptodon extends EntityDeex


{

	public EntityGlyptodon(World worldIn) {
		super(worldIn);
		this.setSize(1.2F, 2.0F);
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
		this.tasks.addTask(0, new EntityAISwimming(this));
		
		this.tasks.addTask(1, new EntityAIWander(this, 0.8d));
		
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.06D);
	

		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(35.0D);
	
		
	}
	



	
	
	
	
}
	 
	
	    

