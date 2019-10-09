package com.deextinction.client.renderer.tileentity;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;

import net.minecraft.entity.Entity;

/**
 * Model_Fossil_Bone_Femur - RafaMv Created using Tabula 7.0.0
 */
public class ModelFossilBoneFemur extends ResettableModelBase
{
	public ResettableModelRenderer femur_center;
	public ResettableModelRenderer femur_neck;
	public ResettableModelRenderer femur_patellar_groove_1;
	public ResettableModelRenderer femur_patellar_groove_2;
	public ResettableModelRenderer femur_head;

	public ModelFossilBoneFemur()
	{
		this.textureWidth = 24;
		this.textureHeight = 16;

		this.femur_center = new ResettableModelRenderer(this, 0, 0);
		this.femur_center.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.femur_center.addBox(-5.0F, -0.5F, -0.5F, 10, 1, 1, 0.0F);
		this.femur_center.setRotateAngle(0.0F, -0.5235987755982988F, 0.0F);

		this.femur_neck = new ResettableModelRenderer(this, 0, 2);
		this.femur_neck.setRotationPoint(5.0F, 0.0F, -0.1F);
		this.femur_neck.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
		this.femur_neck.setRotateAngle(0.0F, 0.7853981633974483F, 0.2617993877991494F);

		this.femur_head = new ResettableModelRenderer(this, 0, 4);
		this.femur_head.setRotationPoint(2.0F, 0.2F, 0.0F);
		this.femur_head.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
		this.femur_head.setRotateAngle(0.5235987755982988F, 0.0F, -0.2617993877991494F);

		this.femur_patellar_groove_1 = new ResettableModelRenderer(this, 6, 2);
		this.femur_patellar_groove_1.setRotationPoint(-5.0F, 0.5F, 0.5F);
		this.femur_patellar_groove_1.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
		this.femur_patellar_groove_1.setRotateAngle(-0.2617993877991494F, 0.7853981633974483F, 0.2617993877991494F);

		this.femur_patellar_groove_2 = new ResettableModelRenderer(this, 12, 2);
		this.femur_patellar_groove_2.mirror = true;
		this.femur_patellar_groove_2.setRotationPoint(-5.0F, 0.5F, -0.5F);
		this.femur_patellar_groove_2.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
		this.femur_patellar_groove_2.setRotateAngle(0.2617993877991494F, -0.7853981633974483F, 0.2617993877991494F);

		this.femur_center.addChild(this.femur_patellar_groove_2);
		this.femur_center.addChild(this.femur_patellar_groove_1);
		this.femur_center.addChild(this.femur_neck);
		this.femur_neck.addChild(this.femur_head);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		this.femur_center.render(f5);
	}
}
