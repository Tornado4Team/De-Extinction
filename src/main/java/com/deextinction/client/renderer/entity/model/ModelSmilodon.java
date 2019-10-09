package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntitySmilodon;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * Smilodon Populator - TheSirBatman Created using Tabula 7.0.0
 */
public class ModelSmilodon extends ResettableModelBase
{
	public ResettableModelRenderer body_back;
	public ResettableModelRenderer left_arm_1;
	public ResettableModelRenderer left_leg_1;
	public ResettableModelRenderer right_leg_1;
	public ResettableModelRenderer right_arm_1;
	public ResettableModelRenderer body_front;
	public ResettableModelRenderer tail;
	public ResettableModelRenderer neck;
	public ResettableModelRenderer hump_2;
	public ResettableModelRenderer head;
	public ResettableModelRenderer hump_1;
	public ResettableModelRenderer top_jaw;
	public ResettableModelRenderer lower_jaw;
	public ResettableModelRenderer left_ear;
	public ResettableModelRenderer right_ear;
	public ResettableModelRenderer snout;
	public ResettableModelRenderer left_tooth;
	public ResettableModelRenderer right_tooth;
	public ResettableModelRenderer left_ear_2;
	public ResettableModelRenderer right_ear_2;
	public ResettableModelRenderer left_arm_2;
	public ResettableModelRenderer left_paw;
	public ResettableModelRenderer left_leg_2;
	public ResettableModelRenderer left_leg_3;
	public ResettableModelRenderer left_foot;
	public ResettableModelRenderer right_leg_2;
	public ResettableModelRenderer right_leg_3;
	public ResettableModelRenderer right_foot;
	public ResettableModelRenderer right_arm_2;
	public ResettableModelRenderer right_paw;
	private Animator animator;

	public ModelSmilodon()
	{
		this.textureWidth = 80;
		this.textureHeight = 100;

		this.hump_1 = new ResettableModelRenderer(this, 33, 8);
		this.hump_1.setRotationPoint(-2.0F, -3.5F, -5.6F);
		this.hump_1.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
		this.hump_1.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.right_leg_1 = new ResettableModelRenderer(this, 18, 39);
		this.right_leg_1.setRotationPoint(-1.1F, 9.4F, 7.0F);
		this.right_leg_1.addBox(-4.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
		this.right_leg_1.setRotateAngle(-0.136659280431156F, 0.0F, 0.0F);

		this.left_ear = new ResettableModelRenderer(this, 40, 31);
		this.left_ear.setRotationPoint(2.7F, -1.0F, -0.2F);
		this.left_ear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.left_ear.setRotateAngle(-1.0016444577195458F, 0.40980330836826856F, 0.0F);

		this.right_foot = new ResettableModelRenderer(this, 30, 61);
		this.right_foot.setRotationPoint(0.0F, 3.4F, 0.4F);
		this.right_foot.addBox(-1.5F, 0.0F, -2.5F, 3, 2, 3, 0.0F);
		this.right_foot.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.neck = new ResettableModelRenderer(this, 46, 0);
		this.neck.setRotationPoint(0.0F, -0.8F, -6.8F);
		this.neck.addBox(-2.5F, -3.5F, -6.0F, 5, 5, 6, 0.0F);
		this.neck.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.left_ear_2 = new ResettableModelRenderer(this, 48, 31);
		this.left_ear_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.left_ear_2.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
		this.left_ear_2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.right_leg_2 = new ResettableModelRenderer(this, 18, 51);
		this.right_leg_2.setRotationPoint(-2.0F, 5.0F, 1.4F);
		this.right_leg_2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.right_leg_2.setRotateAngle(0.36425021489121656F, 0.0F, 0.0F);

		this.left_paw = new ResettableModelRenderer(this, 0, 63);
		this.left_paw.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.left_paw.addBox(-2.0F, 0.0F, -2.5F, 4, 2, 4, 0.0F);
		this.left_paw.setRotateAngle(0.045553093477052F, 0.0F, 0.0F);

		this.left_leg_1 = new ResettableModelRenderer(this, 18, 39);
		this.left_leg_1.setRotationPoint(1.1F, 9.4F, 7.0F);
		this.left_leg_1.addBox(0.0F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
		this.left_leg_1.setRotateAngle(-0.136659280431156F, 0.0F, 0.0F);

		this.left_leg_2 = new ResettableModelRenderer(this, 18, 51);
		this.left_leg_2.setRotationPoint(2.0F, 5.0F, 1.4F);
		this.left_leg_2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
		this.left_leg_2.setRotateAngle(0.36425021489121656F, 0.0F, 0.0F);

		this.right_tooth = new ResettableModelRenderer(this, 40, 44);
		this.right_tooth.setRotationPoint(-2.4F, 1.0F, -4.3F);
		this.right_tooth.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.right_tooth.setRotateAngle(0.4553564018453205F, 0.0F, 0.0F);

		this.left_arm_1 = new ResettableModelRenderer(this, 0, 39);
		this.left_arm_1.setRotationPoint(1.0F, 11.4F, -7.0F);
		this.left_arm_1.addBox(0.0F, 0.0F, -1.0F, 4, 5, 4, 0.0F);
		this.left_arm_1.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.right_ear = new ResettableModelRenderer(this, 53, 31);
		this.right_ear.setRotationPoint(-2.7F, -1.0F, -0.5F);
		this.right_ear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.right_ear.setRotateAngle(-1.0016444577195458F, -0.40980330836826856F, 0.0F);

		this.top_jaw = new ResettableModelRenderer(this, 37, 37);
		this.top_jaw.setRotationPoint(0.0F, 0.7F, -1.0F);
		this.top_jaw.addBox(-2.5F, -0.7F, -4.6F, 5, 2, 3, 0.0F);
		this.top_jaw.setRotateAngle(-0.36425021489121656F, 0.0F, 0.0F);

		this.lower_jaw = new ResettableModelRenderer(this, 42, 46);
		this.lower_jaw.setRotationPoint(0.0F, 1.5F, -1.8F);
		this.lower_jaw.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 4, 0.0F);
		this.lower_jaw.setRotateAngle(-0.136659280431156F, 0.0F, 0.0F);

		this.right_arm_2 = new ResettableModelRenderer(this, 0, 50);
		this.right_arm_2.setRotationPoint(-2.0F, 4.2F, 1.6F);
		this.right_arm_2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.right_arm_2.setRotateAngle(-0.31869712141416456F, 0.0F, 0.0F);

		this.right_paw = new ResettableModelRenderer(this, 0, 63);
		this.right_paw.setRotationPoint(0.0F, 7.0F, 0.0F);
		this.right_paw.addBox(-2.0F, 0.0F, -2.5F, 4, 2, 4, 0.0F);
		this.right_paw.setRotateAngle(0.045553093477052F, 0.0F, 0.0F);

		this.body_front = new ResettableModelRenderer(this, 0, 0);
		this.body_front.setRotationPoint(0.0F, -0.1F, 0.8F);
		this.body_front.addBox(-4.0F, -4.5F, -8.0F, 8, 8, 8, 0.0F);
		this.body_front.setRotateAngle(0.045553093477052F, 0.0F, 0.0F);

		this.body_back = new ResettableModelRenderer(this, 0, 18);
		this.body_back.setRotationPoint(0.0F, 12.5F, -2.4F);
		this.body_back.addBox(-3.5F, -4.5F, 0.0F, 7, 7, 12, 0.0F);
		this.body_back.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.left_foot = new ResettableModelRenderer(this, 30, 61);
		this.left_foot.setRotationPoint(0.0F, 3.4F, 0.4F);
		this.left_foot.addBox(-1.5F, 0.0F, -2.5F, 3, 2, 3, 0.0F);
		this.left_foot.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.left_arm_2 = new ResettableModelRenderer(this, 0, 50);
		this.left_arm_2.setRotationPoint(2.0F, 4.2F, 1.6F);
		this.left_arm_2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
		this.left_arm_2.setRotateAngle(-0.31869712141416456F, 0.0F, 0.0F);

		this.left_tooth = new ResettableModelRenderer(this, 35, 44);
		this.left_tooth.setRotationPoint(1.4F, 1.0F, -4.3F);
		this.left_tooth.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
		this.left_tooth.setRotateAngle(0.4553564018453205F, 0.0F, 0.0F);

		this.left_leg_3 = new ResettableModelRenderer(this, 18, 61);
		this.left_leg_3.setRotationPoint(0.0F, 4.3F, 0.6F);
		this.left_leg_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.left_leg_3.setRotateAngle(-0.40980330836826856F, 0.0F, 0.0F);

		this.hump_2 = new ResettableModelRenderer(this, 45, 12);
		this.hump_2.setRotationPoint(0.5F, 0.0F, 4.0F);
		this.hump_2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
		this.hump_2.setRotateAngle(-0.5347688828110626F, 0.0F, 0.0F);

		this.right_leg_3 = new ResettableModelRenderer(this, 18, 61);
		this.right_leg_3.setRotationPoint(0.0F, 4.3F, 0.6F);
		this.right_leg_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.right_leg_3.setRotateAngle(-0.40980330836826856F, 0.0F, 0.0F);

		this.tail = new ResettableModelRenderer(this, 28, 18);
		this.tail.setRotationPoint(0.0F, -3.7F, 11.3F);
		this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
		this.tail.setRotateAngle(-0.7285004297824331F, 0.0F, 0.0F);

		this.head = new ResettableModelRenderer(this, 43, 22);
		this.head.setRotationPoint(0.0F, -1.2F, -5.0F);
		this.head.addBox(-3.0F, -2.5F, -3.0F, 6, 5, 3, 0.0F);
		this.head.setRotateAngle(0.36425021489121656F, 0.0F, 0.0F);

		this.right_arm_1 = new ResettableModelRenderer(this, 0, 39);
		this.right_arm_1.setRotationPoint(-1.0F, 11.4F, -7.0F);
		this.right_arm_1.addBox(-4.0F, 0.0F, -1.0F, 4, 5, 4, 0.0F);
		this.right_arm_1.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.snout = new ResettableModelRenderer(this, 51, 39);
		this.snout.setRotationPoint(0.0F, -1.4F, -4.2F);
		this.snout.addBox(-2.0F, 0.0F, -1.9F, 4, 2, 4, 0.0F);
		this.snout.setRotateAngle(0.5462880558742251F, 0.0F, 0.0F);

		this.right_ear_2 = new ResettableModelRenderer(this, 60, 31);
		this.right_ear_2.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.right_ear_2.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
		this.right_ear_2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.neck.addChild(this.hump_1);
		this.head.addChild(this.left_ear);
		this.right_leg_3.addChild(this.right_foot);
		this.body_front.addChild(this.neck);
		this.left_ear.addChild(this.left_ear_2);
		this.right_leg_1.addChild(this.right_leg_2);
		this.left_arm_2.addChild(this.left_paw);
		this.left_leg_1.addChild(this.left_leg_2);
		this.top_jaw.addChild(this.right_tooth);
		this.head.addChild(this.right_ear);
		this.head.addChild(this.top_jaw);
		this.head.addChild(this.lower_jaw);
		this.right_arm_1.addChild(this.right_arm_2);
		this.right_arm_2.addChild(this.right_paw);
		this.body_back.addChild(this.body_front);
		this.left_leg_3.addChild(this.left_foot);
		this.left_arm_1.addChild(this.left_arm_2);
		this.top_jaw.addChild(this.left_tooth);
		this.left_leg_2.addChild(this.left_leg_3);
		this.right_leg_2.addChild(this.right_leg_3);
		this.hump_1.addChild(this.hump_2);
		this.body_back.addChild(this.tail);
		this.neck.addChild(this.head);
		this.top_jaw.addChild(this.snout);
		this.right_ear.addChild(this.right_ear_2);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntitySmilodon animal = (EntitySmilodon) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.right_leg_1.render(scale);
		this.left_leg_1.render(scale);
		this.left_arm_1.render(scale);
		this.body_back.render(scale);
		this.right_arm_1.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();
		EntitySmilodon animal = (EntitySmilodon) entity;
		float sittingProgress = animal.getSittingProgress(partialRenderTicks);

		if (sittingProgress > 0.001F)
		{
			this.body_back.rotateAngleX -= 0.75F * sittingProgress;
			this.body_front.rotateAngleX += 0.25F * sittingProgress;
			this.body_front.rotationPointZ += 1.0F * sittingProgress;
			this.neck.rotateAngleX += 0.25F * sittingProgress;

			this.left_leg_1.rotateAngleX -= 1.0F * sittingProgress;
			this.left_leg_1.rotationPointY += 4.8F * sittingProgress;
			this.left_leg_1.rotationPointZ -= 1.0F * sittingProgress;

			this.left_leg_2.rotateAngleX += 1.5F * sittingProgress;
			this.left_leg_2.rotationPointY -= 0.5F * sittingProgress;
			this.left_leg_2.rotationPointZ += 2.0F * sittingProgress;

			this.left_leg_3.rotateAngleX -= 1.85F * sittingProgress;
			this.left_leg_3.rotationPointZ -= 1.0F * sittingProgress;

			this.left_foot.rotateAngleX += 1.35F * sittingProgress;
			this.left_foot.rotationPointZ -= 1.4F * sittingProgress;

			this.right_leg_1.rotateAngleX -= 1.0F * sittingProgress;
			this.right_leg_1.rotationPointY += 4.8F * sittingProgress;
			this.right_leg_1.rotationPointZ -= 1.0F * sittingProgress;

			this.right_leg_2.rotateAngleX += 1.5F * sittingProgress;
			this.right_leg_2.rotationPointY -= 0.5F * sittingProgress;
			this.right_leg_2.rotationPointZ += 2.0F * sittingProgress;

			this.right_leg_3.rotateAngleX -= 1.85F * sittingProgress;
			this.right_leg_3.rotationPointZ -= 1.0F * sittingProgress;

			this.right_foot.rotateAngleX += 1.35F * sittingProgress;
			this.right_foot.rotationPointZ -= 1.4F * sittingProgress;
		}
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntitySmilodon animal)
	{
		float animSpeed = 0.35F;

		if (animal.hasItemInSlot(EntityEquipmentSlot.MAINHAND))
			this.lower_jaw.rotateAngleX += 0.35F;

		if (animal.isSitting())
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
			this.body_front.rotateAngleX += naturalMovement;
			this.neck.rotateAngleX -= naturalMovement;
			this.tail.rotateAngleX += naturalMovement;

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
				this.body_back.rotationPointX -= bodyBob1;
				this.right_leg_1.rotationPointX -= bodyBob1;
				this.left_leg_1.rotationPointX -= bodyBob1;
				this.right_arm_1.rotationPointX -= bodyBob1;
				this.left_arm_1.rotationPointX -= bodyBob1;

				float bodyBob2 = this.getRotateAngle(time, walkSpeed, 2.0F * animSpeed, 1.0F);
				this.body_back.rotationPointY -= bodyBob2;
				this.right_leg_1.rotationPointY -= bodyBob2;
				this.left_leg_1.rotationPointY -= bodyBob2;
				this.right_arm_1.rotationPointY -= bodyBob2;
				this.left_arm_1.rotationPointY -= bodyBob2;

				if (animal.getAnimID() != DeAnimationList.ATTACKING)
				{
					float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.4F);
					float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 1F);
					float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.6F, -1.5707963268F, -0.3F);
					float lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

					float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.4F);
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

					this.left_arm_1.rotateAngleX += 1.2F * rleg1;
					this.left_arm_2.rotateAngleX += rleg2;
					this.left_paw.rotateAngleX += rfoot;

					this.right_arm_1.rotateAngleX += 1.2F * lleg1;
					this.right_arm_2.rotateAngleX += lleg2;
					this.right_paw.rotateAngleX += lfoot;

					float headY = yaw / 57.2957795131F / 2.0F;
					this.neck.rotateAngleY += headY;
					this.head.rotateAngleY += headY;

					float headX = pitch / 57.2957795131F / 2.0F;
					this.neck.rotateAngleY += headX;
					this.head.rotateAngleY += headX;
				}
			}
			else
			{
				float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
				this.body_front.rotateAngleX += naturalMovement;
				this.neck.rotateAngleX -= naturalMovement;
				this.tail.rotateAngleX += naturalMovement;

				float headY = yaw / 57.2957795131F / 2.0F;
				this.neck.rotateAngleY += headY;
				this.head.rotateAngleY += headY;

				float headX = pitch / 57.2957795131F / 2.0F;
				this.neck.rotateAngleY += headX;
				this.head.rotateAngleY += headX;
			}
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntitySmilodon animal)
	{
		if (animal.getAnimID() == DeAnimationList.SOUND_1)
		{
			if (!animal.hasItemInSlot(EntityEquipmentSlot.MAINHAND))
			{
				this.animator.update(animal);
				this.animator.setAnim(DeAnimationList.SOUND_1);

				this.animator.startPhase(5);
				this.animator.rotate(this.lower_jaw, ResettableModelBase.RAD_45_DEGREES, 0.0F, 0.0F);

				this.animator.endPhase();
				this.animator.resetPhase(10);
			}
		}
		else if (animal.getAnimID() == DeAnimationList.ATTACKING)
		{
			this.animator.update(animal);
			this.animator.setAnim(DeAnimationList.ATTACKING);

			this.animator.startPhase(10);
			this.animator.rotate(this.body_back, -ResettableModelBase.RAD_20_DEGREES, 0.0F, 0.0F);
			this.animator.move(this.body_back, 0.0F, -5.0F, 0.0F);

			this.animator.rotate(this.left_leg_1, ResettableModelBase.RAD_30_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.right_leg_1, ResettableModelBase.RAD_30_DEGREES, 0.0F, 0.0F);
			this.animator.move(this.left_leg_1, 0.0F, -1.0F, -2.0F);
			this.animator.move(this.right_leg_1, 0.0F, -1.0F, -2.0F);

			this.animator.rotate(this.body_front, -ResettableModelBase.RAD_20_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.neck, ResettableModelBase.RAD_20_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.lower_jaw, ResettableModelBase.RAD_90_DEGREES, 0.0F, 0.0F);

			this.animator.rotate(this.left_arm_1, -ResettableModelBase.RAD_90_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.right_arm_1, -ResettableModelBase.RAD_90_DEGREES, 0.0F, 0.0F);
			this.animator.move(this.left_arm_1, 0.0F, -5.0F, 3.0F);
			this.animator.move(this.right_arm_1, 0.0F, -5.0F, 3.0F);
			this.animator.endPhase();

			this.animator.startPhase(5);
			this.animator.rotate(this.body_back, -ResettableModelBase.RAD_10_DEGREES, 0.0F, 0.0F);
			this.animator.move(this.body_back, 0.0F, -5.0F, 0.0F);

			this.animator.rotate(this.left_leg_1, ResettableModelBase.RAD_15_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.right_leg_1, ResettableModelBase.RAD_15_DEGREES, 0.0F, 0.0F);
			this.animator.move(this.left_leg_1, 0.0F, -3.0F, -2.0F);
			this.animator.move(this.right_leg_1, 0.0F, -3.0F, -2.0F);

			this.animator.rotate(this.body_front, ResettableModelBase.RAD_5_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.neck, -ResettableModelBase.RAD_5_DEGREES, 0.0F, 0.0F);

			this.animator.rotate(this.left_arm_1, -ResettableModelBase.RAD_30_DEGREES, 0.0F, 0.0F);
			this.animator.rotate(this.right_arm_1, -ResettableModelBase.RAD_30_DEGREES, 0.0F, 0.0F);
			this.animator.move(this.left_arm_1, 0.0F, -4.0F, 0.0F);
			this.animator.move(this.right_arm_1, 0.0F, -4.0F, 0.0F);
			this.animator.endPhase();

			this.animator.resetPhase(5);
		}
	}

	private void resetPose()
	{
		this.body_back.resetParameters();
		this.left_arm_1.resetParameters();
		this.left_leg_1.resetParameters();
		this.right_leg_1.resetParameters();
		this.right_arm_1.resetParameters();
		this.body_front.resetParameters();
		this.tail.resetParameters();
		this.neck.resetParameters();
		this.head.resetParameters();
		this.top_jaw.resetParameters();
		this.lower_jaw.resetParameters();
		this.snout.resetParameters();
		this.left_arm_2.resetParameters();
		this.left_paw.resetParameters();
		this.left_leg_2.resetParameters();
		this.left_leg_3.resetParameters();
		this.left_foot.resetParameters();
		this.right_leg_2.resetParameters();
		this.right_leg_3.resetParameters();
		this.right_foot.resetParameters();
		this.right_arm_2.resetParameters();
		this.right_paw.resetParameters();
	}
}
