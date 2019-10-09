package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntityTheriodictis;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * Theriodictis - BOTMON Created using Tabula 7.0.0
 */
public class ModelTheriodictis extends ResettableModelBase
{
	public ResettableModelRenderer body;
	public ResettableModelRenderer left_leg_1;
	public ResettableModelRenderer right_leg_1;
	public ResettableModelRenderer left_arm_1;
	public ResettableModelRenderer right_arm_1;
	public ResettableModelRenderer rear;
	public ResettableModelRenderer neck;
	public ResettableModelRenderer back_hair;
	public ResettableModelRenderer tail_1;
	public ResettableModelRenderer tail_2;
	public ResettableModelRenderer head;
	public ResettableModelRenderer top_jaw;
	public ResettableModelRenderer lower_jaw;
	public ResettableModelRenderer right_ear_1;
	public ResettableModelRenderer left_ear_1;
	public ResettableModelRenderer nose;
	public ResettableModelRenderer right_ear_2;
	public ResettableModelRenderer right_ear_3;
	public ResettableModelRenderer left_ear_2;
	public ResettableModelRenderer left_ear_3;
	public ResettableModelRenderer left_leg_2;
	public ResettableModelRenderer left_leg_3;
	public ResettableModelRenderer left_foot;
	public ResettableModelRenderer right_leg_2;
	public ResettableModelRenderer right_leg_3;
	public ResettableModelRenderer right_foot;
	public ResettableModelRenderer left_arm_2;
	public ResettableModelRenderer left_arm_3;
	public ResettableModelRenderer left_paw;
	public ResettableModelRenderer right_arm_2;
	public ResettableModelRenderer right_arm_3;
	public ResettableModelRenderer right_paw;
	private Animator animator;

	public ModelTheriodictis()
	{
		this.textureWidth = 150;
		this.textureHeight = 160;

		this.right_ear_3 = new ResettableModelRenderer(this, 74, 30);
		this.right_ear_3.setRotationPoint(0.0F, -0.8F, 0.2F);
		this.right_ear_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.right_ear_3.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.neck = new ResettableModelRenderer(this, 42, 1);
		this.neck.setRotationPoint(0.0F, -1.4F, -10.0F);
		this.neck.addBox(-2.5F, -3.5F, -8.0F, 5, 6, 8, 0.0F);
		this.neck.setRotateAngle(-0.0439822971502571F, 0.0F, 0.0F);

		this.top_jaw = new ResettableModelRenderer(this, 43, 30);
		this.top_jaw.setRotationPoint(0.0F, 0.6F, -3.7F);
		this.top_jaw.addBox(-2.0F, -1.5F, -4.0F, 4, 2, 4, 0.0F);
		this.top_jaw.setRotateAngle(-0.03508111796508602F, 0.0F, 0.0F);

		this.right_arm_3 = new ResettableModelRenderer(this, 0, 137);
		this.right_arm_3.setRotationPoint(0.0F, 5.3F, 0.1F);
		this.right_arm_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.right_arm_3.setRotateAngle(-0.13962634015954636F, 0.0F, 0.0F);

		this.tail_2 = new ResettableModelRenderer(this, 0, 58);
		this.tail_2.setRotationPoint(0.0F, 0.0F, 8.7F);
		this.tail_2.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 7, 0.0F);
		this.tail_2.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.left_arm_3 = new ResettableModelRenderer(this, 10, 137);
		this.left_arm_3.setRotationPoint(0.0F, 5.3F, 0.1F);
		this.left_arm_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.left_arm_3.setRotateAngle(-0.13962634015954636F, 0.0F, 0.0F);

		this.right_leg_2 = new ResettableModelRenderer(this, 0, 87);
		this.right_leg_2.setRotationPoint(-2.0F, 8.0F, 0.3F);
		this.right_leg_2.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
		this.right_leg_2.setRotateAngle(0.4363323129985824F, 0.0F, 0.0F);

		this.rear = new ResettableModelRenderer(this, 0, 22);
		this.rear.setRotationPoint(0.0F, -0.5F, -0.5F);
		this.rear.addBox(-5.0F, -4.5F, 0.0F, 10, 9, 9, 0.0F);
		this.rear.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.tail_1 = new ResettableModelRenderer(this, 0, 42);
		this.tail_1.setRotationPoint(0.0F, -3.6F, 7.0F);
		this.tail_1.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 9, 0.0F);
		this.tail_1.setRotateAngle(-1.1838568316277536F, 0.0F, 0.0F);

		this.body = new ResettableModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 10.0F, 3.0F);
		this.body.addBox(-4.5F, -5.0F, -11.0F, 9, 9, 11, 0.0F);
		this.body.setRotateAngle(-0.012391837689159737F, 0.0F, 0.0F);

		this.right_arm_2 = new ResettableModelRenderer(this, 0, 126);
		this.right_arm_2.setRotationPoint(-2.0F, 4.4F, 2.0F);
		this.right_arm_2.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.right_arm_2.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.left_ear_3 = new ResettableModelRenderer(this, 67, 30);
		this.left_ear_3.setRotationPoint(0.0F, -0.8F, 0.2F);
		this.left_ear_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
		this.left_ear_3.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.left_leg_2 = new ResettableModelRenderer(this, 17, 87);
		this.left_leg_2.setRotationPoint(2.0F, 8.0F, 0.3F);
		this.left_leg_2.addBox(-1.5F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
		this.left_leg_2.setRotateAngle(0.4363323129985824F, 0.0F, 0.0F);

		this.right_foot = new ResettableModelRenderer(this, 0, 107);
		this.right_foot.setRotationPoint(0.0F, 3.3F, -0.2F);
		this.right_foot.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
		this.right_foot.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.left_arm_1 = new ResettableModelRenderer(this, 18, 115);
		this.left_arm_1.setRotationPoint(2.0F, 10.0F, -7.5F);
		this.left_arm_1.addBox(0.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
		this.left_arm_1.setRotateAngle(0.2617993877991494F, 0.0F, 0.0F);

		this.left_leg_3 = new ResettableModelRenderer(this, 19, 98);
		this.left_leg_3.setRotationPoint(0.0F, 4.5F, 2.0F);
		this.left_leg_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.left_leg_3.setRotateAngle(-0.4363323129985824F, 0.0F, 0.0F);

		this.left_paw = new ResettableModelRenderer(this, 14, 145);
		this.left_paw.setRotationPoint(0.0F, 2.9F, -0.1F);
		this.left_paw.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
		this.left_paw.setRotateAngle(0.13962634015954636F, 0.0F, 0.0F);

		this.right_ear_2 = new ResettableModelRenderer(this, 76, 25);
		this.right_ear_2.setRotationPoint(-0.5F, -3.0F, -1.3F);
		this.right_ear_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.right_ear_2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.head = new ResettableModelRenderer(this, 42, 17);
		this.head.setRotationPoint(0.0F, -0.2F, -7.1F);
		this.head.addBox(-3.0F, -3.5F, -4.0F, 6, 6, 4, 0.0F);
		this.head.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.left_arm_2 = new ResettableModelRenderer(this, 16, 126);
		this.left_arm_2.setRotationPoint(2.0F, 4.4F, 2.0F);
		this.left_arm_2.addBox(-1.5F, 0.0F, -1.5F, 3, 6, 3, 0.0F);
		this.left_arm_2.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.left_ear_1 = new ResettableModelRenderer(this, 67, 19);
		this.left_ear_1.setRotationPoint(2.9F, -2.3F, -0.8F);
		this.left_ear_1.addBox(-0.5F, -2.0F, -1.5F, 1, 2, 3, 0.0F);
		this.left_ear_1.setRotateAngle(-0.36425021489121656F, 0.31869712141416456F, 0.36425021489121656F);

		this.lower_jaw = new ResettableModelRenderer(this, 36, 50);
		this.lower_jaw.setRotationPoint(0.0F, 1.1F, -3.3F);
		this.lower_jaw.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 4, 0.0F);
		this.lower_jaw.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.right_paw = new ResettableModelRenderer(this, 0, 145);
		this.right_paw.setRotationPoint(0.0F, 2.9F, -0.1F);
		this.right_paw.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
		this.right_paw.setRotateAngle(0.13962634015954636F, 0.0F, 0.0F);

		this.left_leg_1 = new ResettableModelRenderer(this, 20, 72);
		this.left_leg_1.setRotationPoint(3.0F, 7.2F, 3.5F);
		this.left_leg_1.addBox(0.0F, 0.0F, 0.0F, 4, 8, 5, 0.0F);
		this.left_leg_1.setRotateAngle(-0.08726646259971647F, 0.0F, 0.0F);

		this.right_arm_1 = new ResettableModelRenderer(this, 0, 115);
		this.right_arm_1.setRotationPoint(-2.0F, 10.0F, -7.5F);
		this.right_arm_1.addBox(-4.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F);
		this.right_arm_1.setRotateAngle(0.2617993877991494F, 0.0F, 0.0F);

		this.left_foot = new ResettableModelRenderer(this, 16, 107);
		this.left_foot.setRotationPoint(0.0F, 3.3F, -0.2F);
		this.left_foot.addBox(-1.5F, 0.0F, -2.0F, 3, 2, 3, 0.0F);
		this.left_foot.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.right_leg_3 = new ResettableModelRenderer(this, 0, 98);
		this.right_leg_3.setRotationPoint(0.0F, 4.5F, 2.0F);
		this.right_leg_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.right_leg_3.setRotateAngle(-0.4363323129985824F, 0.0F, 0.0F);

		this.nose = new ResettableModelRenderer(this, 40, 39);
		this.nose.setRotationPoint(0.0F, -1.3F, -4.9F);
		this.nose.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 5, 0.0F);
		this.nose.setRotateAngle(0.4553564018453205F, 0.0F, 0.0F);

		this.left_ear_2 = new ResettableModelRenderer(this, 67, 25);
		this.left_ear_2.setRotationPoint(-0.5F, -3.0F, -1.3F);
		this.left_ear_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
		this.left_ear_2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.back_hair = new ResettableModelRenderer(this, 41, 59);
		this.back_hair.setRotationPoint(0.0F, -4.9F, -10.8F);
		this.back_hair.addBox(-2.5F, -1.0F, 0.0F, 5, 1, 10, 0.0F);
		this.back_hair.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.right_ear_1 = new ResettableModelRenderer(this, 77, 19);
		this.right_ear_1.setRotationPoint(-2.8F, -2.3F, -0.8F);
		this.right_ear_1.addBox(-0.5F, -2.0F, -1.5F, 1, 2, 3, 0.0F);
		this.right_ear_1.setRotateAngle(-0.36425021489121656F, -0.31869712141416456F, -0.5009094953223726F);

		this.right_leg_1 = new ResettableModelRenderer(this, 0, 72);
		this.right_leg_1.setRotationPoint(-3.0F, 7.2F, 3.5F);
		this.right_leg_1.addBox(-4.0F, 0.0F, 0.0F, 4, 8, 5, 0.0F);
		this.right_leg_1.setRotateAngle(-0.08726646259971647F, 0.0F, 0.0F);

		this.right_ear_2.addChild(this.right_ear_3);
		this.body.addChild(this.neck);
		this.head.addChild(this.top_jaw);
		this.right_arm_2.addChild(this.right_arm_3);
		this.tail_1.addChild(this.tail_2);
		this.left_arm_2.addChild(this.left_arm_3);
		this.right_leg_1.addChild(this.right_leg_2);
		this.body.addChild(this.rear);
		this.rear.addChild(this.tail_1);
		this.right_arm_1.addChild(this.right_arm_2);
		this.left_ear_2.addChild(this.left_ear_3);
		this.left_leg_1.addChild(this.left_leg_2);
		this.right_leg_3.addChild(this.right_foot);
		this.left_leg_2.addChild(this.left_leg_3);
		this.left_arm_3.addChild(this.left_paw);
		this.right_ear_1.addChild(this.right_ear_2);
		this.neck.addChild(this.head);
		this.left_arm_1.addChild(this.left_arm_2);
		this.head.addChild(this.left_ear_1);
		this.head.addChild(this.lower_jaw);
		this.right_arm_3.addChild(this.right_paw);
		this.left_leg_3.addChild(this.left_foot);
		this.right_leg_2.addChild(this.right_leg_3);
		this.top_jaw.addChild(this.nose);
		this.left_ear_1.addChild(this.left_ear_2);
		this.body.addChild(this.back_hair);
		this.head.addChild(this.right_ear_1);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityTheriodictis animal = (EntityTheriodictis) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.body.render(scale);
		this.left_arm_1.render(scale);
		this.left_leg_1.render(scale);
		this.right_arm_1.render(scale);
		this.right_leg_1.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();
		EntityTheriodictis animal = (EntityTheriodictis) entity;
		float sittingProgress = animal.getSittingProgress(partialRenderTicks);

		if (sittingProgress > 0.001F)
		{
			this.body.rotateAngleX -= 0.4F * sittingProgress;
			this.body.rotationPointY += 5.0F * sittingProgress;
			this.neck.rotateAngleX += 0.3F * sittingProgress;

			this.left_leg_1.rotateAngleX -= 1.0F * sittingProgress;
			this.left_leg_1.rotationPointY += 6F * sittingProgress;
			this.left_leg_1.rotationPointZ += 3.0F * sittingProgress;

			this.left_leg_2.rotateAngleX += 1.5F * sittingProgress;
			this.left_leg_2.rotationPointY += 0.5F * sittingProgress;
			this.left_leg_2.rotationPointZ += 4.0F * sittingProgress;

			this.left_leg_3.rotateAngleX -= 2.0F * sittingProgress;
			this.left_leg_3.rotationPointZ -= 1.0F * sittingProgress;

			this.left_foot.rotateAngleX += 1.5F * sittingProgress;
			this.left_foot.rotationPointZ -= 0.7F * sittingProgress;
			this.left_foot.rotationPointY += 1.4F * sittingProgress;

			this.right_leg_1.rotateAngleX -= 1.0F * sittingProgress;
			this.right_leg_1.rotationPointY += 6F * sittingProgress;
			this.right_leg_1.rotationPointZ += 3.0F * sittingProgress;

			this.right_leg_2.rotateAngleX += 1.5F * sittingProgress;
			this.right_leg_2.rotationPointY += 0.5F * sittingProgress;
			this.right_leg_2.rotationPointZ += 4.0F * sittingProgress;

			this.right_leg_3.rotateAngleX -= 2.0F * sittingProgress;
			this.right_leg_3.rotationPointZ -= 1.0F * sittingProgress;

			this.right_foot.rotateAngleX += 1.5F * sittingProgress;
			this.right_foot.rotationPointZ -= 0.7F * sittingProgress;
			this.right_foot.rotationPointY += 1.4F * sittingProgress;

			if (sittingProgress > 0.4F)
			{
				sittingProgress = (sittingProgress - 0.4F) / 0.6F;
				this.tail_1.rotationPointY += 0.5F * sittingProgress;
				this.tail_1.rotateAngleX += 0.4F * sittingProgress;
				this.tail_2.rotateAngleX += 1.35F * sittingProgress;
				this.tail_2.rotationPointZ -= 0.7F * sittingProgress;
			}
		}
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityTheriodictis animal)
	{
		float animSpeed = 0.35F;

		if (animal.isSitting())
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
			this.body.rotateAngleX += naturalMovement;
			this.neck.rotateAngleX -= naturalMovement;

			float headY = yaw / 57.2957795131F / 2.0F;
			this.neck.rotateAngleY += headY;
			this.head.rotateAngleY += headY;

			float headX = pitch / 57.2957795131F / 2.0F;
			this.neck.rotateAngleY += headX;
			this.head.rotateAngleY += headX;
		}
		else
		{
			if (walkSpeed > 0.001F)
			{
				float bodyBob1 = this.getRotateAngleComplex(time, walkSpeed, animSpeed, 0.5F, 0.5F);
				this.body.rotationPointX -= bodyBob1;
				this.right_leg_1.rotationPointX -= bodyBob1;
				this.left_leg_1.rotationPointX -= bodyBob1;
				this.right_arm_1.rotationPointX -= bodyBob1;
				this.left_arm_1.rotationPointX -= bodyBob1;

				float bodyBob2 = this.getRotateAngle(time, walkSpeed, 2.0F * animSpeed, 1.0F);
				this.body.rotationPointY -= bodyBob2;
				this.right_leg_1.rotationPointY -= bodyBob2;
				this.left_leg_1.rotationPointY -= bodyBob2;
				this.right_arm_1.rotationPointY -= bodyBob2;
				this.left_arm_1.rotationPointY -= bodyBob2;

				if (animal.getAnimID() != DeAnimationList.ATTACKING)
				{
					float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.2F);
					float larm1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.5F);
					float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 1F);
					float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.6F, -1.5707963268F, -0.3F);
					float lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

					float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.2F);
					float rarm1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.5F);
					float rleg2 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 01F);
					float rleg3 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.6F, -1.5707963268F, -0.3F);
					float rfoot = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

					this.left_leg_1.rotateAngleX += lleg1;
					this.left_leg_2.rotateAngleX += lleg2;
					this.left_leg_3.rotateAngleX += lleg3;
					this.left_foot.rotateAngleX += lfoot;

					this.right_leg_1.rotateAngleX += rleg1;
					this.right_leg_2.rotateAngleX += rleg2;
					this.right_leg_3.rotateAngleX += rleg3;
					this.right_foot.rotateAngleX += rfoot;

					this.left_arm_1.rotateAngleX += 1.2F * rarm1;
					this.left_arm_2.rotateAngleX += rleg2;
					this.left_paw.rotateAngleX += rfoot;

					this.right_arm_1.rotateAngleX += 1.2F * larm1;
					this.right_arm_2.rotateAngleX += lleg2;
					this.right_paw.rotateAngleX += lfoot;

					float headY = yaw / 57.2957795131F / 2.0F;
					this.neck.rotateAngleY += headY;
					this.head.rotateAngleY += headY;

					float headX = pitch / 57.2957795131F / 2.0F;
					this.neck.rotateAngleY += headX;
					this.head.rotateAngleY += headX;

					if (walkSpeed > 1.0F)
						walkSpeed = 1.0F;

					this.left_leg_1.rotationPointY += 2.0F * walkSpeed;
					this.right_leg_1.rotationPointY += 2.0F * walkSpeed;
				}
			}
			else
			{
				float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
				this.body.rotateAngleX += naturalMovement;
				this.neck.rotateAngleX -= naturalMovement;
				this.tail_1.rotateAngleX += 0.5F * naturalMovement;
				this.tail_2.rotateAngleX += 0.5F * naturalMovement;

				float headY = yaw / 57.2957795131F / 2.0F;
				this.neck.rotateAngleY += headY;
				this.head.rotateAngleY += headY;

				float headX = pitch / 57.2957795131F / 2.0F;
				this.neck.rotateAngleY += headX;
				this.head.rotateAngleY += headX;
			}
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityTheriodictis animal)
	{
		if (animal.getAnimID() == DeAnimationList.SOUND_1)
		{
			this.animator.update(animal);
			this.animator.setAnim(DeAnimationList.SOUND_1);

			this.animator.startPhase(5);
			this.animator.rotate(this.lower_jaw, ResettableModelBase.RAD_45_DEGREES, 0.0F, 0.0F);

			this.animator.endPhase();
			this.animator.resetPhase(10);
		}
	}

	private void resetPose()
	{
		this.body.resetParameters();
		this.left_leg_1.resetParameters();
		this.right_leg_1.resetParameters();
		this.left_arm_1.resetParameters();
		this.right_arm_1.resetParameters();
		this.rear.resetParameters();
		this.neck.resetParameters();
		this.tail_1.resetParameters();
		this.tail_2.resetParameters();
		this.head.resetParameters();
		this.top_jaw.resetParameters();
		this.lower_jaw.resetParameters();
		this.left_leg_2.resetParameters();
		this.left_leg_3.resetParameters();
		this.left_foot.resetParameters();
		this.right_leg_2.resetParameters();
		this.right_leg_3.resetParameters();
		this.right_foot.resetParameters();
		this.left_arm_2.resetParameters();
		this.left_arm_3.resetParameters();
		this.left_paw.resetParameters();
		this.right_arm_2.resetParameters();
		this.right_arm_3.resetParameters();
		this.right_paw.resetParameters();
	}
}
