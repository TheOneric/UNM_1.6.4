package Oneric.MNC.common;


import net.minecraftforge.client.MinecraftForgeClient;
import Oneric.MNC.entity.IBoss;
import Oneric.MNC.world.gen.MNCWorldGen;
import Oneric.MNC.common.packets.handler.ClientPacketHandler;
import Oneric.MNC.common.packets.handler.ServerPacketHandler;
import Oneric.MNC.donator.DonatorList;
import Oneric.MNC.donator.choices.DonatorChoice;
import Oneric.MNC.donator.choices.DonatorChoices;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.SidedProxy;
import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.src.*;
import net.minecraft.util.Session;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.*;
import net.minecraftforge.common.*;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



@Mod(modid = "onerics_mnc", name = "The Ultimate Nether Mod", version = "1.8.6")
@NetworkMod(
		clientSideRequired=true, serverSideRequired=false,
		channels = {"MNC-Donator", "MNC-thunder" },
		packetHandler = ClientPacketHandler.class,
		connectionHandler = MNCConectionHandler.class
		)

//clientPacketHandlerSpec = @SidedPacketHandler(channels = {"MNC-Donator", "MNC-thunder" }, packetHandler = ClientPacketHandler.class),
		//serverPacketHandlerSpec = @SidedPacketHandler(channels = {"MNC-Donator", "MNC-thunder" }, packetHandler = ServerPacketHandler.class),



public class mod_netherbr {
	
	@SidedProxy(clientSide = "Oneric.MNC.client.ClientProxyMNC", serverSide = "Oneric.MNC.common.CommonProxyMNC")
	public static CommonProxyMNC proxy;
	@Instance
	public static mod_netherbr mod = new mod_netherbr(); 
	
	
	private GuiHandler guiHandler = new GuiHandler();
	
	
	public static IBoss currentBoss = null;
	
	public static final RenderManager renderManager = new RenderManager();
	
	public static final UpdateChecker updateChecker = new UpdateChecker();
	
	public static DonatorList donatorList = new DonatorList();
	
	public static DonatorChoices donatorChoices = new DonatorChoices();
	
	
	public static final String LOCATION_TEXTURES = "textures/";
	public static final String LOCATION_ARMOR = "textures/models/armor/";
	public static final String LOCATION_ENTITIES = "textures/entity/";
	public static final String LOCATION_GUI = "textures/gui/";
	
	
	
	public static Configuration config;
	
	 /**
        * 
        * ID's
        * 
        * */
	
	//Bloecke
	public static int NetherGoldID;
	public static int NetherBlockID;
	public static int PilzID;
	public static int Pilz2ID;
	public static int HellPilz_BlockID;
	public static int BlackstoneID;
	public static int ESSandID;
	public static int GGoldID;
	public static int GGlowstoneID;
	public static int GSlabID;
	//public static int NSlabID;
	public static int OSlabID;
	public static int GStairID;
	public static int OStairID;
	public static int GFenceID;
	public static int GFenceGateID;
	public static int NFenceGateID;
	public static int OFenceID;
	public static int OFenceGateID;
	public static int HellAltarID;
	public static int GTrapDoorID;
	public static int NTrapDoorID;
	public static int GDoorID;
	public static int NDoorID;
	public static int GDoorHiddenID;
	public static int NDoorHiddenID;
	public static int StatureID;
	public static int MudID;
	public static int SchleimStillID;
	public static int SchleimFliessID;
	public static int nTNTID;
	public static int FireLogID;
	public static int FireLeafID;
	public static int FireSaplingID;
	public static int NetherplanksID;
	public static int NWDoorID;
	public static int NWFenceID;
	public static int NWFenceGateID;
	public static int NWStairsID;
	public static int NWSlabID;
	public static int NWallID;
	public static int GWallID;
	public static int OWallID;
	public static int NWWallID;
	public static int PortalCrazyID;
	public static int deadDirtID;
	public static int deadGrassID;
	public static int SmogID;
	public static int DeadStoneID;
	public static int orePlumbumID;
	public static int dungeonStoneID;
	
	//Items
	public static int HellPilz_SamenID;
	public static int HellPilzID;
	public static int GGold_iID;
	public static int GGlowstone_iID;
	public static int GDoorItemID;
	public static int NDoorItemID;
	public static int GDoorHiddenItemID;
	public static int NDoorHiddenItemID;
	public static int netheringotID;
	public static int epicingotID;
	public static int NArrowID;
	public static int NetherstickID;
	public static int strangeID;
	public static int FireGemID;
	public static int NetherSwordID;
	public static int NetherPickaxeID;
	public static int NetherShoevelID;
	public static int NetherAxeID;
	public static int NetherHoeID;
	public static int GlowSwordID;
	public static int GlowPickaxeID;
	public static int GlowShoevelID;
	public static int GlowAxeID;
	public static int GlowHoeID;
	public static int diabloID;
	public static int NetherHelmetID;
	public static int NetherPlateID;
	public static int NetherLegID;
	public static int NetherBootsID;
	public static int GlowHelmetID;
	public static int GlowPlateID;
	public static int GlowLegID;
	public static int GlowBootsID;
	public static int Stature_iID;
	public static int NBowID;
	public static int NBucketEmptyID;
	public static int NBucketFullID;
	public static int NWDoorItemID;
	public static int ingotPlumbumID;
	public static int hammerPlumbumID;
	public static int pickaxeGravID;
	
	
	/**
	 * 
	 * Other Integers
	 * 
	 * */
	
	public static int MazeRarity;
	public static int biomeRarity;
	
	public static int achievementEnterTheHell;
	public static int achievementDefeatADaemon;
	public static int achievementEnterTheFallenSky;
	
	
	/**
	 * 
	 * Booleans
	 * 
	 * */
	 public static boolean achievementsEnabled;
	 public static boolean updateCheck;
	 public static boolean newVersionAviable = false;
	 
	 @SideOnly(Side.CLIENT)
	 public static boolean reportNewVersion; 
	 /**@SideOnly(Side.CLIENT)
	 public static Enum playerType;*/
	
	
	
	
	
	@EventHandler
    public void preLoad(FMLPreInitializationEvent fmlpreinitevent)
    {
		
		System.out.println("[UltimateNetherMod] Starting.....");
		
		if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			reportNewVersion = false;
			
			/*
			if (mod_netherbr.proxy.getClientSessionUsername() != null)
			{
				playerType = PlayerTypeCheck.checkPlayerType(mod_netherbr.proxy.getClientSessionUsername());
				//System.out.println("------------------------ " + session.username + " ------------------------");
			}
			else
			{
				FMLLog.getLogger().warning("Failed to get you username ! Even if you've donated you are a 'normal' Player at the moment");
				playerType = EnumPlayerType.NORMAL;
			}*/
		}
		
		proxy.registerSounds();
		
		
		
		 System.out.println("[UltimateNetherMod] Loading Config-File.....");
		 
		this.setUpConfig(new Configuration(fmlpreinitevent.getSuggestedConfigurationFile()));
		 
		
		
		proxy.initRenderPlayerAPI();
		 
		new MNCBlocks();
        new MNCItems();
		 
        
        if(achievementsEnabled)
        {
        	new MNCAchievements();
        }
		 
		GameRegistry.registerPlayerTracker(new MNCPlayerTracker());
		 
		 
    }
	
	
	private void setUpConfig(Configuration config)
	{
		this.config = config;
		config.load();
		 
		 /**
	         * 
	         * ID's
	         * 
	         * */
		 
		 //Bloecke
		
		 NetherGoldID = config.getBlock("NetherGold ID", 2000).getInt();
		 NetherBlockID = config.getBlock("Epic NetherBlock ID", 2001).getInt();
		 PilzID = config.getBlock("MushroomBlock ID", 2002).getInt();
		 Pilz2ID = config.getBlock("MushroomBlock2 ID", 2003).getInt();
		 HellPilz_BlockID = config.getBlock("HellMushroom Plant ID", 2004).getInt();
		 ESSandID = config.getBlock("Enchanted Soulsand ID", 2005).getInt();
		 GGoldID = config.getBlock("Growing Gold block ID", 2006).getInt();
		 GGlowstoneID = config.getBlock("Growing Glowstone block ID", 2007).getInt();
		 GSlabID = config.getBlock("Glowstone Slab ID", 2009).getInt();
		 //NSlabID = config.getBlock("NetherBrick Slab ID", 2010).getInt();
		 OSlabID = config.getBlock("Obsidian Slab ID", 2011).getInt();
		 GStairID = config.getBlock("Glowstone Stair ID", 2012).getInt();
		 OStairID = config.getBlock("Obsidian Stair ID", 2013).getInt();
		 GFenceID = config.getBlock("Glowstone Fence ID", 2014).getInt();
		 GFenceGateID = config.getBlock("Glowstone FenceGate ID", 2015).getInt();
		 NFenceGateID = config.getBlock("Netherbrick FenceGate ID", 2016).getInt();
		 OFenceID = config.getBlock("Obsidian Fence ID", 2017).getInt();
		 OFenceGateID = config.getBlock("Obsidian FenceGate ID", 2018).getInt();
		 HellAltarID = config.getBlock("Hell Altar ID", 2019).getInt();
		 GTrapDoorID = config.getBlock("Glowstone Trapdoor ID", 2020).getInt();
		 NTrapDoorID = config.getBlock("Netherbrick Trapdoor ID", 2021).getInt();
		 GDoorID = config.getBlock("Glowstone Door ID", 2022).getInt();
		 NDoorID = config.getBlock("Netherbrick Door ID", 2023).getInt();
		 GDoorHiddenID = config.getBlock("Hidden Glowstone Door ID", 2024).getInt();
		 NDoorHiddenID = config.getBlock("Hidden Netherbrick Door ID", 2025).getInt();
		 StatureID = config.getBlock("Stature ID", 2026).getInt();
		 MudID = config.getBlock("Mud ID", 2027).getInt();
		 SchleimFliessID = config.getBlock("Liquid fl ID", 2028).getInt();
		 SchleimStillID = config.getBlock("Liquid st ID", 2029).getInt();
		 nTNTID = config.getBlock("TNT ID", 2008).getInt();
		 FireLogID = config.getBlock("FireLog ID", 2030).getInt();
		 FireLeafID = config.getBlock("FireLeaf ID", 2031).getInt();
		 FireSaplingID = config.getBlock("FireSapling ID", 2032).getInt();
		 NetherplanksID = config.getBlock("Netherplanks ID", 2033).getInt();
		 NWDoorID = config.getBlock("Netherwood-Door(Block) ID", 2034).getInt();
		 NWFenceID = config.getBlock("Netherwood-Fence ID", 2035).getInt();
		 NWFenceGateID = config.getBlock("Netherwood-FenceGate ID", 2036).getInt();
		 NWStairsID = config.getBlock("Netherwood-Stairs ID", 2037).getInt();
		 NWSlabID = config.getBlock("Netherwood-Slab ID", 2038).getInt();
		 NWallID = config.getBlock("Netherbrick-Wall ID", 2039).getInt();
		 GWallID = config.getBlock("Glowstone-Wall ID", 2040).getInt();
		 OWallID = config.getBlock("Obsidian-Wall ID", 2041).getInt();
		 NWWallID = config.getBlock("Netherwood-Wall ID", 2042).getInt();
		 PortalCrazyID = config.getBlock("Portal-1 ID", 2043).getInt();
		 SmogID = config.getBlock("Smog ID", 2044).getInt();
		 orePlumbumID = config.getBlock("Plumbum Ore ID", 2045).getInt();
		 dungeonStoneID = config.getBlock("Dungeon Stone ID", 2046).getInt();
		 
		 
		 
		 config.addCustomCategoryComment(Configuration.CATEGORY_BLOCK, "DON'T change the ' < 255' Block IDs to something higher than 255 ! NEVER EVER"); 
		 BlackstoneID = config.getTerrainBlock(Configuration.CATEGORY_BLOCK, "BlackStone ID", (int)204, " < 255").getInt();
		 deadDirtID = config.getTerrainBlock(Configuration.CATEGORY_GENERAL, "dead Dirt ID", 202, " < 255").getInt();
		 deadGrassID = config.getTerrainBlock(Configuration.CATEGORY_GENERAL, "dead Grass ID", 203, " < 255").getInt();
		 DeadStoneID = config.getTerrainBlock(Configuration.CATEGORY_GENERAL, "dead Stone ID", 201, " < 255").getInt();
		 
		 
		 
		 //Items
		 HellPilz_SamenID = config.getItem("Hell Mushroom Seeds ID" , 2500).getInt();
		 HellPilzID = config.getItem("Hell Mushroom Item ID" , 2501).getInt();
		 GGold_iID = config.getItem("Growing Gold Item ID" , 2502).getInt();
		 GGlowstone_iID = config.getItem("Growing Glowstone Item ID" , 2503).getInt();
		 GDoorItemID = config.getItem("Glowstone Door Item ID" , 2504).getInt();
		 NDoorItemID = config.getItem("Netherbrick Door Item ID" , 2505).getInt();
		 GDoorHiddenItemID = config.getItem("Hidden Glowstone Door Item ID" , 2506).getInt();
		 NDoorHiddenItemID = config.getItem("Hidden Netherbrick Door Item ID" , 2507).getInt();
		 netheringotID = config.getItem("Netherignot ID" , 2508).getInt();
		 epicingotID = config.getItem("Epic Netherignot ID" , 2509).getInt();
		 NArrowID = config.getItem("NetherArrow ID" , 2510).getInt();
		 NetherstickID = config.getItem("Netherstick ID" , 2511).getInt();
		 strangeID = config.getItem("strange ID" , 2512).getInt();
		 FireGemID = config.getItem("FireGem ID" , 2513).getInt();
		 NetherSwordID = config.getItem("Nether sword ID" , 2514).getInt();
		 NetherPickaxeID = config.getItem("Nether Pickaxe ID" , 2515).getInt();
		 NetherShoevelID = config.getItem("Nether Shoevel ID" , 2516).getInt();
		 NetherAxeID = config.getItem("Nether Axe ID" , 2517).getInt();
		 NetherHoeID = config.getItem("Nether Hoe ID" , 2518).getInt();
		 GlowSwordID = config.getItem("Glowstone sword ID" , 2519).getInt();
		 GlowPickaxeID = config.getItem("Glowstone Pickaxe ID" , 2520).getInt();
		 GlowShoevelID = config.getItem("Glowstone Shoevel ID" , 2521).getInt();
		 GlowAxeID = config.getItem("Glowstone Axe ID" , 2522).getInt();
		 GlowHoeID = config.getItem("Glowstone Hoe ID" , 2523).getInt();
		 NetherHelmetID = config.getItem("Nether Helmet ID" , 2524).getInt();
		 NetherPlateID = config.getItem("Nether Plate ID" , 2525).getInt();
		 NetherLegID = config.getItem("Nether Leg ID" , 2526).getInt();
		 NetherBootsID = config.getItem("Nether Boots ID" , 2527).getInt(); 
		 GlowHelmetID = config.getItem("Glowstone Helmet ID" , 2528).getInt();
		 GlowPlateID = config.getItem("Glowstone Plate ID" , 2529).getInt();
		 GlowLegID = config.getItem("Glowstone Leg ID" , 2530).getInt();
		 GlowBootsID = config.getItem("Glowstone Boots ID" , 2531).getInt();
		 diabloID = config.getItem("Diablo ID" , 2532).getInt();
		 Stature_iID = config.getItem("Stature Item ID" , 2533).getInt();
		 NBowID = config.getItem("Nether Bow ID" , 2534).getInt();
		 NBucketEmptyID = config.getItem("Nether Bucket 1 ID" , 2535).getInt();
		 NBucketFullID = config.getItem("Nether Bucket 2 ID" , 2536).getInt();
		 NWDoorItemID = config.getItem("Netherwood-Door(Item) ID" , 2537).getInt();
		 ingotPlumbumID = config.getItem("Plumbum(Pb) ignot ID" , 2538).getInt();
		 hammerPlumbumID = config.getItem("Pb Hammer ID" , 2539).getInt();
		 pickaxeGravID = config.getItem("Pickaxe Grav ID" , 2540).getInt();
		 
		 /**
		  * 
		  * Other Integers
		  * 
		  * */
		 config.addCustomCategoryComment(Configuration.CATEGORY_GENERAL, "Higher value of the Rarity make structures rarer, deeper value more common"); 
		 MazeRarity = config.get(Configuration.CATEGORY_GENERAL, "Maze Rarity", 300).getInt();
		 biomeRarity = config.get(Configuration.CATEGORY_GENERAL, "Biome Rarity", 3).getInt();
		 achievementDefeatADaemon = config.get(Configuration.CATEGORY_GENERAL, "achievementDefeatADaemon", 2014).getInt();;
		 achievementEnterTheHell = config.get(Configuration.CATEGORY_GENERAL, "achievementEnterTheHell", 2013).getInt();;
		 achievementEnterTheFallenSky = config.get(Configuration.CATEGORY_GENERAL, "achievementEnterTheFallenSky", 2015).getInt();
		
		 
		 
		 
		 /**
		  * 
		  * Booleans
		  * 
		  * */
		 
		 achievementsEnabled = config.get(Configuration.CATEGORY_GENERAL, "enableAchievements", true).getBoolean(true);
		 updateCheck = config.get(Configuration.CATEGORY_GENERAL, "checkForUpdates", true).getBoolean(true);
		 
		 config.save();
		
	}
	
	
	
	
	
	
	
	/**EnumToolMaterial*/
	public static EnumToolMaterial epicNetherT = EnumHelper.addToolMaterial("epicnetherT", 3, 3000, 20F, 7, 10);
	public static EnumToolMaterial glowstoneT = EnumHelper.addToolMaterial("glowstoneT", 2, 40, 8F, 3, 10);
	public static EnumToolMaterial diabloT = EnumHelper.addToolMaterial("diablo", 20, 225, 15F, 10, 0);
	public static EnumToolMaterial gravityT = EnumHelper.addToolMaterial("mnc_grav", 3, 600, 8F, 4, 0);
	
	/**EnumArmorMaterial*/
	public static EnumArmorMaterial epicNetherA = EnumHelper.addArmorMaterial("epicnetherA", 34, new int[] 
			{5, 11, 6, 4}
	, 10); 
	
	public static EnumArmorMaterial glowstoneA = EnumHelper.addArmorMaterial("glowstoneA", 7, new int[]
			{2, 5, 3, 1}
	, 25);
	
	
	
	
	
	
	
	@EventHandler
	 public void load(FMLInitializationEvent event)
	 {
		//MinecraftForgeClient.preloadTexture("/img/mnc_blocks.png");
        //MinecraftForgeClient.preloadTexture("/img/mnc_items.png");
        
		
		proxy.registerRenderThings();
        
        updateChecker.checkForUpdates();
		
        // TODO Zugriff wird beim Speichern verweigert ?
        
        if(FMLCommonHandler.instance().getEffectiveSide().isClient())
		{
			this.donatorList.addMe(Minecraft.getMinecraft().getSession().getUsername());
		}
        
        
        
        /**
         * 
         * Bloecke
         * 
         * */
        
        new MNCBiomes();
        new MNCRecipes();
        
        
        

		
        proxy.registerPostRender();
        
        MinecraftForge.EVENT_BUS.register(new MNCEvent());
        //TerainGen
		MinecraftForge.TERRAIN_GEN_BUS.register(new MNCTerrainEvent());
     
        
        GameRegistry.registerWorldGenerator(new MNCWorldGen());
        
        
        NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
        
       
        
       
        /**
        EntityRegistry.registerModEntity(EntityNetherArrow.class, "NetherArrow", 1, mod_netherbr.mod, 250, 5, false);
        EntityRegistry.registerModEntity(EntityIceBall.class, "IceBall", 2, this, 250, 10, true);
        */
        
        new MNCEntities();
        
        
	  
	 }
	
	
	/**Returns the lowercase Id of the mod*/
	public static String getId()
	{
		return "onerics_mnc";
	}
	
	
	

}
