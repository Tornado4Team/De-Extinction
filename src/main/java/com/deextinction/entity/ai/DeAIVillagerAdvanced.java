package com.deextinction.entity.ai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.deextinction.block.machines.BlockCleaningTable;
import com.deextinction.init.DeItems;
import com.deextinction.item.ItemBrush;
import com.deextinction.item.ItemFloppyDiskEmpty;
import com.deextinction.item.ItemFossilClean;
import com.deextinction.item.ItemFossilDirty;
import com.deextinction.tileentities.TileCleaningTable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGlassBottle;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;

public class DeAIVillagerAdvanced extends EntityAIBase
{
	protected DeAIVillagerAdvanced.VillagerDistanceComparator nearestTargetSorter;
	private EntityVillager villager;

	private List<ContainerInformation> nearCleaningTables;
	private List<ContainerInformation> nearChests;

	private VillagerResearchType researchType;
	private BlockPos targetCoords;

	private int searchDistance;
	private int chance;

	private double speed;

	public DeAIVillagerAdvanced(EntityVillager villager, double speed)
	{
		this.villager = villager;
		this.speed = speed;
		this.searchDistance = 8;
		this.chance = 100;
		this.nearestTargetSorter = new DeAIVillagerAdvanced.VillagerDistanceComparator(this.villager);

		this.nearCleaningTables = new ArrayList<ContainerInformation>();
		this.nearChests = new ArrayList<ContainerInformation>();
		this.targetCoords = this.villager.getPos();

		this.setMutexBits(DeAIMutex.MOTION.getMutex());
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.villager.getRNG().nextInt(this.chance) == 0)
		{
			System.out.println("Research Villager searching Task... Inventory is EMPTY = " + this.villager.getVillagerInventory().isEmpty());

			if (this.villagerHasItems())
			{
				if (this.villagerHasItem(DeItems.brush))
				{
					if (this.findNearbyCleaningTable(this.searchDistance, this.searchDistance / 2))
					{
						this.researchType = VillagerResearchType.CLEAN_DIRTY_FOSSIL;
						return true;
					}
				}
				else if (this.villagerHasItemByClass(DeItems.fossils_dirty.values().iterator().next()))
				{
					if (this.findNearbyCleaningTable(this.searchDistance, this.searchDistance / 2))
					{
						this.researchType = VillagerResearchType.CLEAN_DIRTY_FOSSIL;
						return true;
					}
				}
			}
			else
			{
				if (this.findNearbyChests(this.searchDistance, this.searchDistance / 2))
				{
					ContainerInformation info = this.nearChests.get(0);
					List<Boolean> flags = info.getInformations();
					for (int index = 0; index < flags.size(); index++)
					{
						boolean hasItem = flags.get(index);
						if (hasItem)
						{
							this.researchType = VillagerResearchType.GRAB_ITEM_FROM_CHEST;
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	@Override
	public void startExecuting()
	{
		System.out.println("Research Villager started " + this.researchType.toString() + " Task...");

		switch (this.researchType)
		{
			case GRAB_ITEM_FROM_CHEST:
				this.targetCoords = this.nearChests.get(0).getPosition();
				break;
			case CLEAN_DIRTY_FOSSIL:
				this.targetCoords = this.nearCleaningTables.get(0).getPosition();
				break;
			default:
				this.targetCoords = this.villager.getPos();
				break;
		}

		this.villager.getNavigator().tryMoveToXYZ(this.targetCoords.getX(), this.targetCoords.getY(), this.targetCoords.getZ(), this.speed);
	}

	@Override
	public void updateTask()
	{
		super.updateTask();
	}

	@Override
	public boolean shouldContinueExecuting()
	{
		if (!this.isTargetAlive())
			return false;

		double distanceSq = this.villager.getDistanceSq(this.targetCoords);
		if (distanceSq < 1.0D)
			return false;

		return !this.villager.getNavigator().noPath() && this.villager.hurtTime == 0 && !this.villager.isTrading();
	}

	@Override
	public void resetTask()
	{
		System.out.println("Research Villager finished " + this.researchType.toString() + " Task...");

		switch (this.researchType)
		{
			case GRAB_ITEM_FROM_CHEST:
				TileEntityChest chest = (TileEntityChest) this.villager.world.getTileEntity(this.targetCoords);
				for (int index = 0; index < chest.getSizeInventory(); index++)
				{
					ItemStack stack = chest.getStackInSlot(index);
					if (stack.getItem() instanceof ItemBrush)
					{
						this.villager.getVillagerInventory().addItem(stack.copy());
						chest.decrStackSize(index, stack.getCount());
						break;
					}
					else if (stack.getItem() instanceof ItemFossilDirty)
					{
						this.villager.getVillagerInventory().addItem(stack.copy());
						chest.decrStackSize(index, stack.getCount());
						break;
					}

					// chest.receiveClientEvent(1, 1);
					// chest.openInventory(null);

				}
				break;
			case CLEAN_DIRTY_FOSSIL:
				TileCleaningTable cleaningTable = (TileCleaningTable) this.villager.world.getTileEntity(this.targetCoords);
				InventoryBasic villagerInventory = this.villager.getVillagerInventory();

				if (cleaningTable.getSlot(TileCleaningTable.SLOT_INDEX_BRUSH).isEmpty())
				{
					if (!villagerInventory.isEmpty())
					{
						for (int index = 0; index < villagerInventory.getSizeInventory(); index++)
						{
							ItemStack stack = villagerInventory.getStackInSlot(index);
							if (stack.getItem() == DeItems.brush)
							{
								cleaningTable.setInventorySlotContents(TileCleaningTable.SLOT_INDEX_BRUSH, stack.copy());
								this.villager.getVillagerInventory().decrStackSize(index, stack.getCount());
							}
						}
					}
				}

				if (cleaningTable.getSlot(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY).isEmpty())
				{
					if (!villagerInventory.isEmpty())
					{
						for (int index = 0; index < villagerInventory.getSizeInventory(); index++)
						{
							ItemStack stack = villagerInventory.getStackInSlot(index);
							if (stack.getItem() instanceof ItemFossilDirty)
							{
								cleaningTable.setInventorySlotContents(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY, stack.copy());
								this.villager.getVillagerInventory().decrStackSize(index, stack.getCount());
								break;
							}
						}
					}
				}
				else
				{
					// TODO ADD MORE FOSSILS IF THERE IS ALREADY ONE TYPE OF IT

					if (!villagerInventory.isEmpty())
					{
						for (int index = 0; index < villagerInventory.getSizeInventory(); index++)
						{
							ItemStack villagerStack = villagerInventory.getStackInSlot(index);
							if (villagerStack.getItem() instanceof ItemFossilDirty)
							{
								ItemStack fossilStack = cleaningTable.getStackInSlot(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY);
								if (villagerStack.isItemEqual(fossilStack) && ItemStack.areItemStackTagsEqual(villagerStack, fossilStack))
								{
									int totalFossils = villagerStack.getCount() + fossilStack.getCount();
									if (totalFossils <= cleaningTable.getInventoryStackLimit())
									{
										fossilStack.setCount(totalFossils);
										cleaningTable.setInventorySlotContents(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY, fossilStack.copy());
										this.villager.getVillagerInventory().decrStackSize(index, villagerStack.getCount());
									}
									else
									{
										this.villager.getVillagerInventory().decrStackSize(index, cleaningTable.getInventoryStackLimit() - fossilStack.getCount());
										fossilStack.setCount(cleaningTable.getInventoryStackLimit());
										cleaningTable.setInventorySlotContents(TileCleaningTable.SLOT_INDEX_FOSSIL_DIRTY, fossilStack.copy());
									}
									break;
								}
							}
						}
					}
				}
				break;
			default:
				break;
		}

		this.researchType = VillagerResearchType.IDLE;
		this.targetCoords = this.villager.getPos();
		this.villager.getNavigator().clearPath();
	}

	private boolean findNearbyChests(int searchXZ, int searchY)
	{
		this.nearChests.clear();

		BlockPos villagerPosition = this.villager.getPos();
		for (int x = villagerPosition.getX() - searchXZ; x < villagerPosition.getX() + searchXZ; x++)
		{
			for (int y = villagerPosition.getY() - searchY; y < villagerPosition.getY() + searchY; y++)
			{
				for (int z = villagerPosition.getZ() - searchXZ; z < villagerPosition.getZ() + searchXZ; z++)
				{
					BlockPos searchingPosition = new BlockPos(x, y, z);
					IBlockState state = this.villager.world.getBlockState(searchingPosition);
					if (state.getBlock() instanceof BlockChest)
					{
						TileEntityChest chest = (TileEntityChest) this.villager.world.getTileEntity(searchingPosition);
						boolean hasFossilDirty = false;
						boolean hasFossilClean = false;
						boolean hasBrush = false;
						boolean hasGlassBottle = false;
						boolean hasDNABottle = false;
						boolean hasFloppyDiskEmpty = false;

						for (int index = 0; index < chest.getSizeInventory(); index++)
						{
							ItemStack stack = chest.getStackInSlot(index);
							if (stack.getItem() instanceof ItemBrush)
								hasBrush = true;
							else if (stack.getItem() instanceof ItemFossilDirty)
								hasFossilDirty = true;
							else if (stack.getItem() instanceof ItemFossilClean)
								hasFossilClean = true;
							else if (stack.getItem() instanceof ItemGlassBottle)
								hasGlassBottle = true;
							else if (stack.getItem() instanceof ItemFloppyDiskEmpty)
								hasFloppyDiskEmpty = true;
						}

						this.nearChests.add(new ContainerInformation(searchingPosition, hasBrush, hasFossilDirty));
					}
				}
			}
		}

		if (!this.nearChests.isEmpty())
		{
			Collections.sort(this.nearChests, this.nearestTargetSorter);
			return true;
		}
		else
			return false;
	}

	private boolean findNearbyCleaningTable(int searchXZ, int searchY)
	{
		this.nearCleaningTables.clear();

		BlockPos villagerPosition = this.villager.getPos();
		for (int x = villagerPosition.getX() - searchXZ; x < villagerPosition.getX() + searchXZ; x++)
		{
			for (int y = villagerPosition.getY() - searchY; y < villagerPosition.getY() + searchY; y++)
			{
				for (int z = villagerPosition.getZ() - searchXZ; z < villagerPosition.getZ() + searchXZ; z++)
				{
					BlockPos searchingPosition = new BlockPos(x, y, z);
					IBlockState state = this.villager.world.getBlockState(searchingPosition);
					if (state.getBlock() instanceof BlockCleaningTable)
					{
						TileCleaningTable cleaningTable = (TileCleaningTable) this.villager.world.getTileEntity(searchingPosition);

						this.nearCleaningTables.add(new ContainerInformation(searchingPosition, cleaningTable.hasBrush(), cleaningTable.hasDirtyFossil()));
					}
				}
			}
		}

		if (!this.nearCleaningTables.isEmpty())
		{
			Collections.sort(this.nearCleaningTables, this.nearestTargetSorter);
			return true;
		}
		else
			return false;
	}

	private boolean villagerHasItems()
	{
		return !this.villager.getVillagerInventory().isEmpty();
	}

	private boolean villagerHasItem(Item item)
	{
		return this.inventoryHasItem(this.villager.getVillagerInventory(), item);
	}

	private boolean villagerHasFossilDirty()
	{
		IInventory inventory = this.villager.getVillagerInventory();
		if (inventory.isEmpty())
			return false;

		boolean hasItem = false;
		for (int index = 0; index < inventory.getSizeInventory(); index++)
		{
			ItemStack stack = inventory.getStackInSlot(index);
			if (stack.getItem() instanceof ItemFossilDirty)
			{
				hasItem = true;
				break;
			}
		}
		return hasItem;
	}

	private boolean villagerHasItemByClass(Item item)
	{
		IInventory inventory = this.villager.getVillagerInventory();
		if (inventory.isEmpty())
			return false;

		boolean hasItem = false;
		for (int index = 0; index < inventory.getSizeInventory(); index++)
		{
			ItemStack stack = inventory.getStackInSlot(index);
			if (stack.getItem().getClass() == item.getClass())
			{
				hasItem = true;
				break;
			}
		}
		return hasItem;
	}

	private boolean inventoryHasItem(IInventory inventory, Item item)
	{
		if (inventory.isEmpty())
			return false;

		boolean hasItem = false;
		for (int index = 0; index < inventory.getSizeInventory(); index++)
		{
			ItemStack stack = inventory.getStackInSlot(index);
			if (stack.getItem() == item)
			{
				hasItem = true;
				break;
			}
		}
		return hasItem;
	}

	private boolean isTargetAlive()
	{
		Block targetBlock = this.villager.world.getBlockState(this.targetCoords).getBlock();
		return targetBlock instanceof BlockChest || targetBlock instanceof BlockCleaningTable;
	}

	private static class ContainerInformation
	{
		public static final int INFO_CHEST_BRUSH = 0;
		public static final int INFO_CHEST_FOSSIL_DIRTY = 1;
		public static final int INFO_CHEST_FOSSIL_CLEAN = 2;
		public static final int INFO_CHEST_GLASS_BOTTLE = 3;
		public static final int INFO_CHEST_DNA_BOTTLE = 4;
		public static final int INFO_CHEST_FLOPPY_DISK = 5;

		public static final int INFO_CLEANING_TABLE_BRUSH = 0;
		public static final int INFO_CLEANING_TABLE_FOSSIL_DIRTY = 1;

		private final List<Boolean> flags;
		private BlockPos position;

		public ContainerInformation(BlockPos position, boolean... flags)
		{
			this.position = position;
			this.flags = new ArrayList<Boolean>(flags.length);
			for (boolean flag : flags)
				this.flags.add(flag);
		}

		public BlockPos getPosition()
		{
			return this.position;
		}

		public int getX()
		{
			return this.position.getX();
		}

		public int getY()
		{
			return this.position.getY();
		}

		public int getZ()
		{
			return this.position.getZ();
		}

		public List<Boolean> getInformations()
		{
			return this.flags;
		}

		public boolean getInformation(int index)
		{
			return this.flags.get(index);
		}
	}

	private static class VillagerDistanceComparator implements Comparator
	{
		private final Entity villager;

		public VillagerDistanceComparator(Entity entity)
		{
			this.villager = entity;
		}

		public int compare(ContainerInformation compare1, ContainerInformation compare2)
		{
			double distanceFrom1 = this.villager.getDistanceSq(compare1.getPosition());
			double distanceFrom2 = this.villager.getDistanceSq(compare2.getPosition());
			return distanceFrom1 < distanceFrom2 ? -1 : (distanceFrom1 > distanceFrom2 ? 1 : 0);
		}

		public int compare(Object compare1, Object compare2)
		{
			return this.compare((ContainerInformation) compare1, (ContainerInformation) compare2);
		}
	}

	private enum VillagerResearchType
	{
		IDLE,
		GRAB_ITEM_FROM_CHEST,
		CLEAN_DIRTY_FOSSIL;
	}
}
