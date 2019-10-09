package com.deextinction.entity.ai;

import java.util.ArrayList;
import java.util.List;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DeAIFollowFood extends EntityAIBase
{
	private List<Item> foodList = new ArrayList<Item>();
	private EntityDeExtinctedAnimal animal;
	private EntityPlayer player;
	private World world;
	private double speed;
	private int chance;
	private ItemStack heldItemStack;
	private double distanceToPlayerSq;

	public DeAIFollowFood(EntityDeExtinctedAnimal animal, List<Item> foodList)
	{
		this(animal, 1.0F, 1.5F, 30, foodList);
	}

	public DeAIFollowFood(EntityDeExtinctedAnimal animal, double speed, List<Item> foodList)
	{
		this(animal, speed, 1.5F, 30, foodList);
	}

	public DeAIFollowFood(EntityDeExtinctedAnimal animal, double speed, double distanceToPlayer, List<Item> foodList)
	{
		this(animal, speed, distanceToPlayer, 30, foodList);
	}

	public DeAIFollowFood(EntityDeExtinctedAnimal animal, double speed, double distanceToPlayer, int chance, List<Item> foodList)
	{
		this.animal = animal;
		this.world = animal.world;
		this.chance = chance;
		this.speed = speed;
		this.foodList = foodList;
		this.distanceToPlayerSq = distanceToPlayer * distanceToPlayer;
		this.setMutexBits(DeAIMutex.MOTION_LOOK.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.world.rand.nextInt(this.chance) == 0)
		{
			if (this.animal.isSitting())
				return false;

			this.player = this.world.getClosestPlayerToEntity(this.animal, 10.0D);
			if (this.player == null)
				return false;
			else if (this.animal.getAttackTarget() != null)
				return false;
			else
			{
				ItemStack itemstack = this.player.getHeldItemMainhand();
				if (itemstack == null)
					return false;
				else if (this.foodList.contains(itemstack.getItem()))
				{
					this.heldItemStack = itemstack;
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public void startExecuting()
	{
		if (this.animal.isSitting())
			this.animal.setSitting(false, null);
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return this.player != null && this.player.getHeldItemMainhand() != this.heldItemStack;
	}

	@Override
	public void updateTask()
	{
		this.animal.getLookHelper().setLookPositionWithEntity(this.player, 30.0F, this.animal.getVerticalFaceSpeed());
		if (this.animal.getDistanceSq(this.player) < this.distanceToPlayerSq)
			this.animal.getNavigator().clearPath();
		else
			this.animal.getNavigator().tryMoveToEntityLiving(this.player, this.speed);
	}

	@Override
	public void resetTask()
	{
		this.animal.getNavigator().clearPath();
		this.player = null;
	}
}
