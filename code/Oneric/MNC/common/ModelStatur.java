// Date: 08.09.2012 14:27:21
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package Oneric.MNC.common;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;



public class ModelStatur extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer krone1;
    ModelRenderer stab;
    ModelRenderer krone2;
    ModelRenderer krone3;
    ModelRenderer krone4;
  
  public ModelStatur()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-4F, -8F, -4F, 8, 8, 8);
      head.setRotationPoint(0F, 0F, 0F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 12, 4);
      body.setRotationPoint(0F, 0F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 17);
      rightarm.addBox(-3F, -2F, -2F, 3, 12, 3);
      rightarm.setRotationPoint(-4F, 2F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, -1.412787F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 17);
      leftarm.addBox(-1F, -2F, -2F, 3, 12, 3);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      krone1 = new ModelRenderer(this, 33, 0);
      krone1.addBox(0F, 0F, 0F, 0, 3, 8);
      krone1.setRotationPoint(-4F, -10F, -4F);
      krone1.setTextureSize(64, 32);
      krone1.mirror = true;
      setRotation(krone1, 0F, 0F, 0F);
      stab = new ModelRenderer(this, 56, 7);
      stab.addBox(0F, 0F, 0F, 2, 23, 2);
      stab.setRotationPoint(-6F, -1F, -11F);
      stab.setTextureSize(64, 32);
      stab.mirror = true;
      setRotation(stab, 0F, 0F, 0F);
      krone2 = new ModelRenderer(this, 33, 0);
      krone2.addBox(0F, 0F, 0F, 0, 3, 8);
      krone2.setRotationPoint(4F, -10F, -4F);
      krone2.setTextureSize(64, 32);
      krone2.mirror = true;
      setRotation(krone2, 0F, 0F, 0F);
      krone3 = new ModelRenderer(this, 33, 0);
      krone3.addBox(0F, 0F, 0F, 0, 3, 8);
      krone3.setRotationPoint(-4F, -10F, -4F);
      krone3.setTextureSize(64, 32);
      krone3.mirror = true;
      setRotation(krone3, 0F, 1.570796F, 0F);
      krone4 = new ModelRenderer(this, 33, 0);
      krone4.addBox(0F, 0F, 0F, 0, 3, 8);
      krone4.setRotationPoint(-4F, -10F, 4F);
      krone4.setTextureSize(64, 32);
      krone4.mirror = true;
      setRotation(krone4, 0F, 1.570796F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    krone1.render(f5);
    stab.render(f5);
    krone2.render(f5);
    krone3.render(f5);
    krone4.render(f5);
  }
  
  public void renderModel(float f1)
  {
	  
	  	head.render(f1);
	    body.render(f1);
	    rightarm.render(f1);
	    leftarm.render(f1);
	    rightleg.render(f1);
	    leftleg.render(f1);
	    krone1.render(f1);
	    stab.render(f1);
	    krone2.render(f1);
	    krone3.render(f1);
	    krone4.render(f1); 
	  
  }
  
  
  
  
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, null);
  }

}
