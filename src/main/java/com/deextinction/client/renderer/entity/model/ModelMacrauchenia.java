package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.IAnimatedEntity;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntityMacrauchenia;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * Macrauchenia - BizarreAltispinax Created using Tabula 7.0.0
 */
public class ModelMacrauchenia extends ResettableModelBase
{
	public ResettableModelRenderer leftBackLeg1;
	public ResettableModelRenderer rightBackLeg1;
	public ResettableModelRenderer body1;
	public ResettableModelRenderer leftBackLeg2;
	public ResettableModelRenderer leftBackLeg3;
	public ResettableModelRenderer leftBackFoot;
	public ResettableModelRenderer rightBackLeg2;
	public ResettableModelRenderer rightBackLeg3;
	public ResettableModelRenderer rightBackFoot;
	public ResettableModelRenderer body2;
	public ResettableModelRenderer tail1;
	public ResettableModelRenderer leftArm1;
	public ResettableModelRenderer rightArm1;
	public ResettableModelRenderer neck1;
	public ResettableModelRenderer leftArm2;
	public ResettableModelRenderer leftArm3;
	public ResettableModelRenderer leftFrontFoot;
	public ResettableModelRenderer rightArm2;
	public ResettableModelRenderer rightArm3;
	public ResettableModelRenderer rightFrontFoot;
	public ResettableModelRenderer neck2;
	public ResettableModelRenderer neck3;
	public ResettableModelRenderer neck4;
	public ResettableModelRenderer head;
	public ResettableModelRenderer upperJaw1;
	public ResettableModelRenderer lowerJaw;
	public ResettableModelRenderer rightEar;
	public ResettableModelRenderer leftEar;
	public ResettableModelRenderer upperJaw2;
	public ResettableModelRenderer upperJaw3;
	public ResettableModelRenderer tail2;
	public ResettableModelRenderer tail3;
	private Animator animator;

	public ModelMacrauchenia()
	{
		this.textureWidth = 200;
		this.textureHeight = 50;

		this.neck4 = new ResettableModelRenderer(this, 60, 11);
		this.neck4.setRotationPoint(0.0F, -4.0F, -6.0F);
		this.neck4.addBox(-1.5F, 0.0F, -3.0F, 3, 4, 3, 0.0F);
		this.neck4.setRotateAngle(0.41887902047863906F, 0.0F, 0.0F);

		this.leftArm1 = new ResettableModelRenderer(this, 118, 0);
		this.leftArm1.setRotationPoint(2.5F, 8.0F, -5.0F);
		this.leftArm1.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.leftArm1.setRotateAngle(0.13962634015954636F, 0.08726646259971647F, -0.22689280275926282F);

		this.rightBackLeg1 = new ResettableModelRenderer(this, 16, 0);
		this.rightBackLeg1.setRotationPoint(-3.5F, 6.3F, 9.0F);
		this.rightBackLeg1.addBox(-1.5F, 0.0F, -2.5F, 3, 8, 5, 0.0F);
		this.rightBackLeg1.setRotateAngle(-0.3490658503988659F, 0.0F, 0.0F);

		this.leftFrontFoot = new ResettableModelRenderer(this, 178, 0);
		this.leftFrontFoot.setRotationPoint(0.0F, 3.0F, 1.0F);
		this.leftFrontFoot.addBox(-1.5F, 0.0F, -2.8F, 3, 2, 3, 0.0F);
		this.leftFrontFoot.setRotateAngle(0.0F, 0.0F, 0.05235987755982988F);

		this.leftArm2 = new ResettableModelRenderer(this, 162, 0);
		this.leftArm2.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.leftArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		this.leftArm2.setRotateAngle(-0.19198621771937624F, 0.0F, 0.17453292519943295F);

		this.upperJaw2 = new ResettableModelRenderer(this, 142, 11);
		this.upperJaw2.setRotationPoint(0.0F, -0.8F, -3.0F);
		this.upperJaw2.addBox(-1.0F, 0.0F, -3.0F, 2, 2, 3, 0.0F);
		this.upperJaw2.setRotateAngle(0.6373942428283291F, 0.0F, 0.0F);

		this.tail1 = new ResettableModelRenderer(this, 11, 0);
		this.tail1.setRotationPoint(0.0F, 0.0F, 0.5F);
		this.tail1.addBox(-1.0F, 0.0F, -2.0F, 2, 2, 2, 0.0F);
		this.tail1.setRotateAngle(0.5585053606381855F, 0.0F, 0.0F);

		this.neck1 = new ResettableModelRenderer(this, 142, 0);
		this.neck1.setRotationPoint(0.0F, -0.7F, -12.0F);
		this.neck1.addBox(-2.5F, 0.0F, -2.5F, 5, 6, 5, 0.0F);
		this.neck1.setRotateAngle(-0.2617993877991494F, 0.0F, 0.0F);

		this.body1 = new ResettableModelRenderer(this, 32, 0);
		this.body1.setRotationPoint(0.0F, 6.5F, 11.5F);
		this.body1.addBox(-3.0F, -1.0F, -7.5F, 6, 8, 8, 0.0F);
		this.body1.setRotateAngle(-0.10471975511965977F, 0.0F, 0.0F);

		this.leftBackFoot = new ResettableModelRenderer(this, 70, 0);
		this.leftBackFoot.setRotationPoint(0.0F, 4.6F, -0.3F);
		this.leftBackFoot.addBox(-1.5F, 0.0F, -2.5F, 3, 2, 3, 0.0F);
		this.leftBackFoot.setRotateAngle(0.10471975511965977F, 0.0F, 0.0F);

		this.upperJaw1 = new ResettableModelRenderer(this, 130, 11);
		this.upperJaw1.setRotationPoint(0.0F, 1.0F, -3.7F);
		this.upperJaw1.addBox(-1.5F, -1.0F, -3.0F, 3, 3, 3, 0.0F);
		this.upperJaw1.setRotateAngle(0.13962634015954636F, 0.0F, 0.0F);

		this.lowerJaw = new ResettableModelRenderer(this, 168, 6);
		this.lowerJaw.setRotationPoint(0.0F, 3.1F, -3.2F);
		this.lowerJaw.addBox(-1.0F, -0.2F, -3.0F, 2, 1, 3, 0.0F);
		this.lowerJaw.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.tail2 = new ResettableModelRenderer(this, 142, 0);
		this.tail2.setRotationPoint(0.0F, 1.5F, -0.6F);
		this.tail2.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.tail2.setRotateAngle(-0.22759093446006054F, 0.0F, 0.0F);

		this.leftBackLeg3 = new ResettableModelRenderer(this, 32, 0);
		this.leftBackLeg3.setRotationPoint(0.0F, 7.9F, 2.5F);
		this.leftBackLeg3.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
		this.leftBackLeg3.setRotateAngle(-0.7740535232594852F, 0.0F, 0.0F);

		this.rightBackFoot = new ResettableModelRenderer(this, 92, 0);
		this.rightBackFoot.setRotationPoint(0.0F, 4.6F, -0.3F);
		this.rightBackFoot.addBox(-1.5F, 0.0F, -2.5F, 3, 2, 3, 0.0F);
		this.rightBackFoot.setRotateAngle(0.10471975511965977F, 0.0F, 0.0F);

		this.rightEar = new ResettableModelRenderer(this, 0, 0);
		this.rightEar.setRotationPoint(-1.5F, 0.5F, -1.3F);
		this.rightEar.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
		this.rightEar.setRotateAngle(-0.091106186954104F, 0.0F, -0.36425021489121656F);

		this.leftBackLeg1 = new ResettableModelRenderer(this, 0, 0);
		this.leftBackLeg1.setRotationPoint(3.5F, 6.3F, 9.0F);
		this.leftBackLeg1.addBox(-1.5F, 0.0F, -2.5F, 3, 8, 5, 0.0F);
		this.leftBackLeg1.setRotateAngle(-0.3490658503988659F, 0.0F, 0.0F);

		this.neck3 = new ResettableModelRenderer(this, 156, 9);
		this.neck3.setRotationPoint(0.0F, -0.5F, -5.0F);
		this.neck3.addBox(-1.5F, -4.0F, -6.0F, 3, 4, 6, 0.0F);
		this.neck3.setRotateAngle(-0.41887902047863906F, 0.0F, 0.0F);

		this.leftArm3 = new ResettableModelRenderer(this, 170, 0);
		this.leftArm3.setRotationPoint(0.0F, 4.8F, 0.0F);
		this.leftArm3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.leftArm3.setRotateAngle(0.0F, 0.0F, 0.017453292519943295F);

		this.leftBackLeg2 = new ResettableModelRenderer(this, 60, 0);
		this.leftBackLeg2.setRotationPoint(0.0F, 7.8F, -2.0F);
		this.leftBackLeg2.addBox(-1.0F, 0.0F, 0.0F, 2, 8, 3, 0.0F);
		this.leftBackLeg2.setRotateAngle(1.0183996185386912F, 0.0F, 0.0F);

		this.tail3 = new ResettableModelRenderer(this, 157, 0);
		this.tail3.setRotationPoint(0.0F, 2.9F, 0.0F);
		this.tail3.addBox(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
		this.tail3.setRotateAngle(-0.22759093446006054F, 0.0F, 0.0F);

		this.rightFrontFoot = new ResettableModelRenderer(this, 92, 5);
		this.rightFrontFoot.setRotationPoint(0.0F, 3.0F, 1.0F);
		this.rightFrontFoot.addBox(-1.5F, 0.0F, -2.8F, 3, 2, 3, 0.0F);
		this.rightFrontFoot.setRotateAngle(0.0F, 0.0F, -0.05235987755982988F);

		this.rightArm2 = new ResettableModelRenderer(this, 190, 0);
		this.rightArm2.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.rightArm2.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
		this.rightArm2.setRotateAngle(-0.19198621771937624F, 0.0F, -0.17453292519943295F);

		this.rightBackLeg2 = new ResettableModelRenderer(this, 82, 0);
		this.rightBackLeg2.setRotationPoint(0.0F, 7.8F, -2.0F);
		this.rightBackLeg2.addBox(-1.0F, 0.0F, 0.0F, 2, 8, 3, 0.0F);
		this.rightBackLeg2.setRotateAngle(1.0183996185386912F, 0.0F, 0.0F);

		this.body2 = new ResettableModelRenderer(this, 92, 0);
		this.body2.setRotationPoint(0.0F, -0.2F, -7.0F);
		this.body2.addBox(-3.5F, -1.0F, -12.0F, 7, 9, 12, 0.0F);
		this.body2.setRotateAngle(0.12217304763960307F, 0.0F, 0.0F);

		this.leftEar = new ResettableModelRenderer(this, 27, 0);
		this.leftEar.setRotationPoint(1.5F, 0.5F, -1.3F);
		this.leftEar.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 1, 0.0F);
		this.leftEar.setRotateAngle(-0.091106186954104F, 0.0F, 0.36425021489121656F);

		this.upperJaw3 = new ResettableModelRenderer(this, 191, 7);
		this.upperJaw3.setRotationPoint(0.0F, 0.3F, -3.0F);
		this.upperJaw3.addBox(-0.5F, 0.0F, -3.0F, 1, 1, 3, 0.0F);
		this.upperJaw3.setRotateAngle(0.6373942428283291F, 0.0F, 0.0F);

		this.neck2 = new ResettableModelRenderer(this, 173, 5);
		this.neck2.setRotationPoint(0.0F, 5.8F, -2.0F);
		this.neck2.addBox(-2.0F, -5.0F, -5.0F, 4, 5, 5, 0.0F);
		this.neck2.setRotateAngle(-0.2792526803190927F, 0.0F, 0.0F);

		this.head = new ResettableModelRenderer(this, 72, 11);
		this.head.setRotationPoint(0.0F, -0.2F, -3.0F);
		this.head.addBox(-2.0F, 0.0F, -4.0F, 4, 4, 4, 0.0F);
		this.head.setRotateAngle(0.5918411493512771F, 0.0F, 0.0F);

		this.rightArm1 = new ResettableModelRenderer(this, 130, 0);
		this.rightArm1.setRotationPoint(-2.5F, 8.0F, -5.0F);
		this.rightArm1.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.rightArm1.setRotateAngle(0.13962634015954636F, 0.08726646259971647F, 0.22689280275926282F);

		this.rightArm3 = new ResettableModelRenderer(this, 70, 5);
		this.rightArm3.setRotationPoint(0.0F, 4.8F, 0.0F);
		this.rightArm3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.rightArm3.setRotateAngle(0.0F, 0.0F, -0.017453292519943295F);

		this.rightBackLeg3 = new ResettableModelRenderer(this, 52, 0);
		this.rightBackLeg3.setRotationPoint(0.0F, 7.9F, 2.5F);
		this.rightBackLeg3.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 2, 0.0F);
		this.rightBackLeg3.setRotateAngle(-0.7740535232594852F, 0.0F, 0.0F);

		this.body1.addChild(this.tail1);
		this.tail1.addChild(this.tail2);
		this.tail2.addChild(this.tail3);

		this.body1.addChild(this.body2);
		this.body2.addChild(this.neck1);
		this.neck1.addChild(this.neck2);
		this.neck2.addChild(this.neck3);
		this.neck3.addChild(this.neck4);
		this.neck4.addChild(this.head);

		this.head.addChild(this.rightEar);
		this.head.addChild(this.leftEar);
		this.head.addChild(this.lowerJaw);
		this.head.addChild(this.upperJaw1);
		this.upperJaw1.addChild(this.upperJaw2);
		this.upperJaw2.addChild(this.upperJaw3);

		this.rightArm1.addChild(this.rightArm2);
		this.rightArm2.addChild(this.rightArm3);
		this.rightArm3.addChild(this.rightFrontFoot);

		this.leftArm1.addChild(this.leftArm2);
		this.leftArm2.addChild(this.leftArm3);
		this.leftArm3.addChild(this.leftFrontFoot);

		this.rightBackLeg1.addChild(this.rightBackLeg2);
		this.rightBackLeg2.addChild(this.rightBackLeg3);
		this.rightBackLeg3.addChild(this.rightBackFoot);

		this.leftBackLeg1.addChild(this.leftBackLeg2);
		this.leftBackLeg2.addChild(this.leftBackLeg3);
		this.leftBackLeg3.addChild(this.leftBackFoot);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityMacrauchenia animal = (EntityMacrauchenia) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, (EntityMacrauchenia) entity);

		this.body1.render(scale);
		this.rightBackLeg1.render(scale);
		this.leftBackLeg1.render(scale);
		this.rightArm1.render(scale);
		this.leftArm1.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityMacrauchenia animal)
	{
		float headY = this.getHeadAngle(yaw) / 2.0F;
		this.neck1.rotateAngleY += 0.5F * headY;
		this.neck2.rotateAngleY += 0.5F * headY;
		this.neck3.rotateAngleY += 0.5F * headY;
		this.head.rotateAngleY += 0.5F * headY;

		if (walkSpeed > 0.001F)
		{
			float bodyBob1 = this.getRotateAngleComplex(time, walkSpeed, 0.375F, 0.5F, 0.5F);
			this.body1.rotationPointX -= bodyBob1;
			this.rightBackLeg1.rotationPointX -= bodyBob1;
			this.leftBackLeg1.rotationPointX -= bodyBob1;
			this.rightArm1.rotationPointX -= bodyBob1;
			this.leftArm1.rotationPointX -= bodyBob1;

			float bodyBob2 = this.getRotateAngle(time, walkSpeed, 0.75F, 1.0F);
			this.body1.rotationPointY -= bodyBob2;
			this.rightBackLeg1.rotationPointY -= bodyBob2;
			this.leftBackLeg1.rotationPointY -= bodyBob2;
			this.rightArm1.rotationPointY -= bodyBob2;
			this.leftArm1.rotationPointY -= bodyBob2;

			float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, 0.375F, 0.6F, 3.14159F, 0.0F);
			float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, 0.375F, 0.4F, 1.5F, 0.2F);
			float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, 0.375F, 0.6F, -1.0F, -0.2F);
			float lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, 0.375F, 0.7F, -1.0F, 0.7F);

			float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, 0.375F, 0.6F, 3.14159F, 0.0F);
			float rleg2 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, 0.375F, 0.4F, 1.5F, 0.2F);
			float rleg3 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, 0.375F, 0.6F, -1.0F, -0.2F);
			float rfoot = this.getRotateAngleComplexInclinated(time, walkSpeed, 0.375F, 0.7F, -1.0F, 0.7F);

			this.leftBackLeg1.rotateAngleX += lleg1;
			this.leftBackLeg2.rotateAngleX += lleg2;
			this.leftBackLeg3.rotateAngleX += lleg3;
			this.leftBackFoot.rotateAngleX += lfoot;

			this.rightBackLeg1.rotateAngleX += rleg1;
			this.rightBackLeg2.rotateAngleX += rleg2;
			this.rightBackLeg3.rotateAngleX += rleg3;
			this.rightBackFoot.rotateAngleX += rfoot;

			this.leftArm1.rotateAngleX += rleg1 - 0.5F * walkSpeed;
			this.leftArm2.rotateAngleX += rleg2 + 0.5F * walkSpeed;

			this.rightArm1.rotateAngleX += lleg1 - 0.5F * walkSpeed;
			this.rightArm2.rotateAngleX += lleg2 + 0.5F * walkSpeed;

			if (walkSpeed > 0.4F)
			{
				float[] naturaltailMovement = this.getChainMovement(time, walkSpeed, 3, 0.75F, 0.05F, -2.0F);
				this.tail1.rotateAngleX -= naturaltailMovement[0];
				this.tail2.rotateAngleX -= naturaltailMovement[1];
				this.tail3.rotateAngleX -= naturaltailMovement[2];
				this.tail1.rotateAngleY -= this.getRotateAngleComplex(time, walkSpeed, 0.375F, 0.15F, 0.0F);
			}

			float runningInclination = MathHelper.sin(walkSpeed);
			if (runningInclination > 0.2F)
			{
				runningInclination -= 0.2F;
				if (runningInclination > 0.5F)
					runningInclination = 0.5F;

				this.body1.rotateAngleX -= 0.25F * runningInclination;
			}
		}
		else
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.0625F, 0.03125F);
			this.body1.rotateAngleX -= naturalMovement;
			this.body2.rotateAngleX += naturalMovement;
			this.neck1.rotateAngleX += 0.25F * naturalMovement;
			this.neck2.rotateAngleX += 0.25F * naturalMovement;
			this.neck3.rotateAngleX += 0.25F * naturalMovement;
			this.neck4.rotateAngleX += 0.25F * naturalMovement;

			float[] naturaltailMovement = this.getChainMovement(time, 1.0F, 3, 0.0625F, 0.03125F, -2.0F);
			this.tail1.rotateAngleX += naturaltailMovement[0];
			this.tail2.rotateAngleX += naturaltailMovement[1];
			this.tail3.rotateAngleX += naturaltailMovement[2];
			this.upperJaw1.rotateAngleX -= naturaltailMovement[0];
			this.upperJaw2.rotateAngleX -= naturaltailMovement[1];
			this.upperJaw3.rotateAngleX -= naturaltailMovement[2];
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, IAnimatedEntity entity)
	{
		if (entity.getAnimID() == DeAnimationList.SOUND_1)
		{
			this.animator.update(entity);
			this.animator.setAnim(DeAnimationList.SOUND_1);

			this.animator.startPhase(20);
			this.animator.rotate(this.body1, ResettableModelBase.RAD_5_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.body2, -ResettableModelBase.RAD_5_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.tail1, ResettableModelBase.RAD_5_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.tail2, ResettableModelBase.RAD_5_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.tail3, ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.neck1, -ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.neck2, -ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.neck3, -ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.neck4, -ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.head, -ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);

			this.animator.rotate(this.upperJaw1, -ResettableModelBase.RAD_15_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.upperJaw2, -ResettableModelBase.RAD_15_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.upperJaw3, -ResettableModelBase.RAD_15_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.lowerJaw, ResettableModelBase.RAD_45_DEGREES, 0.0F, 0.0F);

			this.animator.endPhase();
			this.animator.resetPhase(10);
		}
	}

	private void resetPose()
	{
		this.body1.resetParameters();
		this.body2.resetParameters();

		this.leftBackLeg1.resetParameters();
		this.leftBackLeg2.resetParameters();
		this.leftBackLeg3.resetParameters();
		this.leftBackFoot.resetParameters();

		this.rightBackLeg1.resetParameters();
		this.rightBackLeg2.resetParameters();
		this.rightBackLeg3.resetParameters();
		this.rightBackFoot.resetParameters();

		this.leftArm1.resetParameters();
		this.leftArm2.resetParameters();
		this.leftArm3.resetParameters();
		this.leftFrontFoot.resetParameters();

		this.rightArm1.resetParameters();
		this.rightArm2.resetParameters();
		this.rightArm3.resetParameters();
		this.rightFrontFoot.resetParameters();

		this.neck1.resetParameters();
		this.neck2.resetParameters();
		this.neck3.resetParameters();
		this.neck4.resetParameters();

		this.head.resetParameters();
		this.rightEar.resetParameters();
		this.leftEar.resetParameters();
		this.lowerJaw.resetParameters();
		this.upperJaw1.resetParameters();
		this.upperJaw2.resetParameters();
		this.upperJaw3.resetParameters();

		this.tail1.resetParameters();
		this.tail2.resetParameters();
		this.tail3.resetParameters();
	}
}
