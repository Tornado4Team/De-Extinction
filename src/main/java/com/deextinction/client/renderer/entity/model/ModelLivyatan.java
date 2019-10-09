package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.animal.EntityLivyatan;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

/**
 * ModelLivyatan - Batman Created using Tabula 7.0.0
 */
public class ModelLivyatan extends ResettableModelBase
{
	public ResettableModelRenderer body;
	public ResettableModelRenderer rear;
	public ResettableModelRenderer head1;
	public ResettableModelRenderer lowerhead;
	public ResettableModelRenderer leftflipper1;
	public ResettableModelRenderer rightflipper1;
	public ResettableModelRenderer tail1;
	public ResettableModelRenderer topfin;
	public ResettableModelRenderer tail2;
	public ResettableModelRenderer ttail1;
	public ResettableModelRenderer tail3;
	public ResettableModelRenderer ttail2;
	public ResettableModelRenderer tail4;
	public ResettableModelRenderer ttail3;
	public ResettableModelRenderer flukebase;
	public ResettableModelRenderer ttail4;
	public ResettableModelRenderer leftfluke1;
	public ResettableModelRenderer rightfluke1;
	public ResettableModelRenderer flukebaseleft;
	public ResettableModelRenderer flukebaseright;
	public ResettableModelRenderer centerfluke1;
	public ResettableModelRenderer fluketop;
	public ResettableModelRenderer leftfluke2;
	public ResettableModelRenderer rightfluke2;
	public ResettableModelRenderer head2;
	public ResettableModelRenderer head3;
	public ResettableModelRenderer uppdental;
	public ResettableModelRenderer head4;
	public ResettableModelRenderer head4_1;
	public ResettableModelRenderer head4_2;
	public ResettableModelRenderer teeth1;
	public ResettableModelRenderer teeth2;
	public ResettableModelRenderer teeth3;
	public ResettableModelRenderer teeth4;
	public ResettableModelRenderer teeth5;
	public ResettableModelRenderer teeth6;
	public ResettableModelRenderer teeth7;
	public ResettableModelRenderer teeth8;
	public ResettableModelRenderer teeth9;
	public ResettableModelRenderer teeth10;
	public ResettableModelRenderer teeth11;
	public ResettableModelRenderer teeth12;
	public ResettableModelRenderer teeth13;
	public ResettableModelRenderer teeth14;
	public ResettableModelRenderer teeth15;
	public ResettableModelRenderer teeth16;
	public ResettableModelRenderer teeth17;
	public ResettableModelRenderer teeth18;
	public ResettableModelRenderer lowerjaw2;
	public ResettableModelRenderer lowerjaw3;
	public ResettableModelRenderer lowerjaw4;
	public ResettableModelRenderer teeth19;
	public ResettableModelRenderer teeth20;
	public ResettableModelRenderer teeth21;
	public ResettableModelRenderer teeth22;
	public ResettableModelRenderer teeth23;
	public ResettableModelRenderer teeth24;
	public ResettableModelRenderer teeth25;
	public ResettableModelRenderer teeth26;
	public ResettableModelRenderer teeth27;
	public ResettableModelRenderer teeth28;
	public ResettableModelRenderer teeth29;
	public ResettableModelRenderer teeth30;
	public ResettableModelRenderer teeth31;
	public ResettableModelRenderer teeth32;
	public ResettableModelRenderer teeth33;
	public ResettableModelRenderer teeth34;
	public ResettableModelRenderer teeth35;
	public ResettableModelRenderer teeth36;
	public ResettableModelRenderer leftflipper1_1;
	public ResettableModelRenderer leftflipper1_2;
	public ResettableModelRenderer rightflipper2;
	public ResettableModelRenderer rightflipper3;
	public ResettableModelRenderer[] bodyParts;
	private Animator animator;

	public ModelLivyatan()
	{
		this.textureWidth = 150;
		this.textureHeight = 200;

		this.teeth10 = new ResettableModelRenderer(this, 0, 0);
		this.teeth10.setRotationPoint(1.4F, 1.0F, 0.7F);
		this.teeth10.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth10.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.teeth18 = new ResettableModelRenderer(this, 0, 0);
		this.teeth18.setRotationPoint(-1.4F, 1.2F, 1.6F);
		this.teeth18.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth18.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.flukebase = new ResettableModelRenderer(this, 0, 161);
		this.flukebase.setRotationPoint(0.0F, 0.8F, 9.0F);
		this.flukebase.addBox(-4.0F, -1.5F, -1.8F, 8, 3, 6, 0.0F);
		this.flukebase.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.teeth16 = new ResettableModelRenderer(this, 0, 0);
		this.teeth16.setRotationPoint(-1.4F, 1.0F, -0.2F);
		this.teeth16.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth16.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.ttail4 = new ResettableModelRenderer(this, 87, 110);
		this.ttail4.setRotationPoint(0.0F, -4.5F, 0.7F);
		this.ttail4.addBox(-2.0F, -2.1F, 0.0F, 4, 3, 7, 0.0F);
		this.ttail4.setRotateAngle(-0.4363323129985824F, 0.0F, 0.0F);

		this.centerfluke1 = new ResettableModelRenderer(this, -1, 192);
		this.centerfluke1.setRotationPoint(0.0F, 0.0F, 4.0F);
		this.centerfluke1.addBox(-12.5F, -0.5F, 0.0F, 25, 1, 6, 0.0F);
		this.centerfluke1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.teeth26 = new ResettableModelRenderer(this, 0, 0);
		this.teeth26.setRotationPoint(1.4F, 0.8F, -1.3F);
		this.teeth26.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth26.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.teeth34 = new ResettableModelRenderer(this, 0, 0);
		this.teeth34.setRotationPoint(-1.4F, 0.8F, -0.2F);
		this.teeth34.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth34.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.rightflipper2 = new ResettableModelRenderer(this, 7, 0);
		this.rightflipper2.setRotationPoint(0.0F, 3.8F, 0.1F);
		this.rightflipper2.addBox(-0.5F, 0.0F, -2.0F, 1, 5, 6, 0.0F);
		this.rightflipper2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.head4_2 = new ResettableModelRenderer(this, 115, 30);
		this.head4_2.setRotationPoint(0.0F, 11.0F, 0.6F);
		this.head4_2.addBox(-4.5F, -1.5F, -2.0F, 9, 3, 4, 0.0F);
		this.head4_2.setRotateAngle(1.3203415791337103F, 0.0F, 0.0F);

		this.lowerjaw3 = new ResettableModelRenderer(this, 52, 123);
		this.lowerjaw3.setRotationPoint(0.0F, 0.0F, 0.3F);
		this.lowerjaw3.addBox(-1.5F, 0.7F, -14.4F, 3, 1, 14, 0.0F);
		this.lowerjaw3.setRotateAngle(-0.136659280431156F, 0.0F, 0.0F);

		this.teeth24 = new ResettableModelRenderer(this, 0, 0);
		this.teeth24.setRotationPoint(1.4F, 0.8F, -3.5F);
		this.teeth24.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth24.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.topfin = new ResettableModelRenderer(this, 3, 43);
		this.topfin.setRotationPoint(0.0F, -7.5F, 18.0F);
		this.topfin.addBox(-1.0F, 0.0F, 0.0F, 2, 2, 5, 0.0F);
		this.topfin.setRotateAngle(0.4363323129985824F, 0.0F, 0.0F);

		this.head4_1 = new ResettableModelRenderer(this, 119, 23);
		this.head4_1.setRotationPoint(0.0F, 12.4F, 0.7F);
		this.head4_1.addBox(-4.0F, -2.5F, -2.0F, 8, 2, 4, 0.0F);
		this.head4_1.setRotateAngle(0.36425021489121656F, 0.0F, 0.0F);

		this.teeth31 = new ResettableModelRenderer(this, 0, 0);
		this.teeth31.setRotationPoint(-1.4F, 0.8F, -3.5F);
		this.teeth31.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth31.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.teeth33 = new ResettableModelRenderer(this, 0, 0);
		this.teeth33.setRotationPoint(-1.4F, 0.8F, -1.3F);
		this.teeth33.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth33.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.rightfluke2 = new ResettableModelRenderer(this, 0, 183);
		this.rightfluke2.setRotationPoint(-0.8F, -0.4F, 8.4F);
		this.rightfluke2.addBox(-2.0F, -0.5F, 0.0F, 4, 2, 6, 0.0F);
		this.rightfluke2.setRotateAngle(0.0F, 0.2181661564992912F, 0.0F);

		this.teeth12 = new ResettableModelRenderer(this, 0, 0);
		this.teeth12.setRotationPoint(-1.4F, 0.8F, -4.5F);
		this.teeth12.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth12.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.head3 = new ResettableModelRenderer(this, 76, 54);
		this.head3.setRotationPoint(0.0F, 2.6F, -15.4F);
		this.head3.addBox(-5.0F, -6.0F, -2.0F, 10, 9, 4, 0.0F);
		this.head3.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.teeth11 = new ResettableModelRenderer(this, 0, 0);
		this.teeth11.setRotationPoint(1.4F, 1.2F, 1.6F);
		this.teeth11.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth11.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.lowerjaw4 = new ResettableModelRenderer(this, 52, 112);
		this.lowerjaw4.setRotationPoint(0.0F, -2.1F, -7.1F);
		this.lowerjaw4.addBox(-2.0F, 0.7F, -7.0F, 4, 1, 7, 0.0F);
		this.lowerjaw4.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.teeth27 = new ResettableModelRenderer(this, 0, 0);
		this.teeth27.setRotationPoint(1.4F, 0.8F, -0.2F);
		this.teeth27.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth27.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.ttail2 = new ResettableModelRenderer(this, 83, 85);
		this.ttail2.setRotationPoint(0.0F, -5.6F, 1.4F);
		this.ttail2.addBox(-2.9F, -2.1F, 0.0F, 6, 4, 7, 0.0F);
		this.ttail2.setRotateAngle(-0.27314402793711257F, 0.0F, 0.0F);

		this.teeth8 = new ResettableModelRenderer(this, 0, 0);
		this.teeth8.setRotationPoint(1.4F, 0.8F, -1.3F);
		this.teeth8.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth8.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.lowerhead = new ResettableModelRenderer(this, 52, 88);
		this.lowerhead.setRotationPoint(0.0F, 6.5F, -21.1F);
		this.lowerhead.addBox(-3.5F, -1.5F, -8.0F, 7, 3, 8, 0.0F);
		this.lowerhead.setRotateAngle(-0.04363323129985824F, 0.0F, 0.0F);

		this.leftfluke2 = new ResettableModelRenderer(this, 0, 183);
		this.leftfluke2.setRotationPoint(0.8F, -0.4F, 8.4F);
		this.leftfluke2.addBox(-2.0F, -0.5F, 0.0F, 4, 2, 6, 0.0F);
		this.leftfluke2.setRotateAngle(0.0F, -0.2181661564992912F, 0.0F);

		this.rear = new ResettableModelRenderer(this, 0, 40);
		this.rear.setRotationPoint(0.0F, -0.3F, -1.5F);
		this.rear.addBox(-6.0F, -7.5F, 0.0F, 12, 15, 25, 0.0F);
		this.rear.setRotateAngle(-0.08726646259971647F, 0.0F, 0.0F);

		this.teeth7 = new ResettableModelRenderer(this, 0, 0);
		this.teeth7.setRotationPoint(1.4F, 0.8F, -2.4F);
		this.teeth7.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth7.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.teeth2 = new ResettableModelRenderer(this, 0, 0);
		this.teeth2.setRotationPoint(-1.4F, 0.8F, -6.2F);
		this.teeth2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth2.setRotateAngle(0.9105382707654417F, 0.0F, -0.36425021489121656F);

		this.teeth25 = new ResettableModelRenderer(this, 0, 0);
		this.teeth25.setRotationPoint(1.4F, 0.8F, -2.4F);
		this.teeth25.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth25.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.rightflipper1 = new ResettableModelRenderer(this, 0, 12);
		this.rightflipper1.setRotationPoint(-6.0F, 5.0F, -16.0F);
		this.rightflipper1.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 3, 0.0F);
		this.rightflipper1.setRotateAngle(0.7740535232594852F, -0.4553564018453205F, 0.4553564018453205F);

		this.teeth17 = new ResettableModelRenderer(this, 0, 0);
		this.teeth17.setRotationPoint(-1.4F, 1.0F, 0.7F);
		this.teeth17.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth17.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.rightflipper3 = new ResettableModelRenderer(this, 11, 12);
		this.rightflipper3.setRotationPoint(-0.2F, -3.5F, 0.3F);
		this.rightflipper3.addBox(-0.5F, 0.0F, -2.0F, 1, 5, 3, 0.0F);
		this.rightflipper3.setRotateAngle(0.5918411493512771F, 0.0F, 0.0F);

		this.tail3 = new ResettableModelRenderer(this, 28, 137);
		this.tail3.setRotationPoint(0.0F, 0.4F, 8.2F);
		this.tail3.addBox(-3.0F, -4.5F, 0.0F, 6, 9, 9, 0.0F);
		this.tail3.setRotateAngle(-0.04363323129985824F, 0.0F, 0.0F);

		this.teeth32 = new ResettableModelRenderer(this, 0, 0);
		this.teeth32.setRotationPoint(-1.4F, 0.8F, -2.4F);
		this.teeth32.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth32.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.teeth3 = new ResettableModelRenderer(this, 0, 0);
		this.teeth3.setRotationPoint(1.4F, 0.8F, -5.4F);
		this.teeth3.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth3.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.leftflipper1_1 = new ResettableModelRenderer(this, 7, 0);
		this.leftflipper1_1.setRotationPoint(0.0F, 3.8F, 0.1F);
		this.leftflipper1_1.addBox(-0.5F, 0.0F, -2.0F, 1, 5, 6, 0.0F);
		this.leftflipper1_1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.flukebaseright = new ResettableModelRenderer(this, 0, 133);
		this.flukebaseright.setRotationPoint(-3.5F, 0.0F, 0.5F);
		this.flukebaseright.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
		this.flukebaseright.setRotateAngle(0.0F, -0.5918411493512771F, 0.0F);

		this.teeth30 = new ResettableModelRenderer(this, 0, 0);
		this.teeth30.setRotationPoint(-1.4F, 0.8F, -4.5F);
		this.teeth30.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth30.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.ttail3 = new ResettableModelRenderer(this, 84, 97);
		this.ttail3.setRotationPoint(0.0F, -4.1F, -0.4F);
		this.ttail3.addBox(-2.5F, -2.1F, 0.0F, 5, 3, 9, 0.0F);
		this.ttail3.setRotateAngle(-0.18203784098300857F, 0.0F, 0.0F);

		this.head2 = new ResettableModelRenderer(this, 73, 23);
		this.head2.setRotationPoint(0.0F, 2.7F, -5.1F);
		this.head2.addBox(-5.5F, -6.0F, -16.5F, 11, 12, 18, 0.0F);
		this.head2.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.head4 = new ResettableModelRenderer(this, 118, 2);
		this.head4.setRotationPoint(0.0F, -4.8F, 11.3F);
		this.head4.addBox(-4.5F, -5.0F, -2.0F, 9, 16, 4, 0.0F);
		this.head4.setRotateAngle(-1.7756979809790308F, 0.0F, 0.0F);

		this.ttail1 = new ResettableModelRenderer(this, 72, 69);
		this.ttail1.setRotationPoint(0.0F, -5.8F, -0.2F);
		this.ttail1.addBox(-4.5F, -2.1F, 0.0F, 9, 4, 11, 0.0F);
		this.ttail1.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.teeth20 = new ResettableModelRenderer(this, 0, 0);
		this.teeth20.setRotationPoint(-1.4F, 0.8F, -6.2F);
		this.teeth20.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth20.setRotateAngle(0.9105382707654417F, 0.0F, -0.36425021489121656F);

		this.fluketop = new ResettableModelRenderer(this, 25, 156);
		this.fluketop.setRotationPoint(0.0F, -2.4F, -2.5F);
		this.fluketop.addBox(-1.5F, -2.1F, 0.0F, 3, 3, 7, 0.0F);
		this.fluketop.setRotateAngle(-0.4363323129985824F, 0.0F, 0.0F);

		this.teeth19 = new ResettableModelRenderer(this, 0, 0);
		this.teeth19.setRotationPoint(1.4F, 0.8F, -6.2F);
		this.teeth19.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth19.setRotateAngle(0.9105382707654417F, 0.0F, 0.36425021489121656F);

		this.leftfluke1 = new ResettableModelRenderer(this, 0, 171);
		this.leftfluke1.setRotationPoint(2.5F, 0.0F, 1.0F);
		this.leftfluke1.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 9, 0.0F);
		this.leftfluke1.setRotateAngle(0.0F, 1.0471975511965976F, 0.0F);

		this.teeth23 = new ResettableModelRenderer(this, 0, 0);
		this.teeth23.setRotationPoint(1.4F, 0.8F, -4.5F);
		this.teeth23.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth23.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.leftflipper1_2 = new ResettableModelRenderer(this, 11, 12);
		this.leftflipper1_2.setRotationPoint(-0.2F, -3.5F, 0.3F);
		this.leftflipper1_2.addBox(-0.5F, 0.0F, -2.0F, 1, 5, 3, 0.0F);
		this.leftflipper1_2.setRotateAngle(0.5918411493512771F, 0.0F, 0.0F);

		this.teeth35 = new ResettableModelRenderer(this, 0, 0);
		this.teeth35.setRotationPoint(-1.4F, 0.8F, 0.7F);
		this.teeth35.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth35.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.tail1 = new ResettableModelRenderer(this, 0, 83);
		this.tail1.setRotationPoint(0.0F, 0.2F, 23.0F);
		this.tail1.addBox(-5.0F, -6.5F, 0.0F, 10, 13, 11, 0.0F);
		this.tail1.setRotateAngle(0.04363323129985824F, 0.0F, 0.0F);

		this.rightfluke1 = new ResettableModelRenderer(this, 0, 171);
		this.rightfluke1.setRotationPoint(-2.5F, 0.0F, 1.0F);
		this.rightfluke1.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 9, 0.0F);
		this.rightfluke1.setRotateAngle(0.0F, -1.0471975511965976F, 0.0F);

		this.flukebaseleft = new ResettableModelRenderer(this, 0, 133);
		this.flukebaseleft.setRotationPoint(3.5F, 0.0F, 0.0F);
		this.flukebaseleft.addBox(-1.0F, -1.0F, -3.0F, 2, 2, 3, 0.0F);
		this.flukebaseleft.setRotateAngle(0.0F, 0.5462880558742251F, 0.0F);

		this.leftflipper1 = new ResettableModelRenderer(this, 0, 12);
		this.leftflipper1.setRotationPoint(6.0F, 5.0F, -16.0F);
		this.leftflipper1.addBox(-1.0F, 0.0F, -2.0F, 2, 5, 3, 0.0F);
		this.leftflipper1.setRotateAngle(0.7740535232594852F, 0.4553564018453205F, -0.4553564018453205F);

		this.tail2 = new ResettableModelRenderer(this, 0, 112);
		this.tail2.setRotationPoint(0.0F, 0.7F, 8.6F);
		this.tail2.addBox(-3.5F, -5.5F, 0.0F, 7, 11, 9, 0.0F);
		this.tail2.setRotateAngle(0.04363323129985824F, 0.0F, 0.0F);

		this.teeth22 = new ResettableModelRenderer(this, 0, 0);
		this.teeth22.setRotationPoint(-1.4F, 0.8F, -5.4F);
		this.teeth22.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth22.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.tail4 = new ResettableModelRenderer(this, 0, 140);
		this.tail4.setRotationPoint(0.0F, 1.7F, 6.5F);
		this.tail4.addBox(-2.5F, -3.3F, 0.0F, 5, 6, 8, 0.0F);
		this.tail4.setRotateAngle(-0.17453292519943295F, 0.0F, 0.0F);

		this.teeth28 = new ResettableModelRenderer(this, 0, 0);
		this.teeth28.setRotationPoint(1.4F, 0.8F, 0.7F);
		this.teeth28.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth28.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.teeth21 = new ResettableModelRenderer(this, 0, 0);
		this.teeth21.setRotationPoint(1.4F, 0.8F, -5.4F);
		this.teeth21.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth21.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.teeth36 = new ResettableModelRenderer(this, 0, 0);
		this.teeth36.setRotationPoint(-1.4F, 0.8F, 1.6F);
		this.teeth36.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth36.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.head1 = new ResettableModelRenderer(this, 74, 0);
		this.head1.setRotationPoint(0.0F, -4.0F, -22.0F);
		this.head1.addBox(-6.0F, -4.0F, -7.0F, 12, 13, 7, 0.0F);
		this.head1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.teeth5 = new ResettableModelRenderer(this, 0, 0);
		this.teeth5.setRotationPoint(1.4F, 0.8F, -4.5F);
		this.teeth5.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth5.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.teeth6 = new ResettableModelRenderer(this, 0, 0);
		this.teeth6.setRotationPoint(1.4F, 0.8F, -3.5F);
		this.teeth6.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth6.setRotateAngle(0.7285004297824331F, 0.0F, 0.36425021489121656F);

		this.teeth13 = new ResettableModelRenderer(this, 0, 0);
		this.teeth13.setRotationPoint(-1.4F, 0.8F, -3.5F);
		this.teeth13.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth13.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.teeth14 = new ResettableModelRenderer(this, 0, 0);
		this.teeth14.setRotationPoint(-1.4F, 0.8F, -2.4F);
		this.teeth14.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth14.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.teeth29 = new ResettableModelRenderer(this, 0, 0);
		this.teeth29.setRotationPoint(1.4F, 0.8F, 1.6F);
		this.teeth29.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth29.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.teeth1 = new ResettableModelRenderer(this, 0, 0);
		this.teeth1.setRotationPoint(1.4F, 0.8F, -6.2F);
		this.teeth1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth1.setRotateAngle(0.9105382707654417F, 0.0F, 0.36425021489121656F);

		this.teeth15 = new ResettableModelRenderer(this, 0, 0);
		this.teeth15.setRotationPoint(-1.4F, 0.8F, -1.3F);
		this.teeth15.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth15.setRotateAngle(0.6829473363053812F, 0.0F, -0.36425021489121656F);

		this.uppdental = new ResettableModelRenderer(this, 48, 126);
		this.uppdental.setRotationPoint(0.0F, 6.9F, -8.2F);
		this.uppdental.addBox(-2.0F, 1.3F, -7.0F, 4, 0, 7, 0.0F);
		this.uppdental.setRotateAngle(0.045553093477052F, 0.0F, 3.141592653589793F);

		this.teeth4 = new ResettableModelRenderer(this, 0, 0);
		this.teeth4.setRotationPoint(-1.4F, 0.8F, -5.4F);
		this.teeth4.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth4.setRotateAngle(0.7285004297824331F, 0.0F, -0.36425021489121656F);

		this.teeth9 = new ResettableModelRenderer(this, 0, 0);
		this.teeth9.setRotationPoint(1.4F, 1.0F, -0.2F);
		this.teeth9.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.teeth9.setRotateAngle(0.6829473363053812F, 0.0F, 0.36425021489121656F);

		this.lowerjaw2 = new ResettableModelRenderer(this, 52, 100);
		this.lowerjaw2.setRotationPoint(0.0F, -0.1F, -6.9F);
		this.lowerjaw2.addBox(-2.5F, -1.5F, -9.0F, 5, 2, 9, 0.0F);
		this.lowerjaw2.setRotateAngle(0.04363323129985824F, 0.0F, 0.0F);

		this.body = new ResettableModelRenderer(this, 0, 0);
		this.body.setRotationPoint(0.0F, 15.5F, 4.0F);
		this.body.addBox(-6.5F, -8.0F, -22.0F, 13, 16, 22, 0.0F);
		this.body.setRotateAngle(0.04363323129985824F, 0.0F, 0.0F);

		this.uppdental.addChild(this.teeth10);
		this.uppdental.addChild(this.teeth18);
		this.tail4.addChild(this.flukebase);
		this.uppdental.addChild(this.teeth16);
		this.tail4.addChild(this.ttail4);
		this.flukebase.addChild(this.centerfluke1);
		this.lowerjaw4.addChild(this.teeth26);
		this.lowerjaw4.addChild(this.teeth34);
		this.rightflipper1.addChild(this.rightflipper2);
		this.head4.addChild(this.head4_2);
		this.lowerjaw2.addChild(this.lowerjaw3);
		this.lowerjaw4.addChild(this.teeth24);
		this.rear.addChild(this.topfin);
		this.head4.addChild(this.head4_1);
		this.lowerjaw4.addChild(this.teeth31);
		this.lowerjaw4.addChild(this.teeth33);
		this.rightfluke1.addChild(this.rightfluke2);
		this.uppdental.addChild(this.teeth12);
		this.head2.addChild(this.head3);
		this.uppdental.addChild(this.teeth11);
		this.lowerjaw2.addChild(this.lowerjaw4);
		this.lowerjaw4.addChild(this.teeth27);
		this.tail2.addChild(this.ttail2);
		this.uppdental.addChild(this.teeth8);
		this.body.addChild(this.lowerhead);
		this.leftfluke1.addChild(this.leftfluke2);
		this.body.addChild(this.rear);
		this.uppdental.addChild(this.teeth7);
		this.uppdental.addChild(this.teeth2);
		this.lowerjaw4.addChild(this.teeth25);
		this.body.addChild(this.rightflipper1);
		this.uppdental.addChild(this.teeth17);
		this.rightflipper2.addChild(this.rightflipper3);
		this.tail2.addChild(this.tail3);
		this.lowerjaw4.addChild(this.teeth32);
		this.uppdental.addChild(this.teeth3);
		this.leftflipper1.addChild(this.leftflipper1_1);
		this.flukebase.addChild(this.flukebaseright);
		this.lowerjaw4.addChild(this.teeth30);
		this.tail3.addChild(this.ttail3);
		this.head1.addChild(this.head2);
		this.head3.addChild(this.head4);
		this.tail1.addChild(this.ttail1);
		this.lowerjaw4.addChild(this.teeth20);
		this.flukebase.addChild(this.fluketop);
		this.lowerjaw4.addChild(this.teeth19);
		this.flukebase.addChild(this.leftfluke1);
		this.lowerjaw4.addChild(this.teeth23);
		this.leftflipper1_1.addChild(this.leftflipper1_2);
		this.lowerjaw4.addChild(this.teeth35);
		this.rear.addChild(this.tail1);
		this.flukebase.addChild(this.rightfluke1);
		this.flukebase.addChild(this.flukebaseleft);
		this.body.addChild(this.leftflipper1);
		this.tail1.addChild(this.tail2);
		this.lowerjaw4.addChild(this.teeth22);
		this.tail3.addChild(this.tail4);
		this.lowerjaw4.addChild(this.teeth28);
		this.lowerjaw4.addChild(this.teeth21);
		this.lowerjaw4.addChild(this.teeth36);
		this.body.addChild(this.head1);
		this.uppdental.addChild(this.teeth5);
		this.uppdental.addChild(this.teeth6);
		this.uppdental.addChild(this.teeth13);
		this.uppdental.addChild(this.teeth14);
		this.lowerjaw4.addChild(this.teeth29);
		this.uppdental.addChild(this.teeth1);
		this.uppdental.addChild(this.teeth15);
		this.head2.addChild(this.uppdental);
		this.uppdental.addChild(this.teeth4);
		this.uppdental.addChild(this.teeth9);
		this.lowerhead.addChild(this.lowerjaw2);

		this.bodyParts = new ResettableModelRenderer[7];
		this.bodyParts[6] = this.body;
		this.bodyParts[5] = this.rear;
		this.bodyParts[4] = this.tail1;
		this.bodyParts[3] = this.tail2;
		this.bodyParts[2] = this.tail3;
		this.bodyParts[1] = this.tail4;
		this.bodyParts[0] = this.flukebase;

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityLivyatan animal = (EntityLivyatan) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.body.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();

		float tailBuffer = ((EntityLivyatan) entity).tailBuffer.getAnimation(partialRenderTicks);
		for (int i = 0; i < this.bodyParts.length; i++)
			this.bodyParts[i].rotateAngleY += tailBuffer;
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityLivyatan animal)
	{
		if (animal.isInWater())
		{
			float animSpeed = 0.2F;

			this.body.rotateAngleX += pitch * ((float) Math.PI / 180.0F);
			this.body.rotateAngleY += yaw * ((float) Math.PI / 180.0F);

			float[] swim = this.getChainMovement(time, 0.1F + walkSpeed, this.bodyParts.length, animSpeed, 0.08F, 3.5F);
			for (int i = 0; i < this.bodyParts.length; i++)
				this.bodyParts[i].rotateAngleX = swim[i];
			if (walkSpeed > 0.001F)
			{
				float bodyBob1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed / 2.0F, 3.0F, 0.0F, 2.0F);
				this.body.rotationPointY -= bodyBob1;

				float arm = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 1.0F, 0.0F, -1.0F);
				this.leftflipper1.rotateAngleZ += arm;
				this.leftflipper1.rotateAngleX += 0.3F * arm;

				this.rightflipper1.rotateAngleZ -= arm;
				this.rightflipper1.rotateAngleX += 0.3F * arm;
			}
		}
	}

	private void resetPose()
	{
		this.body.resetParameters();
		this.rear.resetParameters();
		this.head1.resetParameters();
		this.lowerhead.resetParameters();
		this.leftflipper1.resetParameters();
		this.rightflipper1.resetParameters();
		this.tail1.resetParameters();
		this.topfin.resetParameters();
		this.tail2.resetParameters();
		this.ttail1.resetParameters();
		this.tail3.resetParameters();
		this.ttail2.resetParameters();
		this.tail4.resetParameters();
		this.ttail3.resetParameters();
		this.flukebase.resetParameters();
		this.ttail4.resetParameters();
		this.leftfluke1.resetParameters();
		this.rightfluke1.resetParameters();
		this.flukebaseleft.resetParameters();
		this.flukebaseright.resetParameters();
		this.centerfluke1.resetParameters();
		this.fluketop.resetParameters();
		this.leftfluke2.resetParameters();
		this.rightfluke2.resetParameters();
		this.head2.resetParameters();
		this.head3.resetParameters();
		this.uppdental.resetParameters();
		this.head4.resetParameters();
		this.head4_1.resetParameters();
		this.head4_2.resetParameters();
		this.lowerjaw2.resetParameters();
		this.lowerjaw3.resetParameters();
		this.lowerjaw4.resetParameters();
		this.leftflipper1_1.resetParameters();
		this.leftflipper1_2.resetParameters();
		this.rightflipper2.resetParameters();
		this.rightflipper3.resetParameters();
	}
}
