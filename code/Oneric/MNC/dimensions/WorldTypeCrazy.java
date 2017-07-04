package Oneric.MNC.dimensions;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldTypeCrazy extends WorldType{
	
	
	public WorldTypeCrazy() {
		super(12, "CRAZY");
		
		
		
	}
	
	
	@Override
	public WorldChunkManager getChunkManager(World world) {
        return new WorldChunkManagerCrazy(/*mod_wallGen.biome_sky, mod_wallGen.biome_sky.getFloatTemperature(), mod_wallGen.biome_sky.getFloatRainfall()*/0.0D);
		//return new WorldChunkManagerHell(new BiomeGenCrazy().me, 0.5F, 0.0F);
        // This is our ChunkManager class, it controls rain, temp, biomes, and spawn location
	}
	
	@Override
	public IChunkProvider getChunkGenerator(World world, String flatOptions) {
        //return new FlyIslandProvider(world, new Random().nextLong());
		 return new ChunkProviderCrazy(world, world.getSeed());
        // This is our ChunkProvider, this generates the world.
	}
	
	@Override
	public boolean hasVoidParticles(boolean flag) {
        return false; // Used to determine if there is a sky
	}
	
	@Override
	public int getMinimumSpawnHeight(World world)
	{
		return 64;
    }

	@Override
	public double voidFadeMagnitude() {
        return 0.0D; // Sets the void fade, play with it to see which values work for you.
	}
	
	

}
