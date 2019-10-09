package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntityCanisNehringi;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * Canis Nehringi - Batman Created using Tabula 7.0.0
 */
public class ModelCanisNehringi extends ResettableModelBase
{
	public ResettableModelRenderer rear;
	public ResettableModelRenderer leftarm1;
	public ResettableModelRenderer rightarm1;
	public ResettableModelRenderer leftleg1;
	public ResettableModelRenderer rightleg1;
	public ResettableModelRenderer front;
	public ResettableModelRenderer bellyfur;
	public ResettableModelRenderer tail1;
	public ResettableModelRenderer neck;
	public ResettableModelRenderer head;
	public ResettableModelRenderer neckfur;
	public ResettableModelRenderer topjaw;
	public ResettableModelRenderer lowerjaw;
	public ResettableModelRenderer leftear1;
	public ResettableModelRenderer rightear1;
	public ResettableModelRenderer snout;
	public ResettableModelRenderer leftear2;
	public ResettableModelRenderer leftear3;
	public ResettableModelRenderer rightear2;
	public ResettableModelRenderer rightear3;
	public ResettableModelRenderer tail2;
	public ResettableModelRenderer tailfur1;
	public ResettableModelRenderer tail3;
	public ResettableModelRenderer tailfur2;
	public ResettableModelRenderer tailfur3;
	public ResettableModelRenderer leftarm2;
	public ResettableModelRenderer leftarm3;
	public ResettableModelRenderer leftpaw;
	public ResettableModelRenderer rightarm2;
	public ResettableModelRenderer rightarm3;
	public ResettableModelRenderer rightpaw;
	public ResettableModelRenderer leftleg2;
	public ResettableModelRenderer leftleg3;
	public ResettableModelRenderer leftfoot;
	public ResettableModelRenderer rightleg2;
	public ResettableModelRenderer rightleg3;
	public ResettableModelRenderer rightfoot;
	private Animator animator;

	public ModelCanisNehringi()
	{
		this.textureWidth = 80;
		this.textureHeight = 200;

		this.tailfur2 = new ResettableModelRenderer(this, 36, 139);
		this.tailfur2.setRotationPoint(-1.5F, 1.9F, 0.9F);
		this.tailfur2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 10, 0.0F);
		this.tailfur2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.bellyfur = new ResettableModelRenderer(this, 0, 107);
		this.bellyfur.setRotationPoint(-3.5F, 3.8F, 0.0F);
		this.bellyfur.addBox(0.0F, 0.0F, 0.0F, 7, 3, 14, 0.0F);
		this.bellyfur.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.tail2 = new ResettableModelRenderer(this, 0, 177);
		this.tail2.setRotationPoint(0.0F, -0.5F, 9.0F);
		this.tail2.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 11, 0.0F);
		this.tail2.setRotateAngle(-0.22759093446006054F, 0.0F, 0.0F);

		this.leftpaw = new ResettableModelRenderer(this, 0, 162);
		this.leftpaw.setRotationPoint(0.0F, 3.3F, 1.0F);
		this.leftpaw.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		this.leftpaw.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.leftear3 = new ResettableModelRenderer(this, 37, 86);
		this.leftear3.setRotationPoint(0.0F, -1.9F, 0.0F);
		this.leftear3.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
		this.leftear3.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.rightarm3 = new ResettableModelRenderer(this, 0, 153);
		this.rightarm3.setRotationPoint(0.0F, 8.5F, -0.4F);
		this.rightarm3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 3, 0.0F);
		this.rightarm3.setRotateAngle(-0.18203784098300857F, 0.0F, 0.0F);

		this.leftleg1 = new ResettableModelRenderer(this, 20, 126);
		this.leftleg1.setRotationPoint(4.0F, 4.5F, 11.0F);
		this.leftleg1.addBox(-2.0F, 0.0F, -3.5F, 4, 6, 7, 0.0F);
		this.leftleg1.setRotateAngle(-0.18203784098300857F, 0.0F, 0.0F);

		this.rightear1 = new ResettableModelRenderer(this, 20, 92);
		this.rightear1.setRotationPoint(-3.3F, -1.3F, -1.0F);
		this.rightear1.addBox(-1.5F, -2.0F, -0.5F, 3, 2, 1, 0.0F);
		this.rightear1.setRotateAngle(0.0F, 1.0471975511965976F, -0.27314402793711257F);

		this.leftarm1 = new ResettableModelRenderer(this, 0, 126);
		this.leftarm1.setRotationPoint(4.0F, 5.9F, -7.0F);
		this.leftarm1.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
		this.leftarm1.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.lowerjaw = new ResettableModelRenderer(this, 0, 84);
		this.lowerjaw.setRotationPoint(0.0F, 2.5F, -5.3F);
		this.lowerjaw.addBox(-1.5F, -1.0F, -6.0F, 3, 2, 6, 0.0F);
		this.lowerjaw.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.tail1 = new ResettableModelRenderer(this, 20, 167);
		this.tail1.setRotationPoint(0.0F, -3.6F, 11.9F);
		this.tail1.addBox(-2.5F, -2.5F, 0.0F, 5, 5, 10, 0.0F);
		this.tail1.setRotateAngle(-0.8196066167365371F, 0.0F, 0.0F);

		this.neck = new ResettableModelRenderer(this, 0, 49);
		this.neck.setRotationPoint(0.0F, -1.0F, -8.6F);
		this.neck.addBox(-3.0F, -3.5F, -11.0F, 6, 7, 11, 0.0F);
		this.neck.setRotateAngle(-0.27314402793711257F, 0.0F, 0.0F);

		this.leftear2 = new ResettableModelRenderer(this, 29, 86);
		this.leftear2.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.leftear2.addBox(-1.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F);
		this.leftear2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.front = new ResettableModelRenderer(this, 0, 0);
		this.front.setRotationPoint(0.0F, -0.5F, 1.0F);
		this.front.addBox(-5.0F, -5.0F, -11.0F, 10, 10, 11, 0.0F);
		this.front.setRotateAngle(0.091106186954104F, 0.0F, 0.0F);

		this.rightpaw = new ResettableModelRenderer(this, 0, 162);
		this.rightpaw.setRotationPoint(0.0F, 3.3F, 1.0F);
		this.rightpaw.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		this.rightpaw.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.rightfoot = new ResettableModelRenderer(this, 15, 169);
		this.rightfoot.setRotationPoint(0.0F, 5.6F, 1.0F);
		this.rightfoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		this.rightfoot.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.neckfur = new ResettableModelRenderer(this, 0, 94);
		this.neckfur.setRotationPoint(0.0F, 3.2F, -10.7F);
		this.neckfur.addBox(-2.5F, 0.0F, 0.0F, 5, 2, 9, 0.0F);
		this.neckfur.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.rightear2 = new ResettableModelRenderer(this, 30, 92);
		this.rightear2.setRotationPoint(0.0F, -2.0F, 0.0F);
		this.rightear2.addBox(-1.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F);
		this.rightear2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.rightleg3 = new ResettableModelRenderer(this, 16, 156);
		this.rightleg3.setRotationPoint(0.0F, 8.0F, 0.2F);
		this.rightleg3.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 3, 0.0F);
		this.rightleg3.setRotateAngle(-0.5009094953223726F, 0.0F, 0.0F);

		this.rear = new ResettableModelRenderer(this, 0, 23);
		this.rear.setRotationPoint(0.0F, 4.8F, 0.0F);
		this.rear.addBox(-4.5F, -5.5F, 0.0F, 9, 10, 14, 0.0F);
		this.rear.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.rightleg2 = new ResettableModelRenderer(this, 16, 141);
		this.rightleg2.setRotationPoint(0.0F, 4.8F, -1.7F);
		this.rightleg2.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, 0.0F);
		this.rightleg2.setRotateAngle(0.5009094953223726F, 0.0F, 0.0F);

		this.rightarm1 = new ResettableModelRenderer(this, 0, 126);
		this.rightarm1.setRotationPoint(-4.0F, 5.9F, -7.0F);
		this.rightarm1.addBox(-2.0F, 0.0F, -2.5F, 4, 6, 5, 0.0F);
		this.rightarm1.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.leftleg2 = new ResettableModelRenderer(this, 16, 141);
		this.leftleg2.setRotationPoint(0.0F, 4.8F, -1.7F);
		this.leftleg2.addBox(-1.5F, 0.0F, -2.0F, 3, 9, 4, 0.0F);
		this.leftleg2.setRotateAngle(0.5009094953223726F, 0.0F, 0.0F);

		this.rightleg1 = new ResettableModelRenderer(this, 20, 126);
		this.rightleg1.setRotationPoint(-4.0F, 4.5F, 11.0F);
		this.rightleg1.addBox(-2.0F, 0.0F, -3.5F, 4, 6, 7, 0.0F);
		this.rightleg1.setRotateAngle(-0.18203784098300857F, 0.0F, 0.0F);

		this.tail3 = new ResettableModelRenderer(this, 33, 185);
		this.tail3.setRotationPoint(0.0F, -0.5F, 10.7F);
		this.tail3.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 4, 0.0F);
		this.tail3.setRotateAngle(-0.136659280431156F, 0.0F, 0.0F);

		this.snout = new ResettableModelRenderer(this, 28, 73);
		this.snout.setRotationPoint(0.0F, -1.5F, -6.7F);
		this.snout.addBox(-1.5F, 0.0F, 0.0F, 3, 3, 8, 0.0F);
		this.snout.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.leftleg3 = new ResettableModelRenderer(this, 16, 156);
		this.leftleg3.setRotationPoint(0.0F, 8.0F, 0.2F);
		this.leftleg3.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 3, 0.0F);
		this.leftleg3.setRotateAngle(-0.5009094953223726F, 0.0F, 0.0F);

		this.tailfur3 = new ResettableModelRenderer(this, 42, 167);
		this.tailfur3.setRotationPoint(-1.0F, 1.0F, -0.1F);
		this.tailfur3.addBox(0.0F, 0.0F, 0.0F, 2, 3, 4, 0.0F);
		this.tailfur3.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.leftarm3 = new ResettableModelRenderer(this, 0, 153);
		this.leftarm3.setRotationPoint(0.0F, 8.5F, -0.4F);
		this.leftarm3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 3, 0.0F);
		this.leftarm3.setRotateAngle(-0.18203784098300857F, 0.0F, 0.0F);

		this.rightarm2 = new ResettableModelRenderer(this, 0, 139);
		this.rightarm2.setRotationPoint(0.0F, 5.0F, 1.0F);
		this.rightarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.rightarm2.setRotateAngle(-0.4553564018453205F, 0.0F, 0.0F);

		this.tailfur1 = new ResettableModelRenderer(this, 30, 153);
		this.tailfur1.setRotationPoint(-2.0F, 2.0F, -0.1F);
		this.tailfur1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 10, 0.0F);
		this.tailfur1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.rightear3 = new ResettableModelRenderer(this, 39, 92);
		this.rightear3.setRotationPoint(0.0F, -1.9F, 0.0F);
		this.rightear3.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
		this.rightear3.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.leftear1 = new ResettableModelRenderer(this, 19, 86);
		this.leftear1.setRotationPoint(3.3F, -1.3F, -1.0F);
		this.leftear1.addBox(-1.5F, -2.0F, -0.5F, 3, 2, 1, 0.0F);
		this.leftear1.setRotateAngle(0.0F, -1.0471975511965976F, 0.27314402793711257F);

		this.head = new ResettableModelRenderer(this, 1, 69);
		this.head.setRotationPoint(0.0F, -0.4F, -9.7F);
		this.head.addBox(-3.5F, -3.5F, -6.0F, 7, 7, 6, 0.0F);
		this.head.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.leftarm2 = new ResettableModelRenderer(this, 0, 139);
		this.leftarm2.setRotationPoint(0.0F, 5.0F, 1.0F);
		this.leftarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.leftarm2.setRotateAngle(-0.4553564018453205F, 0.0F, 0.0F);

		this.topjaw = new ResettableModelRenderer(this, 30, 63);
		this.topjaw.setRotationPoint(0.0F, 0.5F, -5.5F);
		this.topjaw.addBox(-2.0F, -1.5F, -6.0F, 4, 3, 6, 0.0F);
		this.topjaw.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.leftfoot = new ResettableModelRenderer(this, 15, 169);
		this.leftfoot.setRotationPoint(0.0F, 5.6F, 1.0F);
		this.leftfoot.addBox(-1.5F, 0.0F, -3.0F, 3, 2, 4, 0.0F);
		this.leftfoot.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.tail2.addChild(this.tailfur2);
		this.rear.addChild(this.bellyfur);
		this.tail1.addChild(this.tail2);
		this.leftarm3.addChild(this.leftpaw);
		this.leftear2.addChild(this.leftear3);
		this.rightarm2.addChild(this.rightarm3);
		this.head.addChild(this.rightear1);
		this.head.addChild(this.lowerjaw);
		this.rear.addChild(this.tail1);
		this.front.addChild(this.neck);
		this.leftear1.addChild(this.leftear2);
		this.rear.addChild(this.front);
		this.rightarm3.addChild(this.rightpaw);
		this.rightleg3.addChild(this.rightfoot);
		this.neck.addChild(this.neckfur);
		this.rightear1.addChild(this.rightear2);
		this.rightleg2.addChild(this.rightleg3);
		this.rightleg1.addChild(this.rightleg2);
		this.leftleg1.addChild(this.leftleg2);
		this.tail2.addChild(this.tail3);
		this.topjaw.addChild(this.snout);
		this.leftleg2.addChild(this.leftleg3);
		this.tail3.addChild(this.tailfur3);
		this.leftarm2.addChild(this.leftarm3);
		this.rightarm1.addChild(this.rightarm2);
		this.tail1.addChild(this.tailfur1);
		this.rightear2.addChild(this.rightear3);
		this.head.addChild(this.leftear1);
		this.neck.addChild(this.head);
		this.leftarm1.addChild(this.leftarm2);
		this.head.addChild(this.topjaw);
		this.leftleg3.addChild(this.leftfoot);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityCanisNehringi animal = (EntityCanisNehringi) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.leftleg1.render(scale);
		this.leftarm1.render(scale);
		this.rear.render(scale);
		this.rightarm1.render(scale);
		this.rightleg1.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();
		EntityCanisNehringi animal = (EntityCanisNehringi) entity;
		float sittingProgress = animal.getSittingProgress(partialRenderTicks);
		if (sittingProgress > 0.001F)
		{
			this.rear.rotationPointY += 10.0F * sittingProgress;

			this.head.rotateAngleX += 0.15F * sittingProgress;
			this.neck.rotateAngleX -= 0.15F * sittingProgress;

			this.tail2.rotateAngleX += 0.6F * sittingProgress;
			this.tail3.rotateAngleX += 0.6F * sittingProgress;

			this.leftleg1.rotationPointY += 10.0F * sittingProgress;
			this.leftleg1.rotateAngleX -= 0.5F * sittingProgress;
			this.leftleg2.rotateAngleX += 1.2F * sittingProgress;
			this.leftleg3.rotationPointZ -= 1.0F * sittingProgress;
			this.leftleg3.rotateAngleX -= 2.1F * sittingProgress;
			this.leftfoot.rotationPointY += 1.0F * sittingProgress;
			this.leftfoot.rotationPointZ -= 1.0F * sittingProgress;
			this.leftfoot.rotateAngleX += 1.4F * sittingProgress;

			this.rightleg1.rotationPointY += 10.0F * sittingProgress;
			this.rightleg1.rotateAngleX -= 0.5F * sittingProgress;
			this.rightleg2.rotateAngleX += 1.2F * sittingProgress;
			this.rightleg3.rotationPointZ -= 1.0F * sittingProgress;
			this.rightleg3.rotateAngleX -= 2.1F * sittingProgress;
			this.rightfoot.rotationPointY += 1.0F * sittingProgress;
			this.rightfoot.rotationPointZ -= 1.0F * sittingProgress;
			this.rightfoot.rotateAngleX += 1.4F * sittingProgress;

			this.leftarm1.rotationPointY += 10.0F * sittingProgress;
			this.leftarm1.rotateAngleX += 0.25F * sittingProgress;
			this.leftarm2.rotationPointY += 2.0F * sittingProgress;
			this.leftarm2.rotateAngleX -= 1.6F * sittingProgress;
			this.leftarm3.rotateAngleX += 0.15F * sittingProgress;
			this.leftpaw.rotationPointY += 1.0F * sittingProgress;
			this.leftpaw.rotationPointZ -= 1.0F * sittingProgress;
			this.leftpaw.rotateAngleX += 1.3F * sittingProgress;

			this.rightarm1.rotationPointY += 10.0F * sittingProgress;
			this.rightarm1.rotateAngleX += 0.25F * sittingProgress;
			this.rightarm2.rotationPointY += 2.0F * sittingProgress;
			this.rightarm2.rotateAngleX -= 1.6F * sittingProgress;
			this.rightarm3.rotateAngleX += 0.15F * sittingProgress;
			this.rightpaw.rotationPointY += 1.0F * sittingProgress;
			this.rightpaw.rotationPointZ -= 1.0F * sittingProgress;
			this.rightpaw.rotateAngleX += 1.3F * sittingProgress;
		}
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityCanisNehringi animal)
	{
		float animSpeed = 0.35F;

		float headY = yaw / 57.2957795131F / 2.0F;
		this.neck.rotateAngleY += headY;
		this.head.rotateAngleY += headY;

		float headX = pitch / 57.2957795131F / 2.0F;
		this.neck.rotateAngleY += headX;
		this.head.rotateAngleY += headX;

		if (animal.isSitting())
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.15F * animSpeed, 0.02F);
			this.front.rotateAngleX -= naturalMovement;
			this.head.rotateAngleX += naturalMovement;
			naturalMovement = 0.333F * naturalMovement;
			this.neck.rotateAngleX -= naturalMovement;
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

				float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.4F);
				float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 1F);
				float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.6F, -1.5707963268F, -0.3F);
				float lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

				float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.14159F, -0.4F);
				float rleg2 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.4F, 1.5707963268F, 01F);
				float rleg3 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.6F, -1.5707963268F, -0.3F);
				float rfoot = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.35F);

				this.leftleg1.rotateAngleX += lleg1;
				this.leftleg2.rotateAngleX += lleg2;
				this.leftleg3.rotateAngleX += lleg3;
				this.leftfoot.rotateAngleX += lfoot;

				this.rightleg1.rotateAngleX += rleg1;
				this.rightleg2.rotateAngleX += rleg2;
				this.rightleg3.rotateAngleX += rleg3;
				this.rightfoot.rotateAngleX += rfoot;

				this.leftarm1.rotateAngleX += rleg1;
				this.leftarm2.rotateAngleX += rleg2;
				this.leftpaw.rotateAngleX += rfoot;

				this.rightarm1.rotateAngleX += lleg1;
				this.rightarm2.rotateAngleX += lleg2;
				this.rightpaw.rotateAngleX += lfoot;

				rfoot = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.7F);
				lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.7F, -1.5707963268F, 0.7F);

				this.leftarm3.rotateAngleX += 0.5F * rfoot;
				this.rightarm3.rotateAngleX += 0.5F * lfoot;

				float[] tail = this.getChainMovement(time, walkSpeed, 3, animSpeed, 0.2F, 2.0F);
				this.tail3.rotateAngleX += tail[0];
				this.tail2.rotateAngleX += tail[1];
				this.tail1.rotateAngleX += tail[2];
			}
			else
			{
				float naturalMovement = this.getAlwaysRotateAngle(time, 0.15F * animSpeed, 0.02F);
				this.front.rotateAngleX -= 2.0F * naturalMovement;
				this.rear.rotateAngleX += naturalMovement;
				this.head.rotateAngleX += naturalMovement;
				naturalMovement = 0.333F * naturalMovement;
				this.neck.rotateAngleX -= naturalMovement;
				this.tail1.rotateAngleX += naturalMovement;
				this.tail2.rotateAngleX -= naturalMovement;
				this.tail3.rotateAngleX -= naturalMovement;
			}
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityCanisNehringi animal)
	{
		if (animal.getAnimID() == DeAnimationList.SOUND_1)
		{
			if (!animal.hasItemInSlot(EntityEquipmentSlot.MAINHAND))
			{
				this.animator.update(animal);
				this.animator.setAnim(DeAnimationList.SOUND_1);

				this.animator.startPhase(5);
				this.animator.rotate(this.lowerjaw, ResettableModelBase.RAD_45_DEGREES, 0.0F, 0.0F);

				this.animator.endPhase();
				this.animator.resetPhase(10);
			}
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
		this.bellyfur.resetParameters();
		this.tail1.resetParameters();
		this.neck.resetParameters();
		this.head.resetParameters();
		this.neckfur.resetParameters();
		this.topjaw.resetParameters();
		this.lowerjaw.resetParameters();
		this.leftear1.resetParameters();
		this.rightear1.resetParameters();
		this.snout.resetParameters();
		this.leftear2.resetParameters();
		this.leftear3.resetParameters();
		this.rightear2.resetParameters();
		this.rightear3.resetParameters();
		this.tail2.resetParameters();
		this.tailfur1.resetParameters();
		this.tail3.resetParameters();
		this.tailfur2.resetParameters();
		this.tailfur3.resetParameters();
		this.leftarm2.resetParameters();
		this.leftarm3.resetParameters();
		this.leftpaw.resetParameters();
		this.rightarm2.resetParameters();
		this.rightarm3.resetParameters();
		this.rightpaw.resetParameters();
		this.leftleg2.resetParameters();
		this.leftleg3.resetParameters();
		this.leftfoot.resetParameters();
		this.rightleg2.resetParameters();
		this.rightleg3.resetParameters();
		this.rightfoot.resetParameters();
	}
}
