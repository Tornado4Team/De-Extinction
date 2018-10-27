package com.deextinction.deextinction.entity.creature.defectum;

import com.deextinction.deextinction.entity.EntityDeex;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class EntityDefectum extends EntityDeex
{

	public EntityDefectum(World worldIn) {
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
