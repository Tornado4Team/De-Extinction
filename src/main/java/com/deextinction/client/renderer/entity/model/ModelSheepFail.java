package com.deextinction.client.renderer.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.util.math.MathHelper;

/**
 * Sheep Fail - Batman Created using Tabula 7.0.0
 */
public class ModelSheepFail extends ModelBase
{
	public ModelRenderer body;
	public ModelRenderer head;
	public ModelRenderer leg;
	public ModelRenderer leg2;
	public ModelRenderer leg3;
	public ModelRenderer leg4;
	private float headRotationAngleX;

	public ModelSheepFail()
	{
		this.textureWidth = 64;
		this.textureHeight = 32;
		this.leg3 = new ModelRenderer(this, 0, 16);
		this.leg3.mirror = true;
		this.leg3.setRotationPoint(3.0F, 4.0F, -7.0F);
		this.leg3.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, 0.0F);
		this.setRotateAngle(leg3, -1.5707963267948966F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 16);
		this.leg2.setRotationPoint(-2.0F, -8.0F, -7.0F);
		this.leg2.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, 0.0F);
		this.setRotateAngle(leg2, -1.5707963267948966F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 0, 16);
		this.leg4.setRotationPoint(-2.0F, 4.0F, -7.0F);
		this.leg4.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, 0.0F);
		this.setRotateAngle(leg4, -1.5707963267948966F, 0.0F, 0.0F);
		this.body = new ModelRenderer(this, 28, 8);
		this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
		this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 6, 0.0F);
		this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.setRotationPoint(0.0F, -9.0F, -3.0F);
		this.head.addBox(-3.0F, -4.0F, -6.0F, 6, 6, 8, 0.0F);
		this.setRotateAngle(head, -1.5707963267948966F, 0.0F, 0.0F);
		this.leg = new ModelRenderer(this, 0, 16);
		this.leg.mirror = true;
		this.leg.setRotationPoint(3.0F, -8.0F, -7.0F);
		this.leg.addBox(-2.0F, 0.0F, -2.0F, 3, 12, 3, 0.0F);
		this.setRotateAngle(leg, -1.5707963267948966F, 0.0F, 0.0F);
		this.body.addChild(this.leg3);
		this.body.addChild(this.leg2);
		this.body.addChild(this.leg4);
		this.body.addChild(this.head);
		this.body.addChild(this.leg);
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, entity);
		this.body.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
	{
		super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
		this.head.rotationPointY = 6.0F + ((EntitySheep) entitylivingbaseIn).getHeadRotationPointY(partialTickTime) * 9.0F;
		this.headRotationAngleX = ((EntitySheep) entitylivingbaseIn).getHeadRotationAngleX(partialTickTime);
	}

	@Override
	public void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, Entity animal)
	{
		this.head.rotateAngleX = this.headRotationAngleX;
		this.head.rotateAngleX = pitch * 0.017453292F;
		this.head.rotateAngleY = yaw * 0.017453292F;
		this.body.rotateAngleX = ((float) Math.PI / 2F);
		this.leg.rotateAngleX = MathHelper.cos(walkedDistance * 0.6662F) * 1.4F * walkSpeed;
		this.leg2.rotateAngleX = MathHelper.cos(walkedDistance * 0.6662F + (float) Math.PI) * 1.4F * walkSpeed;
		this.leg3.rotateAngleX = MathHelper.cos(walkedDistance * 0.6662F + (float) Math.PI) * 1.4F * walkSpeed;
		this.leg4.rotateAngleX = MathHelper.cos(walkedDistance * 0.6662F) * 1.4F * walkSpeed;
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
