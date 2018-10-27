package com.deextinction.deextinction.entity.model.defectum;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Pig Fail - Batman
 * Created using Tabula 7.0.0
 */
public class ModelZeinner extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leftleg;
    public ModelRenderer rightleg;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer nose;

    public ModelZeinner() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(-0.5F, -9.8F, -2.5F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 7, 8, 7, 0.0F);
        this.nose = new ModelRenderer(this, 16, 16);
        this.nose.setRotationPoint(-0.5F, -8.0F, -1.0F);
        this.nose.addBox(-2.0F, -1.5F, -1.0F, 4, 3, 1, 0.0F);
        this.setRotateAngle(nose, -1.5707963267948966F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.setRotationPoint(2.0F, -3.0F, -7.0F);
        this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leftleg, -1.5707963267948966F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 0, 16);
        this.leftarm.setRotationPoint(2.0F, -9.0F, -7.0F);
        this.leftarm.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leftarm, -1.5707963267948966F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.setRotationPoint(-4.0F, -3.0F, -7.0F);
        this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(rightleg, -1.5707963267948966F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 0, 16);
        this.rightarm.setRotationPoint(-4.0F, -9.0F, -7.0F);
        this.rightarm.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(rightarm, -1.5707963267948966F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 28, 8);
        this.body.setRotationPoint(1.0F, 11.0F, 6.0F);
        this.body.addBox(-5.0F, -10.0F, -7.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.body.addChild(this.head);
        this.head.addChild(this.nose);
        this.body.addChild(this.leftleg);
        this.body.addChild(this.leftarm);
        this.body.addChild(this.rightleg);
        this.body.addChild(this.rightarm);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.body.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
