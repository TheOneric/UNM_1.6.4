package Oneric.MNC.common;

import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraft.stats.AchievementMap;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.MinecraftForge;

public class MNCAchievements {
	
	public static Achievement defeatDaemonLord;
	public static Achievement enterTheNether;
	public static Achievement enterTheFallenSky;
	
	
	public MNCAchievements()
	{
		
		enterTheNether = new Achievement(mod_netherbr.achievementEnterTheHell, "enterTheNether", 0, 0, Block.netherrack, null).registerAchievement();
		enterTheFallenSky = new Achievement(mod_netherbr.achievementEnterTheFallenSky, "enterTheFallenSky", 2, 1, MNCBlocks.deadGrass, enterTheNether).registerAchievement();
		defeatDaemonLord = new Achievement(mod_netherbr.achievementDefeatADaemon, "defeatDaemonLord", -2, 3, MNCItems.NetherSword, enterTheNether).registerAchievement();
		
		
		this.addAchievementName("defeatDaemonLord", "Defeat a Daemon Lord !");
		this.addAchievementName("enterTheNether", "Entering the Hell !");
		this.addAchievementName("enterTheFallenSky", "Entering the Fallen Sky !");
		
		this.addAchievementDesc("defeatDaemonLord", "Like a Hellboy !");
		this.addAchievementDesc("enterTheNether", "...");
		this.addAchievementDesc("enterTheFallenSky", "And then it fall..");
		
		
		
		MNCAchievementPage acPage =  new MNCAchievementPage("Ultimate Nether", new Achievement[]
				{
				
				defeatDaemonLord, enterTheNether, enterTheFallenSky
				
				});
		
		AchievementPage.registerAchievementPage(acPage);
		
		
	}
	
	
	
	private void addAchievementName(String ach, String name)
	{
	        LanguageRegistry.instance().addStringLocalization("achievement." + ach, "en_US", name);
	}

	private void addAchievementDesc(String ach, String desc)
	{
	        LanguageRegistry.instance().addStringLocalization("achievement." + ach + ".desc", "en_US", desc);
	}
	
	

}
