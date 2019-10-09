package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.animal.EntityBasilosaurus;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * Basilosaurus - Paddling Created using Tabula 7.0.0
 */
public class ModelBasilosaurus extends ResettableModelBase
{
	public ResettableModelRenderer body;
	public ResettableModelRenderer neck;
	public ResettableModelRenderer armLeft;
	public ResettableModelRenderer armRight;
	public ResettableModelRenderer body2;
	public ResettableModelRenderer head1;
	public ResettableModelRenderer topjaw;
	public ResettableModelRenderer bottomjaw;
	public ResettableModelRenderer topjaw2;
	public ResettableModelRenderer topjaw3;
	public ResettableModelRenderer topjaw4;
	public ResettableModelRenderer topjaw5;
	public ResettableModelRenderer topjaw6;
	public ResettableModelRenderer mouthskin1;
	public ResettableModelRenderer mouthskin2;
	public ResettableModelRenderer bottomjaw2;
	public ResettableModelRenderer armLeft2;
	public ResettableModelRenderer armLeft3;
	public ResettableModelRenderer armRight2;
	public ResettableModelRenderer armRight3;
	public ResettableModelRenderer TinyLeftfin;
	public ResettableModelRenderer TinyRightfin;
	public ResettableModelRenderer dorsal;
	public ResettableModelRenderer tail1;
	public ResettableModelRenderer tail2;
	public ResettableModelRenderer tail3;
	public ResettableModelRenderer tail4;
	public ResettableModelRenderer tail5;
	public ResettableModelRenderer flukeLeft;
	public ResettableModelRenderer flukeRight;
	public ResettableModelRenderer flukeinner;
	public ResettableModelRenderer flukeinner_1;
	public ResettableModelRenderer flukeoutter;
	public ResettableModelRenderer flukeoutter_1;
	public ResettableModelRenderer[] bodyParts;
	private Animator animator;

	public ModelBasilosaurus()
	{
		this.textureWidth = 200;
		this.textureHeight = 200;

		this.body2 = new ResettableModelRenderer(this, 5, 70);
		this.body2.setRotationPoint(0.0F, 0.0F, 7.0F);
		this.body2.addBox(-5.0F, -5.0F, -0.5F, 10, 10, 13, 0.0F);
		this.body2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.tail1 = new ResettableModelRenderer(this, 5, 95);
		this.tail1.setRotationPoint(-0.1F, -0.5F, 11.5F);
		this.tail1.addBox(-4.0F, -4.0F, 0.0F, 8, 9, 12, 0.0F);
		this.tail1.setRotateAngle(-0.017453292519943295F, 0.0F, 0.0F);

		this.topjaw4 = new ResettableModelRenderer(this, 47, 9);
		this.topjaw4.setRotationPoint(-1.0F, 0.3F, 0.0F);
		this.topjaw4.addBox(-0.45F, 0.0F, -3.5F, 1, 1, 4, 0.0F);
		this.topjaw4.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.armRight3 = new ResettableModelRenderer(this, 47, 53);
		this.armRight3.mirror = true;
		this.armRight3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRight3.addBox(0.0F, 1.8F, 0.7F, 1, 7, 2, 0.0F);
		this.armRight3.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.topjaw3 = new ResettableModelRenderer(this, 48, 9);
		this.topjaw3.setRotationPoint(1.0F, 0.3F, 0.0F);
		this.topjaw3.addBox(-0.55F, 0.0F, -3.5F, 1, 1, 4, 0.0F);
		this.topjaw3.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.head1 = new ResettableModelRenderer(this, 5, 15);
		this.head1.setRotationPoint(0.0F, 0.0F, -5.0F);
		this.head1.addBox(-2.5F, -3.5F, -6.0F, 5, 5, 6, 0.0F);
		this.head1.setRotateAngle(0.08726646259971647F, 0.0F, 0.0F);

		this.bottomjaw2 = new ResettableModelRenderer(this, 32, 15);
		this.bottomjaw2.setRotationPoint(0.0F, 1.0F, 0.0F);
		this.bottomjaw2.addBox(-1.0F, -0.7F, -3.0F, 2, 1, 4, 0.0F);
		this.bottomjaw2.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.tail3 = new ResettableModelRenderer(this, 45, 122);
		this.tail3.setRotationPoint(0.0F, -3.0F, 10.0F);
		this.tail3.addBox(-3.0F, 0.0F, 0.0F, 6, 6, 10, 0.0F);
		this.tail3.setRotateAngle(-0.02617993877991494F, 0.0F, 0.0F);

		this.flukeLeft = new ResettableModelRenderer(this, 6, 186);
		this.flukeLeft.mirror = true;
		this.flukeLeft.setRotationPoint(1.5F, -0.5F, 6.0F);
		this.flukeLeft.addBox(-6.0F, -0.0F, 0.0F, 6, 1, 9, 0.0F);
		this.flukeLeft.setRotateAngle(0.0F, 1.1383037381507017F, 0.0F);

		this.armRight = new ResettableModelRenderer(this, 46, 51);
		this.armRight.setRotationPoint(-4.5F, 1.5F, -2.5F);
		this.armRight.addBox(0.0F, 0.0F, 0.0F, 1, 8, 3, 0.0F);
		this.armRight.setRotateAngle(0.31869712141416456F, 0.0F, 0.8196066167365371F);

		this.topjaw = new ResettableModelRenderer(this, 5, 5);
		this.topjaw.setRotationPoint(0.0F, -0.3F, -6.0F);
		this.topjaw.addBox(-1.5F, -2.0F, -7.0F, 3, 2, 7, 0.0F);
		this.topjaw.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.TinyLeftfin = new ResettableModelRenderer(this, 44, 155);
		this.TinyLeftfin.setRotationPoint(3.0F, 2.5F, 8.0F);
		this.TinyLeftfin.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 4, 0.0F);
		this.TinyLeftfin.setRotateAngle(-0.5462880558742251F, 0.091106186954104F, -0.22759093446006054F);

		this.flukeoutter = new ResettableModelRenderer(this, 12, 189);
		this.flukeoutter.mirror = true;
		this.flukeoutter.setRotationPoint(0.0F, 0.0F, 9.0F);
		this.flukeoutter.addBox(-3.0F, 0.0F, 0.0F, 3, 1, 6, 0.0F);
		this.flukeoutter.setRotateAngle(0.0F, -0.6049311187412345F, 0.0F);

		this.mouthskin2 = new ResettableModelRenderer(this, 15, 1);
		this.mouthskin2.setRotationPoint(-0.8F, -2.0F, -1.0F);
		this.mouthskin2.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2, 0.0F);
		this.mouthskin2.setRotateAngle(-0.22218041377887818F, 0.0F, 0.0F);

		this.body = new ResettableModelRenderer(this, 5, 45);
		this.body.setRotationPoint(0.0F, 18.5F, -3.8F);
		this.body.addBox(-4.5F, -4.5F, -3.0F, 9, 9, 10, 0.0F);
		this.body.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.armLeft3 = new ResettableModelRenderer(this, 47, 53);
		this.armLeft3.mirror = true;
		this.armLeft3.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLeft3.addBox(-1.0F, 1.8F, 0.7F, 1, 7, 2, 0.0F);
		this.armLeft3.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.topjaw5 = new ResettableModelRenderer(this, 47, 9);
		this.topjaw5.setRotationPoint(0.0F, 0.3F, -4.0F);
		this.topjaw5.addBox(-1.0F, 0.0F, -3.0F, 2, 1, 4, 0.0F);
		this.topjaw5.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.topjaw2 = new ResettableModelRenderer(this, 19, 5);
		this.topjaw2.mirror = true;
		this.topjaw2.setRotationPoint(0.0F, -2.8F, 0.0F);
		this.topjaw2.addBox(-1.0F, 0.0F, -3.5F, 2, 1, 4, 0.0F);
		this.topjaw2.setRotateAngle(0.06981317007977318F, 0.0F, 0.0F);

		this.bottomjaw = new ResettableModelRenderer(this, 30, 7);
		this.bottomjaw.setRotationPoint(0.0F, -0.3F, -6.0F);
		this.bottomjaw.addBox(-1.0F, 0.0F, -6.0F, 2, 1, 6, 0.0F);

		this.armLeft = new ResettableModelRenderer(this, 46, 51);
		this.armLeft.mirror = true;
		this.armLeft.setRotationPoint(4.5F, 1.5F, -2.5F);
		this.armLeft.addBox(-1.0F, 0.0F, 0.0F, 1, 8, 3, 0.0F);
		this.armLeft.setRotateAngle(0.31869712141416456F, 0.0F, -0.8196066167365371F);

		this.flukeinner_1 = new ResettableModelRenderer(this, 6, 184);
		this.flukeinner_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.flukeinner_1.addBox(3.7F, 0.0F, 0.2F, 4, 1, 11, 0.0F);
		this.flukeinner_1.setRotateAngle(0.0F, -0.15707963267948966F, 0.0F);

		this.flukeoutter_1 = new ResettableModelRenderer(this, 12, 189);
		this.flukeoutter_1.setRotationPoint(0.0F, 0.0F, 9.0F);
		this.flukeoutter_1.addBox(0.0F, 0.0F, 0.0F, 3, 1, 6, 0.0F);
		this.flukeoutter_1.setRotateAngle(0.0F, 0.6049311187412345F, 0.0F);

		this.neck = new ResettableModelRenderer(this, 5, 30);
		this.neck.setRotationPoint(0.0F, 0.2F, -2.5F);
		this.neck.addBox(-3.5F, -4.0F, -6.0F, 7, 7, 6, 0.0F);
		this.neck.setRotateAngle(-0.04363323129985824F, 0.0F, 0.0F);

		this.armRight2 = new ResettableModelRenderer(this, 46, 57);
		this.armRight2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armRight2.addBox(0.0F, 5.9F, -5.4F, 1, 3, 3, 0.0F);
		this.armRight2.setRotateAngle(0.7431611954991855F, 0.0F, 0.0F);

		this.tail4 = new ResettableModelRenderer(this, 5, 145);
		this.tail4.setRotationPoint(0.0F, 3.0F, 9.5F);
		this.tail4.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 10, 0.0F);
		this.tail4.setRotateAngle(-0.03490658503988659F, 0.0F, 0.0F);

		this.dorsal = new ResettableModelRenderer(this, 45, 155);
		this.dorsal.setRotationPoint(0.0F, -3.5F, 7.0F);
		this.dorsal.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 3, 0.0F);
		this.dorsal.setRotateAngle(0.5462880558742251F, 0.0F, 0.0F);

		this.mouthskin1 = new ResettableModelRenderer(this, 15, 1);
		this.mouthskin1.setRotationPoint(0.8F, -2.0F, -1.0F);
		this.mouthskin1.addBox(0.0F, 0.0F, 0.0F, 0, 2, 2, 0.0F);
		this.mouthskin1.setRotateAngle(-0.22218041377887818F, 0.0F, 0.0F);

		this.TinyRightfin = new ResettableModelRenderer(this, 44, 155);
		this.TinyRightfin.setRotationPoint(-3.0F, 2.5F, 8.0F);
		this.TinyRightfin.addBox(-0.5F, -2.0F, 0.0F, 1, 2, 4, 0.0F);
		this.TinyRightfin.setRotateAngle(-0.5462880558742251F, -0.091106186954104F, 0.22759093446006054F);

		this.tail5 = new ResettableModelRenderer(this, 5, 168);
		this.tail5.setRotationPoint(0.0F, 0.0F, 9.1F);
		this.tail5.addBox(-2.0F, -1.5F, 0.2F, 4, 3, 10, 0.0F);
		this.tail5.setRotateAngle(-0.03490658503988659F, 0.0F, 0.0F);

		this.tail2 = new ResettableModelRenderer(this, 5, 120);
		this.tail2.setRotationPoint(0.0F, 0.2F, 11.0F);
		this.tail2.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 11, 0.0F);
		this.tail2.setRotateAngle(-0.017453292519943295F, 0.0F, 0.0F);

		this.topjaw6 = new ResettableModelRenderer(this, 22, 5);
		this.topjaw6.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.topjaw6.addBox(-0.5F, -0.2F, -1.5F, 1, 1, 2, 0.0F);
		this.topjaw6.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.flukeinner = new ResettableModelRenderer(this, 6, 184);
		this.flukeinner.mirror = true;
		this.flukeinner.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.flukeinner.addBox(-7.7F, 0.0F, 0.2F, 4, 1, 11, 0.0F);
		this.flukeinner.setRotateAngle(0.0F, 0.15707963267948966F, 0.0F);

		this.armLeft2 = new ResettableModelRenderer(this, 46, 57);
		this.armLeft2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.armLeft2.addBox(-1.0F, 5.9F, -5.4F, 1, 3, 3, 0.0F);
		this.armLeft2.setRotateAngle(0.7431611954991855F, 0.0F, 0.0F);

		this.flukeRight = new ResettableModelRenderer(this, 6, 186);
		this.flukeRight.setRotationPoint(-1.5F, -0.5F, 6.0F);
		this.flukeRight.addBox(0.0F, 0.0F, 0.0F, 6, 1, 9, 0.0F);
		this.flukeRight.setRotateAngle(0.0F, -1.1383037381507017F, 0.0F);

		this.body.addChild(this.body2);
		this.body2.addChild(this.tail1);
		this.topjaw2.addChild(this.topjaw4);
		this.armRight.addChild(this.armRight3);
		this.topjaw2.addChild(this.topjaw3);
		this.neck.addChild(this.head1);
		this.bottomjaw.addChild(this.bottomjaw2);
		this.tail2.addChild(this.tail3);
		this.tail5.addChild(this.flukeLeft);
		this.body.addChild(this.armRight);
		this.head1.addChild(this.topjaw);
		this.tail2.addChild(this.TinyLeftfin);
		this.flukeLeft.addChild(this.flukeoutter);
		this.bottomjaw.addChild(this.mouthskin2);
		this.armLeft.addChild(this.armLeft3);
		this.topjaw2.addChild(this.topjaw5);
		this.topjaw.addChild(this.topjaw2);
		this.head1.addChild(this.bottomjaw);
		this.body.addChild(this.armLeft);
		this.flukeRight.addChild(this.flukeinner_1);
		this.flukeRight.addChild(this.flukeoutter_1);
		this.body.addChild(this.neck);
		this.armRight.addChild(this.armRight2);
		this.tail3.addChild(this.tail4);
		this.tail2.addChild(this.dorsal);
		this.bottomjaw.addChild(this.mouthskin1);
		this.tail2.addChild(this.TinyRightfin);
		this.tail4.addChild(this.tail5);
		this.tail1.addChild(this.tail2);
		this.topjaw2.addChild(this.topjaw6);
		this.flukeLeft.addChild(this.flukeinner);
		this.armLeft.addChild(this.armLeft2);
		this.tail5.addChild(this.flukeRight);

		this.bodyParts = new ResettableModelRenderer[6];
		this.bodyParts[5] = this.body2;
		this.bodyParts[4] = this.tail1;
		this.bodyParts[3] = this.tail2;
		this.bodyParts[2] = this.tail3;
		this.bodyParts[1] = this.tail4;
		this.bodyParts[0] = this.tail5;

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityBasilosaurus animal = (EntityBasilosaurus) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.body.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();

		float tailPitchIncrement = ((EntityBasilosaurus) entity).tailBufferPitch.getAnimation(partialRenderTicks);
		for (int i = 0; i < this.bodyParts.length; i++)
			this.bodyParts[i].rotateAngleX -= tailPitchIncrement;

		float tailYawIncrement = ((EntityBasilosaurus) entity).tailBufferYaw.getAnimation(partialRenderTicks);
		for (int i = 0; i < this.bodyParts.length; i++)
			this.bodyParts[i].rotateAngleY += tailYawIncrement;
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityBasilosaurus animal)
	{
		if (animal.isInWater())
		{
			float animSpeed = 0.2F;

			this.body.rotateAngleX += pitch * ((float) Math.PI / 180.0F);
			this.body.rotateAngleY += yaw * ((float) Math.PI / 180.0F);

			float[] swim = this.getChainMovement(time, 0.1F + walkSpeed, this.bodyParts.length, animSpeed, 0.08F, 3.5F);
			for (int i = 0; i < this.bodyParts.length; i++)
				this.bodyParts[i].rotateAngleX = swim[i];
			this.bodyParts[0].rotateAngleX += swim[0];
			this.bodyParts[1].rotateAngleX += swim[1];
			this.bodyParts[2].rotateAngleX += swim[2];

			if (walkSpeed > 0.001F)
			{
				float bodyBob1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed / 2.0F, 3.0F, 0.0F, 2.0F);
				this.body.rotationPointY -= bodyBob1;

				float larm = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 0.0F, -0.2F);
				this.armLeft.rotateAngleZ += larm;
				this.armLeft.rotateAngleY += 0.25F * larm;
				this.TinyLeftfin.rotateAngleZ += 0.5F * larm;

				float rarm = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 0.0F, -0.2F);
				this.armRight.rotateAngleZ += rarm;
				this.armRight.rotateAngleY += 0.25F * rarm;
				this.TinyRightfin.rotateAngleZ += 0.5F * rarm;
			}
		}
	}

	private void resetPose()
	{
		this.body.resetParameters();
		this.neck.resetParameters();
		this.armLeft.resetParameters();
		this.armRight.resetParameters();
		this.body2.resetParameters();
		this.head1.resetParameters();
		this.topjaw.resetParameters();
		this.bottomjaw.resetParameters();
		this.topjaw2.resetParameters();
		this.topjaw3.resetParameters();
		this.topjaw4.resetParameters();
		this.topjaw5.resetParameters();
		this.topjaw6.resetParameters();
		this.mouthskin1.resetParameters();
		this.mouthskin2.resetParameters();
		this.bottomjaw2.resetParameters();
		this.armLeft2.resetParameters();
		this.armLeft3.resetParameters();
		this.armRight2.resetParameters();
		this.armRight3.resetParameters();
		this.tail1.resetParameters();
		this.tail2.resetParameters();
		this.dorsal.resetParameters();
		this.tail3.resetParameters();
		this.TinyLeftfin.resetParameters();
		this.TinyRightfin.resetParameters();
		this.tail4.resetParameters();
		this.tail5.resetParameters();
		this.flukeLeft.resetParameters();
		this.flukeRight.resetParameters();
		this.flukeinner.resetParameters();
		this.flukeoutter.resetParameters();
		this.flukeinner_1.resetParameters();
		this.flukeoutter_1.resetParameters();
	}
}
