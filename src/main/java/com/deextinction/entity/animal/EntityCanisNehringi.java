
package com.deextinction.entity.animal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.animations.ControlledAnimation;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.animals.CanisNehringi;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.entity.ai.DeAIEatDroppedItem;
import com.deextinction.entity.ai.DeAIFloatInWater;
import com.deextinction.entity.ai.DeAIFollowFood;
import com.deextinction.entity.ai.DeAIFollowParent;
import com.deextinction.entity.ai.DeAIHurtByTarget;
import com.deextinction.entity.ai.DeAISittingNatural;
import com.deextinction.entity.ai.DeAIWanderAvoidWater;
import com.deextinction.entity.ai.animation.DeAISound;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.MinecraftTime;

import net.minecraft.block.Block;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityCanisNehringi extends EntityDeExtinctedAnimal
{
	private ControlledAnimation sittingAnimation = new ControlledAnimation(20);
	private EntityAINearestAttackableTarget aiAttackSkeleton;
	private DeAIFollowParent aiFollowParent;
	private EntityAIPanic aiPanic;

	protected static final List<Item> foodList = new ArrayList<Item>();
	static
	{
		EntityCanisNehringi.foodList.add(Items.BEEF);
		EntityCanisNehringi.foodList.add(Items.CHICKEN);
		EntityCanisNehringi.foodList.add(Items.MUTTON);
		EntityCanisNehringi.foodList.add(Items.PORKCHOP);
		EntityCanisNehringi.foodList.add(Items.RABBIT);
		EntityCanisNehringi.foodList.add(Items.COOKED_BEEF);
		EntityCanisNehringi.foodList.add(Items.COOKED_CHICKEN);
		EntityCanisNehringi.foodList.add(Items.COOKED_MUTTON);
		EntityCanisNehringi.foodList.add(Items.COOKED_PORKCHOP);
		EntityCanisNehringi.foodList.add(Items.COOKED_RABBIT);
	}

	public EntityCanisNehringi(World worldIn)
	{
		super(worldIn);
	}

	@Override
	protected void initEntityAI()
	{
		this.aiAttackSkeleton = new EntityAINearestAttackableTarget(this, AbstractSkeleton.class, false);
		this.aiFollowParent = new DeAIFollowParent(this, 1.0D, 10, 30);
		this.aiPanic = new EntityAIPanic(this, 1.0D);

        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new DeAIFloatInWater(this));
		this.tasks.addTask(3, new DeAIWanderAvoidWater(this, 0.6F, 12, 7, 80));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(5, new DeAIEatDroppedItem(this, 1.0D, 10, 16.0D, EntityCanisNehringi.foodList));
		this.tasks.addTask(6, new DeAIFollowFood(this, 1.0D, 30, EntityCanisNehringi.foodList));
		this.tasks.addTask(7, new DeAISound(this, 20));
		this.tasks.addTask(7, new DeAISittingNatural(this));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new DeAIHurtByTarget(this, true, false));
	}

	@Override
	public DeExtinctedAnimal getAnimal()
	{
		return (DeExtinctedAnimal) DeDatabase.LIST_DE_EXTINCTED.get(CanisNehringi.NAME);
	}

	@Override
	public boolean isAdult()
	{
		return this.getGrowthStage() > 1;
	}

	@Override
	public int getMaxHunger()
	{
		return MinecraftTime.MC_DAY_LENGHT;
	}

	@Override
	public float getMaxWidth()
	{
		return 0.8F;
	}

	@Override
	public float getMaxHeight()
	{
		return 1.6F;
	}

	@Override
	public float getEyeHeight()
	{
		return 0.9F * this.height;
	}

	@Override
	public int getTalkInterval()
	{
		return 150;
	}

	@Override
	protected float getSoundVolume()
	{
		return 0.3F + 0.2F * this.getGrowthScaled();
	}

	@Override
	@Nullable
	protected SoundEvent getAmbientSound()
	{
		return SoundEvents.ENTITY_WOLF_AMBIENT;
	}

	@Override
	protected void playStepSound(BlockPos pos, Block blockIn)
	{
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.25F, 0.7F);
	}

	@Override
	public void playLivingSound()
	{
		super.playLivingSound();

		if (!this.world.isRemote && this.canAnimate())
			DeExtinction.sendAnimPacket(this, DeAnimationList.SOUND_1);
	}

	@Override
	public List<Item> getCreatureFoodList()
	{
		return EntityCanisNehringi.foodList;
	}

	@Override
	protected void updateAIFromGrowthStage(int growthStage)
	{
		this.targetTasks.removeTask(this.aiAttackSkeleton);
		this.tasks.removeTask(this.aiFollowParent);
		this.tasks.removeTask(this.aiPanic);

		if (this.isChild())
		{
			this.tasks.addTask(1, this.aiFollowParent);
			this.tasks.addTask(1, this.aiPanic);
		}
		else
			this.targetTasks.addTask(1, this.aiAttackSkeleton);
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.world.isRemote)
		{
			this.sittingAnimation.update();

			if (this.isSitting())
				this.sittingAnimation.runAnimation();
			else
				this.sittingAnimation.stopAnimation();
		}
	}

	@SideOnly(Side.CLIENT)
	public float getSittingProgress(float partialRenderTicks)
	{
		return this.sittingAnimation.getAnimationProgressSin(partialRenderTicks);
	}
}
