package com.deextinction.deextinction.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIFollowOwner;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIOwnerHurtByTarget;
import net.minecraft.entity.ai.EntityAIOwnerHurtTarget;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityDeex extends EntityAnimal 
{
	

	   
	   

	    public boolean isAttacking = false;
	    private int attackingTimer = 0;

	    public EntityDeex(World world){
	        super(world);
	    }

	    @Override
	    protected void initEntityAI() {
	      
	        this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, false));
	        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
	 
	        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
	      
	        this.tasks.addTask(9, new EntityAIWanderAvoidWater(this, 1.0D));
	        this.tasks.addTask(10, new EntityAILookIdle(this));
	      
	        this.targetTasks.addTask(3, new EntityAIHurtByTarget(this, true, new Class[0]));
	    }

	    public EntityDeex createChild(EntityAgeable dinosaur){
	        return new EntityDeex(this.world);
	    }
	   
	    @Override
	    public void onLivingUpdate(){
	        //if(!this.isInLove() && this.growingAge == 0){
	          //  if(this.getRNG().nextInt(1800) == 0){
	        //        this.setInLove(null);
	       //     }
	     //   }
	        if(this.getAttackTarget() != null){
	            float f = this.rotationYaw * 0.017453292F;
	            this.motionX -= (double)(MathHelper.cos(f) * 0.001F);
	            this.motionZ += (double)(MathHelper.cos(f) * 0.001F);
	        }
	        if(!this.world.isRemote){
	            if(this.isAttacking){
	                this.attackingTimer++;
	                if(this.attackingTimer >= 20){
	                    this.isAttacking = false;
	                    this.attackingTimer = 0;
	                }
	            } else {
	                this.attackingTimer = 0;
	            }
	        }
	        super.onLivingUpdate();
	    }

	 
	    @Override
	    public boolean isBreedingItem(ItemStack stack)
	   {
	        return false;
	   }
	    @Override
	    protected void entityInit()
	    {
	        super.entityInit();
	      
	    }

	    @Override
	    protected void applyEntityAttributes(){
	        super.applyEntityAttributes();
	        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
	    }
	    @Override
	    public boolean attackEntityAsMob(Entity entityIn)
	    {
	        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float)((int)this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue()));
	        this.isAttacking = true;
	        if (flag)
	        {
	            this.applyEnchantments(this, entityIn);
	        }

	        return flag;
	    }

	    public void writeEntityToNBT(NBTTagCompound compound)
	    {
	        super.writeEntityToNBT(compound);
	       
	    }

	    public void readEntityFromNBT(NBTTagCompound compound)
	    {
	        super.readEntityFromNBT(compound);
	      
	    }

	
	  
}
