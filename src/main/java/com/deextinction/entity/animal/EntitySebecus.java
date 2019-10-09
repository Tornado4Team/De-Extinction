
package com.deextinction.entity.animal;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.client.renderer.animations.ControlledAnimation;
import com.deextinction.client.renderer.animations.YawChainAnimator;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.animals.Sebecus;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.entity.ai.DeAIEatDroppedItem;
import com.deextinction.entity.ai.DeAIFloatInWater;
import com.deextinction.entity.ai.DeAIFollowFood;
import com.deextinction.entity.ai.DeAIFollowParent;
import com.deextinction.entity.ai.DeAIHurtByTarget;
import com.deextinction.entity.ai.DeAISittingNatural;
import com.deextinction.entity.ai.DeAIWanderAvoidWater;
import com.deextinction.entity.ai.animation.DeAISound;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySebecus extends EntityDeExtinctedAnimal
{
	public YawChainAnimator tailBuffer = new YawChainAnimator(this);
	private ControlledAnimation sittingAnimation = new ControlledAnimation(30);
	private DeAIFollowParent aiFollowParent;
	private EntityAIPanic aiPanic;

	protected static final List<Item> foodList = new ArrayList<Item>();
	static
	{
		EntitySmilodon.foodList.add(Items.PORKCHOP);
		EntitySmilodon.foodList.add(Items.BEEF);
		EntitySmilodon.foodList.add(Items.CHICKEN);
	}

	public EntitySebecus(World worldIn)
	{
		super(worldIn);
	}

	@Override
	protected void initEntityAI()
	{
		this.aiFollowParent = new DeAIFollowParent(this, 1.0D, 10, 30);
		this.aiPanic = new EntityAIPanic(this, 1.0D);

        this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new DeAIFloatInWater(this));
		this.tasks.addTask(2, new DeAIWanderAvoidWater(this, 0.6F, 12, 7, 80));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(4, new DeAIEatDroppedItem(this, 1.0D, 10, 16.0D, EntitySebecus.foodList));
		this.tasks.addTask(4, new DeAIFollowFood(this, 1.0D, 30, EntitySebecus.foodList));
		this.tasks.addTask(5, new DeAISound(this, 20));
		this.tasks.addTask(6, new DeAISittingNatural(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(0, new DeAIHurtByTarget(this, true, false));
	}

	@Override
	public DeExtinctedAnimal getAnimal()
	{
		return (DeExtinctedAnimal) DeDatabase.LIST_DE_EXTINCTED.get(Sebecus.NAME);
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
		return 0.85F;
	}

	@Override
	public float getMaxHeight()
	{
		return 1.0F;
	}

	@Override
	public float getEyeHeight()
	{
		return 0.8F * this.height;
	}

	@Override
	public int getTalkInterval()
	{
		return 250;
	}

	@Override
	public List<Item> getCreatureFoodList()
	{
		return EntitySebecus.foodList;
	}

	@Override
	protected void updateAIFromGrowthStage(int growthStage)
	{
		this.tasks.removeTask(this.aiFollowParent);
		this.tasks.removeTask(this.aiPanic);

		if (this.isChild())
		{
			this.tasks.addTask(1, this.aiFollowParent);
			this.tasks.addTask(1, this.aiPanic);
		}
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if (this.world.isRemote)
		{
			this.tailBuffer.update(8, 30.0F, 3.0F);

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
