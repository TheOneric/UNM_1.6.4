package Oneric.MNC.client.gui.donator;


import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.donator.ChoiceSaver;
import Oneric.MNC.donator.Donator;
import Oneric.MNC.donator.EnumChoiceType;
import Oneric.MNC.donator.choices.DonatorChoice;
import Oneric.MNC.packets.DonatorPacketSender;
import Oneric.MNC.packets.PacketDonatorAddChoice;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.player.EntityPlayer;

public class GuiDonator extends GuiScreen{
	
	
	private EntityPlayer player;
	private Donator donator;
	private Minecraft mc;
	
	private ResourceLocation backgroundTexture = new ResourceLocation(mod_netherbr.getId(), mod_netherbr.LOCATION_GUI + "donatorMenu.png");
	
	private int x,y;
	
	private boolean isDonator = false;
	
	private int capeIndex;
	private boolean hornIndex;
	
	
	public GuiDonator(EntityPlayer playerTmp)
	{
		this.player = playerTmp;
		this.mc = Minecraft.getMinecraft();
		
		this.x = this.mc.displayWidth / 2;
		this.y = this.mc.displayHeight / 2;
		
		this.donator = mod_netherbr.donatorList.getDonatorByName(player.username);
		
		if(this.donator != null)
		{
			this.isDonator = true;
			this.hornIndex = this.donator.hasChooosen(EnumChoiceType.HORN);
			this.capeIndex = ( mod_netherbr.donatorChoices.capeChoices.indexOf(this.donator.getChoiceForType(EnumChoiceType.CAPE)) + 1);
		}
		
		
		
		this.updateScreen();
	}
	
	
	 /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	
	/**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
	@Override
    protected void keyTyped(char var1, int var2)
    {
        super.keyTyped(var1, var2);

        if (var2 == Minecraft.getMinecraft().gameSettings.keyBindInventory.keyCode)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
    }
    
    
	@Override
	public void actionPerformed(GuiButton button)
	{
		switch(button.id)
		{
		case 0:
			
			if(this.capeIndex >= mod_netherbr.donatorChoices.capeChoices.size())
			{
				this.capeIndex = 0;
				PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorChoiceRemove(mod_netherbr.proxy.getClientSessionUsername(), EnumChoiceType.CAPE.name));
				this.donator.removeChoiceForType(EnumChoiceType.CAPE);
				return;
			}
			else
			{
				this.donator.addChoice((DonatorChoice)mod_netherbr.donatorChoices.capeChoices.get(capeIndex));
				PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorChoiceAdd(mod_netherbr.proxy.getClientSessionUsername(), ((DonatorChoice)mod_netherbr.donatorChoices.capeChoices.get(capeIndex)).name));
				capeIndex++;
			}
			
			
			break;
			
		case 1:
			if(this.hornIndex)
			{
				this.hornIndex = false;
				this.donator.removeChoiceForType(EnumChoiceType.HORN);
				PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorChoiceRemove(mod_netherbr.proxy.getClientSessionUsername(), EnumChoiceType.HORN.name));
			}
			else
			{
				this.hornIndex = true;
				this.donator.addChoice((DonatorChoice)mod_netherbr.donatorChoices.hornChoices.get(0));
				PacketDispatcher.sendPacketToAllPlayers(DonatorPacketSender.sendDonatorChoiceAdd(mod_netherbr.proxy.getClientSessionUsername(), ((DonatorChoice)mod_netherbr.donatorChoices.hornChoices.get(0)).name ));
			}
			
			
			break;
		}
	}
	
	
	
	
	
    @Override
    public void drawScreen(int var1, int var2, float var3)
    {
    	this.buttonList.clear();
    	
    	this.drawDefaultBackground();
    	
    	GL11.glColor4f(1F, 1F, 1F, 1F);
    	this.mc.getTextureManager().bindTexture(this.backgroundTexture);
    	this.drawTexturedModalRect((this.width / 2) - 128, (this.height / 2) - 50, 0, 0, 256, 100);
    	
    	
    	GuiButton buttonCape, buttonHorn;
    	String cape;
    	String horn;
    	if(this.donator != null)
    	{
    		DonatorChoice hornC = this.donator.getChoiceForType(EnumChoiceType.HORN);
        	if(hornC == null)
        	{
        		horn = "Horns: OFF";
        	}
        	else
        	{
        		horn = hornC.name;
        	}
    		
    		DonatorChoice capeC = this.donator.getChoiceForType(EnumChoiceType.CAPE);
        	if(capeC == null)
        	{
        		cape = "Cape: OFF";
        	}
        	else
        	{
        		cape = capeC.name;
        	}
        	
        	
        	buttonCape = new GuiButton(0, (this.width / 2) - 40, (this.height / 2) - 23, this.mc.fontRenderer.getStringWidth(cape) + 4, 20, cape);
        	buttonHorn = new GuiButton(1, (this.width / 2) - 40, (this.height / 2) + 3, this.mc.fontRenderer.getStringWidth(horn) + 4, 20, horn);
    	}
    	else
    	{
    		cape = "Cape: OFF";
    		horn = "Horn: OFF";
    		
    		buttonCape = new GuiButton(0, (this.width / 2) - 40, (this.height / 2) - 23, this.mc.fontRenderer.getStringWidth(cape) + 4, 20, cape);
        	buttonHorn = new GuiButton(1, (this.width / 2) - 40, (this.height / 2) + 3, this.mc.fontRenderer.getStringWidth(horn) + 4, 20, horn);
        	
        	buttonCape.enabled = false;
        	buttonHorn.enabled = false;
    	}
    	
    	
    	
    	this.buttonList.add(buttonCape);
    	this.buttonList.add(buttonHorn);
    	
    	
    	
    	this.drawPlayerOnGui(mc, (this.width / 2) - 80, (this.height / 2) + 32, 30, 0F, 0F);
    	
    	super.drawScreen(var1, var2, var3);
    }
    
    
    
    
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed() 
    {
    	try{
    		if(this.donator != null)
    		{
    			ChoiceSaver.saveChoice(EnumChoiceType.CAPE, this.donator.getChoiceForType(EnumChoiceType.CAPE));
        		ChoiceSaver.saveChoice(EnumChoiceType.HORN, this.donator.getChoiceForType(EnumChoiceType.HORN));
    		}
    		
    	} catch(Exception ex){ex.printStackTrace();}
    	 
    	if(!Minecraft.getMinecraft().isSingleplayer())
    	{
    		if(this.donator.hasChooosen(EnumChoiceType.CAPE))
    		{
    			PacketDispatcher.sendPacketToServer(DonatorPacketSender.sendServer_DonatorAddChoice(this.donator.getUserName(), this.donator.getChoiceForType(EnumChoiceType.CAPE).name));
    		} else 
    		{
    			PacketDispatcher.sendPacketToServer(DonatorPacketSender.sendServer_DonatorRemoveChoice(this.donator.getUserName(), EnumChoiceType.CAPE.name));
    		}
    		
    		
    		if(this.donator.hasChooosen(EnumChoiceType.HORN))
    		{
    			PacketDispatcher.sendPacketToServer(DonatorPacketSender.sendServer_DonatorAddChoice(this.donator.getUserName(), this.donator.getChoiceForType(EnumChoiceType.HORN).name));
    		} else 
    		{
    			PacketDispatcher.sendPacketToServer(DonatorPacketSender.sendServer_DonatorRemoveChoice(this.donator.getUserName(), EnumChoiceType.HORN.name));
    		}
    		
    		
    	}
    }
    
    
    
    
    
    
    
    private int p = 0;
    private void drawPlayerOnGui(Minecraft par0Minecraft, int par1, int par2, int par3, float par4, float par5)
    {
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par1, (float)par2, 50.0F);
        GL11.glScalef((float)(-par3), (float)par3, (float)par3);
        GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
        
        float f2 = par0Minecraft.thePlayer.renderYawOffset;
        float f3 = par0Minecraft.thePlayer.rotationYaw;
        float f4 = par0Minecraft.thePlayer.rotationPitch;
        
        GL11.glRotatef(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GL11.glRotatef(-135.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-((float)Math.atan((double)(par5 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        par0Minecraft.thePlayer.renderYawOffset = (float)Math.atan((double)(par4 / 40.0F)) * 20.0F;
        par0Minecraft.thePlayer.rotationYaw = (float)Math.atan((double)(par4 / 40.0F)) * 40.0F;
        par0Minecraft.thePlayer.rotationPitch = -((float)Math.atan((double)(par5 / 40.0F))) * 20.0F;
        par0Minecraft.thePlayer.rotationYawHead = par0Minecraft.thePlayer.rotationYaw;
        GL11.glTranslatef(0.0F, par0Minecraft.thePlayer.yOffset, 0.0F);
        RenderManager.instance.playerViewY = 180.0F;
        
        GL11.glPushMatrix();
        GL11.glRotatef(p, 0F, 1.0F, 0F);
        RenderManager.instance.renderEntityWithPosYaw(par0Minecraft.thePlayer, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        p++;
        
        if(p >= 360) p = 0;
        GL11.glPopMatrix();
        
        par0Minecraft.thePlayer.renderYawOffset = f2;
        par0Minecraft.thePlayer.rotationYaw = f3;
        par0Minecraft.thePlayer.rotationPitch = f4;
        GL11.glPopMatrix();
        RenderHelper.disableStandardItemLighting();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        OpenGlHelper.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        OpenGlHelper.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
    
    
    

}
