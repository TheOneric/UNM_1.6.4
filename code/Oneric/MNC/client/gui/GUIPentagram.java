/**package Oneric.MNC.client.gui;

 

import java.awt.image.BufferedImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.src.ModLoader;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.GameRegistry;

 

public class GUIPentagram extends GuiScreen {
	
	
	private BufferedImage img;
	private int imgID = 1000;
	
	private int page = 0;
	private GuiButton disable;
	
	

    public GUIPentagram()
    {

    }

    

    public void initGui()
    {
    	
    	try
    	{
    		img =  ModLoader.loadImage(mc.renderEngine, "/img/gui/hellaltar.png");
    		mc.renderEngine.setupTexture(img, imgID);
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		
    	}
    	

        //controlList.clear();
        /*tabs();
        
        switch(page)
        {
        
        case 0:
        ////////PAGE1/////////	
        break;
        
        case 1:
        	/////////PAGE2////////
        controlList.add(new GuiButton(1, width / 2 + 5  , height / 2 - 40, 98, 20, "Rainfall"));
        controlList.add(new GuiButton(2, width / 2 - 110, height / 2 - 40, 98, 20, "Stop that f** Rain"));
        
        controlList.add(new GuiButton(5, width / 2 + 5  , height / 2 - 15, 98, 20, "Day"));
        controlList.add(new GuiButton(6, width / 2 - 110, height / 2 - 15, 98, 20, "Night"));
        break;
        
        default:
        ////////////	
        break;
        
        }*\
        
       
        
        
        

    }
    
    private void tabs()
    {
    	  
    	/*controlList.add(new GuiButton(3, width / 2 - 91, height / 2 - 100, 78, 20, "Altar"));  
    	controlList.add(disable = new GuiButton(4, width / 2 - 10, height / 2 - 100, 78, 20, "Controlls !"));
    	disable.drawButton = true;
    	disable.enabled = false;*\
    	  
    }
    
    
    
    
    
    protected void actionPerformed(GuiButton guibutton)
    {
   /****if(guibutton.id == 1)
    	{
    		ModLoader.getMinecraftInstance().theWorld.setRainStrength(5.0F);
    		Minecraft.getMinecraft().theWorld.setRainStrength(1.0F);
    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Rain");
    		//ModLoader.getMinecraftInstance().thePlayer.sendChatMessage("Regen");
    	}
    	
    	if(guibutton.id == 2)
    	{
    		ModLoader.getMinecraftInstance().theWorld.setRainStrength(0.0F);
    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Sun");
    	}
    	
    	if(guibutton.id == 5)
    	{
    		ModLoader.getMinecraftInstance().theWorld.setWorldTime(1);
    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Day");
    		Minecraft.getMinecraft().theWorld.setWorldTime(1);
    	}
    	
    	if(guibutton.id == 6)
    	{
    		ModLoader.getMinecraftInstance().theWorld.setWorldTime(12600);
    		ModLoader.getMinecraftInstance().thePlayer.addChatMessage("Night");
    	}
    	
    	
    	
    	////////PAGES////////
    	
    	if(guibutton.id == 3)
    	{
    		page = 0;
    		initGui();
    	}
    	
    	if(guibutton.id == 4)
    	{
    		page = 1;
    		initGui();
    	}
    	
    	
    	
    	*\
    	
    	
    }

  

    public boolean doesGuiPauseGame()
    {

        return false;

    }

    

    public void onGuiClosed()
    {
    	
    

    }

    

    public void drawScreen(int i, int j, float f)
    {
    	  /**drawCenteredString(fontRenderer, "Super Geile GUI !", width / 2, 45, 0xffffff);
    	     drawRect(60, 60, width - 60, height - 60, 0xFF0000FF);*\
    	
    	
    	
    	//////DEFAULT//////
        drawDefaultBackground();
        drawGradientRect(0, 0, width - 0, height - 0, 0x50500000, 0x550000);
        
        int x = width / 2;
        int y = height / 2;
        
        switch(page){
        
        case 0:
        //////PAGE1//////
        try{
        	int altar = mc.renderEngine.getTexture("/img/gui/hellaltar.png");
        	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        	mc.renderEngine.bindTexture("/img/gui/hellaltar.png");
        	drawTexturedModalRect(x - 90, y - 80, 0, 0, 176, 166);
        	
        }
        finally{
        	
        }
        
       
        GL11.glPushMatrix();
        drawString(fontRenderer, "hell altar",x - 85, y - 76 , 0xdddddd);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glScalef(1.6F, 1.6F, 1.6F);
        drawCenteredString(fontRenderer, "Coming soon !", x - 60, y / 2 + 10, 0x44ff11);
        
        GL11.glPopMatrix();
        
        break;
        
        case 1:
        //////PAGE2//////
        GL11.glPushMatrix();
        GL11.glScalef(1.4F, 1.4F, 1.4F);
       // drawCenteredString(fontRenderer, "Controls (still in progress)", x - 50, y / 2 - 25, 0x44ff11);
        
        GL11.glPopMatrix();
        break;
        
        default:
        	
        break;
        
        
        }
      
      

        super.drawScreen(i, j, f);

    }

 

}*/