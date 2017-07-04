package Oneric.MNC.common;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.src.ModLoader;
import Oneric.MNC.entity.EnumBoss;
import Oneric.MNC.entity.IBoss;

public class RenderManager {

	float zLevel = -90F;
	
	public RenderManager()
	{
		
	}
	
	
	
	@SideOnly(Side.CLIENT)
	public void renderBossHP()
	{
		
		Minecraft mc = FMLClientHandler.instance().getClient();
		if(mc.theWorld != null)
		{	
			ScaledResolution res = new ScaledResolution(mc.gameSettings,
					mc.displayWidth, mc.displayHeight);

			int w = res.getScaledWidth();
			int h = res.getScaledHeight();

			String name = mod_netherbr.currentBoss.getBossName();

			
			mc.fontRenderer.drawStringWithShadow(name,
					(w / 2 - (mc.fontRenderer.getStringWidth(name) / 2)), 18,
					-1);

			String type = "Main - Boss";
			if (mod_netherbr.currentBoss.getBossType() == EnumBoss.MiniBoss) {
				type = "Mini - Boss";
			}

			mc.fontRenderer.drawStringWithShadow(type,
					(w / 2 - (mc.fontRenderer.getStringWidth(type) / 2)), 35,
					-1);
			
			mc.getTextureManager().bindTexture(new ResourceLocation(mod_netherbr.getId(), mod_netherbr.LOCATION_GUI + "bossHP.png"));

			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_ONE_MINUS_DST_COLOR,
					GL11.GL_ONE_MINUS_SRC_COLOR);
			GL11.glColor3f(1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			// drawTexturedModalRect(w / 2 - 128, 12, 0, 16, 256, 32);
			drawTexturedModalRect(w / 2 - 128, 12, 0, 20, 256, 20);
			int k = (int) (((float) mod_netherbr.currentBoss.getBossHP() / (float) mod_netherbr.currentBoss
					.getBossMaxHP()) * 256F);
			drawTexturedModalRect(w / 2 - 128, 12, 0, 0, k, 20);

		}
		
	}
	
		
	
	
	
	
	
	
	
	
	
	
	 /**
     * Draws a textured rectangle at the stored z-value. Args: x, y, u, v, width, height
     */
	 public void drawTexturedModalRect(int par1, int par2, int par3, int par4, int par5, int par6)
	 {
		 float var7 = 0.00390625F;
	     float var8 = 0.00390625F;
	        
	     Tessellator var9 = Tessellator.instance;
	     var9.startDrawingQuads();
	     var9.addVertexWithUV((double)(par1 + 0), (double)(par2 + par6), (double)this.zLevel, (double)((float)(par3 + 0) * var7), (double)((float)(par4 + par6) * var8));
	     var9.addVertexWithUV((double)(par1 + par5), (double)(par2 + par6), (double)this.zLevel, (double)((float)(par3 + par5) * var7), (double)((float)(par4 + par6) * var8));
	     var9.addVertexWithUV((double)(par1 + par5), (double)(par2 + 0), (double)this.zLevel, (double)((float)(par3 + par5) * var7), (double)((float)(par4 + 0) * var8));
	     var9.addVertexWithUV((double)(par1 + 0), (double)(par2 + 0), (double)this.zLevel, (double)((float)(par3 + 0) * var7), (double)((float)(par4 + 0) * var8));
	     var9.draw();
	 }
	
	
	
	
}
