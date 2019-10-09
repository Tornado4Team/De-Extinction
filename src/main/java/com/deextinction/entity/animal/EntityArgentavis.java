package com.deextinction.entity.animal;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.client.renderer.animations.ControlledAnimation;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.animals.Argentavis;
import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.entity.ai.DeAIFloatInWater;
import com.deextinction.entity.ai.DeAIFollowFood;
import com.deextinction.entity.ai.DeAIFollowParent;
import com.deextinction.entity.ai.DeAISittingNatural;
import com.deextinction.init.DeDatabase;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWater;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityArgentavis extends EntityDeExtinctedAnimal
{
	private ControlledAnimation sittingAnimation = new ControlledAnimation(30);
	private DeAIFollowParent aiFollowParent;

	protected static final List<Item> foodList = new ArrayList<Item>();
	static
	{
		EntityArgentavis.foodList.add(Items.APPLE);
		EntityArgentavis.foodList.add(Items.BREAD);
		EntityArgentavis.foodList.add(Items.WHEAT);
	}

	public EntityArgentavis(World worldIn)
	{
		super(worldIn);
	}

	@Override
	protected void initEntityAI()
	{
		this.aiFollowParent = new DeAIFollowParent(this, 1.1D, 8, 30);
        this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new DeAIFloatInWater(this));
		this.tasks.addTask(2, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(4, new DeAIFollowFood(this, 1.0D, 30, EntityArgentavis.foodList));

		this.tasks.addTask(5, new EntityAIWanderAvoidWater(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.tasks.addTask(8, new DeAISittingNatural(this));
	}

	@Override
	public DeExtinctedAnimal getAnimal()
	{
		return (DeExtinctedAnimal) DeDatabase.LIST_DE_EXTINCTED.get(Argentavis.NAME);
	}

	@Override
	public boolean isAdult()
	{
		return this.getGrowthStage() > 1;
	}

	@Override
	public int getMaxHunger()
	{
		return 1000;
	}

	@Override
	public float getMaxWidth()
	{
		return 0.8F;
	}

	@Override
	public float getMaxHeight()
	{
		return 2.0F;
	}

	@Override
	public float getEyeHeight()
	{
		return 1.3F * this.height;
	}

	@Override
	public int getTalkInterval()
	{
		return 250;
	}

	@Override
	public List<Item> getCreatureFoodList()
	{
		return EntityArgentavis.foodList;
	}

	@Override
	protected void updateAIFromGrowthStage(int growthStage)
	{
		this.tasks.removeTask(this.aiFollowParent);

		if (!this.isAdult())
			this.tasks.addTask(4, this.aiFollowParent);
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
