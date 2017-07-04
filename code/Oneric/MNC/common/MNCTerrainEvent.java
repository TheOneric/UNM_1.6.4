package Oneric.MNC.common;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import Oneric.MNC.biomes.MNCGenLayer;

public class MNCTerrainEvent {
	
	 @ForgeSubscribe
     public void onInitBiomeGenerators(WorldTypeEvent.InitBiomeGens event)
     {
		 event.newBiomeGens = MNCGenLayer.initializeAllBiomeGenerators(event.seed, event.worldType);
     }

}
