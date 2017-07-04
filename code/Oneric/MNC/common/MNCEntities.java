package Oneric.MNC.common;

import Oneric.MNC.dimensions.BiomeGenCrazy;
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
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGiantZombie;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MNCEntities {
	
	public MNCEntities()
	{
		
		
		//Arrow
		EntityRegistry.registerModEntity(EntityNetherArrow.class, "NetherArrow", 1, mod_netherbr.mod, 250, 5, false);
		
		
        
		
		//IceBall
		EntityRegistry.registerModEntity(EntityIceBall.class, "IceBall", 2, mod_netherbr.mod, 250, 10, true);
		
		
		//LostSoul
		LanguageRegistry.instance().addStringLocalization("entity.LostSoul.name", "en_US", "LostSoul");
		LanguageRegistry.instance().addStringLocalization("entity.LostSoul.name", "de_DE", "Verlorene Seele");
		EntityRegistry.registerGlobalEntityID(EntityLostSoul.class, "LostSoul", EntityRegistry.findGlobalUniqueEntityId(), 0xcccccc, 0xeeeeee);
		
		 EntityRegistry.addSpawn(EntityLostSoul.class, 50, 4, 9, EnumCreatureType.monster,new BiomeGenBase[] {
            BiomeGenBase.hell,
            BiomeGenBase.icePlains,
            MNCBiomes.biome_HellPilz,
            MNCBiomes.biome_IceHell
		});
		
		
		//Slaughter
		LanguageRegistry.instance().addStringLocalization("entity.Slaughter.name", "en_US", "Slaughter");
		LanguageRegistry.instance().addStringLocalization("entity.Slaughter.name", "de_DE", "Schlaechter");
		EntityRegistry.registerGlobalEntityID(EntitySlaughter.class, "Slaughter", EntityRegistry.findGlobalUniqueEntityId(), 0xdddddd, 0x115500);
		
		 EntityRegistry.addSpawn(EntitySlaughter.class, 6, 1, 1, EnumCreatureType.monster,new BiomeGenBase[] {
            BiomeGenBase.hell,
            MNCBiomes.biome_Blackstone,
            MNCBiomes.biome_HellPilz
		});
		
		
		//IceGhost
		LanguageRegistry.instance().addStringLocalization("entity.IceGhost.name", "en_US", "IceGhost");
		LanguageRegistry.instance().addStringLocalization("entity.IceGhost.name", "de_DE", "Eisgeist");
		EntityRegistry.registerGlobalEntityID(EntityIceGhost.class, "IceGhost", EntityRegistry.findGlobalUniqueEntityId(), 0x99aaff, 0x0000dd);
		
		EntityRegistry.addSpawn(EntityIceGhost.class, 30, 3, 5, EnumCreatureType.monster, MNCBiomes.biome_IceHell);
		
		
		
		//IcePigman
		LanguageRegistry.instance().addStringLocalization("entity.IcePigman.name", "en_US", "IcePigman");
		LanguageRegistry.instance().addStringLocalization("entity.IcePigman.name", "de_DE", "Minecraft-Oetzi");
		EntityRegistry.registerGlobalEntityID(EntityIcePigman.class, "IcePigman", EntityRegistry.findGlobalUniqueEntityId(), 0xff8899, 0x99aaff);
		
		EntityRegistry.addSpawn(EntityIcePigman.class, 79, 4, 8, EnumCreatureType.monster, MNCBiomes.biome_IceHell);
		
		
		//Harpye
		LanguageRegistry.instance().addStringLocalization("entity.harpye.name", "en_US", "Harpye");
		LanguageRegistry.instance().addStringLocalization("entity.harpye.name", "de_DE", "Harpye");
		EntityRegistry.registerGlobalEntityID(EntityHarpye.class, "harpye", EntityRegistry.findGlobalUniqueEntityId(), 0x190707, 0x8a0808);
		
		EntityRegistry.addSpawn(EntityHarpye.class, 79, 4, 8, EnumCreatureType.creature, new BiomeGenCrazy().me);
		
		//LightingBOlt
		EntityRegistry.registerGlobalEntityID(MNCEntityLightningBolt.class, "mnc_blitz", EntityRegistry.findGlobalUniqueEntityId());
		
		
		/**
		 * 
		 * BOSSE
		 * 
		 * */
		
		/* TODO  */
		//DaemonLord
		
		LanguageRegistry.instance().addStringLocalization("entity.DaemonLord.name", "en_US", "Daemon Lord");
		LanguageRegistry.instance().addStringLocalization("entity.DaemonLord.name", "de_DE", "Daemon Lord");
		EntityRegistry.registerGlobalEntityID(EntityDaemonLord.class, "DaemonLord", EntityRegistry.findGlobalUniqueEntityId(), 0xcccccc, 0xeeeeee);
		
		//FeuerBall
		LanguageRegistry.instance().addStringLocalization("entity.FeuerBall.name", "en_US", "FireBall");
		LanguageRegistry.instance().addStringLocalization("entity.FeuerBall.name", "de_DE", "FeuerBall");
		EntityRegistry.registerGlobalEntityID(EntityFeuerBall.class, "FeuerBall", EntityRegistry.findGlobalUniqueEntityId(), 0xcccccc, 0xeeeeee); 
		
		
		
		
		
		
		
	}

}
