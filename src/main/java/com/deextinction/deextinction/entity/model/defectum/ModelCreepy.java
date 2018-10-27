package com.deextinction.deextinction.entity.model.defectum;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * ModelBat - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelCreepy extends ModelBase {
    public ModelRenderer field_82893_b0;
    public ModelRenderer field_82895_a;
    public ModelRenderer field_82893_b1;
    public ModelRenderer field_82895_aChild;
    public ModelRenderer field_82895_aChild_1;

    public ModelCreepy() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_82895_aChild = new ModelRenderer(this, 24, 0);
        this.field_82895_aChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_82895_aChild.addBox(-4.0F, -6.0F, -2.0F, 3, 4, 1, 0.0F);
        this.field_82893_b1 = new ModelRenderer(this, 0, 34);
        this.field_82893_b1.setRotationPoint(0.0F, 4.1F, 0.5F);
        this.field_82893_b1.addBox(-5.0F, 0.0F, 0.0F, 10, 6, 1, 0.0F);
        this.setRotateAngle(field_82893_b1, 0.31869712141416456F, 0.0F, 3.141592653589793F);
        this.field_82893_b0 = new ModelRenderer(this, 0, 16);
        this.field_82893_b0.setRotationPoint(0.0F, 22.5F, -6.8F);
        this.field_82893_b0.addBox(-3.0F, 4.0F, -3.0F, 6, 12, 6, 0.0F);
        this.setRotateAngle(field_82893_b0, 1.5707963267948966F, 0.0F, 3.141592653589793F);
        this.field_82895_a = new ModelRenderer(this, 0, 0);
        this.field_82895_a.setRotationPoint(0.0F, 18.6F, 0.0F);
        this.field_82895_a.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6, 0.0F);
        this.setRotateAngle(field_82895_a, 1.5707963267948966F, 0.0F, 0.0F);
        this.field_82895_aChild_1 = new ModelRenderer(this, 24, 0);
        this.field_82895_aChild_1.mirror = true;
        this.field_82895_aChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_82895_aChild_1.addBox(1.0F, -6.0F, -2.0F, 3, 4, 1, 0.0F);
        this.field_82895_a.addChild(this.field_82895_aChild);
        this.field_82893_b0.addChild(this.field_82893_b1);
        this.field_82893_b0.addChild(this.field_82895_a);
        this.field_82895_a.addChild(this.field_82895_aChild_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.field_82893_b0.offsetX, this.field_82893_b0.offsetY, this.field_82893_b0.offsetZ);
        GlStateManager.translate(this.field_82893_b0.rotationPointX * f5, this.field_82893_b0.rotationPointY * f5, this.field_82893_b0.rotationPointZ * f5);
        GlStateManager.scale(0.5D, 0.5D, 0.5D);
        GlStateManager.translate(-this.field_82893_b0.offsetX, -this.field_82893_b0.offsetY, -this.field_82893_b0.offsetZ);
        GlStateManager.translate(-this.field_82893_b0.rotationPointX * f5, -this.field_82893_b0.rotationPointY * f5, -this.field_82893_b0.rotationPointZ * f5);
        this.field_82893_b0.render(f5);
        GlStateManager.popMatrix();
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
