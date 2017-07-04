package Oneric.MNC.common;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class StaturRender extends TileEntitySpecialRenderer{
	
	
	private ResourceLocation image = new ResourceLocation(mod_netherbr.getId(), mod_netherbr.LOCATION_TEXTURES + "statur2.png");
	
	public StaturRender()
	{
		aModel = new ModelStatur();
	}
	
	public void renderAModelAt(TileEntityStatur tileentity, double d, double d1, double d2, float f)
	{
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)d+0.5F, (float)d1 + 1.5F, (float)d2 + 0.5F);
		
		int metadata = tileentity.getBlockMetadata();
		int rotationAngle = 0;
		
		if (metadata%4 == 0)
        {
                        rotationAngle = 0;
        }

        if (metadata%4 == 1)
        {
            //rotationAngle = 180;
        	rotationAngle = 90;
        }

        if (metadata%4 == 2)
        {
        	//rotationAngle = 100000;
        	rotationAngle = 180;
        	
        }

        if (metadata%4 == 3)
        {
            //rotationAngle = -180;
        	rotationAngle = -90;
        }
        
        
        //GL11.glRotatef(180.0F, 180.0F, 0.0F, rotationAngle);
        GL11.glRotatef(180.0F, 180.0F, 0.0F, 0);
        GL11.glRotatef(rotationAngle, 0, 1, 0);
		
		
        this.tileEntityRenderer.renderEngine.bindTexture(image);
		
		GL11.glPushMatrix();
		aModel.renderModel(0.0625F);
		
	    GL11.glPopMatrix();
	    GL11.glPopMatrix();
		
	}
	
	
	
	

	@Override
	public void renderTileEntityAt(TileEntity tileentity, double d, double d1, double d2, float f)
	{
		
		renderAModelAt((TileEntityStatur)tileentity, d, d1, d2, f);
		
	}
	
	
	private ModelStatur aModel;

}
