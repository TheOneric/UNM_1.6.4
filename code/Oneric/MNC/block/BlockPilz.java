package Oneric.MNC.block;

import java.util.Random;

import Oneric.MNC.common.MNCItems;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.src.*;

public class BlockPilz extends MNCBlock{

	public BlockPilz(int par1) {
		super(par1, Material.rock);
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	 @Override
	 public int idDropped(int par1, Random par2Random, int par3)
	    {
	        return MNCItems.HellPilz_Samen.itemID;
	    }

	
	
	@Override
	public int quantityDropped(Random par1Random)
	    {
	    
		Random rand = new Random();
		int i = rand.nextInt(5);
		
		
			return i;
	    }
	
	
	/*public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
	    {
	        
	        if(entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.axeDiamond.itemID || entityplayer.getCurrentEquippedItem().itemID == Item.axeGold.itemID || entityplayer.getCurrentEquippedItem().itemID == Item.axeSteel.itemID ||  entityplayer.getCurrentEquippedItem().itemID == mod_netherbr.Glowaxe.itemID || entityplayer.getCurrentEquippedItem().itemID == mod_netherbr.Netheraxe.itemID){
	            super.harvestBlock(world, entityplayer, i, j, k, l);
	        }else{
	            //world.setBlockAndMetadataWithNotify(i, j, k, blockID, l);
	        	//return Block.netherrack;
	        	
	        }
	    }*/

}
