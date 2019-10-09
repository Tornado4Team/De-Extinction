package com.deextinction.entity.animal;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.client.renderer.animations.ControlledAnimation;
import com.deextinction.database.DeExtinctedAnimal;
import com.deextinction.database.animals.Archaeorhynchus;
import com.deextinction.entity.EntityDeExtinctedFlyingCoward;
import com.deextinction.entity.ai.DeAIFloatInWater;
import com.deextinction.entity.ai.DeAIFollowFood;
import com.deextinction.entity.ai.DeAIFollowParent;
import com.deextinction.entity.ai.DeAISittingNatural;
import com.deextinction.entity.ai.DeAIWanderAvoidWaterFlying;
import com.deextinction.init.DeDatabase;

import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityArchaeorhynchus extends EntityDeExtinctedFlyingCoward
{
	private ControlledAnimation sittingAnimation = new ControlledAnimation(30);
	private DeAIFollowParent aiFollowParent;

	protected static final List<Item> foodList = new ArrayList<Item>();
	static
	{
		EntityArchaeorhynchus.foodList.add(Items.APPLE);
		EntityArchaeorhynchus.foodList.add(Items.BREAD);
		EntityArchaeorhynchus.foodList.add(Items.WHEAT);
	}

	public EntityArchaeorhynchus(World worldIn)
	{
		super(worldIn);
	}

	@Override
	protected void initEntityAI()
	{
		this.aiFollowParent = new DeAIFollowParent(this, 1.1D, 8, 30);

        this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new DeAIFloatInWater(this));
		this.tasks.addTask(2, new DeAIWanderAvoidWaterFlying(this, 1.0D));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0D, true));
		this.tasks.addTask(4, new DeAIFollowFood(this, 1.0D, 30, EntityArchaeorhynchus.foodList));
		this.tasks.addTask(5, new DeAISittingNatural(this));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
	}

	@Override
	public DeExtinctedAnimal getAnimal()
	{
		return (DeExtinctedAnimal) DeDatabase.LIST_DE_EXTINCTED.get(Archaeorhynchus.NAME);
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
		return EntityArchaeorhynchus.foodList;
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

	@Override
	protected boolean hasAgeToFly()
	{
		return this.isAdult();
	}
}
