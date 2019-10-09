
package com.deextinction.entity.animal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.deextinction.DeExtinction;
import com.deextinction.client.renderer.animations.ControlledAnimation;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.animals.Theriodictis;
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

public class EntityTheriodictis extends EntityDeExtinctedAnimal
{
	private ControlledAnimation sittingAnimation = new ControlledAnimation(20);
	private EntityAINearestAttackableTarget aiAttackSkeleton;
	private DeAIFollowParent aiFollowParent;
	private EntityAIPanic aiPanic;

	protected static final List<Item> foodList = new ArrayList<Item>();
	static
	{
		EntityTheriodictis.foodList.add(Items.BEEF);
		EntityTheriodictis.foodList.add(Items.CHICKEN);
		EntityTheriodictis.foodList.add(Items.MUTTON);
		EntityTheriodictis.foodList.add(Items.PORKCHOP);
		EntityTheriodictis.foodList.add(Items.RABBIT);
		EntityTheriodictis.foodList.add(Items.COOKED_BEEF);
		EntityTheriodictis.foodList.add(Items.COOKED_CHICKEN);
		EntityTheriodictis.foodList.add(Items.COOKED_MUTTON);
		EntityTheriodictis.foodList.add(Items.COOKED_PORKCHOP);
		EntityTheriodictis.foodList.add(Items.COOKED_RABBIT);
	}

	public EntityTheriodictis(World worldIn)
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
		this.tasks.addTask(1, new DeAIFloatInWater(this));
		this.tasks.addTask(2, new DeAIWanderAvoidWater(this, 0.6F, 12, 7, 80));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(4, new DeAIEatDroppedItem(this, 1.0D, 10, 16.0D, EntityTheriodictis.foodList));
		this.tasks.addTask(4, new DeAIFollowFood(this, 1.0D, 30, EntityTheriodictis.foodList));
		this.tasks.addTask(5, new DeAISound(this, 20));
		this.tasks.addTask(6, new DeAISittingNatural(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new DeAIHurtByTarget(this, true, false));
	}

	@Override
	public DeExtinctedAnimal getAnimal()
	{
		return (DeExtinctedAnimal) DeDatabase.LIST_DE_EXTINCTED.get(Theriodictis.NAME);
	}

	@Override
	public boolean isAdult()
	{
		return this.getGrowthStage() > 2;
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
		return 1.2F;
	}

	@Override
	public float getEyeHeight()
	{
		return 0.95F * this.height;
	}

	@Override
	public int getTalkInterval()
	{
		return 100;
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
		this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.25F, 1.0F);
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
		return EntityTheriodictis.foodList;
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
