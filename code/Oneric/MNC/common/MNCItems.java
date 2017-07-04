package Oneric.MNC.common;

import Oneric.MNC.client.ClientProxyMNC;
import Oneric.MNC.item.ItemDoor_MNC;
import Oneric.MNC.item.ItemDoor_MNC_Hidden;
import Oneric.MNC.item.ItemDreizack;
import Oneric.MNC.item.ItemGG;
import Oneric.MNC.item.ItemNetherArrow;
import Oneric.MNC.item.ItemNetherBow;
import Oneric.MNC.item.ItemNetherBucket;
import Oneric.MNC.item.ItemPickaxeGrav;
import Oneric.MNC.item.MNCItem;
import Oneric.MNC.item.MNCItemArmor;
import Oneric.MNC.item.MNCItemAxe;
import Oneric.MNC.item.ItemFoodHellPilz;
import Oneric.MNC.item.MNCItemHoe;
import Oneric.MNC.item.MNCItemPickaxe;
import Oneric.MNC.item.MNCItemSeeds;
import Oneric.MNC.item.MNCItemSpade;
import Oneric.MNC.item.MNCItemSword;
import Oneric.MNC.item.MNCItem_epic;
import Oneric.MNC.item.MNCItem_rare;
import Oneric.MNC.item.MNCItem_uncommon;
import Oneric.MNC.item.ItemPlumbumHammer;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class MNCItems {
	
	
	
	
	
	
	//Name
	public static Item HellPilz_Samen;
	public static Item HellPilz;
	public static Item GGold_i;
	public static Item GGlowstone_i;
	public static Item GDoorItem;
	public static Item NDoorItem;
	public static Item GDoorHiddenItem;
	public static Item NDoorHiddenItem;
	public static Item netheringot;
	public static Item epicingot;
	public static Item NArrow;
	public static Item Netherstick;
	public static Item strange;
	public static Item FireGem;
	
	public static Item NetherSword;
	public static Item NetherPickaxe;
	public static Item NetherShoevel;
	public static Item NetherAxe;
	public static Item NetherHoe;
	public static Item GlowSword;
	public static Item GlowPickaxe;
	public static Item GlowShoevel;
	public static Item GlowAxe;
	public static Item GlowHoe;
	public static Item diablo;
	
	public static Item NetherHelmet;
	public static Item NetherPlate;
	public static Item NetherLeg;
	public static Item NetherBoots;
	public static Item GlowHelmet;
	public static Item GlowPlate;
	public static Item GlowLeg;
	public static Item GlowBoots;
	
	public static Item Stature_i;
	public static Item NBow;
	public static Item NBucketEmpty;
	public static Item NBucketFull;
	
	public static Item NWDoorItem;
	public static Item ingotPlumbum;
	public static Item hammerPlumbum;
	
	/*TODO*/ public static Item pickaxeGrav;
	
	

	
	
	
	public MNCItems()
	{
		
		//Setter
		HellPilz_Samen = new MNCItemSeeds(mod_netherbr.HellPilz_SamenID, MNCBlocks.HellPilz_Block.blockID, Block.netherrack.blockID).setUnlocalizedName("mnc_hellPilzSeed").setMaxStackSize(64).setCreativeTab(CreativeTabs.tabMaterials);
		HellPilz = new ItemFoodHellPilz(mod_netherbr.HellPilzID,  1, 200F, false).setUnlocalizedName("mnc_NetherMushroom").setMaxStackSize(16);
		
		GGold_i = new ItemGG(mod_netherbr.GGold_iID, MNCBlocks.GGold).setUnlocalizedName("mnc_growing-Gold");
		GGlowstone_i = new ItemGG(mod_netherbr.GGlowstone_iID, MNCBlocks.GGlowstone).setUnlocalizedName("mnc_growing-Glowstone");
		GDoorItem = new ItemDoor_MNC(mod_netherbr.GDoorItemID, Material.glass).setUnlocalizedName("mnc_gDoor");
		NDoorItem = new ItemDoor_MNC(mod_netherbr.NDoorItemID, Material.rock).setUnlocalizedName("mnc_nDoor");
		GDoorHiddenItem = new ItemDoor_MNC_Hidden(mod_netherbr.GDoorHiddenItemID, Material.glass).setUnlocalizedName("mnc_gHDoor");
		NDoorHiddenItem = new ItemDoor_MNC_Hidden(mod_netherbr.NDoorHiddenItemID, Material.rock).setUnlocalizedName("mnc_nHDoor");
		netheringot = new MNCItem(mod_netherbr.netheringotID).setUnlocalizedName("mnc_ignot1").setCreativeTab(CreativeTabs.tabMaterials);
		epicingot = new MNCItem(mod_netherbr.epicingotID).setUnlocalizedName("mnc_ignot2").setCreativeTab(CreativeTabs.tabMaterials);
		NArrow = new ItemNetherArrow(mod_netherbr.NArrowID).setUnlocalizedName("mnc_NArrow").setCreativeTab(CreativeTabs.tabCombat);
		Netherstick = new MNCItem_uncommon(mod_netherbr.NetherstickID).setUnlocalizedName("mnc_Netherstick");
		strange = new MNCItem_rare(mod_netherbr.strangeID).setUnlocalizedName("mnc_strange");
		FireGem = new MNCItem_epic(mod_netherbr.FireGemID).setUnlocalizedName("mnc_FireGem");
		
		NetherSword = new MNCItemSword(mod_netherbr.NetherSwordID, mod_netherbr.epicNetherT, false).setUnlocalizedName("mnc_nSword");
		NetherPickaxe = new MNCItemPickaxe(mod_netherbr.NetherPickaxeID, mod_netherbr.epicNetherT).setUnlocalizedName("mnc_nPickaxe");
		NetherShoevel = new MNCItemSpade(mod_netherbr.NetherShoevelID, mod_netherbr.epicNetherT).setUnlocalizedName("mnc_nShoevel");
		NetherAxe = new MNCItemAxe(mod_netherbr.NetherAxeID, mod_netherbr.epicNetherT).setUnlocalizedName("mnc_nAxe");
		NetherHoe = new MNCItemHoe(mod_netherbr.NetherHoeID, mod_netherbr.epicNetherT).setUnlocalizedName("mnc_nHoe");
		GlowSword = new MNCItemSword(mod_netherbr.GlowSwordID, mod_netherbr.glowstoneT, true).setUnlocalizedName("mnc_gSword");
		GlowPickaxe = new MNCItemPickaxe(mod_netherbr.GlowPickaxeID, mod_netherbr.glowstoneT).setUnlocalizedName("mnc_gPickaxe");
		GlowShoevel = new MNCItemSpade(mod_netherbr.GlowShoevelID, mod_netherbr.glowstoneT).setUnlocalizedName("mnc_gShoevel");
		GlowAxe = new MNCItemAxe(mod_netherbr.GlowAxeID, mod_netherbr.glowstoneT).setUnlocalizedName("mnc_gAxe");
		GlowHoe = new MNCItemHoe(mod_netherbr.GlowHoeID, mod_netherbr.glowstoneT).setUnlocalizedName("mnc_gHoe");
		diablo = new ItemDreizack(mod_netherbr.diabloID, mod_netherbr.diabloT).setUnlocalizedName("mnc_diablo");
		
		
		NetherHelmet = new MNCItemArmor(mod_netherbr.NetherHelmetID, mod_netherbr.epicNetherA, mod_netherbr.proxy.armor_nether, 0).setUnlocalizedName("mnc_nHelmet");
		NetherPlate = new MNCItemArmor(mod_netherbr.NetherPlateID, mod_netherbr.epicNetherA, mod_netherbr.proxy.armor_nether, 1).setUnlocalizedName("mnc_nPlate");
		NetherLeg = new MNCItemArmor(mod_netherbr.NetherLegID, mod_netherbr.epicNetherA, mod_netherbr.proxy.armor_nether, 2).setUnlocalizedName("mnc_nLeg");
		NetherBoots = new MNCItemArmor(mod_netherbr.NetherBootsID, mod_netherbr.epicNetherA, mod_netherbr.proxy.armor_nether, 3).setUnlocalizedName("mnc_nBoots");
		
		GlowHelmet = new MNCItemArmor(mod_netherbr.GlowHelmetID, mod_netherbr.glowstoneA, mod_netherbr.proxy.armor_glowstone, 0).setUnlocalizedName("mnc_gHelmet");
		GlowPlate = new MNCItemArmor(mod_netherbr.GlowPlateID, mod_netherbr.glowstoneA, mod_netherbr.proxy.armor_glowstone, 1).setUnlocalizedName("mnc_gPlate");
		GlowLeg = new MNCItemArmor(mod_netherbr.GlowLegID, mod_netherbr.glowstoneA, mod_netherbr.proxy.armor_glowstone, 2).setUnlocalizedName("mnc_gLeg");
		GlowBoots = new MNCItemArmor(mod_netherbr.GlowBootsID, mod_netherbr.glowstoneA, mod_netherbr.proxy.armor_glowstone, 3).setUnlocalizedName("mnc_gBoots");
		
		Stature_i = new ItemGG(mod_netherbr.Stature_iID, MNCBlocks.Stature).setUnlocalizedName("mnc_Statue").setCreativeTab(CreativeTabs.tabDecorations);
		NBow = new ItemNetherBow(mod_netherbr.NBowID).setUnlocalizedName("mnc_NBow");
		NBucketEmpty = new ItemNetherBucket(mod_netherbr.NBucketEmptyID, 0).setUnlocalizedName("mnc_NBucketEmpty");
		NBucketFull = new ItemNetherBucket(mod_netherbr.NBucketFullID, MNCBlocks.SchleimFliess.blockID).setUnlocalizedName("mnc_NBucketFull");
		
		NWDoorItem = new ItemDoor_MNC(mod_netherbr.NWDoorItemID, Material.wood).setUnlocalizedName("mnc_NWDoorItem");
		ingotPlumbum = new MNCItem(mod_netherbr.ingotPlumbumID).setUnlocalizedName("mnc_ignotPb");
		hammerPlumbum = new ItemPlumbumHammer(mod_netherbr.hammerPlumbumID).setUnlocalizedName("mnc_hammerPb");
		
		/** TODO*/   pickaxeGrav = new ItemPickaxeGrav(mod_netherbr.pickaxeGravID, mod_netherbr.gravityT).setUnlocalizedName("mnc_pickaxeGrav");
		
		
		
		/*
		
		//Texture
		NetherHelmet.setIconIndex(0);
		GlowHelmet.setIconIndex(1);
		netherignot.setIconIndex(2);
		epicignot.setIconIndex(3);
		HellPilz_Samen.setIconIndex(4);
		HellPilz.setIconIndex(5);
		Netherstick.setIconIndex(6);
		FireGem.setIconIndex(7);
		strange.setIconIndex(8);
		GGold_i.setIconIndex(9);
		GGlowstone_i.setIconIndex(10);
		Stature_i.setIconIndex(11);
		NDoorItem.setIconIndex(12);
		NDoorHiddenItem.setIconIndex(13);
		GDoorItem.setIconIndex(14);
		GDoorHiddenItem.setIconIndex(15);
		NetherPlate.setIconIndex(16);
		GlowPlate.setIconIndex(17);
		NBow.setIconIndex(18);
		NArrow.setIconIndex(19);
		diablo.setIconIndex(20);
		NBucketEmpty.setIconIndex(21);
		NBucketFull.setIconIndex(22);
		
		NWDoorItem.setIconIndex(23);
		ignotPlumbum.setIconIndex(24);
		hammerPlumbum.setIconIndex(25);
		
		NetherLeg.setIconIndex(32);
		GlowLeg.setIconIndex(33);
		NetherBoots.setIconIndex(48);
		GlowBoots.setIconIndex(49);
		NetherSword.setIconIndex(64);
		GlowSword.setIconIndex(65);
		NetherShoevel.setIconIndex(80);
		GlowShoevel.setIconIndex(81);
		NetherPickaxe.setIconIndex(96);
		GlowPickaxe.setIconIndex(97);
		NetherAxe.setIconIndex(112);
		GlowAxe.setIconIndex(113);
		NetherHoe.setIconIndex(128);
		GlowHoe.setIconIndex(129);
		
		*/
		
	
		
		
		
		/**
		 * 
		 * Language
		 * 
		 * */
		
		//English
		LanguageRegistry.addName(HellPilz_Samen, "Nether Mushroom Seeds");
		LanguageRegistry.addName(HellPilz, "Nether Mushroom");
		LanguageRegistry.addName(GGold_i, "Growing Gold");
		LanguageRegistry.addName(GGlowstone_i, "Growing Glowstone");
		LanguageRegistry.addName(GDoorItem, "Glowstone Door");
		LanguageRegistry.addName(NDoorItem, "Netherbrick Door");
		LanguageRegistry.addName(GDoorHiddenItem, "Hidden Glowstone Door");
		LanguageRegistry.addName(NDoorHiddenItem, "Hidden Netherbrick Door");
		LanguageRegistry.addName(netheringot, "Netheringot");
		LanguageRegistry.addName(epicingot, "Epic Netheringot");
		LanguageRegistry.addName(NArrow, "Nether Arrow");
		LanguageRegistry.addName(Netherstick, "Netherstick");
		LanguageRegistry.addName(strange, "A very strange thing");
		LanguageRegistry.addName(FireGem, "Firegem");
		LanguageRegistry.addName(NetherSword, "Epic Nether Sword");
		LanguageRegistry.addName(NetherPickaxe, "Epic Nether Pickaxe");
		LanguageRegistry.addName(NetherShoevel, "Epic Nether Shoevel");
		LanguageRegistry.addName(NetherAxe, "Epic Nether Axe");
		LanguageRegistry.addName(NetherHoe, "Epic Nether Hoe");
		LanguageRegistry.addName(GlowSword, "Glowstone Sword");
		LanguageRegistry.addName(GlowPickaxe, "Glowstone Pickaxe");
		LanguageRegistry.addName(GlowShoevel, "Glowstone Shoevel");
		LanguageRegistry.addName(GlowAxe, "Glowstone Axe");
		LanguageRegistry.addName(GlowHoe, "Glowstone Hoe");
		LanguageRegistry.addName(diablo, "Diablo");
		LanguageRegistry.addName(NetherHelmet, "Epic Nether Helmet");
		LanguageRegistry.addName(NetherPlate, "Epic Nether Plate");
		LanguageRegistry.addName(NetherLeg, "Epic Nether Leg");
		LanguageRegistry.addName(NetherBoots, "Epic Nether Boots");
		LanguageRegistry.addName(GlowHelmet, "Glowstone Helmet");
		LanguageRegistry.addName(GlowPlate, "Glowstone Plate");
		LanguageRegistry.addName(GlowLeg, "Glowstone Leg");
		LanguageRegistry.addName(GlowBoots, "Glowstone Boots");
		LanguageRegistry.addName(Stature_i, "Statue");
		LanguageRegistry.addName(NBow, "Burning Nether Bow");
		LanguageRegistry.addName(NBucketEmpty, "Nether Bucket");
		LanguageRegistry.addName(NBucketFull, "Nether Slime");
		LanguageRegistry.addName(NWDoorItem, "Netherwood Door");
		LanguageRegistry.addName(ingotPlumbum, "Plumbum ingot");
		LanguageRegistry.addName(hammerPlumbum, "Plumbum Hammer");
		/** TODO*/  LanguageRegistry.addName(pickaxeGrav, "Gravitation Pickaxe");
		
		
		//Deutsch
		LanguageRegistry.instance().addNameForObject(HellPilz_Samen, "de_DE", "Nether Pilz Samen");
		LanguageRegistry.instance().addNameForObject(HellPilz, "de_DE", "Nether Pilz");
		LanguageRegistry.instance().addNameForObject(GGold_i, "de_DE", "Wachsendes Gold");
		LanguageRegistry.instance().addNameForObject(GGlowstone_i, "de_DE", "Wachsender Leuchtstein");
		LanguageRegistry.instance().addNameForObject(GDoorItem, "de_DE", "Leuchtstein Tuer");
		LanguageRegistry.instance().addNameForObject(NDoorItem, "de_DE", "Netherbrick Tuer");
		LanguageRegistry.instance().addNameForObject(GDoorHiddenItem, "de_DE", "Versteckte Leuchtstein Tuer");
		LanguageRegistry.instance().addNameForObject(NDoorHiddenItem, "de_DE", "Versteckte Netherbrick Tuer");
		LanguageRegistry.instance().addNameForObject(netheringot, "de_DE", "Netherbarren");
		LanguageRegistry.instance().addNameForObject(epicingot, "de_DE", "Epischer Netherbarren");
		LanguageRegistry.instance().addNameForObject(NArrow, "de_DE", "Nether Pfeil");
		LanguageRegistry.instance().addNameForObject(Netherstick, "de_DE", "Netherstab");
		LanguageRegistry.instance().addNameForObject(strange, "de_DE", "Ein wirklich seltsames Ding");
		LanguageRegistry.instance().addNameForObject(FireGem, "de_DE", "Feuerkristall");
		LanguageRegistry.instance().addNameForObject(NetherSword, "de_DE", "Episches Nether Schwert");
		LanguageRegistry.instance().addNameForObject(NetherPickaxe, "de_DE", "Epische Nether Spitzhacke");
		LanguageRegistry.instance().addNameForObject(NetherShoevel, "de_DE", "Epische Nether Schaufel");
		LanguageRegistry.instance().addNameForObject(NetherAxe, "de_DE", "Epische Nether Axt");
		LanguageRegistry.instance().addNameForObject(NetherHoe, "de_DE", "Epische Nether Feldhacke");
		LanguageRegistry.instance().addNameForObject(GlowSword, "de_DE", "Leuchtstein Schwert");
		LanguageRegistry.instance().addNameForObject(GlowPickaxe, "de_DE", "Leuchtstein Spitzhacke");
		LanguageRegistry.instance().addNameForObject(GlowAxe, "de_DE", "Leuchtstein Axt");
		LanguageRegistry.instance().addNameForObject(GlowHoe, "de_DE", "Leuchtstein Feldhacke");
		LanguageRegistry.instance().addNameForObject(diablo, "de_DE", "Diablo");
		LanguageRegistry.instance().addNameForObject(NetherHelmet, "de_DE", "Epischer Nether Helm");
		LanguageRegistry.instance().addNameForObject(NetherPlate, "de_DE", "Epischer Nether Brustpanzer");
		LanguageRegistry.instance().addNameForObject(NetherLeg, "de_DE", "Epische Nether Hose");
		LanguageRegistry.instance().addNameForObject(NetherBoots, "de_DE", "Epische Nether Stiefel");
		LanguageRegistry.instance().addNameForObject(GlowHelmet, "de_DE", "Leuchtstein Helm");
		LanguageRegistry.instance().addNameForObject(GlowPlate, "de_DE", "Leuchtstein Brustpanzer");
		LanguageRegistry.instance().addNameForObject(GlowLeg, "de_DE", "Leuchtstein Hose");
		LanguageRegistry.instance().addNameForObject(GlowBoots, "de_DE", "Leuchtstein Stiefel");
		LanguageRegistry.instance().addNameForObject(Stature_i, "de_DE", "Stature");
		LanguageRegistry.instance().addNameForObject(NBow, "de_DE", "Brennender Nether Bogen");
		LanguageRegistry.instance().addNameForObject(NBucketEmpty, "de_DE", "Nether Eimer");
		LanguageRegistry.instance().addNameForObject(NBucketFull, "de_DE", "Nether Schleim");
		LanguageRegistry.instance().addNameForObject(NWDoorItem, "de_DE", "Netherholztuer");
		LanguageRegistry.instance().addNameForObject(ingotPlumbum, "de_DE", "Blei-Barren");
		LanguageRegistry.instance().addNameForObject(hammerPlumbum, "de_DE", "Blei-Hammer");
		/** TODO*/   LanguageRegistry.instance().addNameForObject(pickaxeGrav, "de_DE", "Gravitations Spitzhacke");
		
		
		
	}
	
	
	

}
