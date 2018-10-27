package com.deextinction.deextinction.entity.model.defectum;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Cow Fail - Batman
 * Created using Tabula 7.0.0
 */
public class ModelRafa extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer leg;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;

    public ModelRafa() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.leg3 = new ModelRenderer(this, 0, 16);
        this.leg3.setRotationPoint(4.0F, 6.0F, -7.0F);
        this.leg3.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(leg3, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 0, 16);
        this.leg4.setRotationPoint(-2.0F, 6.0F, -7.0F);
        this.leg4.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(leg4, -1.5707963267948966F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -9.9F, 1.0F);
        this.head.addBox(-4.0F, -4.0F, -6.0F, 8, 8, 6, 0.0F);
        this.setRotateAngle(head, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg = new ModelRenderer(this, 0, 16);
        this.leg.setRotationPoint(4.0F, -8.0F, -7.0F);
        this.leg.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(leg, -1.5707963267948966F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 22, 7);
        this.body.setRotationPoint(0.0F, 5.0F, 2.0F);
        this.body.addBox(-4.0F, -10.0F, -7.0F, 8, 16, 8, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 0, 16);
        this.leg2.setRotationPoint(-2.0F, -8.0F, -7.0F);
        this.leg2.addBox(-2.0F, 0.0F, -2.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(leg2, -1.5707963267948966F, 0.0F, 0.0F);
        this.body.addChild(this.leg3);
        this.body.addChild(this.leg4);
        this.body.addChild(this.head);
        this.body.addChild(this.leg);
        this.body.addChild(this.leg2);
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
