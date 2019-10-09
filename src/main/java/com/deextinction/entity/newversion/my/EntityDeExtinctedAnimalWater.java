package com.deextinction.entity.newversion.my;

import com.deextinction.entity.EntityDeExtinctedAnimal;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityDeExtinctedAnimalWater extends EntityDeExtinctedAnimal
{
	protected EntityDeExtinctedAnimalWater(World world)
	{
		super(world);
	}

	@Override
	public void onUpdate()
	{
		int prevAir = this.getAir();
		super.onUpdate();
		this.updateAir(prevAir);
	}

	protected void updateAir(int prevAir)
	{
		if (this.isEntityAlive() && !this.isInWater())
		{
			this.setAir(prevAir - 1);
			if (this.getAir() == -20)
			{
				this.setAir(0);
				this.attackEntityFrom(DamageSource.DROWN, 2.0F);
			}
		}
		else
			this.setAir(this.getMaxAir());
	}

	@Override
	public boolean isNotColliding()
	{
		return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
	}

	@Override
	public boolean canBreatheUnderwater()
	{
		return true;
	}

	@Override
	public int getTalkInterval()
	{
		return 120;
	}

	@Override
	protected int getExperiencePoints(EntityPlayer player)
	{
		return 1 + this.world.rand.nextInt(3);
	}

	@Override
	public boolean isPushedByWater()
	{
		return false;
	}

	@Override
	public boolean canBeLeashedTo(EntityPlayer player)
	{
		return false;
	}

	public int getMaxAir()
	{
		return 300;
	}

	// MY CODE BELOW =========================================================

	@Override
	public boolean isInWater()
	{
		return super.isInWater() || this.isInsideOfMaterial(Material.CORAL);
	}

	protected boolean isInLiquid()
	{
		return this.isInWater() || this.isInLava();
	}

	@Override
	public boolean shouldDismountInWater(Entity rider)
	{
		return false;
	}

	@Override
	protected boolean canTriggerWalking()
	{
		return false;
	}

	@Override
	public boolean isOnLadder()
	{
		return false;
	}

	protected boolean shouldJumpOnLand()
	{
		return true;
	}
}
