package Oneric.MNC.common;

import Oneric.MNC.biomes.biome_Blackstone;
import Oneric.MNC.biomes.biome_HellPilz;
import Oneric.MNC.biomes.biome_IceHell;
import Oneric.MNC.dimensions.BiomeGenCrazy;
import Oneric.MNC.dimensions.WorldProviderCrazy;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import cpw.mods.fml.common.registry.GameRegistry;

public class MNCBiomes {
	
	
	public static BiomeGenBase biome_Blackstone;
	public static BiomeGenBase biome_HellPilz;
	public static BiomeGenBase biome_IceHell;
	public static int CrazyDimID;
	public static BiomeGenBase[] CrazyBiomeList;
	public static BiomeGenCrazy crazy;
	public static BiomeGenBase[] rareBiomes;
	
	public MNCBiomes()
	{
		
		//Blackstone
		biome_Blackstone = new biome_Blackstone(25);
    	//GameRegistry.addBiome(biome_Blackstone);
    	
    	//HellPilz
    	biome_HellPilz = new biome_HellPilz(30);
    	//GameRegistry.addBiome(biome_HellPilz);
    	
    	rareBiomes = new BiomeGenBase[]{biome_Blackstone, biome_HellPilz};
    	
    	//IceHell
    	biome_IceHell = new biome_IceHell(26);
    	GameRegistry.addBiome(biome_IceHell);
    	
		
    	crazy = new BiomeGenCrazy().me;
    	
    	CrazyDimID = DimensionManager.getNextFreeDimId();
    	CrazyBiomeList = new BiomeGenBase[256];
    	CrazyBiomeList[0] = crazy.me;
    	DimensionManager.registerProviderType(12, WorldProviderCrazy.class, true);
    	DimensionManager.registerDimension(CrazyDimID, 12);
    	
    	
	}

}
