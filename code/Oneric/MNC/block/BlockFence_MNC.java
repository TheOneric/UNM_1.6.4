package Oneric.MNC.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockFence_MNC extends BlockFence
{
	boolean diamondrequires;
	
	
    public BlockFence_MNC(int par1, boolean j)
    {
        super(par1, "", Material.rock);
        diamondrequires = j;
        this.setCreativeTab(CreativeTabs.tabBlock);
        
    }

    public BlockFence_MNC(int par1, Material par3Material, boolean j)
    {
        super(par1, "", par3Material);
        diamondrequires = j;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    
   
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
    	return this.getBlockTextureFromSideAndMetadata(par1, par2);
    }
    
    
    
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	 {
	
		 Icon tmp = Block.glowStone.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 
		 
		 
		 if(this.blockID == MNCBlocks.OFence.blockID)
		 {
			 tmp = Block.obsidian.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 if(this.blockID == MNCBlocks.NFence_NEW.blockID)
		 {
			 tmp = Block.netherBrick.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 if(this.blockID == MNCBlocks.NWFence.blockID)
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
		 
		 
		 
		 if(this.blockID == MNCBlocks.OFence.blockID)
		 {
			 tmp = Block.obsidian.getBlockTextureFromSide(par1);
		 }
		 
		 if(this.blockID == MNCBlocks.NFence_NEW.blockID)
		 {
			 tmp = Block.netherBrick.getBlockTextureFromSide(par1);
		 }
		 
		 if(this.blockID == MNCBlocks.NWFence.blockID)
		 {
			 tmp = MNCBlocks.Netherplanks.getBlockTextureFromSide(par1);
		 }
		 
		 this.blockIcon = tmp;
		 return tmp;
    	
    }
    
    
    
    
    
    

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

   
  

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        boolean flag = canConnectFenceTo(par1IBlockAccess, par2, par3, par4 - 1);
        boolean flag1 = canConnectFenceTo(par1IBlockAccess, par2, par3, par4 + 1);
        boolean flag2 = canConnectFenceTo(par1IBlockAccess, par2 - 1, par3, par4);
        boolean flag3 = canConnectFenceTo(par1IBlockAccess, par2 + 1, par3, par4);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int i)
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 11;
    }

    /**
     * Returns true if the specified block can be connected by a fence
     */
    public boolean canConnectFenceTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int i = par1IBlockAccess.getBlockId(par2, par3, par4);

        if (i == blockID || i == Block.fenceGate.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == Block.fence.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == MNCBlocks.GFence.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == MNCBlocks.GFenceGate.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == Block.netherFence.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == MNCBlocks.NFenceGate.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == MNCBlocks.OFenceGate.blockID)
        {
            return true;
        }
        
        if (i == blockID || i == MNCBlocks.OFence.blockID)
        {
            return true;
        }
        
        if(i == MNCBlocks.NWFence.blockID){return true;}
        if(i == MNCBlocks.NWFenceGate.blockID){return true;}
        
        


        

        Block block = Block.blocksList[i];

        if (block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock())
        {
            return block.blockMaterial != Material.pumpkin;
        }
        else
        {
            return false;
        }
    }
    
    public static boolean isIdAFence(int par0)
    {
        return par0 == Block.fence.blockID || par0 == Block.netherFence.blockID;
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
