package com.deextinction.deextinction.entity.creature.cenozoic.CarnivoresMammals;

import com.deextinction.deextinction.entity.creature.cenozoic.HerbMammals.EntityGlyptodon;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntitySmilodon extends EntityBigCat


{

	public EntitySmilodon(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 2.0F);
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
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySheep.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPig.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCow.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHorse.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityGlyptodon.class, true));
		  this.targetTasks.addTask(1, new EntitySmilodon.AIHurtByTarget());
	        this.targetTasks.addTask(2, new EntitySmilodon.AIAttackPlayer());
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 4.0d, true));
		this.tasks.addTask(1, new EntityAIWander(this, 2.3d));
	    this.tasks.addTask(4, new EntityAILookIdle(this));
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.09D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);

		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(18.0D);
	
		
	}
	

	public boolean attackEntityAsMob(Entity entityIn)
    {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));

        if (flag)
        {
            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

	class AIAttackPlayer extends EntityAINearestAttackableTarget<EntityPlayer>
    {
        public AIAttackPlayer()
        {
            super(EntitySmilodon.this, EntityPlayer.class, 20, true, true, (Predicate)null);
        }
	
}
	
	 class AIHurtByTarget extends EntityAIHurtByTarget
	    {
	        public AIHurtByTarget()
	        {
	            super(EntitySmilodon.this, false);
	        }

	
	
	
	
}
	 
	
	    
}
