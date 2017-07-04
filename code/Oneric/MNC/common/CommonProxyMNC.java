package Oneric.MNC.common;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraft.util.Session;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxyMNC implements IGuiHandler{
	
	public static int armor_nether;
	public static int armor_glowstone;
	
	public void registerRenderThings()
	{
		
		GameRegistry.registerTileEntity(Oneric.MNC.common.TileEntityStatur.class, "Stature");
		
	}
	
	public void registerPostRender(){}
	
	public void initRenderPlayerAPI() {} 
	
	public void registerSounds(){}
	
	public void loadSounds(){}
	
	public void triggerAchievement(Achievement ach, EntityPlayer player) {}
	
	public String getClientSessionUsername(){return null;}
	
	 @Override
	    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	        return null;
	    }

	    @Override
	    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	    {
	        return null;
	    }
	

}
