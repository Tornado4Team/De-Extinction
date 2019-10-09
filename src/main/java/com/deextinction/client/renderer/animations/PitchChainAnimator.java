package com.deextinction.client.renderer.animations;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class PitchChainAnimator
{
	private final EntityLivingBase entity;
	private float pitchVariation;
	private float prevPitch;
	private float pitch;

	public PitchChainAnimator(EntityLivingBase entity)
	{
		this.entity = entity;
		this.pitch = this.prevPitch = 0.0F;
		this.pitchVariation = 0.0F;
	}

	public float getPitch()
	{
		return this.pitch;
	}

	public float getPrevPitch()
	{
		return this.prevPitch;
	}

	public void setPitchVariation(float variation)
	{
		this.pitchVariation = variation;
	}

	public float getAnimation(float partialRenderTicks)
	{
		return this.prevPitch + (this.pitch - this.prevPitch) * partialRenderTicks;
	}

	public void update(int numberOfParentedBoxes, float maxAngle, float angleDecrement)
	{
		if (this.entity.rotationPitch != this.entity.prevRotationPitch)
		{
			this.pitchVariation += (this.entity.prevRotationPitch - this.entity.rotationPitch);
			if (this.pitchVariation > maxAngle)
				this.pitchVariation = maxAngle;
			else if (this.pitchVariation < -maxAngle)
				this.pitchVariation = -maxAngle;
		}

		this.prevPitch = this.pitch;
		if (MathHelper.abs(this.pitchVariation) < angleDecrement)
		{
			this.pitchVariation = 0;
			this.pitch = 0.0F;
		}
		else
		{
			this.pitch = 0.01745329251F * this.pitchVariation / numberOfParentedBoxes;

			if (this.pitchVariation > 0)
				this.pitchVariation -= angleDecrement;
			else
				this.pitchVariation += angleDecrement;
		}
	}
}
