package com.deextinction.entity.ai.animation;

import com.deextinction.entity.EntityDeExtinctedAnimal;
import com.deextinction.entity.ai.DeAIMutex;

public class DeAISound extends DeAIAnimation
{
	private int duration;

	public DeAISound(EntityDeExtinctedAnimal creature, int duration)
	{
		super(creature);
		this.duration = duration;
		this.setMutexBits(DeAIMutex.COMPATIBLE_VANILLA.getMutex());
	}

	@Override
	public int getAnimID()
	{
		return DeAnimationList.SOUND_1;
	}

	@Override
	public boolean isAutomatic()
	{
		return true;
	}

	@Override
	public int getDuration()
	{
		return this.duration;
	}
}
