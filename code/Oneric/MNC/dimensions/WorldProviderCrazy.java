package Oneric.MNC.dimensions;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldProviderEnd;
import net.minecraft.world.WorldProviderHell;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderCrazy extends WorldProvider{

	@Override
	public String getDimensionName() {
		
		return "FallenSky";
	}
	
	@Override
	 public String getWelcomeMessage()
	 {
	       
	            return "Entering the Fallen Sky";
	      
	 }
	
	
	
	

	 /**
	 * A Message to display to the user when they transfer out of this dismension.
	 *
	 * @return The message to be displayed
	 */
	@Override
	 public String getDepartMessage()
	 {
	       
	        return "Leaving the Fallen Sky";
	       
	  }
	 
	 @Override
	 public String getSaveFolder()
	 {
	     return "FallenSky";
	 }
	 
	 @Override
	  protected void registerWorldChunkManager()
	  {
		  	this.terrainType = new WorldTypeCrazy();
	        worldChunkMgr = terrainType.getChunkManager(worldObj);
	        
	  }

	    /**
	     * Returns a new chunk provider which generates chunks for this world
	     */
	  @Override
	    public IChunkProvider createChunkGenerator()
	    {
	        return terrainType.getChunkGenerator(worldObj, field_82913_c);
	    }
	    
	    @Override
	    public boolean canRespawnHere()
	    {
	        return false;
	    }  
	    
	    @Override
	    public double getVoidFogYFactor()
	    {
	        return 100D;
	    }
	    
	    @Override
	    public boolean isDaytime()
	    {
	        return false;
	    }
	    
	    @Override
	    public float calculateCelestialAngle(long par1, float par3)
	    {
	        
	        return 0.5F;
	    }
	    
	    @Override
	    public float getCloudHeight()
	    {
	        return 0.5F;
	    }
	    
	    @Override
	    public void calculateInitialWeather()
	    {
	    	worldObj.rainingStrength = 0.0F;
	        worldObj.thunderingStrength = 0.0F;
	    	
	    	worldObj.calculateInitialWeatherBody();
	    }

	    @Override
	    public void updateWeather()
	    {
	    	worldObj.rainingStrength = 0.0F;
	        worldObj.thunderingStrength = 0.0F;
	    	
	        worldObj.updateWeatherBody();
	    }

}
