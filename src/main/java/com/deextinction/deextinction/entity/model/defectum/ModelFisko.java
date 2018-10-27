package com.deextinction.deextinction.entity.model.defectum;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Fail Ocelot - Batman
 * Created using Tabula 7.0.0
 */
public class ModelFisko extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer tail;
    public ModelRenderer leg1;
    public ModelRenderer leg2;
    public ModelRenderer leg3;
    public ModelRenderer leg4;
    public ModelRenderer nose;
    public ModelRenderer ear2;
    public ModelRenderer ear;

    public ModelFisko() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.ear = new ModelRenderer(this, 6, 10);
        this.ear.setRotationPoint(-3.0F, -3.0F, 0.0F);
        this.ear.addBox(1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ear, -1.593485607070823F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 22, 0);
        this.body.setRotationPoint(0.0F, 12.0F, -10.0F);
        this.body.addBox(-2.0F, 3.0F, -8.0F, 4, 16, 6, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.ear2 = new ModelRenderer(this, 6, 10);
        this.ear2.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.ear2.addBox(1.0F, -3.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(ear2, -1.593485607070823F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, 3.1F, -3.0F);
        this.head.addBox(-2.5F, -4.0F, -3.0F, 5, 4, 5, 0.0F);
        this.leg3 = new ModelRenderer(this, 8, 15);
        this.leg3.setRotationPoint(-1.3F, 3.9F, -6.0F);
        this.leg3.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leg3, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg4 = new ModelRenderer(this, 8, 15);
        this.leg4.setRotationPoint(1.3F, 3.9F, -6.0F);
        this.leg4.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leg4, -1.5707963267948966F, 0.0F, 0.0F);
        this.nose = new ModelRenderer(this, 0, 25);
        this.nose.setRotationPoint(0.0F, -3.8F, -1.8F);
        this.nose.addBox(-1.5F, -2.0F, -1.0F, 3, 2, 2, 0.0F);
        this.tail = new ModelRenderer(this, 0, 15);
        this.tail.setRotationPoint(0.0F, 18.0F, -3.0F);
        this.tail.addBox(-0.5F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
        this.setRotateAngle(tail, -0.5009094953223726F, 0.0F, 0.0F);
        this.leg1 = new ModelRenderer(this, 8, 15);
        this.leg1.setRotationPoint(-1.3F, 17.0F, -6.0F);
        this.leg1.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leg1, -1.5707963267948966F, 0.0F, 0.0F);
        this.leg2 = new ModelRenderer(this, 8, 15);
        this.leg2.setRotationPoint(1.3F, 17.0F, -6.0F);
        this.leg2.addBox(-1.0F, 0.0F, -1.0F, 2, 6, 2, 0.0F);
        this.setRotateAngle(leg2, -1.5707963267948966F, 0.0F, 0.0F);
        this.head.addChild(this.ear);
        this.head.addChild(this.ear2);
        this.body.addChild(this.head);
        this.body.addChild(this.leg3);
        this.body.addChild(this.leg4);
        this.head.addChild(this.nose);
        this.body.addChild(this.tail);
        this.body.addChild(this.leg1);
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
