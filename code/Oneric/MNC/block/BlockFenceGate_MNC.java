package Oneric.MNC.block;

import java.util.Random;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFenceGate_MNC extends BlockFenceGate
{
	
	boolean diamondrequires;
	
   
    public BlockFenceGate_MNC(int par1, boolean j)
    {
        super(par1);
        diamondrequires = j;
        this.setCreativeTab(CreativeTabs.tabBlock);
        
        
    }
    
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
    	return this.getBlockTextureFromSideAndMetadata(par1, par2);
    }
    
    
    
    @Override
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	 {
	
		 Icon tmp = Block.glowStone.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 
		 
		 
		 if(this.blockID == MNCBlocks.OFenceGate.blockID)
		 {
			 tmp = Block.obsidian.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 if(this.blockID == MNCBlocks.NFenceGate.blockID)
		 {
			 tmp = Block.netherBrick.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 if(this.blockID == MNCBlocks.NWFenceGate.blockID)
		 {
			 tmp = MNCBlocks.Netherplanks.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 this.blockIcon = tmp;
		 return tmp;
		 
	 }
    
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @SideOnly(Side.CLIENT)
    public Icon getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
    	
    	Icon tmp = Block.glowStone.getBlockTextureFromSide(par1);
		 
		 
		 
		 if(this.blockID == MNCBlocks.OFenceGate.blockID)
		 {
			 tmp = Block.obsidian.getBlockTextureFromSide(par1);
		 }
		 
		 if(this.blockID == MNCBlocks.NFenceGate.blockID)
		 {
			 tmp = Block.netherBrick.getBlockTextureFromSide(par1);
		 }
		 
		 if(this.blockID == MNCBlocks.NWFenceGate.blockID)
		 {
			 tmp = MNCBlocks.Netherplanks.getBlockTextureFromSide(par1);
		 }
		 
		 this.blockIcon = tmp;
		 return tmp;
    	
    }
    
    
    
    @Override
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