package Oneric.MNC.dimensions;

import java.util.Random;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.entity.EntityHarpye;
import Oneric.MNC.entity.EntityIceGhost;
import Oneric.MNC.entity.EntityLostSoul;
import Oneric.MNC.entity.EntitySlaughter;
import Oneric.MNC.world.gen.WorldGenDeadTree;
import Oneric.MNC.world.gen.WorldGenFireTree;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenerator;

public class BiomeGenCrazy extends BiomeGenBase{

	public static BiomeGenCrazy me;
	public BiomeGenCrazy() {
		super(230);
		rainfall = 0.0F;
	    this.spawnableMonsterList.clear();
	    this.spawnableCreatureList.clear();
	    this.spawnableWaterCreatureList.clear();
	    setBiomeName("Madness");
	    this.topBlock = (byte)MNCBlocks.deadGrass.blockID;
	    this.fillerBlock = (byte)MNCBlocks.deadDirt.blockID;
	    /***
	    try
	    {
	    	ObfuscationReflectionHelper.setPrivateValue(net.minecraft.world.biome.BiomeGenBase.class, this, false , ObfuscationReflectionHelper.obfuscation ? "S" : "enableRain");
		    ObfuscationReflectionHelper.setPrivateValue(net.minecraft.world.biome.BiomeGenBase.class, this, false , ObfuscationReflectionHelper.obfuscation ? "R" : "enableSnow");
	    }
	    catch (Exception exception)
        {
            FMLLog.getLogger().warning("Could not disable rain and snow in the Madness. Did obfuscation change?");
        }*/
	    
	    //this.spawnableCreatureList.add(new SpawnListEntry(EntityBat.class, 12, 4, 6));
	    this.spawnableCreatureList.add(new SpawnListEntry(EntityHarpye.class, 16, 4, 8));
	    
	    this.spawnableMonsterList.add(new SpawnListEntry(EntityLostSoul.class, 11, 4, 6));
	    this.spawnableMonsterList.add(new SpawnListEntry(EntityIceGhost.class, 9, 1, 2));
	    this.spawnableMonsterList.add(new SpawnListEntry(EntitySlaughter.class, 1, 1, 1));
	    //this.spawnableMonsterList.add(new SpawnListEntry(EntityGiantZombie.class, 20, 1, 2));
	    
	    me = this;
	    
		
	}
	
	/**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random random)
    {
        if (random.nextInt(100) == 0)
        {
            return new WorldGenFireTree(true);
        }
        else
        {
        	return new WorldGenDeadTree(true);
        }
    }
    
    /**
    * takes temperature, returns color
    */
   public int getSkyColorByTemp(float f)
   {
       return 0xc0c0ff;
   }
	
	

}
