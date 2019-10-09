package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntityToxodon;

import net.minecraft.entity.Entity;

/**
 * Toxodon - Bizarre Created using Tabula 7.0.0
 */
public class ModelToxodon extends ResettableModelBase
{
	public ResettableModelRenderer body_1;
	public ResettableModelRenderer Back_Leg_Left_1;
	public ResettableModelRenderer Back_Leg_Right_1;
	public ResettableModelRenderer Front_Leg_Left_1;
	public ResettableModelRenderer Front_Leg_Right_1;
	public ResettableModelRenderer Body_2;
	public ResettableModelRenderer Body_1_up;
	public ResettableModelRenderer Tail_1;
	public ResettableModelRenderer Neck_Mid;
	public ResettableModelRenderer Neck_Up;
	public ResettableModelRenderer Neck_Bottom;
	public ResettableModelRenderer Head_1;
	public ResettableModelRenderer Left_Ear;
	public ResettableModelRenderer Right_Ear;
	public ResettableModelRenderer Upper_Jaw_1;
	public ResettableModelRenderer lower_jaw_1;
	public ResettableModelRenderer Upper_Jaw_2;
	public ResettableModelRenderer Upper_Jaw_3;
	public ResettableModelRenderer Lower_Jaw_2;
	public ResettableModelRenderer Tail_2;
	public ResettableModelRenderer Back_Leg_Left_2;
	public ResettableModelRenderer Left_Back_Foot;
	public ResettableModelRenderer Back_Leg_Right_2;
	public ResettableModelRenderer Right_Back_Foot;
	public ResettableModelRenderer Front_Leg_Left_2;
	public ResettableModelRenderer Front_Left_Foot;
	public ResettableModelRenderer Front_Leg_Right_2;
	public ResettableModelRenderer Front_Right_Foot;
	private Animator animator;

	public ModelToxodon()
	{
		this.textureWidth = 200;
		this.textureHeight = 50;

		this.Front_Right_Foot = new ResettableModelRenderer(this, 128, 21);
		this.Front_Right_Foot.mirror = true;
		this.Front_Right_Foot.setRotationPoint(0.0F, 4.5F, -0.5F);
		this.Front_Right_Foot.addBox(-2.0F, 0.0F, -3.5F, 4, 2, 4, 0.0F);
		this.Front_Right_Foot.setRotateAngle(0.4363323129985824F, 0.0F, 0.0F);

		this.Neck_Bottom = new ResettableModelRenderer(this, 171, 11);
		this.Neck_Bottom.setRotationPoint(0.0F, 5.2F, 0.0F);
		this.Neck_Bottom.addBox(-2.5F, -3.0F, -9.0F, 5, 3, 9, 0.0F);
		this.Neck_Bottom.setRotateAngle(-0.19268434942017396F, 0.0F, 0.0F);

		this.Front_Leg_Left_2 = new ResettableModelRenderer(this, 0, 4);
		this.Front_Leg_Left_2.setRotationPoint(0.0F, 7.0F, 1.0F);
		this.Front_Leg_Left_2.addBox(-1.5F, -1.0F, -2.5F, 3, 7, 3, 0.0F);
		this.Front_Leg_Left_2.setRotateAngle(-0.8726646259971648F, -0.08726646259971647F, 0.08726646259971647F);

		this.Left_Back_Foot = new ResettableModelRenderer(this, 181, 23);
		this.Left_Back_Foot.setRotationPoint(0.0F, 6.7F, 3.5F);
		this.Left_Back_Foot.addBox(-2.0F, 0.0F, -4.5F, 4, 3, 5, 0.0F);
		this.Left_Back_Foot.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.Tail_1 = new ResettableModelRenderer(this, 0, 0);
		this.Tail_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Tail_1.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, 0.0F);
		this.Tail_1.setRotateAngle(0.594982742004867F, 0.0F, 0.0F);

		this.Lower_Jaw_2 = new ResettableModelRenderer(this, 115, 18);
		this.Lower_Jaw_2.setRotationPoint(0.0F, 2.0F, 0.0F);
		this.Lower_Jaw_2.addBox(-1.5F, -1.0F, -5.0F, 3, 1, 5, 0.0F);
		this.Lower_Jaw_2.setRotateAngle(-0.20245819323134223F, 0.0F, 0.0F);

		this.Body_2 = new ResettableModelRenderer(this, 71, 0);
		this.Body_2.setRotationPoint(0.0F, 9.0F, -14.0F);
		this.Body_2.addBox(-3.5F, -14.0F, -6.0F, 7, 14, 6, 0.0F);
		this.Body_2.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.Upper_Jaw_2 = new ResettableModelRenderer(this, 183, 0);
		this.Upper_Jaw_2.setRotationPoint(0.0F, -2.0F, 0.4F);
		this.Upper_Jaw_2.addBox(-2.5F, 0.0F, -3.0F, 5, 2, 3, 0.0F);
		this.Upper_Jaw_2.setRotateAngle(0.16755160819145562F, 0.0F, 0.0F);

		this.Head_1 = new ResettableModelRenderer(this, 46, 15);
		this.Head_1.setRotationPoint(0.0F, -3.4F, -5.5F);
		this.Head_1.addBox(-3.5F, 0.0F, -6.0F, 7, 7, 6, 0.0F);
		this.Head_1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.Left_Ear = new ResettableModelRenderer(this, 8, 0);
		this.Left_Ear.setRotationPoint(3.0F, 1.0F, -2.0F);
		this.Left_Ear.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
		this.Left_Ear.setRotateAngle(-0.40980330836826856F, 0.0F, 0.8651597102135892F);

		this.Back_Leg_Left_2 = new ResettableModelRenderer(this, 167, 23);
		this.Back_Leg_Left_2.setRotationPoint(1.5F, 7.0F, -2.6F);
		this.Back_Leg_Left_2.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 4, 0.0F);
		this.Back_Leg_Left_2.setRotateAngle(0.6108652381980153F, 0.0F, 0.05131268000863328F);

		this.Front_Leg_Left_1 = new ResettableModelRenderer(this, 151, 0);
		this.Front_Leg_Left_1.setRotationPoint(3.0F, 12.3F, -7.5F);
		this.Front_Leg_Left_1.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.Front_Leg_Left_1.setRotateAngle(0.4363323129985824F, 0.2617993877991494F, -0.08726646259971647F);

		this.Neck_Up = new ResettableModelRenderer(this, 143, 11);
		this.Neck_Up.setRotationPoint(0.0F, -7.0F, 0.0F);
		this.Neck_Up.addBox(-3.0F, 0.0F, -8.0F, 6, 6, 8, 0.0F);
		this.Neck_Up.setRotateAngle(0.5113814708343385F, 0.0F, 0.0F);

		this.Upper_Jaw_1 = new ResettableModelRenderer(this, 92, 18);
		this.Upper_Jaw_1.setRotationPoint(0.0F, 2.0F, -6.0F);
		this.Upper_Jaw_1.addBox(-3.0F, 0.0F, -5.0F, 6, 3, 5, 0.0F);
		this.Upper_Jaw_1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.Back_Leg_Right_2 = new ResettableModelRenderer(this, 110, 24);
		this.Back_Leg_Right_2.mirror = true;
		this.Back_Leg_Right_2.setRotationPoint(-1.5F, 7.0F, -2.6F);
		this.Back_Leg_Right_2.addBox(-1.5F, 0.0F, 0.0F, 3, 7, 4, 0.0F);
		this.Back_Leg_Right_2.setRotateAngle(0.6108652381980153F, 0.0F, 0.0F);

		this.Front_Leg_Right_1 = new ResettableModelRenderer(this, 167, 0);
		this.Front_Leg_Right_1.mirror = true;
		this.Front_Leg_Right_1.setRotationPoint(-3.0F, 12.3F, -7.5F);
		this.Front_Leg_Right_1.addBox(-2.0F, 0.0F, -2.0F, 4, 7, 4, 0.0F);
		this.Front_Leg_Right_1.setRotateAngle(0.4363323129985824F, -0.17453292519943295F, 0.08726646259971647F);

		this.body_1 = new ResettableModelRenderer(this, 0, 0);
		this.body_1.setRotationPoint(0.0F, 5.0F, 8.0F);
		this.body_1.addBox(-4.0F, -1.0F, -14.0F, 8, 10, 15, 0.0F);
		this.body_1.setRotateAngle(0.13962634015954636F, 0.0F, 0.0F);

		this.Body_1_up = new ResettableModelRenderer(this, 97, 0);
		this.Body_1_up.setRotationPoint(0.0F, -1.0F, 0.0F);
		this.Body_1_up.addBox(-3.0F, 0.0F, -14.0F, 6, 4, 14, 0.0F);
		this.Body_1_up.setRotateAngle(-0.296705972839036F, 0.0F, 0.0F);

		this.Back_Leg_Left_1 = new ResettableModelRenderer(this, 31, 0);
		this.Back_Leg_Left_1.setRotationPoint(3.0F, 10.0F, 7.0F);
		this.Back_Leg_Left_1.addBox(-0.5F, -2.0F, -3.0F, 4, 9, 6, 0.0F);
		this.Back_Leg_Left_1.setRotateAngle(-0.3490658503988659F, -0.13962634015954636F, 0.0F);

		this.Neck_Mid = new ResettableModelRenderer(this, 123, 0);
		this.Neck_Mid.setRotationPoint(0.0F, -7.0F, -6.0F);
		this.Neck_Mid.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 8, 0.0F);
		this.Neck_Mid.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.Back_Leg_Right_1 = new ResettableModelRenderer(this, 51, 0);
		this.Back_Leg_Right_1.mirror = true;
		this.Back_Leg_Right_1.setRotationPoint(-3.0F, 10.0F, 7.0F);
		this.Back_Leg_Right_1.addBox(-3.5F, -2.0F, -3.0F, 4, 9, 6, 0.0F);
		this.Back_Leg_Right_1.setRotateAngle(-0.3490658503988659F, 0.13962634015954636F, 0.0F);

		this.Front_Leg_Right_2 = new ResettableModelRenderer(this, 72, 20);
		this.Front_Leg_Right_2.mirror = true;
		this.Front_Leg_Right_2.setRotationPoint(0.0F, 7.0F, 1.0F);
		this.Front_Leg_Right_2.addBox(-1.5F, -1.0F, -2.5F, 3, 7, 3, 0.0F);
		this.Front_Leg_Right_2.setRotateAngle(-0.8726646259971648F, 0.0F, -0.08726646259971647F);

		this.Tail_2 = new ResettableModelRenderer(this, 123, 0);
		this.Tail_2.setRotationPoint(0.0F, 1.8F, 0.4F);
		this.Tail_2.addBox(-0.5F, 0.0F, -0.5F, 1, 6, 1, 0.0F);
		this.Tail_2.setRotateAngle(-0.4476769531365455F, 0.0F, 0.0F);

		this.Front_Left_Foot = new ResettableModelRenderer(this, 163, 11);
		this.Front_Left_Foot.setRotationPoint(0.0F, 4.5F, -0.5F);
		this.Front_Left_Foot.addBox(-2.0F, 0.0F, -3.5F, 4, 2, 4, 0.0F);
		this.Front_Left_Foot.setRotateAngle(0.4363323129985824F, 0.0F, 0.0F);

		this.Right_Back_Foot = new ResettableModelRenderer(this, 0, 25);
		this.Right_Back_Foot.mirror = true;
		this.Right_Back_Foot.setRotationPoint(0.0F, 6.7F, 3.5F);
		this.Right_Back_Foot.addBox(-2.0F, 0.0F, -4.5F, 4, 3, 5, 0.0F);
		this.Right_Back_Foot.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.Upper_Jaw_3 = new ResettableModelRenderer(this, 183, 5);
		this.Upper_Jaw_3.setRotationPoint(0.0F, 0.0F, -2.9F);
		this.Upper_Jaw_3.addBox(-2.5F, 0.0F, -3.0F, 5, 2, 3, 0.0F);
		this.Upper_Jaw_3.setRotateAngle(0.39444441095071847F, 0.0F, 0.0F);

		this.Right_Ear = new ResettableModelRenderer(this, 31, 0);
		this.Right_Ear.setRotationPoint(-3.0F, 1.0F, -2.0F);
		this.Right_Ear.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 1, 0.0F);
		this.Right_Ear.setRotateAngle(-0.40980330836826856F, 0.0F, -0.8651597102135892F);

		this.lower_jaw_1 = new ResettableModelRenderer(this, 91, 0);
		this.lower_jaw_1.setRotationPoint(0.0F, 5.0F, -5.7F);
		this.lower_jaw_1.addBox(-2.0F, 0.0F, -5.0F, 4, 1, 5, 0.0F);
		this.lower_jaw_1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.Front_Leg_Right_2.addChild(this.Front_Right_Foot);
		this.Neck_Mid.addChild(this.Neck_Bottom);
		this.Front_Leg_Left_1.addChild(this.Front_Leg_Left_2);
		this.Back_Leg_Left_2.addChild(this.Left_Back_Foot);
		this.body_1.addChild(this.Tail_1);
		this.lower_jaw_1.addChild(this.Lower_Jaw_2);
		this.body_1.addChild(this.Body_2);
		this.Upper_Jaw_1.addChild(this.Upper_Jaw_2);
		this.Neck_Mid.addChild(this.Head_1);
		this.Head_1.addChild(this.Left_Ear);
		this.Back_Leg_Left_1.addChild(this.Back_Leg_Left_2);
		this.Neck_Mid.addChild(this.Neck_Up);
		this.Head_1.addChild(this.Upper_Jaw_1);
		this.Back_Leg_Right_1.addChild(this.Back_Leg_Right_2);
		this.body_1.addChild(this.Body_1_up);
		this.Body_2.addChild(this.Neck_Mid);
		this.Front_Leg_Right_1.addChild(this.Front_Leg_Right_2);
		this.Tail_1.addChild(this.Tail_2);
		this.Front_Leg_Left_2.addChild(this.Front_Left_Foot);
		this.Back_Leg_Right_2.addChild(this.Right_Back_Foot);
		this.Upper_Jaw_2.addChild(this.Upper_Jaw_3);
		this.Head_1.addChild(this.Right_Ear);
		this.Head_1.addChild(this.lower_jaw_1);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityToxodon animal = (EntityToxodon) entity;
		this.resetPose();
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.Front_Leg_Left_1.render(scale);
		this.Front_Leg_Right_1.render(scale);
		this.body_1.render(scale);
		this.Back_Leg_Left_1.render(scale);
		this.Back_Leg_Right_1.render(scale);
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityToxodon animal)
	{
		float animSpeed = 0.35F;

		if (animal.isSitting())
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
			this.body_1.rotateAngleX += naturalMovement;
			this.Neck_Mid.rotateAngleX -= naturalMovement;
			this.Tail_1.rotateAngleX += 0.5F * naturalMovement;
			this.Tail_2.rotateAngleX += 0.5F * naturalMovement;

			float headY = yaw / 57.2957795131F / 2.0F;
			this.Neck_Mid.rotateAngleY += headY;
			this.Head_1.rotateAngleY += headY;

			float headX = pitch / 57.2957795131F / 2.0F;
			this.Neck_Mid.rotateAngleY += headX;
			this.Head_1.rotateAngleY += headX;
		}
		else
		{
			if (walkSpeed > 0.001F)
			{
				float bodyBob1 = this.getRotateAngleComplex(time, walkSpeed, animSpeed, 0.5F, 0.5F);
				this.body_1.rotationPointX -= bodyBob1;
				this.Front_Leg_Left_1.rotationPointX -= bodyBob1;
				this.Front_Leg_Right_1.rotationPointX -= bodyBob1;
				this.Back_Leg_Left_1.rotationPointX -= bodyBob1;
				this.Back_Leg_Right_1.rotationPointX -= bodyBob1;

				float bodyBob2 = this.getRotateAngle(time, walkSpeed, 2.0F * animSpeed, 1.0F);
				this.body_1.rotationPointY -= bodyBob2;
				this.Front_Leg_Left_1.rotationPointY -= bodyBob2;
				this.Front_Leg_Right_1.rotationPointY -= bodyBob2;
				this.Back_Leg_Left_1.rotationPointY -= bodyBob2;
				this.Back_Leg_Right_1.rotationPointY -= bodyBob2;

				if (animal.getAnimID() != DeAnimationList.ATTACKING)
				{
					float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.4F);
					float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 0.8F);
					float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

					float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.4F);
					float rleg2 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 0.8F);
					float rleg3 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

					this.Back_Leg_Left_1.rotateAngleX += rleg1;
					this.Back_Leg_Left_1.rotationPointY += 3.0F * rleg2;
					this.Back_Leg_Left_2.rotationPointZ += 3.0F * rleg2;
					this.Back_Leg_Left_2.rotateAngleX += rleg2;

					this.Back_Leg_Right_1.rotateAngleX += lleg1;
					this.Back_Leg_Right_1.rotationPointY += 3.0F * lleg2;
					this.Back_Leg_Right_2.rotationPointZ += 3.0F * lleg2;
					this.Back_Leg_Right_2.rotateAngleX += lleg2;

					this.Front_Leg_Left_1.rotateAngleX += lleg1;
					this.Front_Leg_Left_2.rotateAngleX += lleg3;

					this.Front_Leg_Right_1.rotateAngleX += rleg1;
					this.Front_Leg_Right_2.rotateAngleX += rleg3;

					float headY = yaw / 57.2957795131F / 2.0F;
					this.Neck_Mid.rotateAngleY += headY;
					this.Head_1.rotateAngleY += headY;

					float headX = pitch / 57.2957795131F / 2.0F;
					this.Neck_Mid.rotateAngleY += headX;
					this.Head_1.rotateAngleY += headX;
				}
			}
			else
			{
				float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
				this.body_1.rotateAngleX += naturalMovement;
				this.Neck_Mid.rotateAngleX -= naturalMovement;
				this.Tail_1.rotateAngleX += 0.5F * naturalMovement;
				this.Tail_2.rotateAngleX += 0.5F * naturalMovement;

				float headY = yaw / 57.2957795131F / 2.0F;
				this.Neck_Mid.rotateAngleY += headY;
				this.Head_1.rotateAngleY += headY;

				float headX = pitch / 57.2957795131F / 2.0F;
				this.Neck_Mid.rotateAngleY += headX;
				this.Head_1.rotateAngleY += headX;
			}
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityToxodon animal)
	{
		if (animal.getAnimID() == DeAnimationList.SOUND_1)
		{
			this.animator.update(animal);
			this.animator.setAnim(DeAnimationList.SOUND_1);

			this.animator.startPhase(5);
			this.animator.rotate(this.lower_jaw_1, ResettableModelBase.RAD_45_DEGREES, 0.0F, 0.0F);

			this.animator.endPhase();
			this.animator.resetPhase(10);
		}
	}

	private void resetPose()
	{
		this.body_1.resetParameters();
		this.Back_Leg_Left_1.resetParameters();
		this.Back_Leg_Right_1.resetParameters();
		this.Front_Leg_Left_1.resetParameters();
		this.Front_Leg_Right_1.resetParameters();
		this.Body_2.resetParameters();
		this.Body_1_up.resetParameters();
		this.Tail_1.resetParameters();
		this.Neck_Mid.resetParameters();
		this.Head_1.resetParameters();
		this.lower_jaw_1.resetParameters();
		this.Tail_2.resetParameters();
		this.Back_Leg_Left_2.resetParameters();
		this.Left_Back_Foot.resetParameters();
		this.Back_Leg_Right_2.resetParameters();
		this.Right_Back_Foot.resetParameters();
		this.Front_Leg_Left_2.resetParameters();
		this.Front_Left_Foot.resetParameters();
		this.Front_Leg_Right_2.resetParameters();
		this.Front_Right_Foot.resetParameters();
	}
}
