package com.deextinction.client.renderer.entity.model;

import com.deextinction.client.renderer.ResettableModelBase;
import com.deextinction.client.renderer.ResettableModelRenderer;
import com.deextinction.client.renderer.animations.Animator;
import com.deextinction.entity.ai.animation.DeAnimationList;
import com.deextinction.entity.animal.EntityKelenken;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;

/**
 * Kelenken - dom123048 Created using Tabula 7.0.0
 */
public class ModelKelenken extends ResettableModelBase
{
	public ResettableModelRenderer body;
	public ResettableModelRenderer femur_right;
	public ResettableModelRenderer femur_left;
	public ResettableModelRenderer Hind_1;
	public ResettableModelRenderer Shoulder;
	public ResettableModelRenderer Hind_2;
	public ResettableModelRenderer Hind_3;
	public ResettableModelRenderer butt_1;
	public ResettableModelRenderer Hind_4;
	public ResettableModelRenderer Butt_2;
	public ResettableModelRenderer Tail_Feather_1;
	public ResettableModelRenderer Pygostyle;
	public ResettableModelRenderer Tail_Feather_left;
	public ResettableModelRenderer Tail_Feather_right;
	public ResettableModelRenderer Chest;
	public ResettableModelRenderer neck_1;
	public ResettableModelRenderer Humerus_right;
	public ResettableModelRenderer humerus_left;
	public ResettableModelRenderer neck_2;
	public ResettableModelRenderer Head_Joint;
	public ResettableModelRenderer Windpipe;
	public ResettableModelRenderer head;
	public ResettableModelRenderer Upp_Beak_low;
	public ResettableModelRenderer Lower_Jaw;
	public ResettableModelRenderer feather;
	public ResettableModelRenderer feather_1;
	public ResettableModelRenderer feather_2;
	public ResettableModelRenderer feather_3;
	public ResettableModelRenderer feather_4;
	public ResettableModelRenderer feather_5;
	public ResettableModelRenderer feather_6;
	public ResettableModelRenderer feather_long;
	public ResettableModelRenderer feather_7;
	public ResettableModelRenderer feather_8;
	public ResettableModelRenderer feather_long_1;
	public ResettableModelRenderer feather_9;
	public ResettableModelRenderer feather_10;
	public ResettableModelRenderer feather_long_2;
	public ResettableModelRenderer Upp_Beak_up_1;
	public ResettableModelRenderer Nasal_right;
	public ResettableModelRenderer Nasal_left;
	public ResettableModelRenderer Upp_Beak_up_2;
	public ResettableModelRenderer Beak_point_1;
	public ResettableModelRenderer Beak_point_2;
	public ResettableModelRenderer Cheek_left;
	public ResettableModelRenderer Cheek_right;
	public ResettableModelRenderer Ulna_right;
	public ResettableModelRenderer feather_long_3;
	public ResettableModelRenderer feather_long_4;
	public ResettableModelRenderer feather_long_5;
	public ResettableModelRenderer feather_long_6;
	public ResettableModelRenderer carpus_right;
	public ResettableModelRenderer feather_long_7;
	public ResettableModelRenderer feather_long_8;
	public ResettableModelRenderer feather_long_9;
	public ResettableModelRenderer feather_long_10;
	public ResettableModelRenderer feather_long_11;
	public ResettableModelRenderer feather_long_12;
	public ResettableModelRenderer feather_long_13;
	public ResettableModelRenderer feather_long_14;
	public ResettableModelRenderer feather_long_15;
	public ResettableModelRenderer Ulna_right_1;
	public ResettableModelRenderer feather_long_16;
	public ResettableModelRenderer feather_long_17;
	public ResettableModelRenderer feather_long_18;
	public ResettableModelRenderer feather_long_19;
	public ResettableModelRenderer carpus_left;
	public ResettableModelRenderer feather_long_20;
	public ResettableModelRenderer feather_long_21;
	public ResettableModelRenderer feather_long_22;
	public ResettableModelRenderer feather_long_23;
	public ResettableModelRenderer feather_long_24;
	public ResettableModelRenderer feather_long_25;
	public ResettableModelRenderer feather_long_26;
	public ResettableModelRenderer feather_long_27;
	public ResettableModelRenderer feather_long_28;
	public ResettableModelRenderer thigh_right;
	public ResettableModelRenderer tarsometatarsus_right;
	public ResettableModelRenderer foot_right;
	public ResettableModelRenderer thigh_left;
	public ResettableModelRenderer tarsometatarsus_left;
	public ResettableModelRenderer foot_left;
	private Animator animator;

	public ModelKelenken()
	{
		this.textureWidth = 200;
		this.textureHeight = 200;

		this.feather_long_4 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_4.setRotationPoint(-0.4F, 0.1F, 3.9F);
		this.feather_long_4.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_4.setRotateAngle(-1.5707963267948966F, 1.3658946726107624F, -0.045553093477052F);

		this.feather_1 = new ResettableModelRenderer(this, 0, 0);
		this.feather_1.setRotationPoint(0.0F, -4.0F, 2.8F);
		this.feather_1.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_1.setRotateAngle(0.5009094953223726F, 0.31869712141416456F, 0.36425021489121656F);

		this.Beak_point_2 = new ResettableModelRenderer(this, 0, 70);
		this.Beak_point_2.setRotationPoint(0.0F, -1.2F, -0.4F);
		this.Beak_point_2.addBox(-0.5F, -1.0F, -1.0F, 1, 1, 2, 0.0F);
		this.Beak_point_2.setRotateAngle(2.231054382824351F, 0.0F, 0.0F);

		this.feather_7 = new ResettableModelRenderer(this, 0, 0);
		this.feather_7.setRotationPoint(0.8F, 0.1F, 4.0F);
		this.feather_7.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_7.setRotateAngle(-1.2292353921796064F, 0.31869712141416456F, -0.27314402793711257F);

		this.feather_long_18 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_18.setRotationPoint(-0.7F, 0.0F, 3.0F);
		this.feather_long_18.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_18.setRotateAngle(-1.5707963267948966F, 1.5025539530419183F, -0.045553093477052F);

		this.humerus_left = new ResettableModelRenderer(this, 5, 36);
		this.humerus_left.setRotationPoint(3.5F, -1.5F, 2.0F);
		this.humerus_left.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
		this.humerus_left.setRotateAngle(-1.8212510744560826F, 0.0F, -0.4553564018453205F);

		this.feather_6 = new ResettableModelRenderer(this, 0, 0);
		this.feather_6.setRotationPoint(-0.4F, -4.0F, 2.4F);
		this.feather_6.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_6.setRotateAngle(0.8196066167365371F, 0.31869712141416456F, 0.5009094953223726F);

		this.Pygostyle = new ResettableModelRenderer(this, 107, 0);
		this.Pygostyle.setRotationPoint(0.0F, 1.7F, 1.9F);
		this.Pygostyle.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 5, 0.0F);
		this.Pygostyle.setRotateAngle(0.31869712141416456F, 0.0F, 0.0F);

		this.Hind_2 = new ResettableModelRenderer(this, 43, 17);
		this.Hind_2.setRotationPoint(0.0F, -0.4F, 2.7F);
		this.Hind_2.addBox(-3.0F, -4.0F, 0.0F, 6, 8, 3, 0.0F);
		this.Hind_2.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.femur_left = new ResettableModelRenderer(this, 51, 41);
		this.femur_left.setRotationPoint(2.0F, 3.3F, -1.5F);
		this.femur_left.addBox(0.0F, -3.5F, -2.5F, 4, 9, 6, 0.0F);
		this.femur_left.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.feather = new ResettableModelRenderer(this, 0, 0);
		this.feather.setRotationPoint(0.0F, -4.0F, 2.8F);
		this.feather.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather.setRotateAngle(0.5009094953223726F, 0.0F, 0.0F);

		this.Upp_Beak_low = new ResettableModelRenderer(this, 0, 101);
		this.Upp_Beak_low.setRotationPoint(0.0F, -3.3F, 0.8F);
		this.Upp_Beak_low.addBox(-1.5F, -9.0F, -0.5F, 3, 9, 1, 0.0F);
		this.Upp_Beak_low.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.feather_long_19 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_19.setRotationPoint(-0.7F, 0.0F, 2.1F);
		this.feather_long_19.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_19.setRotateAngle(-1.5707963267948966F, 1.593485607070823F, -0.045553093477052F);

		this.Tail_Feather_1 = new ResettableModelRenderer(this, 9, 21);
		this.Tail_Feather_1.setRotationPoint(0.0F, -1.4F, 3.5F);
		this.Tail_Feather_1.addBox(-2.0F, 0.0F, 0.0F, 4, 0, 13, 0.0F);
		this.Tail_Feather_1.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.Cheek_left = new ResettableModelRenderer(this, 10, 64);
		this.Cheek_left.setRotationPoint(0.8F, -1.7F, 0.0F);
		this.Cheek_left.addBox(0.0F, -1.5F, 0.0F, 0, 3, 3, 0.0F);
		this.Cheek_left.setRotateAngle(-0.22759093446006054F, 0.0F, 0.0F);

		this.tarsometatarsus_right = new ResettableModelRenderer(this, 51, 72);
		this.tarsometatarsus_right.setRotationPoint(0.0F, 8.0F, 0.9F);
		this.tarsometatarsus_right.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.tarsometatarsus_right.setRotateAngle(-0.6373942428283291F, 0.0F, 0.0F);

		this.feather_long_5 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_5.setRotationPoint(-0.7F, 0.0F, 3.0F);
		this.feather_long_5.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_5.setRotateAngle(-1.5707963267948966F, 1.5025539530419183F, -0.045553093477052F);

		this.Upp_Beak_up_2 = new ResettableModelRenderer(this, 0, 79);
		this.Upp_Beak_up_2.setRotationPoint(0.0F, -5.7F, 0.0F);
		this.Upp_Beak_up_2.addBox(-1.0F, -4.0F, -1.0F, 2, 4, 2, 0.0F);
		this.Upp_Beak_up_2.setRotateAngle(0.091106186954104F, 0.0F, 0.0F);

		this.feather_long_25 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_25.setRotationPoint(0.0F, 0.1F, 3.5F);
		this.feather_long_25.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_25.setRotateAngle(1.3203415791337103F, 0.0F, 0.0F);

		this.foot_right = new ResettableModelRenderer(this, 51, 87);
		this.foot_right.setRotationPoint(0.0F, 9.3F, 0.0F);
		this.foot_right.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 5, 0.0F);
		this.foot_right.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.foot_left = new ResettableModelRenderer(this, 51, 87);
		this.foot_left.setRotationPoint(0.0F, 9.3F, 0.0F);
		this.foot_left.addBox(-1.5F, 0.0F, -4.0F, 3, 1, 5, 0.0F);
		this.foot_left.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.neck_1 = new ResettableModelRenderer(this, 0, 143);
		this.neck_1.setRotationPoint(0.0F, -1.4F, 3.3F);
		this.neck_1.addBox(-1.5F, -2.5F, 0.0F, 3, 4, 7, 0.0F);
		this.neck_1.setRotateAngle(-0.5009094953223726F, 0.0F, 0.0F);

		this.feather_long_6 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_6.setRotationPoint(-0.7F, 0.0F, 2.1F);
		this.feather_long_6.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_6.setRotateAngle(-1.5707963267948966F, 1.593485607070823F, -0.045553093477052F);

		this.feather_long_13 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_13.setRotationPoint(0.0F, 0.1F, 2.6F);
		this.feather_long_13.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_13.setRotateAngle(1.4570008595648662F, 0.0F, 0.0F);

		this.feather_long_26 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_26.setRotationPoint(0.0F, 0.1F, 2.6F);
		this.feather_long_26.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_26.setRotateAngle(1.4570008595648662F, 0.0F, 0.0F);

		this.Nasal_left = new ResettableModelRenderer(this, 13, 81);
		this.Nasal_left.setRotationPoint(0.8F, 0.0F, 1.6F);
		this.Nasal_left.addBox(-0.5F, -9.0F, -1.2F, 1, 9, 2, 0.0F);
		this.Nasal_left.setRotateAngle(0.091106186954104F, 0.0F, 0.0F);

		this.Windpipe = new ResettableModelRenderer(this, 28, 129);
		this.Windpipe.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.Windpipe.addBox(-1.0F, -2.5F, 0.0F, 2, 2, 5, 0.0F);
		this.Windpipe.setRotateAngle(0.40980330836826856F, 0.0F, 0.0F);

		this.Cheek_right = new ResettableModelRenderer(this, 10, 64);
		this.Cheek_right.setRotationPoint(-0.8F, -1.7F, 0.0F);
		this.Cheek_right.addBox(0.0F, -1.5F, 0.0F, 0, 3, 3, 0.0F);
		this.Cheek_right.setRotateAngle(-0.22759093446006054F, 0.0F, 0.0F);

		this.body = new ResettableModelRenderer(this, 0, 180);
		this.body.setRotationPoint(0.0F, 3.1F, -6.0F);
		this.body.addBox(-4.5F, -5.0F, -4.5F, 9, 10, 9, 0.0F);
		this.body.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.feather_long_15 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_15.setRotationPoint(0.0F, 0.1F, 0.5F);
		this.feather_long_15.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_15.setRotateAngle(1.6390387005478748F, 0.0F, 0.0F);

		this.feather_2 = new ResettableModelRenderer(this, 0, 0);
		this.feather_2.setRotationPoint(0.0F, -4.0F, 2.8F);
		this.feather_2.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_2.setRotateAngle(0.5009094953223726F, -0.31869712141416456F, -0.36425021489121656F);

		this.feather_long_11 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_11.setRotationPoint(0.0F, 0.2F, 1.2F);
		this.feather_long_11.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_11.setRotateAngle(2.1399481958702475F, 0.008726646259971648F, 0.11100294042683936F);

		this.feather_long_3 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_3.setRotationPoint(-0.2F, 0.1F, 4.7F);
		this.feather_long_3.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_3.setRotateAngle(-1.5707963267948966F, 1.1838568316277536F, -0.045553093477052F);

		this.tarsometatarsus_left = new ResettableModelRenderer(this, 51, 72);
		this.tarsometatarsus_left.setRotationPoint(0.0F, 8.0F, 0.9F);
		this.tarsometatarsus_left.addBox(-1.0F, 0.0F, -1.0F, 2, 10, 2, 0.0F);
		this.tarsometatarsus_left.setRotateAngle(-0.6373942428283291F, 0.0F, 0.0F);

		this.Shoulder = new ResettableModelRenderer(this, 0, 160);
		this.Shoulder.setRotationPoint(0.0F, 0.9F, -5.7F);
		this.Shoulder.addBox(-3.5F, -3.5F, -0.9F, 7, 7, 6, 0.0F);
		this.Shoulder.setRotateAngle(1.9123572614101867F, 0.0F, 0.0F);

		this.head = new ResettableModelRenderer(this, 0, 113);
		this.head.setRotationPoint(0.0F, -0.6F, -1.2F);
		this.head.addBox(-2.0F, -4.4F, -0.8F, 4, 7, 5, 0.0F);
		this.head.setRotateAngle(0.22759093446006054F, 0.0F, 0.0F);

		this.feather_long_22 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_22.setRotationPoint(0.0F, 0.1F, 3.3F);
		this.feather_long_22.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_22.setRotateAngle(2.0032889154390916F, 0.008726646259971648F, 0.11100294042683936F);

		this.feather_long_2 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_2.setRotationPoint(0.0F, 1.9F, 4.0F);
		this.feather_long_2.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_2.setRotateAngle(-1.6390387005478748F, 0.0F, 0.0F);

		this.feather_long_10 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_10.setRotationPoint(0.0F, 0.1F, 2.3F);
		this.feather_long_10.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_10.setRotateAngle(2.0488420089161434F, 0.008726646259971648F, 0.11100294042683936F);

		this.feather_long_8 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_8.setRotationPoint(0.0F, 0.1F, 4.2F);
		this.feather_long_8.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_8.setRotateAngle(1.8668041679331349F, 0.0F, 0.10559241974565695F);

		this.thigh_left = new ResettableModelRenderer(this, 51, 58);
		this.thigh_left.mirror = true;
		this.thigh_left.setRotationPoint(1.7F, 3.2F, 0.0F);
		this.thigh_left.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.thigh_left.setRotateAngle(0.4553564018453205F, 0.0F, 0.0F);

		this.feather_long_24 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_24.setRotationPoint(0.0F, 0.2F, 1.2F);
		this.feather_long_24.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_24.setRotateAngle(2.1399481958702475F, 0.008726646259971648F, 0.11100294042683936F);

		this.Ulna_right = new ResettableModelRenderer(this, 3, 46);
		this.Ulna_right.mirror = true;
		this.Ulna_right.setRotationPoint(-0.5F, 0.3F, 5.5F);
		this.Ulna_right.addBox(-0.5F, -0.5F, 0.0F, 1, 2, 6, 0.0F);
		this.Ulna_right.setRotateAngle(-2.6406831582674206F, 0.36425021489121656F, 0.0F);

		this.Lower_Jaw = new ResettableModelRenderer(this, 0, 58);
		this.Lower_Jaw.setRotationPoint(0.0F, -3.3F, 0.0F);
		this.Lower_Jaw.addBox(-1.0F, -9.0F, -0.5F, 2, 9, 1, 0.0F);
		this.Lower_Jaw.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.feather_4 = new ResettableModelRenderer(this, 0, 0);
		this.feather_4.setRotationPoint(0.0F, -4.0F, 2.8F);
		this.feather_4.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_4.setRotateAngle(0.9560913642424937F, 0.0F, 0.0F);

		this.Tail_Feather_left = new ResettableModelRenderer(this, 5, 19);
		this.Tail_Feather_left.setRotationPoint(1.8F, 0.0F, 4.0F);
		this.Tail_Feather_left.addBox(0.0F, 0.0F, -4.0F, 2, 0, 12, 0.0F);
		this.Tail_Feather_left.setRotateAngle(0.0F, 0.27314402793711257F, 0.5009094953223726F);

		this.feather_long_1 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_1.setRotationPoint(0.0F, 1.0F, 4.0F);
		this.feather_long_1.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_1.setRotateAngle(-1.3658946726107624F, 0.0F, 0.0F);

		this.feather_long_28 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_28.setRotationPoint(0.0F, 0.1F, 0.5F);
		this.feather_long_28.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_28.setRotateAngle(1.6390387005478748F, 0.0F, 0.0F);

		this.neck_2 = new ResettableModelRenderer(this, 0, 129);
		this.neck_2.setRotationPoint(0.0F, 0.1F, 6.0F);
		this.neck_2.addBox(-1.5F, -2.5F, 0.0F, 3, 4, 5, 0.0F);
		this.neck_2.setRotateAngle(0.18203784098300857F, 0.0F, 0.0F);

		this.feather_long_7 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_7.setRotationPoint(0.0F, -0.1F, 5.0F);
		this.feather_long_7.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_7.setRotateAngle(1.7756979809790308F, 0.0F, 0.0471238898038469F);

		this.feather_long_27 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_27.setRotationPoint(0.0F, 0.1F, 1.4F);
		this.feather_long_27.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_27.setRotateAngle(1.5025539530419183F, 0.0F, 0.0F);

		this.Hind_4 = new ResettableModelRenderer(this, 85, 0);
		this.Hind_4.setRotationPoint(0.0F, -0.9F, 1.8F);
		this.Hind_4.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 5, 0.0F);
		this.Hind_4.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.feather_8 = new ResettableModelRenderer(this, 0, 0);
		this.feather_8.setRotationPoint(-0.8F, 0.1F, 4.0F);
		this.feather_8.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_8.setRotateAngle(-1.2292353921796064F, -0.31869712141416456F, 0.27314402793711257F);

		this.feather_long_12 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_12.setRotationPoint(0.0F, 0.1F, 3.5F);
		this.feather_long_12.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_12.setRotateAngle(1.3203415791337103F, 0.0F, 0.0F);

		this.Hind_3 = new ResettableModelRenderer(this, 69, 7);
		this.Hind_3.setRotationPoint(0.0F, -0.9F, 2.7F);
		this.Hind_3.addBox(-2.5F, -3.0F, 0.0F, 5, 6, 3, 0.0F);
		this.Hind_3.setRotateAngle(-0.091106186954104F, 0.0F, 0.0F);

		this.feather_long_9 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_9.setRotationPoint(0.0F, 0.1F, 3.3F);
		this.feather_long_9.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_9.setRotateAngle(2.0032889154390916F, 0.008726646259971648F, 0.11100294042683936F);

		this.Upp_Beak_up_1 = new ResettableModelRenderer(this, 0, 88);
		this.Upp_Beak_up_1.setRotationPoint(0.0F, 0.3F, 2.1F);
		this.Upp_Beak_up_1.addBox(-1.0F, -6.0F, -2.0F, 2, 7, 3, 0.0F);
		this.Upp_Beak_up_1.setRotateAngle(0.091106186954104F, 0.0F, 0.0F);

		this.feather_long_14 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_14.setRotationPoint(0.0F, 0.1F, 1.5F);
		this.feather_long_14.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_14.setRotateAngle(1.5025539530419183F, 0.0F, 0.0F);

		this.carpus_right = new ResettableModelRenderer(this, 9, 58);
		this.carpus_right.setRotationPoint(0.0F, -0.1F, 5.5F);
		this.carpus_right.addBox(-0.4F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
		this.carpus_right.setRotateAngle(1.593485607070823F, -0.091106186954104F, -0.091106186954104F);

		this.feather_long_21 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_21.setRotationPoint(0.0F, 0.1F, 4.2F);
		this.feather_long_21.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_21.setRotateAngle(1.8668041679331349F, 0.0F, 0.10559241974565695F);

		this.Butt_2 = new ResettableModelRenderer(this, 84, 13);
		this.Butt_2.setRotationPoint(0.0F, 1.7F, 1.9F);
		this.Butt_2.addBox(-1.5F, -2.0F, 0.0F, 3, 4, 5, 0.0F);
		this.Butt_2.setRotateAngle(0.40980330836826856F, 0.0F, 0.0F);

		this.Chest = new ResettableModelRenderer(this, 31, 161);
		this.Chest.setRotationPoint(0.0F, 2.1F, 1.6F);
		this.Chest.addBox(-3.0F, -2.5F, -5.5F, 6, 5, 6, 0.0F);
		this.Chest.setRotateAngle(-0.7740535232594852F, 0.0F, 0.0F);

		this.feather_10 = new ResettableModelRenderer(this, 0, 0);
		this.feather_10.setRotationPoint(0.5F, 1.0F, 4.0F);
		this.feather_10.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_10.setRotateAngle(-1.3658946726107624F, 0.36425021489121656F, -0.36425021489121656F);

		this.feather_long_20 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_20.setRotationPoint(0.0F, -0.1F, 5.0F);
		this.feather_long_20.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_20.setRotateAngle(1.7756979809790308F, 0.0F, 0.0471238898038469F);

		this.butt_1 = new ResettableModelRenderer(this, 62, 18);
		this.butt_1.setRotationPoint(0.0F, 1.0F, 1.5F);
		this.butt_1.addBox(-1.9F, -3.0F, 0.0F, 4, 6, 4, 0.0F);
		this.butt_1.setRotateAngle(0.40980330836826856F, 0.0F, 0.0F);

		this.feather_long_16 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_16.setRotationPoint(-0.2F, 0.1F, 4.7F);
		this.feather_long_16.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_16.setRotateAngle(-1.5707963267948966F, 1.1838568316277536F, -0.045553093477052F);

		this.Hind_1 = new ResettableModelRenderer(this, 43, 0);
		this.Hind_1.setRotationPoint(0.0F, -0.6F, 3.0F);
		this.Hind_1.addBox(-4.0F, -4.5F, 0.0F, 8, 9, 4, 0.0F);
		this.Hind_1.setRotateAngle(-0.22759093446006054F, 0.0F, 0.0F);

		this.feather_5 = new ResettableModelRenderer(this, 0, 0);
		this.feather_5.setRotationPoint(0.4F, -4.0F, 2.4F);
		this.feather_5.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_5.setRotateAngle(0.8196066167365371F, -0.31869712141416456F, -0.5009094953223726F);

		this.carpus_left = new ResettableModelRenderer(this, 9, 58);
		this.carpus_left.setRotationPoint(0.0F, -0.1F, 5.5F);
		this.carpus_left.addBox(-0.4F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
		this.carpus_left.setRotateAngle(1.593485607070823F, 0.091106186954104F, 0.091106186954104F);

		this.Humerus_right = new ResettableModelRenderer(this, 5, 36);
		this.Humerus_right.setRotationPoint(-3.1F, -1.5F, 2.0F);
		this.Humerus_right.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 6, 0.0F);
		this.Humerus_right.setRotateAngle(-1.8212510744560826F, 0.0F, 0.4553564018453205F);

		this.Nasal_right = new ResettableModelRenderer(this, 13, 81);
		this.Nasal_right.setRotationPoint(-0.8F, 0.0F, 1.6F);
		this.Nasal_right.addBox(-0.5F, -9.0F, -1.2F, 1, 9, 2, 0.0F);
		this.Nasal_right.setRotateAngle(0.091106186954104F, 0.0F, 0.0F);

		this.feather_long_23 = new ResettableModelRenderer(this, 0, 12);
		this.feather_long_23.setRotationPoint(0.0F, 0.1F, 2.3F);
		this.feather_long_23.addBox(0.0F, -0.5F, 0.0F, 0, 1, 4, 0.0F);
		this.feather_long_23.setRotateAngle(2.0488420089161434F, 0.008726646259971648F, 0.11100294042683936F);

		this.feather_long = new ResettableModelRenderer(this, 0, 6);
		this.feather_long.setRotationPoint(0.0F, 0.1F, 4.0F);
		this.feather_long.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long.setRotateAngle(-1.2292353921796064F, 0.0F, 0.0F);

		this.feather_3 = new ResettableModelRenderer(this, 0, 0);
		this.feather_3.setRotationPoint(0.0F, -4.0F, 2.8F);
		this.feather_3.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_3.setRotateAngle(0.6829473363053812F, 0.0F, 0.0F);

		this.Ulna_right_1 = new ResettableModelRenderer(this, 3, 46);
		this.Ulna_right_1.setRotationPoint(0.0F, 0.3F, 5.5F);
		this.Ulna_right_1.addBox(-0.5F, -0.5F, 0.0F, 1, 2, 6, 0.0F);
		this.Ulna_right_1.setRotateAngle(-2.6406831582674206F, -0.36425021489121656F, 0.0F);

		this.femur_right = new ResettableModelRenderer(this, 51, 41);
		this.femur_right.setRotationPoint(-2.0F, 3.3F, -1.5F);
		this.femur_right.addBox(-4.0F, -3.5F, -2.5F, 4, 9, 6, 0.0F);
		this.femur_right.setRotateAngle(-0.045553093477052F, 0.0F, 0.0F);

		this.thigh_right = new ResettableModelRenderer(this, 51, 58);
		this.thigh_right.mirror = true;
		this.thigh_right.setRotationPoint(-1.7F, 3.2F, 0.0F);
		this.thigh_right.addBox(-1.5F, 0.0F, -1.5F, 3, 9, 3, 0.0F);
		this.thigh_right.setRotateAngle(0.4553564018453205F, 0.0F, 0.0F);

		this.feather_9 = new ResettableModelRenderer(this, 0, 0);
		this.feather_9.setRotationPoint(-0.5F, 1.0F, 4.0F);
		this.feather_9.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 3, 0.0F);
		this.feather_9.setRotateAngle(-1.3658946726107624F, -0.36425021489121656F, 0.36425021489121656F);

		this.feather_long_17 = new ResettableModelRenderer(this, 0, 6);
		this.feather_long_17.setRotationPoint(-0.4F, 0.1F, 3.9F);
		this.feather_long_17.addBox(-0.5F, 0.0F, 0.0F, 1, 0, 4, 0.0F);
		this.feather_long_17.setRotateAngle(-1.5707963267948966F, 1.3658946726107624F, -0.045553093477052F);

		this.Tail_Feather_right = new ResettableModelRenderer(this, 20, 18);
		this.Tail_Feather_right.setRotationPoint(-1.8F, 0.0F, 4.0F);
		this.Tail_Feather_right.addBox(-2.0F, 0.0F, -4.0F, 2, 0, 12, 0.0F);
		this.Tail_Feather_right.setRotateAngle(0.0F, -0.27314402793711257F, -0.5009094953223726F);

		this.Head_Joint = new ResettableModelRenderer(this, 22, 0);
		this.Head_Joint.setRotationPoint(0.0F, -0.4F, 4.5F);
		this.Head_Joint.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
		this.Head_Joint.setRotateAngle(0.0F, 0.0F, 0.0F);

		this.Beak_point_1 = new ResettableModelRenderer(this, 1, 74);
		this.Beak_point_1.setRotationPoint(0.0F, -2.8F, -0.8F);
		this.Beak_point_1.addBox(-0.5F, -2.0F, -1.0F, 1, 2, 2, 0.0F);
		this.Beak_point_1.setRotateAngle(-0.5009094953223726F, 0.0F, 0.0F);

		this.Humerus_right.addChild(this.feather_long_4);
		this.head.addChild(this.feather_1);
		this.Beak_point_1.addChild(this.Beak_point_2);
		this.head.addChild(this.feather_7);
		this.humerus_left.addChild(this.feather_long_18);
		this.Shoulder.addChild(this.humerus_left);
		this.head.addChild(this.feather_6);
		this.Hind_4.addChild(this.Pygostyle);
		this.Hind_1.addChild(this.Hind_2);
		this.head.addChild(this.feather);
		this.head.addChild(this.Upp_Beak_low);
		this.humerus_left.addChild(this.feather_long_19);
		this.Hind_4.addChild(this.Tail_Feather_1);
		this.Lower_Jaw.addChild(this.Cheek_left);
		this.thigh_right.addChild(this.tarsometatarsus_right);
		this.Humerus_right.addChild(this.feather_long_5);
		this.Upp_Beak_up_1.addChild(this.Upp_Beak_up_2);
		this.carpus_left.addChild(this.feather_long_25);
		this.tarsometatarsus_right.addChild(this.foot_right);
		this.tarsometatarsus_left.addChild(this.foot_left);
		this.Shoulder.addChild(this.neck_1);
		this.Humerus_right.addChild(this.feather_long_6);
		this.carpus_right.addChild(this.feather_long_13);
		this.carpus_left.addChild(this.feather_long_26);
		this.Upp_Beak_low.addChild(this.Nasal_left);
		this.neck_2.addChild(this.Windpipe);
		this.Lower_Jaw.addChild(this.Cheek_right);
		this.carpus_right.addChild(this.feather_long_15);
		this.head.addChild(this.feather_2);
		this.Ulna_right.addChild(this.feather_long_11);
		this.Humerus_right.addChild(this.feather_long_3);
		this.thigh_left.addChild(this.tarsometatarsus_left);
		this.body.addChild(this.Shoulder);
		this.Head_Joint.addChild(this.head);
		this.Ulna_right_1.addChild(this.feather_long_22);
		this.head.addChild(this.feather_long_2);
		this.Ulna_right.addChild(this.feather_long_10);
		this.Ulna_right.addChild(this.feather_long_8);
		this.femur_left.addChild(this.thigh_left);
		this.Ulna_right_1.addChild(this.feather_long_24);
		this.Humerus_right.addChild(this.Ulna_right);
		this.head.addChild(this.Lower_Jaw);
		this.head.addChild(this.feather_4);
		this.Tail_Feather_1.addChild(this.Tail_Feather_left);
		this.head.addChild(this.feather_long_1);
		this.carpus_left.addChild(this.feather_long_28);
		this.neck_1.addChild(this.neck_2);
		this.Ulna_right.addChild(this.feather_long_7);
		this.carpus_left.addChild(this.feather_long_27);
		this.Hind_3.addChild(this.Hind_4);
		this.head.addChild(this.feather_8);
		this.carpus_right.addChild(this.feather_long_12);
		this.Hind_2.addChild(this.Hind_3);
		this.Ulna_right.addChild(this.feather_long_9);
		this.Upp_Beak_low.addChild(this.Upp_Beak_up_1);
		this.carpus_right.addChild(this.feather_long_14);
		this.Ulna_right.addChild(this.carpus_right);
		this.Ulna_right_1.addChild(this.feather_long_21);
		this.Hind_3.addChild(this.Butt_2);
		this.Shoulder.addChild(this.Chest);
		this.head.addChild(this.feather_10);
		this.Ulna_right_1.addChild(this.feather_long_20);
		this.Hind_2.addChild(this.butt_1);
		this.humerus_left.addChild(this.feather_long_16);
		this.body.addChild(this.Hind_1);
		this.head.addChild(this.feather_5);
		this.Ulna_right_1.addChild(this.carpus_left);
		this.Shoulder.addChild(this.Humerus_right);
		this.Upp_Beak_low.addChild(this.Nasal_right);
		this.Ulna_right_1.addChild(this.feather_long_23);
		this.head.addChild(this.feather_long);
		this.head.addChild(this.feather_3);
		this.humerus_left.addChild(this.Ulna_right_1);
		this.femur_right.addChild(this.thigh_right);
		this.head.addChild(this.feather_9);
		this.humerus_left.addChild(this.feather_long_17);
		this.Tail_Feather_1.addChild(this.Tail_Feather_right);
		this.neck_2.addChild(this.Head_Joint);
		this.Upp_Beak_up_2.addChild(this.Beak_point_1);

		this.animator = new Animator();
	}

	@Override
	public void render(Entity entity, float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale)
	{
		EntityKelenken animal = (EntityKelenken) entity;
		this.setRotationAngles(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);
		this.animateModel(walkedDistance, walkSpeed, time, yaw, pitch, scale, animal);

		this.body.render(scale);
		this.femur_left.render(scale);
		this.femur_right.render(scale);
	}

	@Override
	public void setLivingAnimations(EntityLivingBase entity, float yaw, float pitch, float partialRenderTicks)
	{
		this.resetPose();
		EntityKelenken animal = (EntityKelenken) entity;
		float sittingProgress = animal.getSittingProgress(partialRenderTicks);

		if (sittingProgress > 0.001F)
		{
			this.body.rotationPointY += 10.5F * sittingProgress;

			this.femur_right.rotateAngleX -= 1.0F * sittingProgress;
			this.femur_right.rotationPointY += 10.5F * sittingProgress;
			this.femur_right.rotationPointZ -= 1.0F * sittingProgress;
			this.thigh_right.rotateAngleX += 1.5F * sittingProgress;
			this.thigh_right.rotationPointZ += 2.0F * sittingProgress;
			this.tarsometatarsus_right.rotateAngleX -= 1.85F * sittingProgress;
			this.tarsometatarsus_right.rotationPointY += 1.0F * sittingProgress;
			this.tarsometatarsus_right.rotationPointZ -= 1.0F * sittingProgress;
			this.foot_right.rotateAngleX += 1.35F * sittingProgress;

			this.femur_left.rotateAngleX -= 1.0F * sittingProgress;
			this.femur_left.rotationPointY += 10.5F * sittingProgress;
			this.femur_left.rotationPointZ -= 1.0F * sittingProgress;
			this.thigh_left.rotateAngleX += 1.5F * sittingProgress;
			this.thigh_left.rotationPointZ += 2.0F * sittingProgress;
			this.tarsometatarsus_left.rotateAngleX -= 1.85F * sittingProgress;
			this.tarsometatarsus_left.rotationPointY += 1.0F * sittingProgress;
			this.tarsometatarsus_left.rotationPointZ -= 1.0F * sittingProgress;
			this.foot_left.rotateAngleX += 1.35F * sittingProgress;
		}
	}

	private void setRotationAngles(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityKelenken animal)
	{
		float animSpeed = 0.375F;

		float headX = this.getHeadAngle(pitch);
		this.neck_1.rotateAngleX += 0.15F * headX;
		this.neck_2.rotateAngleX += 0.15F * headX;
		this.head.rotateAngleX += 0.3F * headX;

		float headY = this.getHeadAngle(yaw);
		this.neck_1.rotateAngleZ -= 0.3F * headY;
		this.neck_2.rotateAngleZ -= 0.3F * headY;
		this.head.rotateAngleZ -= 0.3F * headY;

		if (animal.isSitting())
		{
			float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
			this.body.rotateAngleX += naturalMovement;
			this.neck_1.rotateAngleX -= naturalMovement;
			this.neck_2.rotateAngleX -= naturalMovement;
			this.butt_1.rotateAngleX += naturalMovement;
		}
		else
		{
			if (walkSpeed > 0.001F)
			{
				float bodyBob1 = this.getRotateAngleComplex(time, walkSpeed, animSpeed, 0.5F, 0.5F);
				float bodyBob2 = this.getRotateAngleComplex(2.0F * time, walkSpeed, animSpeed, 0.5F, 0.5F);
				this.body.rotationPointX += bodyBob1;
				this.body.rotationPointY -= bodyBob2;
				this.femur_right.rotationPointX += bodyBob1;
				this.femur_right.rotationPointY -= bodyBob2;
				this.femur_left.rotationPointX += bodyBob1;
				this.femur_left.rotationPointY -= bodyBob2;

				float lleg1 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, 3.0F, -0.4F);
				float lleg2 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.4F, 1.5F, 1.0F);
				float lleg3 = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.6F, -1.5F, -0.2F);
				float lfoot = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, -1.5F, 0.4F);

				float rleg1 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.8F, 3.0F, -0.4F);
				float rleg2 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.4F, 1.5F, 1.0F);
				float rleg3 = this.getRotateAngleComplexInclinatedInverted(time, walkSpeed, animSpeed, 0.6F, -1.5F, -0.2F);
				float rfoot = this.getRotateAngleComplexInclinated(time, walkSpeed, animSpeed, 0.8F, -1.5F, 0.4F);

				this.femur_left.rotateAngleX += lleg1;
				this.thigh_left.rotateAngleX += lleg2;
				this.tarsometatarsus_left.rotateAngleX += lleg3;
				this.foot_left.rotateAngleX += lfoot;

				this.femur_right.rotateAngleX += rleg1;
				this.thigh_right.rotateAngleX += rleg2;
				this.tarsometatarsus_right.rotateAngleX += rleg3;
				this.foot_right.rotateAngleX += rfoot;

				this.humerus_left.rotateAngleX += 0.25F * rleg1;
				this.Humerus_right.rotateAngleX += 0.25F * lleg1;
			}
			else
			{
				float naturalMovement = this.getAlwaysRotateAngle(time, 0.2F * animSpeed, 0.03125F);
				float naturalMovement_2 = 2.0F * naturalMovement;

				this.body.rotateAngleX += naturalMovement;
				this.neck_1.rotateAngleX -= naturalMovement;
				this.neck_2.rotateAngleX -= naturalMovement;
				this.butt_1.rotateAngleX += naturalMovement;

				this.Humerus_right.rotateAngleX += naturalMovement_2;
				this.Ulna_right.rotateAngleX += naturalMovement;
				this.carpus_right.rotateAngleX -= naturalMovement_2;

				this.carpus_left.rotateAngleX -= naturalMovement_2;
				this.Ulna_right_1.rotateAngleX += naturalMovement;
				this.humerus_left.rotateAngleX += naturalMovement_2;
			}
		}
	}

	public void animateModel(float walkedDistance, float walkSpeed, float time, float yaw, float pitch, float scale, EntityKelenken animal)
	{
		if (animal.getAnimID() == DeAnimationList.SOUND_1)
		{
			if (!animal.hasItemInSlot(EntityEquipmentSlot.MAINHAND))
			{
				this.animator.update(animal);
				this.animator.setAnim(DeAnimationList.SOUND_1);

				this.animator.startPhase(5);
				this.animator.rotate(this.Lower_Jaw, ResettableModelBase.RAD_30_DEGREES, 0.0F, 0.0F);

				this.animator.endPhase();
				this.animator.resetPhase(10);
			}
		}
	}

	private void resetPose()
	{
		this.body.resetParameters();
		this.femur_right.resetParameters();
		this.femur_left.resetParameters();
		this.Hind_1.resetParameters();
		this.Shoulder.resetParameters();
		this.Hind_2.resetParameters();
		this.Hind_3.resetParameters();
		this.butt_1.resetParameters();
		this.Hind_4.resetParameters();
		this.Butt_2.resetParameters();
		this.Tail_Feather_1.resetParameters();
		this.Pygostyle.resetParameters();
		this.Tail_Feather_left.resetParameters();
		this.Tail_Feather_right.resetParameters();
		this.Chest.resetParameters();
		this.neck_1.resetParameters();
		this.Humerus_right.resetParameters();
		this.humerus_left.resetParameters();
		this.neck_2.resetParameters();
		this.Head_Joint.resetParameters();
		this.Windpipe.resetParameters();
		this.head.resetParameters();
		this.Upp_Beak_low.resetParameters();
		this.Lower_Jaw.resetParameters();
		this.Upp_Beak_up_1.resetParameters();
		this.Nasal_right.resetParameters();
		this.Nasal_left.resetParameters();
		this.Upp_Beak_up_2.resetParameters();
		this.Beak_point_1.resetParameters();
		this.Beak_point_2.resetParameters();
		this.Cheek_left.resetParameters();
		this.Cheek_right.resetParameters();
		this.Ulna_right.resetParameters();
		this.carpus_right.resetParameters();
		this.Ulna_right_1.resetParameters();
		this.carpus_left.resetParameters();
		this.thigh_right.resetParameters();
		this.tarsometatarsus_right.resetParameters();
		this.foot_right.resetParameters();
		this.thigh_left.resetParameters();
		this.tarsometatarsus_left.resetParameters();
		this.foot_left.resetParameters();
	}
}
