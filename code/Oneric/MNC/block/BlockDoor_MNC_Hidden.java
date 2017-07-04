package Oneric.MNC.block;

import java.util.Random;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDoor_MNC_Hidden extends BlockDoor{

	public BlockDoor_MNC_Hidden(int par1, Material par2Material) {
		super(par1, par2Material);
	}
	
	
	
    public int idDropped(int par1, Random par2Random, int par3)
    {
        if ((par1 & 8) != 0)
        {
            return 0;
        }

        if (blockMaterial == Material.glass)
        {
            return MNCItems.GDoorHiddenItem.itemID;
        }
        else
        {
            return MNCItems.NDoorHiddenItem.itemID;
        }
    }
    
    
   public boolean isOpaqueCube(){return false;}
   
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
		
		
    	Icon tmp = Block.glowStone.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
    	
    	if(this.blockID == MNCBlocks.NDoorHidden.blockID)
    	{
    		tmp = Block.netherBrick.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
    	}
    	
    	
        return tmp;
        
    }
    
    
    @Override
    public Icon getIcon(int par1, int meta)
    {
    	Icon tmp = Block.glowStone.getBlockTextureFromSide(par1);
    	
    	if(this.blockID == MNCBlocks.NDoorHidden.blockID)
    	{
    		tmp = Block.netherBrick.getBlockTextureFromSide(par1);
    	}
    	
    	
        return tmp;
    }
    
    
    
    
    
    

    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        if(this.blockMaterial == Material.glass)
        {
        	return MNCItems.GDoorHiddenItem.itemID;
        }
        
        else
        {
        	return MNCItems.NDoorHiddenItem.itemID;
        }
    }
    
    
    @Override
    public void registerIcons(IconRegister iconregister)
    {
        
    }
    
    
    
    
    
}