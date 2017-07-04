package Oneric.MNC.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSlab extends Block{

	private static boolean diamondrequires;
		
	private Icon NWIcon;
		
	public BlockSlab(int par1, boolean j) {
		super(par1,  Material.rock);
		
		this.setBlockBounds(0, 0, 0, 1, 0.5F, 1);
		
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(1.0F);
		
		diamondrequires = j;
	}

	
	
	 public boolean renderAsNormalBlock()
	    {
	        return false;
	    }
	    
	    public boolean isOpaqueCube()
	    {
	        return false;
	    }
	    
	    public int idDropped(int meta, Random random, int fortune)
	    {
	        return this.blockID;
	    }
	    
	    public int damageDropped(int i)
	    {
	        return i;
	    }
	    
	    
	    
	    
	   
	    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	    {
	    	
	    	int id = world.getBlockId(x, y, z);
	    	
	    	if(id == player.inventory.getCurrentItem().itemID && id == this.blockID)
	    	{
	    		
	    		if(id == MNCBlocks.GSlab.blockID){world.setBlock(x, y, z, Block.glowStone.blockID, 0, 2);}
	    		//if(id == MNCBlocks.NSlab.blockID){world.setBlock(x, y, z, Block.netherBrick.blockID);}
	    		if(id == MNCBlocks.OSlab.blockID){world.setBlock(x, y, z, Block.obsidian.blockID, 0, 2);}
	    		if(id == MNCBlocks.NWSlab.blockID){world.setBlock(x, y, z, MNCBlocks.Netherplanks.blockID, 0, 2);}
	    		
	    		world.playSound((double)x, (double)y, (double)z, this.stepSound.getPlaceSound(), 1F, 1F, true);
	    		
	    		if(!player.capabilities.isCreativeMode)
	    		{
	    			player.inventory.getCurrentItem().stackSize--;
	    		}
	    		
	    		
	    		return true;
	    	}
	    	
	    	else
	    	{
	    		return false;
	    	}
	    	
	        
	    }
	    
	    
	    @SideOnly(Side.CLIENT)
	    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
		 {
		
			 Icon tmp = Block.glowStone.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
			 
			 
			 
			 if(this.blockID == MNCBlocks.OSlab.blockID)
			 {
				 tmp = Block.obsidian.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
			 }
			 
			 if(this.blockID == MNCBlocks.NWSlab.blockID)
			 {
				 tmp = MNCBlocks.Netherplanks.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
			 }
			 
			 this.blockIcon = tmp;
			 return tmp;
			 
		 }
	    
	    @SideOnly(Side.CLIENT)
	    /**
	     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	     */
	    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
	    {
	    	
	    	Icon tmp = Block.glowStone.getBlockTextureFromSide(par1);
			 
			 
			 
			 if(this.blockID == MNCBlocks.OSlab.blockID)
			 {
				 tmp = Block.obsidian.getBlockTextureFromSide(par1);
			 }
			 
			 if(this.blockID == MNCBlocks.NWSlab.blockID)
			 {
				 tmp = MNCBlocks.Netherplanks.getBlockTextureFromSide(par1);
			 }
			 
			 this.blockIcon = tmp;
			 return tmp;
	    	
	    }
	    
	    @Override
	    public Icon getIcon(int par1, int par2)
	    {
	    	return this.getBlockTextureFromSideAndMetadata(par1, par2);
	    }
	    
	    
	    @Override
	    public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l)
	    {
	        if(diamondrequires == true){
	        	
	        if(entityplayer.getCurrentEquippedItem() != null && entityplayer.getCurrentEquippedItem().itemID == Item.pickaxeDiamond.itemID || entityplayer.getCurrentEquippedItem().itemID == MNCItems.NetherPickaxe.itemID){
	            super.harvestBlock(world, entityplayer, i, j, k, l);
	        }
	        }
	        
	        else{
	        	super.harvestBlock(world, entityplayer, i, j, k, l);
	        	
	        }
	        
	    }
	    
	    @Override
	    public void registerIcons(IconRegister iconregister)
	    {
	        
	    }
	    
	

}
