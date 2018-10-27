package com.deextinction.deextinction.entity.model.cenozoic;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

/**
 * Smilodon Populator - TheSirBatman
 * Created using Tabula 7.0.0
 */
public class ModelSmilodon extends ModelBase {
    public ModelRenderer rear;
    public ModelRenderer fleftjoint;
    public ModelRenderer frightjoint;
    public ModelRenderer rleftjoint;
    public ModelRenderer rrightjoint;
    public ModelRenderer body;
    public ModelRenderer tail;
    public ModelRenderer neck;
    public ModelRenderer hump2;
    public ModelRenderer head;
    public ModelRenderer hump1;
    public ModelRenderer topjaw;
    public ModelRenderer lowerjaw;
    public ModelRenderer leftear;
    public ModelRenderer rightear;
    public ModelRenderer snout;
    public ModelRenderer lefttooth;
    public ModelRenderer righttooth;
    public ModelRenderer leftear2;
    public ModelRenderer rightear2;
    public ModelRenderer leftarm1;
    public ModelRenderer leftarm2;
    public ModelRenderer leftpaw;
    public ModelRenderer rightarm1;
    public ModelRenderer rightarm2;
    public ModelRenderer rightpaw;
    public ModelRenderer leftleg1;
    public ModelRenderer leftleg2;
    public ModelRenderer leftleg3;
    public ModelRenderer leftfoot;
    public ModelRenderer rightleg1;
    public ModelRenderer rightleg2;
    public ModelRenderer rightleg3;
    public ModelRenderer rightfoot;

    public ModelSmilodon() {
        this.textureWidth = 80;
        this.textureHeight = 100;
        this.leftarm1 = new ModelRenderer(this, 0, 39);
        this.leftarm1.setRotationPoint(0.1F, 0.8F, -0.1F);
        this.leftarm1.addBox(0.0F, -2.3F, -2.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(leftarm1, 0.22759093446006054F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 51, 39);
        this.snout.setRotationPoint(0.0F, -1.4F, -4.2F);
        this.snout.addBox(-2.0F, 0.0F, -1.9F, 4, 2, 4, 0.0F);
        this.setRotateAngle(snout, 0.5462880558742251F, 0.0F, 0.0F);
        this.rear = new ModelRenderer(this, 0, 18);
        this.rear.setRotationPoint(0.0F, 6.500000000000003F, -2.4F);
        this.rear.addBox(-3.5F, -4.5F, 0.0F, 7, 7, 12, 0.0F);
        this.lefttooth = new ModelRenderer(this, 35, 44);
        this.lefttooth.setRotationPoint(1.4F, 1.0F, -4.3F);
        this.lefttooth.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(lefttooth, 0.4553564018453205F, 0.0F, 0.0F);
        this.rightpaw = new ModelRenderer(this, 0, 63);
        this.rightpaw.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.rightpaw.addBox(-2.0F, 0.0F, -2.5F, 4, 2, 4, 0.0F);
        this.setRotateAngle(rightpaw, 0.091106186954104F, 0.0F, 0.0F);
        this.leftpaw = new ModelRenderer(this, 0, 63);
        this.leftpaw.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.leftpaw.addBox(-2.0F, 0.0F, -2.5F, 4, 2, 4, 0.0F);
        this.setRotateAngle(leftpaw, 0.091106186954104F, 0.0F, 0.0F);
        this.rightarm1 = new ModelRenderer(this, 0, 39);
        this.rightarm1.setRotationPoint(-0.1F, 0.8F, -0.1F);
        this.rightarm1.addBox(-4.0F, -2.3F, -2.0F, 4, 5, 4, 0.0F);
        this.setRotateAngle(rightarm1, 0.22759093446006054F, 0.0F, 0.0F);
        this.leftarm2 = new ModelRenderer(this, 0, 50);
        this.leftarm2.setRotationPoint(2.0F, 2.1F, 0.0F);
        this.leftarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(leftarm2, -0.31869712141416456F, 0.0F, 0.0F);
        this.righttooth = new ModelRenderer(this, 40, 44);
        this.righttooth.setRotationPoint(-2.4F, 1.0F, -4.3F);
        this.righttooth.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(righttooth, 0.4553564018453205F, 0.0F, 0.0F);
        this.leftleg2 = new ModelRenderer(this, 18, 51);
        this.leftleg2.setRotationPoint(2.0F, 1.6F, 0.3F);
        this.leftleg2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(leftleg2, 0.36425021489121656F, 0.0F, 0.0F);
        this.rightleg2 = new ModelRenderer(this, 18, 51);
        this.rightleg2.setRotationPoint(-2.0F, 1.6F, 0.3F);
        this.rightleg2.addBox(-1.5F, 0.0F, -1.5F, 3, 5, 3, 0.0F);
        this.setRotateAngle(rightleg2, 0.36425021489121656F, 0.0F, 0.0F);
        this.rrightjoint = new ModelRenderer(this, 0, 11);
        this.rrightjoint.setRotationPoint(-1.5F, 6.400000000000003F, 9.4F);
        this.rrightjoint.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.leftleg1 = new ModelRenderer(this, 18, 39);
        this.leftleg1.setRotationPoint(-0.1F, 1.1F, -0.1F);
        this.leftleg1.addBox(0.0F, -3.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(leftleg1, -0.136659280431156F, 0.0F, 0.0F);
        this.leftfoot = new ModelRenderer(this, 30, 61);
        this.leftfoot.setRotationPoint(0.0F, 3.4F, 0.4F);
        this.leftfoot.addBox(-1.5F, 0.0F, -2.5F, 3, 2, 3, 0.0F);
        this.setRotateAngle(leftfoot, 0.18203784098300857F, 0.0F, 0.0F);
        this.topjaw = new ModelRenderer(this, 37, 37);
        this.topjaw.setRotationPoint(0.0F, 0.7F, -1.0F);
        this.topjaw.addBox(-2.5F, -0.7F, -4.6F, 5, 2, 3, 0.0F);
        this.setRotateAngle(topjaw, -0.36425021489121656F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 28, 18);
        this.tail.setRotationPoint(0.0F, -3.7F, 11.3F);
        this.tail.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 5, 0.0F);
        this.setRotateAngle(tail, -0.7285004297824331F, 0.0F, 0.0F);
        this.rightfoot = new ModelRenderer(this, 30, 61);
        this.rightfoot.setRotationPoint(0.0F, 3.4F, 0.4F);
        this.rightfoot.addBox(-1.5F, 0.0F, -2.5F, 3, 2, 3, 0.0F);
        this.setRotateAngle(rightfoot, 0.18203784098300857F, 0.0F, 0.0F);
        this.rightear = new ModelRenderer(this, 53, 31);
        this.rightear.setRotationPoint(-2.7F, -1.0F, -0.5F);
        this.rightear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(rightear, -1.0016444577195458F, -0.40980330836826856F, 0.0F);
        this.hump1 = new ModelRenderer(this, 33, 8);
        this.hump1.setRotationPoint(-2.0F, -3.5F, -5.6F);
        this.hump1.addBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F);
        this.setRotateAngle(hump1, 0.31869712141416456F, 0.0F, 0.0F);
        this.fleftjoint = new ModelRenderer(this, 0, 11);
        this.fleftjoint.setRotationPoint(1.2F, 7.100000000000002F, -7.4F);
        this.fleftjoint.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.leftleg3 = new ModelRenderer(this, 18, 61);
        this.leftleg3.setRotationPoint(0.0F, 4.3F, 0.6F);
        this.leftleg3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(leftleg3, -0.40980330836826856F, 0.0F, 0.0F);
        this.rightleg1 = new ModelRenderer(this, 18, 39);
        this.rightleg1.setRotationPoint(0.1F, 1.1F, -0.1F);
        this.rightleg1.addBox(-4.0F, -3.0F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(rightleg1, -0.136659280431156F, 0.0F, 0.0F);
        this.neck = new ModelRenderer(this, 46, 0);
        this.neck.setRotationPoint(0.0F, -0.8F, -6.8F);
        this.neck.addBox(-2.5F, -3.5F, -6.0F, 5, 5, 6, 0.0F);
        this.setRotateAngle(neck, -0.091106186954104F, 0.0F, 0.0F);
        this.frightjoint = new ModelRenderer(this, 0, 11);
        this.frightjoint.setRotationPoint(-1.2F, 7.000000000000003F, -7.4F);
        this.frightjoint.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.hump2 = new ModelRenderer(this, 45, 12);
        this.hump2.setRotationPoint(-1.5F, -5.7F, -8.3F);
        this.hump2.addBox(0.0F, 0.0F, 0.0F, 3, 3, 5, 0.0F);
        this.setRotateAngle(hump2, -0.27296949501191314F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setRotationPoint(0.0F, -0.1F, 0.8F);
        this.body.addBox(-4.0F, -4.5F, -8.0F, 8, 8, 8, 0.0F);
        this.setRotateAngle(body, 0.045553093477052F, 0.0F, 0.0F);
        this.rightleg3 = new ModelRenderer(this, 18, 61);
        this.rightleg3.setRotationPoint(0.0F, 4.3F, 0.6F);
        this.rightleg3.addBox(-1.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F);
        this.setRotateAngle(rightleg3, -0.40980330836826856F, 0.0F, 0.0F);
        this.lowerjaw = new ModelRenderer(this, 42, 46);
        this.lowerjaw.setRotationPoint(0.0F, 1.5F, -1.8F);
        this.lowerjaw.addBox(-1.5F, -1.0F, -4.0F, 3, 2, 4, 0.0F);
        this.setRotateAngle(lowerjaw, -0.136659280431156F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 43, 22);
        this.head.setRotationPoint(0.0F, -1.2F, -5.0F);
        this.head.addBox(-3.0F, -2.5F, -3.0F, 6, 5, 3, 0.0F);
        this.setRotateAngle(head, 0.36425021489121656F, 0.0F, 0.0F);
        this.rightear2 = new ModelRenderer(this, 60, 31);
        this.rightear2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightear2.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.leftear = new ModelRenderer(this, 40, 31);
        this.leftear.setRotationPoint(2.7F, -1.0F, -0.2F);
        this.leftear.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(leftear, -1.0016444577195458F, 0.40980330836826856F, 0.0F);
        this.leftear2 = new ModelRenderer(this, 48, 31);
        this.leftear2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftear2.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rightarm2 = new ModelRenderer(this, 0, 50);
        this.rightarm2.setRotationPoint(-2.0F, 2.1F, 0.0F);
        this.rightarm2.addBox(-1.5F, 0.0F, -1.5F, 3, 8, 3, 0.0F);
        this.setRotateAngle(rightarm2, -0.31869712141416456F, 0.0F, 0.0F);
        this.rleftjoint = new ModelRenderer(this, 0, 11);
        this.rleftjoint.setRotationPoint(1.5F, 6.400000000000003F, 9.4F);
        this.rleftjoint.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.fleftjoint.addChild(this.leftarm1);
        this.topjaw.addChild(this.snout);
        this.topjaw.addChild(this.lefttooth);
        this.rightarm2.addChild(this.rightpaw);
        this.leftarm2.addChild(this.leftpaw);
        this.frightjoint.addChild(this.rightarm1);
        this.leftarm1.addChild(this.leftarm2);
        this.topjaw.addChild(this.righttooth);
        this.leftleg1.addChild(this.leftleg2);
        this.rightleg1.addChild(this.rightleg2);
        this.rleftjoint.addChild(this.leftleg1);
        this.leftleg3.addChild(this.leftfoot);
        this.head.addChild(this.topjaw);
        this.rear.addChild(this.tail);
        this.rightleg3.addChild(this.rightfoot);
        this.head.addChild(this.rightear);
        this.neck.addChild(this.hump1);
        this.leftleg2.addChild(this.leftleg3);
        this.rrightjoint.addChild(this.rightleg1);
        this.body.addChild(this.neck);
        this.body.addChild(this.hump2);
        this.rear.addChild(this.body);
        this.rightleg2.addChild(this.rightleg3);
        this.head.addChild(this.lowerjaw);
        this.neck.addChild(this.head);
        this.rightear.addChild(this.rightear2);
        this.head.addChild(this.leftear);
        this.leftear.addChild(this.leftear2);
        this.rightarm1.addChild(this.rightarm2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rear.offsetX, this.rear.offsetY, this.rear.offsetZ);
        GlStateManager.translate(this.rear.rotationPointX * f5, this.rear.rotationPointY * f5, this.rear.rotationPointZ * f5);
        GlStateManager.scale(1.54D, 1.54D, 1.54D);
        GlStateManager.translate(-this.rear.offsetX, -this.rear.offsetY, -this.rear.offsetZ);
        GlStateManager.translate(-this.rear.rotationPointX * f5, -this.rear.rotationPointY * f5, -this.rear.rotationPointZ * f5);
        this.rear.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rrightjoint.offsetX, this.rrightjoint.offsetY, this.rrightjoint.offsetZ);
        GlStateManager.translate(this.rrightjoint.rotationPointX * f5, this.rrightjoint.rotationPointY * f5, this.rrightjoint.rotationPointZ * f5);
        GlStateManager.scale(1.54D, 1.54D, 1.54D);
        GlStateManager.translate(-this.rrightjoint.offsetX, -this.rrightjoint.offsetY, -this.rrightjoint.offsetZ);
        GlStateManager.translate(-this.rrightjoint.rotationPointX * f5, -this.rrightjoint.rotationPointY * f5, -this.rrightjoint.rotationPointZ * f5);
        this.rrightjoint.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.fleftjoint.offsetX, this.fleftjoint.offsetY, this.fleftjoint.offsetZ);
        GlStateManager.translate(this.fleftjoint.rotationPointX * f5, this.fleftjoint.rotationPointY * f5, this.fleftjoint.rotationPointZ * f5);
        GlStateManager.scale(1.54D, 1.54D, 1.54D);
        GlStateManager.translate(-this.fleftjoint.offsetX, -this.fleftjoint.offsetY, -this.fleftjoint.offsetZ);
        GlStateManager.translate(-this.fleftjoint.rotationPointX * f5, -this.fleftjoint.rotationPointY * f5, -this.fleftjoint.rotationPointZ * f5);
        this.fleftjoint.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.frightjoint.offsetX, this.frightjoint.offsetY, this.frightjoint.offsetZ);
        GlStateManager.translate(this.frightjoint.rotationPointX * f5, this.frightjoint.rotationPointY * f5, this.frightjoint.rotationPointZ * f5);
        GlStateManager.scale(1.54D, 1.54D, 1.54D);
        GlStateManager.translate(-this.frightjoint.offsetX, -this.frightjoint.offsetY, -this.frightjoint.offsetZ);
        GlStateManager.translate(-this.frightjoint.rotationPointX * f5, -this.frightjoint.rotationPointY * f5, -this.frightjoint.rotationPointZ * f5);
        this.frightjoint.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.rleftjoint.offsetX, this.rleftjoint.offsetY, this.rleftjoint.offsetZ);
        GlStateManager.translate(this.rleftjoint.rotationPointX * f5, this.rleftjoint.rotationPointY * f5, this.rleftjoint.rotationPointZ * f5);
        GlStateManager.scale(1.54D, 1.54D, 1.54D);
        GlStateManager.translate(-this.rleftjoint.offsetX, -this.rleftjoint.offsetY, -this.rleftjoint.offsetZ);
        GlStateManager.translate(-this.rleftjoint.rotationPointX * f5, -this.rleftjoint.rotationPointY * f5, -this.rleftjoint.rotationPointZ * f5);
        this.rleftjoint.render(f5);
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
    	this.rrightjoint.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F ) * 0.6F * limbSwingAmount;
    	this.frightjoint.rotateAngleX = MathHelper.cos(limbSwing  * 0.6662F + (float)Math.PI) * 0.6F * limbSwingAmount;

    
    	
    	this.rleftjoint.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI ) * 0.6F * limbSwingAmount;
    	this.fleftjoint.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F ) * 0.6F * limbSwingAmount;
    }
    
}
