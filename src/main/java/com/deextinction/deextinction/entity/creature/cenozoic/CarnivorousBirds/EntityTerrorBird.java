package com.deextinction.deextinction.entity.creature.cenozoic.CarnivorousBirds;

import com.deextinction.deextinction.entity.EntityDeex;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityTerrorBird extends EntityDeex
{

	public EntityTerrorBird(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void readEntityFromNBT(NBTTagCompound compound)	
	{
		
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)	
	{
		
	}

	public boolean isMoving() {
		// TODO Auto-generated method stub
		return false;
	}


}
