package Oneric.MNC.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Oneric.MNC.common.MNCItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class BlockTreppen extends BlockStairs
{
	boolean diamondrequires;
	
	

	public BlockTreppen(int par1, Block par2Block, boolean j) {
		 
	
		super(par1, par2Block, par1);
		diamondrequires = j;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	public boolean renderAsNormalBlock()
		{
		 return false;
		}
	public int getRenderType()
	{
		return 10;
	}
	
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }
	

	 public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
	    {
	        if(diamondrequires == true){
	        	
	        if(entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.pickaxeDiamond.itemID || entityplayer.getCurrentEquippedItem().itemID == MNCItems.NetherPickaxe.itemID){
	            super.harvestBlock(world, entityplayer, i, j, k, l);
	        }
	        else{
	           
	        	}
	        }
	        
	        if(diamondrequires == false){
	        	super.harvestBlock(world, entityplayer, i, j, k, l);
	        	
	        }
	        
	    }
	
}
