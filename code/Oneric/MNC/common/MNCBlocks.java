package Oneric.MNC.common;

import Oneric.MNC.block.BlackStone;
import Oneric.MNC.block.BlockDeadGrass;
import Oneric.MNC.block.BlockDoor_MNC;
import Oneric.MNC.block.BlockDoor_MNC_Hidden;
import Oneric.MNC.block.BlockDungeonStone;
import Oneric.MNC.block.BlockEnchantedSoulSand;
import Oneric.MNC.block.BlockEpicNether;
import Oneric.MNC.block.BlockFenceGate_MNC;
import Oneric.MNC.block.BlockFence_MNC;
import Oneric.MNC.block.BlockFireLeaf;
import Oneric.MNC.block.BlockFireLog;
import Oneric.MNC.block.BlockFireSapling;
import Oneric.MNC.block.BlockGGlowstone;
import Oneric.MNC.block.BlockGrowGold;
import Oneric.MNC.block.BlockHellPilz;
import Oneric.MNC.block.BlockMud;
import Oneric.MNC.block.BlockNetherGold;
import Oneric.MNC.block.BlockNetherTNT;
import Oneric.MNC.block.BlockOrePlumbum;
import Oneric.MNC.block.BlockPentagram;
import Oneric.MNC.block.BlockPilz;
import Oneric.MNC.block.BlockPortalCrazy;
import Oneric.MNC.block.BlockSlab;
import Oneric.MNC.block.BlockStature;
import Oneric.MNC.block.BlockTrapDoor_MNC;
import Oneric.MNC.block.BlockTreppen;
import Oneric.MNC.block.BlockWall_MNC;
import Oneric.MNC.block.ItemBlockDungeon;
import Oneric.MNC.block.ItemBlockStature;
import Oneric.MNC.block.MNCBlock;
import Oneric.MNC.block.BlockSmog;
import Oneric.MNC.block.MNCBlockFlowing;
import Oneric.MNC.block.MNCBlockStationary;
import Oneric.MNC.block.MNCBlockTreppen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.src.ModLoader;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MNCBlocks
{
	//Name
	public static Block NetherGold;
	public static Block NetherBlock;
	public static Block Pilz;
	public static Block Pilz2;
	public static Block HellPilz_Block;
	public static Block Blackstone;
	public static Block ESSand;
	public static Block GGold;
	public static Block GGlowstone;
	public static Block Smog;
	public static Block GSlab;
	//public static Block NSlab;
	public static Block OSlab;
	public static Block GStair;
	public static Block OStair;
	public static Block GFence;
	public static Block GFenceGate;
	public static Block NFence_NEW;
	public static Block NFenceGate;
	public static Block OFence;
	public static Block OFenceGate;
	public static Block HellAltar;
	public static Block GTrapDoor;
	public static Block NTrapDoor;
	public static Block GDoor;
	public static Block NDoor;
	public static Block GDoorHidden;
	public static Block NDoorHidden;
	public static Block Stature;
	public static Block Mud;
	public static Block SchleimStill;
	public static Block SchleimFliess;
	public static Block nTNT;
	
	public static Block FireLog;
	public static Block FireLeaf;
	public static Block FireSapling;
	public static Block Netherplanks;
	public static Block NWDoor;
	public static Block NWFence;
	public static Block NWFenceGate;
	public static Block NWStairs;
	public static Block NWSlab;
	
	public static Block NWall;
	public static Block GWall;
	public static Block OWall;
	public static Block NWWall;
	
	public static BlockPortalCrazy PortalCrazy;
	public static Block deadDirt;
	public static Block deadGrass;
	public static Block DeadStone;
	public static Block orePlumbum;
	
	public static Block dungeonStone;
	
	
	
	public MNCBlocks()
	{
	
	//Setter
    NetherGold = new BlockNetherGold(mod_netherbr.NetherGoldID, Material.rock).setHardness(0.8F).setUnlocalizedName("mnc_goldOre").setCreativeTab(CreativeTabs.tabBlock);
    NetherBlock = new BlockEpicNether(mod_netherbr.NetherBlockID).setHardness(1.3F).setUnlocalizedName("mnc_epicNetherBlock").setCreativeTab(CreativeTabs.tabBlock);
    Pilz = new BlockPilz(mod_netherbr.PilzID).setUnlocalizedName("mnc_netherMushroomBlockOne").setHardness(1.0F).setLightValue(0.3F);
    Pilz2 = new BlockPilz(mod_netherbr.Pilz2ID).setUnlocalizedName("mnc_netherMushroomBlockTwo").setHardness(1.0F).setLightValue(0.3F);
    HellPilz_Block = new BlockHellPilz(mod_netherbr.HellPilz_BlockID).setUnlocalizedName("mnc_HellPilz").setStepSound(Block.soundWoodFootstep).setHardness(1.3F);
    Blackstone = new BlackStone(mod_netherbr.BlackstoneID, Material.rock).setUnlocalizedName("mnc_BlackStone").setHardness(1.5F).setLightValue(0.4F);
    ESSand = new BlockEnchantedSoulSand(mod_netherbr.ESSandID).setUnlocalizedName("mnc_ESS").setHardness(0.3F).setLightValue(0.4F).setStepSound(Block.soundSandFootstep);
    GGold = new BlockGrowGold(mod_netherbr.GGoldID, Material.rock).setUnlocalizedName("mnc_growingGold").setHardness(0.1F);
    GGlowstone = new BlockGGlowstone(mod_netherbr.GGlowstoneID, Material.rock).setUnlocalizedName("mnc_growingGlowstone").setHardness(0.2F).setLightValue(1.0F);
    Smog = (new BlockSmog(mod_netherbr.SmogID)).setUnlocalizedName("mnc_Smog");
    GSlab = new BlockSlab(mod_netherbr.GSlabID,  false).setUnlocalizedName("mnc_glowstoneSlab").setLightValue(1F).setStepSound(Block.soundGlassFootstep).setHardness(0.6F);
    //NSlab = new BlockSlab(mod_netherbr.NSlabID, 224,  false).setUnlocalizedName("mnc_Netherbrick Slab").setHardness(1.3F);
    OSlab = new BlockSlab(mod_netherbr.OSlabID, true).setUnlocalizedName("mnc_obsidianSlab").setHardness(5F).setResistance(200F);
    GStair = new BlockTreppen(mod_netherbr.GStairID, Block.glowStone, false).setUnlocalizedName("mnc_GStair").setLightValue(1F);
    OStair = new BlockTreppen(mod_netherbr.OStairID, Block.obsidian, true).setUnlocalizedName("mnc_OStair").setHardness(5F).setResistance(200F);
    GFence = new BlockFence_MNC(mod_netherbr.GFenceID, false).setUnlocalizedName("mnc_GFence").setLightValue(1F).setHardness(0.6F).setStepSound(Block.soundGlassFootstep);
    GFenceGate = new BlockFenceGate_MNC(mod_netherbr.GFenceGateID, false).setUnlocalizedName("mnc_GFenceGate").setLightValue(1.0F).setHardness(0.6F).setStepSound(Block.soundGlassFootstep);
    Block.blocksList[Block.netherFence.blockID] = null;
    NFence_NEW = new BlockFence_MNC(113, false).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mnc_netherFence");
    NFenceGate = new BlockFenceGate_MNC(mod_netherbr.NFenceGateID, false).setUnlocalizedName("mnc_NFenceGate").setHardness(1.3F);
    OFence = new BlockFence_MNC(mod_netherbr.OFenceID, true).setUnlocalizedName("mnc_OFence").setHardness(5F).setResistance(200F);
    OFenceGate = new BlockFenceGate_MNC(mod_netherbr.OFenceGateID, true).setUnlocalizedName("mnc_OFenceGate").setHardness(5F).setResistance(200F);
    GameRegistry.registerTileEntity(TileEntityHellAltar.class, "HellAltar");
    HellAltar = new BlockPentagram(mod_netherbr.HellAltarID, Oneric.MNC.common.TileEntityHellAltar.class).setUnlocalizedName("mnc_HellAltar").setHardness(2F);
    GTrapDoor = new BlockTrapDoor_MNC(mod_netherbr.GTrapDoorID, Material.rock).setUnlocalizedName("mnc_GTrapDoor").setLightValue(1F).setStepSound(Block.soundGlassFootstep);
    NTrapDoor = new BlockTrapDoor_MNC(mod_netherbr.NTrapDoorID, Material.rock).setUnlocalizedName("mnc_NTrapDoor").setHardness(2F).setResistance(10F);
    GDoor = new BlockDoor_MNC(mod_netherbr.GDoorID, Material.glass).setUnlocalizedName("mnc_GDoor").setLightValue(1F).setHardness(0.6F).setStepSound(Block.soundGlassFootstep);
    NDoor = new BlockDoor_MNC(mod_netherbr.NDoorID, Material.rock).setUnlocalizedName("mnc_NDoor").setHardness(2F).setResistance(10F);
    GDoorHidden = new BlockDoor_MNC_Hidden(mod_netherbr.GDoorHiddenID, Material.glass).setUnlocalizedName("mnc_GDoorHidden").setLightValue(1F).setHardness(0.6F).setStepSound(Block.soundGlassFootstep);
    NDoorHidden = new BlockDoor_MNC_Hidden(mod_netherbr.NDoorHiddenID, Material.rock).setUnlocalizedName("mnc_NDoorHidden").setHardness(2F).setResistance(10F);
    Stature = new BlockStature(mod_netherbr.StatureID, Oneric.MNC.common.TileEntityStatur.class).setUnlocalizedName("mnc_Stature");
    Mud = new BlockMud(mod_netherbr.MudID).setUnlocalizedName("mnc_Mud").setHardness(1F).setResistance(2F).setStepSound(Block.soundSandFootstep);
    SchleimStill = new MNCBlockStationary(mod_netherbr.SchleimStillID, Material.lava).setUnlocalizedName("mnc_Schleim1").setLightValue(0.5F);
    SchleimFliess = new MNCBlockFlowing(mod_netherbr.SchleimFliessID, Material.lava).setUnlocalizedName("mnc_Schleim2").setLightValue(0.5F);
    nTNT = new BlockNetherTNT(mod_netherbr.nTNTID).setUnlocalizedName("mnc_nTNT").setStepSound(Block.soundPowderFootstep);
    FireLog = new BlockFireLog(mod_netherbr.FireLogID).setUnlocalizedName("mnc_FireLog").setHardness(7F).setLightValue(0.3F).setResistance(4F);
    FireLeaf = new BlockFireLeaf(mod_netherbr.FireLeafID).setUnlocalizedName("mnc_FireLeaf").setLightValue(0.3F).setHardness(0.5F);
    FireSapling = new BlockFireSapling(mod_netherbr.FireSaplingID).setUnlocalizedName("mnc_FireSapling").setLightValue(0.3F).setHardness(0.5F);
    Netherplanks = new MNCBlock(mod_netherbr.NetherplanksID, Material.wood).setUnlocalizedName("mnc_NWPlanks").setHardness(6F).setResistance(3.5F).setStepSound(Block.soundWoodFootstep);
    NWDoor = new BlockDoor_MNC(mod_netherbr.NWDoorID, Material.wood).setUnlocalizedName("mnc_NWDoor").setHardness(5F).setResistance(3.4F).setStepSound(Block.soundWoodFootstep);
    NWFence = new BlockFence_MNC(mod_netherbr.NWFenceID, Material.wood, false).setUnlocalizedName("mnc_NWFence").setHardness(6F).setResistance(3.5F).setStepSound(Block.soundWoodFootstep);
    NWFenceGate = new BlockFenceGate_MNC(mod_netherbr.NWFenceGateID, false).setUnlocalizedName("mnc_NWFenceG").setHardness(6F).setResistance(3.5F).setStepSound(Block.soundWoodFootstep);
    NWStairs = new MNCBlockTreppen(mod_netherbr.NWStairsID, MNCBlocks.Netherplanks, false).setUnlocalizedName("mnc_NWStairs").setHardness(6F).setResistance(3.5F).setStepSound(Block.soundWoodFootstep);
    NWSlab = new BlockSlab(mod_netherbr.NWSlabID,  false).setUnlocalizedName("mnc_NWSlab").setHardness(6F).setResistance(3.5F).setStepSound(Block.soundWoodFootstep);
    NWall = new BlockWall_MNC(mod_netherbr.NWallID,  Block.netherBrick, false).setResistance(10.0F).setStepSound(Block.soundStoneFootstep).setUnlocalizedName("mnc_netherWall");
    GWall = new BlockWall_MNC(mod_netherbr.GWallID,  Block.glowStone, false).setUnlocalizedName("mnc_GWall").setLightValue(1F).setStepSound(Block.soundGlassFootstep).setHardness(0.6F);;
    OWall = new BlockWall_MNC(mod_netherbr.OWallID, Block.obsidian, true).setUnlocalizedName("mnc_OWall").setHardness(5F).setResistance(200F);
    NWWall = new BlockWall_MNC(mod_netherbr.NWWallID, this.Netherplanks, false).setHardness(6F).setResistance(3.5F).setStepSound(Block.soundWoodFootstep).setUnlocalizedName("mnc_NWWall");
    PortalCrazy = (BlockPortalCrazy)(new BlockPortalCrazy(mod_netherbr.PortalCrazyID).setUnlocalizedName("mnc_portal").setStepSound(Block.soundGlassFootstep));
    deadDirt = new MNCBlock(mod_netherbr.deadDirtID, Material.ground).setUnlocalizedName("mnc_deadDirt").setStepSound(Block.soundGravelFootstep);
    deadGrass = new BlockDeadGrass(mod_netherbr.deadGrassID).setUnlocalizedName("mnc_deadGrass").setStepSound(Block.soundGravelFootstep);
    DeadStone = new MNCBlock(mod_netherbr.DeadStoneID, Material.rock).setUnlocalizedName("mnc_deadStone").setStepSound(Block.soundStoneFootstep).setHardness(1.5F).setResistance(2.0F);
    orePlumbum = new BlockOrePlumbum(mod_netherbr.orePlumbumID, Material.rock).setUnlocalizedName("mnc_orePlumbum").setHardness(4F).setResistance(6F);
   /*TODO*/ dungeonStone = new BlockDungeonStone(mod_netherbr.dungeonStoneID).setUnlocalizedName("mnc_dungeonStone").setLightValue(0.2F);
    
    
    
    
    
    //Register
    GameRegistry.registerBlock(NetherGold);
    GameRegistry.registerBlock(NetherBlock);
    GameRegistry.registerBlock(Pilz);
    GameRegistry.registerBlock(Pilz2);
    GameRegistry.registerBlock(HellPilz_Block);
    GameRegistry.registerBlock(Blackstone);
    GameRegistry.registerBlock(ESSand);
    GameRegistry.registerBlock(GGold);
    GameRegistry.registerBlock(GGlowstone);
    GameRegistry.registerBlock(Smog);
    GameRegistry.registerBlock(GSlab);
    //GameRegistry.registerBlock(NSlab);
    GameRegistry.registerBlock(OSlab);
    GameRegistry.registerBlock(GStair);
    GameRegistry.registerBlock(OStair);
    GameRegistry.registerBlock(GFence);
    GameRegistry.registerBlock(GFenceGate);
    GameRegistry.registerBlock(NFence_NEW);
    GameRegistry.registerBlock(NFenceGate);
    GameRegistry.registerBlock(OFence);
    GameRegistry.registerBlock(OFenceGate);
    GameRegistry.registerBlock(HellAltar);
    GameRegistry.registerBlock(GTrapDoor);
    GameRegistry.registerBlock(NTrapDoor);
    GameRegistry.registerBlock(GDoor);
    GameRegistry.registerBlock(NDoor);
    GameRegistry.registerBlock(Mud);
    GameRegistry.registerBlock(nTNT);
    GameRegistry.registerBlock(FireLog);
    GameRegistry.registerBlock(FireLeaf);
    GameRegistry.registerBlock(FireSapling);
    GameRegistry.registerBlock(Netherplanks);
    GameRegistry.registerBlock(NWDoor);
    GameRegistry.registerBlock(NWFence);
    GameRegistry.registerBlock(NWFenceGate);
    GameRegistry.registerBlock(NWStairs);
    GameRegistry.registerBlock(NWSlab);
    GameRegistry.registerBlock(NWall);
    GameRegistry.registerBlock(GWall);
    GameRegistry.registerBlock(OWall);
    GameRegistry.registerBlock(NWWall);
    GameRegistry.registerBlock(PortalCrazy);
    GameRegistry.registerBlock(deadDirt);
    GameRegistry.registerBlock(deadGrass);
    GameRegistry.registerBlock(DeadStone);
    GameRegistry.registerBlock(orePlumbum);
    GameRegistry.registerBlock(Stature, ItemBlockStature.class);
    /*TODO*/ GameRegistry.registerBlock(dungeonStone, ItemBlockDungeon.class);
    
    
    
    
    /**
     * 
     * Texture
     * 
     * */
    /*
    //custom
    NetherGold.blockIndexInTexture = 0;
    Blackstone.blockIndexInTexture = 1;
    ESSand.blockIndexInTexture = 2;
    NDoor.blockIndexInTexture = (6 + 16);
    GDoor.blockIndexInTexture = (7 + 16);
    NTrapDoor.blockIndexInTexture = 8;
    GTrapDoor.blockIndexInTexture = 9;
    Smog.blockIndexInTexture = 10;
    GGold.blockIndexInTexture = 11;
    GGlowstone.blockIndexInTexture = 12;
    Pilz.blockIndexInTexture = 13;
    Pilz2.blockIndexInTexture = 14;
    NetherBlock.blockIndexInTexture = 15;
    HellAltar.blockIndexInTexture = 16;
    Mud.blockIndexInTexture = 18;
    FireLog.blockIndexInTexture = 19;
    FireSapling.blockIndexInTexture = 24;
    Netherplanks.blockIndexInTexture = 25;
    NWDoor.blockIndexInTexture = (26 + 16);
    //PortalCrazy.blockIndexInTexture = 27;
    deadDirt.blockIndexInTexture = 28;
    deadGrass.blockIndexInTexture = 29;
    DeadStone.blockIndexInTexture = 30;
    orePlumbum.blockIndexInTexture = 31;
    dungeonStone.blockIndexInTexture = 33;
    
    //standart && unregistert yet
    GDoorHidden.blockIndexInTexture = 105;
    NDoorHidden.blockIndexInTexture = 224;
    */
    
    
    
    /**
     * 
     * Language
     * 
     * */
    
    //English(prefer British)
    LanguageRegistry.addName(NetherGold, "Gold Ore");
    LanguageRegistry.addName(NetherBlock, "Epic Nether Block");
    LanguageRegistry.addName(Pilz, "Nether Mushroom Block");
    LanguageRegistry.addName(Pilz2, "Nether Mushroom Block");
    LanguageRegistry.addName(HellPilz_Block, "Hell Pilz Block");
    LanguageRegistry.addName(Blackstone, "Black Stone");
    LanguageRegistry.addName(ESSand, "Enchanted Soulsand");
    LanguageRegistry.addName(GGold, "Growing Gold");
    LanguageRegistry.addName(GGlowstone, "Growing Gold");
   // LanguageRegistry.addName(new ItemStack(Aercloud, 1, 0), "Cold Aercloud");
    //LanguageRegistry.addName(new ItemStack(Aercloud, 1, 1), "Blue Aercloud");
    //LanguageRegistry.addName(new ItemStack(Aercloud, 1, 2), "Gold Aercloud");
    LanguageRegistry.addName(Smog, "Smog");
    
    LanguageRegistry.addName(GSlab, "Glowstone Slab");
    //LanguageRegistry.addName(NSlab, "Netherbrick Slab");
    LanguageRegistry.addName(OSlab, "Obsidian Slab");
    LanguageRegistry.addName(GStair, "Glowstone Stair");
    LanguageRegistry.addName(OStair, "Obsidian Stair");
    LanguageRegistry.addName(GFence, "Glowstone Fence");
    LanguageRegistry.addName(GFenceGate, "Glowstone Fence Gate");
    LanguageRegistry.addName(NFence_NEW, "Netherbrick Fence");
    LanguageRegistry.addName(NFenceGate, "Netherbrick Fence Gate");
    LanguageRegistry.addName(OFence, "Obsidian Fence");
    LanguageRegistry.addName(OFenceGate, "Obsidian Fence Gate");
    LanguageRegistry.addName(HellAltar, "Hell Altar");
    LanguageRegistry.addName(GTrapDoor, "Glowstone Trapdoor");
    LanguageRegistry.addName(NTrapDoor, "Netherbrick Trapdoor");
    LanguageRegistry.addName(GDoor, "Glowstone Door");
    LanguageRegistry.addName(NDoor, "Netherbrick Door");
    LanguageRegistry.addName(GDoorHidden, "Hidden Glowstone Door");
    LanguageRegistry.addName(NDoorHidden, "Hidden Netherbrick Door");
    LanguageRegistry.addName(Mud, "Mud");
    LanguageRegistry.addName(nTNT, "Fake TNT");
    LanguageRegistry.addName(FireLog, "Fire Wood");
    LanguageRegistry.addName(FireLeaf, "Fire Leaf");
    LanguageRegistry.addName(FireSapling, "Fire-Tree Sapling");
    LanguageRegistry.addName(Netherplanks, "Netherwood Planks");
    LanguageRegistry.addName(NWFence, "Netherwood Fence");
    LanguageRegistry.addName(NWFenceGate, "Netherwood Fencegate");
    LanguageRegistry.addName(NWStairs, "Netherwood Stairs");
    LanguageRegistry.addName(NWSlab, "Netherwood Slabs");
    LanguageRegistry.addName(NWall, "Netherbrick Wall");
    LanguageRegistry.addName(GWall, "Glowstone Wall");
    LanguageRegistry.addName(OWall, "Obsidian Wall");
    LanguageRegistry.addName(NWWall, "Netherwood Wall");
    LanguageRegistry.addName(deadGrass, "Dead grass");
    LanguageRegistry.addName(deadDirt, "Dead dirt");
    LanguageRegistry.addName(DeadStone, "Dead stone");
    LanguageRegistry.addName(orePlumbum, "Plumbum Ore");
   /*TODO*/ LanguageRegistry.addName(dungeonStone, "Dungeon Stone");
    
    
    
    //Deutsch
    LanguageRegistry.instance().addNameForObject(NetherGold,"de_DE", "Nether Gold Erz");
    LanguageRegistry.instance().addNameForObject(NetherBlock,"de_DE", "Epischer Nether Block");
    LanguageRegistry.instance().addNameForObject(Pilz,"de_DE", "Nether Pilz Block");
    LanguageRegistry.instance().addNameForObject(Pilz2,"de_DE", "Nether Pilz Block");
    LanguageRegistry.instance().addNameForObject(HellPilz_Block, "de_DE", "Hell Pilz Block");
    LanguageRegistry.instance().addNameForObject(Blackstone,"de_DE", "Schwarzer Stein");
    LanguageRegistry.instance().addNameForObject(ESSand,"de_DE", "Verzauberter Seelensand");
    LanguageRegistry.instance().addNameForObject(GGold,"de_DE", "Wachsendes Gold");
    LanguageRegistry.instance().addNameForObject(GGlowstone,"de_DE", "Wachsender Leuchtstein");
    //LanguageRegistry.addName(new ItemStack(Aercloud, 1, 0), "Cold Aercloud");
    //LanguageRegistry.addName(new ItemStack(Aercloud, 1, 1), "Blue Aercloud");
    //LanguageRegistry.addName(new ItemStack(Aercloud, 1, 2), "Gold Aercloud");
    LanguageRegistry.instance().addNameForObject(Smog, "de_DE", "Smog");
    
    LanguageRegistry.instance().addNameForObject(GSlab, "de_DE", "Leuchtstein Slab");
    //LanguageRegistry.instance().addNameForObject(NSlab, "de_DE", "Netherbrick Slab");
    LanguageRegistry.instance().addNameForObject(OSlab, "de_DE", "Obsidian Slab");
    LanguageRegistry.instance().addNameForObject(GStair, "de_DE", "Leuchtstein Treppen");
    LanguageRegistry.instance().addNameForObject(OStair, "de_DE", "Obsidian Treppen");
    LanguageRegistry.instance().addNameForObject(GFence, "de_DE", "Leuchtstein Zaun");
    LanguageRegistry.instance().addNameForObject(GFenceGate, "de_DE", "Leuchtstein Zauntor");
    LanguageRegistry.instance().addNameForObject(NFence_NEW, "de_DE", "Netherbrick Zaun");
    LanguageRegistry.instance().addNameForObject(NFenceGate, "de_DE", "Netherbrick Zauntor");
    LanguageRegistry.instance().addNameForObject(OFence, "de_DE", "Obsidian Zaun");
    LanguageRegistry.instance().addNameForObject(OFenceGate, "de_DE", "Obsidian Zauntor");
    LanguageRegistry.instance().addNameForObject(HellAltar, "de_DE", "Hoellen Altar");
    LanguageRegistry.instance().addNameForObject(GTrapDoor, "de_DE", "Leuchtstein Falltuer");
    LanguageRegistry.instance().addNameForObject(NTrapDoor, "de_DE", "Netherbrick Falltuer");
    LanguageRegistry.instance().addNameForObject(GDoor, "de_DE", "Glowstone Tuer");
    LanguageRegistry.instance().addNameForObject(NDoor, "de_DE", "Netherbrick Tuer");
    LanguageRegistry.instance().addNameForObject(GDoorHidden, "de_DE", "Versteckte Glowstone Tuer");
    LanguageRegistry.instance().addNameForObject(NDoorHidden, "de_DE", "Versteckte Netherbrick Tuer");
    LanguageRegistry.instance().addNameForObject(Mud, "de_DE", "Schlamm");
    LanguageRegistry.instance().addNameForObject(nTNT, "de_DE", "getarntes TNT");
    LanguageRegistry.instance().addNameForObject(FireLog, "de_DE", "Feuerbaumholz");
    LanguageRegistry.instance().addNameForObject(FireLeaf, "de_DE", "Feuerbaumblaetter");
    LanguageRegistry.instance().addNameForObject(FireSapling, "de_DE", "Feuerbaumsamen");
    LanguageRegistry.instance().addNameForObject(Netherplanks, "de_DE", "Netherholzbretter");
    LanguageRegistry.instance().addNameForObject(NWFence, "de_DE", "Netherholz - Zaun");
    LanguageRegistry.instance().addNameForObject(NWFenceGate, "de_DE", "Netherholz - Zauntor");
    LanguageRegistry.instance().addNameForObject(NWStairs, "de_DE", "Netherholztreppen");
    LanguageRegistry.instance().addNameForObject(NWSlab, "de_DE", "Netherholzslabs");
    LanguageRegistry.instance().addNameForObject(NWWall, "de_DE", "Netherholzmauer");
    LanguageRegistry.instance().addNameForObject(NWall, "de_DE", "Netherbrickzmauer");
    LanguageRegistry.instance().addNameForObject(GWall, "de_DE", "Leuchtsteinmauer");
    LanguageRegistry.instance().addNameForObject(OWall, "de_DE", "Obsidianmauer");
    LanguageRegistry.instance().addNameForObject(deadGrass, "de_DE", "Totes Grass");
    LanguageRegistry.instance().addNameForObject(deadDirt, "de_DE", "Verbrannte Erde");
    LanguageRegistry.instance().addNameForObject(DeadStone, "de_DE", "Verbrannter Stein");
    LanguageRegistry.instance().addNameForObject(orePlumbum, "de_DE", "Bleierz");
   /*TODO*/ LanguageRegistry.instance().addNameForObject(dungeonStone, "de_DE", "Dungeon Stein");
    
    
    
    
    
	
	}
	
}
