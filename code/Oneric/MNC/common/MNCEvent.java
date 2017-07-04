package Oneric.MNC.common;

import java.io.File;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import Oneric.MNC.biomes.MNCGenLayer;
import Oneric.MNC.block.BlockFireSapling;
import Oneric.MNC.block.BlockHellPilz;
import Oneric.MNC.donator.choices.DonatorChoice;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.client.event.sound.PlayBackgroundMusicEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;

public class MNCEvent {
	
	
	
	
	 @ForgeSubscribe
	    public void bonemealUsed(BonemealEvent event)
	    {
	  if(event.world.getBlockId(event.X, event.Y, event.Z)== MNCBlocks.HellPilz_Block.blockID)
	        {
	         ((BlockHellPilz)MNCBlocks.HellPilz_Block).fertilize(event.world, event.X, event.Y, event.Z);
	        }
	  
	  	if(event.world.getBlockId(event.X, event.Y, event.Z)== MNCBlocks.FireSapling.blockID && event.world.rand.nextBoolean())
	  	{
	  		((BlockFireSapling)MNCBlocks.FireSapling).growTree(event.world, event.X, event.Y, event.Z, new Random());
	  	}
	  
	    }
	 
	 
	
	 @SideOnly(Side.CLIENT)
	 @ForgeSubscribe
	    public void onSound(SoundLoadEvent event)
	    {
		 
		 System.out.println("---Yeah!!---");		 
	        try 
	        {
	        	Minecraft mc = Minecraft.getMinecraft();
	        	
	            event.manager.addSound(mod_netherbr.getId()+":achievement/achiev1.ogg");
	            event.manager.addSound(mod_netherbr.getId()+":achievement/achiev2.ogg");
	        
	        } 
	        catch (Exception e)
	        {
	            System.out.println("----------Failed to register one or more sounds.--------------------");
	        }
	    }
	 
	 
	
	
	/***@ForgeSubscribe
	public void onPlayerFall(LivingFallEvent event)
	{
		//System.out.println(event.entity);
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer)event.entity;
			if(event.entity.dimension == MNCBiomes.CrazyDimID && event.entity.posY < 2)
			{
				System.out.println("--------");
			}
		}
		
	}*/
	
	
	

}
