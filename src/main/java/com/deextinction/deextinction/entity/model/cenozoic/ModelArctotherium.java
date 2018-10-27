package com.deextinction.deextinction.entity.model.cenozoic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Arctotherium - Botmon
 * Created using Tabula 7.0.0
 */
public class ModelArctotherium extends ModelBase {
    public ModelRenderer rear;
    public ModelRenderer leftarm1;
    public ModelRenderer rightarm1;
    public ModelRenderer leftleg1;
    public ModelRenderer rightleg1;
    public ModelRenderer front;
    public ModelRenderer bellyfur;
    public ModelRenderer rump1;
    public ModelRenderer chest;
    public ModelRenderer neck;
    public ModelRenderer hump1;
    public ModelRenderer chestfur;
    public ModelRenderer head;
    public ModelRenderer neckfur;
    public ModelRenderer topjaw;
    public ModelRenderer lowerjaw;
    public ModelRenderer leftear;
    public ModelRenderer rightear;
    public ModelRenderer snout;
    public ModelRenderer hump2;
    public ModelRenderer rump2;
    public ModelRenderer tail;
    public ModelRenderer rump3;
    public ModelRenderer leftarm2;
    public ModelRenderer leftpaw;
    public ModelRenderer armfur;
    public ModelRenderer rightarm2;
    public ModelRenderer rightpaw;
    public ModelRenderer armfur2;
    public ModelRenderer leftleg2;
    public ModelRenderer leftleg3;
    public ModelRenderer leftfoot;
    public ModelRenderer rightleg2;
    public ModelRenderer rightleg3;
    public ModelRenderer rightfoot;

    public ModelArctotherium() {
        this.textureWidth = 60;
        this.textureHeight = 200;
        this.leftpaw = new ModelRenderer(this, 32, 106);
        this.leftpaw.setRotationPoint(0.0F, 8.0F, 0.3F);
        this.leftpaw.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(leftpaw, 0.18203784098300857F, 0.0F, 0.0F);
        this.chest = new ModelRenderer(this, 0, 47);
        this.chest.setRotationPoint(0.0F, 3.8F, -11.0F);
        this.chest.addBox(-4.0F, 0.0F, 0.0F, 8, 2, 10, 0.0F);
        this.leftleg2 = new ModelRenderer(this, 21, 120);
        this.leftleg2.setRotationPoint(0.0F, 3.4F, -0.5F);
        this.leftleg2.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 4, 0.0F);
        this.setRotateAngle(leftleg2, 0.136659280431156F, 0.0F, 0.0F);
        this.armfur2 = new ModelRenderer(this, 0, 165);
        this.armfur2.setRotationPoint(-1.0F, 0.0F, 1.0F);
        this.armfur2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.front = new ModelRenderer(this, 0, 25);
        this.front.setRotationPoint(0.0F, 0.0F, 0.7F);
        this.front.addBox(-4.5F, -5.0F, -11.0F, 9, 9, 11, 0.0F);
        this.setRotateAngle(front, 0.091106186954104F, 0.0F, 0.0F);
        this.armfur = new ModelRenderer(this, 0, 165);
        this.armfur.setRotationPoint(-1.0F, 0.0F, 1.0F);
        this.armfur.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.topjaw = new ModelRenderer(this, 0, 87);
        this.topjaw.setRotationPoint(0.0F, 0.2F, -3.7F);
        this.topjaw.addBox(-2.0F, -1.5F, -3.0F, 4, 3, 3, 0.0F);
        this.setRotateAngle(topjaw, 0.136659280431156F, 0.0F, 0.0F);
        this.leftfoot = new ModelRenderer(this, 34, 126);
        this.leftfoot.setRotationPoint(0.0F, 5.9F, 0.0F);
        this.leftfoot.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(leftfoot, 0.091106186954104F, 0.0F, 0.0F);
        this.neckfur = new ModelRenderer(this, 26, 150);
        this.neckfur.setRotationPoint(-2.0F, 2.3F, -6.2F);
        this.neckfur.addBox(0.0F, 0.0F, 0.0F, 4, 2, 7, 0.0F);
        this.leftarm1 = new ModelRenderer(this, 0, 106);
        this.leftarm1.setRotationPoint(5.2F, 5.2F, -6.7F);
        this.leftarm1.addBox(0.0F, -1.9F, -2.0F, 4, 7, 4, 0.0F);
        this.setRotateAngle(leftarm1, 0.045553093477052F, 0.0F, 0.0F);
        this.rump1 = new ModelRenderer(this, 6, 12);
        this.rump1.setRotationPoint(0.0F, -5.1F, 11.8F);
        this.rump1.addBox(-4.5F, 0.0F, 0.0F, 9, 5, 4, 0.0F);
        this.setRotateAngle(rump1, -0.7740535232594852F, 0.0F, 0.0F);
        this.rump3 = new ModelRenderer(this, 9, 9);
        this.rump3.setRotationPoint(0.0F, -1.6F, 1.5F);
        this.rump3.addBox(-4.0F, -3.0F, -1.8F, 8, 3, 4, 0.0F);
        this.setRotateAngle(rump3, -2.367539130330308F, 0.0F, 0.0F);
        this.rightarm1 = new ModelRenderer(this, 0, 106);
        this.rightarm1.setRotationPoint(-5.2F, 5.2F, -6.7F);
        this.rightarm1.addBox(-4.0F, -1.9F, -2.0F, 4, 7, 4, 0.0F);
        this.setRotateAngle(rightarm1, 0.045553093477052F, 0.0F, 0.0F);
        this.rear = new ModelRenderer(this, 0, 0);
        this.rear.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rear.addBox(-5.0F, -5.0F, 0.0F, 10, 11, 12, 0.0F);
        this.rightleg1 = new ModelRenderer(this, 0, 120);
        this.rightleg1.setRotationPoint(-8.3F, 0.4F, 15.2F);
        this.rightleg1.addBox(-2.5F, -2.5F, -3.0F, 5, 7, 5, 0.0F);
        this.setRotateAngle(rightleg1, -0.045553093477052F, 0.0F, 0.0F);
        this.chestfur = new ModelRenderer(this, 0, 150);
        this.chestfur.setRotationPoint(-3.5F, 1.6F, 0.2F);
        this.chestfur.addBox(0.0F, 0.0F, 0.0F, 7, 2, 10, 0.0F);
        this.rightfoot = new ModelRenderer(this, 34, 126);
        this.rightfoot.setRotationPoint(0.0F, 5.9F, 0.0F);
        this.rightfoot.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(rightfoot, 0.091106186954104F, 0.0F, 0.0F);
        this.rightleg3 = new ModelRenderer(this, 40, 115);
        this.rightleg3.setRotationPoint(0.0F, 3.7F, 0.5F);
        this.rightleg3.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(rightleg3, -0.18203784098300857F, 0.0F, 0.0F);
        this.leftleg1 = new ModelRenderer(this, 0, 120);
        this.leftleg1.setRotationPoint(8.3F, 0.4F, 15.2F);
        this.leftleg1.addBox(-2.5F, -2.5F, -3.0F, 5, 7, 5, 0.0F);
        this.setRotateAngle(leftleg1, -0.045553093477052F, 0.0F, 0.0F);
        this.bellyfur = new ModelRenderer(this, 3, 135);
        this.bellyfur.setRotationPoint(-4.5F, 6.0F, 0.0F);
        this.bellyfur.addBox(0.0F, 0.0F, 0.0F, 9, 2, 11, 0.0F);
        this.rightarm2 = new ModelRenderer(this, 18, 106);
        this.rightarm2.setRotationPoint(-1.9F, 4.5F, 0.5F);
        this.rightarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(rightarm2, -0.22759093446006054F, 0.0F, 0.0F);
        this.rightleg2 = new ModelRenderer(this, 21, 120);
        this.rightleg2.setRotationPoint(0.0F, 3.4F, -0.5F);
        this.rightleg2.addBox(-2.0F, 0.0F, -2.5F, 4, 4, 4, 0.0F);
        this.setRotateAngle(rightleg2, 0.136659280431156F, 0.0F, 0.0F);
        this.rightpaw = new ModelRenderer(this, 32, 106);
        this.rightpaw.setRotationPoint(0.0F, 8.0F, 0.3F);
        this.rightpaw.addBox(-2.0F, 0.0F, -4.0F, 4, 2, 5, 0.0F);
        this.setRotateAngle(rightpaw, 0.18203784098300857F, 0.0F, 0.0F);
        this.rightear = new ModelRenderer(this, 16, 87);
        this.rightear.setRotationPoint(-3.0F, -2.0F, -1.0F);
        this.rightear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(rightear, -0.7740535232594852F, -0.31869712141416456F, 0.0F);
        this.neck = new ModelRenderer(this, 0, 61);
        this.neck.setRotationPoint(0.0F, -1.7F, -8.6F);
        this.neck.addBox(-3.0F, -3.0F, -7.0F, 6, 6, 7, 0.0F);
        this.setRotateAngle(neck, -0.18203784098300857F, 0.0F, 0.0F);
        this.rump2 = new ModelRenderer(this, 9, 9);
        this.rump2.setRotationPoint(0.0F, 5.1F, 7.2F);
        this.rump2.addBox(-4.0F, 0.0F, 0.0F, 8, 6, 5, 0.0F);
        this.setRotateAngle(rump2, -2.5953045977155678F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 0, 134);
        this.tail.setRotationPoint(0.0F, 1.6F, 2.5F);
        this.tail.addBox(-1.0F, -1.5F, 0.0F, 2, 2, 4, 0.0F);
        this.setRotateAngle(tail, 0.31869712141416456F, 0.0F, 0.0F);
        this.leftarm2 = new ModelRenderer(this, 18, 106);
        this.leftarm2.setRotationPoint(1.9F, 4.5F, 0.5F);
        this.leftarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
        this.setRotateAngle(leftarm2, -0.22759093446006054F, 0.0F, 0.0F);
        this.leftleg3 = new ModelRenderer(this, 40, 115);
        this.leftleg3.setRotationPoint(0.0F, 3.7F, 0.5F);
        this.leftleg3.addBox(-1.5F, 0.0F, -2.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(leftleg3, -0.18203784098300857F, 0.0F, 0.0F);
        this.leftear = new ModelRenderer(this, 13, 93);
        this.leftear.setRotationPoint(3.0F, -2.0F, -1.0F);
        this.leftear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(leftear, -0.7740535232594852F, 0.31869712141416456F, 0.0F);
        this.snout = new ModelRenderer(this, 0, 94);
        this.snout.setRotationPoint(-2.0F, -1.5F, -3.0F);
        this.snout.addBox(0.5F, 0.0F, 0.0F, 3, 1, 4, 0.0F);
        this.setRotateAngle(snout, 0.36425021489121656F, 0.0F, 0.0F);
        this.lowerjaw = new ModelRenderer(this, 0, 101);
        this.lowerjaw.setRotationPoint(0.0F, 2.2F, -3.9F);
        this.lowerjaw.addBox(-1.5F, -0.5F, -2.0F, 3, 1, 2, 0.0F);
        this.setRotateAngle(lowerjaw, 0.045553093477052F, 0.0F, 0.0F);
        this.hump1 = new ModelRenderer(this, 9, 165);
        this.hump1.setRotationPoint(-4.0F, -5.0F, -9.4F);
        this.hump1.addBox(0.0F, 0.0F, 0.0F, 8, 1, 4, 0.0F);
        this.setRotateAngle(hump1, 0.22759093446006054F, 0.0F, 0.0F);
        this.hump2 = new ModelRenderer(this, 12, 172);
        this.hump2.setRotationPoint(0.5F, 0.0F, 4.0F);
        this.hump2.addBox(0.0F, 0.0F, 0.0F, 7, 1, 3, 0.0F);
        this.setRotateAngle(hump2, -0.5462880558742251F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 76);
        this.head.setRotationPoint(0.0F, -0.3F, -5.6F);
        this.head.addBox(-3.5F, -3.0F, -4.0F, 7, 6, 4, 0.0F);
        this.setRotateAngle(head, 0.31869712141416456F, 0.0F, 0.0F);
        this.leftarm2.addChild(this.leftpaw);
        this.front.addChild(this.chest);
        this.leftleg1.addChild(this.leftleg2);
        this.rightarm2.addChild(this.armfur2);
        this.rear.addChild(this.front);
        this.leftarm2.addChild(this.armfur);
        this.head.addChild(this.topjaw);
        this.leftleg3.addChild(this.leftfoot);
        this.neck.addChild(this.neckfur);
        this.rear.addChild(this.rump1);
        this.rump2.addChild(this.rump3);
        this.chest.addChild(this.chestfur);
        this.rightleg3.addChild(this.rightfoot);
        this.rightleg2.addChild(this.rightleg3);
        this.rear.addChild(this.bellyfur);
        this.rightarm1.addChild(this.rightarm2);
        this.rightleg1.addChild(this.rightleg2);
        this.rightarm2.addChild(this.rightpaw);
        this.head.addChild(this.rightear);
        this.front.addChild(this.neck);
        this.rump1.addChild(this.rump2);
        this.rump1.addChild(this.tail);
        this.leftarm1.addChild(this.leftarm2);
        this.leftleg2.addChild(this.leftleg3);
        this.head.addChild(this.leftear);
        this.topjaw.addChild(this.snout);
        this.head.addChild(this.lowerjaw);
        this.front.addChild(this.hump1);
        this.hump1.addChild(this.hump2);
        this.neck.addChild(this.head);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.leftarm1.offsetX, this.leftarm1.offsetY, this.leftarm1.offsetZ);
        GlStateManager.translate(this.leftarm1.rotationPointX * f5, this.leftarm1.rotationPointY * f5, this.leftarm1.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.3D, 1.9D);
        GlStateManager.translate(-this.leftarm1.offsetX, -this.leftarm1.offsetY, -this.leftarm1.offsetZ);
        GlStateManager.translate(-this.leftarm1.rotationPointX * f5, -this.leftarm1.rotationPointY * f5, -this.leftarm1.rotationPointZ * f5);
        this.leftarm1.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rightarm1.offsetX, this.rightarm1.offsetY, this.rightarm1.offsetZ);
        GlStateManager.translate(this.rightarm1.rotationPointX * f5, this.rightarm1.rotationPointY * f5, this.rightarm1.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.3D, 1.9D);
        GlStateManager.translate(-this.rightarm1.offsetX, -this.rightarm1.offsetY, -this.rightarm1.offsetZ);
        GlStateManager.translate(-this.rightarm1.rotationPointX * f5, -this.rightarm1.rotationPointY * f5, -this.rightarm1.rotationPointZ * f5);
        this.rightarm1.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rear.offsetX, this.rear.offsetY, this.rear.offsetZ);
        GlStateManager.translate(this.rear.rotationPointX * f5, this.rear.rotationPointY * f5, this.rear.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.6D, 1.6D);
        GlStateManager.translate(-this.rear.offsetX, -this.rear.offsetY, -this.rear.offsetZ);
        GlStateManager.translate(-this.rear.rotationPointX * f5, -this.rear.rotationPointY * f5, -this.rear.rotationPointZ * f5);
        this.rear.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rightleg1.offsetX, this.rightleg1.offsetY, this.rightleg1.offsetZ);
        GlStateManager.translate(this.rightleg1.rotationPointX * f5, this.rightleg1.rotationPointY * f5, this.rightleg1.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.6D, 1.8D);
        GlStateManager.translate(-this.rightleg1.offsetX, -this.rightleg1.offsetY, -this.rightleg1.offsetZ);
        GlStateManager.translate(-this.rightleg1.rotationPointX * f5, -this.rightleg1.rotationPointY * f5, -this.rightleg1.rotationPointZ * f5);
        this.rightleg1.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.leftleg1.offsetX, this.leftleg1.offsetY, this.leftleg1.offsetZ);
        GlStateManager.translate(this.leftleg1.rotationPointX * f5, this.leftleg1.rotationPointY * f5, this.leftleg1.rotationPointZ * f5);
        GlStateManager.scale(1.6D, 1.6D, 1.8D);
        GlStateManager.translate(-this.leftleg1.offsetX, -this.leftleg1.offsetY, -this.leftleg1.offsetZ);
        GlStateManager.translate(-this.leftleg1.rotationPointX * f5, -this.leftleg1.rotationPointY * f5, -this.leftleg1.rotationPointZ * f5);
        this.leftleg1.render(f5);
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
    	this.rightleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F ) * 0.5F * limbSwingAmount;
    	this.rightarm1.rotateAngleX = MathHelper.cos(limbSwing  * 0.6662F + (float)Math.PI) * 0.5F * limbSwingAmount;

    
    	
    	this.leftleg1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI ) * 0.5F * limbSwingAmount;
    	this.leftarm1.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F ) * 0.5F * limbSwingAmount;
    }
    
}
