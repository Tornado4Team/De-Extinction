package com.deextinction.entity.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.init.DeDatabase;
import com.deextinction.util.MinecraftTime;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DeAIEatDroppedItem extends EntityAIBase
{
	protected DeAIEatDroppedItem.DistanceComparator nearestTargetSorter;
	private EntityDeExtinctedAnimal animal;
	private EntityItem droppedFood;
	private List<Item> listItems;
	private double searchDistance;
	private double distanceToEatSq;
	private double speed;
	private int timeTryingToEat;
	private int eatDelay;
	private int chance;

	public DeAIEatDroppedItem(EntityDeExtinctedAnimal animal, double speed, double distanceToEat, List<Item> listItems)
	{
		this(animal, speed, 30, distanceToEat, 8, listItems);
	}

	public DeAIEatDroppedItem(EntityDeExtinctedAnimal animal, double speed, double distanceToEat, double searchDistance, List<Item> listItems)
	{
		this(animal, speed, 30, distanceToEat, searchDistance, listItems);
	}

	public DeAIEatDroppedItem(EntityDeExtinctedAnimal animal, double speed, int chance, double distanceToEat, double searchDistance, List<Item> listItems)
	{
		this.animal = animal;
		this.chance = chance;
		this.speed = speed;
		this.distanceToEatSq = distanceToEat * distanceToEat;
		this.searchDistance = searchDistance;
		this.listItems = listItems;
		this.timeTryingToEat = 0;
		this.nearestTargetSorter = new DeAIEatDroppedItem.DistanceComparator(this.animal);
		this.setMutexBits(DeAIMutex.MOTION_LOOK.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.animal.world.rand.nextInt(this.chance) == 0)
		{
			if (this.animal.isSitting() || this.animal.getAttackTarget() != null || !this.animal.isNotFull())
				return false;

			List<EntityItem> nearEntityList = this.animal.world.getEntitiesWithinAABB(EntityItem.class, this.animal.getEntityBoundingBox().expand(this.searchDistance, this.searchDistance / 2.0D, this.searchDistance));
			if (!nearEntityList.isEmpty())
			{
				Collections.sort(nearEntityList, this.nearestTargetSorter);
				for (EntityItem target : nearEntityList)
				{
					if (this.listItems.contains(target.getItem().getItem()))
					{
						this.droppedFood = target;
						return true;
					}
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

		this.animal.getNavigator().tryMoveToXYZ(this.droppedFood.posX, this.droppedFood.posY, this.droppedFood.posZ, this.speed);
		this.timeTryingToEat = 150;
	}

	@Override
	public void updateTask()
	{
		double distanceSq = this.animal.getDistanceSq(this.droppedFood);

		if (distanceSq < this.distanceToEatSq)
		{
			if (this.eatDelay-- < 0)
			{
				ItemStack droppedFoodStack = this.droppedFood.getItem();
				if (droppedFoodStack != null)
				{
					Item droppedFoodItem = droppedFoodStack.getItem();
					if (droppedFoodItem != null && this.listItems.contains(droppedFoodItem))
					{
						String itemUnlocalizedName = droppedFoodItem.getUnlocalizedName();
						if (DeDatabase.FOOD_LIST.containsKey(itemUnlocalizedName))
							this.animal.decreaseHunger(DeDatabase.FOOD_LIST.get(itemUnlocalizedName));
						else
							this.animal.decreaseHunger((int) (0.1F * MinecraftTime.MC_DAY_LENGHT));

						this.animal.setEntityStateEating(this.animal, droppedFoodItem);
						droppedFoodStack.shrink(1);
						this.timeTryingToEat += 5;
						this.eatDelay = 5;
					}
				}

				if (this.droppedFood.getItem().isEmpty())
				{
					this.droppedFood.setDead();

					if (this.animal.isNotFull())
					{
						List<EntityItem> nearEntityList = this.animal.world.getEntitiesWithinAABB(EntityItem.class, this.animal.getEntityBoundingBox().expand(this.searchDistance, this.searchDistance / 2.0D, this.searchDistance));
						if (!nearEntityList.isEmpty())
						{
							Collections.sort(nearEntityList, this.nearestTargetSorter);
							for (EntityItem target : nearEntityList)
							{
								if (this.listItems.contains(target.getItem().getItem()))
								{
									this.droppedFood = target;
									this.animal.getNavigator().tryMoveToXYZ(this.droppedFood.posX, this.droppedFood.posY, this.droppedFood.posZ, this.speed);
									this.timeTryingToEat = 150;
								}
							}
						}
					}
				}
			}
		}
		else
		{
			if (this.animal.getNavigator().noPath())
				this.animal.getNavigator().tryMoveToXYZ(this.droppedFood.posX, this.droppedFood.posY, this.droppedFood.posZ, this.speed);
		}
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return this.timeTryingToEat-- > 0 && this.droppedFood.isEntityAlive() && this.animal.isEntityAlive() && this.animal.isNotFull() && !this.animal.isSitting();
	}

	@Override
	public void resetTask()
	{
		this.animal.getNavigator().clearPath();
		this.droppedFood = null;
		this.timeTryingToEat = 0;
	}

	public static class DistanceComparator implements Comparator
	{
		private final Entity theEntity;

		public DistanceComparator(Entity entity)
		{
			this.theEntity = entity;
		}

		public int compare(Entity compare1, Entity compare2)
		{
			double distanceFrom1 = this.theEntity.getDistanceSq(compare1);
			double distanceFrom2 = this.theEntity.getDistanceSq(compare2);
			return distanceFrom1 < distanceFrom2 ? -1 : (distanceFrom1 > distanceFrom2 ? 1 : 0);
		}

		public int compare(Object compare1, Object compare2)
		{
			return this.compare((Entity) compare1, (Entity) compare2);
		}
	}
}
