package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;

import net.minecraft.entity.Entity;

/**
 * Glyptodon - Botmon Created using Tabula 7.0.0
 */
public class ModelGlyptodon extends ResettableModelBase
{
	public ResettableModelRenderer body_base;
	public ResettableModelRenderer left_leg;
	public ResettableModelRenderer right_leg;
	public ResettableModelRenderer right_arm;
	public ResettableModelRenderer left_arm;
	public ResettableModelRenderer body_base_2;
	public ResettableModelRenderer front_1;
	public ResettableModelRenderer rear;
	public ResettableModelRenderer belly_fur_3;
	public ResettableModelRenderer belly_fur_4;
	public ResettableModelRenderer belly_fur_6;
	public ResettableModelRenderer front_2;
	public ResettableModelRenderer neck;
	public ResettableModelRenderer belly_fur_1;
	public ResettableModelRenderer belly_fur_2;
	public ResettableModelRenderer belly_fur_5;
	public ResettableModelRenderer top_1;
	public ResettableModelRenderer top_2;
	public ResettableModelRenderer top_3;
	public ResettableModelRenderer top_4;
	public ResettableModelRenderer head;
	public ResettableModelRenderer top_jaw;
	public ResettableModelRenderer lower_jaw;
	public ResettableModelRenderer left_ear;
	public ResettableModelRenderer right_ear;
	public ResettableModelRenderer snout;
	public ResettableModelRenderer rear_2;
	public ResettableModelRenderer tail_1;
	public ResettableModelRenderer tail_2;
	public ResettableModelRenderer tail_3;
	public ResettableModelRenderer left_foot;
	public ResettableModelRenderer right_foot;
	public ResettableModelRenderer right_hand;
	public ResettableModelRenderer left_hand;

	public ModelGlyptodon()
	{
		this.textureWidth = 100;
		this.textureHeight = 200;
		this.body_base = new ResettableModelRenderer(this, 0, 0);
		this.body_base.setRotationPoint(0.0F, 21.1F, -1.0F);
		this.body_base.addBox(-7.5F, -3.0F, 0.0F, 15, 3, 13, 0.0F);
		this.setRotateAngle(body_base, -0.014137166941154071F, 0.0F, 0.0F);
		this.belly_fur_1 = new ResettableModelRenderer(this, 35, 185);
		this.belly_fur_1.setRotationPoint(5.5F, -0.1F, -9.0F);
		this.belly_fur_1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 9, 0.0F);
		this.top_4 = new ResettableModelRenderer(this, 0, 84);
		this.top_4.setRotationPoint(0.5F, 0.0F, 8.0F);
		this.top_4.addBox(0.5F, 0.0F, 0.0F, 11, 4, 3, 0.0F);
		this.setRotateAngle(top_4, -0.6829473363053812F, 0.0F, 0.0F);
		this.left_foot = new ResettableModelRenderer(this, 35, 168);
		this.left_foot.setRotationPoint(0.0F, 2.4F, 0.1F);
		this.left_foot.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(left_foot, -0.17156586547104258F, 0.0F, 0.0F);
		this.rear = new ResettableModelRenderer(this, 0, 62);
		this.rear.setRotationPoint(0.0F, -0.3F, 12.2F);
		this.rear.addBox(-6.5F, -1.5F, 0.0F, 13, 2, 7, 0.0F);
		this.setRotateAngle(rear, 0.9105382707654417F, 0.0F, 0.0F);
		this.top_3 = new ResettableModelRenderer(this, 0, 126);
		this.top_3.setRotationPoint(0.0F, 0.0F, 8.0F);
		this.top_3.addBox(0.01F, 0.0F, 0.0F, 13, 6, 8, 0.0F);
		this.setRotateAngle(top_3, -0.5462880558742251F, 0.0F, 0.0F);
		this.right_arm = new ResettableModelRenderer(this, 0, 168);
		this.right_arm.setRotationPoint(-4.5F, 20.5F, -6.0F);
		this.right_arm.addBox(0.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.top_jaw = new ResettableModelRenderer(this, 32, 152);
		this.top_jaw.setRotationPoint(0.0F, 1.1F, -2.4F);
		this.top_jaw.addBox(-2.0F, -1.0F, -3.0F, 4, 2, 3, 0.0F);
		this.setRotateAngle(top_jaw, 0.136659280431156F, 0.0F, 0.0F);
		this.top_2 = new ResettableModelRenderer(this, 0, 110);
		this.top_2.setRotationPoint(-6.5F, 0.0F, 9.0F);
		this.top_2.addBox(0.0F, 0.0F, 0.0F, 13, 6, 8, 0.0F);
		this.setRotateAngle(top_2, -0.40980330836826856F, 0.0F, 0.0F);
		this.left_ear = new ResettableModelRenderer(this, 30, 161);
		this.left_ear.setRotationPoint(2.0F, -1.0F, -0.5F);
		this.left_ear.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(left_ear, -0.40980330836826856F, 0.0F, 0.40980330836826856F);
		this.belly_fur_3 = new ResettableModelRenderer(this, 0, 181);
		this.belly_fur_3.setRotationPoint(6.0F, 0.0F, 0.0F);
		this.belly_fur_3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 13, 0.0F);
		this.belly_fur_5 = new ResettableModelRenderer(this, 2, 176);
		this.belly_fur_5.setRotationPoint(-5.0F, 0.0F, -9.0F);
		this.belly_fur_5.addBox(0.0F, 0.0F, 0.0F, 10, 2, 1, 0.0F);
		this.tail_2 = new ResettableModelRenderer(this, 18, 142);
		this.tail_2.setRotationPoint(0.0F, 5.0F, 0.4F);
		this.tail_2.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
		this.left_hand = new ResettableModelRenderer(this, 9, 168);
		this.left_hand.setRotationPoint(0.0F, 2.6F, 0.0F);
		this.left_hand.addBox(-0.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
		this.head = new ResettableModelRenderer(this, 15, 152);
		this.head.setRotationPoint(0.0F, -0.6F, -2.3F);
		this.head.addBox(-2.5F, -1.5F, -3.0F, 5, 5, 3, 0.0F);
		this.belly_fur_6 = new ResettableModelRenderer(this, 26, 176);
		this.belly_fur_6.setRotationPoint(-5.5F, 0.0F, 11.9F);
		this.belly_fur_6.addBox(0.0F, 0.0F, 0.0F, 11, 2, 1, 0.0F);
		this.belly_fur_2 = new ResettableModelRenderer(this, 49, 182);
		this.belly_fur_2.setRotationPoint(-6.5F, -0.1F, -9.0F);
		this.belly_fur_2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 9, 0.0F);
		this.neck = new ResettableModelRenderer(this, 0, 152);
		this.neck.setRotationPoint(0.0F, -2.1F, -8.5F);
		this.neck.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
		this.setRotateAngle(neck, 0.18203784098300857F, 0.0F, 0.0F);
		this.right_foot = new ResettableModelRenderer(this, 35, 169);
		this.right_foot.setRotationPoint(0.0F, 2.4F, 0.1F);
		this.right_foot.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
		this.setRotateAngle(right_foot, -0.17156586547104258F, 0.0F, 0.0F);
		this.right_hand = new ResettableModelRenderer(this, 9, 168);
		this.right_hand.setRotationPoint(0.0F, 2.6F, 0.0F);
		this.right_hand.addBox(-0.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
		this.left_leg = new ResettableModelRenderer(this, 25, 168);
		this.left_leg.setRotationPoint(4.0F, 20.7F, 6.0F);
		this.left_leg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(left_leg, 0.18203784098300857F, 0.0F, 0.0F);
		this.top_1 = new ResettableModelRenderer(this, 0, 93);
		this.top_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.top_1.addBox(-6.0F, 0.0F, 0.0F, 12, 6, 9, 0.0F);
		this.setRotateAngle(top_1, 0.6373942428283291F, 0.0F, 0.0F);
		this.tail_3 = new ResettableModelRenderer(this, 32, 142);
		this.tail_3.setRotationPoint(0.0F, 3.9F, 0.4F);
		this.tail_3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
		this.body_base_2 = new ResettableModelRenderer(this, 0, 17);
		this.body_base_2.setRotationPoint(0.0F, -6.0F, 0.0F);
		this.body_base_2.addBox(-7.0F, 0.0F, 0.0F, 14, 3, 13, 0.0F);
		this.rear_2 = new ResettableModelRenderer(this, 0, 73);
		this.rear_2.setRotationPoint(0.0F, -3.0F, 0.0F);
		this.rear_2.addBox(-6.0F, 0.0F, 0.0F, 12, 2, 7, 0.0F);
		this.left_arm = new ResettableModelRenderer(this, 0, 168);
		this.left_arm.setRotationPoint(2.5F, 20.5F, -6.0F);
		this.left_arm.addBox(0.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.right_leg = new ResettableModelRenderer(this, 25, 168);
		this.right_leg.setRotationPoint(-4.0F, 20.7F, 6.0F);
		this.right_leg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
		this.setRotateAngle(right_leg, 0.18203784098300857F, 0.0F, 0.0F);
		this.front_1 = new ResettableModelRenderer(this, 0, 35);
		this.front_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.front_1.addBox(-7.0F, -3.0F, -9.0F, 14, 3, 9, 0.0F);
		this.setRotateAngle(front_1, -0.029670597283903602F, 0.0F, 0.0F);
		this.belly_fur_4 = new ResettableModelRenderer(this, 17, 184);
		this.belly_fur_4.setRotationPoint(-7.0F, 0.0F, 0.0F);
		this.belly_fur_4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 13, 0.0F);
		this.lower_jaw = new ResettableModelRenderer(this, 16, 161);
		this.lower_jaw.setRotationPoint(0.0F, 2.8F, -2.1F);
		this.lower_jaw.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 3, 0.0F);
		this.setRotateAngle(lower_jaw, -0.091106186954104F, 0.0F, 0.0F);
		this.right_ear = new ResettableModelRenderer(this, 36, 161);
		this.right_ear.setRotationPoint(-2.0F, -1.0F, -0.5F);
		this.right_ear.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		this.setRotateAngle(right_ear, -0.40980330836826856F, 0.0F, -0.5462880558742251F);
		this.front_2 = new ResettableModelRenderer(this, 0, 49);
		this.front_2.setRotationPoint(0.0F, -4.9F, -9.0F);
		this.front_2.addBox(-6.5F, 0.0F, 0.0F, 13, 2, 9, 0.0F);
		this.snout = new ResettableModelRenderer(this, 1, 161);
		this.snout.setRotationPoint(0.0F, -0.8F, -3.9F);
		this.snout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
		this.setRotateAngle(snout, 0.4553564018453205F, 0.0F, 0.0F);
		this.tail_1 = new ResettableModelRenderer(this, 0, 142);
		this.tail_1.setRotationPoint(0.0F, -1.4F, 2.1F);
		this.tail_1.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
		this.setRotateAngle(tail_1, 0.4553564018453205F, 0.0F, 0.0F);
		this.front_1.addChild(this.belly_fur_1);
		this.top_3.addChild(this.top_4);
		this.left_leg.addChild(this.left_foot);
		this.body_base.addChild(this.rear);
		this.top_2.addChild(this.top_3);
		this.head.addChild(this.top_jaw);
		this.top_1.addChild(this.top_2);
		this.head.addChild(this.left_ear);
		this.body_base.addChild(this.belly_fur_3);
		this.front_1.addChild(this.belly_fur_5);
		this.tail_1.addChild(this.tail_2);
		this.left_arm.addChild(this.left_hand);
		this.neck.addChild(this.head);
		this.body_base.addChild(this.belly_fur_6);
		this.front_1.addChild(this.belly_fur_2);
		this.front_1.addChild(this.neck);
		this.right_leg.addChild(this.right_foot);
		this.right_arm.addChild(this.right_hand);
		this.front_2.addChild(this.top_1);
		this.tail_2.addChild(this.tail_3);
		this.body_base.addChild(this.body_base_2);
		this.rear.addChild(this.rear_2);
		this.body_base.addChild(this.front_1);
		this.body_base.addChild(this.belly_fur_4);
		this.head.addChild(this.lower_jaw);
		this.head.addChild(this.right_ear);
		this.front_1.addChild(this.front_2);
		this.top_jaw.addChild(this.snout);
		this.rear.addChild(this.tail_1);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.body_base.render(f5);
		this.right_arm.render(f5);
		this.left_leg.render(f5);
		this.left_arm.render(f5);
		this.right_leg.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ResettableModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
