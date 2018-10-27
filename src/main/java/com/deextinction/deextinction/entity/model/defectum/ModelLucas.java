package com.deextinction.deextinction.entity.model.defectum;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ChickenFail - Batman
 * Created using Tabula 7.0.0
 */
public class ModelLucas extends ModelBase {
    public ModelRenderer body;
    public ModelRenderer leftleg;
    public ModelRenderer rightleg;
    public ModelRenderer neck;
    public ModelRenderer beak;

    public ModelLucas() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body = new ModelRenderer(this, 0, 9);
        this.body.setRotationPoint(0.0F, 16.0F, 0.0F);
        this.body.addBox(-2.5F, -6.0F, -3.0F, 5, 6, 6, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 0);
        this.neck.setRotationPoint(0.0F, -5.0F, 1.0F);
        this.neck.addBox(-1.5F, -1.0F, -1.0F, 3, 6, 3, 0.0F);
        this.setRotateAngle(neck, 1.5707963267948966F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 26, 0);
        this.leftleg.setRotationPoint(1.0F, -2.0F, -3.0F);
        this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(leftleg, -1.5760323145508797F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 26, 0);
        this.rightleg.setRotationPoint(-1.0F, -2.0F, -3.0F);
        this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 5, 2, 0.0F);
        this.setRotateAngle(rightleg, -1.5760323145508797F, 0.0F, 0.0F);
        this.beak = new ModelRenderer(this, 14, 0);
        this.beak.setRotationPoint(0.0F, 2.0F, 1.3F);
        this.beak.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
        this.body.addChild(this.neck);
        this.body.addChild(this.leftleg);
        this.body.addChild(this.rightleg);
        this.neck.addChild(this.beak);
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
