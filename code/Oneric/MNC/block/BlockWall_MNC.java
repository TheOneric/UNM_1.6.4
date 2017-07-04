package Oneric.MNC.block;

import java.util.List;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWall_MNC extends BlockWall{
	
	boolean diamondrequires;
	
	public BlockWall_MNC(int par1, Block block, boolean i) {
		super(par1, block);
		//this.blockIndexInTexture = texture;
		this.diamondrequires = i;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	

	public int getRenderType()
    {
        return 32;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        return false;
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
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        boolean var5 = this.canConnectWallTo(par1IBlockAccess, par2, par3, par4 - 1);
        boolean var6 = this.canConnectWallTo(par1IBlockAccess, par2, par3, par4 + 1);
        boolean var7 = this.canConnectWallTo(par1IBlockAccess, par2 - 1, par3, par4);
        boolean var8 = this.canConnectWallTo(par1IBlockAccess, par2 + 1, par3, par4);
        float var9 = 0.25F;
        float var10 = 0.75F;
        float var11 = 0.25F;
        float var12 = 0.75F;
        float var13 = 1.0F;

        if (var5)
        {
            var11 = 0.0F;
        }

        if (var6)
        {
            var12 = 1.0F;
        }

        if (var7)
        {
            var9 = 0.0F;
        }

        if (var8)
        {
            var10 = 1.0F;
        }

        if (var5 && var6 && !var7 && !var8)
        {
            var13 = 0.8125F;
            var9 = 0.3125F;
            var10 = 0.6875F;
        }
        else if (!var5 && !var6 && var7 && var8)
        {
            var13 = 0.8125F;
            var11 = 0.3125F;
            var12 = 0.6875F;
        }

        this.setBlockBounds(var9, 0.0F, var11, var10, var13, var12);
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        this.maxY = 1.5D;
        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Return whether an adjacent block can connect to a wall.
     */
    public boolean canConnectWallTo(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        int var5 = par1IBlockAccess.getBlockId(par2, par3, par4);

        if (var5 != this.blockID && var5 != Block.fenceGate.blockID)
        {
            Block var6 = Block.blocksList[var5];
            return var6 != null && var6.blockMaterial.isOpaque() && var6.renderAsNormalBlock() ? var6.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
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
    
    
    
    public Icon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	 {
	
		 Icon tmp = Block.glowStone.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 
		 
		 
		 if(this.blockID == MNCBlocks.OWall.blockID)
		 {
			 tmp = Block.obsidian.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 if(this.blockID == MNCBlocks.NWall.blockID)
		 {
			 tmp = Block.netherBrick.getBlockTexture(par1IBlockAccess, par2, par3, par4, par5);
		 }
		 
		 if(this.blockID == MNCBlocks.NWWall.blockID)
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
		 
		 
		 
		 if(this.blockID == MNCBlocks.OWall.blockID)
		 {
			 tmp = Block.obsidian.getBlockTextureFromSide(par1);
		 }
		 
		 if(this.blockID == MNCBlocks.NWall.blockID)
		 {
			 tmp = Block.netherBrick.getBlockTextureFromSide(par1);
		 }
		 
		 if(this.blockID == MNCBlocks.NWWall.blockID)
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
    
    
    
    
    @SideOnly(Side.CLIENT)

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        par3List.add(new ItemStack(par1, 1, 0));
    }
    
    

}
