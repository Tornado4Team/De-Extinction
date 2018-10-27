package  com.deextinction.deextinction.entity.model.defectum;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelRabbit - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelJohn extends ModelBase {
    public ModelRenderer field_178704_h;
    public ModelRenderer field_178702_j;
    public ModelRenderer field_178700_l;
    public ModelRenderer field_178705_i;
    public ModelRenderer field_178703_k;
    public ModelRenderer field_178698_a;
    public ModelRenderer field_178697_c;
    public ModelRenderer field_178695_e;
    public ModelRenderer field_178693_g;
    public ModelRenderer field_178696_b;
    public ModelRenderer field_178694_d;
    public ModelRenderer field_178692_f;

    public ModelJohn() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.field_178702_j = new ModelRenderer(this, 58, 0);
        this.field_178702_j.setRotationPoint(0.0F, 16.0F, -1.0F);
        this.field_178702_j.addBox(0.5F, -7.6F, -1.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(field_178702_j, 0.0F, 0.2617993877991494F, 0.0F);
        this.field_178694_d = new ModelRenderer(this, 16, 15);
        this.field_178694_d.setRotationPoint(-3.0F, 17.5F, 3.700000047683716F);
        this.field_178694_d.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 5, 0.0F);
        this.setRotateAngle(field_178694_d, -0.36651915311813354F, 0.0F, 0.0F);
        this.field_178704_h = new ModelRenderer(this, 32, 0);
        this.field_178704_h.setRotationPoint(0.0F, 16.0F, -1.0F);
        this.field_178704_h.addBox(-2.5F, -4.0F, -5.0F, 5, 4, 5, 0.0F);
        this.field_178703_k = new ModelRenderer(this, 52, 6);
        this.field_178703_k.setRotationPoint(0.0F, 20.0F, 7.0F);
        this.field_178703_k.addBox(-1.5F, -1.5F, 0.0F, 3, 3, 2, 0.0F);
        this.setRotateAngle(field_178703_k, -0.349065899848938F, 0.0F, 0.0F);
        this.field_178693_g = new ModelRenderer(this, 0, 15);
        this.field_178693_g.setRotationPoint(-3.0F, 17.0F, -1.0F);
        this.field_178693_g.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(field_178693_g, -0.19198621809482574F, 0.0F, 0.0F);
        this.field_178698_a = new ModelRenderer(this, 26, 24);
        this.field_178698_a.setRotationPoint(3.0F, 17.5F, 3.700000047683716F);
        this.field_178698_a.addBox(-1.0F, 5.5F, -3.700000047683716F, 2, 1, 7, 0.0F);
        this.field_178697_c = new ModelRenderer(this, 30, 15);
        this.field_178697_c.setRotationPoint(3.0F, 17.5F, 3.700000047683716F);
        this.field_178697_c.addBox(-1.0F, 0.0F, 0.0F, 2, 4, 5, 0.0F);
        this.setRotateAngle(field_178697_c, -0.36651915311813354F, 0.0F, 0.0F);
        this.field_178695_e = new ModelRenderer(this, 0, 0);
        this.field_178695_e.setRotationPoint(0.0F, 19.0F, 8.0F);
        this.field_178695_e.addBox(-3.0F, -2.0F, -10.0F, 6, 5, 10, 0.0F);
        this.setRotateAngle(field_178695_e, -0.34906584024429316F, 0.0F, 0.0F);
        this.field_178692_f = new ModelRenderer(this, 8, 15);
        this.field_178692_f.setRotationPoint(3.0F, 17.0F, -1.0F);
        this.field_178692_f.addBox(-1.0F, 0.0F, -1.0F, 2, 7, 2, 0.0F);
        this.setRotateAngle(field_178692_f, -0.19198621809482574F, 0.0F, 0.0F);
        this.field_178705_i = new ModelRenderer(this, 52, 0);
        this.field_178705_i.setRotationPoint(0.0F, 16.0F, -1.0F);
        this.field_178705_i.addBox(-2.5F, -9.0F, -1.0F, 2, 5, 1, 0.0F);
        this.setRotateAngle(field_178705_i, 0.0F, -0.2617993950843811F, 0.0F);
        this.field_178700_l = new ModelRenderer(this, 32, 9);
        this.field_178700_l.setRotationPoint(0.0F, 16.0F, -1.0F);
        this.field_178700_l.addBox(-0.5F, -2.5F, -5.5F, 1, 1, 1, 0.0F);
        this.field_178696_b = new ModelRenderer(this, 8, 24);
        this.field_178696_b.setRotationPoint(-3.0F, 17.5F, 3.700000047683716F);
        this.field_178696_b.addBox(-1.0F, 5.5F, -3.700000047683716F, 2, 1, 7, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.field_178702_j.render(f5);
        this.field_178694_d.render(f5);
        this.field_178704_h.render(f5);
        this.field_178703_k.render(f5);
        this.field_178693_g.render(f5);
        this.field_178698_a.render(f5);
        this.field_178697_c.render(f5);
        this.field_178695_e.render(f5);
        this.field_178692_f.render(f5);
        this.field_178705_i.render(f5);
        this.field_178700_l.render(f5);
        this.field_178696_b.render(f5);
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
