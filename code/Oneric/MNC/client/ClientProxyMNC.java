package Oneric.MNC.client;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import api.player.render.RenderPlayerAPI;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBat;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBat;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLightningBolt;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.stats.Achievement;
import net.minecraft.util.Session;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import Oneric.MNC.common.CommonProxyMNC;
import Oneric.MNC.common.MNCItems;
import Oneric.MNC.common.MNCSoundManager;
import Oneric.MNC.common.MNCTickHandler;
import Oneric.MNC.common.StaturRender;
import Oneric.MNC.common.mod_netherbr;
import Oneric.MNC.entity.EntityFeuerBall;
import Oneric.MNC.entity.EntityHarpye;
import Oneric.MNC.entity.EntityIceBall;
import Oneric.MNC.entity.EntityIceGhost;
import Oneric.MNC.entity.EntityIcePigman;
import Oneric.MNC.entity.EntityLostSoul;
import Oneric.MNC.entity.EntityNetherArrow;
import Oneric.MNC.entity.EntitySlaughter;
import Oneric.MNC.entity.boss.EntityDaemonLord;
import Oneric.MNC.entity.effect.MNCEntityLightningBolt;
import Oneric.MNC.entity.model.ModelDaemonLord;
import Oneric.MNC.entity.model.ModelFeuerBall;
import Oneric.MNC.entity.model.ModelIceGhost;
import Oneric.MNC.entity.model.ModelLostSoul;
import Oneric.MNC.entity.model.ModelSlaughter;
import Oneric.MNC.entity.render.RenderFeuerBall;
import Oneric.MNC.entity.render.RenderHarpye;
import Oneric.MNC.entity.render.RenderIceGhost;
import Oneric.MNC.entity.render.RenderLostSoul;
import Oneric.MNC.entity.render.RenderMNCBiped;
import Oneric.MNC.entity.render.RenderSlaughter;
import Oneric.MNC.item.ItemNetherArrow;

public class ClientProxyMNC extends CommonProxyMNC{
	
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	  @Override
	  @SideOnly(Side.CLIENT)
	    public void registerRenderThings()
	    {
		  KeyBindingRegistry.registerKeyBinding(new MNCKeyHandler());
	     
		  //MinecraftForgeClient.preloadTexture("/img/mnc_items.png");
		  //MinecraftForgeClient.preloadTexture("/img/mnc_blocks.png");
		  
		 
		  
		  //RenderingRegistry.instance().registerEntityRenderingHandler(EntityFeuerBall.class, new RenderLostSoul(new ModelLostSoul(), 0.5F));
		 
		  RenderingRegistry.registerEntityRenderingHandler(EntityLostSoul.class, new RenderLostSoul(new ModelLostSoul(), 0.5F));
		  RenderingRegistry.registerEntityRenderingHandler(EntitySlaughter.class, new RenderSlaughter(new ModelSlaughter(), 0.5F));
		  RenderingRegistry.registerEntityRenderingHandler(EntityIceGhost.class, new RenderIceGhost(new ModelIceGhost(), 0.5F));
		  RenderingRegistry.registerEntityRenderingHandler(EntityIcePigman.class, new RenderMNCBiped(new ModelBiped(), 0.5F));
		  RenderingRegistry.registerEntityRenderingHandler(EntityHarpye.class, new RenderHarpye());
		  RenderingRegistry.registerEntityRenderingHandler(MNCEntityLightningBolt.class, new RenderLightningBolt());
		  
		  //TODO
		  RenderingRegistry.registerEntityRenderingHandler(EntityDaemonLord.class, new RenderMNCBiped(new ModelDaemonLord(), 0.5F));
		  RenderingRegistry.registerEntityRenderingHandler(EntityFeuerBall.class, new RenderFeuerBall(new ModelFeuerBall(), 1.0F)); 
		  
		  
		  armor_nether = RenderingRegistry.addNewArmourRendererPrefix("nether");
		  armor_glowstone = RenderingRegistry.addNewArmourRendererPrefix("glowstone");
		  
		  ClientRegistry.registerTileEntity(Oneric.MNC.common.TileEntityStatur.class, "Stature", new StaturRender());
		  
		  
		  TickRegistry.registerTickHandler(new MNCTickHandler(), Side.CLIENT);
		  
		  
		  
		  
	    }
	  
	  
	  
	  public void initRenderPlayerAPI() 
	  {
		  RenderPlayerAPI.register(mod_netherbr.getId(), MNCRenderPlayerBase.class);
	  }
	  
	  
	  public void registerPostRender()
	  {
		  
		  RenderingRegistry.registerEntityRenderingHandler(EntityNetherArrow.class, new RenderSnowball(MNCItems.NArrow, 0));
		  RenderingRegistry.registerEntityRenderingHandler(EntityIceBall.class, new RenderSnowball(MNCItems.NArrow, 1));
		  
	  }
	  
	  
	  
	@Override  
	public void loadSounds()
	{
		/**
		if(this.mc.sndManager != null)
		{
			this.moveSounds("newsound/achievement/achiev1.ogg");
			this.moveSounds("newsound/achievement/achiev2.ogg");
		}*/
	}  
	  
	
	@Override
	public void registerSounds()
	{
		MinecraftForge.EVENT_BUS.register(new MNCSoundManager());	
	}
	
	  
	  
	 public void triggerAchievement(Achievement ach, EntityPlayer player) 
	 {
         if (!FMLClientHandler.instance().getClient().statFileWriter.hasAchievementUnlocked(ach))
         {
        	 if(ach.parentAchievement == null)
        	 {
        		 player.triggerAchievement(ach);
            	 player.worldObj.playSoundAtEntity(player, mod_netherbr.getId()+":achievement.achiev", 1, 1); 
        	 }
        	 else if(FMLClientHandler.instance().getClient().statFileWriter.hasAchievementUnlocked(ach.parentAchievement))
        	 {
        		 player.triggerAchievement(ach);
            	 player.worldObj.playSoundAtEntity(player, mod_netherbr.getId()+":achievement.achiev", 1, 1); 
        	 }
        	 
		 }
	 }
	 
	 
	 public String getClientSessionUsername()
	 {
		 return Minecraft.getMinecraft().getSession().getUsername();
	 }
	  
	  
	  
	  

}
