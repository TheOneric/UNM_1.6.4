package Oneric.MNC.biomes;

import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.src.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;

public class biome_IceHell extends BiomeGenBase {
	
	
	public biome_IceHell(int par1) {
		
		
		super(par1);
		
		spawnableMonsterList.clear();
	    spawnableCreatureList.clear();
	    spawnableWaterCreatureList.clear();
	    //spawnableMonsterList.add(new SpawnListEntry(net.minecraft.src.EntityLostSoul.class, 50, 4, 4));
	    this.spawnableMonsterList.add(new SpawnListEntry(EntitySilverfish.class, 20, 4, 4));
	    this.spawnableCreatureList.add(new SpawnListEntry(EntitySnowman.class, 100, 4, 4));
        topBlock = (byte)Block.blockSnow.blockID;
        fillerBlock = (byte)Block.ice.blockID;
        this.setBiomeName("IceHell");
        this.setColor(0xFFFFFF);
        
        this.theBiomeDecorator.generateLakes = true;
        this.setEnableSnow();
        this.rainfall = 0.5F;
        this.temperature = 0.0F;
        
        
        this.minHeight = 0.3F;
        this.maxHeight = 1.5F;
       
	}
	
	


	

}
