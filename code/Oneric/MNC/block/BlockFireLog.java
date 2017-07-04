package Oneric.MNC.block;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import Oneric.MNC.common.MNCBlocks;
import Oneric.MNC.common.MNCItems;
import Oneric.MNC.common.mod_netherbr;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFireLog extends Block
{
    /** The type of tree this log came from. */
   // public static final String[] woodType = new String[] {"oak", "spruce", "birch", "jungle"};
	
	 @SideOnly(Side.CLIENT)
	 private Icon tree_top;

    public BlockFireLog(int par1)
    {
        super(par1, Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setStepSound(Block.soundWoodFootstep);
    }
    
    public String getTextureFile()
    {
            return "/img/mnc_blocks.png";
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 31;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        byte var7 = 4;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

                        if (Block.blocksList[var12] != null)
                        {
                            Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
                        }
                    }
                }
            }
        }
    }


    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public Icon getBlockTextureFromSideAndMetadata(int i, int j)
    {
		
    	if(i == 0 || i == 1)
    	{
    		return this.tree_top; //Bottom
    	}
			
		
			
    	else
		{
			return this.blockIcon;
		}
			
        
    }
    
    @Override
    public Icon getIcon(int par1, int par2)
    {
    	return this.getBlockTextureFromSideAndMetadata(par1, par2);
    }
    
    
    
    public void registerIcons(IconRegister par1IconRegister)
    {
        this.tree_top = par1IconRegister.registerIcon(mod_netherbr.getId()+":mnc_FireLogTop");
       this.blockIcon = par1IconRegister.registerIcon(mod_netherbr.getId()+":mnc_FireLogSide");
    }
    
    
    

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    public int damageDropped(int par1)
    {
        return par1 & 3;
    }

    /**
     * returns a number between 0 and 3
     */
    public static int limitToValidMetadata(int par0)
    {
        return par0 & 3;
    }

    
    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
     * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock(int par1)
    {
        return new ItemStack(this.blockID, 1, limitToValidMetadata(par1));
    }

    @Override
    public boolean canSustainLeaves(World world, int x, int y, int z)
    {
        return true;
    }
    
    public void onBlockRemoval(World world, int i, int j, int k)
    {
        byte byte0 = 4;
        int l = byte0 + 1;
        if(world.checkChunksExist(i - l, j - l, k - l, i + l, j + l, k + l))
        {
            for(int i1 = -byte0; i1 <= byte0; i1++)
            {
                for(int j1 = -byte0; j1 <= byte0; j1++)
                {
                    for(int k1 = -byte0; k1 <= byte0; k1++)
                    {
                        int l1 = world.getBlockId(i + i1, j + j1, k + k1);
                        if(l1 != MNCBlocks.FireLeaf.blockID)  ///Leaf//////////////
                        {
                            continue;
                        }
                        int i2 = world.getBlockMetadata(i + i1, j + j1, k + k1);
                        if((i2 & 8) == 0)
                        {
                            world.setBlockMetadataWithNotify(i + i1, j + j1, k + k1, i2 | 8, 2);
                        }
                    }

                }

            }

        }
       }
    
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int par5)
    {
    	
    }
    
    public void harvestBlock(World world, EntityPlayer player, int x, int y, int z, int meta)
    {
    	Random rand = new Random();
    	if(player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem() == new ItemStack(MNCItems.NetherAxe))
    	{
    		 
             
             if(rand.nextInt(100) == 0)
             {
            	 dropBlockAsItem_do(world, x, y, z, new ItemStack(MNCItems.FireGem.itemID, 1, 0));
             }
             else
             {
            	 switch(world.rand.nextInt(20))
               	 {
               	 case 0:
               		dropBlockAsItem_do(world, x, y, z, new ItemStack(Item.magmaCream.itemID, 1, 0));
               		 break;
               		 
               	 case 1:
               		dropBlockAsItem_do(world, x, y, z, new ItemStack(Item.blazePowder.itemID, 1, 0));
               		 break;
               	 }
            	 
            	
             }
             
            
            
    	}
    	super.harvestBlock(world, player, x, y, z, meta);
    	
    }
    
    public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1)
    {
        super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
        
    }

   
}
