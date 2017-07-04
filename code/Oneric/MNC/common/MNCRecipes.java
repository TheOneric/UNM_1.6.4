package Oneric.MNC.common;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MNCRecipes {
	
	public MNCRecipes()
	{
		
		
		/**
		 * 
		 * Smelting
		 * 
		 * */
		
		
		//Netherrack
		
		//GameRegistry.addSmelting(Block.netherrack.blockID, new ItemStack(MNCItems.netherignot), 0.5F);
		
		//GoldOre2Goldignot
		GameRegistry.addSmelting(MNCBlocks.NetherGold.blockID, new ItemStack(Item.ingotGold, 2), 1.0F);
		
		//Hiddendoors
		//Glowdoor_Hidden
		GameRegistry.addSmelting(MNCItems.GDoorItem.itemID,new ItemStack(MNCItems.GDoorHiddenItem), 0.0F);
		//Brickdoorhidden
		GameRegistry.addSmelting(MNCItems.NDoorItem.itemID,new ItemStack(MNCItems.NDoorHiddenItem), 0.0F);
		
		//Plumbum
		GameRegistry.addSmelting(MNCBlocks.orePlumbum.blockID, new ItemStack(MNCItems.ingotPlumbum), 0.1F);
		
		
		
		
		
		
		
		
		
		
		/**
		 * 
		 * Crafting
		 * 
		 * */
		
		/******************************************************1.5-UPDATE*************************************************************/
		
		//New Epic Ignot Recipe
		GameRegistry.addRecipe(new ItemStack(MNCItems.netheringot, 6), new Object[]{
			
			"NII",
			"IDI",
			"IIO",
			
			Character.valueOf('I'), Item.netherrackBrick,
			Character.valueOf('D'), Block.obsidian,
			Character.valueOf('O'), Item.blazePowder,
			Character.valueOf('N'), Item.netherStalkSeeds
			
			
			
		});
		
		
		
		
		
		
		
		/******************************************************1.4.7-UPDATE*************************************************************/
		
		
		//PlumbumHammer
		GameRegistry.addRecipe(new ItemStack(MNCItems.hammerPlumbum, 1), new Object[]{
			
			"PPP",
			"PIP",
			"#I#",
			
			Character.valueOf('P'), MNCItems.ingotPlumbum,
			Character.valueOf('I'), MNCItems.Netherstick,
			});	
		
		
		//Walls
		//G
		GameRegistry.addShapelessRecipe(new ItemStack(MNCBlocks.GWall, 1), new Object[]{MNCBlocks.GFence});
		
		//N
		GameRegistry.addShapelessRecipe(new ItemStack(MNCBlocks.NWall, 1), new Object[]{MNCBlocks.NFence_NEW});
		
		//O
		GameRegistry.addShapelessRecipe(new ItemStack(MNCBlocks.OWall, 1), new Object[]{MNCBlocks.OFence});
		
		//NW
		GameRegistry.addShapelessRecipe(new ItemStack(MNCBlocks.NWWall, 1), new Object[]{MNCBlocks.NWFence});
		
		
		//NWDoor
		GameRegistry.addRecipe(new ItemStack(MNCItems.NWDoorItem, 6), new Object[]{
			 "XX", "XX", "XX", Character.valueOf('X'), MNCBlocks.Netherplanks
			
		});
		
		
		
		
		//NWFence and Gate
		//Zaun
		GameRegistry.addRecipe(new ItemStack(MNCBlocks.NWFence, 6), new Object[]{
			 "XXX", "XXX", Character.valueOf('X'), MNCItems.Netherstick
			
		});
		//gate
		GameRegistry.addRecipe(new ItemStack(MNCBlocks.NWFenceGate, 2), new Object[]{
			  "XAX", "XAX", Character.valueOf('X'), MNCItems.Netherstick,  Character.valueOf('A'), MNCBlocks.Netherplanks
			
		});
		
		
		
		
		//Netherwood
		GameRegistry.addShapelessRecipe(new ItemStack(MNCBlocks.Netherplanks, 1), new Object[]{
			
			MNCBlocks.FireLog
			
			
		});
		
		
		
		
	/******************************************************1.4.5-UPDATE & older*************************************************************/
		
		
		//Fire Gem
		GameRegistry.addRecipe(new ItemStack(MNCItems.FireGem, 1), new Object[]{
			
			"TMB",
			"MDM",
			"SMT",
			
			Character.valueOf('S'), MNCItems.strange,  
			Character.valueOf('T'), Item.ghastTear,  
			Character.valueOf('D'), Item.diamond,
			Character.valueOf('M'), Item.magmaCream,
			Character.valueOf('B'), Item.bucketLava,
			});	
	
		
		
		
		
	//Arrow
		GameRegistry.addRecipe(new ItemStack(MNCItems.NArrow, 12), new Object[]{
			
			"F##",
			"#S#",
			"##T",
			
			Character.valueOf('S'), MNCItems.Netherstick,  
			Character.valueOf('T'), Item.ghastTear,  
			 Character.valueOf('F'), MNCItems.FireGem
			});	
		
		
	//Bow
		GameRegistry.addRecipe(new ItemStack(MNCItems.NBow, 1), new Object[]{
			
			"TI#",
			"TXF",
			"TI#",
			
			Character.valueOf('X'), MNCItems.strange,  
			Character.valueOf('T'), Item.ghastTear,  
			Character.valueOf('I'), MNCItems.epicingot,
			 Character.valueOf('F'), MNCItems.FireGem
			});	
		
		
		
	//Ignot2EpicNetherBlock	
		GameRegistry.addRecipe(new ItemStack(MNCBlocks.NetherBlock, 1), new Object[]{
			
			"XXX", "XXX", "XXX", Character.valueOf('X'), MNCItems.netheringot
			});	
		
	//NetherBlock2Ignot
		GameRegistry.addRecipe(new ItemStack(MNCItems.netheringot, 9), new Object[]{
			
			"X", Character.valueOf('X'), MNCBlocks.NetherBlock
			});	
		
	//Pentagram
		GameRegistry.addRecipe(new ItemStack(MNCBlocks.HellAltar, 1), new Object[]{
			
			 "#T#", "BAB", "XXX", Character.valueOf('X'), MNCBlocks.NetherBlock, Character.valueOf('A'), MNCItems.strange, Character.valueOf('B'), Item.magmaCream, Character.valueOf('T'), Item.ghastTear
			});
		
		
		
		
		
		
	//GGold_I
		GameRegistry.addRecipe(new ItemStack(MNCItems.GGold_i, 1), new Object[]{
			
			"XXX", "BAB", "XXX", Character.valueOf('X'), Block.blockGold, Character.valueOf('A'), MNCItems.strange, Character.valueOf('B'), Item.ingotGold
			});
		
		
	//GGlowstone_I
		GameRegistry.addRecipe(new ItemStack(MNCItems.GGlowstone_i, 1), new Object[]{
			
			"XXX", "BAB", "XXX", Character.valueOf('X'), Block.glowStone, Character.valueOf('A'), MNCItems.strange, Character.valueOf('B'), MNCBlocks.GSlab
			});
	
		
		
		
	
		
	
		

	//Tueren
	
	//Brickdoor
	GameRegistry.addRecipe(new ItemStack(MNCItems.NDoorItem, 1), new Object[]{
		
		"XX", "XX", "XX", Character.valueOf('X'), Block.netherBrick
		});
	
	//Glowstonedoor
	GameRegistry.addRecipe(new ItemStack(MNCItems.GDoorItem, 1), new Object[]{
		
		"XX", "XX", "XX", Character.valueOf('X'), Block.glowStone
		});
	
	
	
	//Falltueren
		//Glowstone trapdoor
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.GTrapDoor, 2), new Object[]{
		 "XX", "XX", Character.valueOf('X'), Block.glowStone
		
	});
	
	//bricktrapdoor
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.NTrapDoor, 2), new Object[]{
		 "XX", "XX", Character.valueOf('X'), Block.netherBrick
		
	});
	
	
	
	
	
	
	
	
	
	
	//Treppen
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.GStair, 4), new Object[]{
		"X##", "XX#", "XXX", Character.valueOf('X'), Block.glowStone
		
	});
	
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.OStair, 4), new Object[]{
		"X##", "XX#", "XXX", Character.valueOf('X'), Block.obsidian
		
	});
	
	
	
	
	
	
	//Zaeune
	//Glowstonefence
	//Zaun
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.GFence, 6), new Object[]{
		 "XXX", "XXX", Character.valueOf('X'), Block.glowStone
		
	});
	//gate
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.GFenceGate, 2), new Object[]{
		  "XAX", "XAX", Character.valueOf('X'), Item.glowstone,  Character.valueOf('A'), Block.glowStone
		
	});
	
	//Netherbrick
	//Gate
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.NFenceGate, 2), new Object[]{
		 "AXA", "AXA", Character.valueOf('X'), Block.netherBrick, Character.valueOf('A'), Item.netherrackBrick
		
	});
	
	//Obsidian
	//Zaun
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.OFence, 6), new Object[]{
		 "XXX", "XXX", Character.valueOf('X'), Block.obsidian
		
	});
	//gate
	GameRegistry.addRecipe(new ItemStack(MNCBlocks.OFenceGate, 2), new Object[]{
		  "XAX", "XAX", Character.valueOf('X'), MNCItems.Netherstick,  Character.valueOf('A'), Block.obsidian
		
	});
	
	
	
	
	
	
	
	//NetherStick
	GameRegistry.addRecipe(new ItemStack(MNCItems.Netherstick, 3), new Object[]{
		
		"X", "X", "X", Character.valueOf('X'), MNCItems.HellPilz
		
		
	});
	
	GameRegistry.addRecipe(new ItemStack(MNCItems.Netherstick, 2), new Object[]{
		
		"X", "X", Character.valueOf('X'), MNCBlocks.Netherplanks
		
		
	});
	
	
	
	
	
	//Samen
	GameRegistry.addRecipe(new ItemStack(MNCItems.HellPilz_Samen, 2), new Object[]{
		
		"X", Character.valueOf('X'), MNCItems.HellPilz
		
		
	});
	
	
	
	
	
	//Werkzeuge
	
	//Nether
		//Pickaxe
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherPickaxe, 1), new Object[]{
			
			"EEE","#S#","#S#", 
			Character.valueOf('E'), MNCItems.epicingot,
			Character.valueOf('S'), MNCItems.Netherstick
			
		});
		
		//Axe
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherAxe, 1), new Object[]{
			
			"#EE","#SE","#S#", 
			Character.valueOf('E'), MNCItems.epicingot,
			Character.valueOf('S'), MNCItems.Netherstick
			
		});
		
		
		
		
		//Schaufel
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherShoevel, 1), new Object[]{
			
			"#E#","#S#","#S#", 
			Character.valueOf('E'), MNCItems.epicingot,
			Character.valueOf('S'), MNCItems.Netherstick
			
		});
		
		
		//Hoe
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherHoe, 1), new Object[]{
			
			"EE#","#S#","#S#", 
			Character.valueOf('E'), MNCItems.epicingot,
			Character.valueOf('S'), MNCItems.Netherstick
			
		});
		
		
		
		//Schwert
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherSword, 1), new Object[]{
			
			"#E#","#E#","#S#", 
			Character.valueOf('E'), MNCItems.epicingot,
			Character.valueOf('S'), MNCItems.Netherstick
			
		});
		
		
		
		
		
		
		
		
//Glowstone
		//Pickaxe
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowPickaxe, 1), new Object[]{
			
			"EEE","#S#","#S#", 
			Character.valueOf('E'), Block.glowStone,
			Character.valueOf('S'), Item.stick
			
		});
		
		//Axe
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowAxe, 1), new Object[]{
			
			"#EE","#SE","#S#", 
			Character.valueOf('E'), Block.glowStone,
			Character.valueOf('S'),Item.stick
			
		});
		
		
		
		
		//Schaufel
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowShoevel, 1), new Object[]{
			
			"#E#","#S#","#S#", 
			Character.valueOf('E'), Block.glowStone,
			Character.valueOf('S'), Item.stick
			
		});
		
		
		//Hoe
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowHoe, 1), new Object[]{
			
			"EE#","#S#","#S#", 
			Character.valueOf('E'), Block.glowStone,
			Character.valueOf('S'), Item.stick
			
		});
		
		
		
		//Schwert
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowSword, 1), new Object[]{
			
			"E","E","S", 
			Character.valueOf('E'), Block.glowStone,
			Character.valueOf('S'), Item.blazeRod
			
		});
		
		
		
		
		
		
		
		
		
	//Ruestung
		
	//Nether
		//Plate
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherPlate, 1), new Object[]{
			
			"X#X", "XXX", "XXX", Character.valueOf('X'), MNCItems.epicingot
		});
		
		
		
		//Helm
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherHelmet, 1), new Object[]{
			
			"XXX", "X#X", Character.valueOf('X'), MNCItems.epicingot
		});
		
	
		
		
		//Hose
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherLeg, 1), new Object[]{
			
			"XXX", "X#X", "X#X",  Character.valueOf('X'), MNCItems.epicingot
		});
		
		//Shuhe
		GameRegistry.addRecipe(new ItemStack(MNCItems.NetherBoots, 1), new Object[]{
			
			"X#X", "X#X", Character.valueOf('X'), MNCItems.epicingot
		});
		
		
	//Glowstone
		//Plate
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowPlate, 1), new Object[]{
			
			"X#X", "XXX", "XXX", Character.valueOf('X'), Block.glowStone
		});
		
		
		
		//Helm
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowHelmet, 1), new Object[]{
			
			"XXX", "X#X", Character.valueOf('X'), Block.glowStone
		});
		
	
		
		
		//Hose
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowLeg, 1), new Object[]{
			
			"XXX", "X#X", "X#X",  Character.valueOf('X'), Block.glowStone
		});
		
		//Shuhe
		GameRegistry.addRecipe(new ItemStack(MNCItems.GlowBoots, 1), new Object[]{
			
			"X#X", "X#X", Character.valueOf('X'), Block.glowStone
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	//Brick2Ignot
		GameRegistry.addRecipe(new ItemStack(Item.netherrackBrick , 4), new Object[]{
			

			"#",  Character.valueOf('#'), Block.netherBrick  
			
			});
		
		/*   REMOVED -- NOW A VANILLA FEATURE 
		//Ignot2Brick
		GameRegistry.addRecipe(new ItemStack(Block.netherBrick , 1), new Object[]{
		

			"###","###","###",  Character.valueOf('#'), MNCItems.netherignot  
			
			});
			*/
	
	
	/* REMOVED - NEW RECIPE
	//Epic_Ignot
	
		GameRegistry.addRecipe(new ItemStack(MNCItems.epicignot , 1), new Object[]{

		"A","B",  Character.valueOf('A'), MNCItems.netherignot  ,Character.valueOf('B'), Item.netherStalkSeeds  
		
		});
		*/






//Netherslab
GameRegistry.addRecipe(new ItemStack(MNCBlocks.GSlab , 6), new Object[]{

	"###",  Character.valueOf('#'), Block.glowStone  
	
	});


//Slab2Brick
GameRegistry.addRecipe(new ItemStack(Block.glowStone, 1), new Object[]{
	"X", "X", Character.valueOf('X'), MNCBlocks.GSlab
	});







//Glowstone2Glowstonedust
GameRegistry.addRecipe(new ItemStack(Item.glowstone, 4), new Object[]{
	"X", Character.valueOf('X'), Block.glowStone
	
});
		
		
	}

}
