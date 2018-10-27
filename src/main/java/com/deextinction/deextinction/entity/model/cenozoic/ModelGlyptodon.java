package com.deextinction.deextinction.entity.model.cenozoic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Glyptodon - Botmon
 * Created using Tabula 7.0.0
 */
public class ModelGlyptodon extends ModelBase {
    public ModelRenderer bodybase;
    public ModelRenderer leftleg;
    public ModelRenderer rightarm;
    public ModelRenderer leftarm;
    public ModelRenderer rightleg;
    public ModelRenderer bodybase2;
    public ModelRenderer front1;
    public ModelRenderer rear;
    public ModelRenderer bellyfur3;
    public ModelRenderer bellyfur4;
    public ModelRenderer bellyfur6;
    public ModelRenderer front2;
    public ModelRenderer neck;
    public ModelRenderer bellyfur1;
    public ModelRenderer bellyfur2;
    public ModelRenderer bellyfur5;
    public ModelRenderer top1;
    public ModelRenderer top2;
    public ModelRenderer top3;
    public ModelRenderer top4;
    public ModelRenderer head;
    public ModelRenderer topjaw;
    public ModelRenderer lowerjaw;
    public ModelRenderer leftear;
    public ModelRenderer rightear;
    public ModelRenderer snout;
    public ModelRenderer rear2;
    public ModelRenderer tail1;
    public ModelRenderer tail2;
    public ModelRenderer tail3;
    public ModelRenderer leftfoot;
    public ModelRenderer righthand;
    public ModelRenderer lefthand;
    public ModelRenderer rightfoot;

    public ModelGlyptodon() {
        this.textureWidth = 100;
        this.textureHeight = 200;
        this.bodybase2 = new ModelRenderer(this, 0, 17);
        this.bodybase2.setRotationPoint(0.0F, -6.0F, 0.0F);
        this.bodybase2.addBox(-7.0F, 0.0F, 0.0F, 14, 3, 13, 0.0F);
        this.leftfoot = new ModelRenderer(this, 35, 169);
        this.leftfoot.setRotationPoint(0.0F, 2.4F, 0.1F);
        this.leftfoot.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(leftfoot, -0.17156586547104258F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 1, 161);
        this.snout.setRotationPoint(0.0F, -0.8F, -3.9F);
        this.snout.addBox(-1.5F, 0.0F, 0.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(snout, 0.4553564018453205F, 0.0F, 0.0F);
        this.lefthand = new ModelRenderer(this, 9, 168);
        this.lefthand.setRotationPoint(0.0F, 2.6F, 0.0F);
        this.lefthand.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
        this.neck = new ModelRenderer(this, 0, 152);
        this.neck.setRotationPoint(0.0F, -2.1F, -8.5F);
        this.neck.addBox(-2.0F, -2.0F, -3.0F, 4, 4, 3, 0.0F);
        this.setRotateAngle(neck, 0.18203784098300857F, 0.0F, 0.0F);
        this.righthand = new ModelRenderer(this, 9, 168);
        this.righthand.setRotationPoint(0.0F, 2.6F, 0.0F);
        this.righthand.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
        this.rightleg = new ModelRenderer(this, 25, 168);
        this.rightleg.setRotationPoint(-6.5F, 18.2F, 9.4F);
        this.rightleg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(rightleg, 0.18203784098300857F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 25, 168);
        this.leftleg.setRotationPoint(6.5F, 18.2F, 9.4F);
        this.leftleg.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.setRotateAngle(leftleg, 0.18203784098300857F, 0.0F, 0.0F);
        this.bellyfur3 = new ModelRenderer(this, 0, 181);
        this.bellyfur3.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.bellyfur3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 13, 0.0F);
        this.head = new ModelRenderer(this, 15, 152);
        this.head.setRotationPoint(0.0F, -0.6F, -2.3F);
        this.head.addBox(-2.5F, -1.5F, -3.0F, 5, 5, 3, 0.0F);
        this.leftear = new ModelRenderer(this, 30, 161);
        this.leftear.setRotationPoint(2.0F, 0.0F, -0.5F);
        this.leftear.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(leftear, -0.40980330836826856F, 0.0F, 0.40980330836826856F);
        this.rightarm = new ModelRenderer(this, 0, 168);
        this.rightarm.setRotationPoint(-6.4F, 18.7F, -12.2F);
        this.rightarm.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.bellyfur1 = new ModelRenderer(this, 35, 185);
        this.bellyfur1.setRotationPoint(5.5F, -0.1F, -9.0F);
        this.bellyfur1.addBox(0.0F, 0.0F, 0.0F, 1, 2, 9, 0.0F);
        this.tail2 = new ModelRenderer(this, 18, 142);
        this.tail2.setRotationPoint(0.0F, 5.0F, 0.4F);
        this.tail2.addBox(-1.5F, 0.0F, -1.5F, 3, 4, 3, 0.0F);
        this.bellyfur6 = new ModelRenderer(this, 26, 176);
        this.bellyfur6.setRotationPoint(-5.5F, 0.0F, 11.9F);
        this.bellyfur6.addBox(0.0F, 0.0F, 0.0F, 11, 2, 1, 0.0F);
        this.lowerjaw = new ModelRenderer(this, 16, 161);
        this.lowerjaw.setRotationPoint(0.0F, 2.8F, -2.1F);
        this.lowerjaw.addBox(-1.5F, -0.5F, -3.0F, 3, 1, 3, 0.0F);
        this.setRotateAngle(lowerjaw, -0.091106186954104F, 0.0F, 0.0F);
        this.bellyfur5 = new ModelRenderer(this, 2, 176);
        this.bellyfur5.setRotationPoint(-5.0F, 0.0F, -9.0F);
        this.bellyfur5.addBox(0.0F, 0.0F, 0.0F, 10, 2, 1, 0.0F);
        this.top3 = new ModelRenderer(this, 0, 126);
        this.top3.setRotationPoint(0.0F, 0.0F, 8.0F);
        this.top3.addBox(0.01F, 0.0F, 0.0F, 13, 6, 8, 0.0F);
        this.setRotateAngle(top3, -0.5462880558742251F, 0.0F, 0.0F);
        this.top1 = new ModelRenderer(this, 0, 93);
        this.top1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top1.addBox(-6.0F, 0.0F, 0.0F, 12, 6, 9, 0.0F);
        this.setRotateAngle(top1, 0.6373942428283291F, 0.0F, 0.0F);
        this.rear2 = new ModelRenderer(this, 0, 73);
        this.rear2.setRotationPoint(0.0F, -3.0F, 0.0F);
        this.rear2.addBox(-6.0F, 0.0F, 0.0F, 12, 2, 7, 0.0F);
        this.bellyfur4 = new ModelRenderer(this, 17, 184);
        this.bellyfur4.setRotationPoint(-7.0F, 0.0F, 0.0F);
        this.bellyfur4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 13, 0.0F);
        this.tail1 = new ModelRenderer(this, 0, 142);
        this.tail1.setRotationPoint(0.0F, -1.4F, 2.1F);
        this.tail1.addBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(tail1, 0.4553564018453205F, 0.0F, 0.0F);
        this.top4 = new ModelRenderer(this, 0, 84);
        this.top4.setRotationPoint(0.5F, 0.0F, 8.0F);
        this.top4.addBox(0.5F, 0.0F, 0.0F, 11, 4, 3, 0.0F);
        this.setRotateAngle(top4, -0.6829473363053812F, 0.0F, 0.0F);
        this.front1 = new ModelRenderer(this, 0, 35);
        this.front1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.front1.addBox(-7.0F, -3.0F, -9.0F, 14, 3, 9, 0.0F);
        this.setRotateAngle(front1, -0.029670597283903602F, 0.0F, 0.0F);
        this.bellyfur2 = new ModelRenderer(this, 49, 182);
        this.bellyfur2.setRotationPoint(-6.5F, -0.1F, -9.0F);
        this.bellyfur2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 9, 0.0F);
        this.leftarm = new ModelRenderer(this, 0, 168);
        this.leftarm.setRotationPoint(6.4F, 18.7F, -12.2F);
        this.leftarm.addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F);
        this.rightfoot = new ModelRenderer(this, 35, 169);
        this.rightfoot.setRotationPoint(0.0F, 2.4F, 0.1F);
        this.rightfoot.addBox(-1.5F, 0.0F, -3.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(rightfoot, -0.17156586547104258F, 0.0F, 0.0F);
        this.rightear = new ModelRenderer(this, 36, 161);
        this.rightear.setRotationPoint(-2.0F, 0.0F, -0.5F);
        this.rightear.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
        this.setRotateAngle(rightear, -0.40980330836826856F, 0.0F, -0.5462880558742251F);
        this.tail3 = new ModelRenderer(this, 32, 142);
        this.tail3.setRotationPoint(0.0F, 3.9F, 0.4F);
        this.tail3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.rear = new ModelRenderer(this, 0, 62);
        this.rear.setRotationPoint(0.0F, -0.3F, 12.2F);
        this.rear.addBox(-6.5F, -1.5F, 0.0F, 13, 2, 7, 0.0F);
        this.setRotateAngle(rear, 0.9105382707654417F, 0.0F, 0.0F);
        this.top2 = new ModelRenderer(this, 0, 110);
        this.top2.setRotationPoint(-6.5F, 0.0F, 9.0F);
        this.top2.addBox(0.0F, 0.0F, 0.0F, 13, 6, 8, 0.0F);
        this.setRotateAngle(top2, -0.40980330836826856F, 0.0F, 0.0F);
        this.topjaw = new ModelRenderer(this, 32, 152);
        this.topjaw.setRotationPoint(0.0F, 1.1F, -2.4F);
        this.topjaw.addBox(-2.0F, -1.0F, -3.0F, 4, 2, 3, 0.0F);
        this.setRotateAngle(topjaw, 0.136659280431156F, 0.0F, 0.0F);
        this.bodybase = new ModelRenderer(this, 0, 0);
        this.bodybase.setRotationPoint(0.0F, 18.5F, -5.0F);
        this.bodybase.addBox(-7.5F, -3.0F, 0.0F, 15, 3, 13, 0.0F);
        this.setRotateAngle(bodybase, -0.01064650843716541F, 0.0F, 0.0F);
        this.front2 = new ModelRenderer(this, 0, 49);
        this.front2.setRotationPoint(0.0F, -4.9F, -9.0F);
        this.front2.addBox(-6.5F, 0.0F, 0.0F, 13, 2, 9, 0.0F);
        this.bodybase.addChild(this.bodybase2);
        this.leftleg.addChild(this.leftfoot);
        this.topjaw.addChild(this.snout);
        this.leftarm.addChild(this.lefthand);
        this.front1.addChild(this.neck);
        this.rightarm.addChild(this.righthand);
        this.bodybase.addChild(this.bellyfur3);
        this.neck.addChild(this.head);
        this.head.addChild(this.leftear);
        this.front1.addChild(this.bellyfur1);
        this.tail1.addChild(this.tail2);
        this.bodybase.addChild(this.bellyfur6);
        this.head.addChild(this.lowerjaw);
        this.front1.addChild(this.bellyfur5);
        this.top2.addChild(this.top3);
        this.front2.addChild(this.top1);
        this.rear.addChild(this.rear2);
        this.bodybase.addChild(this.bellyfur4);
        this.rear.addChild(this.tail1);
        this.top3.addChild(this.top4);
        this.bodybase.addChild(this.front1);
        this.front1.addChild(this.bellyfur2);
        this.rightleg.addChild(this.rightfoot);
        this.head.addChild(this.rightear);
        this.tail2.addChild(this.tail3);
        this.bodybase.addChild(this.rear);
        this.top1.addChild(this.top2);
        this.head.addChild(this.topjaw);
        this.front1.addChild(this.front2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rightleg.offsetX, this.rightleg.offsetY, this.rightleg.offsetZ);
        GlStateManager.translate(this.rightleg.rotationPointX * f5, this.rightleg.rotationPointY * f5, this.rightleg.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.8D, 1.6D);
        GlStateManager.translate(-this.rightleg.offsetX, -this.rightleg.offsetY, -this.rightleg.offsetZ);
        GlStateManager.translate(-this.rightleg.rotationPointX * f5, -this.rightleg.rotationPointY * f5, -this.rightleg.rotationPointZ * f5);
        this.rightleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.leftleg.offsetX, this.leftleg.offsetY, this.leftleg.offsetZ);
        GlStateManager.translate(this.leftleg.rotationPointX * f5, this.leftleg.rotationPointY * f5, this.leftleg.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.8D, 1.6D);
        GlStateManager.translate(-this.leftleg.offsetX, -this.leftleg.offsetY, -this.leftleg.offsetZ);
        GlStateManager.translate(-this.leftleg.rotationPointX * f5, -this.leftleg.rotationPointY * f5, -this.leftleg.rotationPointZ * f5);
        this.leftleg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rightarm.offsetX, this.rightarm.offsetY, this.rightarm.offsetZ);
        GlStateManager.translate(this.rightarm.rotationPointX * f5, this.rightarm.rotationPointY * f5, this.rightarm.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.6D, 1.6D);
        GlStateManager.translate(-this.rightarm.offsetX, -this.rightarm.offsetY, -this.rightarm.offsetZ);
        GlStateManager.translate(-this.rightarm.rotationPointX * f5, -this.rightarm.rotationPointY * f5, -this.rightarm.rotationPointZ * f5);
        this.rightarm.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.leftarm.offsetX, this.leftarm.offsetY, this.leftarm.offsetZ);
        GlStateManager.translate(this.leftarm.rotationPointX * f5, this.leftarm.rotationPointY * f5, this.leftarm.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.6D, 1.6D);
        GlStateManager.translate(-this.leftarm.offsetX, -this.leftarm.offsetY, -this.leftarm.offsetZ);
        GlStateManager.translate(-this.leftarm.rotationPointX * f5, -this.leftarm.rotationPointY * f5, -this.leftarm.rotationPointZ * f5);
        this.leftarm.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.bodybase.offsetX, this.bodybase.offsetY, this.bodybase.offsetZ);
        GlStateManager.translate(this.bodybase.rotationPointX * f5, this.bodybase.rotationPointY * f5, this.bodybase.rotationPointZ * f5);
        GlStateManager.scale(1.5D, 1.5D, 1.5D);
        GlStateManager.translate(-this.bodybase.offsetX, -this.bodybase.offsetY, -this.bodybase.offsetZ);
        GlStateManager.translate(-this.bodybase.rotationPointX * f5, -this.bodybase.rotationPointY * f5, -this.bodybase.rotationPointZ * f5);
        this.bodybase.render(f5);
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
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFator, Entity entityIn )
    {
    	this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F ) * 0.4F * limbSwingAmount;
    	this.rightarm.rotateAngleX = MathHelper.cos(limbSwing  * 0.6662F + (float)Math.PI) * 0.4F * limbSwingAmount;

    
    	
    	this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI ) * 0.4F * limbSwingAmount;
    	this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F ) * 0.4F * limbSwingAmount;
    }
    
}
