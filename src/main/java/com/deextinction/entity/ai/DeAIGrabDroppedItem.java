package com.deextinction.entity.ai;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DeAIGrabDroppedItem extends EntityAIBase
{
	protected DeAIGrabDroppedItem.DistanceComparator nearestTargetSorter;
	private EntityDeExtinctedAnimal animal;
	private EntityItem droppedItem;
	private List<Item> listItems;
	private double searchDistance;
	private double distanceToGrabSq;
	private double speed;
	private int timeToGrab;
	private int chance;

	public DeAIGrabDroppedItem(EntityDeExtinctedAnimal animal, double speed, double distanceToEat, List<Item> listItems)
	{
		this(animal, speed, 30, distanceToEat, 8, listItems);
	}

	public DeAIGrabDroppedItem(EntityDeExtinctedAnimal animal, double speed, double distanceToEat, double searchDistance, List<Item> listItems)
	{
		this(animal, speed, 30, distanceToEat, searchDistance, listItems);
	}

	public DeAIGrabDroppedItem(EntityDeExtinctedAnimal animal, double speed, int chance, double distanceToGrab, double searchDistance, List<Item> listItems)
	{
		this.animal = animal;
		this.chance = chance;
		this.speed = speed;
		this.distanceToGrabSq = distanceToGrab * distanceToGrab;
		this.searchDistance = searchDistance;
		this.listItems = listItems;
		this.timeToGrab = 0;
		this.nearestTargetSorter = new DeAIGrabDroppedItem.DistanceComparator(this.animal);
		this.setMutexBits(DeAIMutex.MOTION_LOOK.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.animal.world.rand.nextInt(this.chance) == 0)
		{
			if (this.animal.hasItemInSlot(EntityEquipmentSlot.MAINHAND) || this.animal.isSitting() || this.animal.getAttackTarget() != null)
				return false;

			List<EntityItem> nearEntityList = this.animal.world.getEntitiesWithinAABB(EntityItem.class, this.animal.getEntityBoundingBox().expand(this.searchDistance, this.searchDistance / 2.0D, this.searchDistance));
			if (!nearEntityList.isEmpty())
			{
				Collections.sort(nearEntityList, this.nearestTargetSorter);
				for (EntityItem target : nearEntityList)
				{
					if (this.listItems.contains(target.getItem().getItem()))
					{
						this.droppedItem = target;
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

		this.animal.getNavigator().tryMoveToXYZ(this.droppedItem.posX, this.droppedItem.posY, this.droppedItem.posZ, this.speed);
		this.timeToGrab = 150;
	}

	@Override
	public void updateTask()
	{
		double distanceSq = this.animal.getDistanceSq(this.droppedItem);

		if (distanceSq < this.distanceToGrabSq)
		{
			if (this.droppedItem.getItem() != null)
			{
				Item droppedItem = this.droppedItem.getItem().getItem();
				if (droppedItem != null && this.listItems.contains(droppedItem))
				{
					this.animal.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(this.droppedItem.getItem().getItem()));
					this.animal.setEntityStateEating(this.animal, droppedItem);
					this.droppedItem.getItem().shrink(1);
				}
			}

			if (this.droppedItem.getItem().isEmpty())
				this.droppedItem.setDead();
		}
		else
		{
			if (this.animal.getNavigator().noPath())
				this.animal.getNavigator().tryMoveToXYZ(this.droppedItem.posX, this.droppedItem.posY, this.droppedItem.posZ, this.speed);
		}
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		return this.timeToGrab-- > 0 && this.animal.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty() && this.droppedItem.isEntityAlive() && this.animal.isEntityAlive() && !this.animal.isSitting();
	}

	@Override
	public void resetTask()
	{
		this.animal.getNavigator().clearPath();
		this.droppedItem = null;
		this.timeToGrab = 0;
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
