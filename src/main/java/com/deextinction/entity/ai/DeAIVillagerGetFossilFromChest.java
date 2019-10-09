package com.deextinction.entity.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deextinction.item.ItemFossilDirty;

import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;

public class DeAIVillagerGetFossilFromChest extends EntityAIBase
{
	protected DeAIVillagerGetFossilFromChest.DistanceComparator nearestTargetSorter;
	private EntityVillager villager;
	private BlockPos chestCoords;
	private double speed;
	private int searchDistance;
	private int chance;

	public DeAIVillagerGetFossilFromChest(EntityVillager villager, double speed)
	{
		this.villager = villager;
		this.speed = speed;
		this.searchDistance = 8;
		this.chance = 50;
		this.nearestTargetSorter = new DeAIVillagerGetFossilFromChest.DistanceComparator(this.villager);

		this.setMutexBits(DeAIMutex.MOTION.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.villager.getRNG().nextInt(this.chance) == 0)
		{
			InventoryBasic villagerInventory = this.villager.getVillagerInventory();
			for (int index = 0; index < villagerInventory.getSizeInventory(); index++)
			{
				ItemStack stack = villagerInventory.getStackInSlot(index);
				if (stack.getItem() instanceof ItemFossilDirty)
					return false;
			}

			BlockPos pos = this.villager.getPos();
			List<BlockPos> nearStates = new ArrayList<BlockPos>();
			for (int x = pos.getX() - this.searchDistance; x < pos.getX() + this.searchDistance; x++)
			{
				for (int y = pos.getY() - this.searchDistance / 2; y < pos.getY() + this.searchDistance / 2; y++)
				{
					for (int z = pos.getZ() - this.searchDistance; z < pos.getZ() + this.searchDistance; z++)
					{
						BlockPos blockPos = new BlockPos(x, y, z);
						IBlockState state = this.villager.world.getBlockState(blockPos);
						if (state.getBlock() instanceof BlockChest)
							nearStates.add(blockPos);
					}
				}
			}

			System.out.println("Chests inside searching area = " + nearStates);

			if (!nearStates.isEmpty())
			{
				Collections.sort(nearStates, this.nearestTargetSorter);
				for (BlockPos target : nearStates)
				{
					this.chestCoords = target;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public void startExecuting()
	{
		this.villager.getNavigator().tryMoveToXYZ(this.chestCoords.getX(), this.chestCoords.getY(), this.chestCoords.getZ(), this.speed);
	}

	@Override
	public void updateTask()
	{

	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (!(this.villager.world.getBlockState(this.chestCoords).getBlock() instanceof BlockChest))
		{
			this.villager.getNavigator().clearPath();
			return false;
		}

		double distanceSq = this.villager.getDistanceSq(this.chestCoords);
		if (distanceSq < 1.5D)
		{
			this.villager.getNavigator().clearPath();
			return false;
		}

		return this.villager.isEntityAlive();
	}

	@Override
	public void resetTask()
	{
		System.out.println("resetTask chest");
		if (this.villager.world.getBlockState(this.chestCoords).getBlock() instanceof BlockChest)
		{
			TileEntityChest chest = (TileEntityChest) this.villager.world.getTileEntity(this.chestCoords);
			for (int index = 0; index < chest.getSizeInventory(); index++)
			{
				ItemStack stack = chest.getStackInSlot(index);
				if (stack.getItem() instanceof ItemFossilDirty)
				{
					System.out.println(stack);

					chest.decrStackSize(index, 1);
					this.villager.getVillagerInventory().addItem(stack);

					// chest.receiveClientEvent(1, 1);
					// chest.openInventory(null);

					break;
				}
			}
		}
	}

	public static class DistanceComparator implements Comparator
	{
		private final Entity villager;

		public DistanceComparator(Entity entity)
		{
			this.villager = entity;
		}

		public int compare(BlockPos compare1, BlockPos compare2)
		{
			double distanceFrom1 = this.villager.getDistanceSq(compare1);
			double distanceFrom2 = this.villager.getDistanceSq(compare2);
			return distanceFrom1 < distanceFrom2 ? -1 : (distanceFrom1 > distanceFrom2 ? 1 : 0);
		}

		public int compare(Object compare1, Object compare2)
		{
			return this.compare((BlockPos) compare1, (BlockPos) compare2);
		}
	}
}
