package Oneric.MNC.block;

import java.util.Random;

import Oneric.MNC.common.MNCItems;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;



public class BlockNetherGold extends MNCBlock{

	public BlockNetherGold(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	public static boolean isNormalCube()
	{
		return true;
	}
	
	 public int idDropped(int par1, Random par2Random, int par3 )
	    {
		  return Item.goldNugget.itemID;
	    }
	 
	 public int quantityDropped(Random par1Random)
	    {
	    	 return 5 + par1Random.nextInt(8);
	    }
	 
	 public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
	    {
	        if (!par1World.isRemote)
	        {
	            EntityXPOrb var6 = new EntityXPOrb(par1World);
	            var6.setLocationAndAngles((double)par2 + 0.5D, (double)par3, (double)par4 + 0.5D, 0.0F, 0.0F);
	            par1World.spawnEntityInWorld(var6);
	            
	        }
	        
	        

	        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
	    }
	 
	 public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer)
	 {
		 par6EntityPlayer.addExperience(2);
	 }

	 
	 
	 
	 
	 public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
	    {
	        
	        if(entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.pickaxeDiamond.itemID || entityplayer.getCurrentEquippedItem().itemID == Item.pickaxeGold.itemID || entityplayer.getCurrentEquippedItem().itemID == Item.pickaxeIron.itemID ||  entityplayer.getCurrentEquippedItem().itemID == MNCItems.GlowPickaxe.itemID || entityplayer.getCurrentEquippedItem().itemID == MNCItems.NetherPickaxe.itemID){
	            super.harvestBlock(world, entityplayer, i, j, k, l);
	        }else{
	           
	        	
	        }
	    }

}
