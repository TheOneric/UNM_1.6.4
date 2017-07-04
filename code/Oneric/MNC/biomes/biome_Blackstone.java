package Oneric.MNC.biomes;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.entity.EntityLostSoul;
import Oneric.MNC.entity.EntitySlaughter;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.src.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class biome_Blackstone extends BiomeGenBase{
	
	
	public biome_Blackstone(int par1) {
		
		
		super(par1);
		
		spawnableMonsterList.clear();
	    spawnableCreatureList.clear();
	    spawnableWaterCreatureList.clear();
	    spawnableCreatureList.add(new SpawnListEntry(EntityLostSoul.class, 40, 3, 6));
	    spawnableCreatureList.add(new SpawnListEntry(EntitySlaughter.class, 20, 1, 1));
	    spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 5, 4, 4));
        topBlock = (byte) MNCBlocks.Blackstone.blockID;
        fillerBlock = (byte)Block.lavaMoving.blockID;
        
        this.theBiomeDecorator.generateLakes = false;
        
        this.temperature = 1.0F;
        this.rainfall = 0.0F;
        
        this.setBiomeName("Blackstone");
        this.setColor(0x00000);
        this.waterColorMultiplier = 0x00000;
        
        this.theBiomeDecorator.gravelGen = new WorldGenMinable(Block.oreGold.blockID, 3);
        
       
       
	}
	
	


	

}
