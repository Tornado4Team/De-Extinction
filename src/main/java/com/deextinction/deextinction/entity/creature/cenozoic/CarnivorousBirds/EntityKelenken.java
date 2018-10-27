package com.deextinction.deextinction.entity.creature.cenozoic.CarnivorousBirds;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityKelenken extends EntityTerrorBird


{

	public EntityKelenken(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 2.5F);
	}


	
	@Override
	protected void initEntityAI()
	{
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.targetTasks.addTask(2, new EntityKelenken.AIHurtByTarget());
	    this.targetTasks.addTask(3, new EntityKelenken.AIAttackPlayer());
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 3.5d, true));
		this.tasks.addTask(4, new EntityAIWander(this, 2.0d));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntitySheep.class, true));
		this.targetTasks.addTask(5, new EntityAINearestAttackableTarget(this, EntityHorse.class, true));
	    this.tasks.addTask(6, new EntityAILookIdle(this));
		
	}
	
	@Override
	protected void applyEntityAttributes() 
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(36.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.09D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);

		this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
	
		
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
            super(EntityKelenken.this, EntityPlayer.class, 20, true, true, (Predicate)null);
        }
	
}
	
	 class AIHurtByTarget extends EntityAIHurtByTarget
	    {
	        public AIHurtByTarget()
	        {
	            super(EntityKelenken.this, false);
	        }

	
	
	
	
}
	 
	
	    
}



