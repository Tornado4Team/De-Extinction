package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntityArctotherium;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * Arctotherium - Botmon Created using Tabula 7.0.0
 */
public class ModelArctotherium extends ResettableModelBase
{
	public ResettableModelRenderer rear;
	public ResettableModelRenderer leftarm1;
	public ResettableModelRenderer rightarm1;
	public ResettableModelRenderer leftleg1;
	public ResettableModelRenderer rightleg1;
	public ResettableModelRenderer front;
	public ResettableModelRenderer tail;
	public ResettableModelRenderer bellyfur;
	public ResettableModelRenderer chest;
	public ResettableModelRenderer neck;
	public ResettableModelRenderer hump1;
	public ResettableModelRenderer chestfur;
	public ResettableModelRenderer head;
	public ResettableModelRenderer neckfur;
	public ResettableModelRenderer topjaw;
	public ResettableModelRenderer lowerjaw;
	public ResettableModelRenderer leftear;
	public ResettableModelRenderer rightear;
	public ResettableModelRenderer snout;
	public ResettableModelRenderer hump2;
	public ResettableModelRenderer leftarm2;
	public ResettableModelRenderer leftpaw;
	public ResettableModelRenderer armfur;
	public ResettableModelRenderer rightarm2;
	public ResettableModelRenderer rightpaw;
	public ResettableModelRenderer armfur2;
	public ResettableModelRenderer leftleg2;
	public ResettableModelRenderer leftleg3;
	public ResettableModelRenderer leftfoot;
	public ResettableModelRenderer rightleg2;
	public ResettableModelRenderer rightleg3;
	public ResettableModelRenderer rightfoot;
	private Animator animator;

	public ModelArctotherium()
	{
		this.textureWidth = 60;
		this.textureHeight = 200;

		this.armfur = new ResettableModelRenderer(this, 0, 165);
		this.armfur.setRotationPoint(-1.0F, 0.0F, 1.0F);
		this.armfur.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.armfur.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.chestfur = new ResettableModelRenderer(this, 0, 150);
		this.chestfur.setRotationPoint(-3.5F, 1.6F, 0.2F);
		this.chestfur.addBox(0.0F, 0.0F, 0.0F, 7, 2, 10, 0.0F);
		this.chestfur.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.leftarm1 = new ResettableModelRenderer(this, 0, 106);
		this.leftarm1.setRotationPoint(4.8F, 7.8F, -7.5F);
		this.leftarm1.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.leftarm1.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.leftear = new ResettableModelRenderer(this, 13, 93);
		this.leftear.setRotationPoint(3.0F, -2.0F, -1.0F);
		this.leftear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.leftear.setRotateAngle(-0.7853981633974483F, 0.3141592653589793F, 0.0F);

		this.topjaw = new ResettableModelRenderer(this, 0, 87);
		this.topjaw.setRotationPoint(0.0F, 0.2F, -3.7F);
		this.topjaw.addBox(-2.0F, -1.5F, -3.0F, 4, 3, 3, 0.0F);
		this.topjaw.setRotateAngle(0.136659280431156F, 0.0F, 0.0F);

		this.leftfoot = new ResettableModelRenderer(this, 34, 126);
		this.leftfoot.setRotationPoint(0.0F, 5.9F, 0.0F);
		this.leftfoot.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
		this.leftfoot.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.hump1 = new ResettableModelRenderer(this, 9, 165);
		this.hump1.setRotationPoint(-4.0F, -5.0F, -11.0F);
		this.hump1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 4, 0.0F);
		this.hump1.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.neckfur = new ResettableModelRenderer(this, 26, 150);
		this.neckfur.setRotationPoint(-2.0F, 2.9F, -7.0F);
		this.neckfur.addBox(0.0F, 0.0F, 0.0F, 4, 2, 7, 0.0F);
		this.neckfur.setRotateAngle(0.0F, 0.0F, -0.013688859694109504F);

		this.rightarm1 = new ResettableModelRenderer(this, 0, 106);
		this.rightarm1.setRotationPoint(-4.8F, 7.8F, -7.5F);
		this.rightarm1.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.rightarm1.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.front = new ResettableModelRenderer(this, 0, 25);
		this.front.setRotationPoint(0.0F, 0.0F, 0.7F);
		this.front.addBox(-4.5F, -5.0F, -11.0F, 9, 9, 11, 0.0F);
		this.front.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.rightpaw = new ResettableModelRenderer(this, 32, 106);
		this.rightpaw.setRotationPoint(0.0F, 8.0F, 0.3F);
		this.rightpaw.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
		this.rightpaw.setRotateAngle(0.17453292519943295F, 0.0F, 0.0F);

		this.armfur2 = new ResettableModelRenderer(this, 0, 165);
		this.armfur2.setRotationPoint(-1.0F, 0.0F, 1.0F);
		this.armfur2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
		this.armfur2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.rightleg3 = new ResettableModelRenderer(this, 40, 115);
		this.rightleg3.setRotationPoint(0.0F, 3.7F, 0.5F);
		this.rightleg3.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
		this.rightleg3.setRotateAngle(-0.17453292519943295F, 0.0F, 0.0F);

		this.rightleg1 = new ResettableModelRenderer(this, 0, 120);
		this.rightleg1.setRotationPoint(-5.0F, 6.0F, 9.5F);
		this.rightleg1.addBox(-2.5F, 0.0F, -3.0F, 5, 7, 5, 0.0F);
		this.rightleg1.setRotateAngle(-0.08726646259971647F, 0.0F, 0.0F);

		this.chest = new ResettableModelRenderer(this, 0, 47);
		this.chest.setRotationPoint(0.0F, 3.8F, -11.0F);
		this.chest.addBox(-4.0F, 0.0F, 0.0F, 8, 2, 10, 0.0F);
		this.chest.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.leftleg2 = new ResettableModelRenderer(this, 21, 120);
		this.leftleg2.setRotationPoint(0.0F, 6.5F, -0.5F);
		this.leftleg2.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 4, 0.0F);
		this.leftleg2.setRotateAngle(0.17453292519943295F, 0.0F, 0.0F);

		this.rear = new ResettableModelRenderer(this, 0, 0);
		this.rear.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.rear.addBox(-5.0F, -5.0F, 0.0F, 10, 11, 12, 0.0F);
		this.rear.setRotateAngle(-0.04363323129985824F, 0.0F, 0.0F);

		this.leftpaw = new ResettableModelRenderer(this, 32, 106);
		this.leftpaw.setRotationPoint(0.0F, 8.0F, 0.3F);
		this.leftpaw.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
		this.leftpaw.setRotateAngle(0.17453292519943295F, 0.0F, 0.0F);

		this.lowerjaw = new ResettableModelRenderer(this, 0, 101);
		this.lowerjaw.setRotationPoint(0.0F, 2.2F, -3.9F);
		this.lowerjaw.addBox(-1.5F, -0.5F, -2.0F, 3, 1, 2, 0.0F);
		this.lowerjaw.setRotateAngle(0.045553093477052F, 0.0F, 0.0F);

		this.leftleg1 = new ResettableModelRenderer(this, 0, 120);
		this.leftleg1.setRotationPoint(5.0F, 6.0F, 9.5F);
		this.leftleg1.addBox(-2.5F, 0.0F, -3.0F, 5, 7, 5, 0.0F);
		this.leftleg1.setRotateAngle(-0.08726646259971647F, 0.0F, 0.0F);

		this.rightfoot = new ResettableModelRenderer(this, 34, 126);
		this.rightfoot.setRotationPoint(0.0F, 5.9F, 0.0F);
		this.rightfoot.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
		this.rightfoot.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.hump2 = new ResettableModelRenderer(this, 12, 172);
		this.hump2.setRotationPoint(0.5F, 0.0F, 4.0F);
		this.hump2.addBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
		this.hump2.setRotateAngle(-0.5462880558742251F, 0.0F, 0.0F);

		this.rightear = new ResettableModelRenderer(this, 16, 87);
		this.rightear.setRotationPoint(-3.0F, -2.0F, -1.0F);
		this.rightear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.rightear.setRotateAngle(-0.7853981633974483F, -0.3141592653589793F, 0.0F);

		this.tail = new ResettableModelRenderer(this, 0, 134);
		this.tail.setRotationPoint(0.0F, -3.5F, 10.7F);
		this.tail.addBox(-1.0F, -1.5F, 0.0F, 2, 2, 4, 0.0F);
		this.tail.setRotateAngle(-0.9105382707654417F, 0.0F, 0.0F);

		this.neck = new ResettableModelRenderer(this, 0, 61);
		this.neck.setRotationPoint(0.0F, -1.7F, -10.0F);
		this.neck.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 7, 0.0F);
		this.neck.setRotateAngle(-0.17453292519943295F, 0.0F, 0.0F);

		this.leftleg3 = new ResettableModelRenderer(this, 40, 115);
		this.leftleg3.setRotationPoint(0.0F, 3.7F, 0.5F);
		this.leftleg3.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
		this.leftleg3.setRotateAngle(-0.17453292519943295F, 0.0F, 0.0F);

		this.rightleg2 = new ResettableModelRenderer(this, 21, 120);
		this.rightleg2.setRotationPoint(0.0F, 6.5F, -0.5F);
		this.rightleg2.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 4, 0.0F);
		this.rightleg2.setRotateAngle(0.17453292519943295F, 0.0F, 0.0F);

		this.leftarm2 = new ResettableModelRenderer(this, 18, 106);
		this.leftarm2.setRotationPoint(0.0F, 6.5F, 0.5F);
		this.leftarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.leftarm2.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.rightarm2 = new ResettableModelRenderer(this, 18, 106);
		this.rightarm2.setRotationPoint(0.0F, 6.5F, 0.5F);
		this.rightarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.rightarm2.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.head = new ResettableModelRenderer(this, 0, 76);
		this.head.setRotationPoint(0.0F, -0.3F, -5.6F);
		this.head.addBox(-3.5F, -3.0F, -4.0F, 7, 6, 4, 0.0F);
		this.head.setRotateAngle(0.3141592653589793F, 0.0F, 0.0F);

		this.snout = new ResettableModelRenderer(this, 0, 94);
		this.snout.setRotationPoint(-2.0F, -1.5F, -3.0F);
		this.snout.addBox(0.5F, 0.0F, 0.0F, 3, 1, 4, 0.0F);
		this.snout.setRotateAngle(0.36425021489121656F, 0.0F, 0.0F);

		this.bellyfur = new ResettableModelRenderer(this, 3, 135);
		this.bellyfur.setRotationPoint(-4.5F, 6.0F, 0.0F);
		this.bellyfur.addBox(0.0F, 0.0F, 0.0F, 9, 2, 11, 0.0F);
		this.bellyfur.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.leftarm2.addChild(this.armfur);
		this.chest.addChild(this.chestfur);
		this.head.addChild(this.leftear);
		this.head.addChild(this.topjaw);
		this.leftleg3.addChild(this.leftfoot);
		this.front.addChild(this.hump1);
		this.neck.addChild(this.neckfur);
		this.rear.addChild(this.front);
		this.rightarm2.addChild(this.rightpaw);
		this.rightarm2.addChild(this.armfur2);
		this.rightleg2.addChild(this.rightleg3);
		this.front.addChild(this.chest);
		this.leftleg1.addChild(this.leftleg2);
		this.leftarm2.addChild(this.leftpaw);
		this.head.addChild(this.lowerjaw);
		this.rightleg3.addChild(this.rightfoot);
		this.hump1.addChild(this.hump2);
		this.head.addChild(this.rightear);
		this.rear.addChild(this.tail);
		this.front.addChild(this.neck);
		this.leftleg2.addChild(this.leftleg3);
		this.rightleg1.addChild(this.rightleg2);
		this.leftarm1.addChild(this.leftarm2);
		this.rightarm1.addChild(this.rightarm2);
		this.neck.addChild(this.head);
		this.topjaw.addChild(this.snout);
		this.rear.addChild(this.bellyfur);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityArctotherium animal = (EntityArctotherium) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.leftarm1.render(scale);
		this.rightarm1.render(scale);
		this.rightleg1.render(scale);
		this.rear.render(scale);
		this.leftleg1.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();
		EntityArctotherium animal = (EntityArctotherium) entity;
		float sittingProgress = animal.getSittingProgress(partialRenderTicks);
		if (sittingProgress > 0.001F)
		{
			this.rear.rotationPointY += 7.0F * sittingProgress;

			this.leftleg1.rotateAngleX -= 0.8F * sittingProgress;
			this.leftleg1.rotationPointY += 10.0F * sittingProgress;
			this.leftleg2.rotateAngleX += 1.0F * sittingProgress;
			this.leftleg2.rotationPointY -= 2.0F * sittingProgress;
			this.leftleg2.rotationPointZ += 2.0F * sittingProgress;
			this.leftleg3.rotateAngleX -= 1.8F * sittingProgress;
			this.leftleg3.rotationPointZ -= 1.5F * sittingProgress;
			this.leftfoot.rotateAngleX += 1.6F * sittingProgress;
			this.leftfoot.rotationPointZ -= 1.4F * sittingProgress;

			this.rightleg1.rotateAngleX -= 0.8F * sittingProgress;
			this.rightleg1.rotationPointY += 10.0F * sittingProgress;
			this.rightleg2.rotateAngleX += 1.0F * sittingProgress;
			this.rightleg2.rotationPointY -= 2.0F * sittingProgress;
			this.rightleg2.rotationPointZ += 2.0F * sittingProgress;
			this.rightleg3.rotateAngleX -= 1.8F * sittingProgress;
			this.rightleg3.rotationPointZ -= 1.5F * sittingProgress;
			this.rightfoot.rotateAngleX += 1.6F * sittingProgress;
			this.rightfoot.rotationPointZ -= 1.4F * sittingProgress;

			this.leftarm1.rotateAngleX += 0.8F * sittingProgress;
			this.leftarm1.rotationPointY += 10.0F * sittingProgress;
			this.leftarm2.rotateAngleX -= 2.4F * sittingProgress;
			this.leftarm2.rotationPointZ -= 1.5F * sittingProgress;
			this.leftpaw.rotateAngleX += 1.6F * sittingProgress;
			this.leftpaw.rotationPointZ -= 1.4F * sittingProgress;

			this.rightarm1.rotateAngleX += 0.8F * sittingProgress;
			this.rightarm1.rotationPointY += 10.0F * sittingProgress;
			this.rightarm2.rotateAngleX -= 2.4F * sittingProgress;
			this.rightarm2.rotationPointZ -= 1.5F * sittingProgress;
			this.rightpaw.rotateAngleX += 1.6F * sittingProgress;
			this.rightpaw.rotationPointZ -= 1.4F * sittingProgress;

			if (sittingProgress > 0.5F)
			{
				sittingProgress = (sittingProgress - 0.5F) * 2.0F;

				this.rightarm2.rotationPointY += 3.0F * sittingProgress;
				this.leftarm2.rotationPointY += 3.0F * sittingProgress;
			}
		}
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityArctotherium animal)
	{
		float animSpeed = 0.375F;

		float headY = yaw / 57.2957795131F / 2.0F;
		this.neck.rotateAngleY += headY;
		this.head.rotateAngleY += headY;

		float headX = pitch / 57.2957795131F / 2.0F;
		this.neck.rotateAngleY += headX;
		this.head.rotateAngleY += headX;

		if (animal.isSitting())
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
			this.rear.rotateAngleX += naturalMovement;
			this.front.rotateAngleX -= naturalMovement;
			this.neck.rotateAngleX += naturalMovement;
			this.tail.rotateAngleX -= naturalMovement;
		}
		else
		{
			if (walkSpeed > 0.001F)
			{
				float bodyBob1 = this.getRotateAngleComplex(time, walkSpeed, animSpeed, 0.5F, 0.5F);
				this.rear.rotationPointX -= bodyBob1;
				this.rightleg1.rotationPointX -= bodyBob1;
				this.leftleg1.rotationPointX -= bodyBob1;
				this.rightarm1.rotationPointX -= bodyBob1;
				this.leftarm1.rotationPointX -= bodyBob1;

				float bodyBob2 = this.getRotateAngle(time, walkSpeed, 2.0F * animSpeed, 1.0F);
				this.rear.rotationPointY -= bodyBob2;
				this.rightleg1.rotationPointY -= bodyBob2;
				this.leftleg1.rotationPointY -= bodyBob2;
				this.rightarm1.rotationPointY -= bodyBob2;
				this.leftarm1.rotationPointY -= bodyBob2;

				float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.0F, -0.2F);
				float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 1.0F, 1.5F, 1.0F);
				float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, -1.5F, -0.8F);
				float lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 1.0F, -1.0F, 0.4F);

				this.leftleg1.rotationPointY += 0.8F + lleg3;
				this.leftleg1.rotateAngleX += lleg1;
				this.leftleg2.rotateAngleX += lleg2;
				this.leftleg3.rotateAngleX += lleg3;
				this.leftfoot.rotateAngleX += lfoot;

				this.rightarm1.rotateAngleX += 0.8F * lleg1;
				this.rightarm2.rotateAngleX += lleg2;
				this.rightpaw.rotateAngleX += lfoot;

				float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.0F, -0.2F);
				float rleg2 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 1.5F, 0.8F);
				float rleg3 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, -1.5F, -0.8F);
				float rfoot = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 1.0F, -1.0F, 0.4F);

				this.rightleg1.rotationPointY += 0.8F + rleg3;
				this.rightleg1.rotateAngleX += rleg1;
				this.rightleg2.rotateAngleX += rleg2;
				this.rightleg3.rotateAngleX += rleg3;
				this.rightfoot.rotateAngleX += rfoot;

				this.leftarm1.rotateAngleX += 0.8F * rleg1;
				this.leftarm2.rotateAngleX += rleg2;
				this.leftpaw.rotateAngleX += rfoot;
			}
			else
			{
				float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
				this.rear.rotateAngleX += naturalMovement;
				this.neck.rotateAngleX -= naturalMovement;
				this.tail.rotateAngleX += naturalMovement;
			}
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityArctotherium animal)
	{
		if (animal.getAnimID() == DeAnimationList.SOUND_1)
		{
			this.animator.update(animal);
			this.animator.setAnim(DeAnimationList.SOUND_1);

			this.animator.startPhase(5);
			this.animator.rotate(this.lowerjaw, ResettableModelBase.RAD_45_DEGREES, 0.0F, 0.0F);

			this.animator.endPhase();
			this.animator.resetPhase(10);
		}
	}

	private void resetPose()
	{
		this.rear.resetParameters();
		this.leftarm1.resetParameters();
		this.rightarm1.resetParameters();
		this.leftleg1.resetParameters();
		this.rightleg1.resetParameters();
		this.front.resetParameters();
		this.tail.resetParameters();
		this.bellyfur.resetParameters();
		this.chest.resetParameters();
		this.neck.resetParameters();
		this.hump1.resetParameters();
		this.chestfur.resetParameters();
		this.head.resetParameters();
		this.neckfur.resetParameters();
		this.topjaw.resetParameters();
		this.lowerjaw.resetParameters();
		this.leftear.resetParameters();
		this.rightear.resetParameters();
		this.snout.resetParameters();
		this.hump2.resetParameters();
		this.leftarm2.resetParameters();
		this.leftpaw.resetParameters();
		this.armfur.resetParameters();
		this.rightarm2.resetParameters();
		this.rightpaw.resetParameters();
		this.armfur2.resetParameters();
		this.leftleg2.resetParameters();
		this.leftleg3.resetParameters();
		this.leftfoot.resetParameters();
		this.rightleg2.resetParameters();
		this.rightleg3.resetParameters();
		this.rightfoot.resetParameters();
	}
}
