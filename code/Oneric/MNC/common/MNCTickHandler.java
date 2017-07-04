package Oneric.MNC.common;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import org.lwjgl.opengl.GL11;

import Oneric.MNC.client.gui.donator.GuiDonator;
import Oneric.MNC.packets.DonatorPacketSender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreenServerList;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.profiler.Profiler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.ModLoader;
import net.minecraft.util.ChatMessageComponent;
import net.minecraft.world.World;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.network.PacketDispatcher;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MNCTickHandler implements ITickHandler{

	
	
	
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
		
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
		
		if (type.equals(EnumSet.of(TickType.RENDER)))
        {
            onRenderTick();
        }
        else if (type.equals(EnumSet.of(TickType.CLIENT)))
        {
            GuiScreen guiscreen = Minecraft.getMinecraft().currentScreen;
            if (guiscreen != null)
            {
            	//System.out.println( guiscreen.getClass().getName() );
                onTickInGUI(guiscreen);
            } else {
                onTickInGame();
            }
        }
		
	}

	@Override
	public EnumSet<TickType> ticks() {
		
		  return EnumSet.of(TickType.RENDER, TickType.CLIENT);
	}

	@Override
	public String getLabel() {
		
		return null;
	}
	
	
	@SideOnly(Side.CLIENT)
	 public void onRenderTick()
	    {
	        //System.out.println("onRenderTick");
		
			if(mod_netherbr.currentBoss != null)
			{	
				mod_netherbr.renderManager.renderBossHP();
				if(mod_netherbr.currentBoss.getBossHP() <= 0)
				{
					mod_netherbr.currentBoss = null;
					
				}
			}
			
			
			/**
			World w = FMLClientHandler.instance().getClient().theWorld;
			if(w == null)
			{
				System.out.println("Entity list is equals Null");
				return;
			} 
			Iterator it = w.loadedEntityList.iterator();
			Entity ent;
			while(it.hasNext()) 
			{
				
				ent = (Entity)it.next();
				
				GL11.glPushMatrix();
				
				//GL11.glTranslated(ent.posX, ent.posY, ent.posZ);
				
				GL11.glBegin(GL11.GL_TRIANGLES);
				
				GL11.glColor3f(1, 0, 0);
				GL11.glVertex3d(ent.posX, ent.posY, ent.posZ);
				
				GL11.glColor3f(0, 1, 0);
				GL11.glVertex3d(ent.posX+1, ent.posY, ent.posZ);
				
				GL11.glColor3f(0, 0, 1);
				GL11.glVertex3d(ent.posX, ent.posY+1, ent.posZ);
				
				GL11.glEnd();

				GL11.glPopMatrix();
			}*/
			
			
			
			
			
			
			
		
	    }

	 @SideOnly(Side.CLIENT)
	    public void onTickInGUI(GuiScreen guiscreen)
	    {
		 
	        //System.out.println("onTickInGUI");

		 if(guiscreen instanceof GuiMainMenu || guiscreen instanceof GuiSelectWorld || guiscreen instanceof GuiScreenServerList)
		 {
		 	if(mod_netherbr.updateCheck && mod_netherbr.newVersionAviable)
		 	{	 
		 		if(!mod_netherbr.reportNewVersion)
		 		{
		 				mod_netherbr.reportNewVersion = true;
		 		}
			 
		 	}
		 }
		 
		 
		 
	    }

	    @SideOnly(Side.CLIENT)
	    public void onTickInGame()
	    {
	        //System.out.println("----------------onTickInGame----------------");
	        
	    	
	    	//Minecraft mc = FMLClientHandler.instance().getClient();
	    	//EntityPlayerMP player = FMLClientHandler.instance().getClient().getIntegratedServer().getConfigurationManager().getPlayerForUsername(FMLClientHandler.instance().getClient().thePlayer.username);
	    	
	 	    //InventoryPlayer inv = player.inventory;
	 	   //player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 200, 200, true));
	    	//FMLClientHandler.instance().getClient().getIntegratedServer().getConfigurationManager().getPlayerForUsername(FMLClientHandler.instance().getClient().thePlayer.username).addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 200, 200, true));
	 		 
	 	 //if(/*player.inventory.armorInventory[0] != null &&*/ /**player.inventory.armorInventory[0] == new ItemStack(MNCItems.NetherBoots, 1) /*&& player.inventory.armorInventory[1] != null*\ && player.inventory.armorInventory[1] == new ItemStack(MNCItems.NetherLeg, 1) /*&& player.inventory.armorInventory[2] != null*\ && player.inventory.armorInventory[2] ==  new ItemStack(MNCItems.NetherPlate, 1)*/ /*&& player.inventory.armorInventory[3] != null*/ /*&&*/  player.inventory.armorInventory[3] == new ItemStack(MNCItems.NetherHelmet, 1))
	 	 /*{
	 		 System.out.println("----------------wearing armor !----------------");
	 		
	 		 player.addPotionEffect(new PotionEffect(Potion.fireResistance.getId(), 200, 10, true));
	 		 player.extinguish();
	 		 
	 		
	 		 
	 	 }*/
	    	if(mod_netherbr.updateCheck && mod_netherbr.newVersionAviable)
	    	{
	    		Minecraft mc = FMLClientHandler.instance().getClient();
		    	EntityClientPlayerMP player = FMLClientHandler.instance().getClient().thePlayer;
	    		
		    	if(player != null)
		    	{
		    		if(mod_netherbr.reportNewVersion)
		    		{
		    			player.addChatMessage("A new Version of the 'UltimateNetherMod' is available ! ");
		    			mod_netherbr.reportNewVersion = false;
		    		}
		    	}
		    	else
		    	{
		    		
		    	}
	    	}
	    	
	    	if(mod_netherbr.achievementsEnabled)
	    	{
	    		
	    		
	    		/**try
		    	{
	    			
		    		//Minecraft mc = FMLClientHandler.instance().getClient();
			    	EntityPlayerMP player = FMLClientHandler.instance().getClient().getIntegratedServer().getConfigurationManager().getPlayerForUsername(FMLClientHandler.instance().getClient().thePlayer.username);
			    	
			    	
			    	
			    	/**if(player !=  null)
			    	{
			    		if(player.dimension == -1)
			    		{
			    			mod_netherbr.proxy.triggerAchievement(MNCAchievements.enterTheNether, player);
			    		}
			    		
			    		else if(player.dimension == MNCBiomes.CrazyDimID)
			    		{
			    			mod_netherbr.proxy.triggerAchievement(MNCAchievements.enterTheFallenSky, player);
			    		}
			    		
			    		
			    	}
			    	
			    	
		    	}catch(Exception ex){}*/

	    		
	    		
	    	}

	    	
	    	
	    }
	

}
