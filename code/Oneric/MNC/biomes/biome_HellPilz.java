package Oneric.MNC.biomes;

import Oneric.MNC.entity.EntityLostSoul;
import Oneric.MNC.entity.EntitySlaughter;
import net.minecraft.block.Block;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.src.*;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class biome_HellPilz extends BiomeGenBase {
	
	
	public biome_HellPilz(int par1) {
		
		
		super(par1);
		
		spawnableMonsterList.clear();
	    spawnableCreatureList.clear();
	    spawnableWaterCreatureList.clear();
	    spawnableCreatureList.add(new SpawnListEntry(EntityLostSoul.class, 40, 4, 4));
	    spawnableCreatureList.add(new SpawnListEntry(EntitySlaughter.class, 14, 1, 1));
	    spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 5, 4, 4));
        spawnableMonsterList.add(new SpawnListEntry(EntityGiantZombie.class, 30, 4, 4));
        topBlock = (byte)Block.netherrack.blockID;
        fillerBlock = (byte)Block.lavaMoving.blockID;
        this.setBiomeName("HellPilz");
        this.setColor(0x00000);
        this.waterColorMultiplier = 0x00000;
        
        this.temperature = 1.0F;
        this.rainfall = 0.0F;
        
        this.theBiomeDecorator.generateLakes = false;
        
        //this.theBiomeDecorator.dirtGen = new WorldGenMinable(MNCBlocks.NetherGold.blockID, 32);
        this.theBiomeDecorator.gravelGen = new WorldGenMinable(Block.oreGold.blockID, 3);
       
        
        
	}
	
	


	

}
